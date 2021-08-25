package kr.or.iei.book.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import kr.or.iei.book.dao.LibraryDao;
import kr.or.iei.book.vo.Book;
import kr.or.iei.book.vo.Member;
import kr.or.iei.book.vo.Rent;

public class LibraryService {

	LibraryDao dao = new LibraryDao();

	public Member login(String[] idPw) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = null;
		m = dao.login(conn, idPw);
		JDBCTemplate.close(conn);
		return m;
	}
	
	public Member login(int no) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = null;
		m = dao.login(conn, no);
		JDBCTemplate.close(conn);
		return m;
	}

	public ArrayList<Object> select(char ch) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Object> objects = dao.select(conn, ch);
		JDBCTemplate.close(conn);
		return objects;
	}

	public int insert(String[] list, char ch) {
		Connection conn = JDBCTemplate.getConnection();
		int r = -1;
		r = dao.insert(conn, list, ch);

		if (r > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(conn);

		return r;
	}

	public ArrayList<Rent> selectRentList(int no) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Rent> r = dao.select(conn, no);
		JDBCTemplate.close(conn);
		return r;
	}

	public int returnBook(int memberNo, int rentNo) {
		Connection conn = JDBCTemplate.getConnection();
		int r = -1;
		Rent rent = null;
		rent = dao.checkRent(conn, memberNo, rentNo);

		if (rent!=null)
			r = dao.updateRent(conn, rent.getRent_no(), 0);
		
		if (r > 0)
			r = dao.updateBook(conn, rent.getBook_no(), 1);
		
		if (r > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(conn);

		return r;
	}

	public int borrowBook(int memberNo, int bookNo) {
		Connection conn = JDBCTemplate.getConnection();
		int r = -1;
		Book book = null;
		book = dao.checkStock(conn, bookNo);

		if (book!=null)
			r = dao.insertBookIntoRent(conn, book, memberNo);
		
		if (r > 0)
			r = dao.updateBook(conn, book.getBook_no(), -1);
		
		if (r > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}

		JDBCTemplate.close(conn);

		return r;
	}

}
