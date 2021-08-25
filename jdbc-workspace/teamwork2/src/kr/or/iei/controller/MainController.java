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
			if(loginMember == null) {
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
			}else {
				loginMenu();
			}
			
		}

	}

	private void loginMenu() {
		String lv = loginMember.getMember_lev();
		if (lv == "직원") {
			view.staffMain();
		}else {
			view.customerMain(loginMember.getMember_name());
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
		}else {
			view.printMsg("로그인 실패");
		}

	}

}
