package kh.java.controller;

import java.util.Scanner;
import kh.java.vo.*;
//ctrl + shift + F 
// ctrl + shift + o;

public class PointMgr {

	private Scanner sc;
	private Grade[] members;
	private int index;

	public PointMgr() {
		sc = new Scanner(System.in);
		members = new Grade[40];
		index = 0;
	}

	public void main() {
		while (true) {
			System.out.println("\n============= ����Ʈ ���� ���α׷�v4 ===========\n");
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
				insertMember();
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

	public void insertMember() {
		System.out.println("================== ȸ�� ���� ��� ================");
		add(index, true, false);
		System.out.println("��� �Ϸ�!");

	}

	public void printAllMember() {
		System.out.println("================== ��ü ȸ�� ���� ��� ================");
		System.out.println("���\t�̸�\t����Ʈ\t���ʽ�");
		for (int i = 0; i < index; i++) {
			System.out.printf("%s\t%s\t%d\t%.4f%n", members[i].getGrade(), members[i].getName(), members[i].getPoint(),
					members[i].getBonus());
		}

	}

	public void printOneMember() {
		System.out.println("================== ȸ�� ���� ��� (1��) ================");
		System.out.println("��ȸ �� ȸ�� �̸� �Է� : ");
		int i = searchIndex(sc.next());
		if (i == -1) {
			System.out.println("ȸ�� ������ ã�� �� �����ϴ�.");
			return;
		}
		System.out.printf("%s\t%s\t%d\t%.4f%n", members[i].getGrade(), members[i].getName(), members[i].getPoint(),
				members[i].getBonus());
		System.out.println("��� �Ϸ�!");

	}

	public void updateMember() {
		System.out.println("================== ȸ�� ���� ���� ================");
		System.out.println("���� �� ȸ�� �̸� �Է� : ");
		int i = searchIndex(sc.next());
		if (i == -1) {
			System.out.println("ȸ�� ������ ã�� �� �����ϴ�.");
			return;
		}
		add(i, false, true);
		System.out.println("���� �Ϸ�!");

	}

	public void deleteMember() {
		System.out.println("================== ȸ�� ���� ���� ================");
		System.out.println("���� �� ȸ�� �̸� �Է� : ");
		int i = searchIndex(sc.next());
		if (i == -1) {
			System.out.println("ȸ�� ������ ã�� �� �����ϴ�.");
			return;
		}
		for (int j = i; j < index - 1; j++) {
			members[j] = members[j + 1];
		}
		members[--index] = null;
		System.out.println("���� �Ϸ�!");

	}

	public int searchIndex(String name) {
		for (int i = 0; i < index; i++) {
			if (name.equals(members[i].getName())) {
				return i;
			}
		}
		return -1;
	}

	public void add(int i, boolean isInstanceIndex, boolean isEditting) {
		int j = -1;
		String grade;
		String name;
		do {
			sc.nextLine();
			System.out.printf("���[silver/gold/vip/Vvip]/�̸�/����Ʈ �Է� (����� ����) : ");
			grade = sc.next();
			name = sc.next();
			j = searchIndex(name);
			if (j != -1) {
				if (isEditting && members[j].getName().equals(name)) {
					break;
				}
				System.out.println("�̹� ������� �̸� �Դϴ�.");
			}
		} while (j != -1);
		if (grade.equalsIgnoreCase("silver"))
			members[i++] = new Silver(grade, name, sc.nextInt());
		if (grade.equalsIgnoreCase("Gold"))
			members[i++] = new Gold(grade, name, sc.nextInt());
		if (grade.equalsIgnoreCase("Vip"))
			members[i++] = new Vip(grade, name, sc.nextInt());
		if (grade.equalsIgnoreCase("Vvip"))
			members[i++] = new Vvip(grade, name, sc.nextInt());
		if (isInstanceIndex) {
			index++;
		}
	}

}
