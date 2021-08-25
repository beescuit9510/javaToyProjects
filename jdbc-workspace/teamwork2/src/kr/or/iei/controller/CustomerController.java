package kr.or.iei.controller;

import java.util.ArrayList;

import kr.or.iei.service.RoomService;
import kr.or.iei.view.View;
import kr.or.iei.vo.Room;

public class CustomerController {
	private int member_no;
	private String name;
	private View view;
	private RoomService service;

	public CustomerController() {
		super();
		view = new View();
		service = new RoomService();
	}

	public void main(int member_no, String name) {
		this.member_no = member_no;
		this.name = name;
		while (true) {
			int sel = view.customerMain(name);
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
		int room_no = view.getRoomNo();
		int r = service.bookingRoom(room_no, member_no);
		if (r > -1) {
			view.printMsg("에약되어 있는방 입니다.");
		} else if(r>0){
			view.printMsg("예약 성공");
		}else {
			view.printMsg("에약실패");
		}

	}

	private void printAllRoom() {
		ArrayList<Room> rooms = service.selectAllRoom();
		view.printRoom(rooms);
	}

}