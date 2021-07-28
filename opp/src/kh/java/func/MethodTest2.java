package kh.java.func;

import java.util.Scanner;

public class MethodTest2 {
	
	public void main() {
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번쨰 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.println("두번쨰 정수 입력 : ");
		int num2 = sc.nextInt();
		Calc c = new Calc();
		System.out.println(c.mulFunction(num1, num2));
		
		
	}
	
	public int add(int n, int n2) {
		return(n+n2);
	}

}

