package kh.java.func;

// Ctrl + shift + f 
// alt + shift + a !! ALT + SHIFT + A !!!!!!!! MUltiple cursors!!!!!!!!!
// alt + shift + a !! ALT + SHIFT + A !!!!!!!! MUltiple cursors!!!!!!!!!
// alt + shift + a !! ALT + SHIFT + A !!!!!!!! MUltiple cursors!!!!!!!!!
// alt + shift + a !! ALT + SHIFT + A !!!!!!!! MUltiple cursors!!!!!!!!!
// alt + shift + a !! ALT + SHIFT + A !!!!!!!! MUltiple cursors!!!!!!!!!
// 壕壱督 ぬぬぬぬぬぬぬぬぬぬぬぬぬぬぬぬぬぬぬぬぬぬぬぬ


//CRUD
//CRUD
//CRUD
//CRUD
//CRUD
//CRUD
//CRUD
//CRUD
//CRUD
//CRUD
//Create/Read/Update/Delete
//Create/Read/Update/Delete
//Create/Read/Update/Delete
//Create/Read/Update/Delete
//Create/Read/Update/Delete
//Create/Read/Update/Delete
//Create/Read/Update/Delete
//Create/Read/Update/Delete
//Create/Read/Update/Delete
//Create/Read/Update/Delete
//Create/Read/Update/Delete
//Create/Read/Update/Delete
//Create/Read/Update/Delete

public class Student {
	private int stuID;
	private String name;
	private int age;
	private String address;
	private String phoneNum;
	private char gender;
	static int count;
	
	static {
		System.out.println("class variable initialization");
	}
	
	{
		stuID = ++count;
	}

	public Student() {

	}

	public Student(String name, int age, String address, String phoneNum, char gender) {
//		this.stuID = stuID;
		this.name = name;
		this.age = age;
		this.address = address;
		this.phoneNum = phoneNum;
		this.gender = gender;
	}
	
	public Student(Student s) {
		this(s.name,s.age,s.address,s.phoneNum,s.gender);
	}

	public int getStuId() {
		return stuID;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public char getGender() {
		return gender;
	}

//	public void setStuId(int stuID) {
//		this.stuID = stuID;
//	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;

	}

	public void setAddress(String address) {
		this.address = address;

	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public void setGender(char gender) {
		this.gender = gender;

	}

}
