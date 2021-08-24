package kr.or.iei.book.controller;

import kr.or.iei.book.service.LibraryService;
import kr.or.iei.book.view.LibraryView;
import kr.or.iei.book.vo.Member;

public class LibraryController {
	LibraryView view = new LibraryView();
	LibraryService service = new LibraryService();
	String userId;
	String userPw;
	int userNo;
	int userGrade;

	public void main() {
		while (true) {
			int sel = view.main();
			switch (sel) {

			case 1:
				login();
				break;
			case 2:
				register();
				break;
			case 0:
				return;
			}
		}
	}

	private void register() {
		String[] list = view.register();
		int r = service.insert(list, 'M');
		view.resultMsg(r > 0);

	}

	private void login(boolean loggedIn, Member m) {
		if (loggedIn) {
			userId = m.getId();
			userNo = m.getMember_no();
			userPw = m.getPw();
			userGrade = m.getGrade();

			if (userGrade == 1) {
				CustomerController cc = new CustomerController(userId,userPw, userNo);
				cc.main();
			} else if (userGrade == 2) {
				StaffController sc = new StaffController();
				sc.main();
			}

		}

	}

	private void login() {
		String[] idPw = view.login();
		Member member = service.login(idPw);
		boolean r = member != null;
		view.resultMsg(r);
		login(r, member);

	}

}
