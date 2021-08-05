package kh.java.func;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest {
	Scanner sc;
	
	public ExceptionTest() {
		super();
		sc = new Scanner(System.in);
	}
	
	public void test1() {
		System.out.println("���� �Է� : ");
		int n = 0;
		try {
			n = sc.nextInt();
		}catch (Exception e) {
			sc.nextLine();
			System.out.println("���ڸ� �Է����ּ���.");
			test1();
			return;
		}finally {
			System.out.println("������ ������");
		}
		System.out.println("�Է� �Ͻ� ���� �� "+n);	
	}
	
	public void test2() {
		System.out.println("���� �Է� : ");
		if(sc.hasNextInt()) {
			int n = sc.nextInt();
			System.out.println("�Է� �Ͻ� ���� �� "+n);
		}else {
			System.out.println("���ڸ� �Է����ּ���.");
			sc.nextLine();
			test1();
			return;			
		}
	}
	
	public void test3() {
		try {
			System.out.println("���� �Է� : ");
			int n = sc.nextInt();			
			System.out.println("���� �Է� : ");
			int n2 = sc.nextInt();
			System.out.println(n/n2);
		}catch(InputMismatchException e){
			e.printStackTrace();
			System.out.println("������ �Է� ���� !");
		}catch(ArithmeticException e){
			e.printStackTrace();
			System.out.println("������ �Է� ���� !");
		}
	}
	
	public void mainTest4() throws FileNotFoundException{
		test4();
	}
	
	public void test4() throws FileNotFoundException {
		FileInputStream fis = new FileInputStream("test.txt");
//		F2
//		F2
//		F2
//		F2
	}

}
