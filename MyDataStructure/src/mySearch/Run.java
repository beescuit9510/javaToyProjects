package mySearch;

import java.util.Arrays;


public class Run {
	public static void main(String[] args) {
		MyBinarySearch binarySearch = new MyBinarySearch();
//		MySequentialSearch sequentialSearch = new MySequentialSearch();
		
		
		int[] list = new int[100];
		for(int i=0;i<100;i++) {
			list[i] = i+1;
		}
		int[] list2 = {1,2,9,0,0,9,0,9};
		int[] list3 = {8,9,9,9,10,11,11,12};
		
		int[][] lists = {list,list2,list3};
		
		
		









		
		
//		int b = binarySearch.binarySearchFindTheFisrtIndex(list3, 22);
//		System.out.println(b);
//		int[] r = sequentialSearch.sequentialSearch(list2, 9);
//		for(int i=0;i<r.length;i++) {
//			System.out.println(r[i]);			
//		}
	}
}
