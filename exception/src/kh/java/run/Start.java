package kh.java.run;

import java.io.FileNotFoundException;

import kh.java.func.ExceptionTest;

public class Start {

	
	public static void main(String[] args) {
		ExceptionTest e = new ExceptionTest();
//		e.test1();
		
		try {
			e.mainTest4();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			
		}
	}
}

