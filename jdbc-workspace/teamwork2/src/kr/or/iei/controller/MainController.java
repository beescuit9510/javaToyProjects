package kr.or.iei.controller;

import java.util.ArrayList;

import kr.or.iei.service.RoomService;
import kr.or.iei.view.View;
import kr.or.iei.vo.Member;

public class MainController {

	View view = new View();
	RoomService service = new RoomService();
	Member loginMember =null;
			
			
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

	private void loginMenu() {
		String lv = loginMember.getMember_lev();
		if (lv.equals("직원")) {
			StaffController sc = new StaffController();
			sc.main();
			loginMember = null;
		}else {
			CustomerController cc = new CustomerController();
			cc.main(loginMember.getMember_no(), loginMember.getMember_name());
			loginMember = null;
		}
		
	}

	private void register() {
		ArrayList<String> list =  view.getRegisterList();
		int result  = service.register(list);
		if(result>0) {
			view.printMsg("회원가입 완료");
		}else {
			view.printMsg("회원가입 실패");
		}
	}

	private void login() {
		ArrayList<String> idPw = view.login();
		loginMember = service.login(idPw);
		if (loginMember !=null) {
			view.printMsg("로그인 성공");
			loginMenu();
		}else {
			view.printMsg("로그인 실패");
		}

	}

}
