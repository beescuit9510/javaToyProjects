package MySort;

public class ShellSort {

	public static void main(String[] args) {

//		int[] list = { 1, 2, 3, 4, 9, 8, 7, 2, 1, 3, 10, 12, 16 };
		int[] list = { 4, 2, 1, 16, 3 };
		shellsort(list);

		for (int i : list) {
			System.out.print(i + "\t");
		}
	}

	private static void shellsort(int[] list) {
		int size = list.length;

//		int gap;
//		for (gap = 1; gap < size / 9; gap = gap * 3 + 1)
		;
		int gap = size / 2;

		while (gap > 0) {

			for (int i = gap; i < size; i++) {

				int tmpt = list[i];

				int j = i - gap;

				for (; j >= 0 && list[j] > tmpt; j -= gap) {
					list[j + gap] = list[j];
				}

				list[j + gap] = tmpt;
			}

			gap = gap / 3;
		}

	}

}
