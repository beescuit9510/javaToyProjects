package kh.java.func;

import java.util.Scanner;

public class ForTest {
	
//	shift+enter = another line
//	ctrl+alt+up/down = copy;
//	ctrl+D = delete a line;
//	ctrl+enter = align a line
//	shift+up/down = select multiple lines
//	ctrl+n = create a new class/package
//	ctrl+space = import
	
	
	
	public void test1() {
		
		for(int i=0;i<10;i++) {
			System.out.println(i + "��° ���");
			
		}
	}
	public void example1() {

		for(int i=0;i<5;i++) {
			System.out.println("�ȳ��ϼ���");		
		}
	}
	
	public void example2() {
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("��� ����Ͻðڽ��ϱ� ? : ");
		int num = sc.nextInt();
		
		for(int i=0;i<num;i++) {
			System.out.println("�ȳ��ϼ���");
		}
	}
	
	public void example3 () {
		
		System.out.println("2�� �Դϴ�.");
		for(int i=1;i<10;i++) {
			System.out.printf("2 * %d = %d%n",i,2*i);
		}
	}
	
	public void example4() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("�� ���� ��� �Ͻðڽ��ϱ� ? : ");
		int num = sc.nextInt();
		System.out.printf("%d�� �Դϴ�. %n", num);
		
		for(int i=1;i<10;i++) {
			System.out.printf("%d * %d = %d%n",num,i,num*i);			
		}
	}
	
	public void example5() {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for(int i=0;i<5;i++) {
			System.out.printf("���� ���� �Է��Ͻÿ� : ");
			sum += sc.nextInt();
		}
		System.out.printf("�Է��� 5���� ������ �� : %d", sum);
		
	}
	
	public void example6() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("ù��° �� �Է�  : ");
		int start = sc.nextInt();
		System.out.printf("�ι�° �� �Է�  : ");
		int end = sc.nextInt();
		
		if(start>end) {int box=start; start=end; end=box;}
		
//		int start = start>end?start:end;
		
		int total = 0;
		for(int i = start;i<=end;i++) {
			total += i;
		}
		System.out.printf("%d ~ %d�� ������ ��: %d", 
				start, end, total );
	}
	
	
	public void example7() {
		Scanner sc = new Scanner(System.in);
	
		System.out.printf("���� �Է� :");
		int num = sc.nextInt();
		
		int total = 0;
		for(int i=0;i<=num;i+=2) {
			total+=i;
		}
		System.out.printf("¦������ ����: %d",total);
	}

}