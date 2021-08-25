package kr.or.iei.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.or.iei.dao.RoomDao;
import kr.or.iei.vo.Member;
import kr.or.iei.vo.Rent;
import kr.or.iei.vo.Room;

public class RoomService {

	private RoomDao dao;

	public RoomService() {
		super();
		dao = new RoomDao();
	}

	public int register(ArrayList<String> registerList) {
		Connection conn = JDBCTemplate.getConnection();
		int r = -1;

		r = dao.register(conn, registerList);

		if (r > 0)
			JDBCTemplate.commit(conn);
		else
			JDBCTemplate.close(conn);

		JDBCTemplate.close(conn);

		return r;
	}

	public int insertRoom(ArrayList<String> roomInfoList) {
		Connection conn = JDBCTemplate.getConnection();
		int r = -1;

		r = dao.insertRoom(conn, roomInfoList);

		if (r > 0)
			JDBCTemplate.commit(conn);
		else
			JDBCTemplate.close(conn);

		JDBCTemplate.close(conn);

		return r;
	}
	public int bookingRoom(int room_no, int member_no) {
		Connection conn = JDBCTemplate.getConnection();
		int r = -1;

		r = dao.bookingRoom(conn, room_no, member_no);

		if (r > 0)
			JDBCTemplate.commit(conn);
		else
			JDBCTemplate.close(conn);

		JDBCTemplate.close(conn);

		return r;
		
	}
	
	
	public Member login(ArrayList<String> idPw) {
		Connection conn = JDBCTemplate.getConnection();
		Member member = null;
		member = dao.login(conn, idPw);
		JDBCTemplate.close(conn);
		return member;
	}


	public ArrayList<Member> selectAllMember() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Member> members = null;
		members = dao.selectAllMember(conn);
		JDBCTemplate.close(conn);
		return members;
	}

	public ArrayList<Room> selectAllRoom() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Room> rooms = null;
		rooms = dao.selectAllRoom(conn);
		JDBCTemplate.close(conn);
		return rooms;
	}

	public ArrayList<Rent> selectAllReserver() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Rent> rents = null;
		rents = dao.selectAllReserver(conn);
		JDBCTemplate.close(conn);
		return rents;
	}
	

}
