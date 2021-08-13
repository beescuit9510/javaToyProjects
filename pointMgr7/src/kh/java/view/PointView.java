package kh.java.view;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import kh.java.vo.Gold;
import kh.java.vo.Grade;
import kh.java.vo.Silver;
import kh.java.vo.Vip;

public class PointView {
	Scanner sc = new Scanner(System.in);

	public int main() {
		System.out.println("----------ȸ�� ���� ���α׷� v7-----------");
		System.out.println("1.ȸ�� ���");
		System.out.println("2.ȸ�� ��ü ���� ���");
		System.out.println("3.ȸ�� 1�� ���");
		System.out.println("4.ȸ�� ���� ����");
		System.out.println("5.ȸ�� ���� ����");
		System.out.println("0.���α׷� ����");
		System.out.println("���� > ");
		int sel = sc.nextInt();
		if (sel == 0)
			System.out.println("���α׷��� ���� �մϴ�.");
		if (sel > 5)
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		
		return sel;
	}

	public void register() {
		System.out.println("----------ȸ�� ���-----------");
	}

	public Grade addMember() {
		sc.nextLine();
		System.out.println("ȸ�� �̸�/���/����Ʈ �Է� (/�� ����) : ");
		StringTokenizer str =  new StringTokenizer(sc.nextLine(), "/");
		
		String name = str.nextToken();
		String grade = str.nextToken();
		int point = Integer.parseInt(str.nextToken());
		
		if (grade.equalsIgnoreCase("gold")) {
			return new Gold(grade, name, point);
		} else if (grade.equalsIgnoreCase("silver")) {
			return new Silver(grade, name, point);
		} else if (grade.equalsIgnoreCase("vip")) {
			return new Vip(grade, name, point);
		}
		return null;
	}
	
	public void printAllMember(ArrayList<Grade> arr) {
		System.out.println("----------ȸ�� ��ü ���-----------");
		System.out.println("���\t�̸�\t����Ʈ\t���ʽ�");
		for (Grade g : arr) {
			System.out.println(g);
		}
		System.out.println("��ü ��� �Ϸ�!");

	}

	public void printMember() {
		System.out.println("----------ȸ�� ���(1��)-----------");
	}

	public void printMember(Grade member) {
		System.out.println(member);
	}

	public void editMember() {
		System.out.println("----------ȸ�� ���� ����-----------");
	}

	public void deleteMember() {
		System.out.println("----------ȸ�� ���� ����-----------");
	}

	public String findMember() {
		System.out.println("ã���ô� ȸ���� �̸� �˻� : ");
		return sc.next();
	}

	public void noMemberInList() {
		System.out.println("ã���ô� ȸ���� ��ϵǾ����� ���� ȸ���Դϴ�.");
	}

	public void suceed() {
		System.out.println("���� !");
		System.out.println();
		System.out.println();

	}

	public void fail() {
		System.out.println("���� !");
		System.out.println();
		System.out.println();
	}

}
