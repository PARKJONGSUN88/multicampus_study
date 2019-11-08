<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<head>
  <meta charset="UTF-8">
  <title>page-test</title>
  <style> body { margin: 0; } </style>
</head>

<body>
  
  <h1>VISDATA to 3d-force 테스트</h1>
  <div>
  </div>
  <div>
  	<button type="button" id="btnPrev">&lt;</button>
  	<input type="number" id="posNum" style="text-align:center; width:30px"
       max=0 value=0 readonly/>
  	<button type="button" id="btnNext">&gt;</button>
    <input type="number" id="toGoNum" style="text-align:center; width:30px"
       max=0 value=0/>
    <button type="button" id="btnGo">Go</button>
  </div>
  
  <br/>
  <hr/>
  <div id="3d-graph"></div>
  
  
  <!-- global resources -->
  <%@ include file="global/resources_body.jsp" %>
  
  <!-- current resources -->
  <script type="text/javascript" src="resources/third-party-etc/three.js"></script>
  <script type="text/javascript" src="resources/third-party-etc/three-spritetext.js"></script>
  <script type="text/javascript" src="resources/third-party-etc/3d-force-graph.min.js"></script>
  <script type="text/javascript" src="resources/js/page-test.js?1"></script>

</body>
</html>