<%@page import="kr.or.iei.member.model.vo.Member" %>
<%@page import="kr.or.iei.member.model.service.MemberService" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	request.setCharacterEncoding("utf-8");

    	int memberNo = Integer.parseInt(request.getParameter("memberNo"));
    	String memberPw = request.getParameter("memberPw");
    	String phone = request.getParameter("phone");
    	String address = request.getParameter("address");
    	
    	Member member = new Member();
    	
    	member.setMemberNo(memberNo);
    	member.setMemberPw(memberPw);
    	member.setPhone(phone);
    	member.setAddress(address);
    	
    	int result = new MemberService().update(member);
    	
    	if(result>0){
//    		Member m = (Member)session.getAttribute("member");
  //  		Member newM = new MemberService().selectOneMember(m.getMemberId(), member.getMemberPw());
    //		session.setAttribute("member", newM);	
    
    		Member m = (Member)session.getAttribute("member");
    		m.setMemberPw(memberPw);
    		m.setPhone(phone);
    		m.setAddress(address);
    	}
    	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
</body>
	<script>
		alert(result>0?"정보변경 성공!":"정보변경 실패")
		location.href="/05_jspDbProject/index.jsp";
	</script>
</html>