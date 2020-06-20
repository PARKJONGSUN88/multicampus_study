<%@page import="lab.web.model.Product"%>
<%@ page   contentType="text/html; charset=utf-8"    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>priceResult.jsp</title>  
</script>
</head>
<body>
<h3>구매 상품 리스트</h3>
<table> 
<tr><td width=150> 상품명</td><td width=150> 가격</td><td width=150> 수량</td><td> 합계</td></tr>
<%
 int total = 0;
 Product[] products = (Product[])request.getAttribute("products");
 for (int i=0;i<products.length;i++){
	 
	 out.print("<tr><td>"+products[i].getName()+"</td>");
	 out.print("<td>"+products[i].getPrice()+"원</td>");
	 out.print("<td>"+products[i].getQty()+"개</td>");
	 total += products[i].getPrice()*products[i].getQty();
	 out.print("<td>"+(products[i].getPrice()*products[i].getQty())+"원</td></tr>");
 }
%>  
   
</table>   
  <hr>
  총 구매 가격:  <span id="result"> <%=total %>원</span>
</body>
</html>
