package kr.or.iei.func;

import java.util.Scanner;

public class Question {
	
	public void exam1() {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		
		for(int i=0;i<arr.length;i++) {
			System.out.printf("%d��° ���� �Է� : ", i+1);
			arr[i] = sc.nextInt();
			System.out.println();
		}
		
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					int tmp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		
		System.out.println("���� ��� : ");
		int sum = 0;
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+"\t");
			sum+=arr[i];
		}
		System.out.println();
		System.out.printf("�Է��� ���� �� ���� : %d", sum);
		
	}
	

}
