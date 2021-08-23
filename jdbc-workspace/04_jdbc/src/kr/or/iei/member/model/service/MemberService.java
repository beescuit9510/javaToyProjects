package kr.or.iei.member.model.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import kr.or.iei.member.model.dao.MemberDao;
import kr.or.iei.member.model.vo.Member;

public class MemberService {

	final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final String USER = "jdbc";
	final String PW = "1234";
	final String DRIVER = "oracle.jdbc.driver.OracleDriver";
//	final String KH_URL = "jdbc:oracle:thin:@1.220.236.74:15212:xe";
	private MemberDao dao;

	{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public MemberService() {
		super();
		dao = new MemberDao();
	}

	public ArrayList<Member> selectMember() {
		ArrayList<Member> list = null;

		try (Connection conn = DriverManager.getConnection(URL, USER, PW);
		) {
			conn.setAutoCommit(false);
			list = dao.selectMember(conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public int deleteMember(String id) {
		int r = 0;
		
		try (Connection conn = DriverManager.getConnection(URL, USER, PW);
		) {
			conn.setAutoCommit(false);
			r = dao.deleteMember(conn, id);
			
			if( r > 0 )
				r = dao.insertDelMember(conn, id);
			
			if( r > 0 )
				conn.commit();
			else
				conn.rollback();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return r;
	}

}