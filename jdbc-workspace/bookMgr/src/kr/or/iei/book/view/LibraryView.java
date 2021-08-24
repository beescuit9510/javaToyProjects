package kr.or.iei.book.view;

import java.util.ArrayList;
import java.util.Scanner;

import kr.or.iei.book.vo.Rent;

public class LibraryView {
	Scanner sc = new Scanner(System.in);

	public int main() {
		System.out.println("------------ 로그인 ------------");
		System.out.println("1. 로그인 ");
		System.out.println("2. 회원가입 ");
		System.out.println("0. 종료 ");
		return sc.nextInt();

	}

	public int customerMain() {
		System.out.println("------------ KH 도서관 ------------");
		System.out.println("1. 책빌리기");
		System.out.println("2. 내 대여정보 확인 ");
		System.out.println("3. 책 반납하기");
		System.out.println("4. 내 정보 보기");
		System.out.println("0. 로그아웃(이전 화면)");
		return sc.nextInt();

	}

	public int staffMain() {
		System.out.println("------------ KH 도서관 ------------");
		System.out.println("1. 책 현황 보기");
		System.out.println("2. 신규 책 등록");
		System.out.println("3. 전체 대여 현황");
		System.out.println("4. 전체 회원 정보 조회");
		System.out.println("0. 로그아웃(이전 화면)");
		return sc.nextInt();

	}

	public String[] login() {
		String[] r = new String[2];
		int i = 0;
		System.out.println("아이디 입력 :");
		r[i++] = sc.next();
		System.out.println("비밀번호 입력 :");
		r[i++] = sc.next();
		return r;
	}

	public String[] register() {
		System.out.println("------------ 회원 가입 ------------");
		String[] r = new String[5];
		int i = 0;
		System.out.println("아이디 입력 :");
		r[i++] = sc.next();
		System.out.println("비밀번호 입력 :");
		r[i++] = sc.next();
		System.out.println("이름 입력 :");
		r[i++] = sc.next();
		System.out.println("전화번호 입력 :");
		r[i++] = sc.next();
		System.out.println("회원 등급 입력[1.고객/2.직원] :");
		r[i++] = sc.next();
		return r;
	}

	public String[] insertBook() {
		System.out.println("------------ 회원 가입 ------------");
		String[] r = new String[5];
		int i = 0;
		System.out.println("장르 입력 :");
		r[i++] = sc.next();
		System.out.println("제목 입력 :");
		r[i++] = sc.next();
		System.out.println("소개 입력 :");
		r[i++] = sc.next();
		System.out.println("작가 입력 :");
		r[i++] = sc.next();
		System.out.println("재고 입력:");
		r[i++] = sc.next();
		return r;
	}

	public void resultMsg(boolean success) {
		System.out.println(success ? "성공!!" : " 실패!!");
	}

	public void print(ArrayList<Object> objects) {
		for (Object o : objects) {
			System.out.println(o);
		}

	}

	public int getRentNo() {
		System.out.println("반납 할 책의 대여번호 입력:");
		return sc.nextInt();
	}

	public int getBookNo() {
		System.out.println("대여할 책의 도서번호 입력:");
		return sc.nextInt();
	}

	public void printR(ArrayList<Rent> rents) {
		for (Rent o : rents) {
			System.out.println(o);
		}

	}

}
