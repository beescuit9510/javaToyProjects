package kh.java.func;

public class TryWithResources {
	
	public static void main(String[] args) {
		
		try {
			int a = 10;
			int b = 0;
			int c = a/b;
			System.out.println("end of a try block");
			ArithmeticException ar = new ArithmeticException();
//			ar.
			throw new RuntimeException();
			
			
		}catch(Exception e) {
			System.out.println("catching exception");
		}finally {
			try {
				int a = 10;
				int b = 0;
				int c = a/b;
				System.out.println("end of a finally blcok");				
			}catch(Exception e) {
				System.out.println("catching exception inside a finally block");				
			}
		}
		
		
	}

}
