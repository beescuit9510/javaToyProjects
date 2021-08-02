package kh.java.view;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;
import kh.java.vo.Student;

public class StudentView {
	private Scanner sc;

	public StudentView() {
		super();
		sc = new Scanner(System.in);
		
	}

	public int showMainMenu() {
		System.out.println("\n============학생관리 프로그램v5=============\n");
		System.out.println("1. 학생 정보 등록");
		System.out.println("2. 학생 정보 출력(등록된 전체학생)");
		System.out.println("3. 학생 정보 출력(1명 이름으로 검색)");
		System.out.println("4. 학생 정보 수정");
		System.out.println("5. 학생 정보 삭제");
		System.out.println("0. 프로그램종료");
		System.out.printf("선택 > ");
		return sc.nextInt();

	}

	public StringTokenizer add() {
		sc.nextLine();
		System.out.println("학생 이름/나이/주소 입력 : ");
		return new StringTokenizer(sc.nextLine(), "/");
	}
	
	public String searchName() {
		sc.nextLine();
		System.out.println("이름 입력 : ");
		return sc.next();
	}
	
	
	public StringTokenizer insertStudnet() {
		System.out.println("=========== 학생 정보 입력 ============");
		return add();
	}

	public void printStudent(ArrayList<Student> students) {
		System.out.println("=========== 학생 정보 출력 ============");
		System.out.println("name\tage\taddress");
		for(Student s : students){
			System.out.println(s);
		}
	}
	
	public void printOneStudent(ArrayList<Student> sts, int index) {
		System.out.println("=========== 학생 정보 전체 ============");
		if(index==-1) {
			System.out.println("그런 학생은 없습니다.");
			return;
		}
		System.out.println(sts.get(index));
	
	}
	
	public String updateStudent() {
		System.out.println("=========== 학생 정보 수정 ============");
		return searchName();		
	}
	
	public String deleteStudent() {
		System.out.println("=========== 학생 정보 삭제 ============");
		return searchName();		
		
	}
	
	public void fail() {
		System.out.println("실패 !");
	}
	
	public void success() {
		System.out.println("성공 !");
	}
	

}