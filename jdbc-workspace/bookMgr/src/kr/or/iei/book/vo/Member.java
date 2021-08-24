package kr.or.iei.book.vo;

public class Member {

	private int Member_no;
	private String id;
	private String pw;
	private String name;
	private String phone;
	private int grade;

	public Member(int member_no, String id, String pw, String name, String phone, int grade) {
		super();
		Member_no = member_no;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.grade = grade;
	}

	public int getMember_no() {
		return Member_no;
	}

	public void setMember_no(int member_no) {
		Member_no = member_no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return Member_no +"\t"+ id +"\t"+ pw +"\t"+ name +"\t"+ phone +"\t"+grade;
	}
	

}
