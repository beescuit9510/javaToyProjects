package kh.java.function;

import java.util.Scanner;

public class Example {
	
	public void exam5() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("영어단어 입력: ");
		String word = sc.nextLine();
		System.out.println("첫번째 문자:" + word.charAt(0));
		System.out.println("두번째 문자:"+ word.charAt(1));
		System.out.println("세번째 문자:" + word.charAt(2));
		
	}

}
