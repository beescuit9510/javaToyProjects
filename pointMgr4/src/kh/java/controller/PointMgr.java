package kh.java.controller;

import java.util.Scanner;
import kh.java.vo.*;
//ctrl + shift + F 
// ctrl + shift + o;

public class PointMgr {

	private Scanner sc;
	private Grade[] members;
	private int index;

	public PointMgr() {
		sc = new Scanner(System.in);
		members = new Grade[40];
		index = 0;
	}

	public void main() {
		while (true) {
			System.out.println("\n============= 포인트 관리 프로그램v4 ===========\n");
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

	public void insertMember() {
		System.out.println("================== 회원 정보 등록 ================");
		add(index, true, false);
		System.out.println("등록 완료!");

	}

	public void printAllMember() {
		System.out.println("================== 전체 회원 정보 출력 ================");
		System.out.println("등급\t이름\t포인트\t보너스");
		for (int i = 0; i < index; i++) {
			System.out.printf("%s\t%s\t%d\t%.4f%n", members[i].getGrade(), members[i].getName(), members[i].getPoint(),
					members[i].getBonus());
		}

	}

	public void printOneMember() {
		System.out.println("================== 회원 정보 출력 (1인) ================");
		System.out.println("조회 할 회원 이름 입력 : ");
		int i = searchIndex(sc.next());
		if (i == -1) {
			System.out.println("회원 정보를 찾을 수 없습니다.");
			return;
		}
		System.out.printf("%s\t%s\t%d\t%.4f%n", members[i].getGrade(), members[i].getName(), members[i].getPoint(),
				members[i].getBonus());
		System.out.println("출력 완료!");

	}

	public void updateMember() {
		System.out.println("================== 회원 정보 수정 ================");
		System.out.println("수정 할 회원 이름 입력 : ");
		int i = searchIndex(sc.next());
		if (i == -1) {
			System.out.println("회원 정보를 찾을 수 없습니다.");
			return;
		}
		add(i, false, true);
		System.out.println("수정 완료!");

	}

	public void deleteMember() {
		System.out.println("================== 회원 정보 삭제 ================");
		System.out.println("삭제 할 회원 이름 입력 : ");
		int i = searchIndex(sc.next());
		if (i == -1) {
			System.out.println("회원 정보를 찾을 수 없습니다.");
			return;
		}
		for (int j = i; j < index - 1; j++) {
			members[j] = members[j + 1];
		}
		members[--index] = null;
		System.out.println("삭제 완료!");

	}

	public int searchIndex(String name) {
		for (int i = 0; i < index; i++) {
			if (name.equals(members[i].getName())) {
				return i;
			}
		}
		return -1;
	}

	public void add(int i, boolean isInstanceIndex, boolean isEditting) {
		int j = -1;
		String grade;
		String name;
		do {
			sc.nextLine();
			System.out.printf("등급[silver/gold/vip/Vvip]/이름/포인트 입력 (띄어쓰기로 구분) : ");
			grade = sc.next();
			name = sc.next();
			j = searchIndex(name);
			if (j != -1) {
				if (isEditting && members[j].getName().equals(name)) {
					break;
				}
				System.out.println("이미 사용중인 이름 입니다.");
			}
		} while (j != -1);
		if (grade.equalsIgnoreCase("silver"))
			members[i++] = new Silver(grade, name, sc.nextInt());
		if (grade.equalsIgnoreCase("Gold"))
			members[i++] = new Gold(grade, name, sc.nextInt());
		if (grade.equalsIgnoreCase("Vip"))
			members[i++] = new Vip(grade, name, sc.nextInt());
		if (grade.equalsIgnoreCase("Vvip"))
			members[i++] = new Vvip(grade, name, sc.nextInt());
		if (isInstanceIndex) {
			index++;
		}
	}

}
