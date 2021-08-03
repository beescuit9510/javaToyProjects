package kh.java.func;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ByteStream {
	
	public void test1() {
		Scanner sc = new Scanner(System.in);
		System.out.println("파일 명 : ");
		String name = sc.next();
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("C:\\Users\\장변덕\\Desktop\\"+name);
			System.out.println("파일 에 저장될 내용 : ");
			System.out.println("exit ");
			sc.nextLine();
			int lineN = 0;
			while(true) {
				System.out.println(++lineN+" : ");
				String str = sc.nextLine()+"\r\n"; //window 개행문자 추가
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
