package kh.java.run;

import kh.java.func.ByteStream;
import kh.java.func.CharStream;
import kh.java.func.FileTest;
import kh.java.func.StreamTest;
import kh.java.func.UserMgr;

public class Start {

	public static void main(String[] args) {
		ByteStream b = new ByteStream();
		CharStream c = new CharStream(); 
//		c.subStream();
//		c.charStreamReader();
		StreamTest st = new StreamTest();
//		st.test1();
//		st.test2();
//		st.test3();
		FileTest f = new FileTest();
//		f.fileTest();
		
		UserMgr um = new UserMgr();
		um.test1();
		um.test2();

	}

}
