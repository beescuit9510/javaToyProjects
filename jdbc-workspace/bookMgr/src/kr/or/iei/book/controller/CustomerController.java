package kr.or.iei.book.controller;

import java.util.ArrayList;

import kr.or.iei.book.service.LibraryService;
import kr.or.iei.book.view.LibraryView;
import kr.or.iei.book.vo.Member;
import kr.or.iei.book.vo.Rent;

public class CustomerController {

	LibraryView view = new LibraryView();
	LibraryService service = new LibraryService();

	String id;
	String pw;
	int no;

	public CustomerController(String id, String pw, int no) {
		super();
		this.id = id;
		this.pw = pw;
		this.no = no;
	}

	public void main() {
		while (true) {
			int sel = view.customerMain();
			switch (sel) {
			case 1:
				print('B');
				borrowBook();
				break;
			case 2:
				printRentInfo();
				break;
			case 3:
				returnBook();
				break;
			case 4:
				printMyInfo();
				break;
			case 0:
				return;
			}
		}
	}

	private void returnBook() {
		int rentNo = view.getRentNo();
		int r = service.returnBook(no, rentNo);
		view.resultMsg(r > 0);
	}

	private void print(char ch) {
		ArrayList<Object> objects = service.select(ch);
		view.print(objects);
	}

	private void borrowBook() {
		int bookNo = view.getBookNo();
		int r = service.borrowBook(no, bookNo);
		view.resultMsg(r > 0);
	}

	private void printRentInfo() {
		ArrayList<Rent> rents = service.selectRentList(no);
		view.printR(rents);
	}

	private void printMyInfo() {
		Member m = service.login(no);
		ArrayList<Object> object = new ArrayList<Object>();
		object.add(m);
		view.print(object);
	}

}
