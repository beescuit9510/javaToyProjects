package grokkingAlgoritmn.java.func;

public class Search {
	
	static int snailSort() {}
	static int binarySearch(int[] array, int target) {}
	static int linkedList(int[] array, int target) {}
	static int mergeSort() {}
	static int hashTable() {}
	static int hashFunction1(String str) {}
	static int breadthFirstSearch(){}
	static int queue() {}
	static int DijkstrasAlgorithm(){}
	static int greedyAlgorithm() {}
	static int approximationAlgorithm() {}
	
	
	static int[] quickSort(int[] arr) {
		if(arr.length==1) {
			return arr;
		} else {
			int[][] tmp = new int[2][arr.length];
			int prevIn=0;
			int afterIn=0;
			for(int i=1;i<arr.length;i++) {
				if(arr[i]<arr[0]) {
					prevIn++;
					tmp[0][prevIn] = arr[i];
				}else {
					tmp[1][afterIn] = arr[i];
					afterIn++;
				}
			}
			int[] prev = new int[prevIn];
			int[] after = new int[afterIn];
			int[] pivot = {arr[0]};
			System.arraycopy(tmp[0], 0, prev, 0, prevIn);
			System.arraycopy(tmp[1], 0, after, 0, afterIn);
			
			int[] prevArr = quickSort(prev);
			int[] afterArr = quickSort(after);
			
			int n =0;
			int[] completeArr = new int[arr.length]; 
			completeArr[prevArr.length-1] = arr[0];
			System.arraycopy(prevArr, 0, completeArr, 0, prevArr.length);
			System.arraycopy(afterArr, prevArr.length, completeArr, prevArr.length, afterArr.length);
			
			return completeArr;
					
		}
	}
	
		
	
	
	
	
	
	
	
	
}
