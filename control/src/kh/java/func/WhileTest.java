package kh.java.func;

import java.util.Scanner;

public class WhileTest {
	
	Scanner sc = new Scanner(System.in);
	
	public void example4() {
		System.out.printf("�� ���� ��� �Ͻðڽ��ϱ� ? : ");
		int dan = sc.nextInt();
		System.out.printf("%d�� �Դϴ�. %n", dan);
		int num = 1;
		while(num<10) {
			System.out.printf("%d * %d = %d%n", dan,num,dan*num);
			num++;
		}

	}
	
	public void example5() {
		int sum = 0;
		int num = 0;
		while(num<5) {
			System.out.printf("���� ���� �Է��Ͻÿ� : ");
			sum += sc.nextInt();	
			num++;
		}
		System.out.printf("�Է��� 5���� ������ �� : %d", sum);
	}
	
	public void example6() {
		System.out.printf("ù��° �� �Է�  : ");
		int start = sc.nextInt();
		System.out.printf("�ι�° �� �Է�  : ");
		int end = sc.nextInt();
		
		if(start>end) {int box=start; start=end; end=box;}
		
		int total = 0;
		int num = start;
		while(num<=end) {
			total+=num;
			num++;
		}
		System.out.printf("%d ~ %d�� ������ ��: %d", 
				start, end, total );
	}
	
	public void example7() {
		System.out.printf("���� �Է� :");
		int num = sc.nextInt();
		
		int total = 0;
		int add=0;
		while(add<=num) {
			total+=add;
			add+=2;
		}
		System.out.printf("¦������ ����: %d",total);
	}


}
