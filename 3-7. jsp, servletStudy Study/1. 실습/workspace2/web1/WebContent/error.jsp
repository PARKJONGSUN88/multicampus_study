<%@ page contentType="text/html; charset=utf-8"
isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>error.jsp</title>
</head>
<body>
<%
	out.println(exception.getMessage());
%>
</body>
</html>