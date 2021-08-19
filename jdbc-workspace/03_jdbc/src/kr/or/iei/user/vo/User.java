package kr.or.iei.user.vo;

public class User {

	private int userNo;
	private String userId;
	private String userPw;
	private String userName;
	private int userAge;
	private String userPhone;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(int userNo, String userId, String userPw, String userName, int userAge, String userPhone) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userAge = userAge;
		this.userPhone = userPhone;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	@Override
	public String toString() {
		return userNo + "\t" + userId + "\t" + userPw + "\t" + userName + "\t" + userAge + "\t" + userPhone;
	}

}
