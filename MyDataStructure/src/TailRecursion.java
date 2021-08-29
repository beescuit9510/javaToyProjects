import java.util.ArrayList;

public class TailRecursion {
	
	
//	steps for implementing recursion !
//	1) Show f(1) works(base case)
//	2) Assume f(n-1) works
//	3) show f(n) works using f(n-1)
//	need to define relationship betwee f(n) and f(n-1) properly
//	 think of Domino if its hard to understand;

	public static void main(String[] args) {
		tailRecurUsingStack(4);
	}

	// find the great common factor using Eucliean algorithmn;
	static int euclideanGCD(int x, int y) {
		if (y == 0)
			return x;
		else
			return euclideanGCD(y, x % y);
	}

	static void recur(int n) {
		if (n > 0) {
			recur(n - 2);
			System.out.print(n+"\t");
			recur(n - 1);
		}

	}

	static void tailRecur(int n) {
		while (n > 0) {
			recur(n - 1);
			System.out.print(n+"\t");
			n = n - 2;
		}

	}

	static void tailRecurUsingStack(int n) {
		
		MyIntStack s = new MyIntStack(n);
		while (true) {
			if(n > 0) {
				s.push(n);
				n = n-1;
				continue;
			}
			if(!s.isEmpty()){
				n = s.pop();
//				System.out.println("s.pop() : "+n);
				System.out.print(n+"\t");
				n = n - 2;
				continue;
			}
			
			break;
		}
		
	}
	
	

	static int factorial(int n) {
		int go = 1;
		
		while (n > 0) {
			go = facGo(n--, go);
		}

		return go;

	}

	static int facGo(int x, int y) {
		return x * y;
	}
	
	
	
	
	static ArrayList<Integer> fibonacci(int n) {
		ArrayList<Integer> fib = new ArrayList<Integer>();
		
		int prv = 0;
		int x = 1;
		fib.add(prv);

		while(fib.size()!=n) {
			fib.add(x);
			int box = x;
			x = fibGo(prv, x);
			prv = box;
			
		}
		return fib;
		
	}
	
	static int fibGo(int prv, int r) {
		return prv+r;
	}

}
