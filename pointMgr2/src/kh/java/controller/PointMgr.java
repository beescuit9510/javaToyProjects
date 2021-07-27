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

	
	public void insertMember(){
		System.out.println("======================== 회원 정보 입력 ========================");
		int i = searchGrade()
	} 
	public void printAllMember(){
		System.out.println("======================== 전체 회원 정보 출력 ========================");
	}
	public void printOneMember(){
		System.out.println("======================== 회원 정보 출력(1인) ========================");
	}

	public void updateMember(){
		System.out.println("======================== 회원 정보 수정 ========================");
	}	
	public void deleteMember(){
		System.out.println("======================== 회원 정보 삭제 ========================");
	}
	
	
	public void add() {
		System.out.println("회원 등급/이름/포인트 입력 (띄어쓰기로 구분) :");
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
		System.out.println("등록 완료!");
	}
	
	public int searchGrade(String str){
		String[] grades = {"silver","gold","vip"};
		for(int i=0;i<grades.length;i++) {
			if(str.equalsIgnoreCase(grades[i])){
				return i;
			}
		}
		System.out.println("등급을 잘못 입력 하셨습니다.");
//		System.out.println("다시 입력해주세요.");
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


