package kh.java.func;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class ArrayTest {
	public void test1() {
		int[] arr1 = new int[5];

		// only numbers can be inside array[]
		// /but in the case of numi its unpossible to discern if its alphabet or num

		for (int i = 0; i < 5; i++) {
			// int num+i = i;
			arr1[i] = i + 1;
			System.out.printf("arr1[%d] : %d %n", i, arr1[i]);
		}

		int[] arr2 = { 1, 2, 3, 4, 5 };
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}

		String[] arr3 = { "hi", "hello", "kssydgktpdy" };

		String[] arr4 = new String[3];
		arr4[0] = "hi";
		arr4[1] = "hello";
		arr4[2] = "안녕하세요";
	}

	public void example1() {
		String[] fruit = { "딸기", "복숭아", "키위", "사과", "바나나" };
		for (int i = 0; i < fruit.length; i++) {
			System.out.print(fruit[i] + "\t");
		}
		System.out.println();
		System.out.printf(fruit[0] + "\t");
		System.out.printf(fruit[1] + "\t");
		System.out.printf(fruit[2] + "\t");
		System.out.printf(fruit[3] + "\t");
		System.out.printf(fruit[4] + "\t");
	}

	public void example2() {
		int[] nums = new int[100];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i + 1;
			System.out.println(nums[i]);
		}
	}

	public void example3() {
		Scanner sc = new Scanner(System.in);
		int[] grade = new int[4];
		String[] subject = { "국어", "영어", "수학" };

		for (int i = 0; i < grade.length - 1; i++) {
			System.out.println(subject[i] + " 점수 입력:");
			grade[i] = sc.nextInt();
			grade[3] += grade[i];
		}

		System.out.printf("평균 : %.2f", (float) (grade[3]) / grade.length);

	}

	public void example4() {
		Scanner sc = new Scanner(System.in);
		int[] arr1 = new int[5];
		for (int i = 0; i < arr1.length; i++) {
			System.out.printf("%d번째 숫자 입력 : %n", i + 1);
			arr1[i] = sc.nextInt();
		}
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
	}

	public void bubbleArray() {
		Random r = new Random();
		int[] arr = new int[5];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(100) + 1;
			System.out.print(arr[i] + " \t");
		}

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		System.out.println();
		System.out.println("정렬 후");

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " \t");
		}

	}

	// public void reverseBubbleArray() {
	// Random r = new Random();
	// int[] arr = new int[5];
	//
	// for(int i=0;i<arr.length;i++) {
	// arr[i]=r.nextInt(100)+1;
	// System.out.print(arr[i]+" \t");
	// }
	//
	// for(int i=0;i<arr.length;i++) {
	// int current = i;
	// for(int j=0;j<arr.length;j++) {
	// if(arr[current]>arr[j]) {
	// int temp = arr[current];
	// arr[current] = arr[j];
	// arr[j] = temp;
	// }
	// }
	// }
	//
	//// for(int i=0;i<arr.length;i++) {
	//// int current = i;
	//// for(int j=current+1;j<arr.length;j++) {
	//// if(arr[current]>arr[j]) {
	//// int temp = arr[current];
	//// arr[current] = arr[j];
	//// arr[j] = temp;
	//// }
	//// }
	//// }
	// System.out.println();
	// System.out.println("정렬 후");
	// for(int i=0;i<arr.length;i++) {
	// System.out.print(arr[i]+" \t");
	// }
	//
	// }

	public void reverseBubbleArray() {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("%d번째 숫자 입력 : ", i + 1);
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] < arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}

		for (int i = 0; i < arr.length - 1; i++) {
			System.out.print(arr[i] + "\t");
		}
	}

	public void lotto() {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();

		int[] inputNums = new int[6];
		int[] comNums = new int[6];

		System.out.println("========= 로또 프로그램 =========");

		boolean run = true;
		while (run) {
			for (int i = 0; i < inputNums.length; i++) {
				int tmp = 0;
				boolean overlap = false;
				boolean limit = false;
				do {
					limit = false;
					overlap = false;
					System.out.printf("%d번째 번호 입력(1~45) : ", i + 1);
					tmp = sc.nextInt();
					inputNums[i] = tmp;

					if (tmp <= 0 || tmp > 45) {
						limit = true;
						System.out.println("1~45 사이 번호를 입력해주세요.");
					}

					for (int k = 0; k < inputNums.length; k++) {
						if (tmp == inputNums[k] && tmp != 0) {
							overlap = k != i ? true : false;
							if (overlap) {
								System.out.println("중복된 값 입니다.");
							}
							break;
						}
					}
				} while (limit || overlap);

				for (int j = 0; j < comNums.length; j++) {
					// comNums[i] = i+1;
					comNums[i] = r.nextInt(46) + 1;
					for (int k = 0; k < comNums.length; k++) {
						if (comNums[i] == comNums[k] && i != k) {
							j--;
						}
					}
				}
			}

			for (int i = 0; i < inputNums.length - 1; i++) {
				for (int j = 0; j < inputNums.length - i - 1; j++) {
					if (inputNums[j] > inputNums[j + 1]) {
						int temp = inputNums[j];
						inputNums[j] = inputNums[j + 1];
						inputNums[j + 1] = temp;
					}
				}
			}
			for (int i = 0; i < comNums.length - 1; i++) {
				for (int j = 0; j < comNums.length - i - 1; j++) {
					if (comNums[j] > comNums[j + 1]) {
						int temp = comNums[j];
						comNums[j] = comNums[j + 1];
						comNums[j + 1] = temp;
					}
				}
			}

			boolean myturn = true;

			for (int j = 0; j < 2; j++) {
				if (myturn) {
					System.out.println("사용자 번호 ");
				} else {
					System.out.println("컴퓨터 번호 ");
				}
				for (int i = 0; i < inputNums.length; i++) {
					System.out.print(myturn ? inputNums[i] + " " : comNums[i] + " ");
				}
				System.out.println();
				myturn = !myturn;

			}

			int count = 0;
			for (int i = 0; i < comNums.length; i++) {
				for (int j = 0; j < comNums.length; j++) {
					if (inputNums[i] == comNums[j]) {
						count++;
					}
				}
			}

			System.out.println("맞힌 갯수 : " + count);

			// 48 – 57
			int grade = 49 + 6 - count;
			System.out.printf(grade == 7 ? "당신은 꽝 입니다." : "당신은 %c 등 입니다", grade);

			System.out.println();
			System.out.println("한번 더 하시겠습니까(1.yes,2.no)?");
			run = sc.nextInt() == 1 ? true : false;

		}

	}

	public void $array() {
		int[] arr1 = { 1, 2, 3, 4, 5 };
		int[][] arr2 = { { 100, 400, 300 }, { 500, 200, 600 } };
		int[][] arr3 = new int[3][3];
		// int[][] arr3 = {{1,2,3},{4,5,6},{7,8,9}};

		int count = 1;
		for (int i = 0; i < arr3.length; i++) {
			for (int j = 0; j < arr3[i].length; j++) {
				arr3[i][j] = count++;
				System.out.println(arr3[i][j]);
			}
		}
	}

	public void example6() {
		int[][] arr = new int[5][5];
		int k = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = arr[i].length - 1; j > -1; j--) {
				arr[i][j] = ++k;

			}

		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public void example7() {
		int[][] arr = new int[5][5];
		int k = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[j][i] = ++k;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}

	}

	public void example8() {
		int[][] arr = new int[5][5];
		int k = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = arr[i].length - 1; j > -1; j--) {
				arr[j][i] = ++k;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}

	}

	public void example9() {
		int[][] arr = new int[5][5];
		int k = 0;
		boolean turn = true;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				arr[i][turn ? j : 4 - j] = ++k;

			}
			turn = !turn;
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}

	}

	public void reverseSnail() {
		int[][] arr = new int[5][5];

		int size = arr.length;
		int k = 1;
		int col = -1;
		int row = 0;
		int increase = 1;

		while (size > 0) {

			for (int i = 0; i < size; i++) {
				col += increase;
				arr[row][4 - col] = k++;
			}

			size--;
			for (int i = 0; i < size; i++) {
				row += increase;
				arr[row][4 - col] = k++;

			}
			increase = -increase;

		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}

	public void snail() {
		int[][] arr = new int[5][5];
		int size = arr.length - 1;
		int k = 1;
		int col = -1;
		int row = 0;
		int increase = 1;

		while (size > 0) {

			for (int i = 0; i < size; i++) {
				col += increase;
				arr[row][col] = k++;

			}
			size--;

			for (int i = 0; i < size; i++) {
				row += increase;
				arr[row][col] = k++;
			}
			increase = -increase;

		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}

	}

	// public void $snail123() {
	//
	// int[][] arr = new int[5][5];
	// int size = arr.length-1;
	//
	// int k = 0;
	// int col = 0;
	// int row = 0;
	// int rightcol = 0;
	// int leftcol = 0;
	//
	// while(size>0) {
	//
	// for(int i=0+leftcol;i<arr.length-rightcol;i++) {
	// arr[row][i] = ++k;
	// }
	// rightcol++;
	// size--;
	// for(int i=0;i<arr.length;i++) {
	// arr[i][4-col] = ++k;
	//
	// }
	//
	// for(int i=0+leftcol;i<arr.length-rightcol;i++) {
	// arr[4-row][i] = ++k;
	// }
	// rightcol++;
	// row++;
	// for(int i=0;i<arr.length-rightcol;i++) {
	// arr[size-i][col] = ++k;
	// }
	// leftcol++;
	// col++;
	// size--;
	// System.out.println(rightcol);
	// System.out.println(leftcol);
	// for(int i=0+leftcol;i<arr.length-rightcol;i++) {
	// arr[row][i] = ++k;
	// }
	// }
	//
	//
	public void lottery2() {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		HashSet<Integer> useNums = new HashSet<Integer>();
		HashSet<Integer> comNums = new HashSet<Integer>();
		while (useNums.size() < 6) {
			System.out.printf("%d번째 숫자 입력 : ", useNums.size() + 1);
			if (!useNums.add(sc.nextInt())) {
				System.out.println("중복 숫자 입니다. 다시 입력 해주세요.");
			}
		}
		while (comNums.size() < 6) {
			comNums.add(r.nextInt(45) + 1);
		}
		Collection[] arr = { useNums, comNums };
		for (Collection h : arr) {
			for (Object i : (HashSet) h) {
				System.out.print(i + "\t");
			}
			System.out.println();
		}
	}

}
