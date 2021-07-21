package kh.java.func;

import java.util.Scanner;

public class IfTest {
	
	Scanner sc = new Scanner(System.in);

	public void example1() {
		
		System.out.printf("������ ������ �Է��ϼ��� : ");
		int num = sc.nextInt();
		
		if(num<0) {System.out.printf("����� �Է��� ���� %d �����Դϴ�. \n", num);}
		if(num>0) {System.out.printf("����� �Է��� ���� %d ����Դϴ�. \n", num);}
		if(num==0) {System.out.printf("����� �Է��� ���� %d 0�Դϴ�. \n", num);}
		
	}
	
	public void example2() {
		
		System.out.println("ù��° ������ �Է��ϼ��� : ");
		int num1 = sc.nextInt();
		System.out.println("�ι�° ������ �Է��ϼ��� : ");
		int num2 = sc.nextInt();
		
		if(num1==num2) {System.out.printf("%d = %d, �Ѵ� �����ϴ�", num1, num2);}
		if(num1>num2) {System.out.printf("%d > %d, ù��°�� Ů�ϴϴ�", num1, num2);}
		if(num1<num2) {System.out.printf("%d < %d, �ι�°�� Ů�ϴ�", num1, num2);}
	}
	
	
	public void example3() {
		System.out.println("�����ڸ� �����ϼ��� (+,-,*,/) : ");
		char operator = sc.nextLine().charAt(0);
		System.out.println("ù��° ������ �Է��ϼ��� : ");
		int num1 = sc.nextInt();
		System.out.println("�ι�° ������ �Է��ϼ��� : ");
		int num2 = sc.nextInt();
		if(operator=='+') {System.out.println(num1+num2);}
		if(operator=='-') {System.out.println(num1-num2);}
		if(operator=='*') {System.out.println(num1*num2);}
		if(operator=='/') {System.out.println((double)(num1)/num2);}
		
	}	
	
	public void example4() {
		
		System.out.println("===========���̰��� ���α׷�============");
		System.out.print("�����Ͻ� �� �ο��� ����Դϱ� ? : ");
		int total = sc.nextInt();
		System.out.print("��� ����Դϱ� ? (�δ� 15000) : ");
		int adults = sc.nextInt();
		System.out.print("���̴� ����Դϱ� ? (�δ� 5000) : ");
		int kids = sc.nextInt();
		if(total==adults+kids) {System.out.printf("�����Ͻ� �� �ݾ��� : %d "
				, adults*15000+kids*5000);}
		else {System.out.println("�ο� ���� ���� �ʽ��ϴ�. ");}
		
		
	}
	
	public void example5() {
		
		System.out.println("===========���� ���α׷�============");

		int total = 0;
		
		System.out.printf("����� ����� ? (1.apple 2.banana) : ");
		int answer1 = sc.nextInt();
		if(answer1==1) {total++;}
		System.out.println(answer1==1? "����!!":"��!");
		
		
		System.out.printf("�ٳ����� ��� ������ ���� ������ ? (1.��� 2.����) : ");
		int answer2 = sc.nextInt();
		if(answer2==2) {total++;}
		System.out.println(answer2==2? "����!!":"��!");
		
		System.out.printf("�� %d ���� �������ϴ�. ", total);
		
	}
	
	public void example6() {
		System.out.println("=========== �ɸ��׽�Ʈ ============");

		System.out.printf("����� ���� �����մϱ�? (1.yes, 2.no)");
		int answer1 = sc.nextInt();

		if(answer1==1) {
			System.out.printf("��踦 �ǿ쳪��? (1.yes, 2.no)");
			int answer2 = sc.nextInt();
			
			if(answer2==1){System.out.println("���� �ǰ��� ���� �ʽ��ϴ�.");}
			else {System.out.println("���� ���� ���� �ʽ��ϴ�.");}
			}
		else {
			System.out.printf("�̼�ģ���� �ֳ���? (1.yes, 2.no)");
			int answer3 = sc.nextInt();
			
			if(answer3==1){System.out.println("��..��");}
			else {System.out.println("������̤�");}
			
		}
		
		
		
	}
	
	
	public void example7() {
		System.out.println("=======��/�ҹ��� ��ȯ ���α׷�======");
		
		System.out.printf("���� �Է� : ");
		int ch = sc.next().charAt(0);
		System.out.println("=======��� �Է�======");
		
		if(ch>=97&&ch<=122) {
			System.out.println("�ҹ��ڸ� �Է��Ͽ����ϴ�.");
			System.out.printf("�빮�ڷ� ��ȯ : %c", ch-32);}
		else if(ch<=90&&ch>=65){
			System.out.println("�빮�ڸ� �Է��Ͽ����ϴ�.");
			System.out.printf("�ҹ��ڷ� ��ȯ: %c", ch+32);}
		else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�. �����ڸ� �Է����ּ���");
		}
		
	}
	
	
	public void answerExample7() {
		System.out.println("=======��/�ҹ��� ��ȯ ���α׷�======");
		
		System.out.printf("���� �Է� : ");
		char ch = sc.next().charAt(0);
		System.out.println("=======��� �Է�======");
		
		if(ch>='a'&&ch<='z') {
			System.out.println("�ҹ��ڸ� �Է��Ͽ����ϴ�.");
			System.out.printf("�빮�ڷ� ��ȯ : %c", ch-32);
		}else if(ch<='Z'&&ch>='A'){
			System.out.println("�빮�ڸ� �Է��Ͽ����ϴ�.");
			System.out.printf("�ҹ��ڷ� ��ȯ: %c", ch+32);
		}else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�. �����ڸ� �Է����ּ���");
		}
		
	}
	
	
	public void example8() {
		System.out.printf("���� �Է� : ");
		int num = sc.nextInt();


		if(num==0) {
			System.out.printf("[%d]��(��) � ���� ����� �ƴմϴ�.", num);		
		} else if((num%3==0)&&(num%4==0)) {
			System.out.printf("[%d]��(��) 3�� 4�� ��� �Դϴ�.", num);
		} else if(num%3==0) {
			System.out.printf("[%d]��(��) 3�� ��� �Դϴ�.", num);
		} else if(num%4==0) {
			System.out.printf("[%d]��(��) 4�� ��� �Դϴ�.", num); 	
		} else{
			System.out.printf("[%d]��(��) 3�� ����� 4�� ����� �ƴմϴ�.", num);			
			
		}
	}
	
	
	public void answerExample8() {
		System.out.printf("���� �Է� : ");
		int num = sc.nextInt();

		if(num==0 || (num%3!=0&&num%4!=0)) {
			System.out.printf("[%d]��(��) 3�� ����� 4�� ����� �ƴմϴ�.", num);			
		} else if((num%3==0)&&(num%4==0)) {
			System.out.printf("[%d]��(��) 3�� 4�� ��� �Դϴ�.", num);
		} else if(num%3==0) {
			System.out.printf("[%d]��(��) 3�� ��� �Դϴ�.", num);
		} else if(num%4==0) {
			System.out.printf("[%d]��(��) 4�� ��� �Դϴ�.", num); 	
		}
		
		
	}

}
