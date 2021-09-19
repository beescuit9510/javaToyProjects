import myStringSearch.KMPMatchingSearch;

public class Run {
		
	public static void main(String[] args) {
		
		int a =KMPMatchingSearch.kmpMatch("dsgwadsgadsgwadaadsgwadsgz", "dsgwadsgz");
		
		String aa = "dsgwadsgadsgwadaadsgwadsgz";
		System.out.println(a);
		System.out.println(aa.substring(a));
	}
	
//	public static void main(String[] args) {
//		String str1 = "hello java html va";
//		String str2 = "lo";
//		int a = BruteForceSearch.bfMatchLast(str1, str2);
//		int b = BruteForceSearch.bfMatchLast2(str1, str2);
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(str);
//		
//		MyIntSet set = new MyIntSortedSet(10);
//		MyIntSet set1 = new MyIntSortedSet(10);
//		MyIntSet set2 = new MyIntSortedSet(3);
//		MyIntSet set3 = new MyIntSortedSet(10);
//		set2.add(7);
//		set2.add(8);
//		set2.add(8);
//		set.add(5);
//		set.add(5);
//		set.add(1);
//		set.add(2);
//		set.add(3);
//		System.out.println(set);
//		set.remove(3);
//		System.out.println(set);
//		System.out.println(set.indexOf(0));
//		System.out.println(set.indexOf(2));
//		System.out.println(set.contains(0));
//		System.out.println(set.contains(2));
//		set1.copyFrom(set);
//		System.out.println(set);
//		System.out.println(set1);
//		System.out.println(set.size());
//		System.out.println(set1.size());
//		System.out.println(set.equalTo(set1));
//		
//		set.unionOf(set2, set1);
//		
//		set.add(11);
//		set.add(12);
//		set.add(13);
////		set.add(14);
////		set.add(15);
//		set3.add(set);
//		System.out.println(set1);
//		System.out.println(set3);
//////		set.add(16);
//		System.out.println(set);
//		System.out.println(set.isFull());
//		System.out.println(set.isEmpty());
////		set.clear();
//		System.out.println(set1);
//		System.out.println(set2);
//		System.out.println(set);
//		System.out.println(set1.isProperSubsetOf(set1));
//		System.out.println(set1.isProperSubsetOf(set2));
//		System.out.println(set1.isProperSubsetOf(set2));
//		System.out.println(set2.isSubsetOf(set));
//		
//	}
	
//	public static void main(String[] args) {
//		
//		MyIntRingBuffer rb = new MyIntRingBuffer(5);
//		
//		rb.enque(1);
//		rb.enque(2);
//		rb.enque(3);
//		rb.enque(4);
//		rb.enque(5);
//		rb.enque(6);
//		rb.enque(7);
//		rb.enque(8);
//		rb.enque(9);
//		rb.enque(10);
//		rb.enque(11);
//		System.out.println(rb);
//		System.out.println(rb.deque());
//		
//	}

}
