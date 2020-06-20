<%@ page contentType="text/html; charset=utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>calc.jsp</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
 //action="./CalcServlet"  method="post"
 $(document).ready(function(){
	 $("#f1").submit( function(event){
		 event.preventDefault();
		 var n1 = $("#num1").val();
		 var n2 = $("#num2").val();
		 var op = $("#operator option:selected").val();		 
		  $.ajax( {
			    url  : "./CalcServlet",
			    data : {"num1" : n1, "num2": n2, "operator" : op},
				  success: function(data){ 
					  console.log(data);
					  $("#result").html("<mark>"+n1+op+n2+"="+data+"</mark>");
				  }
		  });
		 
	 })
 });
 
</script>
</head>
<body>
<h3>계산기</h3>
  <form id="f1" >
   number1 :
   <input type="text"  name="num1" id="num1"  ><br>
   operator :
   <select name="operator" id="operator">
   <option value="+">+</option>
   <option value="-">-</option>
   <option value="*">*</option>
   <option value="/">/</option>
   </select>
   <br>
   number2 :
   <input type="text"  name="num2"  id="num2" ><br>
   
   <input type="submit"  value="계산">
  </form>
  <hr>
  계산결과 :  <span id="result"></span>
</body>
</html>