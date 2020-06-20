<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>postResult.jsp</title>
</head>
<body>
<h3>메시지 전송 결과</h3>
<%
	if(request.getParameter("msg") != null
		&& request.getAttribute("address") != null) {
%>
send.jsp에서 보낸 파라미터 메시지 : <%= request.getParameter("msg") %><br>
Postservlet에서 보낸 메시지: <%= request.getAttribute("address") %><br> 
<%
}else{
%>
sendRediect()로 요청을 전달하면,
요청된 페이지에 새로운 request와 response객체가 전달되므로 <br>
파라미터와 Attribute를 request로부터 추출할 수 없습니다.<br>
<%
}
%>
</body>
</html>