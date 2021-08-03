package kh.java.func;

import java.io.File;
import java.util.Scanner;

public class FileTest {
	public void fileTest() {
		Scanner sc = new Scanner(System.in);
		System.out.println("파일명 입력 : ");
		File file = new File(sc.next());

		if (file.exists()) {
			System.out.println("파일 있음");
			System.out.println("파일명 : " + file.getName());
			System.out.println("파일명 상대 경로 : " + file.getPath());
			System.out.println("파일 절대 경로 : " + file.getAbsolutePath());
			System.out.println("파일 삭제 ? ㄱ ?");
			if(sc.next().equals("ㄱ")) {
				file.delete();
			}
		} else {
			System.out.println("파일 없음");
		}
	}

}
