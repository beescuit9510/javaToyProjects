package kh.exam.controller;

import java.util.ArrayList;

import kh.exam.dao.Dao;

import kh.exam.vo.Memo;

public class Controller {
	
	public static void main(String[] args) {
		main1();
	}

	public static void main1() {

		Dao dao = new Dao();

		Memo m = new Memo();

		m.setNo(101);

		m.setName("홍길동");

		m.setMsg("환영합니다");

		int result = dao.update(m);

//		if (result > 0) {
		if (result > 0) {

			System.out.println("변경 성공");

		} else {

			System.out.println("변경 실패");

		}

	}

}