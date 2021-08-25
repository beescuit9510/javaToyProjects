package kr.or.iei.controller;

import kr.or.iei.view.View;

public class CustomerController {

	View view = new View();

	public void main() {
		while (true) {
			int sel = view.main();
			switch (sel) {
			case 1:
				printAllRoom();
				break;
			case 2:
				bookingRoom();
				break;
			case 0:
				return;
			}
		}

	}

	private void bookingRoom() {
		
	}

	private void printAllRoom() {
		
	}
	

}