package kh.java.func;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class SetTest {
	public static void lotto() {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		HashSet<Integer> useNums = new HashSet<Integer>();
		HashSet<Integer> comNums = new HashSet<Integer>();
		while(useNums.size()<6){
			System.out.printf("%d번째 숫자 입력 : ", useNums.size()+1);
			if(!useNums.add(sc.nextInt())) {
				System.out.println("중복 숫자 입니다. 다시 입력 해주세요.");
			}
		}
		while(comNums.size()<6) {
			comNums.add(r.nextInt(45)+1);
		}
		Collection[] arr = {useNums, comNums};
		HashSet<Integer> overlap = new HashSet<Integer>();
		for(Collection h : arr) {
			for(Object i : h) {
				overlap.add((Integer)i);
				System.out.print(i+"\t");
			}
			System.out.println();
		}
		System.out.println(Math.abs(overlap.size()-12)+"개 동일");
	}
}
