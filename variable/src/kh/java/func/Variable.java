package kh.java.func;

public class Variable {
	public void var1() {
		
		String name = "������";
		System.out.println(name);
		
		
	}
	
	public void var2() {	
		final String myName = "������";
		final int myAge = 22;
//		System.out.println("�ȳ��ϼ��� �� �̸��� "+myName+" �̰� ���̴� "+myAge+"���Դϴ�");
		System.out.printf("�ȳ��ϼ��� �� �̸��� %s ���̴� %d�� �Դϴ�\n", myName, myAge);
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
		String myName = "������ ";
		int myAge = 22;
		String myHometown = "����";
		String myNumber = "01021705555";
		String myEmail = "kotis20@naver.com";
		System.out.printf("�ȳ��ϼ��� �� �̸��� %s, ���� ���� %d, ���� ��� ���� %s, ���� ��ȭ��ȣ�� �̸����� %s %s",
				myName, myAge, myHometown, myNumber, myEmail);
	
	}
	 
}
