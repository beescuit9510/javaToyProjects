package kr.or.iei.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.iei.member.vo.Member;

public class MemberDao {
	final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final String USER = "jdbc";
	final String PW = "1234";
	final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String KH_URL = "jdbc:oracle:thin:@1.220.236.74:15212:xe";

	{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Member> selectMember(boolean printAllMember, boolean searchById, String searchInfo)
			throws SQLException {
		String where = searchById ? " member_id = ? " : " member_name like ?";
		String query = "select * from member";
		query = query + " where" + where;
		ArrayList<Member> list = new ArrayList<Member>();

		if (!searchById)
			searchInfo = "%" + searchInfo + "%";

		Connection conn = DriverManager.getConnection(URL, USER, PW);
		PreparedStatement prepared = conn.prepareStatement(query);
		prepared.setString(1, searchInfo);
		ResultSet r = prepared.executeQuery();

		while (r.next()) {
			Member member = new Member(r.getString(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5),
					r.getInt(6), r.getDate(7));
			list.add(member);
		}

		conn.close();
		prepared.close();
		r.close();
		return list;

	}

	public boolean isMemberInDB(String searchInfo) throws SQLException {
		String query = "select * from member where member_id = ?";
		Connection conn = DriverManager.getConnection(URL, USER, PW);
		PreparedStatement prepared = conn.prepareStatement(query);
		prepared.setString(1, searchInfo);
		ResultSet r = prepared.executeQuery();

		boolean isMemberInDB = r.next();
		conn.close();
		prepared.close();
		r.close();

		return isMemberInDB;
	}

	public int deleteMember(String searchInfo) throws SQLException {

		String query = "delete from member where member_id = ?";
		Connection conn = DriverManager.getConnection(URL, USER, PW);
		PreparedStatement prepared = conn.prepareStatement(query);
		prepared.setString(1, searchInfo);

		int r = prepared.executeUpdate();
		if (r > 0) {
			conn.commit();
		} else {
			conn.rollback();
		}

		conn.close();
		prepared.close();
		return r;
	}

	public int insertMember(String[] list) throws SQLException {
		if (list == null)
			return -1;

		String query = "";
		boolean update = false;

		if (list.length > 5) {
			query = "insert into member values(? ,? ,? ,? ,? ,? ,sysdate)";

		} else {
			update = true;
			query = "update member set member_pw = ?, member_name = ?, member_addr = ?, member_phone = ? where member_id = '"
					+ list[0] + "'";

		}

		Connection conn = DriverManager.getConnection(URL, USER, PW);
		PreparedStatement prepared = conn.prepareStatement(query);

		if (!update) {
			int age = Integer.parseInt(list[list.length - 1]);
			prepared.setInt(list.length, age);
		}

		for (int i = 1; i <= list.length - 1; i++) {
			prepared.setString(i, list[update ? i : i - 1]);
		}

		int r = prepared.executeUpdate();

		if (r > 0) {
			conn.commit();
		} else {
			conn.rollback();
		}

		conn.close();
		prepared.close();
		return r;
	}

}
