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
			System.out.println("\n============= 포인트 관리 프로그램v1 ===========\n");
			System.out.println("1. 회원 정보 등록");
			System.out.println("2. 전체 회원 조회");
			System.out.println("3. 회원 1명 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("5. 회원 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.printf("선택 > ");
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
				System.out.println("프로그램 종료 ~~ ");
				return;
				
			default:
				System.out.println("잘못입력하셨습니다.");
				break;
			}
			
	}
		
	
}
	
	
	public void insertMember   (){
		System.out.println("\n=============== 회원 정보 입력 ==============\n");
		if(add()==0) {
			System.out.println("등록 완료!");
		}
	}

	public void printAllMember (){
		System.out.println("\n=============== 전체 회원 정보 출력 ==============\n");
		System.out.println("등급\t이름\t포인트\t보너스");
		
		for(int i=0;i<indexes.length;i++) {
			for(int j=0;j<indexes[i];j++) {
				System.out.println(i==0? s[j].getGrade()+"\t"+s[j].getName()+"\t"+s[j].getPoint()+"\t"+s[j].getBonus():
					i==1? g[j].getGrade()+"\t"+g[j].getName()+"\t"+g[j].getPoint()+"\t"+g[j].getBonus():
						v[j].getGrade()+"\t"+v[j].getName()+"\t"+v[j].getPoint()+"\t"+v[j].getBonus());		
			}
		}
	}
	
	
	public void printOneMember (){
		System.out.println("\n========================회원 정보 출력 (1명)========================\n");
		System.out.print("조회 할 회원의 등급과 이름 입력 : ");
		String grade = sc.next();
		String  name = sc.next();
		int gradeI = searchObjIndex(grade);
		int j = gradeI>=0? searchIndex(name, gradeI): -1;
		
		if(j==-1||gradeI==-1) {
			System.out.println("회원 정보가 없습니다.");
			return;
		}
		System.out.println("등급\t이름\t포인트\t보너스");
		System.out.println(gradeI==0? s[j].getGrade()+"\t"+s[j].getName()+"\t"+s[j].getPoint()+"\t"+s[j].getBonus():
			gradeI==1? g[j].getGrade()+"\t"+g[j].getName()+"\t"+g[j].getPoint()+"\t"+g[j].getBonus():
				v[j].getGrade()+"\t"+v[j].getName()+"\t"+v[j].getPoint()+"\t"+v[j].getBonus());
	}
	
	
	
	public void updateMember   (){
		System.out.println("\n========================회원 정보 수정 ========================\n");
		System.out.printf("수정 할 회원의 등급과 이름 입력 : ");
		if(delete()==0) {
			if(add()==0) {
				System.out.println("수정 완료!");
			}
		}
		System.out.println("수정 실패!");
	}
	
	public void deleteMember   (){
		System.out.println("\n========================회원 정보 삭제========================\n");
		System.out.printf("삭제 할 회원의 등급과 이름 입력 : ");
		if(delete()==0) {
			System.out.println("삭제 완료가 완료되었니다.");
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
			System.out.println("회원 정보가 없습니다.");
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
			System.out.printf("등급/이름/포인트 입력 (띄어쓰기로 구분): ");
			String grade = sc.next();
			i = searchObjIndex(grade);
			if(i==0) {
				s[indexes[0]++] = new Silver(grade, sc.next(), sc.nextInt());
			} else if(i==1) {
				g[indexes[1]++] = new Gold(grade, sc.next(), sc.nextInt());
			} else if(i==2) {
				v[indexes[2]++] = new Vip(grade, sc.next(), sc.nextInt());
			} else {
				System.out.println("잘못된 등급 입니다.");
			}
		}while(i==-1);
		return 0;
	}
}
