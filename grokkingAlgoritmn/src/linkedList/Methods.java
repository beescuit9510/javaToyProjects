package linkedList;
import java.util.Scanner;
import linkedList.*;


public class Methods {
	static public MyLinkedList ml = new MyLinkedList();
	static Scanner sc = new Scanner(System.in);

	public static void signUP() {
		System.out.println("============ 회원 가입 =============");
		signUpLoop();
		System.out.println();
		System.out.println("가입 완료!");
		System.out.println();

	}

	public static void printMember() {
		System.out.println("============ 회원  정보 출력  =============");
		boolean isMember = false;
		String name = "";
		do {
			System.out.printf("이름 입력 : ");
			name = sc.next();
			System.out.println();
			isMember = 	ml.printMember(name);
		} while (!isMember);
			System.out.println();
			System.out.println("1. 회원 정보 수정");
			System.out.println("2. 회원 삭제");
			System.out.println("0. 프로그램 종료");
			System.out.printf("선택 > ");
			int sel = sc.nextInt();
			System.out.println();
			
			switch (sel) {
			case 1:
				ml.delete(name);
				signUpLoop();
				System.out.println("수정 완료!");
				return;
			case 2:
				ml.delete(name);
				System.out.println("삭제 완료!");
				return;
			case 3:
				return;
			}
			
		
	}
	
	  public void addPoint(String name, double point) {
		  ml.addPoint(name, point);

	   }
	
	
	public static void signUpLoop() {
		boolean isMember = false;
		do {
			System.out.printf("이름 입력 : ");
			isMember = ml.signUp(sc.next());
		} while (isMember);
	}

}
