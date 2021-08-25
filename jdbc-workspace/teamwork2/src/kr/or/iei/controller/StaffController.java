package kr.or.iei.controller;

import java.util.ArrayList;

import kr.or.iei.service.RoomService;
import kr.or.iei.view.View;
import kr.or.iei.vo.Member;
import kr.or.iei.vo.Rent;
import kr.or.iei.vo.Room;

public class StaffController {
	private RoomService service;
	private View view;

	public StaffController() {
		super();
		view = new View();
		service = new RoomService();
	}

	public void main() {
		while (true) {
			int sel = view.staffMain();
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
		ArrayList<Member> list = service.selectAllMember();
		view.printMember(list);
	}

	private void printAllReserver() {
		ArrayList<Rent> list = service.selectAllReserver();
		if (list == null) {
			view.printMsg("예약자가 없습니다. \n나중에 다시 이용부탁드립니다.");
		} else {
			view.printRent(list);
		}
	}

	private void printAllRoom() {
		ArrayList<Room> list = service.selectAllRoom();
		if (list == null) {
			view.printMsg("매물이 없습니다. 추후에 다시 이용해주세요.");
		} else {
			view.printRoom(list);
		}
	}

	private void insertRoom() {
		// insert into room values(room_seq.nextval,?,?,?)
		ArrayList<String> list = view.insertRoom();
		int result = service.insertRoom(list);
		if (result > 0) {
			view.printMsg("등록완료");
		} else {
			view.printMsg("입력하실 정보를 다시 확인해주세요.");
		}
	}

}
