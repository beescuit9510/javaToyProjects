package kh.java.func;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class UserMgrList {
	Scanner sc;
	ArrayList<User> list;
	
	public UserMgrList() {
		sc = new Scanner(System.in);
		list = new ArrayList<User>();
		inList();
		
	}
	
	public void main() {
		
		while(true) {
			System.out.println("1. 회원 등록");
			System.out.println("2. 회원 출력 ");
			System.out.println("3. 회원 내보내기 ");
			System.out.println("4. 회원 불러오기 ");
			System.out.println("0. 종료");
			int sel = sc.nextInt();
			
			switch(sel) {
			case 1:
				 insertMember();
				break;
			case 2:
				printAllMember();
				break;
			case 3:
				outList();
				break;
			case 4:
				inList();
				break;
			case 0:
				System.out.println("프로그램 종료 ~~ ");
				return;
				
			default:
				System.out.println("잘못입력하셨습니다.");
				break;
			}
		}

	}
	
	public void outList() {
		ObjectOutputStream oss = null;
		
		try {
			FileOutputStream fos = new FileOutputStream("list.txt");
			oss = new ObjectOutputStream(fos);
			oss.writeObject(list);
			System.out.println("회원 내보내기 완료 !");
			
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
	
	public void inList() {
		ObjectInputStream ois = null;
		try {
			FileInputStream fis = new FileInputStream("list.txt");
			ois = new ObjectInputStream(fis);
			list = (ArrayList<User>)ois.readObject();
			System.out.println("불러오기 완료! ");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ois.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void insertMember() {
		System.out.println("아이디/비밀번호/이름/나이 입력: ");
		list.add(new User(sc.next(),sc.next(),sc.next(),sc.next()));
	}
	
	private void printAllMember() {
		for(User u : list) {
			System.out.println(u);
		}

	}

}
