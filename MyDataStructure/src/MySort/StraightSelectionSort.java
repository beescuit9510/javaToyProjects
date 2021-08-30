package MySort;

public class StraightSelectionSort {

	public static void main(String[] args) {

		int[] list = { 1, 2, 3, 4, 9, 8, 7, 2, 1, 3, 10, 12, 16, 4 };
		straightSelectionSort(list);

	}

	public static void straightSelectionSort(int[] list) {
		int len = list.length;
		int idx = 0;
		int start = 0;

		for (int i = 0; i < len - 1; i++) {
			int min = start;
			for (int j = start; j < len; j++) {
				min = list[min] < list[j] ? min : j;
			}
			start++;
			swap(list, idx++, min);
		}

		for (int i : list) {
			System.out.print(i + "\t");
		}
	}

	public static void swap(int[] list, int idx, int minIndx) {
		int box = list[idx];
		list[idx] = list[minIndx];
		list[minIndx] = box;

	}

}
