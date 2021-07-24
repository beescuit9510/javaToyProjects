package grokkingAlgoritmn.java.func;

import java.util.Random;

public class Search {
	
	
	public void bubbleArray() {
		Random r = new Random();
		int[] arr = new int[5];
		for(int i=0;i<arr.length;i++) {
			arr[i]=r.nextInt(100)+1;
			System.out.print(arr[i]+" \t");
		}
		
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0; j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		System.out.println();
		System.out.println("Á¤·Ä ÈÄ");
	
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" \t");
		}		
		
		
	}
	
	static int binarySearch(int[] array, int target) {}
	static int linkedList(int[] array, int target) {}
	static int quickSort(int[] array, int target) {}
	static int snailSort() {}
	static int reverseSnailSort() {}
	
		
	
	
	
	
	
	
	
	
}
