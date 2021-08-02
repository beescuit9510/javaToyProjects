package kh.java.controller;

import java.util.HashMap;
import java.util.Scanner;
import kh.java.vo.Student;

public class StudentController {
	Scanner sc;
	HashMap<String, Student> students;

	public StudentController() {
		sc = new Scanner(System.in);
		students = new HashMap<String, Student>();
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
				insertStudent(false);
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

	private void insertStudent(boolean isbeingEditted) {
		System.out.printf(isbeingEditted ? "" : "================ 학생 정보 입력 ================%n");
		System.out.println("학생의 이름/나이/주소 입력 : ");
		String name = sc.next();
		if (students.containsKey(name)) {
			System.out.println("이미 등록된 이름입니다. 다시 입력 해주세요.");
			sc.nextLine();
			insertStudent(true);
			return;
		} else {
			students.put(name, new Student(name, sc.nextInt(), sc.next()));
		}
		System.out.printf(isbeingEditted ? "" : "등록 완료 !%n");
	}

	private void printAllStudents() {
		System.out.println("================ 학생 정보 출력 ================");
		System.out.println("이름\t나이\t주소\t");
		for (Student s : students.values()) {
			System.out.println(s);
		}
	}

	private void printOneStudent() {
		System.out.println("================ 학생 정보 출력(1인) ================");
		Student s = students.get(searchKey());
		System.out.println("이름\t나이\t주소\t");
		System.out.println(s == null ? "출력 실패 !" : s);
	}

	private void editStudent() {
		System.out.println("================ 학생 정보 수정 ================");
		if (students.remove(searchKey()) == null) {
			System.out.println("수정 실패!");
			return;
		}
		insertStudent(true);
		System.out.println("수정 성공!");
	}

	private void deleteStudent() {
		System.out.println("================ 학생 정보 삭제 ================");
		System.out.println(students.remove(searchKey()) == null ? "삭제 실패!" : "삭제 성공!");
	}

	private String searchKey() {
		System.out.println("이름 입력  : ");
		String name = sc.next();
		if (students.containsKey(name))
			return name;
		System.out.println("등록되지 않은 학생입니다. ");
		return null;
	}

}
