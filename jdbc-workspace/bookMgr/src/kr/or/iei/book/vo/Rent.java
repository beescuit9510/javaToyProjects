package kr.or.iei.book.vo;

import java.sql.Date;

public class Rent {

	private int rent_no;
	private String member_name;
	private int book_no;
	private String title;
	private Date start_date;
	private Date end_date;
	private int rent_status;
	
	public Rent(int rent_no, String member_name, int book_no, String title, Date start_date, Date end_date, int rent_status) {
		super();
		this.rent_no = rent_no;
		this.member_name = member_name;
		this.book_no = book_no;
		this.title = title;
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
	public String getMember_no() {
		return member_name;
	}
	public void setMember_no(String member_name) {
		this.member_name = member_name;
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
	public String getRent_status() {
		return rent_status==1? "미반납":"반납완료";
	}
	public void setRent_status(int rent_status) {
		this.rent_status = rent_status;
	}
	@Override
	public String toString() {
		if(end_date==null)
			return "랜트번호 :" +rent_no + " 회원 이름 : " + member_name + " 도서번호: " + book_no + " 제목: " + title
					+ " 대여일: " + start_date + " 상태:" + getRent_status() ;
		
		return "랜트번호 :" +rent_no + " 회원 이름 : " + member_name + " 도서번호: " + book_no + " 제목: " + title
				+ " 대여일: " + start_date + " 반납일: " + end_date+ " 상태:" + getRent_status() ;
	}
	
	
	

}
