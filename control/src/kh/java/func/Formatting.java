package kh.java.func;

import java.util.Scanner;

public class Formatting {
	
	Scanner sc = new Scanner(System.in);
	public void sample1() {
		System.out.printf("���� �Է�:");
		char ch = sc.next().charAt(0);
		System.out.println((int)(ch));
		
		
	}
	
	public void example1() {
		
		System.out.printf("ù���� �� �Է�:"); 
		int num1 = sc.nextInt();
		System.out.printf("�ι�° �� �Է�:");
		int num2 = sc.nextInt();
		
		System.out.printf("���� �� :%d \n",num1+num2);
		System.out.printf("�� �� :%d \n",num1-num2);
		System.out.printf("���� �� :%d \n",num1*num2);
		System.out.printf("���� �� :%.2f \n",(double)(num1)/num2);
	}
	
	
	public void example4() {
		System.out.printf("���̸� �Է��ϼ��� : ");
		int age = sc.nextInt();
		System.out.println(age>=19? "����Ϸ�":"�̼����ڴ� ���Ա����Դϴ�.");
		
		
		
	}

}
