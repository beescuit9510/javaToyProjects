package kr.or.iei.book.dao;

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
import kr.or.iei.book.vo.Book;
import kr.or.iei.book.vo.Member;
import kr.or.iei.book.vo.Rent;

public class LibraryDao {

	private String insertMember = null;
	private String insertBook = null;
	private String insertRent = null;
	private String select = null;
	private String selectMyInfo = null;
	private String selectBook = null;
	private String selectMember = null;
	private String selectRent = null;
	private String selectRentByNo = null;
	private String selectBookbyNo = null;
	private String updateBook = null;
	private String chekcRent = null;
	private String updateRent = null;
	{
		try (FileReader fr = new FileReader("resources/libraryQuery.properties");) {
			Properties prop = new Properties();
			prop.load(fr);
			select = prop.getProperty("select");
			selectMyInfo = prop.getProperty("selectMyInfo");
			selectBook = prop.getProperty("selectBook");
			selectMember = prop.getProperty("selectMember");
			selectRent = prop.getProperty("selectRent");
			selectRentByNo = prop.getProperty("selectRentByNo");
			selectBookbyNo = prop.getProperty("selectBookbyNo");
			insertMember = prop.getProperty("insertMember");
			insertBook = prop.getProperty("insertBook");
			insertRent = prop.getProperty("insertRent");
			updateBook = prop.getProperty("updateBook");
			chekcRent = prop.getProperty("chekcRent");
			updateRent = prop.getProperty("updateRent");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public Member login(Connection conn, String[] idPw) {
		Member m = null;
		PreparedStatement state = null;
		ResultSet r = null;
		try {
			state = conn.prepareStatement(select);

			int i = 1;
			for (String str : idPw) {
				state.setString(i++, str);
			}

			r = state.executeQuery();

			if (r.next())
				m = getMember(r);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(state);
			JDBCTemplate.close(r);
		}

		return m;
	}

	public Member login(Connection conn, int no) {
		Member m = null;
		PreparedStatement state = null;
		ResultSet r = null;
		try {

			state = conn.prepareStatement(selectMyInfo);
			state.setInt(1, no);
			state.setInt(2, no);

			r = state.executeQuery();

			if (r.next())
				m = getMemberWithRent(r);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(state);
			JDBCTemplate.close(r);
		}

		return m;
	}

	public int insert(Connection conn, String[] list, char ch) {
		String query = ch == 'M' ? insertMember : insertBook;
		int r = -1;
		PreparedStatement state = null;
		try {

			state = conn.prepareStatement(query);

			int i = 1;
			for (String str : list) {
				if (i == 5)
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

	public ArrayList<Object> select(Connection conn, char ch) {
		String query = ch == 'M' ? selectMember : ch == 'R' ? selectRent : selectBook;
		ArrayList<Object> objects = new ArrayList<>();
		PreparedStatement state = null;
		ResultSet r = null;
		try {

			state = conn.prepareStatement(query);
			r = state.executeQuery();

			while (r.next()) {
				if (ch == 'R')
					objects.add((Object) getRent(r));
				else if (ch == 'B')
					objects.add((Object) getBook(r));
				else if (ch == 'M')
					objects.add((Object) getMember(r));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(state);
			JDBCTemplate.close(r);
		}

		return objects;
	}

	public Rent getRent(ResultSet r) throws SQLException {
		return new Rent(r.getInt(1), r.getString(2), r.getInt(3), r.getString(4), r.getDate(5), r.getDate(6), r.getInt(7));
	}

	public Member getMember(ResultSet r) throws SQLException {
		return new Member(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5), r.getInt(6));
	}

	public Member getMemberWithRent(ResultSet r) throws SQLException {
		return new Member(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5), r.getInt(6),
				r.getInt(7));
	}

	public Book getBook(ResultSet r) throws SQLException {
		return new Book(r.getInt(1), r.getString(2), r.getString(3), r.getString(4), r.getString(5), r.getInt(6));
	}

	public ArrayList<Rent> select(Connection conn, int memberNo) {
		ArrayList<Rent> rents = new ArrayList<>();
		PreparedStatement state = null;
		ResultSet r = null;

		try {
			state = conn.prepareStatement(selectRentByNo);
			state.setInt(1, memberNo);
			r = state.executeQuery();

			while (r.next()) {
				rents.add(getRent(r));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(state);
			JDBCTemplate.close(r);
		}

		return rents;
	}

	public Book checkStock(Connection conn, int bookNo) {

		PreparedStatement state = null;
		ResultSet r = null;
		Book book = null;

		try {
			state = conn.prepareStatement(selectBookbyNo);
			state.setInt(1, bookNo);
			r = state.executeQuery();

			if (r.next()) {
				book = getBook(r);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(state);
			JDBCTemplate.close(r);
		}

		return book;
	}

	public int insertBookIntoRent(Connection conn, Book book, int memberNo) {
		PreparedStatement state = null;
		int r = -1;
		try {
			state = conn.prepareStatement(insertRent);
			state.setInt(1, memberNo);
			state.setInt(2, book.getBook_no());
			state.setString(3, book.getTitle());
			r = state.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(state);
		}
		return r;
	}

	public int updateBook(Connection conn, int book_no, int howMany) {
		PreparedStatement state = null;
		int r = -1;
		try {
			state = conn.prepareStatement(updateBook);
			state.setInt(1, howMany);
			state.setInt(2, book_no);
			r = state.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(state);
		}
		return r;
	}

	public Rent checkRent(Connection conn, int memberNo, int rentNo) {
		PreparedStatement state = null;
		ResultSet r = null;
		Rent rent = null;
		try {
			state = conn.prepareStatement(chekcRent);
			state.setInt(1, memberNo);
			state.setInt(2, rentNo);
			r = state.executeQuery();
			if (r.next())
				rent = getRent(r);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(state);
			JDBCTemplate.close(r);
		}
		return rent;
	}

	public int updateRent(Connection conn, int rent_no, int bookStatus) {
		PreparedStatement state = null;
		int r = -1;
		try {
			state = conn.prepareStatement(updateRent);
			state.setInt(1, bookStatus);
			state.setInt(2, rent_no);
			r = state.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(state);
		}
		return r;
	}

}
