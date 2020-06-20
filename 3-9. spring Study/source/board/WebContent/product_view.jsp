<%@page import="java.util.Vector"%> 
<%@ page contentType="text/html;charset=utf-8" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html><head><title>상품 상세 정보</title>
<link rel="stylesheet" href="./resources/css/bootstrap.min.css" />
<link href="mystyle.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function addToCart() {
		if (confirm("상품을 장바구니에 추가하시겠습니까?")) {
			document.addForm.submit();
		} else {		
			document.addForm.reset();
		}
	}
</script>

</head>
 
<body>
 

<h3 id="header">상품 상세 정보</h3>
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


</div>

<div id="main">
 <div class="container">
		<div class="row">
			<div class="col-md-5">
				<img src= "./image/${product_list.filename}" style="width: 100%" />
			</div>
			<div class="col-md-6">
				<h3>${product_list.pname}</h3>
				<p>${product_list.description}</p>
				<p><b>상품 코드 : </b><span class="badge badge-danger"> ${product_list.productId} </span>
				<p><b>제조사</b> :  ${product_list.manufacturer}
				<p><b>분류</b> :   ${product_list.category}
				<p><b>재고 수</b> :    ${product_list.unitsInStock}
				<h4>${product_list.unitPrice}</h4>
				<p><form name="addForm" action="./addCart.jsp?prodid= " method="post">
					<a href="#" class="btn btn-info" onclick="addToCart()"> 상품 주문 &raquo;</a>
					<a href=" " class="btn btn-warning"> 장바구니 &raquo;</a> 
					<a href="./products.do" class="btn btn-secondary"> 상품 목록 &raquo;</a>
				</form>
			</div>
		</div>
		<hr>
	</div>
</div>


</body>
</html>