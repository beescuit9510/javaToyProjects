package kh.java.vo;

public class Silver {
	
	private String grade;
	private String name;
	private int point;
	private double bonus = 0.02;
	
	
	
	public Silver() {
	}
	public Silver(String grade, String name, int point) {
		this.grade = grade;
		this.name = name;
		this.point = point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBonus() {
		return this.point*this.bonus;
	}
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

}
	