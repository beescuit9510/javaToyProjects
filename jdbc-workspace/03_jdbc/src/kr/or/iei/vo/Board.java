package kr.or.iei.vo;

import java.sql.Date;

public class Board {

	private int board_no;
	private String board_title;
	private String board_content;
	private int board_writer;
	private int board_count;
	private Date enroll_date;

	public Board() {
	}

	public Board(int board_no, String board_title, String board_content, int board_writer, int board_count,
			Date enroll_date) {
		super();
		this.board_no = board_no;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_writer = board_writer;
		this.board_count = board_count;
		this.enroll_date = enroll_date;
	}

	public int getBoard_no() {
		return board_no;
	}

	public void setBoard_no(int board_no) {
		this.board_no = board_no;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public String getBoard_writer() {
		String writer = this.board_writer == 0 ? "탈퇴한 회원" : this.board_writer + "";
		return writer;
	}

	public void setBoard_writer(int board_writer) {
		this.board_writer = board_writer;
	}

	public int getBoard_count() {
		return board_count;
	}

	public void setBoard_count(int board_count) {
		this.board_count = board_count;
	}

	public Date getEnroll_date() {
		return enroll_date;
	}

	public void setEnroll_date(Date enroll_date) {
		this.enroll_date = enroll_date;
	}

	@Override
	public String toString() {
		return board_no + "\t" + board_title + "\t" + getBoard_writer() + "\t" + board_count + "\t" + enroll_date;
	}

}
