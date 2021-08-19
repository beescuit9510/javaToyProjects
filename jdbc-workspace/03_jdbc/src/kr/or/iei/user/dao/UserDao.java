package kr.or.iei.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.iei.user.vo.User;

public class UserDao {

	final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final String USER = "JDBC1";
	final String PW = "1234";
	final String DRIVER = "oracle.jdbc.driver.OracleDriver";
//	final String KH_URL = "jdbc:oracle:thin:@1.220.236.74:15212:xe";

	{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public boolean isUserInDB(String id, String pw) throws SQLException {
		String query = "select * from user_tbl where user_id = ?";
		query = pw != null ? query + " and user_pw = ?" : query;

		Connection conn = DriverManager.getConnection(URL, USER, PW);
		PreparedStatement prepared = conn.prepareStatement(query);
		prepared.setString(1, id);
		if (pw != null)
			prepared.setString(2, pw);

		ResultSet r = prepared.executeQuery();
		boolean boolR = r.next();

		conn.close();
		prepared.close();
		r.close();
		return boolR;
	}

	public User selectUser(String id) throws SQLException {
		String query = "select * from user_tbl where user_id = ?";
		Connection conn = DriverManager.getConnection(URL, USER, PW);
		PreparedStatement prepared = conn.prepareStatement(query);
		prepared.setString(1, id);
		ResultSet r = prepared.executeQuery();

		User user = null;
		if (r.next()) {
			user = new User(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getInt(5), r.getString(6));

		}

		conn.close();
		prepared.close();
		r.close();
		return user;

	}

	public int deleteUser(String id) throws SQLException {
		String query = "delete from user_tbl where user_id = ?";
		Connection conn = DriverManager.getConnection(URL, USER, PW);
		PreparedStatement prepared = conn.prepareStatement(query);
		prepared.setString(1, id);
		int r = prepared.executeUpdate();

		if (r > 0)
			conn.commit();
		else
			conn.rollback();

		conn.close();
		prepared.close();
		return r;

	}


	public int insertNdEditUser(String[] list, boolean edit) throws SQLException {
		String editStr = "update user_tbl set user_pw = ?, user_name = ?, user_phone = ? where user_id = ?";
		String insert = "insert into user_tbl(user_no, user_pw, user_name, user_phone, user_age, user_id) values(squ.nextval,?,?,?,?,?)";
		String query = edit ? editStr : insert;
		
		Connection conn = DriverManager.getConnection(URL, USER, PW);
		PreparedStatement prepared = conn.prepareStatement(query);

		if(!edit) {
			int age = Integer.parseInt(list[list.length-2]);
			prepared.setInt(list.length-1, age);
		}
		prepared.setString(list.length, list[list.length-1]);
		for (int i = 1; i<4; i++) {
			prepared.setString(i, list[i - 1]);
		}

		int r = prepared.executeUpdate();

		if (r > 0)
			conn.commit();
		else
			conn.rollback();

		conn.close();
		prepared.close();
		return r;
	}

}
