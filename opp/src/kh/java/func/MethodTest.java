package kh.java.func;

import java.util.Scanner;

public class MethodTest {
	
	
	public void main() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ù???? ???? ?Է? : ");
		int num1 = sc.nextInt();
		System.out.println("?ι??? ???? ?Է? : ");
		int num2 = sc.nextInt();
		
		Calc c = new Calc();
		System.out.println(c.mulFunction(num1, num2));
		System.out.println(c.addFunction(num1, num2));
		System.out.println(c.subFunction(num1, num2));
		System.out.println(c.divFunction(num1, num2));
		

	}
	
	public double add(int  num1, int num2) {
		double sum = num1+(double)num2;
		return(sum);
		
	}


}
