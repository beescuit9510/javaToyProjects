package kh.java.func;

import java.util.Scanner;

public class IfTest {
	
	Scanner sc = new Scanner(System.in);

	public void example1() {
		
		System.out.printf("임의의 정수를 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num<0) {System.out.printf("당신이 입력한 수는 %d 음수입니다. \n", num);}
		if(num>0) {System.out.printf("당신이 입력한 수는 %d 양수입니다. \n", num);}
		if(num==0) {System.out.printf("당신이 입력한 수는 %d 0입니다. \n", num);}
		
	}
	
	public void example2() {
		
		System.out.println("첫번째 정수를 입력하세요 : ");
		int num1 = sc.nextInt();
		System.out.println("두번째 정수를 입력하세요 : ");
		int num2 = sc.nextInt();
		
		if(num1==num2) {System.out.printf("%d = %d, 둘다 같습니다", num1, num2);}
		if(num1>num2) {System.out.printf("%d > %d, 첫번째가 큽니니다", num1, num2);}
		if(num1<num2) {System.out.printf("%d < %d, 두번째가 큽니다", num1, num2);}
	}
	
	
	public void example3() {
		System.out.println("연산자를 선택하세요 (+,-,*,/) : ");
		char operator = sc.nextLine().charAt(0);
		System.out.println("첫번째 정수를 입력하세요 : ");
		int num1 = sc.nextInt();
		System.out.println("두번째 정수를 입력하세요 : ");
		int num2 = sc.nextInt();
		if(operator=='+') {System.out.println(num1+num2);}
		if(operator=='-') {System.out.println(num1-num2);}
		if(operator=='*') {System.out.println(num1*num2);}
		if(operator=='/') {System.out.println((double)(num1)/num2);}
		
	}	
	
	public void example4() {
		
		System.out.println("===========놀이공원 프로그램============");
		System.out.print("입장하실 총 인원은 몇명입니까 ? : ");
		int total = sc.nextInt();
		System.out.print("어른은 몇명입니까 ? (인당 15000) : ");
		int adults = sc.nextInt();
		System.out.print("아이는 몇명입니까 ? (인당 5000) : ");
		int kids = sc.nextInt();
		if(total==adults+kids) {System.out.printf("지불하실 총 금액은 : %d "
				, adults*15000+kids*5000);}
		else {System.out.println("인원 수가 맞지 않습니다. ");}
		
		
	}
	
	public void example5() {
		
		System.out.println("===========퀴즈 프로그램============");

		int total = 0;
		
		System.out.printf("사과는 영어로 ? (1.apple 2.banana) : ");
		int answer1 = sc.nextInt();
		if(answer1==1) {total++;}
		System.out.println(answer1==1? "정답!!":"땡!");
		
		
		System.out.printf("바나나는 길어 길으면 기차 기차는 ? (1.비싸 2.빨라) : ");
		int answer2 = sc.nextInt();
		if(answer2==2) {total++;}
		System.out.println(answer2==2? "정답!!":"땡!");
		
		System.out.printf("총 %d 문제 맞혔습니다. ", total);
		
	}
	
	public void example6() {
		System.out.println("=========== 심리테스트 ============");

		System.out.printf("당신은 술을 좋아합니까? (1.yes, 2.no)");
		int answer1 = sc.nextInt();

		if(answer1==1) {
			System.out.printf("담배를 피우나요? (1.yes, 2.no)");
			int answer2 = sc.nextInt();
			
			if(answer2==1){System.out.println("담배는 건강에 좋지 않습니다.");}
			else {System.out.println("술은 간에 좋지 않습니다.");}
			}
		else {
			System.out.printf("이성친구가 있나요? (1.yes, 2.no)");
			int answer3 = sc.nextInt();
			
			if(answer3==1){System.out.println("올..ㅋ");}
			else {System.out.println("힘내요ㅜㅜ");}
			
		}
		
		
		
	}
	
	
	public void example7() {
		System.out.println("=======대/소문자 변환 프로그램======");
		
		System.out.printf("문자 입력 : ");
		int ch = sc.next().charAt(0);
		System.out.println("=======결과 입력======");
		
		if(ch>=97&&ch<=122) {
			System.out.println("소문자를 입력하였습니다.");
			System.out.printf("대문자로 변환 : %c", ch-32);}
		else if(ch<=90&&ch>=65){
			System.out.println("대문자를 입력하였습니다.");
			System.out.printf("소문자로 변환: %c", ch+32);}
		else {
			System.out.println("잘못 입력하셨습니다. 영문자를 입력해주세요");
		}
		
	}
	
	
	public void answerExample7() {
		System.out.println("=======대/소문자 변환 프로그램======");
		
		System.out.printf("문자 입력 : ");
		char ch = sc.next().charAt(0);
		System.out.println("=======결과 입력======");
		
		if(ch>='a'&&ch<='z') {
			System.out.println("소문자를 입력하였습니다.");
			System.out.printf("대문자로 변환 : %c", ch-32);
		}else if(ch<='Z'&&ch>='A'){
			System.out.println("대문자를 입력하였습니다.");
			System.out.printf("소문자로 변환: %c", ch+32);
		}else {
			System.out.println("잘못 입력하셨습니다. 영문자를 입력해주세요");
		}
		
	}
	
	
	public void example8() {
		System.out.printf("정수 입력 : ");
		int num = sc.nextInt();


		if(num==0) {
			System.out.printf("[%d]은(는) 어떤 수의 배수도 아닙니다.", num);		
		} else if((num%3==0)&&(num%4==0)) {
			System.out.printf("[%d]은(는) 3과 4의 배수 입니다.", num);
		} else if(num%3==0) {
			System.out.printf("[%d]은(는) 3의 배수 입니다.", num);
		} else if(num%4==0) {
			System.out.printf("[%d]은(는) 4의 배수 입니다.", num); 	
		} else{
			System.out.printf("[%d]은(는) 3의 배수도 4의 배수도 아닙니다.", num);			
			
		}
	}
	
	
	public void answerExample8() {
		System.out.printf("정수 입력 : ");
		int num = sc.nextInt();

		if(num==0 || (num%3!=0&&num%4!=0)) {
			System.out.printf("[%d]은(는) 3의 배수도 4의 배수도 아닙니다.", num);			
		} else if((num%3==0)&&(num%4==0)) {
			System.out.printf("[%d]은(는) 3과 4의 배수 입니다.", num);
		} else if(num%3==0) {
			System.out.printf("[%d]은(는) 3의 배수 입니다.", num);
		} else if(num%4==0) {
			System.out.printf("[%d]은(는) 4의 배수 입니다.", num); 	
		}
		
		
	}

}
