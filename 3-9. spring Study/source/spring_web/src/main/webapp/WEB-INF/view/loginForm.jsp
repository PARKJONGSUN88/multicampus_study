<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<style>
table {
  width: 30%;
  margin: auto;
  padding : 10px;  
  text-align:center;
   background-color : #e0ffff;
  border-color     : #b0e0e6;
  border-style     : dotted;
}

 
</style>
<title>Insert title here</title>
</head>
<body>

<div id="main">
<h3 style="text-align : center;"> 로그인</h3>

<form method='post' action='./login.do'  >
 <table >
     <tr>
       <td style="width:100;text-align:left;">아이디</td>
       <td><input type="text" id="userid" name="userid" size="20" maxlength="15"/></td>
      </tr>
     <tr>
      <td style="width:100;text-align:left;">비밀번호</td>
        <td><input type="password" id="userpwd" name="userpwd" size="20" maxlength="15"/></td>
        </tr>
        <tr><td colspan="2" align="center">
        <input type="submit" id="login" value="로그인" />&nbsp;&nbsp;
        <a href="./join.do"  ><span style="font-size:small">회원가입</span></a>&nbsp;&nbsp;<a href=""><span style="font-size:small;">아이디/비밀번호 찾기</span></a></td>
        </tr>
      </table>
</form>

</div>

</body>
</html>