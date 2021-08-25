package kr.or.iei.vo;

import java.sql.Date;

public class Rent {
	
    private int room_no       ; 
    private String member_name    ;
    private Date rent_date   ;
	
	
	public int getRoom_no() {
		return room_no;
	}


	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}


	public String getMember_name() {
		return member_name;
	}


	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}


	public Date getRent_date() {
		return rent_date;
	}


	public void setRent_date(Date rent_date) {
		this.rent_date = rent_date;
	}


	public Rent(int room_no, String member_name, Date rent_date) {
		super();
		this.room_no = room_no;
		this.member_name = member_name;
		this.rent_date = rent_date;
	}


	@Override
	public String toString() {
		return ""+room_no +"\t"+member_name +"\t"+ rent_date;
	}

    
}
