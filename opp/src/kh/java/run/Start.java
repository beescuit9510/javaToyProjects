package kh.java.run;

import java.util.Random;

import java.util.RandomAccess;

import kh.java.func.Animal;
import kh.java.func.Bclass;
import kh.java.func.Calc;
import kh.java.func.Cat;
import kh.java.func.MethodTest;
import kh.java.func.MethodTest2;
import kh.java.func.Student;
import kh.java.func.Tiger;
import kh.java.func.Tv;

public class Start {
	
	
	
	public static void main(String[] args) {
	
//		String[] str = {"Cat","Tiger"};
		
		
		
		
		Animal[] animals = {new Cat(), new Tiger()};
		for(int i=0;i<animals.length;i++) {
//			str a = ((str)animals[i]);
			Cat a = ((Cat)animals[i]);
			Tiger b = ((Tiger)animals[i]);
//			((Cat)animals[i]).grooming();
		}
		
		
		
		
		
//		for(int i=0;i<37;i++) {
//			System.out.println(i);
//			int num = i;
//			do {
//				if(num%10%3==0&num%10!=0) {
//					System.out.printf("¦");
//					System.out.println();
//				}
//				
//			}while((num/=10)!=0);				
//		}
//		int[] arr = new int[10000];
//		for(int i=0;i<10000;i++) {
//			arr[i] = i+1;
//		
		
		
		
}
		
	
	
	
	static int[] quickSort(int[] arr) {
		if(arr.length<2) {
			return arr;
			} else {
			int[][] tmp = new int[2][arr.length-1];
			int prevIn=0;
			int afterIn=0;
			int pivot = arr[0];
			for(int num: arr) {
				if(num<pivot) {
					tmp[0][prevIn] = num;
					prevIn++;
				}else {
					tmp[1][afterIn] = num;
					afterIn++;
				}
			}
			int[] prev = new int[prevIn];
			int[] after = new int[afterIn];
			System.arraycopy(tmp[0], 0, prev, 0, prevIn);
			System.arraycopy(tmp[1], 0, after, 0, afterIn);
			
			
			
//			
//			for(int num: tmp[1]) {
//				System.out.print(num+"   ");
//			}
//			System.out.println();
//			for(int i=0;i<2;i++) {
//				for(int j=0;j<prevIn;j++) {
//					prev[j] = tmp[0][j];
//				}
//			}
//			for(int i=0;i<2;i++) {
//				for(int j=0;j<afterIn;j++) {
//					after[j] = tmp[1][j];
//				}
//			}
			int[] prevArr = quickSort(prev);
			int[] afterArr = quickSort(after);
//			System.out.println();
//			System.out.println("tmp lengh");
//			System.out.println(tmp[1].length);
//			System.out.println(afterIn);
//			System.out.println("=====tmp lengh");
//	//
//			
			int[] completeArr = new int[arr.length]; 
//			completeArr[prevArr.length] = arr[0];
			System.arraycopy(prevArr, 0, completeArr, 0, prevArr.length);
			
			System.arraycopy(afterArr, prevArr.length, completeArr, prevArr.length, afterArr.length);
			
			return completeArr;
					
		}
	}
	
		
	
	
	
	


}