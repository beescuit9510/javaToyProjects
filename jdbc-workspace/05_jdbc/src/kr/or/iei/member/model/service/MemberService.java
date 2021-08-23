package kr.or.iei.member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.or.iei.member.model.dao.MemberDao;
import kr.or.iei.member.model.vo.Member;

public class MemberService {
	private MemberDao dao;

	public MemberService() {
		super();
		dao = new MemberDao();
	}

	public ArrayList<Member> selectMember(boolean searchById, String searchInfo) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Member> list = null;
		list = dao.selectMember(conn, searchById, searchInfo);
		JDBCTemplate.close(conn);
		return list;
	}
	
	public int insertMember(boolean edit, String[] list) {
		Connection conn = JDBCTemplate.getConnection();
		int r = -1;
		if(edit)
			r = dao.editMember(conn, list);
		else
			r = dao.insertMember(conn, list);
		JDBCTemplate.close(conn);
		return r;
	}

	public boolean isMemberInDB(String id) {
		Connection conn = JDBCTemplate.getConnection();
		boolean r = false;
		r = dao.isMemberInDB(conn, id);
		JDBCTemplate.close(conn);
		return r;
	}

	public int deleteMember(String id) {
		Connection conn = JDBCTemplate.getConnection();
		int r = -1;
		r = dao.deleteMember(conn, id);
		JDBCTemplate.close(conn);
		return r;
	}


}