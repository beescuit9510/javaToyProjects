package kr.or.iei.dao;

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
import kr.or.iei.vo.Member;
import kr.or.iei.vo.Rent;
import kr.or.iei.vo.Room;

public class RoomDao {
	private String selectAllMember = null;
	private String selectAllRoom = null;
	private String selectAllReserver = null;
	private String register = null;
	private String insertRoom = null;
	private String login = null;
	private String bookingRoom = null;

	{
		try (FileReader fr = new FileReader("resources/query.properties");) {
			Properties prop = new Properties();
			prop.load(fr);
			selectAllMember = prop.getProperty("selectAllMember");
			selectAllRoom = prop.getProperty("selectAllRoom");
			selectAllReserver = prop.getProperty("selectAllReserver");
			register = prop.getProperty("register");
			insertRoom = prop.getProperty("insertRoom");
			login = prop.getProperty("login");
			bookingRoom = prop.getProperty("bookingRoom");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public ArrayList<Member> selectAllMember(Connection conn) {
		PreparedStatement state = null;
		ResultSet r = null;
		ArrayList<Member> members = new ArrayList<Member>();
		
		try {
			state = conn.prepareStatement(selectAllMember);
			r = state.executeQuery();
			while (r.next()) {
				members.add(getMember(r));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(r);
			JDBCTemplate.close(state);
		}
		return members.size() == 0 ? null : members;
	}

	public ArrayList<Room> selectAllRoom(Connection conn) {
		PreparedStatement state = null;
		ResultSet r = null;
		ArrayList<Room> rooms = new ArrayList<Room>();

		try {
			state = conn.prepareStatement(selectAllRoom);
			r = state.executeQuery();
			while (r.next()) {
				rooms.add(getRoom(r));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(r);
			JDBCTemplate.close(state);
		}

		return rooms.size() == 0 ? null : rooms;
	}

	public ArrayList<Rent> selectAllReserver(Connection conn) {
		PreparedStatement state = null;
		ResultSet r = null;
		ArrayList<Rent> reservers = new ArrayList<Rent>();

		try {
			state = conn.prepareStatement(selectAllReserver);
			r = state.executeQuery();
			while (r.next()) {
				reservers.add(getRent(r));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(r);
			JDBCTemplate.close(state);
		}

		return reservers.size() == 0 ? null : reservers;
	}

	private Rent getRent(ResultSet r) throws SQLException {
		return new Rent(r.getInt(1), r.getString(2), r.getDate(3));
	}

	public Member login(Connection conn, ArrayList<String> idPw) {
		PreparedStatement state = null;
		ResultSet r = null;
		Member member = null;

		try {
			state = conn.prepareStatement(login);
			state.setString(1, idPw.get(0));
			state.setString(2, idPw.get(1));
			r = state.executeQuery();
			if (r.next()) {
				member = getMember(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(r);
			JDBCTemplate.close(state);
		}

		return member;
	}
	
	
	
	
	
	
	

	public int register(Connection conn, ArrayList<String> registerList) {
		PreparedStatement state = null;
		int r = -1;

		try {
			state = conn.prepareStatement(register);
			int i = 1;
			for(String str: registerList) {
				if(i ==5)
					state.setInt(i++, Integer.parseInt(str));
				else
					state.setString(i++, str);
			}
			
			r = state.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(state);
		}
		return r;
	}

	public int insertRoom(Connection conn, ArrayList<String> roomInfoList) {
		PreparedStatement state = null;
		int r = -1;

		try {
			state = conn.prepareStatement(insertRoom);
			int i = 1;
			for(String str: roomInfoList) {
				state.setString(i++, str);
			}
			
			r = state.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(state);
		}
		return r;
	}

	private Member getMember(ResultSet r) throws SQLException {
		return new Member(r.getInt(1),r.getString(2),r.getString(3),r.getString(4),r.getString(5),r.getInt(6));
	}

	private Room getRoom(ResultSet r) throws SQLException {
		int i = 1;
		return new Room(r.getInt(i++), r.getString(i++), r.getString(i++), r.getString(i++));
	}

	public int bookingRoom(Connection conn, int room_no, int member_no) {
		PreparedStatement state = null;
		int r = -1;

		try {
			state = conn.prepareStatement(bookingRoom);
			state.setInt(1, room_no);
			state.setInt(2, member_no);
			
			r = state.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(state);
		}
		return r;
	}
}
