package kh.java.vo;

public class Student {
	
	private String name;
	private int age;
	private String addr;
	
	public Student() {}
	public Student(String name, int age, String addr) {
		this.name = name;
		this.age = age;
		this.addr = addr.substring(1);
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getAddr() {
		return addr;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
}
