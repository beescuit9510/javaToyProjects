package kh.java.controller;

import java.util.Scanner;

import kh.java.vo.Gold;
import kh.java.vo.Silver;
import kh.java.vo.Vip;

public class PointMgr {
	Scanner sc;
	Silver[] s;
	Gold[] g;
	Vip[] v;
	int[] indexes;
	
	public PointMgr() {
		s = new Silver[10];
		g = new Gold[10];
		v = new Vip[10];
		indexes = new int[3];
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

	
	public void insertMember(){
		System.out.println("======================== ȸ�� ���� �Է� ========================");
		int i = searchGrade()
	} 
	public void printAllMember(){
		System.out.println("======================== ��ü ȸ�� ���� ��� ========================");
	}
	public void printOneMember(){
		System.out.println("======================== ȸ�� ���� ���(1��) ========================");
	}

	public void updateMember(){
		System.out.println("======================== ȸ�� ���� ���� ========================");
	}	
	public void deleteMember(){
		System.out.println("======================== ȸ�� ���� ���� ========================");
	}
	
	
	public void add() {
		System.out.println("ȸ�� ���/�̸�/����Ʈ �Է� (����� ����) :");
		int i = searchGrade(sc.next());
		do {
			if(i==0) {
				s[indexes[0]] = new Silver("Silver",sc.next(),sc.nextInt());			
			} else if(i==1) {
				g[indexes[1]] = new Gold("Silver",sc.next(),sc.nextInt());			
			} else if(i==2) {
				v[indexes[2]] = new Vip("Silver",sc.next(),sc.nextInt());
			}
		} while(i==-1);
		System.out.println("��� �Ϸ�!");
	}
	
	public int searchGrade(String str){
		String[] grades = {"silver","gold","vip"};
		for(int i=0;i<grades.length;i++) {
			if(str.equalsIgnoreCase(grades[i])){
				return i;
			}
		}
		System.out.println("����� �߸� �Է� �ϼ̽��ϴ�.");
//		System.out.println("�ٽ� �Է����ּ���.");
		return -1;
	}
	
	public int saerchName(String name, int grade) {
		for(int i=0;i<grade;i++) {
			if(grade==0) {
				if(name.equals(s[i].getName())){
					return i;
				}
			}
			if(grade==1) {
				if(name.equals(g[i].getName())){
					return i;
				}
			}
			if(grade==2) {
				if(name.equals(v[i].getName())){
					return i;
				}
			}
		}
	}

}


