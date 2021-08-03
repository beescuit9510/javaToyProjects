package kh.java.func;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class UserMgr {
	Scanner sc = new Scanner(System.in);

	public void test1() {
		User u = new User("idid", "pwpw", "name", "9");
		User u2 = new User("catcat", "pwpw", "catcat", "913213");
		
		ObjectOutputStream oss = null;
		
		try {
			FileOutputStream fos = new FileOutputStream("objext.txt");
			oss = new ObjectOutputStream(fos);
			oss.writeObject(u2);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				oss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void test2() {
		ObjectInputStream ois = null;
		try {
			FileInputStream fis = new FileInputStream("objext.txt");
			ois = new ObjectInputStream(fis);
			
			Object obj = ois.readObject();
			User user = (User)obj;
			System.out.println(user);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
