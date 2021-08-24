package kr.or.iei.book.vo;

import java.sql.Date;

public class Rent {

	private int rent_no;
	private int member_no;
	private int book_no;
	private Date start_date;
	private Date end_date;
	private int rent_status;
	
	public Rent(int rent_no, int member_no, int book_no, Date start_date, Date end_date, int rent_status) {
		super();
		this.rent_no = rent_no;
		this.member_no = member_no;
		this.book_no = book_no;
		this.start_date = start_date;
		this.end_date = end_date;
		this.rent_status = rent_status;
	}
	public int getRent_no() {
		return rent_no;
	}
	public void setRent_no(int rent_no) {
		this.rent_no = rent_no;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public int getBook_no() {
		return book_no;
	}
	public void setBook_no(int book_no) {
		this.book_no = book_no;
	}
	public Date getStart_date() {
		return start_date;
	}
	public void setStart_date(Date start_date) {
		this.start_date = start_date;
	}
	public Date getEnd_date() {
		return end_date;
	}
	public void setEnd_date(Date end_date) {
		this.end_date = end_date;
	}
	public int getRent_status() {
		return rent_status;
	}
	public void setRent_status(int rent_status) {
		this.rent_status = rent_status;
	}

}
