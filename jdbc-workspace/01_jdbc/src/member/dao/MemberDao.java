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

			while (result.next()) {
				String memberId = result.getString("member_id");
				String memberPw = result.getString("member_pw");
				String memberName = result.getString("member_name");
				String memberAddr = result.getString("member_addr");
				String memberPhone = result.getString("member_phone");
				int memberAge = result.getInt("member_age");
				Date enrollDate = result.getDate("enroll_date");


				Member m = new Member(memberId, memberPw, memberName, 
						memberAddr, memberPhone, memberAge, enrollDate);
				list.add(m);
				

			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				result.close();
				state.close();
				conn.close();				
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}

		return list;
	}

}
