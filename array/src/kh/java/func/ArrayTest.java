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
	
	public void $reverseBubbleArray() {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		for(int i=0;i<arr.length;i++) {
			System.out.printf("%d번째 숫자 입력 : ", i+1);
			arr[i] = sc.nextInt();
		}
		
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-1-i;j++) {
				if(arr[j]<arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		for(int i=0;i<arr.length-1;i++) {
			System.out.print(arr[i]+"\t");
		}
	}
	
	
	public void lotto() {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		
		int[] inputNums = new int[6];
		int[] comNums = new int[6];
		
		System.out.println("========= 로또 프로그램 =========");
		
		boolean run = true;
		while(run) {
			for(int i=0;i<inputNums.length;i++) {
				int tmp = 0;
				boolean overlap = false;
				boolean limit = false;
				do {
					limit = false;
					overlap = false;
					System.out.printf("%d번째 번호 입력(1~45) : ", i+1);
					tmp = sc.nextInt();
					inputNums[i]=tmp;
					
					
					if(tmp<=0||tmp>45) {
						limit = true;
						System.out.println("1~45 사이 번호를 입력해주세요.");
					}
					
					for(int k=0;k<inputNums.length;k++) {
						if(tmp==inputNums[k]&&tmp!=0) {
							overlap = k!=i ? true:false;
							if(overlap) {
								System.out.println("중복된 값 입니다.");
							}
							break;
						}
					}
//					System.out.println();
				}while(limit||overlap);
				
				for(int j=0;j<comNums.length;j++) {
					comNums[i] = r.nextInt(46)+1;
				}				
			}
			
			for(int i=0;i<inputNums.length-1;i++) {
				for(int j=0;j<inputNums.length-i-1;j++) {
					if(inputNums[j]>inputNums[j+1]) {
						int temp = inputNums[j];
						inputNums[j] = inputNums[j+1];
						inputNums[j+1] = temp;
					}
				}
			}
			for(int i=0;i<comNums.length-1;i++) {
				for(int j=0;j<comNums.length-i-1;j++) {
					if(comNums[j]>comNums[j+1]) {
						int temp = comNums[j];
						comNums[j] = comNums[j+1];
						comNums[j+1] = temp;
					}
				}
			}
			
			boolean myturn = true;
			
			for(int j=0; j<2;j++) {
				if(myturn) {
					System.out.println("사용자 번호 ");
				}else {
					System.out.println("컴퓨터 번호 ");
				}
				for(int i=0;i<inputNums.length;i++) {
					System.out.print(myturn ? inputNums[i]+" ":comNums[i]+" ");
				}	
				System.out.println();
				myturn=!myturn;
				
			}
			
			
			int count = 0;
			for(int i=0;i<comNums.length-1;i++) {
				for(int j=0;j<comNums.length;j++) {
					if(inputNums[i]==comNums[j]) {
						count++;
					}		
				}
			}
			
			System.out.println("맞힌 갯수 : "+count);
			
			
//			48 – 57
			int grade = 49+6-count;
			System.out.printf(grade==7? "당신은 꽝 입니다.":"당신은 %c 등 입니다", grade);
			
			System.out.println();
			System.out.println("한번 더 하시겠습니까(1.yes,2.no)?");
			run = sc.nextInt()==1? true:false;
			
		}
	

		
		
		
	}
	


	
}


