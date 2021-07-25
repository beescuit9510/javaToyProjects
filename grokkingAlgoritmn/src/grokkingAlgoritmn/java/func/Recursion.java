package grokkingAlgoritmn.java.func;

public class Recursion {
//	 divide-and-conquer algorithm 
	
	static int count = 0;
	
	
//	Sum up all the elements in a list
	static int sum(int[] arr) {
		int[] arr2 = new int[arr.length-1];
		System.arraycopy(arr, 1, arr2, 0, arr2.length);
		return arr.length==1? arr[0]:arr[0]+sum(arr2);
//		for(int i : arr) {
//			System.out.print(i+" ");
//		}
//		System.out.println();
	}
	
	
//	Count number of elements in a list
	static int count(int[] arr) {
		if(arr.length==0) {return 0;}
		int[] arr2 = new int[arr.length-1];
		return 1+count(arr2);
	}
	
	
//	Find max int
	static int max(int[] arr) {
		if(arr.length==2) {return arr[0]>arr[1]? arr[0]:arr[1];}
		int[] arr2 = new int[arr.length-1];
		System.arraycopy(arr, 1, arr2, 0, arr.length-1);
		return arr[0]>max(arr2)? arr[0]:max(arr2);
		
		
	}
	
	
//	binarySearch using recursion;
	static boolean binarySearch(int[] arr, int target){
		count++;
		if(arr[arr.length/2]==target){
			System.out.println(count);
			count = 0;
			System.out.println("Found !");
			return true;
		} else if(arr.length==1) {
			count = 0;
			System.out.println("Cannot find target");
			return false;
		} else{
			int[] cloneArr;
			if(arr[arr.length/2]>target) {
				cloneArr = new int[arr.length/2];
				System.arraycopy(arr, 0, cloneArr, 0, cloneArr.length);
			}else {
				cloneArr = new int[arr.length%2==0? arr.length/2:arr.length/2+1];
				System.arraycopy(arr, arr.length/2, cloneArr, 0, cloneArr.length);
			}
			return binarySearch(cloneArr, target);
 
		}
		
	}


}
