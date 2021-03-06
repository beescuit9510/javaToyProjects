package member.view;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

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
		System.out.println("7. 로그인");
		System.out.println("0. 프로그램 종료");
		return sc.nextInt();

	}

	public void emptyMember() {
		System.out.println("회원이 존재하지 않습니다.");
	}

	public void selectAllMember(ArrayList<Member> list) {
		System.out.println("-------------------회원 정보 출력-------------------");
		System.out.println("아이디\t비밀번호\t이름\t주소\t전화번호\t나이\t가입일\t");
		for (Member m : list) {
			System.out.println(m);
		}
	}

	public String getId(String purpose) {
		System.out.println(purpose + " 할 아이디 입력 : ");
		return sc.next();
	}

	public String getName(String purpose) {
		System.out.println(purpose + " 할 이름 입력 : ");
		return sc.next();
	}

	public void selectOneMember(Member member) {
		System.out.println(member);
	}

	public void selectOneMember(ArrayList<Member> list) {
		for (Member m : list) {
			System.out.println(m);
		}
	}

	public String[] insertMember() {
		sc.nextLine();
		System.out.println("-------------------회원 가입-------------------");
		System.out.println("아이디/비밀번호/이름/주소/전화번호/나이 입력 (/로 구분): ");
		return addMember(6);

	}

	public String[] addMember(int length) {
		StringTokenizer str = new StringTokenizer(sc.nextLine(), "/");
		String[] strArr = new String[length];
		int i = 0;

		while (str.hasMoreTokens()) {
			strArr[i++] = str.nextToken();
		}

		if (strArr[length - 1] != null)
			return strArr;

		System.out.println("잘못 입력하셨습니다. 다시 시도해주세요.");
		return null;

	}

	public void successMsg() {
		System.out.println("성공!");
	}

	public void failMsg() {
		System.out.println("실패!");
	}

	public String editMember() {
		System.out.println("-------------------회원 정보 수정-------------------");
		return getId("수정");
	}

	public String[] editMember(boolean isMemberinDB) {
		if (!isMemberinDB) {
			emptyMember();
			failMsg();
			return null;
		}
		sc.nextLine();
		System.out.println("비밀번호/주소/전화번호 입력 (/로 구분): ");
		return addMember(3);
	}

	public String deleteMember() {
		System.out.println("-------------------회원 탈퇴-------------------");
		return getName("삭제");

	}

	public Member login() {
		System.out.println("-------------------로그인-------------------");
		Member m = new Member();
		System.out.println("아이디 입력 :");
		m.setMemberId(sc.next());
		System.out.println("비밀번호 입력 :");
		m.setMemberPw(sc.next());
		return m;
	}

	public int loginMenu(String memberName) {
		System.out.println("-------------------[" + memberName + "]-------------------");
		System.out.println("1. 내 정보 보기");
		System.out.println("2. 로그아웃");
		System.out.println("3. 회원 탈퇴");
		System.out.println("4. 회원 정보 수정");
		System.out.println("선택 > ");
		return sc.nextInt();

	}
	
	public void memberAlreadyExist() {
		System.out.println("이미 있는 아이디 입니다. 다시 시도해주세요.");

	}

}
