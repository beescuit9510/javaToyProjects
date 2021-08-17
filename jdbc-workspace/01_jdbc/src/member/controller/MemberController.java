package member.controller;

import java.util.ArrayList;

import member.dao.MemberDao;
import member.view.MemberView;
import member.vo.Member;

public class MemberController {

	private MemberView view;
	private MemberDao dao;

	public MemberController() {
		super();
		view = new MemberView();
		dao = new MemberDao();
	}

	public void main() {
		while (true) {
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
			case 0:
				return;
			default:
				break;

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
		

		
		if (searchById== true) {
			memberIdOrName = view.getId("조회");
			list = dao.selectOneMember(memberIdOrName, true);
		} else {
			memberIdOrName = view.getName("조회");
			list = dao.selectOneMember(memberIdOrName, false);
		}
		
		if (list == null) {
			view.emptyMember();
			return;
		} else if(list.size()==1) {
			Member m = list.get(0);
			view.selectOneMember(m);
		}else {
			view.selectOneMember(list);
		}

	}

	private void insertMember() {
		
		int r = dao.insertMember(view.insertMember());
		
		
		if(r>0) {
			view.successMsg();
			
		}
		else {
			view.failMsg();
			
		}
		
	
		
	}
	
	private void editMember() {
		String name = view.editMember();
		boolean r = dao.memberInDB(name);
		
		if(r) {
			String[] list = view.editMember(r);
			if(list==null)
				return;
			
			boolean delete = dao.editMember(name, list);
			if(delete) {
				view.successMsg();
			}else {
				view.failMsg();
			}
			
		}else {		
			view.emptyMember();
			view.failMsg();
		}
	
		
	}
	
	private void deleteMember() {
		String name = view.deleteMember();
		boolean r = dao.deleteMember(name);
		
		if(r) {
			view.successMsg();
		}else {
			view.failMsg();
		}

	}

}
