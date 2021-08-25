package kr.or.iei.controller;

import kr.or.iei.service.RoomService;
import kr.or.iei.view.View;

public class MainController {

	View view = new View();
	RoomService service = new RoomService();
	
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
		
	}

	private void login() {
		view.printRent(service.selectAllReserver());
	}

}
