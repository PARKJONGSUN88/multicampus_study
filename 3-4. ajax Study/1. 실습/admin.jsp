<%@ page   contentType="text/xml; charset=utf-8"     %>
<%
    request.setCharacterEncoding("utf-8"); 
    //반드시 응답되는 내용의  Content-type을 "text/xml;charset=utf-8"해야함, 생략시 결과가 표시되지 않을 수 있음
    // response.setContentType("text/xml;charset=utf-8");//응답되는 내용의 Content-type을 설정

    String outString = ""; // 요청한 페이지인 partPageDBUse.js로 리턴할  결과를 저장
    int result = 0 ;
    String id = request.getParameter("userid"); 
    String passwd = request.getParameter("userpwd"); 
     
    if(id.equals("admin")&&passwd.equals("1234")){
    	result = 1;
    }else if(id.equals("admin")){
    	result = 0;
    }else{
    	result = 2;
    }
     
    
    //userCheck()메소드의 수행후 리턴되는 결과 값에 따라 처리
    if(result==1){//사용자 인증에 성공시
		session.setAttribute("id",id);
		outString="<response><result>"+ result + "</result><id>"+ id 
				+"</id></response>";
	}else if(result==0){//사용자 인증에 실패시 - 비밀번호 틀림
		outString="<response><result>"+ result + "</result><id>"+ id 
		+"</id></response>";
    }else{//사용자 인증에 실패시 - 아이디 틀림
    	outString="<response><result>"+ result + "</result><id>"+ id 
    	+"</id></response>";
    }	
    
    out.println(outString); // outString의 내용을 요청한 페이지인 partPageDBUse.js로 응답함
    
%>



