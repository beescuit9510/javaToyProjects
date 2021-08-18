package kr.or.iei.member.view;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import kr.or.iei.member.vo.Member;

public class MemberView {
	Scanner sc = new Scanner(System.in);

	public int main() {
		System.out.println("-----------회원 관리 프로그램-----------");
		System.out.println("1. 전체 회원 정보 조회");
		System.out.println("2. 아이디로 회원 정보 조회");
		System.out.println("3. 이름으로 회원 정보 조회");
		System.out.println("4. 회원 가입");
		System.out.println("5. 회원 정보 수정");
		System.out.println("6. 회원 정보 삭제");
		System.out.println("0. 프로그램 종료");
		System.out.println("선택 > ");
		return sc.nextInt();
	}

	public void printMember(ArrayList<Member> list) {
		for (Member m : list) {
			System.out.println(m);
		}
	}

	public void printMember(boolean printAllMember, boolean searchById) {
		String content = printAllMember ? "전체 회원 정보 조회" : "";
		if (content.equals(""))
			content = searchById ? "아이디로 회원 정보 조회" : "이름으로 회원 정보 조회";
		System.out.println("-------------" + content + "------------");
	}

	public void register() {
		System.out.println("-------------회원 가입-----------");

	}

	public void deleteMember() {
		System.out.println("-------------회원 정보 삭제-----------");

	}

	public void eidtMember() {
		System.out.println("-------------회원 정보 수정-----------");

	}

	public String[] addMemberInDB(int length, String name) {
		sc.nextLine();
		if (length > 5)
			System.out.println("회원 비밀번호/이름/주소/전화번호/나이 입력 (/로 구분) : ");
		else
			System.out.println("회원 비밀번호/이름/주소/전화번호 입력 (/로 구분) : ");

		StringTokenizer tokens = new StringTokenizer(sc.nextLine(), "/");
		String[] list = new String[length];
		int i = 0;
		list[i++] = name;

		while (tokens.hasMoreTokens()) {
			list[i++] = tokens.nextToken();
		}

		for (String str : list) {
			if (str == null) {
				System.out.println("잘못 입력하셨습니다. 다시 시도해주세요.");
				return null;
			}
		}
		return list;

	}

	public String getId(String str) {
		System.out.println(str + "할 아이디 입력 : ");
		return sc.next();
	}

	public String getName(String str) {
		System.out.println(str + "할 이름 입력 : ");
		return sc.next();
	}

	public void failMsg() {
		System.out.println("실패 !");
	}

	public void successMsg() {
		System.out.println("성공 !");
	}

	public void noMemberMsg() {
		System.out.println("등록되지 않은 회원 입니다.");
	}

	public void alreadyMemberInDBMsg() {
		System.out.println("이미 등록된 회원 입니다.");
	}

}
