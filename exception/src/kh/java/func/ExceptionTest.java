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
		System.out.println("숫자 입력 : ");
		int n = 0;
		try {
			n = sc.nextInt();
		}catch (Exception e) {
			sc.nextLine();
			System.out.println("숫자를 입력해주세요.");
			test1();
			return;
		}finally {
			System.out.println("무조건 무조건");
		}
		System.out.println("입력 하신 숫자 는 "+n);	
	}
	
	public void test2() {
		System.out.println("숫자 입력 : ");
		if(sc.hasNextInt()) {
			int n = sc.nextInt();
			System.out.println("입력 하신 숫자 는 "+n);
		}else {
			System.out.println("숫자를 입력해주세요.");
			sc.nextLine();
			test1();
			return;			
		}
	}
	
	public void test3() {
		try {
			System.out.println("숫자 입력 : ");
			int n = sc.nextInt();			
			System.out.println("숫자 입력 : ");
			int n2 = sc.nextInt();
			System.out.println(n/n2);
		}catch(InputMismatchException e){
			e.printStackTrace();
			System.out.println("정수만 입력 가능 !");
		}catch(ArithmeticException e){
			e.printStackTrace();
			System.out.println("정수만 입력 가능 !");
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
