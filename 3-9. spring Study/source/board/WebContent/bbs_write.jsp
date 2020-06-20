<%@ page contentType="text/html; charset=utf-8" %>
<html>
<head>
<meta charset="utf-8">
<title>게시판 글 작성</title>
</head>
<link href="mystyle.css" rel="stylesheet" type="text/css">
<body>
<c:if test='${empty user}'>
<div style='text-align:right'>
<a href="./login.jsp">로그인</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="">회원가입</a> &nbsp;&nbsp;&nbsp;&nbsp;
</div>
</c:if>
<h3 id="header">게시판 글 작성</h3>
<form method='post' action='write.do' enctype="multipart/form-data">
<table width='100%'>
 
<tr><td>제목</td><td><input type='text' name='subject' size="50"></td></tr>

	<tr><td>이름</td>
		<td><input type='text' name='writer'  ></td></tr>
	<tr><td>암호</td>
		<td><input type='password' name='password' ></td></tr>
	<tr><td>Email</td>
		<td><input type='text' name='email' size="50"></td></tr>
	


<tr><td>내용</td><td>
<textarea cols='65' name='contents' rows='20'></textarea>
</td></tr>


 
 
<tr><td>파일 첨부 </td>
		<td><input type='file' name='upload' ></td></tr>
 	
<tr><td colspan='2' align='center'>
<a href="./bbs_list.do">글목록</a>
<input type='submit' value="글쓰기 저장" > 
<input type='reset' value="글쓰기 취소" >
</td></tr>
</table>
</form>



</body>
</html>
