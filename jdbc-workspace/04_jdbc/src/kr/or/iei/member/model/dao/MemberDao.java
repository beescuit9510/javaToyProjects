package kr.or.iei.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import kr.or.iei.member.model.vo.Member;

public class MemberDao {

	public ArrayList<Member> selectMember(Connection conn) throws SQLException {
		String query = "select * from member";
		PreparedStatement state = conn.prepareStatement(query);
		ResultSet result = state.executeQuery();

		ArrayList<Member> members = new ArrayList<Member>();

		while (result.next()) {
			Member m = new Member(result.getString(1), result.getString(2), result.getString(3), result.getString(4),
					result.getString(5), result.getInt(6), result.getDate(7));
			members.add(m);
		}

		state.close();
		result.close();

		return members;
	}

	public int deleteMember(Connection conn, String id) throws SQLException {
		String query = "delete from member where member_id = ?";
		PreparedStatement state = conn.prepareStatement(query);
		state.setString(1, id);

		int r = state.executeUpdate();
		state.close();

		return r;
	}

	public int insertDelMember(Connection conn, String id) throws SQLException {
		String query = "insert into del_member values(1, ?)";
		int r = 0;

		try (PreparedStatement state = conn.prepareStatement(query);) {
			state.setString(1, id);
			r = state.executeUpdate();

		} catch (SQLIntegrityConstraintViolationException e) {
			e.printStackTrace();
		}

		return r;
	}

}
