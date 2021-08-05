package kh.java.func;

import java.util.Scanner;

public class Scan {
	
	public void test1() {
		Scanner sc = new Scanner(System.in);
		int varInt = sc.nextInt();
		System.out.println(varInt);
		
	}
	
	public void exam1() {
		Scanner sc2 = new Scanner(System.in);
		System.out.printf("국어 점수 입력: ");
		int korean = sc2.nextInt();
		System.out.printf("수학 점수 입력: ");
		int math = sc2.nextInt();
		System.out.printf("영어 점수 입력: ");
		int English = sc2.nextInt();
		
		
		System.out.printf("당신의 성적 총합은 %d이고, 평균은 %.2f 입니다!", korean+math+English,
//				(korean+math+English)/3.0);
//				(korean+math+English)/3d);
				((double)(korean)+math+English)/3);
		
	}
	


}
