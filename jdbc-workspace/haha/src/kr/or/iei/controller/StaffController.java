package kr.or.iei.controller;

import kr.or.iei.view.View;

public class StaffController {
	View view = new View();
	
	public void main() {
		while (true) {
			int sel = view.main();
			switch (sel) {
			case 1:
				insertRoom();
				break;
			case 2:
				printAllRoom();
				break;
			case 3:
				printAllReserver();
				break;
			case 4:
				printAllMember();
				break;
			case 0:
				return;
			}
		}

	}

	private void printAllMember() {
		
	}

	private void printAllReserver() {
		
	}

	private void printAllRoom() {
		
	}

	private void insertRoom() {
		
	}

}
