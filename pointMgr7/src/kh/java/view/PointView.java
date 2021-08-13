package kh.java.view;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import kh.java.vo.Gold;
import kh.java.vo.Grade;
import kh.java.vo.Silver;
import kh.java.vo.Vip;

public class PointView {
	Scanner sc = new Scanner(System.in);

	public int main() {
		System.out.println("----------회원 관리 프로그램 v7-----------");
		System.out.println("1.회원 등록");
		System.out.println("2.회원 전체 정보 출력");
		System.out.println("3.회원 1명 출력");
		System.out.println("4.회원 정보 수정");
		System.out.println("5.회원 정보 삭제");
		System.out.println("0.프로그램 종료");
		System.out.println("선택 > ");
		int sel = sc.nextInt();
		if (sel == 0)
			System.out.println("프로그램을 종료 합니다.");
		if (sel > 5)
			System.out.println("잘못 입력하셨습니다.");
		
		return sel;
	}

	public void register() {
		System.out.println("----------회원 등록-----------");
	}

	public Grade addMember() {
		sc.nextLine();
		System.out.println("회원 이름/등급/포인트 입력 (/로 구분) : ");
		StringTokenizer str =  new StringTokenizer(sc.nextLine(), "/");
		
		String name = str.nextToken();
		String grade = str.nextToken();
		int point = Integer.parseInt(str.nextToken());
		
		if (grade.equalsIgnoreCase("gold")) {
			return new Gold(grade, name, point);
		} else if (grade.equalsIgnoreCase("silver")) {
			return new Silver(grade, name, point);
		} else if (grade.equalsIgnoreCase("vip")) {
			return new Vip(grade, name, point);
		}
		return null;
	}
	
	public void printAllMember(ArrayList<Grade> arr) {
		System.out.println("----------회원 전체 출력-----------");
		System.out.println("등급\t이름\t포인트\t보너스");
		for (Grade g : arr) {
			System.out.println(g);
		}
		System.out.println("전체 출력 완료!");

	}

	public void printMember() {
		System.out.println("----------회원 출력(1명)-----------");
	}

	public void printMember(Grade member) {
		System.out.println(member);
	}

	public void editMember() {
		System.out.println("----------회원 정보 수정-----------");
	}

	public void deleteMember() {
		System.out.println("----------회원 정보 삭제-----------");
	}

	public String findMember() {
		System.out.println("찾으시는 회원의 이름 검색 : ");
		return sc.next();
	}

	public void noMemberInList() {
		System.out.println("찾으시는 회원은 등록되어있지 않은 회원입니다.");
	}

	public void suceed() {
		System.out.println("성공 !");
		System.out.println();
		System.out.println();

	}

	public void fail() {
		System.out.println("실패 !");
		System.out.println();
		System.out.println();
	}

}
