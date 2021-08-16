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
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
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
		
		if(list.isEmpty()) {
			view.emptyMember();
		}else {
			view.selectAllMember(list);
		}

	}

	private void slectOneMember() {

	}

	private void insertOneMember() {

	}

}
