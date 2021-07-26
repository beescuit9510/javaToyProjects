package kh.java.controller;
import java.util.Scanner;
import kh.java.vo.Student;

public class StudentMgr {
	private Scanner sc;
	private Student[] students;
	private int index;
	
	public StudentMgr() {
		sc = new Scanner(System.in);
		students = new Student[10];
		index = 0;
	}
	
	public void main() {
		
//		run:
		while(true) {
			System.out.println("\n============�л����� ���α׷�v1=============\n");
			System.out.println("1. �л� ���� ���");
			System.out.println("2. �л� ���� ���(��ϵ� ��ü�л�)");
			System.out.println("3. �л� ���� ���(1�� �̸����� �˻�)");
			System.out.println("4. �л� ���� ����");
			System.out.println("5. �л� ���� ����");
			System.out.println("0. ���α׷�����");
			System.out.printf("���� > ");
			int sel = sc.nextInt();
			
			switch(sel) {
			case 1:
				insertStudent();
				break;
				
			case 2:
				printStudents();
				break;
				
			case 3:
				printStudent();
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
//				break run;
				
			default:
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
				break;
			}
			
		}
	}
	
	
	public void insertStudent() {
		System.out.println("\n---------------�л� ���� ���---------------\n");
		System.out.printf("�л� �̸�, ����, �ּ� �Է� (����� ����): ");
		students[index++] = new Student(sc.next(),sc.nextInt(),sc.nextLine());
	}
	
	
	public void printStudents() {
		System.out.println("\n---------------��ü �л� ���� ���---------------\n");
		System.out.println("�̸�\t����\t�ּ�\t");
		for(int i=0; i<index; i++) {
			System.out.printf("%s\t%d\t%s%n", students[i].getName(), students[i].getAge(), students[i].getAddr());
		}
	}
	
	
	public void printStudent() {
		System.out.println("\n---------------�л� ���� ��� (1��)---------------\n");
		int i = searchIndex();
		
		if(i>=0) {
			System.out.printf("%s\t%d\t%s%n", students[i].getName(), students[i].getAge(), students[i].getAddr());
			return;
		}
		System.out.println("�л� ������ �����ϴ�.");
	}
	
	
	public void editStudent() {
		System.out.println("\n---------------�л� ���� ����---------------\n");
		int i = searchIndex();
		
		if(i>=0) {
			while(true) {
//					sc.nextLine();
				System.out.printf("���� �Ͻ÷��� ���� (1)�̸�, (2)����, (3)�ּ� ,(4)����  : ");
				int sel = sc.nextInt();
				sc.nextLine();
				switch(sel) {
				case 4:
					return;
				case 1:
					System.out.print("���� �� �л� �̸� �Է� : ");
					students[i].setName(sc.next());
					break;
				case 2:
					System.out.print("���� �� �л� ���� �Է� : ");
					students[i].setAge(sc.nextInt());
					break;
				case 3:
					System.out.print("���� �� �л� �ּ� �Է�: ");
					students[i].setAddr(sc.nextLine());
					break;
				default:
					System.out.println("�߸��� �Է� �Դϴ�.");
					break;
					
				}
			}
		}
		System.out.println("�л� ������ �����ϴ�.");
	}
	
	
	public void deleteStudent() {
		System.out.println("\n---------------�л� ���� ����---------------\n");
		int i = searchIndex();
		
		if(i>=0) {
				for(int j=i;j<index-1;j++) {
					students[j] = students[j+1];
				}					
			System.out.println("���� �Ǿ����ϴ�.");
			index--;
			students[index]=null;
			return;
		}
		System.out.println("�л� ������ �����ϴ�.");
		
	}
	
	
	public int searchIndex() {
		System.out.printf("��ȸ �� �л� �̸� �Է� : ");
		String name = sc.next();
		for(int i=0; i<index; i++) {
			if(students[i].getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}


}
