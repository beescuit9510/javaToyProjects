package kh.java.func;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StreamTest {
	public void test1() {
		BufferedReader br = null;
		BufferedOutputStream bos = null;
		try {
			FileReader fr = new FileReader("quiz.txt");
			br = new BufferedReader(fr);

			String str = br.readLine();

			ArrayList<Byte> al = new ArrayList<Byte>();

			StringTokenizer token = new StringTokenizer(str, " ");

			while (token.hasMoreTokens()) {
				String strN = token.nextToken();
				byte n = (byte) Integer.parseInt(strN, 16);
				al.add(n);
			}
			System.out.println("리스트 길이 : " + al.size());

			FileOutputStream fos = new FileOutputStream("test.gif");

			bos = new BufferedOutputStream(fos);

			for (Byte b : al) {
				bos.write(b);
			}
			System.out.println("파일 내보내기 완료 !");
			// System.out.println(str);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
				bos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void test2() {
		Scanner sc = new Scanner(System.in);
		FileReader fr = null;
		FileOutputStream fos = null;
		try {
			fr = new FileReader("quiz.txt");
			StringBuffer sb = new StringBuffer();
			fos = new FileOutputStream("test2.gif");
			while (true) {
				int data = fr.read();
				if (data == -1) {
					break;
				}
				sb.append((char) data);
			}
			ArrayList<Byte> al = new ArrayList<Byte>();
			StringTokenizer st = new StringTokenizer(sb.toString(), " ");
			while (st.hasMoreTokens()) {
				byte num = (byte) Integer.parseInt(st.nextToken(), 16);
				al.add(num);
			}
			System.out.println("리스트 길이 : " + al.size());
			for (Byte b : al) {
				fos.write(b);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void test3() {
		FileReader fr = null;
		FileOutputStream fos = null;
		try {
			fr = new FileReader("quiz.txt");
			fos = new FileOutputStream("test11.gif");
			ArrayList<Byte> al = new ArrayList<Byte>();
			while (true) {
				int data = fr.read();
				if (data == -1) {
					break;
				}
				if ((char)data==' ') {
					continue;
				} else {
					String str = Integer.toString(data);
					byte b = (byte)Integer.parseInt(str, 16);
					al.add(b);
				}
			}
			System.out.println("리스트 길이 : " + al.size());
			for (Byte b : al) {
				fos.write(b);
			}
			System.out.println("끝 !");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
