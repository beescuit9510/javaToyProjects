package kr.or.iei.view;

import java.util.ArrayList;
import java.util.Scanner;

import kr.or.iei.vo.Member;
import kr.or.iei.vo.Rent;
import kr.or.iei.vo.Room;

public class View {
	Scanner sc = new Scanner(System.in);

	public int main() {
		System.out.println("-----------회원 관리 프로그램-----------");
		System.out.println("1. 로그인 ");
		System.out.println("2. 회원 가입");
		System.out.println("0. 프로그램 종료");
		System.out.println("선택 > ");
		return sc.nextInt();
	}

	public int staffMain() {
		System.out.println("-----------[ 다방 직원 ]-----------");
		System.out.println("1. 매물 정보 등록 ");
		System.out.println("2. 모든 매물 정보 불러오기");
		System.out.println("3. 예약자 보기");
		System.out.println("4. 모든 회원 정보 불러오기");
		System.out.println("0. 로그아웃");
		System.out.println("선택 > ");
		return sc.nextInt();

	}

	public int customerMain(String name) {
		System.out.println("-----------[ " + name + " ]-----------");
		System.out.println("1. 모든 매물 정보 불러오기");
		System.out.println("2. 매물 예약하기");
		System.out.println("0. 로그아웃");
		System.out.println("선택 > ");
		return sc.nextInt();
	}

	public ArrayList<String> getRegisterList() {
		ArrayList<String> list = new ArrayList<String>();
		System.out.println(" 아이디 입력 :");
		list.add(sc.next());
		System.out.println(" 비밀번호 입력 :");
		list.add(sc.next());
		System.out.println(" 이름 입력 :");
		list.add(sc.next());
		System.out.println(" 핸드폰 입력 :");
		list.add(sc.next());
		System.out.println(" 등급 입력[1.직원/2.손님] :");
		list.add(sc.next());
		return list;
	}

	public void printMember(ArrayList<Member> members) {
		System.out.println("회원번호\t아이디\t비밀번호\t이름\t전화번호\t회원구분");
		for (Member m : members) {
			System.out.println(m);
		}
	}

	public void printRoom(ArrayList<Room> rooms) {
		System.out.println("매물번호\t지역\t평수\t방갯수");
		for (Room m : rooms) {
			System.out.println(m);
		}
	}

	public void printRent(ArrayList<Rent> rents) {
		System.out.println("매물번호\t이름\t예약날짜");
		for (Rent m : rents) {
			System.out.println(m);
		}
		
	}

}
