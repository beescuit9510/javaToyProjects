package kh.java.func;

import java.util.Scanner;

public class SwitchTest {
	
	Scanner sc = new Scanner(System.in);
	
	public void practice1() {
		System.out.println("���� �Է��ϼ��� : ");
		int month = sc.nextInt();
		
		switch(month) {
		case 8:
			System.out.println("�� ����");
		case 1:
		case 3:
		case 5:
		case 7:
		case 10:
		case 12:
			System.out.println("31��");
			break;
		case 2:
			System.out.println("28��");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("30��");
			break;
		
	}
		
	

}
	public void practice2() {
		System.out.println("�ҹ��� ��ȯ ���α׷�");
		System.out.println("���� �Է� : ");
		char ch = sc.next().charAt(0);
		switch(ch) {
		case 'a':
			System.out.println("AAAAAA");
			break;
		case 90:
			System.out.println("ZZZZZZ");
			break;
//			char �� �����ڵ�� int�� ���ڵ�/���ڵ��Ǳ� ������ ���ڷ� �񱳰���;
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
