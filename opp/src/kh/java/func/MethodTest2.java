package kh.java.func;

import java.util.Scanner;

public class MethodTest2 {
	
	public void main() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ù���� ���� �Է� : ");
		int num1 = sc.nextInt();
		System.out.println("�ι��� ���� �Է� : ");
		int num2 = sc.nextInt();
		Calc c = new Calc();
		System.out.println(c.mulFunction(num1, num2));
		
		
	}
	
	public int add(int n, int n2) {
		return(n+n2);
	}

}

