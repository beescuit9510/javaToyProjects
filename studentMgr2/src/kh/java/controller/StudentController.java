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
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
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
