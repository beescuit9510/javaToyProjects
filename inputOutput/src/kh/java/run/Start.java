package kh.java.run;

import kh.java.func.ByteStream;
import kh.java.func.CharStream;
import kh.java.func.StreamTest;

public class Start {

	public static void main(String[] args) {
		ByteStream b = new ByteStream();
		CharStream c = new CharStream(); 
//		c.subStream();
//		c.charStreamReader();
		StreamTest st = new StreamTest();
		st.tset1();

	}

}
