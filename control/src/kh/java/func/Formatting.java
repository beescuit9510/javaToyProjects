package kh.java.func;

import java.util.Scanner;

public class Formatting {
	
	Scanner sc = new Scanner(System.in);
	public void sample1() {
		System.out.printf("문자 입력:");
		char ch = sc.next().charAt(0);
		System.out.println((int)(ch));
		
		
	}
	
	public void example1() {
		
		System.out.printf("첫번쨰 수 입력:"); 
		int num1 = sc.nextInt();
		System.out.printf("두번째 수 입력:");
		int num2 = sc.nextInt();
		
		System.out.printf("더한 수 :%d \n",num1+num2);
		System.out.printf("뺀 수 :%d \n",num1-num2);
		System.out.printf("곱한 수 :%d \n",num1*num2);
		System.out.printf("나눈 수 :%.2f \n",(double)(num1)/num2);
	}
	
	
	public void example4() {
		System.out.printf("나이를 입력하세요 : ");
		int age = sc.nextInt();
		System.out.println(age>=19? "입장완료":"미성년자는 출입금지입니다.");
		
		
		
	}

}
