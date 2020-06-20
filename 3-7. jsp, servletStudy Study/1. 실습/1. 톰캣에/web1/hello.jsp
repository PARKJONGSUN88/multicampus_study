<%@ page contentType="text/html;charset=utf-8" %>
<%@ page import="java.util.Date" %>
<%-- JSP주석 : HTML태그 + Java코드 포함 --%>
<html>
<head>
<meta charset="utf-8">
<title>hello.jsp</title></head>
<body>
처음 만들어보는 JSP페이지입니다.<br>
<%
//자바 코드영역
	Date now = new Date();
	out.println(now);
%>
</body>
</html>