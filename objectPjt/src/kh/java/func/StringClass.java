package kh.java.func;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.StringTokenizer;

public class StringClass {
	
	public void test1() {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		System.out.println(sb.length());
		sb.append("a11");
		System.out.println(sb.length());
		
		String str = "wkd/wkd/wkk/";
		StringTokenizer st = new StringTokenizer(str);

	}
	
	public void test2() {
		String str = "a b c d e f g f";
		StringTokenizer st = new StringTokenizer(str, " ");
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken().toUpperCase());
		}
	}
	
	public void test3() {
		System.out.println(Math.round(1.2355*100)/100.0);
		System.out.println((int)(Math.random()*10)+1);
	}
	
	
	public void test4() {
		Calendar today =Calendar.getInstance();
		System.out.println(today.getTime());
		System.out.println(today.get(Calendar.MONTH)+1);
		System.out.println(today.get(Calendar.DATE));
		System.out.println(today.get(Calendar.AM_PM));
		System.out.println(today.get(Calendar.YEAR));
		System.out.println("------------------");
		Calendar day1 = Calendar.getInstance();
		System.out.println(day1.get(Calendar.DATE));
		System.out.println(day1.get(Calendar.DAY_OF_WEEK));
		day1.set(Calendar.DAY_OF_WEEK, 0); //10일로 변경
		day1.set(Calendar.MONTH, 9); //10월로 변경
		day1.set(Calendar.DATE, 9); //10일로 변경
		day1.set(Calendar.HOUR, 0); 
		System.out.println(day1.getTime());
		
		System.out.println("------------------");
		Calendar day2 = Calendar.getInstance();
		day2.set(Calendar.YEAR, 8, Calendar.DATE-Calendar.DATE+1);
		System.out.println(day2.getTime());
	}
	
	public void test5() {
		Date today = new Date();
		System.out.println(today);
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초 EEE");
		System.out.println(format1.format(today));
	}
	
	public void test6() {
		Calendar day = Calendar.getInstance();
		Date date = new Date(day.getTimeInMillis());
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초 EEE");
		System.out.println(format1.format(date));
		
	}

}
 