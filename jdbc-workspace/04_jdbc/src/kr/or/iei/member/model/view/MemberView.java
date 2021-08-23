package kr.or.iei.member.model.view;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

import kr.or.iei.member.model.vo.Member;

public class MemberView {
	Scanner sc = new Scanner(System.in);

	public int main() {
		System.out.println("-----------회원 관리 프로그램-----------");
		System.out.println("1. 삭제 ");
		System.out.println("2. 회원 가입");
		System.out.println("3. 프로그램 종료");
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

	public String[] getList(String id, boolean edit) {
		sc.nextLine();
		String insert = "비밀번호/이름/핸드폰/나이 입력 (/로 구분): ";
		String editStr = "비밀번호/이름/핸드폰 입력 (/로 구분):";
		System.out.println(edit ? editStr : insert);

		StringTokenizer tokens = new StringTokenizer(sc.nextLine(), "/");

		String[] list = new String[edit ? 4 : 5];

		int i = 0;
		while (tokens.hasMoreTokens()) {
			list[i++] = tokens.nextToken();
		}
		list[i++] = id;

		return list.length <= i ? list : null;
	}

	public void alreadyUserExist() {
		System.out.println("사용중인 아이디 입니다. 다시 시도해주세요.");
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

}
