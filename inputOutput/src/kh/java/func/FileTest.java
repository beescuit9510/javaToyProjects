package kh.java.func;

import java.io.File;
import java.util.Scanner;

public class FileTest {
	public void fileTest() {
		Scanner sc = new Scanner(System.in);
		System.out.println("���ϸ� �Է� : ");
		File file = new File(sc.next());

		if (file.exists()) {
			System.out.println("���� ����");
			System.out.println("���ϸ� : " + file.getName());
			System.out.println("���ϸ� ��� ��� : " + file.getPath());
			System.out.println("���� ���� ��� : " + file.getAbsolutePath());
			System.out.println("���� ���� ? �� ?");
			if(sc.next().equals("��")) {
				file.delete();
			}
		} else {
			System.out.println("���� ����");
		}
	}

}
