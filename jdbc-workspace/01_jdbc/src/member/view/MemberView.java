package member.view;

import java.util.ArrayList;
import java.util.Scanner;

import member.vo.Member;

public class MemberView {
	Scanner sc = new Scanner(System.in);
	
	public MemberView() {
	}
	
	public int showMain() {
		System.out.println("-------------------회원 관리 프로그램-------------------");
		System.out.println("1. 전체 회원 조회 ");
		System.out.println("2. 아이디로 회원 조회 ");
		System.out.println("3. 이름으로 회원 조회 ");
		System.out.println("4. 회원 가입 ");
		System.out.println("5. 회원 정보 변경 ");
		System.out.println("6. 회원 탈퇴 ");
		System.out.println("0. 프로그램 종료");
		return sc.nextInt();
		
	}
	
	public void emptyMember() {
		System.out.println("회원이 존재하지 않습니다.");
	}
	
	public void selectAllMember(ArrayList<Member> list) {
		System.out.println("-------------------회원 정보 출력-------------------");
		System.out.println("아이디\t비밀번호\t이름\t주소\t전화번호\t나이\t가입일\t");
		for(Member m : list) {
			System.out.println(m);
		}
	}

}
