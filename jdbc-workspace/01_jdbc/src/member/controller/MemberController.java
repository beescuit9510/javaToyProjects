package member.controller;

import java.util.ArrayList;

import member.dao.MemberDao;
import member.view.MemberView;
import member.vo.Member;

public class MemberController {

	private MemberView view;
	private MemberDao dao;
	private Member loginMember;

	public MemberController() {
		super();
		view = new MemberView();
		dao = new MemberDao();
	}

	public void main() {
		while (true) {
			if (loginMember == null) {
				int sel = view.showMain();
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
					insertMember();
					break;
				case 5:
					editMember();
					break;
				case 6:
					deleteMember();
					break;
				case 7:
					login();
					break;
				case 0:
					return;
				default:
					break;
				}
			} else {
				int sel = view.loginMenu(loginMember.getMemberName());
				switch (sel) {
				case 1:
					selectOneMember(false);
					break;
				case 3:
					deleteMember();
				case 2:
					loginMember = null;
					break;
				case 4:
					editMember();
					break;

				}

			}
		}
	}

	private void selectAllMember() {
		ArrayList<Member> list = dao.selectAllMember();

		if (list.isEmpty()) {
			view.emptyMember();
		} else {
			view.selectAllMember(list);
		}

	}

	private void selectOneMember(boolean searchById) {

		String memberIdOrName = null;
		ArrayList<Member> list = null;

		if (loginMember != null) {
			String id = loginMember.getMemberId();
			list = dao.selectOneMember(id, true);
		} else if (searchById == true) {
			memberIdOrName = view.getId("조회");
			list = dao.selectOneMember(memberIdOrName, true);
		} else {
			memberIdOrName = view.getName("조회");
			list = dao.selectOneMember(memberIdOrName, false);
		}

		if (list == null) {
			view.emptyMember();
		} else if (list.size() == 1) {
			Member m = list.get(0);
			view.selectOneMember(m);
		} else {
			view.selectOneMember(list);
		}

	}

	private void insertMember() {
		String[] list = view.insertMember();
		boolean isMemberInDB = true;

		if (list != null)
			isMemberInDB = dao.memberInDB(list[0]);

		if (isMemberInDB) {
			view.memberAlreadyExist();
			view.failMsg();
			return;
		}

		int r = dao.insertMember(list);

		if (r > 0) {
			view.successMsg();

		} else {
			view.failMsg();

		}

	}

	private void editMember() {
		boolean isMemberInDB = false;
		String id = null;

		if (loginMember == null) {
			id = view.editMember();
			isMemberInDB = dao.memberInDB(id);
		} else {
			id = loginMember.getMemberId();
			isMemberInDB = true;
		}

		String[] list = view.editMember(isMemberInDB);

		if (list == null) {
			return;
		}

		int r = dao.editMember(id, list);

		if (r > 0) {
			view.successMsg();
			return;
		}

		view.failMsg();

	}

	private void deleteMember() {
		String name = loginMember.getMemberName();

		if (name == null) {
			name = view.deleteMember();
		}

		int r = dao.deleteMember(name);

		if (r > 0) {
			view.successMsg();
			return;
		}

		view.failMsg();

	}

	private void login() {
		Member m = view.login();
		loginMember = dao.login(m);

		if (loginMember == null) {
			view.failMsg();
			return;
		}

		view.successMsg();
	}

}
