package kh.java.controller;

import java.util.ArrayList;
import java.util.Scanner;
import kh.java.vo.*;
//ctrl + shift + F 
// ctrl + shift + o;

public class PointMgr {

	private Scanner sc;
	private ArrayList<Grade> members;

	public PointMgr() {
		sc = new Scanner(System.in);
		members = new ArrayList<Grade>();
	}

	public void main() {
		while (true) {
			System.out.println("\n============= 포인트 관리 프로그램v5 ===========\n");
			System.out.println("1. 회원 정보 등록");
			System.out.println("2. 전체 회원 조회");
			System.out.println("3. 회원 1명 조회");
			System.out.println("4. 회원 정보 수정");
			System.out.println("5. 회원 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.printf("선택 > ");
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
				System.out.println("프로그램 종료 ~~ ");
				return;

			default:
				System.out.println("잘못입력하셨습니다.");
				break;
			}
		}
	}

	public void insertMember(boolean isEditting) {
		if(!isEditting) {
			System.out.println("================== 회원 정보 등록 ================");			
		}
		System.out.printf("등급[silver/gold/vip/Vvip]/이름/포인트 입력 (띄어쓰기로 구분) : ");
		String grade = sc.next();
		if (grade.equalsIgnoreCase("silver"))
			members.add(new Silver(grade,sc.next(),sc.nextInt()));
		if (grade.equalsIgnoreCase("Gold"))
			members.add(new Gold(grade,sc.next(),sc.nextInt()));
		if (grade.equalsIgnoreCase("Vip"))
			members.add(new Vip(grade,sc.next(),sc.nextInt()));
		if (grade.equalsIgnoreCase("Vvip"))
			members.add(new Vvip(grade,sc.next(),sc.nextInt()));
		System.out.println(isEditting? "수정 완료!":"등록 완료!");

	}

	public void printAllMember() {
		System.out.println("================== 전체 회원 정보 출력 ================");
		System.out.println("등급\t이름\t포인트\t보너스");
		for (Grade g : members) {
			System.out.println(g);
		}

	}

	public void printOneMember() {
		System.out.println("================== 회원 정보 출력 (1인) ================");
		System.out.println("조회 할 회원 이름 입력 : ");
		Grade m = searchMember(sc.next());
		if(m==null) {
			System.out.println("회원 정보를 찾을 수 없습니다.");
		}else {
			System.out.println(m);
		}
	}	

	public void updateMember() {
		System.out.println("================== 회원 정보 수정 ================");
		System.out.println("수정 할 회원 이름 입력 : ");
		Grade m = searchMember(sc.next());
		if (m == null) {
			System.out.println("회원 정보를 찾을 수 없습니다.");
		}else {
			members.remove(m);
			insertMember(true);
		}

	}

	public void deleteMember() {
		System.out.println("================== 회원 정보 삭제 ================");
		System.out.println("삭제 할 회원 이름 입력 : ");
		Grade m = searchMember(sc.next());
		if(m ==null) {
			System.out.println("회원 정보를 찾을 수 없습니다.");
		}else {
			members.remove(m);
			System.out.println("삭제 완료!");
		}

	}

	public Grade searchMember(String name) {
		for(Grade m : members) {
			if (name.equals(m.getName())) {
				return m;
			}
		}
		return null;
	}

}
