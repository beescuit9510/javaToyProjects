package kh.java.func;

public class Variable {
	public void var1() {
		
		String name = "장윤영";
		System.out.println(name);
		
		
	}
	
	public void var2() {	
		final String myName = "장윤영";
		final int myAge = 22;
//		System.out.println("안녕하세요 제 이름은 "+myName+" 이고 나이는 "+myAge+"살입니다");
		System.out.printf("안녕하세요 제 이름은 %s 나이는 %d살 입니다\n", myName, myAge);
	}
	
	
	public void test1() {
		
		int var1 = 100;
		long var2 = 999000000;
		double var3 = 486.520;
		double var4 = 5697.890123;
		char var5 = 'A';
		String str1 = "Hello JAVA";
		boolean var6 = true;
		
		System.out.println(var1);
		System.out.println(var2);
		System.out.println(var3);
		System.out.println(var4);
		System.out.println(var5);
		System.out.println(str1);
		System.out.println(var6);
	}
	
	public void test2() {
		String myName = "장윤영 ";
		int myAge = 22;
		String myHometown = "서울";
		String myNumber = "01021705555";
		String myEmail = "kotis20@naver.com";
		System.out.printf("안녕하세요 제 이름은 %s, 저의 나이 %d, 제가 사는 곳은 %s, 저의 전화번호와 이메일은 %s %s",
				myName, myAge, myHometown, myNumber, myEmail);
	
	}
	 
}
