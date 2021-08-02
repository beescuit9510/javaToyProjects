package kh.java.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import kh.java.vo.*;
//ctrl + shift + F 
// ctrl + shift + o;

public class PointMgr {

	private Scanner sc;
	private HashMap<String, Grade> members;

	public PointMgr() {
		sc = new Scanner(System.in);
		members = new HashMap<String, Grade>();
	}

	public void main() {
		while (true) {
			System.out.println("\n============= 포인트 관리 프로그램v6 ===========\n");
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

	public void insertMember(boolean isbeingEditted) {
		System.out.println(isbeingEditted ? "" : "================== 회원 정보 등록 ================");
		System.out.printf("등급[silver/gold/vip/Vvip]/이름/포인트 입력 (띄어쓰기로 구분) : ");
		String grade = sc.next();
		String name = sc.next();
		if (members.containsKey(name)) {
			System.out.println("이미 등록된 회원 입니다. 다시 시도 해주세요.");
			sc.nextLine();
			insertMember(false);
			return;
		}
		if (grade.equalsIgnoreCase("silver"))
			members.put(name, new Silver(grade, name, sc.nextInt()));
		if (grade.equalsIgnoreCase("Gold"))
			members.put(name, new Gold(grade, name, sc.nextInt()));
		if (grade.equalsIgnoreCase("Vip"))
			members.put(name, new Vip(grade, name, sc.nextInt()));
		if (grade.equalsIgnoreCase("Vvip"))
			members.put(name, new Vvip(grade, name, sc.nextInt()));
		System.out.println(isbeingEditted ? "" : "등록 완료!");

	}

	public void printAllMember() {
		System.out.println("================== 전체 회원 정보 출력 ================");
		System.out.println("등급\t이름\t포인트\t보너스");
		for (Grade g : members.values()) {
			System.out.println(g);
		}

	}

	public void printOneMember() {
		System.out.println("================== 회원 정보 출력 (1인) ================");
		System.out.println("조회 할 회원 이름 입력 : ");
		String name = searchMember(sc.next());
		System.out.println(name == null ? "" : members.get(name));
	}

	public void updateMember() {
		System.out.println("================== 회원 정보 수정 ================");
		System.out.println("수정 할 회원 이름 입력 : ");
		if (members.remove(searchMember(sc.next())) == null) {
			System.out.println("수정 실패 !");
		} else {
			insertMember(true);
			System.out.println("수정 성공 !");
		}

	}

	public void deleteMember() {
		System.out.println("================== 회원 정보 삭제 ================");
		System.out.println("삭제 할 회원 이름 입력 : ");
		System.out.println(members.remove(searchMember(sc.next())) == null ? "삭제 실패!" : "삭제 성공!");
	}

	public String searchMember(String name) {
		// System.out.println("이름 입력 : ");
		// String name = sc.next();
		if (members.containsKey(name)) {
			return name;
		}
		System.out.println("회원 정보를 찾을 수 없습니다.");
		return null;
	}

}
