package kr.or.iei.member.controller;

import java.util.ArrayList;

import kr.or.iei.member.model.service.MemberService;
import kr.or.iei.member.model.view.MemberView;
import kr.or.iei.member.model.vo.Member;

public class MemberController {
	private MemberView view;
	private MemberService service;
	private boolean login;
	String logginedId;

	public MemberController() {
		super();
		view = new MemberView();
		service = new MemberService();

	}

	public void main() {
		while (true) {
			int sel = view.main();
			switch (sel) {
			case 1:
				selectAllMember();
				break;
			case 2:
				selectOneMember(true);
				break;
			case 3:
				selectOneMember(false);
				break;
			case 4:
				register(false);
				break;
			case 5:
				register(true);
				break;
			case 6:
				delete();
				break;
			case 7:
				login();
				break;
			case 0:
				return;
			}
			while (login) {
				sel = view.loginMain(logginedId);
				switch (sel) {
				case 1:
					selectOneMember(true);
					break;
				case 2:
					register(true);
					break;
				case 3:
					delete();
				case 4:
					login = !login;
					logginedId = null;
					break;

				}
			}
		}
	}

	private void login() {
		String id = view.getId();
		String pw = view.getPw();
		login = service.isMemberInDB(id, pw);
		if (login)
			logginedId = id;
		
		view.resultMsg(login);
	}

	public void selectAllMember() {
		ArrayList<Member> list = service.selectMember(true, "%%");
		view.printMember(list);

	}

	public void selectOneMember(boolean searchById) {
		String seachInfo = !searchById ? view.getName() : login ? logginedId : view.getId();
		ArrayList<Member> list = service.selectMember(searchById, seachInfo);
		view.printMember(list);
		view.noSuchMember(list.size()>0);

	}

	public void register(boolean edit) {
		String id = login ? logginedId : view.getId();
		boolean isMemberinDB = service.isMemberInDB(id);
		int r = -1;

		if (!edit && !isMemberinDB || edit && isMemberinDB) {
			String[] list = view.getList(edit, id);
			r = list == null ? r : service.insertMember(edit, list);
		}
		if (!edit)
			view.alreadyMemberExist(isMemberinDB);
		else
			view.noSuchMember(isMemberinDB);
		view.resultMsg(r > 0);
	}

	public void delete() {
		String id = login ? logginedId : view.getId();
		boolean isMemberinDB = service.isMemberInDB(id);
		view.noSuchMember(isMemberinDB);
		int r = -1;

		if (isMemberinDB) {
			r = service.deleteMember(id);
		}
		view.resultMsg(r > 0);
	}

}
