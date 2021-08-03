package kh.java.func;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class StreamTest {
	public  void tset1() {
		BufferedReader br =null;
		BufferedOutputStream bos = null;
		try {
			FileReader fr = new FileReader("quiz.txt");
			br = new BufferedReader(fr);
			
			String str = br.readLine();

			ArrayList<Byte> al = new ArrayList<Byte>();
			
			StringTokenizer token = new StringTokenizer(str, " ");
			
			while(token.hasMoreTokens()) {
				String strN = token.nextToken();
				byte n = (byte)Integer.parseInt(strN,16);
				al.add(n);
			}
			System.out.println("리스트 길이 : "+al.size());
			
			FileOutputStream fos = new FileOutputStream("test.gif");
			
			bos = new BufferedOutputStream(fos);
			
			for(Byte b: al) {
				bos.write(b);
			}
			System.out.println("파일 내보내기 완료 !");
//			System.out.println(str);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
				bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
