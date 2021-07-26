package kh.java.controller;
import java.util.Scanner;
import kh.java.vo.Student;

public class StudentMgr {
	private Scanner sc;
	private Student[] students;
	private int index;
	
	public StudentMgr() {
		sc = new Scanner(System.in);
		students = new Student[10];
		index = 0;
	}
	
	public void main() {
		
//		run:
		while(true) {
			System.out.println("\n============학생관리 프로그램v1=============\n");
			System.out.println("1. 학생 정보 등록");
			System.out.println("2. 학생 정보 출력(등록된 전체학생)");
			System.out.println("3. 학생 정보 출력(1명 이름으로 검색)");
			System.out.println("4. 학생 정보 수정");
			System.out.println("5. 학생 정보 삭제");
			System.out.println("0. 프로그램종료");
			System.out.printf("선택 > ");
			int sel = sc.nextInt();
			
			switch(sel) {
			case 1:
				insertStudent();
				break;
				
			case 2:
				printStudents();
				break;
				
			case 3:
				printStudent();
				break;
				
			case 4:
				editStudent();
				break;
			case 5:
				
				deleteStudent();
				break;
			
			case 0:
				System.out.println("Bye ~ ");
				return;
//				break run;
				
			default:
				System.out.println("잘못입력하셨습니다.");
				break;
			}
			
		}
	}
	
	
	public void insertStudent() {
		System.out.println("\n---------------학생 정보 등록---------------\n");
		System.out.printf("학생 이름, 나이, 주소 입력 (띄어쓰기로 구분): ");
		students[index++] = new Student(sc.next(),sc.nextInt(),sc.nextLine());
	}
	
	
	public void printStudents() {
		System.out.println("\n---------------전체 학생 정보 출력---------------\n");
		System.out.println("이름\t나이\t주소\t");
		for(int i=0; i<index; i++) {
			System.out.printf("%s\t%d\t%s%n", students[i].getName(), students[i].getAge(), students[i].getAddr());
		}
	}
	
	
	public void printStudent() {
		System.out.println("\n---------------학생 정보 출력 (1명)---------------\n");
		int i = searchIndex();
		
		if(i>=0) {
			System.out.printf("%s\t%d\t%s%n", students[i].getName(), students[i].getAge(), students[i].getAddr());
			return;
		}
		System.out.println("학생 정보가 없습니다.");
	}
	
	
	public void editStudent() {
		System.out.println("\n---------------학생 정보 수정---------------\n");
		int i = searchIndex();
		
		if(i>=0) {
			while(true) {
//					sc.nextLine();
				System.out.printf("수정 하시려는 정보 (1)이름, (2)나이, (3)주소 ,(4)종료  : ");
				int sel = sc.nextInt();
				sc.nextLine();
				switch(sel) {
				case 4:
					return;
				case 1:
					System.out.print("수정 할 학생 이름 입력 : ");
					students[i].setName(sc.next());
					break;
				case 2:
					System.out.print("수정 할 학생 나이 입력 : ");
					students[i].setAge(sc.nextInt());
					break;
				case 3:
					System.out.print("수정 할 학생 주소 입력: ");
					students[i].setAddr(sc.nextLine());
					break;
				default:
					System.out.println("잘못된 입력 입니다.");
					break;
					
				}
			}
		}
		System.out.println("학생 정보가 없습니다.");
	}
	
	
	public void deleteStudent() {
		System.out.println("\n---------------학생 정보 삭제---------------\n");
		int i = searchIndex();
		
		if(i>=0) {
				for(int j=i;j<index-1;j++) {
					students[j] = students[j+1];
				}					
			System.out.println("삭제 되었습니다.");
			index--;
			students[index]=null;
			return;
		}
		System.out.println("학생 정보가 없습니다.");
		
	}
	
	
	public int searchIndex() {
		System.out.printf("조회 할 학생 이름 입력 : ");
		String name = sc.next();
		for(int i=0; i<index; i++) {
			if(students[i].getName().equals(name)) {
				return i;
			}
		}
		return -1;
	}


}
