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
			System.out.println("\n============�л����� ���α׷�v1=============\n");
			System.out.println("1. �л� ���� ���");
			System.out.println("2. �л� ���� ���(��ϵ� ��ü�л�)");
			System.out.println("3. �л� ���� ���(1�� �̸����� �˻�)");
			System.out.println("4. �л� ���� ����");
			System.out.println("5. �л� ���� ����");
			System.out.println("0. ���α׷�����");
			System.out.printf("���� > ");
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
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
				break;
			}
		}
	}

	private void insertStudent(boolean isbeingEditted) {
		System.out.printf(isbeingEditted ? "" : "================ �л� ���� �Է� ================%n");
		System.out.println("�л��� �̸�/����/�ּ� �Է� : ");
		String name = sc.next();
		if (students.containsKey(name)) {
			System.out.println("�̹� ��ϵ� �̸��Դϴ�. �ٽ� �Է� ���ּ���.");
			sc.nextLine();
			insertStudent(true);
			return;
		} else {
			students.put(name, new Student(name, sc.nextInt(), sc.next()));
		}
		System.out.printf(isbeingEditted ? "" : "��� �Ϸ� !%n");
	}

	private void printAllStudents() {
		System.out.println("================ �л� ���� ��� ================");
		System.out.println("�̸�\t����\t�ּ�\t");
		for (Student s : students.values()) {
			System.out.println(s);
		}
	}

	private void printOneStudent() {
		System.out.println("================ �л� ���� ���(1��) ================");
		Student s = students.get(searchKey());
		System.out.println("�̸�\t����\t�ּ�\t");
		System.out.println(s == null ? "��� ���� !" : s);
	}

	private void editStudent() {
		System.out.println("================ �л� ���� ���� ================");
		if (students.remove(searchKey()) == null) {
			System.out.println("���� ����!");
			return;
		}
		insertStudent(true);
		System.out.println("���� ����!");
	}

	private void deleteStudent() {
		System.out.println("================ �л� ���� ���� ================");
		System.out.println(students.remove(searchKey()) == null ? "���� ����!" : "���� ����!");
	}

	private String searchKey() {
		System.out.println("�̸� �Է�  : ");
		String name = sc.next();
		if (students.containsKey(name))
			return name;
		System.out.println("��ϵ��� ���� �л��Դϴ�. ");
		return null;
	}

}
