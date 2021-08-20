import java.text.DecimalFormat;

import LeetCodeMedium.ListNode;

public class Run {
	
	
	  public static String foo(double value) //Got here 6.743240136E7 or something..
	    {
	        DecimalFormat formatter;

	        if(value - (int)value > 0.0)
	            formatter = new DecimalFormat("0.00"); //Here you can also deal with rounding if you wish..
	        else
	            formatter = new DecimalFormat("0");

	        return formatter.format(value);
	    }
	  

	public static void main(String[] args) {
		Double aaaa = 1000000000000000000000000000001D;
		Double b = 1000000000000000000000000000001D;
		System.out.printf("%f", b);
		

//		System.out.println(foo(aaaa));
//		[9,9,9,9,9,9,9]
//				[9,9,9,9]
//		int[] list1 = { 9,9,9,9,9,9,9 };
//		int[] list1 = { 1, 2, 3, 4 };
//		int[] list2 = { 9,9,9, 9 };
//		int[] list2 = { 5, 6, 7, 8 };

		int[] list1 = { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 };
//		int[] list2 = { 9,9,9, 9 };
		int[] list2 = { 5, 4, 6 };
//		ListNode a = addTwoNumbers(list1, list2);
//		while (a.next != null) {
//			System.out.println(a.val);
//			a = a.next;
//		}
//		System.out.println(a.val);
//		
		
		
//	
	}

	public static ListNode addTwoNumbers(int[] l1, int[] l2) {

		ListNode listNode = new ListNode(-1, new ListNode());

		String strSum = "";
		String strSum2 = "";
		String reversed = "";
		String reversed2 = "";
		
		int i = 0;
		int k = 0;
		while (true) {
			if (i < l1.length)
				strSum += Integer.toString(l1[i++]);
			if (k < l2.length)
				strSum2 += Integer.toString(l2[k++]);

			if (i == l1.length && k == l2.length)
				break;
		}

		while (true) {
			if (strSum.length() > reversed.length())
				reversed += strSum.charAt(strSum.length() - 1 - reversed.length());

			if (strSum2.length() > reversed2.length())
				reversed2 += strSum2.charAt(strSum2.length() - 1 - reversed2.length());

			if (strSum.length() == reversed.length() && strSum2.length() == reversed2.length())
				break;
		}

		Double a = Double.parseDouble(reversed);
		Double b = Double.parseDouble(reversed2);
		
		
		Double longR = a + b;
		String strR = Double.toString(longR);
		System.out.println(Double.parseDouble(reversed));
		System.out.println(reversed2);
		System.out.println(a);
		System.out.println(b);
		System.out.println(strR);

		ListNode pointer = listNode;
		


		for (int j = strR.length(); j > 0; j--) {
			ListNode box = pointer;
			box.val = Integer.parseInt(strR.charAt(j - 1) + "");
			box.next = j > 1 ? new ListNode() : null;
			pointer = box.next;
		}

		return listNode;
	}

}

//public class Run {
//
//	public static void main(String[] args) {
//
////		[9,9,9,9,9,9,9]
////				[9,9,9,9]
//		int[] list1 = { 9,9,9,9,9,9,9 };
//		int[] list2 = { 9,9,9, 9 };
//		ListNode a = addTwoNumbers(list1, list2);
//		while (a.next != null) {
//			System.out.println(a.val);
//			a = a.next;
//		}
//		System.out.println(a.val);
////	
//	}
//
//	public static ListNode addTwoNumbers(int[] l1, int[] l2) {
//
//		ListNode listNode = new ListNode(-1, new ListNode());
//		ListNode list = new ListNode();
//
//		String strSum = "";
//		String strSum2 = "";
//		String reversed = "";
//		String reversed2 = "";
//
//		int i = 0;
//		int k = 0;
//		while (true) {
//			if (i < l1.length)
//				strSum += Integer.toString(l1[i++]);
//			if (k < l2.length)
//				strSum2 += Integer.toString(l2[k++]);
//
//			if (i == l1.length && k == l2.length)
//				break;
//		}
//
//		while (true) {
//			if (strSum.length() > reversed.length())
//				reversed += strSum.charAt(strSum.length() - 1 - reversed.length());
//
//			if (strSum2.length() > reversed2.length())
//				reversed2 += strSum2.charAt(strSum2.length() - 1 - reversed2.length());
//
//			if (strSum.length() == reversed.length() && strSum2.length() == reversed2.length())
//				break;
//		}
//		
//		double b = Long.parseLong(reversed2);
//		double a = Long.parseLong(reversed);
//		
//        if(reversed.length()>10&&reversed2.length()>10) {
//			b = Long.parseLong(reversed2) / 1000.0;
//			a = Long.parseLong(reversed) / 1000.0;	
//		}
////		double b = Long.parseLong(reversed2) / 1000.0;
////		double a = Long.parseLong(reversed) / 1000.0;	
//		double intR = a + b;
//		String strR = Double.toString(intR);
//		double check = intR;
//		if (check == 0) {
//			return new ListNode(0, null);
//		}
//		
//		boolean startWtihZero = strR.startsWith("0");
//		while (startWtihZero) {
//			strR = strR.substring(1);
//			startWtihZero = strR.startsWith("0");
//		}
//		
//		boolean containsDeci = strR.contains(".");
//		while (containsDeci) {
//			strR = strR.substring(0, strR.length()-1);
//			containsDeci = strR.contains(".");
//		}
//
//
//		ListNode pointer = listNode;
//
//		for (int j = strR.length(); j > 0; j--) {
//			ListNode box = pointer;
//			box.val = Integer.parseInt(strR.charAt(j - 1) + "");
//			box.next = j > 1 ? new ListNode() : null;
//			pointer = box.next;
//		}
//
//		return listNode;
//	}
//
//}

//class Solution {
//	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//
//		ListNode listNode = new ListNode(-1, new ListNode());
//
//		String strSum = "";
//		String strSum2 = "";
//
//		while (true) {
//            if(l1!=null){
//            strSum += Integer.toString(l1.val);
//            l1 = l1.next;
//            }
//            
//            if(l2!=null){
//            strSum2 += Integer.toString(l2.val);
//        	l2 = l2.next;
//            }
//            
//			if (l1 == null && l2 == null)
//				break;
//		}
//		
//		int intR = Integer.parseInt(strSum) + Integer.parseInt(strSum2);
//		String strR = Integer.toString(intR);
//
//        int i = 0;
//		ListNode pointer = listNode;
//		
//		for (int j = strR.length(); j>0; j--) {
//			ListNode box = pointer;
//			box.val = Integer.parseInt(strR.charAt(j-1) + "");
//    	    box.next = j>1? new ListNode():null;
//			pointer = box.next;
//		}
//
//		return listNode;
//	}
//}
