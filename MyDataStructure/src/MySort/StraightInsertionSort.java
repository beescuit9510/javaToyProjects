package MySort;

public class StraightInsertionSort {

	public static void main(String[] args) {

		int[] list = { 1, 3, 2, 4, 9, 8, 7, 2, 1, 3, 10, 12, 16, 4 };
		int[] list2 = { 1, 3, 2, 4, 9, 8, 7, 2, 1, 3, 10, 12, 16, 4 };
		binaryInsertionSort(list);
		for (int k : list) {
			System.out.print(k + "\t");

		}

	}

	public static void binaryInsertionSort(int[] list) {
		int len = list.length;
//
		int i, sorted, toExchg, selected;
//
		for (i = 1; i < len; ++i) {
			sorted = i - 1;
			selected = list[i];

			toExchg = binarySearch(list, selected, 0, sorted);

			while (sorted >= toExchg) {
				list[sorted + 1] = list[sorted];
				sorted--;
			}

			list[sorted + 1] = selected;

		}

	}

	private static int binarySearch(int[] list, int selected, int bottom, int ceil) {

		int mid = (bottom + ceil) / 2;

		if (bottom >= ceil) {
			return selected > list[bottom] ? (bottom + 1) : bottom;
		}

		if (list[mid] == selected) {
			return mid + 1;
		}

		if (list[mid] < selected)
			return binarySearch(list, selected, mid + 1, ceil);

		return binarySearch(list, selected, bottom, mid - 1);

	}

	public static void straightInsertionSort(int[] list) {
		int len = list.length;

		for (int i = 0; i < len; i++) {
			swap(list, i);
		}

		for (int i : list) {
			System.out.print(i + "\t");
		}
	}

	public static void swap(int[] list, int idx) {

		for (int i = idx; i > 0; i--) {
			if (list[i] < list[i - 1]) {
				int box = list[i];
				list[i] = list[i - 1];
				list[i - 1] = box;
			} else {
				return;
			}

		}

	}

	public static void straightInsertionSort2(int[] list) {
		int len = list.length;

		for (int i = 0; i < len; i++) {
			int j;
			int tmp = list[i];
			for (j = i; j > 0 && list[j - 1] > tmp; j--) {
				list[j] = list[j - 1];
			}
			list[j] = tmp;
		}

		for (int i : list) {
			System.out.print(i + "\t");
		}
	}
}
