package kh.java.database;

import java.util.ArrayList;

import kh.java.vo.Grade;

public class PointDatabase {
	private ArrayList<Grade> members;


	public PointDatabase(){
		members = new ArrayList<Grade>();
		
	}
	public boolean register(Grade member) {
		
		if (member != null) {
			String memberName = member.getName();
			for (int i = 0; i < members.size(); i++) {
				String objName = members.get(i).getName();
				if (objName.equals(memberName)) {
					return false;
				}
			}
			members.add(member);
			return true;
		}
		return false;
	}
	
	public ArrayList<Grade> printAllMember() {
		return members;
	}
	
	
	public Grade printMember(int i) {
		return members.get(i);
	}

	
	public void deleteMember(int i) {
		if(i==-1)
			return;
		members.remove(i);
	}
	
	public int findMember(String name) {
		for (int i = 0; i < members.size(); i++) {
			String objName = members.get(i).getName();
			if (objName.equals(name))
				return i;
		}
		return -1;
	}

}

