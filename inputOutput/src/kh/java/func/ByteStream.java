package kh.java.func;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ByteStream {
	
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("���� �� : ");
		String name = sc.next();
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("C:\\Users\\�庯��\\Desktop\\"+name);
			System.out.println("���� �� ����� ���� : ");
			System.out.println("exit ");
			sc.nextLine();
			int lineN = 0;
			while(true) {
				System.out.println(++lineN+" : ");
				String str = sc.nextLine()+"\r\n"; //window ���๮�� �߰�
				if(str.equals("exit\r\n")){
					break;
				}
				fos.write(str.getBytes());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
