package member.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import member.vo.Member;

public class MemberDao {
	final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final String KH_URL = "jdbc:oracle:thin:@1.220.236.74:15212:xe";
	final String USER = "jdbc";
	final String PW = "1234";

	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Member> selectAllMember() {
		Connection conn = null; // DMS 연결 객체
		Statement state = null; // SQL 구문을 전달하고 받아오는 객체
		ResultSet result = null; // select 쿼리 수행 결과를 저장하는 객체

		ArrayList<Member> list = new ArrayList<Member>(); // query 표의 결과를 arraylist로 변환
		String query = "select * from member"; // ; semicolon 없이 !

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver"); // 시용할 DB에 대한 드라이버 등록

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "jdbc", "1234");
			// 등록된 클라스 이용해서 DB 연결처리

			state = conn.createStatement();
			// 쿼리문을 실행하고 결과를 받아오는 statement

			result = state.executeQuery(query);
			// 쿼리문을 전송하고 실행하고 실행결과를 받아와 저장;

//			if(result.next()) {
//				Array memberId = result.getArray("member_id");
//				Object obj = memberId.getArray();
//				System.out.println((String)obj);
//				
//			}

			while (result.next()) {
				String memberId = result.getString("member_id");
				String memberPw = result.getString("member_pw");
				String memberName = result.getString("member_name");
				String memberAddr = result.getString("member_addr");
				String memberPhone = result.getString("member_phone");
				int memberAge = result.getInt("member_age");
				Date enrollDate = result.getDate("enroll_date");

				Member m = new Member(memberId, memberPw, memberName, memberAddr, memberPhone, memberAge, enrollDate);
				list.add(m);

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				result.close();
				state.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

	public ArrayList<Member> selectOneMember(String memberIdOrName, boolean searchById) {

		String query = null;
		ArrayList<Member> list = new ArrayList<Member>();

		if (searchById)
			query = "select * from member where member_id='" + memberIdOrName + "'";
		else
			query = "select * from member where member_name like'%" + memberIdOrName + "%'";

		try (Connection conn = DriverManager.getConnection(URL, USER, PW);
				Statement state = conn.createStatement();
				ResultSet r = state.executeQuery(query);) {

			while (r.next()) {
				Member m = new Member(r.getString(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5),
						r.getInt(6), r.getDate(7));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (list.size() == 0)
			return null;
		return list;
	}

	public int insertMember(String[] list) {

		if (list == null)
			return -1;

		String values = "";
		int result = 0;

		for (String str : list) {
			values += "'" + str + "',";
		}

		String query = "insert into member values(" + values + "sysdate)";

		try (Connection conn = DriverManager.getConnection(URL, USER, PW); Statement state = conn.createStatement();) {

			result = state.executeUpdate(query);
			// insert/update/delete excuteUpdate 사용해서 결과로 정수 리턴 !

			if (result > 0)
				conn.commit();
			else
				conn.rollback();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public boolean memberInDB(String name) {
		String query = "select * from member where member_id like '" + name + "'";
		boolean r = false;

		try (Connection conn = DriverManager.getConnection(URL, USER, PW);
				Statement state = conn.createStatement();
				ResultSet result = state.executeQuery(query);) {
			if (result.next())
				r = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;

	}

	public int editMember(String id, String[] list) {
		int r = -1;
		String values = "member_pw='" + list[0] + "'," + "member_addr='" + list[1] + "'," + "member_phone='" + list[2]
				+ "'";
		String query = "update member set " + values + " where member_id= '" + id + "'";

		try (Connection conn = DriverManager.getConnection(URL, USER, PW); Statement state = conn.createStatement();) {

			r = state.executeUpdate(query);
			conn.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return r;
	}

	public int deleteMember(String name) {
		String query = "delete from member where member_name like '" + name + "'";
		int r = -1;

		try (Connection conn = DriverManager.getConnection(URL, USER, PW); Statement state = conn.createStatement();) {
			r = state.executeUpdate(query);

			if (r > 0)
				conn.commit();
			else
				conn.rollback();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return r;

	}

	public Member login(Member m) {
		String query = "select * from member where member_id='" + m.getMemberId() + "' and member_pw='"
				+ m.getMemberPw() + "'";

		try (Connection conn = DriverManager.getConnection(URL, USER, PW);
				Statement state = conn.createStatement();
				ResultSet r = state.executeQuery(query);) {

			if (r.next()) {
				int i = 1;
				return new Member(r.getString(i++), r.getString(i++), r.getString(i++), r.getString(i++),
						r.getString(i++), r.getInt(i++), r.getDate(i++));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

}
