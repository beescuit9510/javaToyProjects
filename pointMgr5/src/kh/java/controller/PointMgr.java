package kh.java.controller;

import java.util.ArrayList;
import java.util.Scanner;
import kh.java.vo.*;
//ctrl + shift + F 
// ctrl + shift + o;

public class PointMgr {

	private Scanner sc;
	private ArrayList<Grade> members;

	public PointMgr() {
		sc = new Scanner(System.in);
		members = new ArrayList<Grade>();
	}

	public void main() {
		while (true) {
			System.out.println("\n============= ����Ʈ ���� ���α׷�v5 ===========\n");
			System.out.println("1. ȸ�� ���� ���");
			System.out.println("2. ��ü ȸ�� ��ȸ");
			System.out.println("3. ȸ�� 1�� ��ȸ");
			System.out.println("4. ȸ�� ���� ����");
			System.out.println("5. ȸ�� ����");
			System.out.println("0. ���α׷� ����");
			System.out.printf("���� > ");
			int sel = sc.nextInt();

			switch (sel) {
			case 1:
				insertMember(false);
				break;
			case 2:
				printAllMember();
				break;
			case 3:
				printOneMember();
				break;
			case 4:
				updateMember();
				break;
			case 5:
				deleteMember();
				break;
			case 0:
				System.out.println("���α׷� ���� ~~ ");
				return;

			default:
				System.out.println("�߸��Է��ϼ̽��ϴ�.");
				break;
			}
		}
	}

	public void insertMember(boolean isEditting) {
		if(!isEditting) {
			System.out.println("================== ȸ�� ���� ��� ================");			
		}
		System.out.printf("���[silver/gold/vip/Vvip]/�̸�/����Ʈ �Է� (����� ����) : ");
		String grade = sc.next();
		if (grade.equalsIgnoreCase("silver"))
			members.add(new Silver(grade,sc.next(),sc.nextInt()));
		if (grade.equalsIgnoreCase("Gold"))
			members.add(new Gold(grade,sc.next(),sc.nextInt()));
		if (grade.equalsIgnoreCase("Vip"))
			members.add(new Vip(grade,sc.next(),sc.nextInt()));
		if (grade.equalsIgnoreCase("Vvip"))
			members.add(new Vvip(grade,sc.next(),sc.nextInt()));
		System.out.println(isEditting? "���� �Ϸ�!":"��� �Ϸ�!");

	}

	public void printAllMember() {
		System.out.println("================== ��ü ȸ�� ���� ��� ================");
		System.out.println("���\t�̸�\t����Ʈ\t���ʽ�");
		for (Grade g : members) {
			System.out.println(g);
		}

	}

	public void printOneMember() {
		System.out.println("================== ȸ�� ���� ��� (1��) ================");
		System.out.println("��ȸ �� ȸ�� �̸� �Է� : ");
		Grade m = searchMember(sc.next());
		if(m==null) {
			System.out.println("ȸ�� ������ ã�� �� �����ϴ�.");
		}else {
			System.out.println(m);
		}
	}	

	public void updateMember() {
		System.out.println("================== ȸ�� ���� ���� ================");
		System.out.println("���� �� ȸ�� �̸� �Է� : ");
		Grade m = searchMember(sc.next());
		if (m == null) {
			System.out.println("ȸ�� ������ ã�� �� �����ϴ�.");
		}else {
			members.remove(m);
			insertMember(true);
		}

	}

	public void deleteMember() {
		System.out.println("================== ȸ�� ���� ���� ================");
		System.out.println("���� �� ȸ�� �̸� �Է� : ");
		Grade m = searchMember(sc.next());
		if(m ==null) {
			System.out.println("ȸ�� ������ ã�� �� �����ϴ�.");
		}else {
			members.remove(m);
			System.out.println("���� �Ϸ�!");
		}

	}

	public Grade searchMember(String name) {
		for(Grade m : members) {
			if (name.equals(m.getName())) {
				return m;
			}
		}
		return null;
	}

}
