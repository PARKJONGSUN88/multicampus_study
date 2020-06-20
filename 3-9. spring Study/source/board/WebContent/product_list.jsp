<%@page import="java.util.Vector"%> 
<%@ page contentType="text/html;charset=utf-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html><head><title>상품 목록</title>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
<link href="mystyle.css" rel="stylesheet" type="text/css">
</head>

<body>
 
<h3 id="header">상품 목록</h3>
<div id='menu'>

<div id="menucontainer">
	<div id="shatop"></div>
	<h3 class="center">메 뉴</h3>
	<a href="./login.do?action=logout">로그아웃</a>
	<div class="blank">&nbsp;</div>
	<a href="./member_edit.jsp">정보수정</a>
	<div class="blank">&nbsp;</div>
	<a href=notice.jsp>공지사항</a>
	<div class="blank">&nbsp;</div>
	<a href=user_list.jsp>회원목록</a>
	<div class="blank">&nbsp;</div>
	<a href="./products.do">쇼핑하기</a>
	<div class="blank">&nbsp;</div>	
	<a href=Mail>전자메일</a>
	<div class="blank">&nbsp;</div>
	<a href="./list.do">게 시 판</a>
	<div class="blank">&nbsp;</div>
	<div class="blank">&nbsp;</div>	 
	<div class="blank">&nbsp;</div>
	<div class="blank">&nbsp;</div>		
	
	</div>
</div>

<div id="main">
<div class="container">
		<div class="row" align="center">		
		<c:forEach var="products" items="${products}">
			<div class="col-md-4">
				<img src="./image/${products.filename}" style="width: 100%">
				<h3>${products.pname}</h3>
				<p>${products.description}</p>
				<p>${products.unitPrice}</p>
				<p><a href="./productView.do?productid=${products.productId}" class="btn btn-secondary" role="button"> 상세 정보 &raquo;</a></p>
			</div>		
		</c:forEach>
					 
			
</div>
		<hr>
	</div>

	</div>


</body>
</html>