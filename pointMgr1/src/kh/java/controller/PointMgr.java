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
		System.out.printf("등급/이름/포인트 입력 (띄어쓰기로 구분): ");
		s[sIndex++] = new Silver(sc.next(), sc.next(), sc.nextInt());
		System.out.println("등록 완료!");
	}
	public void printAllMember (){
		System.out.println("\n=============== 전체 회원 정보 출력 ==============\n");
		System.out.println("등급\t이름\t포인트\t보너스");
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
