package kr.or.iei.member.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import common.JDBCTemplate;
import kr.or.iei.member.model.vo.Member;

public class MemberDao {
	private String selectById = null;
	private String selectByName = null;
	private String login = null;
	private String insert = null;
	private String update = null;
	private String delete = null;

	{
		try (FileReader fr = new FileReader("resources/memberQuery.properties");) {
			Properties prop = new Properties();
			prop.load(fr);
			selectById = prop.getProperty("selectById");
			selectByName = prop.getProperty("selectByName");
			login = prop.getProperty("login");
			insert = prop.getProperty("insert");
			update = prop.getProperty("update");
			delete = prop.getProperty("delete");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private String readProperties(String propertyToRead) {
		String query = null;

		try (FileReader fr = new FileReader("resources.memberQuery.properties");) {
			Properties prop = new Properties();
			query = prop.getProperty(propertyToRead);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return query;

	}

	public Member parseMember(ResultSet rset) throws SQLException {
		Member m = new Member(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4),
				rset.getString(5), rset.getInt(6), rset.getDate(7));
		return m;

	}

	public ArrayList<Member> selectMember(Connection conn, boolean searchById, String searchInfo) {
		searchInfo = searchById ? searchInfo : searchInfo + "%";

		PreparedStatement state = null;
		ResultSet result = null;
		ArrayList<Member> list = null;
		try {
			state = conn.prepareStatement(searchById? selectById:selectByName);
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
		PreparedStatement state = null;
		ResultSet result = null;
		boolean r = false;
		try {
			state = conn.prepareStatement(selectById);
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
		PreparedStatement state = null;
		ResultSet result = null;
		boolean r = false;
		try {
			state = conn.prepareStatement(login);
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
		PreparedStatement state = null;
		int r = 0;
		try {
			state = conn.prepareStatement(insert);
			for (int i = 0; i < list.length - 1; i++) {
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
		PreparedStatement state = null;
		int r = 0;
		try {
			state = conn.prepareStatement(update);
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
		PreparedStatement state = null;
		int r = 0;
		try {
			state = conn.prepareStatement(delete);
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
