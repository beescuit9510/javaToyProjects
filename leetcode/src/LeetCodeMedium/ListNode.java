package LeetCodeMedium;


public class ListNode{
	
	public int val;
	public ListNode next;

	public ListNode() {
	}

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		ListNode listNode = new ListNode(-1, new ListNode());

		String strSum = "";
		String strSum2 = "";
		String reversed = "";
		String reversed2 = "";

        
		while (true) {
            if(l1!=null){
            strSum += Integer.toString(l1.val);
            l1 = l1.next;
            }
            
            if(l2!=null){
            strSum2 += Integer.toString(l2.val);
        	l2 = l2.next;
            }
            
			if (l1 == null && l2 == null)
				break;
		}
        
        while(true) {
			if(strSum.length()>reversed.length())
				reversed+= strSum.charAt(strSum.length()-1-reversed.length());

			if(strSum2.length()>reversed2.length())
				reversed2+= strSum2.charAt(strSum2.length()-1-reversed2.length());
			
			if(strSum.length()==reversed.length()&&strSum2.length()==reversed2.length())
				break;
		}
		
        long a = Long.parseLong(reversed);
		long b = Long.parseLong(reversed2);
		long longR = a+b;
		String strR = Long.toString(longR);

        int i = 0;
		ListNode pointer = listNode;
		
		for (int j = strR.length(); j>0; j--) {
			ListNode box = pointer;
			box.val = Integer.parseInt(strR.charAt(j-1) + "");
    	    box.next = j>1? new ListNode():null;
			pointer = box.next;
		}

		return listNode;
	}
}






























//
//
//
//
//public static void main(String[] args) {
//
////	[9,9,9,9,9,9,9]
////			[9,9,9,9]
//	int[] list1 = {1};
//	int[] list2 = {0};
//	ListNode a = addTwoNumbers(list1, list2);
//	System.out.println("jaja");
//	while (a.next != null) {
//		System.out.println(a.val);
//		a = a.next;
//	}
//	System.out.println(a.val);
////
//}
//
//public static ListNode addTwoNumbers(int[] l1, int[] l2) {
//
//	ListNode listNode = new ListNode(-1, new ListNode());
//	ListNode list = new ListNode();
//
//	String strSum = "";
//	String strSum2 = "";
//	String reversed = "";
//	String reversed2 = "";
//
//	int i = 0;
//	int k = 0;
//	while (true) {
//		if (i < l1.length)
//			strSum += Integer.toString(l1[i++]);
//		if (k < l2.length)
//			strSum2 += Integer.toString(l2[k++]);
//
//		if (i == l1.length && k == l2.length)
//			break;
//	}
//
//	while (true) {
//		if (strSum.length() > reversed.length())
//			reversed += strSum.charAt(strSum.length() - 1 - reversed.length());
//
//		if (strSum2.length() > reversed2.length())
//			reversed2 += strSum2.charAt(strSum2.length() - 1 - reversed2.length());
//
//		if (strSum.length() == reversed.length() && strSum2.length() == reversed2.length())
//			break;
//	}
//	double b = Long.parseLong(reversed2);
//	double a = Long.parseLong(reversed);
//	if(reversed.length()>10&&reversed2.length()>10) {
//		b = Long.parseLong(reversed2) / 10000.0;
//		a = Long.parseLong(reversed) / 10000.0;	
//	}
//	;
//	
//	double intR = a + b;
//	double check = a + b;
//	String strR = Double.toString(intR);
//	
//	
//	if(check==0)
//		return new ListNode(0, null);
//	
//	System.out.println("intR "+strR);
//	while(true) {
//		strR = Integer.toString((int)(intR));
//		if(Long.parseLong(strR)==check)
//			break;
//		
//		intR*=10;
//	}
//
//	System.out.println("intR "+intR);
//	System.out.println("strR "+strR);
//	System.out.println("check "+check);
//
//
//	ListNode pointer = listNode;
//
//	for (int j = strR.length(); j > 0; j--) {
//			ListNode box = pointer;
//			box.val = Integer.parseInt(strR.charAt(j - 1) + "");
//			box.next = j > 1 ? new ListNode() : null;
//			pointer = box.next;
//	}
//
//	return listNode;
//}
//
//}
