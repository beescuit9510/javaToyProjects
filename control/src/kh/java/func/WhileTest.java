package kh.java.func;

import java.util.Scanner;

public class WhileTest {
	
	Scanner sc = new Scanner(System.in);
	
	public void example4() {
		System.out.printf("몇 단을 출력 하시겠습니까 ? : ");
		int dan = sc.nextInt();
		System.out.printf("%d단 입니다. %n", dan);
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
			System.out.printf("정수 값을 입력하시오 : ");
			sum += sc.nextInt();	
			num++;
		}
		System.out.printf("입력한 5개의 정수의 합 : %d", sum);
	}
	
	public void example6() {
		System.out.printf("첫번째 수 입력  : ");
		int start = sc.nextInt();
		System.out.printf("두번째 수 입력  : ");
		int end = sc.nextInt();
		
		if(start>end) {int box=start; start=end; end=box;}
		
		int total = 0;
		int num = start;
		while(num<=end) {
			total+=num;
			num++;
		}
		System.out.printf("%d ~ %d의 정수의 합: %d", 
				start, end, total );
	}
	
	public void example7() {
		System.out.printf("숫자 입력 :");
		int num = sc.nextInt();
		
		int total = 0;
		int add=0;
		while(add<=num) {
			total+=add;
			add+=2;
		}
		System.out.printf("짝수들의 합은: %d",total);
	}


}
