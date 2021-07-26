package kh.java.controller;

import java.util.Scanner;

import kh.java.vo.Silver;

public class PointMgr {
	Silver[] silvers;
	Scanner sc;
	int index;
	

	
	public PointMgr() {
		silvers = new Silver[10];
		sc = new Scanner(System.in);
		index = 0;
	}
	public void main() {

		while(true) {			
			System.out.println("===== ����Ʈ ���� ���α׷�v1 =====");
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
		System.out.println("=============== ȸ�� ���� �Է� ==============");
		System.out.printf("���/�̸�/����Ʈ �Է� (����� ����): ");
		silvers[index] = new Silver(sc.next(), sc.next(), sc.next());
		System.out.println("��� �Ϸ�!");
	}
	public void printAllMember (){
		System.out.println("=============== ��ü ȸ�� ���� ��� ==============");
		for(int i=0;i<index;i++) {
			System.out.printf("%s ';[[[[[[[/....d%s %s", silvers[i].getGrade(), silvers[i].getName(), silvers[i].getPoint());
		}
	}
	public void printOneMember (){}
	public void updateMember   (){}
	public void deleteMember   (){}
	
	
	public int searchIndex(String name){
		for(int i=0;i<index;i++) {
			if(silvers[i].getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}

}
