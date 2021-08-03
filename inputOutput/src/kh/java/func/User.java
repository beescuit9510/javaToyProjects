package kh.java.func;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = 111111111;
	private String id;
	private transient String pw;
	private String name;
	private String age;

	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String id, String pw, String name, String age) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return this.name+"\t"+this.age+"\t"+this.pw+"\t"+this.id;
	}
}
