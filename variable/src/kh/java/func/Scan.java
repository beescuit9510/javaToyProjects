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
		System.out.printf("���� ���� �Է�: ");
		int korean = sc2.nextInt();
		System.out.printf("���� ���� �Է�: ");
		int math = sc2.nextInt();
		System.out.printf("���� ���� �Է�: ");
		int English = sc2.nextInt();
		
		
		System.out.printf("����� ���� ������ %d�̰�, ����� %.2f �Դϴ�!", korean+math+English,
//				(korean+math+English)/3.0);
//				(korean+math+English)/3d);
				((double)(korean)+math+English)/3);
		
	}
	


}
