package kh.java.func;

import java.util.Random;
import java.util.Scanner;

public class ArrayTest {
	public void test1() {
		int[] arr1 = new int[5];
		
		
		
//		only numbers can be inside array[]
//		/but in the case of numi its unpossible to discern if its alphabet or num
		
		for(int i=0; i<5; i++) {
//			int num+i = i;
			arr1[i] = i+1;
			System.out.printf("arr1[%d] : %d %n",i, arr1[i]);
		}
		
		int[] arr2 = {1,2,3,4,5};
		for(int i=0; i<arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		
		String[] arr3 = {"hi","hello","kssydgktpdy"};
		
		String[] arr4 = new String[3];
		arr4[0] ="hi";
		arr4[1] ="hello";
		arr4[2] ="안녕하세요";
	}
	
	public void example1() {
		String[] fruit = {"딸기", "복숭아","키위","사과","바나나"};
		for(int i=0;i<fruit.length; i++) {
			System.out.print(fruit[i]+"\t");
		}
		System.out.println();
		System.out.printf(fruit[0]+"\t");
		System.out.printf(fruit[1]+"\t");
		System.out.printf(fruit[2]+"\t");
		System.out.printf(fruit[3]+"\t");
		System.out.printf(fruit[4]+"\t");
	}
	
	
	
	
	public void example2() {
		int[] nums = new int[100];
		for(int i=0;i<nums.length;i++) {
			nums[i] = i+1;
			System.out.println(nums[i]);
		}
	}
	
	
	
	
	public void example3() {
		Scanner sc = new Scanner(System.in);
		int[] grade = new int[4];
		String[] subject = {"국어", "영어", "수학"};
		
		for(int i=0; i<grade.length-1; i++) {
			System.out.println(subject[i]+" 점수 입력:");
			grade[i] = sc.nextInt();
			grade[3]+= grade[i];
		}
		
		System.out.printf("평균 : %.2f", (float)(grade[3])/grade.length);
		
	}
	
	public void example4() {
		Scanner sc = new Scanner(System.in);
		int[] arr1 = new int[5];
		for(int i=0; i<arr1.length;i++) {
			System.out.printf("%d번째 숫자 입력 : %n", i+1);
			arr1[i] = sc.nextInt();
		}
		for(int i=0; i<arr1.length;i++) {
			System.out.println(arr1[i]);
		}
	}
	
	
	
	
	public void $bubbleArray() {
		Random r = new Random();
		int[] arr = new int[5];
		for(int i=0;i<arr.length;i++) {
			arr[i]=r.nextInt(100)+1;
			System.out.print(arr[i]+" \t");
		}
		
		for(int j=0;j<arr.length;j++) {
			for(int i=0; i<arr.length-i;i++) {
				if(arr[i]>arr[i+1]) {
					int temp = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = temp;
				}
			}
		}
		
		System.out.println();
		System.out.println("정렬 후");
	
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" \t");
		}		
		
		
	}
	
	public void reverseBubbleArray() {
		Random r = new Random();
		int[] arr = new int[5];
		
		for(int i=0;i<arr.length;i++) {
			arr[i]=r.nextInt(100)+1;
			System.out.print(arr[i]+" \t");
		}
		
		for(int i=0;i<arr.length;i++) {
			int current = i;
			for(int j=0;j<arr.length;j++) {
				if(arr[current]>arr[j]) {
					int temp = arr[current];
					arr[current] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
//		for(int i=0;i<arr.length;i++) {
//			int current = i;
//			for(int j=current+1;j<arr.length;j++) {
//				if(arr[current]>arr[j]) {
//					int temp = arr[current];
//					arr[current] = arr[j];
//					arr[j] = temp;
//				}
//			}
//		}
		System.out.println();
		System.out.println("정렬 후");
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" \t");
		}		
		
	}

	
}


