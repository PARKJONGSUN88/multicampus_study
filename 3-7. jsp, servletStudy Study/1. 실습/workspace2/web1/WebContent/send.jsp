<%@ page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>message.jsp</title>
</head>
<body>
<h3>메시지 전송</h3>
	<form id="f1" action="./PostServlet"  method="post">
   메시지 입력하세요<br>
   <input type="text"  name="msg"  size=100><br>
   <br>
   <input type="submit"  value="전송">
  </form>
</body>
</html>