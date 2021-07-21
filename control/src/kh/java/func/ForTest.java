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
			System.out.println(i + "번째 출력");
			
		}
	}
	public void example1() {

		for(int i=0;i<5;i++) {
			System.out.println("안녕하세요");		
		}
	}
	
	public void example2() {
		
		Scanner sc = new Scanner(System.in);
		System.out.printf("몇번 출력하시겠습니까 ? : ");
		int num = sc.nextInt();
		
		for(int i=0;i<num;i++) {
			System.out.println("안녕하세요");
		}
	}
	
	public void example3 () {
		
		System.out.println("2단 입니다.");
		for(int i=1;i<10;i++) {
			System.out.printf("2 * %d = %d%n",i,2*i);
		}
	}
	
	public void example4() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("몇 단을 출력 하시겠습니까 ? : ");
		int num = sc.nextInt();
		System.out.printf("%d단 입니다. %n", num);
		
		for(int i=1;i<10;i++) {
			System.out.printf("%d * %d = %d%n",num,i,num*i);			
		}
	}
	
	public void example5() {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for(int i=0;i<5;i++) {
			System.out.printf("정수 값을 입력하시오 : ");
			sum += sc.nextInt();
		}
		System.out.printf("입력한 5개의 정수의 합 : %d", sum);
		
	}
	
	public void example6() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("첫번째 수 입력  : ");
		int start = sc.nextInt();
		System.out.printf("두번째 수 입력  : ");
		int end = sc.nextInt();
		
		if(start>end) {int box=start; start=end; end=box;}
		
//		int start = start>end?start:end;
		
		int total = 0;
		for(int i = start;i<=end;i++) {
			total += i;
		}
		System.out.printf("%d ~ %d의 정수의 합: %d", 
				start, end, total );
	}
	
	
	public void example7() {
		Scanner sc = new Scanner(System.in);
	
		System.out.printf("숫자 입력 :");
		int num = sc.nextInt();
		
		int total = 0;
		for(int i=0;i<=num;i+=2) {
			total+=i;
		}
		System.out.printf("짝수들의 합은: %d",total);
	}

}