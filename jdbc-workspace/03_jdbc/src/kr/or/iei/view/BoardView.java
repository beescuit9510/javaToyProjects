package kr.or.iei.view;

import java.util.Scanner;
import java.util.StringTokenizer;

import kr.or.iei.vo.Board;

public class BoardView {

	Scanner sc = new Scanner(System.in);

	public void printAllPost(Board[] posts) {
		if (posts.length == 0) {
			System.out.println("등록된 게시물이 없습니다.");
			return;
		}
		System.out.println("게시물번호\t제목\t작성자\t조회수\t작성일\t");
		for (Board post : posts) {
			System.out.println(post);
		}
		System.out.println();
		System.out.println();
		System.out.println();

	}

	public int boardMenu(String name) {

		System.out.println("-----------[ 고양이 애호 동호회 게시판 ]-----------");
		System.out.println("1. 게시물 전체 목록 보기 ");
		System.out.println("2. 게시물 상세보기 ");
		System.out.println("3. 게시글 등록 ");
		System.out.println("4. 게시글 수정");
		System.out.println("5. 게시글 삭제");
		System.out.println("6. 이전 화면");
		System.out.println("선택 > ");
		return sc.nextInt();
	}

	public void resultMsg(boolean result) {
		System.out.println(result ? "성공 !" : "실패 !");
		System.out.println();
		System.out.println();
		System.out.println();
	}

	public int getBoradNo() {
		System.out.println("게시판 번호 입력 : ");
		return sc.nextInt();
	}

	public void printPost(Board[] posts, int userNo, String userName) {
		if (posts[0] == null) {
			System.out.println("그런 게시판 번호를 가진 게시물은 없습니다.");
			return;
		}
		System.out.print("게시물번호\t");
		System.out.println(posts[0].getBoard_no());
		System.out.print("제목\t");
		System.out.println(posts[0].getBoard_title());
		System.out.print("내용\t");
		System.out.println(posts[0].getBoard_content());
		String writer = posts[0].getBoard_writer();
		if ((userNo + "").equals(writer))
			writer = userName;
		System.out.print("작성자\t");
		System.out.println(writer);
		System.out.print("조회수\t");
		System.out.println(posts[0].getBoard_count());
		System.out.print("작성일\t");
		System.out.println(posts[0].getEnroll_date());
		System.out.println();
		System.out.println();
		System.out.println();

	}

	public String[] getBoradList(boolean edit) {
		sc.nextLine();
		System.out.println("제목/내용 (/로 구분): ");
		StringTokenizer tokens = new StringTokenizer(sc.nextLine(), "/");

		String[] list = new String[edit ? 2 : 3];

		int i = 0;
		while (tokens.hasMoreTokens()) {
			list[i++] = tokens.nextToken();
			if ((i > 2 && edit) || (i > 3 && !edit))
				System.out.println("잘못된 입력 입니다. 다시 시도해주세요.");
		}

		return list;
	}

	public void isBoardWriter(boolean isBoardWriter) {
		System.out.println(isBoardWriter ? "" : "오직 게시판 작성자만 삭제 및 수정 가능 합니다.");
	}

}
