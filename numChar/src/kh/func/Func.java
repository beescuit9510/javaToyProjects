package kh.func;

public class Func {
	
	public void print1() {
		System.out.println(1);
		System.out.println(1.0);
		System.out.println('1');
		System.out.println("1");
	}

	public void print2() {
	 	System.out.println(1+1);
	 	System.out.println(1.0+1.0);
	 	System.out.println('1'+'1');
	 	System.out.println("1"+"1");
	}
	
	public void print3() {
		System.out.println(1+1.0);
		System.out.println(1+1.1);
		System.out.println(1+'9');
//		���ڸ� ������ ��ȯ, 50
		System.out.println(1.1+'1');
//		50.1		
		System.out.println('1'+'1');
	}
	
	public void print4() {
//		���ڿ��� �ֿ켱������
		System.out.println(1.1+"1");
		System.out.println("1"+1);		
		System.out.println("1"+'1');
		
	}
	
}
