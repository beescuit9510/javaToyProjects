package kh.java.func;

import java.util.Scanner;

public class SwitchTest {
	
	Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		System.out.println("월을 입력하세요 : ");
		int month = sc.nextInt();
		
		switch(month) {
		case 8:
			System.out.println("내 생일");
		case 1:
		case 3:
		case 5:
		case 7:
		case 10:
		case 12:
			System.out.println("31일");
			break;
		case 2:
			System.out.println("28일");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("30일");
			break;
		
	}
		
	

}
	public void practice2() {
		System.out.println("소문자 변환 프로그램");
		System.out.println("문자 입력 : ");
		char ch = sc.next().charAt(0);
		switch(ch) {
		case 'a':
			System.out.println("AAAAAA");
			break;
		case 90:
			System.out.println("ZZZZZZ");
			break;
//			char 는 유니코드로 int로 디코딩/인코딩되기 때문에 숫자로 비교가능;
		}
		
		
		

//		shift+enter = another line
//		ctrl+alt+up/down = copy;
//		ctrl+D = delete a line;
//		ctrl+enter = align a line
//		shift+up/down = select multiple lines
//		ctrl+n = create a new class/package
//		ctrl+space = import
	}
	
	
	
	
}
