package mySearch;

public class MySequentialSearch {

	public int[] sequentialSearch(int[] list, int target) {
//		? ?κ²??? ?΄?©?¨.
//		λ¦¬μ€?Έ?? ??κ²κ³Ό ?ΌμΉν? κ°μ ?Έ?±?€λ₯? λͺ¨μ λ¦¬ν΄.
		
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
