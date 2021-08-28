package mySearch;

public class MySequentialSearch {

	public int[] sequentialSearch(int[] list, int target) {
//		?„ ?˜•ê²??ƒ‰?„ ?´?š©?•¨.
//		ë¦¬ìŠ¤?Š¸?—?„œ ??ê²Ÿê³¼ ?¼ì¹˜í•˜?Š” ê°’ì˜ ?¸?±?Š¤ë¥? ëª¨ì•„ ë¦¬í„´.
		
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
