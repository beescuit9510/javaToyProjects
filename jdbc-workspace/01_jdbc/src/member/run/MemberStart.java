package member.run;

import java.sql.DriverManager;

import member.controller.MemberController;

public class MemberStart {
	
	public static void main(String[] args) {
		MemberController mc = new MemberController();
		mc.main();
		
		
	}

}
