package main;

public class MySequentialSearch {

	public int[] sequentialSearch(int[] list, int target) {
//		선형검색을 이용함.
//		리스트에서 타겟과 일치하는 값의 인덱스를 모아 리턴.
		
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
