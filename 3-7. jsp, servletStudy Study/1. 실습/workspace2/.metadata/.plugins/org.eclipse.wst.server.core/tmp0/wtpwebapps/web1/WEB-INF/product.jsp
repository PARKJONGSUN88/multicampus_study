<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>calc.jsp</title>
  
</script>
</head>
<body>
<h3>계산기</h3>
  <form id="f1" action="./Price" method="post">
  <table>
   <tr><td width=150> 상품명</td><td width=150> 가격</td><td width=150> 수량</td>
   <tr><td>
   <input type="hidden"  name="snak1" id="snak"  value="새우깡" >
   <br>
   <img src="./images/shimp.jpg" width=100 height=100>
   </td>
   <td>
   1500원
   <input type="hidden"  name="price1" id="price"  value="1500" >
   </td>
   <td>
   <select name="qty1" id="qty">
   <option value="0">0</option>
   <option value="1">1</option>
   <option value="2">2</option>
   <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
   </select>
  </td>
  </tr>
   <tr><td>
   <input type="hidden"  name="snak2" id="snak"  value="바나나퀵" >
   <br>
   <img src="./images/banana.jpg" width=100 height=100>
   </td>
   <td>
   1000원
   <input type="hidden"  name="price2" id="price"  value="1000" >
   </td>
   <td>
   <select name="qty2" id="qty">
   <option value="0">0</option>
   <option value="1">1</option>
   <option value="2">2</option>
   <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
   </select>
  </td>
  </tr>
   <tr><td>
   <input type="hidden"  name="snak3" id="snak"  value="칸초" >
   <br>
   <img src="./images/ccancho.JPG" width=100 height=100>
   </td>
   <td>
   1200원
   <input type="hidden"  name="price3" id="price"  value="1200" >
   </td>
   <td>
   <select name="qty3" id="qty">
   <option value="0">0</option>
   <option value="1">1</option>
   <option value="2">2</option>
   <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
   </select>
  </td>
  </tr>
   </table>
   <input type="submit"  value="계산">
  </form>
  <hr>
  계산결과 :  <span id="result"></span>
</body>
</html>