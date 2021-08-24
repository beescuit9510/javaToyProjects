package kr.or.iei.book.controller;

import java.util.ArrayList;

import kr.or.iei.book.service.LibraryService;
import kr.or.iei.book.view.LibraryView;

public class StaffController {

	LibraryView view = new LibraryView();
	LibraryService service = new LibraryService();

	public void main() {
		while (true) {
			int sel = view.staffMain();
			switch (sel) {
			case 1:
				print('B');
				break;
			case 2:
				insertBook();
				break;
			case 3:
				print('R');
				break;
			case 4:
				print('M');
				break;
			case 0:
				return;
			}
		}
	}

	private void print(char ch) {
		ArrayList<Object> objects = service.select(ch);
		view.print(objects);
	}

	private void insertBook() {
		String[] list = view.insertBook();
		int r = service.insert(list, 'B');
		view.resultMsg(r > 0);

	}

}
