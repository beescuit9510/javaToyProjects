package kr.or.iei.member.model.view;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import kr.or.iei.member.model.vo.Member;

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

	public int loginMain(String name) {
		System.out.println("-----------[" + name + "]-----------");
		System.out.println("1. 내 정보 보기");
		System.out.println("2. 내 정보 수정");
		System.out.println("3. 회원 탈퇴");
		System.out.println("4. 로그아웃");
		System.out.println("5. 게시판가기");
		System.out.println("선택 > ");
		return sc.nextInt();
	}

	public void resultMsg(boolean result) {
		System.out.println(result ? "성공 !" : "실패 !");
		System.out.println();
		System.out.println();
		System.out.println();
	}

	public String[] getList(boolean edit, String id) {
		sc.nextLine();
		if (!edit)
			System.out.println("회원 비밀번호/이름/주소/전화번호/나이 입력 (/로 구분) : ");
		else
			System.out.println("회원 비밀번호/이름/주소/전화번호 입력 (/로 구분) : ");

		StringTokenizer tokens = new StringTokenizer(sc.nextLine(), "/");
		int length = edit? 5:6;
		String[] list = new String[length];
		int i = 0;
		list[i++] = id;

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

	public void alreadyMemberExist(boolean isMemberInDB) {
		System.out.println(isMemberInDB? "사용중인 아이디 입니다. 다시 시도해주세요.":"");
	}

	public void somethingWentWrong() {
		System.out.println("잘못된 입력 입니다. 다시 시도해주세요.");

	}

	public void wrongIdOrPw() {
		System.out.println("아이디 혹은 비밀번호를 다시 확인해주세요.");
	}

	public String getId() {
		System.out.println("아이디 입력 : ");
		return sc.next();
	}
	
	public String getName() {
		System.out.println("아이디 입력 : ");
		return sc.next();
	}


	public String getPw() {
		System.out.println("비밀번호 입력 : ");
		return sc.next();
	}


	public void printMember(ArrayList<Member> members) {
		System.out.println("회원번호\t아이디\t비밀번호\t이름\t나이\t전화번호");
		for (Member m : members) {
			System.out.println(m);

		}

	}

	public void noSuchMember(boolean isMemberInDB) {
		System.out.println(isMemberInDB? "":"가입되지 않은 회원입니다. 다시 시도해주세요.");
		
	}

}
