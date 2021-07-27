package kh.java.controller;
import java.util.Scanner;
import kh.java.vo.Gold;
import kh.java.vo.Silver;
import kh.java.vo.Vip;

public class PointMgr {
	private Scanner sc;

	private Vip[] v;
	private Gold[] g;
	private Silver[] s;
	private int[] indexes= {0,0,0};
	

	
	public PointMgr() {
		v = new Vip[10];
		g = new Gold[10];
		s = new Silver[10];
		sc = new Scanner(System.in);		
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
		if(add()==0) {
			System.out.println("��� �Ϸ�!");
		}
	}

	public void printAllMember (){
		System.out.println("\n=============== ��ü ȸ�� ���� ��� ==============\n");
		System.out.println("���\t�̸�\t����Ʈ\t���ʽ�");
		
		for(int i=0;i<indexes.length;i++) {
			for(int j=0;j<indexes[i];j++) {
				System.out.println(i==0? s[j].getGrade()+"\t"+s[j].getName()+"\t"+s[j].getPoint()+"\t"+s[j].getBonus():
					i==1? g[j].getGrade()+"\t"+g[j].getName()+"\t"+g[j].getPoint()+"\t"+g[j].getBonus():
						v[j].getGrade()+"\t"+v[j].getName()+"\t"+v[j].getPoint()+"\t"+v[j].getBonus());		
			}
		}
	}
	
	
	public void printOneMember (){
		System.out.println("\n========================ȸ�� ���� ��� (1��)========================\n");
		System.out.print("��ȸ �� ȸ���� ��ް� �̸� �Է� : ");
		String grade = sc.next();
		String  name = sc.next();
		int gradeI = searchObjIndex(grade);
		int j = gradeI>=0? searchIndex(name, gradeI): -1;
		
		if(j==-1||gradeI==-1) {
			System.out.println("ȸ�� ������ �����ϴ�.");
			return;
		}
		System.out.println("���\t�̸�\t����Ʈ\t���ʽ�");
		System.out.println(gradeI==0? s[j].getGrade()+"\t"+s[j].getName()+"\t"+s[j].getPoint()+"\t"+s[j].getBonus():
			gradeI==1? g[j].getGrade()+"\t"+g[j].getName()+"\t"+g[j].getPoint()+"\t"+g[j].getBonus():
				v[j].getGrade()+"\t"+v[j].getName()+"\t"+v[j].getPoint()+"\t"+v[j].getBonus());
	}
	
	
	
	public void updateMember   (){
		System.out.println("\n========================ȸ�� ���� ���� ========================\n");
		System.out.printf("���� �� ȸ���� ��ް� �̸� �Է� : ");
		if(delete()==0) {
			if(add()==0) {
				System.out.println("���� �Ϸ�!");
			}
		}
		System.out.println("���� ����!");
	}
	
	public void deleteMember   (){
		System.out.println("\n========================ȸ�� ���� ����========================\n");
		System.out.printf("���� �� ȸ���� ��ް� �̸� �Է� : ");
		if(delete()==0) {
			System.out.println("���� �Ϸᰡ �Ϸ�Ǿ��ϴ�.");
		}
	}
	
//	===========Frontend=bbbbbbbbbbbbbbbbvg66666666666666666666666t,lllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll=========
//	=================================================================================================================
//	=================================================================================================================
//	=================================================================================================================
//	=================================================================================================================
//	=================================================================================================================
//	=================================================================================================================
//	=================================================================================================================
//	=================================================================================================================
//	=================================================================================================================
//			===========Backend==========

	
	public int searchIndex(String name, int grade){
		for(int i=0;i<indexes[grade];i++) {
			if(grade==0) {
				if(s[i].getName().equals(name)) {
					return i;
				}				
			}
			if(grade==1) {
				if(g[i].getName().equals(name)) {
					return i;
				}
			}
			if(grade==2) {
				if(v[i].getName().equals(name)) {
					return i;
				}
			}
		}
		return -1;
	}
	
	
	
	public int searchObjIndex(String str) {
		String[] grades = {"silver","gold","vip"};
		for(int i=0;i<3;i++) {
			if(str.equalsIgnoreCase(grades[i])) {
				return i;
			}
		}
		return -1;
	}
	
	public int delete() {
		String grade = sc.next();
		String  name = sc.next();
		int gradeI = searchObjIndex(grade);
		int j = gradeI>=0? searchIndex(name, gradeI): -1;
		
		if(j==-1||gradeI==-1) {
			System.out.println("ȸ�� ������ �����ϴ�.");
			return-1;
		}
		
		int k = gradeI==0? indexes[0]:gradeI==1? indexes[1]:indexes[2];

		for(int i=j;i<k-1;i++) {
			if(gradeI==0) {
				s[j] = s[j+1];
			}else if(gradeI==1) {
				g[j] = g[j+1];
			}else{
				v[j] = v[j+1];	
			}
		}
		k = gradeI==0? --indexes[0]:gradeI==1? --indexes[1]:--indexes[2];
		
		if(gradeI==0) {
			s[k] = null;
		}else if(gradeI==1) {
			g[k] = null;
		}else{
			v[k] = null;
		}
		return 0;
	}

	public int add() {
		int i = -1;
		do {
			sc.nextLine();
			System.out.printf("���/�̸�/����Ʈ �Է� (����� ����): ");
			String grade = sc.next();
			i = searchObjIndex(grade);
			if(i==0) {
				s[indexes[0]++] = new Silver(grade, sc.next(), sc.nextInt());
			} else if(i==1) {
				g[indexes[1]++] = new Gold(grade, sc.next(), sc.nextInt());
			} else if(i==2) {
				v[indexes[2]++] = new Vip(grade, sc.next(), sc.nextInt());
			} else {
				System.out.println("�߸��� ��� �Դϴ�.");
			}
		}while(i==-1);
		return 0;
	}
}
