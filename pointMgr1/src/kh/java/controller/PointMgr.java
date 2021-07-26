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
			System.out.println("===== 포인트 관리 프로그램v1 =====");
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
		System.out.println("=============== 회원 정보 입력 ==============");
		System.out.printf("등급/이름/포인트 입력 (띄어쓰기로 구분): ");
		silvers[index] = new Silver(sc.next(), sc.next(), sc.next());
		System.out.println("등록 완료!");
	}
	public void printAllMember (){
		System.out.println("=============== 전체 회원 정보 출력 ==============");
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
