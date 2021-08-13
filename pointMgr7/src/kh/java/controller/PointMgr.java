package kh.java.controller;

import java.util.ArrayList;

import java.util.StringTokenizer;

import kh.java.view.PointView;
import kh.java.vo.Gold;
import kh.java.vo.Grade;
import kh.java.vo.Silver;
import kh.java.vo.Vip;
import kh.java.database.PointDatabase;

public class PointMgr {
//	private ArrayList<Grade> members = new ArrayList<Grade>();
	private PointView view;
	private int index;
	private PointDatabase db;

	public PointMgr() {
		view = new PointView();
		db = new PointDatabase();
	}

	public void main() {
		while (true) {
			int sel = view.main();

			switch (sel) {
			case 1:
				register();
				break;
			case 2:
				printAllMember();
				break;
			case 3:
				printMember();
				break;
			case 4:
				editMember();
				break;
			case 5:
				deleteMember();
				break;
			}
		}
	}

	public void register() {
		view.register();
		addMember();
	}
	
	public void addMember() {
		boolean isRegistered = db.register(view.addMember());
		
		if (isRegistered)
			view.suceed();
		else
			view.fail();

	}

	public void printAllMember() {
		view.printAllMember(db.printAllMember());
		view.suceed();
	}

	public void printMember() {
		view.printMember();
		if (isMemberInList()) {
			view.printMember(db.printMember(index));
			view.suceed();
		}
	}

	public void editMember() {
		view.editMember();
		if (isMemberInList()) {
			db.deleteMember(index);
			addMember();
		}

	}

	public void deleteMember() {
		view.deleteMember();
		if (isMemberInList()) {
			db.deleteMember(index);
			view.suceed();
		}
	}


	public boolean isMemberInList() {
		int i = db.findMember(view.findMember());
		if (i == -1) {
			view.noMemberInList();
			index = i;
			view.fail();
			return false;
		}
		return true;
	}

}
