package kr.or.iei.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.iei.vo.Board;

public class BoardDao {

	final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final String USER = "JDBC1";
	final String PW = "1234";
	final String DRIVER = "oracle.jdbc.driver.OracleDriver";
//	final String KH_URL = "jdbc:oracle:thin:@1.220.236.74:15212:xe";

	{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Board[] selectPost(int board_no, boolean ReadAll) throws SQLException {

		String board_content = ReadAll ? "" : ", board_content";
		String boardNo = ReadAll ? " -1 = ?" : "board_no = ?";
		String query = "select board_no, board_title, board_writer, board_count, enroll_date " + board_content
				+ " from board_tbl where " + boardNo + " order by board_no ";
		String boardCount = "update board_tbl set board_count = board_count+1 where " + boardNo;

		String count = "select count(*) from board_tbl";

		Connection conn = DriverManager.getConnection(URL, USER, PW);
		PreparedStatement prepared = null;
		if (!ReadAll) {
			prepared = conn.prepareStatement(boardCount);
			prepared.setInt(1, board_no);
			prepared.executeQuery();
		}

		int c = 1;
		if (ReadAll) {
			prepared = conn.prepareStatement(count);
			ResultSet countR = prepared.executeQuery();
			if (countR.next())
				c = countR.getInt(1);
		}

		prepared = conn.prepareStatement(query);
		prepared.setInt(1, board_no);
		ResultSet r = prepared.executeQuery();
		Board[] posts = new Board[c];
		int i = 0;
		while (r.next()) {
			String content = ReadAll ? "" : r.getString(6);
			posts[i++] = new Board(r.getInt(1), r.getString(2), content, r.getInt(3), r.getInt(4), r.getDate(5));
		}

		conn.close();
		prepared.close();
		r.close();
		return posts;

	}

	public int deletePost(int board_no) throws SQLException {
		Connection conn = DriverManager.getConnection(URL, USER, PW);
		String query = "delete from board_tbl where board_no = ?";
		PreparedStatement prepared = conn.prepareStatement(query);

		prepared.setInt(1, board_no);
		int r = prepared.executeUpdate();

		if (r > 0)
			conn.commit();
		else
			conn.rollback();

		conn.close();
		prepared.close();
		return r;
	}

	public boolean isBoardWriter(int board_no, int user_no) throws SQLException {
		String query = "select * from board_tbl where board_no = ? ";
		Connection conn = DriverManager.getConnection(URL, USER, PW);
		PreparedStatement prepared = conn.prepareStatement(query);
		prepared.setInt(1, board_no);

		ResultSet r = prepared.executeQuery();
		boolean boolR = false;
		if (r.next()) {
			boolR = r.getInt("board_writer") == user_no;
		}

		conn.close();
		prepared.close();
		r.close();
		return boolR;
	}

	public int insertNdUpdatePost(String[] list, int board_no, boolean edit) throws SQLException {
		String editStr = "update board_tbl set board_title = ? , board_content = ? where board_no = '" + board_no + "'";
		String insert = "insert into board_tbl(board_no,board_title,board_content,board_writer,board_count,enroll_date) values(board_squ.nextval,?,?,?,0,sysdate)";
		String query = edit ? editStr : insert;
		Connection conn = DriverManager.getConnection(URL, USER, PW);
		PreparedStatement prepared = conn.prepareStatement(query);

		for (int i = 1; i < 3; i++) {
			prepared.setString(i, list[i - 1]);
		}

		if (!edit) {
			prepared.setInt(3, Integer.parseInt(list[2]));
		}

		int r = prepared.executeUpdate();

		if (r > 0)
			conn.commit();
		else
			conn.rollback();

		conn.close();
		prepared.close();
		return r;
	}

}
