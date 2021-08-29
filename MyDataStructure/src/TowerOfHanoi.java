
public class TowerOfHanoi {
	
	public static void main(String[] args) {
		hanoi(5,1,3);
	}

//	steps for implementing recursion !
//	1) Show f(1) works(base case)
//	2) Assume f(n-1) works
//	3) show f(n) works using f(n-1)
//	need to define relationship betwee f(n) and f(n-1) properly
//	 think of Domino if its hard to understand;

	public static void hanoi(int n, int start, int end) {
		boolean cond = (1 <= start) && (start < end);
		if (!cond)
			return;

		if (n == 1)
			pm(start, end);

		else {
			int other = 6 - (start + end);
			System.out.println("n-1 :"+(n-1)+" start :"+start+" other :"+other);
			hanoi(n-1,start,other);
			pm(start,end);
			hanoi(n-1,other,end);
		}
	}

	public static void pm(int start, int end) {
		System.out.println(start + "->" + end);
	}

}
