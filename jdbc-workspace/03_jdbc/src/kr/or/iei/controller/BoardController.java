package kr.or.iei.controller;

import java.sql.SQLException;

import kr.or.iei.dao.BoardDao;
import kr.or.iei.view.BoardView;
import kr.or.iei.vo.Board;
import kr.or.iei.vo.User;

public class BoardController {
	BoardView view = new BoardView();
	BoardDao dao = new BoardDao();
	User user;

	public BoardController(User user) {
		this.user = user;
	}

	public void main() {

		try {
			while (true) {
				int sel = view.boardMenu(user.getUserName());
				switch (sel) {
				case 1:
					viewPost(false);
					break;
				case 2:
					viewPost(true);
					break;
				case 3:
					editOrWriterPost(false);
					break;
				case 4:
					editOrWriterPost(true);
					break;
				case 5:
					deletePost();
					break;
				case 6:
					return;

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void deletePost() throws SQLException {
		int boardNo = view.getBoradNo();
		boolean isBoardWriter = dao.isBoardWriter(boardNo, user.getUserNo());
		
		if (isBoardWriter) {
			view.resultMsg(dao.deletePost(boardNo) > 0);
			return;
		}
		
		view.isBoardWriter(isBoardWriter);
		view.resultMsg(isBoardWriter);

	}

	private void editOrWriterPost(boolean edit) throws SQLException {
		int boardNo = edit ? view.getBoradNo() : -1;
		boolean isBoardWriter = !edit ? true : dao.isBoardWriter(boardNo, user.getUserNo());
		
		if (isBoardWriter) {
			String[] list = view.getBoradList(edit);
			if (!edit)
				list[2] = Integer.toString(user.getUserNo());
			dao.insertNdUpdatePost(list, boardNo, edit);
		}
		
		view.isBoardWriter(isBoardWriter);
		view.resultMsg(isBoardWriter);
	}

	private void viewPost(boolean readAll) throws SQLException {
		int boardNo = readAll? -1:view.getBoradNo();
		Board[] posts = dao.selectPost(boardNo, readAll);
		view.printAllPost(posts);
	}

}
