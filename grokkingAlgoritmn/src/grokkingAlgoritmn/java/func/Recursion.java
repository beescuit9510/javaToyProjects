package grokkingAlgoritmn.java.func;

public class Recursion {
	
	
	static int sum(int[] arr) {
		int[] arr2 = new int[arr.length-1];
		System.arraycopy(arr, 1, arr2, 0, arr2.length);
		return arr.length==1? arr[0]:arr[0]+sum(arr2);
//		for(int i : arr) {
//			System.out.print(i+" ");
//		}
//		System.out.println();
	}

}
