<%@ page contentType="text/html; charset=utf-8"
    isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>error.jsp</title>
</head>
<body>
예외가 발생하엿습니다. <br>
<%= exception.getMessage() %> <br>
${exception.message} <br>
</body>
</html>