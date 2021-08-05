package kh.java.func;

import java.util.ArrayList;

public class ListClass {
	
	public void listTest1() {
		
		String[] str = new String[3];
		str[0] = "hi";
		str[1] = "hello";
		str[2] = "hooray";
		
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("hi");
		list.add("hello");
		list.add("hooray");
		
		
	}
	
	public void listTest2() {
		ArrayList<String> a = new ArrayList<String>();
//		ArrayList<Integer> b = new ArrayList<Integer>();
		a.add("hooray");
		for(String str: a) {
			System.out.println(str);
		}
//		a.add()
	}

}
