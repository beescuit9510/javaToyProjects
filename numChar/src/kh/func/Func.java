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
//		문자를 정수로 변환, 50
		System.out.println(1.1+'1');
//		50.1		
		System.out.println('1'+'1');
	}
	
	public void print4() {
//		문자열은 최우선순위로
		System.out.println(1.1+"1");
		System.out.println("1"+1);		
		System.out.println("1"+'1');
		
	}
	
}
