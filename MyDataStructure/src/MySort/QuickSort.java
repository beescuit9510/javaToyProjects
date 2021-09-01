package MySort;

public class QuickSort {

	public static void main(String[] args) {

//		int[] list = { 1, 2, 3, 4, 9, 8, 7, 2, 1, 3, 10, 12, 16 };
		int[] list = { 6, 4, 2, 1, 3 ,1};
		quickSort(list, list.length);

		for (int i : list) {
			System.out.print(i + "\t");
		}
	}

	private static void quickSort(int[] list, int len) {
		int pl= 0;
		int pr = len-1;
		int mid = list[len/2];
		
		System.out.println(mid);
		do {
			while(list[pl] < mid) pl++;
			while(list[pr] > mid) pr--;
			if(pl <= pr)
				swap(list, pl++, pr--);
		}while(pl<=pr);
		
		
		
	}

	private static void swap(int[] list, int i, int j) {
		
		int t = list[i];
		list[i] = list[j];
		list[j] = t;
		
	}

//	private static void quickSort(int[] list, int low, int high) {
//
//		if (low >= high || high - low <= 0) {
//			return;
//		}
//
//		int mid = 0;
//
//		for (int i = low; i <= high; i++)
//			mid += i;
//
//		mid = mid / (high - low);
//
//		int gap = Math.abs(mid - list[0]);
//		int pivot = 0;
//
//		for (int j = low; j < high; j++) {
//			if (list[j] == mid) {
//				pivot = j;
//				break;
//			} else {
//				int gap2 = Math.abs(mid - list[j]);
//				pivot = gap2 < gap ? j : pivot;
//				gap = gap2;
//
//			}
//		}
//
//		mid = (high + low) / 2;
//		int box = list[mid];
//		list[mid] = list[pivot];
//		list[pivot] = box;
//
//		int[] left = new int[high - low];
//		int[] right = new int[high - low];
//		int r = 0;
//		int l = 0;
//
//		for (int k = low; k < pivot; k++) {
//
//			if (list[k] > list[pivot] && list[high - k] < list[pivot]) {
//				box = list[k];
//				list[k] = list[pivot];
//				list[pivot] = box;
//
//			} else if (list[k] > list[pivot]) {
//				l++;
//
//			} else if (list[high - k] < list[pivot]) {
//				r++;
//			}
//
//		}
//
//		if (l > 1 && r > 1) {
//			int i = Math.max(l, r);
//
//			for (; i >= 0; i--) {
//				int a = left[l];
//				int b = right[r];
//				box = list[a];
//				list[a] = list[b];
//				list[b] = box;
//				l--;
//				r--;
//			}
//		}
//
//		while (l > -1 && r > -1) {
//			if (l > -1) {
//				box = list[left[l]];
//				for (int i = left[l]; i > pivot; i++) {
//					list[i] = list[i + 1];
//				}
//				list[pivot] = box;
//			}
//			if (r > -1) {
//				box = list[right[r]];
//				for (int i = pivot; i > left[l] && i < high; i++) {
//					list[i] = list[i + 1];
//				}
//				list[pivot] = box;
//
//			}
//			r--;
//			l--;
//		}

//		quickSort(list, 0, mid);
//		quickSort(list, mid, list.length - 1);
//	}

}
