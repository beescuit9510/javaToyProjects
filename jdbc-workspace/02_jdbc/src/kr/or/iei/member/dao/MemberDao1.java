package kr.or.iei.member.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kr.or.iei.member.vo.Member;

public class MemberDao1 {
	final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final String USER = "jdbc";
	final String PW = "1234";
	final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String KH_URL = "jdbc:oracle:thin:@1.220.236.74:15212:xe";

	boolean printAllMember;
	boolean searchById;
	boolean r;
	int intR;
	String searchInfo;
	ArrayList<Member> list = new ArrayList<Member>();
	ArrayList<String> infoList = new ArrayList<String>();
	Member member;

	{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void setInstanceValues(boolean printAllMember, boolean searchById, String searchInfo,
			ArrayList<String> infoList) {
		this.printAllMember = printAllMember;
		this.searchById = searchById;
		this.searchInfo = searchInfo;
		this.infoList = infoList;
	}

	private void setDefaultValues() {
		this.printAllMember = false;
		this.searchById = false;
		this.r = false;
		this.searchInfo = null;
		this.list = new ArrayList<Member>();
		this.member = null;
		this.intR = -1;
		infoList = new ArrayList<String>();
	}

	private void methods(int sel) {
		try {
			switch (sel) {
			case 1, 2, 3:
				selectMember();
				break;
			case 4:
				insertMember();
				break;
			case 5:
				break;
			case 6:
				deleteMember();
				break;
			case 7:
				isMemberInDM();
				break;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Member> selectMember(boolean printAllMember, boolean searchById, String searchInfo) {
		setDefaultValues();
		setInstanceValues(printAllMember, searchById, searchInfo, null);
		methods(1);
		return this.list;
	}

	public boolean isMemberInDB(String searchInfo) {
		setDefaultValues();
		setInstanceValues(false, false, searchInfo, null);
		methods(7);
		return this.r;
	}

	public int deleteMember(String searchInfo) {
		setDefaultValues();
		setInstanceValues(false, false, searchInfo, null);
		methods(6);
		return this.intR;
	}

	public int insertMember(ArrayList<String> infoList) {
		setDefaultValues();
		setInstanceValues(false, false, null, infoList);
		methods(6);
		return this.intR;

	}

	private void selectMember() throws SQLException {
		String where = searchById ? " member_id = ? " : " member_name like ?";
		String query = "select * from member";
		query = query + " where" + where;

		if (!searchById)
			searchInfo = "%" + searchInfo + "%";

		Connection conn = DriverManager.getConnection(URL, USER, PW);
		PreparedStatement prepared = conn.prepareStatement(query);
		prepared.setString(1, searchInfo);
		ResultSet r = prepared.executeQuery();

		while (r.next()) {
			Member member = new Member(r.getString(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5),
					r.getInt(6), r.getDate(7));
			this.list.add(member);
		}

		conn.close();
		prepared.close();
		r.close();

	}

	private void isMemberInDM() throws SQLException {
		String query = "select * from member where member_id = ?";
		Connection conn = DriverManager.getConnection(URL, USER, PW);
		PreparedStatement prepared = conn.prepareStatement(query);
		prepared.setString(1, searchInfo);
		ResultSet r = prepared.executeQuery();

		this.r = r.next() ? true : false;

		conn.close();
		prepared.close();
		r.close();

	}

	private void deleteMember() throws SQLException {
		String query = "delete from member where member_id = ?";
		Connection conn = DriverManager.getConnection(URL, USER, PW);
		PreparedStatement prepared = conn.prepareStatement(query);
		prepared.setString(1, searchInfo);

		this.intR = prepared.executeUpdate();
		if (this.intR > 0) {
			conn.commit();
		} else {
			conn.rollback();
		}

		conn.close();
		prepared.close();
	}

	private void insertMember() throws SQLException {
		String query = "insert into member values(? ,? ,? ,? ,? ,? ,sysdate)";

		Connection conn = DriverManager.getConnection(URL, USER, PW);
		PreparedStatement prepared = conn.prepareStatement(query);

		int i = 1;
		for (String searchInfo : infoList) {
			prepared.setString(i++, searchInfo);
		}

		this.intR = prepared.executeUpdate();
		
		if (this.intR > 0) {
			conn.commit();
		} else {
			conn.rollback();
		}

		conn.close();
		prepared.close();
	}

}
