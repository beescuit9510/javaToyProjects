package kh.java.func;

import java.util.Scanner;

public class Calc {
	
//	F3 !!!!!!!!!!!!!!!!!!!!
//	F3 !!!!!!!!!!!!!!!!!!!!
//	F3 !!!!!!!!!!!!!!!!!!!!
//	F3 !!!!!!!!!!!!!!!!!!!!
//	F3 !!!!!!!!!!!!!!!!!!!!
//	F3 !!!!!!!!!!!!!!!!!!!!
//	F3 !!!!!!!!!!!!!!!!!!!!
//	F3 !!!!!!!!!!!!!!!!!!!!
//	F3 !!!!!!!!!!!!!!!!!!!!
//	F3 !!!!!!!!!!!!!!!!!!!!
//	F3 !!!!!!!!!!!!!!!!!!!!
//	F3 !!!!!!!!!!!!!!!!!!!!
//	F3 !!!!!!!!!!!!!!!!!!!!
//	F3 !!!!!!!!!!!!!!!!!!!!
//	F3 !!!!!!!!!!!!!!!!!!!!
//	F3 !!!!!!!!!!!!!!!!!!!!
	
	public void main() {
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번쨰 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.println("두번쨰 정수 입력 : ");
		int num2 = sc.nextInt();
		
		int r1 = addFunction(num1, num2);
		int r2 = subFunction(num1, num2);
		int r3 = mulFunction(num1, num2);
		double r4 = divFunction(num1, num2);
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
		System.out.println(r4);
	}
	
	
	public int addFunction(int num1, int num2) {
		return(num1+num2);
		
	}
	
	public int subFunction(int num1, int num2) {
		return(num1-num2);
		
	}
	
	int mulFunction(int num1, int num2) {
		return(num1*num2);
		
	}
	
	public double divFunction(int num1, int num2) {
		return(num1/(double)num2);
		
	}

}
