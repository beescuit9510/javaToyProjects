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
		System.out.println("\n============�л����� ���α׷�v5=============\n");
		System.out.println("1. �л� ���� ���");
		System.out.println("2. �л� ���� ���(��ϵ� ��ü�л�)");
		System.out.println("3. �л� ���� ���(1�� �̸����� �˻�)");
		System.out.println("4. �л� ���� ����");
		System.out.println("5. �л� ���� ����");
		System.out.println("0. ���α׷�����");
		System.out.printf("���� > ");
		return sc.nextInt();

	}

	public StringTokenizer add() {
		sc.nextLine();
		System.out.println("�л� �̸�/����/�ּ� �Է� : ");
		return new StringTokenizer(sc.nextLine(), "/");
	}
	
	public String searchName() {
		sc.nextLine();
		System.out.println("�̸� �Է� : ");
		return sc.next();
	}
	
	
	public StringTokenizer insertStudnet() {
		System.out.println("=========== �л� ���� �Է� ============");
		return add();
	}

	public void printStudent(ArrayList<Student> students) {
		System.out.println("=========== �л� ���� ��� ============");
		System.out.println("name\tage\taddress");
		for(Student s : students){
			System.out.println(s);
		}
	}
	
	public void printOneStudent(ArrayList<Student> sts, int index) {
		System.out.println("=========== �л� ���� ��ü ============");
		if(index==-1) {
			System.out.println("�׷� �л��� �����ϴ�.");
			return;
		}
		System.out.println(sts.get(index));
	
	}
	
	public String updateStudent() {
		System.out.println("=========== �л� ���� ���� ============");
		return searchName();		
	}
	
	public String deleteStudent() {
		System.out.println("=========== �л� ���� ���� ============");
		return searchName();		
		
	}
	
	public void fail() {
		System.out.println("���� !");
	}
	
	public void success() {
		System.out.println("���� !");
	}
	

}