package mySearch;

public class MyBinarySearch {

	public int binarySearch(int[] list, int target) {

		int first = 0;
		int last = list.length;
		int center = (first+last)/2;

		while(center<list.length) {
			
			if(list[center]==target)
				return center;
			
			if(list[center]>target) {
				last = center;
			}
			else {
				first = center+1;
			}
			
			center = (first+last)/2;
			
		}
		return -1;

	}

	public int binarySearchFindTheFisrtIndex(int[] list, int target) {
		
		int first = 0;
		int last = list.length;
		int center = (first+last)/2;
		
		while(center<list.length) {
			
			if(list[center]==target) {
				int r = center;
				for(int i=center;i>-1;i--) {
					if(list[i]!=target)
						break;
					else
						r = i;
				}
				return r;
			}
			
			if(list[center]>target) {
				last = center;
			}
			else {
				first = center+1;
			}
			
			center = (first+last)/2;
			
		}
		return -1;
		
	}
	
}
