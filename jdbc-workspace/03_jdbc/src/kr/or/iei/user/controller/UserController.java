package kr.or.iei.user.controller;

import java.sql.SQLException;

import kr.or.iei.user.dao.UserDao;
import kr.or.iei.user.view.UserView;
import kr.or.iei.user.vo.User;

public class UserController {
	UserView view = new UserView();
	UserDao dao = new UserDao();
	User user;
	boolean login;

	public void main() {
		try {
			while (true) {
				int sel = view.main();
				switch (sel) {
				case 1:
					login();
					break;
				case 2:
					insertNdEditUser(false);
					break;
				case 3:
					return;
				}
				while (login) {
					sel = view.loginMain(user.getUserName());
					switch (sel) {
					case 1:
						viewUserInfo();
						break;
					case 2:
						insertNdEditUser(true);
						break;
					case 3:
						unregister();
					case 4:
						logout();
						break;

					}
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void insertNdEditUser(boolean edit) throws SQLException {
		String id = edit ? user.getUserId() : view.getId();
		boolean isUserInDB = edit ? true : dao.isUserInDB(id, null);
		boolean result = false;

		if (isUserInDB && !edit)
			view.alreadyUserExist();

		if (!isUserInDB || (isUserInDB && edit)) {
			String[] list = view.getList(id, edit);
			if (list == null) {
				view.somethingWentWrong();
			} else {
				int r = dao.insertNdEditUser(list, edit);
				result = r > 0 ? true : false;
			}
		}

		view.resultMsg(result);

	}

	private void viewUserInfo() throws SQLException {
		view.printUser(user);

	}

	private void unregister() throws SQLException {
		int r = dao.deleteUser(user.getUserId());
		boolean result = r > 0 ? true : false;
		view.resultMsg(result);
	}

	private void login() throws SQLException {
		String id = view.getId();
		String pw = view.getPw();
		login = dao.isUserInDB(id, pw);
		if (!login) {
			view.wrongIdOrPw();
			view.resultMsg(login);			
			return;
		}
		view.resultMsg(login);			
		user = dao.selectUser(id);
	}

	private void logout() {
		login = false;
		user = null;

	}

}
