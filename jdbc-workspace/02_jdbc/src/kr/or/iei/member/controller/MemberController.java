package kr.or.iei.member.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.iei.member.dao.MemberDao;
import kr.or.iei.member.view.MemberView;
import kr.or.iei.member.vo.Member;

public class MemberController {

	MemberView view;
	MemberDao dao;
	String searchInfo;

	public MemberController() {
		view = new MemberView();
		dao = new MemberDao();

	}

	public void main() {

		try {

			while (true) {
				int sel = view.main();

				switch (sel) {
				case 1:
					printMember(true, false);
					break;
				case 2:
					printMember(false, true);
					break;
				case 3:
					printMember(false, false);
					break;
				case 4:
					register();
					break;
				case 5:
					editMember();
					break;
				case 6:
					deleteMember();
					break;
				case 0:
					return;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private boolean isMemberInDB(String purpose) throws SQLException {
		searchInfo = null;
		String id = view.getId(purpose);
		searchInfo = id;
		boolean isMemberInDB = dao.isMemberInDB(id);
		if (!isMemberInDB) {
			if (purpose.equals("등록"))
				return false;
			view.noMemberMsg();
			view.failMsg();
			return false;
		}

		return true;
	}

	private void deleteMember() throws SQLException {
		view.deleteMember();
		if (isMemberInDB("삭제")) {
			if (dao.deleteMember(searchInfo) > 0)
				view.successMsg();
			else
				view.failMsg();
		}

	}

	private void editMember() throws SQLException {
		view.eidtMember();
		if (isMemberInDB("수정")) {
			String name = searchInfo;
			String[] list = view.addMemberInDB(5, name);
			if (dao.insertMember(list) > -1)
				view.successMsg();
			else
				view.failMsg();

		}
	}

	private void register() throws SQLException {
		view.register();
		if (!isMemberInDB("등록")) {
			String name = searchInfo;
			String[] list = view.addMemberInDB(6, name);
			if (dao.insertMember(list) > -1) {
				view.successMsg();
				return;
			}
			view.failMsg();
			return;
		}
		view.alreadyMemberInDBMsg();
		view.failMsg();

	}

	private void printMember(boolean printAllMember, boolean searchById) throws SQLException {
		view.printMember(printAllMember, searchById);
		String searchInfo = "";

		if (!printAllMember)
			searchInfo = searchById ? view.getId("출력") : view.getName("출력");

		ArrayList<Member> list = dao.selectMember(printAllMember, searchById, searchInfo);

		if (list.size() == 0) {
			view.failMsg();
			return;
		}

		view.printMember(list);
		view.successMsg();

	}

}
