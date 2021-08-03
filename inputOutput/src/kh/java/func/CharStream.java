package kh.java.func;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CharStream {
	
	public void primaryStream() {
		Scanner sc = new Scanner(System.in);
		System.out.print("���� �� ���� �� �Է� : ");
		String fileName = sc.next();
		sc.nextLine();
		FileWriter fw = null;
			try {
				fw = new FileWriter(fileName);
				System.out.println(fileName+ " ���Ͽ� ����� ���� �Է� : ");
				System.out.println("����� exit ");
				int n = 0;
				while(true) {
					System.out.print(++n+"��° �Է� : ");
					String str = sc.nextLine()+"\r\n";
					if(str.equals("exit\r\n")) {
						break;
					}
					fw.write(str);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
	
	public void subStream() {
		Scanner sc = new Scanner(System.in);
		System.out.println("���ϸ� : ");
		String name = sc.next();
		sc.nextLine();
		BufferedWriter bw = null;
		
		try {
			FileWriter fw = new FileWriter(name);
			bw = new BufferedWriter(fw);
			System.out.println(name+" ���� ���� �Է� : ");
			System.out.println("����� exit");
			int n = 0;
			while(true) {
				System.out.print(++n+"��° �� : ");
				String str = sc.nextLine();
				if(str.equals("exit"))
						break;
				bw.write(str);
				bw.newLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void charStreamReader() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�ε� �� ���ϸ� �Է� : ");
		String fileName = sc.next();
		sc.nextLine();
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader(fileName);
			br = new BufferedReader(fr);
			while(true) {
				String str = br.readLine();
				if(str==null) {
					break;
				}
				System.out.println(str);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
