package kh.java.controller;

import java.util.Scanner;

import kh.java.vo.Gold;
import kh.java.vo.Silver;
import kh.java.vo.Vip;

public class PointMgr {
	private Vip[] v;
	private Gold[] g;
	private Silver[] s;
	private Scanner sc;
	private int vIndex;
	private int gIndex;
	private int sIndex;
	

	
	public PointMgr() {
		v = new Vip[10];
		g = new Gold[10];
		s = new Silver[10];
		sc = new Scanner(System.in);
		sIndex = 0;
	}
	public void main() {

		while(true) {			
			System.out.println("\n============= ����Ʈ ���� ���α׷�v1 ===========\n");
			System.out.println("1. ȸ�� ���� ���");
			System.out.println("2. ��ü ȸ�� ��ȸ");
			System.out.println("3. ȸ�� 1�� ��ȸ");
			System.out.println("4. ȸ�� ���� ����");
			System.out.println("5. ȸ�� ����");
			System.out.println("0. ���α׷� ����");
			System.out.printf("���� > ");
			int sel = sc.nextInt();
			
			switch(sel) {
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
	
	
	public void insertMember   (){
		System.out.println("\n=============== ȸ�� ���� �Է� ==============\n");
		System.out.printf("���/�̸�/����Ʈ �Է� (����� ����): ");
		s[sIndex++] = new Silver(sc.next(), sc.next(), sc.nextInt());
		System.out.println("��� �Ϸ�!");
	}
	public void printAllMember (){
		System.out.println("\n=============== ��ü ȸ�� ���� ��� ==============\n");
		System.out.println("���\t�̸�\t����Ʈ\t���ʽ�");
		for(int i=0;i<sIndex;i++) {
			System.out.printf("%s\t%s\t%d\t%.4f%n",s[i].getGrade(), s[i].getName(), s[i].getPoint(), s[i].getBonus());
		}
	}
	public void printOneMember (){
	}
	public void updateMember   (){}
	public void deleteMember   (){}
	
	
	public int searchIndex(String name){
		for(int i=0;i<sIndex;i++) {
			if(s[i].getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}

}
