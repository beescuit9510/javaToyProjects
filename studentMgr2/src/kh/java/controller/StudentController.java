package kh.java.controller;

import java.util.ArrayList;
import java.util.Scanner;

import kh.java.vo.Student;

public class StudentController {
	Scanner sc;
	ArrayList<Student> students;

	public StudentController() {
		sc = new Scanner(System.in);
		students = new ArrayList<Student>();
	}

	public void main() {

		while (true) {
			System.out.println("\n============학생관리 프로그램v1=============\n");
			System.out.println("1. 학생 정보 등록");
			System.out.println("2. 학생 정보 출력(등록된 전체학생)");
			System.out.println("3. 학생 정보 출력(1명 이름으로 검색)");
			System.out.println("4. 학생 정보 수정");
			System.out.println("5. 학생 정보 삭제");
			System.out.println("0. 프로그램종료");
			System.out.printf("선택 > ");
			int sel = sc.nextInt();

			switch (sel) {
			case 1:
				insertStudent();
				break;

			case 2:
				printAllStudents();
				break;

			case 3:
				printOneStudent();
				break;

			case 4:
				editStudent();
				break;
			case 5:

				deleteStudent();
				break;

			case 0:
				System.out.println("Bye ~ ");
				return;

			default:
				System.out.println("잘못입력하셨습니다.");
				break;
			}
		}
	}

	private void insertStudent() {
		System.out.println("enter your name/age/address : ");
		students.add(new Student(sc.next(), sc.nextInt(), sc.next()));
	}

	private void printAllStudents() {
		for (Student s : students) {
			System.out.println(s);
		}
	}

	private void printOneStudent() {
		System.out.println(searchStudent(findName()));
	}

	private void editStudent() {
		students.remove(searchStudent(findName()));
		insertStudent();
	}

	private void deleteStudent() {
		students.remove(searchStudent(findName()));
	}

	private Student searchStudent(String name) {
		for (Student s : students) {
			if (s.getName().equals(name)) {
				return s;
			}
		}
		return null;
	}

	private String findName() {
		System.out.println("enter name ");
		return sc.next();

	}

}
