package kr.or.iei.member.controller;

import kr.or.iei.member.model.service.MemberService;
import kr.or.iei.member.model.view.MemberView;

public class MemberController {
	private MemberView view;
	private MemberService service;
	public MemberController() {
		super();
		view = new MemberView();
		service = new MemberService();
		
	}

	public void main() {
		while(true) {
			int sel = view.main();
			switch(sel) {
				case 1:
					deleteMember();
					break;
				case 2:
				
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 0:
					return;			
			}
		}
	}
	
	public void selectAllMember() {
		view.printMember(service.selectMember());
		
	}
	
	public void deleteMember() {
		String id = view.getId();
		int r = service.deleteMember(id);
		view.resultMsg(r > 0);
		
	}

}
