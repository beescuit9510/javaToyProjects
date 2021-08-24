package kr.or.iei.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.or.iei.member.model.vo.Member;

public class MemberDao {

	public Member parseMember(ResultSet rset) throws SQLException {
		Member m = new Member(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4),
				rset.getString(5), rset.getInt(6), rset.getDate(7));
		return m;

	}

	public ArrayList<Member> selectMember(Connection conn, boolean searchById, String searchInfo) {
		String searchBy = searchById ? "member_id" : "member_name";
		searchInfo = searchById ? searchInfo : searchInfo + "%";
		String query = "select * from member where " + searchBy + " like ?";
		
		PreparedStatement state = null;
		ResultSet result = null;
		ArrayList<Member> list = null;
		
		try {
			state = conn.prepareStatement(query);
			state.setString(1, searchInfo);
			result = state.executeQuery();
			list = new ArrayList<Member>();
			while (result.next()) {
				list.add(parseMember(result));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(result);
			JDBCTemplate.close(state);
		}

		return list;
	}

	public boolean isMemberInDB(Connection conn, String id) {
		String query = "select * from member where member_id = ?";
		PreparedStatement state = null;
		ResultSet result = null;
		boolean r = false;
		try {
			state = conn.prepareStatement(query);
			state.setString(1, id);
			result = state.executeQuery();
			r = result.next();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(state);
			JDBCTemplate.close(result);
		}

		return r;
	}
	
	public boolean isMemberInDB(Connection conn, String id, String pw) {
		String query = "select * from member where member_id = ? and member_pw = ?";
		PreparedStatement state = null;
		ResultSet result = null;
		boolean r = false;
		try {
			state = conn.prepareStatement(query);
			state.setString(1, id);
			state.setString(2, pw);
			result = state.executeQuery();
			r = result.next();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(state);
			JDBCTemplate.close(result);
		}

		return r;
	}


	public int insertMember(Connection conn, String[] list) {
		String query = "insert into member values(?,?,?,?,?,?,sysdate)";
		PreparedStatement state = null;
		int r = 0;
		try {
			state = conn.prepareStatement(query);
			for (int i = 0; i < list.length-1; i++) {
				state.setString(i + 1, list[i]);
			}
			state.setInt(list.length, Integer.parseInt(list[list.length - 1]));
			r = state.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(state);
		}

		return r;
	}

	public int editMember(Connection conn, String[] list) {
		String query = "update member set member_pw = ?, member_name = ?, member_addr = ?, member_phone = ? where member_id = ? ";
		PreparedStatement state = null;
		int r = 0;
		try {
			state = conn.prepareStatement(query);
			for (int i = 1; i < list.length; i++) {
				state.setString(i, list[i]);
			}
			state.setString(list.length, list[0]);

			r = state.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(state);
		}

		return r;
	}

	public int deleteMember(Connection conn, String id) {
		String query = "delete from member where member_id = ?";
		PreparedStatement state = null;
		int r = 0;
		try {
			state = conn.prepareStatement(query);
			state.setString(1, id);
			r = state.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(state);
		}
		return r;
	}

}
