package kr.or.iei.vo;

import java.sql.Date;

public class Room {
	private int room_no;
	private String room_area;
	private String room_field;
	private String room_number;
	private Date rent_date;

	public Room(int room_no, String room_area, String room_field, String room_number, Date rent_date) {
		super();
		this.room_no = room_no;
		this.room_area = room_area;
		this.room_field = room_field;
		this.room_number = room_number;
		this.rent_date = rent_date;
	}

	public int getRoom_no() {
		return room_no;
	}

	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}

	public String getRoom_area() {
		return room_area;
	}

	public void setRoom_area(String room_area) {
		this.room_area = room_area;
	}

	public String getRoom_field() {
		return room_field;
	}

	public void setRoom_field(String room_field) {
		this.room_field = room_field;
	}

	public String getRoom_number() {
		return room_number;
	}

	public void setRoom_number(String room_number) {
		this.room_number = room_number;
	}

	
	public String getRent_date() {
		if(rent_date==null)
			return "예약가능";
		else
			return "예약불가";
	}

	public void setRent_date(Date rent_date) {
		this.rent_date = rent_date;
	}

	@Override
	public String toString() {
		return room_no + "\t" + room_area + "\t" + room_field + "\t" + room_number+"\t"+getRent_date();
	}

}
