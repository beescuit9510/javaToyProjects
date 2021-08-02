package kh.java.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import kh.java.vo.*;
//ctrl + shift + F 
// ctrl + shift + o;

public class PointMgr {

	private Scanner sc;
	private HashMap<String, Grade> members;

	public PointMgr() {
		sc = new Scanner(System.in);
		members = new HashMap<String, Grade>();
	}

	public void main() {
		while (true) {
			System.out.println("\n============= ����Ʈ ���� ���α׷�v6 ===========\n");
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

	public void insertMember(boolean isbeingEditted) {
		System.out.println(isbeingEditted ? "" : "================== ȸ�� ���� ��� ================");
		System.out.printf("���[silver/gold/vip/Vvip]/�̸�/����Ʈ �Է� (����� ����) : ");
		String grade = sc.next();
		String name = sc.next();
		if (members.containsKey(name)) {
			System.out.println("�̹� ��ϵ� ȸ�� �Դϴ�. �ٽ� �õ� ���ּ���.");
			sc.nextLine();
			insertMember(false);
			return;
		}
		if (grade.equalsIgnoreCase("silver"))
			members.put(name, new Silver(grade, name, sc.nextInt()));
		if (grade.equalsIgnoreCase("Gold"))
			members.put(name, new Gold(grade, name, sc.nextInt()));
		if (grade.equalsIgnoreCase("Vip"))
			members.put(name, new Vip(grade, name, sc.nextInt()));
		if (grade.equalsIgnoreCase("Vvip"))
			members.put(name, new Vvip(grade, name, sc.nextInt()));
		System.out.println(isbeingEditted ? "" : "��� �Ϸ�!");

	}

	public void printAllMember() {
		System.out.println("================== ��ü ȸ�� ���� ��� ================");
		System.out.println("���\t�̸�\t����Ʈ\t���ʽ�");
		for (Grade g : members.values()) {
			System.out.println(g);
		}

	}

	public void printOneMember() {
		System.out.println("================== ȸ�� ���� ��� (1��) ================");
		System.out.println("��ȸ �� ȸ�� �̸� �Է� : ");
		String name = searchMember(sc.next());
		System.out.println(name == null ? "" : members.get(name));
	}

	public void updateMember() {
		System.out.println("================== ȸ�� ���� ���� ================");
		System.out.println("���� �� ȸ�� �̸� �Է� : ");
		if (members.remove(searchMember(sc.next())) == null) {
			System.out.println("���� ���� !");
		} else {
			insertMember(true);
			System.out.println("���� ���� !");
		}

	}

	public void deleteMember() {
		System.out.println("================== ȸ�� ���� ���� ================");
		System.out.println("���� �� ȸ�� �̸� �Է� : ");
		System.out.println(members.remove(searchMember(sc.next())) == null ? "���� ����!" : "���� ����!");
	}

	public String searchMember(String name) {
		// System.out.println("�̸� �Է� : ");
		// String name = sc.next();
		if (members.containsKey(name)) {
			return name;
		}
		System.out.println("ȸ�� ������ ã�� �� �����ϴ�.");
		return null;
	}

}
