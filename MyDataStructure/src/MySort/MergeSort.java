package MySort;

public class MergeSort {
	static int[] buff;
	
	public static void main(String[] args) {
		int[] arr = {1,5,2};
		mergeSort(arr, arr.length);
		
		for(int a: arr) {
			System.out.println(a);
			
		}
		
	}

	private static void mergeSort(int[] arr, int length) {
		// TODO Auto-generated method stub
		
		 buff = new int[length];
		
		__mergeSort(arr, 0, length-1);
		
		buff = null;
	}

	private static void __mergeSort(int[] arr, int left, int right) {
		// TODO Auto-generated method stub
		
		if(left < right) {
			
			int center = (left+right)/2;
			__mergeSort(arr, left, center);
			__mergeSort(arr, center+1, right);

			
			int lenB = 0;
			int curserB = 0;
			int lenA = left;
			int curserA = left;
			
			for(; lenA <= center; lenA++) {
				buff[lenB++] = arr[lenA];
			}
			
			while(lenA <= right && curserB <lenB) {
				int min = buff[curserB]<=arr[lenA] ? buff[curserB++]:arr[lenA++];
				arr[curserA++] = min;
			}
			
			while(curserB < lenB) {
				arr[curserA++] = buff[curserB];
			}
			
		}
		
	}
	

}
