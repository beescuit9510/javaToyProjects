package mySearch;

public class MySequentialSearch {

	public int[] sequentialSearch(int[] list, int target) {
//		?��?���??��?�� ?��?��?��.
//		리스?��?��?�� ??겟과 ?��치하?�� 값의 ?��?��?���? 모아 리턴.
		
		String indexes = "";
		
		for(int i=0; i<list.length;i++) {
			if(list[i] == target)
				indexes += ""+i;
		}
		
		int[] indexesList = new int[indexes.length()];
		
		for(int i=0;i<indexes.length();i++) {
			indexesList[i] = Integer.parseInt(""+indexes.charAt(i));
			
		}
		
		return indexesList;
	}

}
