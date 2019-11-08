
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="lab.latte.issue.model.TimelineVO" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <meta name="generator" content="">  

  
  
  <!-- global resources -->
  <!-- %@ include file="global/resources_header.jsp" %--> 
  
  <!-- Custom styles for this template -->
  <link href="resources/css/home.css" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.css">
  
  <!-- title -->
  <title>잇슈왓슈 - IssueWhatShow</title>
</head>

<body>   

  <!-- GNB -->
  <!-- %@ include file="global/gnb.jsp" %-->

  <!-- Main Contents [START]-->
  <div class="body">
  
  <!-- 페이지 변경시 이미지 -->
  <div id="warpDiv"><img src="resources/images/warp.gif"/></div>
    
  <!-- 메인 3D 그래프 -->
  <div class="graph-wrap">
    <div id="3d-graph"></div>
  </div>
        
  <!-- 사이트 로고 -->
  <div id="spacehorseDiv"><img id="spacehorse" src="resources/images/logo.png"/></div>
       
  <!-- 시계 -->
  <div class="clockcontainer">
		<div class="clockinner">
			<div id="clockDate">시간여행을 시작합니다.</div>
			<ul id="clockul">
				<li id="clockhours" class="clockli">00</li>
			    <li id="clockpoint" class="clockli">:</li>
			    <li id="clockmin" class="clockli">00</li>
			    <li id="clockpoint" class="clockli">:</li>
			    <li id="clocksec" class="clockli">00</li>
			</ul>
		</div>
		

	</div> 
    
  <!-- Timeline 이동 -->
  <div class="timeline">
      <div class="timelineinner">
        <ul class="time-past">
          <li>
            <div class="travel-5 travel-target">
              <span class="tr-day"></span>
              <span  class="tr-time"></span>
            </div>
          </li>
          <li>
            <div class="travel-4 travel-target">
              <span class="tr-day"></span>
              <span  class="tr-time"></span>
            </div>
          </li>
          <li>
            <div class="travel-3 travel-target">
              <span class="tr-day"></span>
              <span  class="tr-time"></span>
            </div>
          </li>
          <li>
            <div class="travel-2 travel-target">
              <span class="tr-day"></span>
              <span  class="tr-time"></span>
            </div>
          </li>
          <li>
            <div class="travel-1 travel-target">
              <span class="tr-day"></span>
              <span  class="tr-time"></span>
            </div>
          </li>
        </ul>
        <div class="travel-center">
          <div class="t-input">
            <input id="tYear" type="text" maxlength="4"/>
            <input id="tMonth" type="text" maxlength="2"/>
            <input id="tDay" type="text" maxlength="2"/>
          </div>
          <div class="t-input">
            <input id="tHour" type="text" maxlength="2"/>
            <input id="tMinute" type="text" maxlength="2"/>
          </div>
          <!-- 
          <span id="travelDay"></span>
          <span id="travelTime"></span>
           -->
        </div>
        <ul class="time-future">
           <li>
            <div class="travel-1 travel-target">
              <span class="tr-day"></span>
              <span  class="tr-time"></span>
            </div>
          </li>
          <li>
             <div class="travel-2 travel-target">
              <span class="tr-day"></span>
              <span  class="tr-time"></span>
            </div>
          </li>
          <li>
             <div class="travel-3 travel-target">
              <span class="tr-day"></span>
              <span  class="tr-time"></span>
            </div>
          </li>
          <li>
             <div class="travel-4 travel-target">
              <span class="tr-day"></span>
              <span  class="tr-time"></span>
            </div>
          </li>
          <li>
            <div class="travel-5 travel-target">
              <span class="tr-day"></span>
              <span  class="tr-time"></span>
            </div>
          </li>
        </ul>  
      <span><button id="btnCustomWarp">입력한 시점으로 출발합니다</button></span>  	
      <span class="copyright" onclick="document.getElementById('infojs').style.display='block'">&nbsp;&nbsp;2019_Training for 4th Industrial Revolution_Open API를 활용한 빅데이터 전처리・시각화_B반.&nbsp;&nbsp;&nbsp;&nbsp;Team_Latte is Horse.&nbsp;&nbsp;Project_IssueWhatShow.&nbsp;&nbsp;</span> 	
      </div>                       
    </div>
    
  <!-- 주요키워드 이동 -->    
  <div id="sigWordsWrap">
      <table>
        <tr>
          <td id="sigBtn">
                                        〉
          </td>
          <td class="sig-td">
            <ul class="sig-ul-outer">
              <li class="sig-li-outer">
              </li>
            </ul>
          </td>
        </tr>
      </table>
    </div>


	<!-- 로딩 -->
  <div id = loading></div> 

  <!-- 뉴스가 잘 들어가질까아? -->

  <div id = "newscover">
  
	<div id="newslist">
		<div id="newlistcontent"></div>
		<div class = "infonote" id="infonote0"></div>
		<div class = "infonote" id="infonote1"></div>
		<div class = "infonote" id="infonote2"></div>
		<div class = "infonote" id="infonote3"></div>
		<button id ="closenews">뉴스 닫기</button>
	</div>

  </div>
		
  <!-- 라이센스 -->
  <div id='infojs' class="infototaldiv">    
    <div class="infoinnerpage">       
    <button onclick="document.getElementById('infojs').style.display='none'" id="xbutton">&times;</button>
	  <div id="infoneyong">          
	    <h2>References &amp; Open sources</h2>
        <h4>시각화 라이브러리</h4>
       	<h5>3d-force-graph<span>, MIT License&nbsp;&nbsp;</span><a href="https://github.com/vasturiano/3d-force-graph" target="_blank">github.com/vasturiano/3d-force-graph</a></h5>
        <hr>
        <h4>형태소 분석기</h4>
       	<h5>Khaiii<span>, Apache License v2.0&nbsp;&nbsp;</span><a href="https://github.com/kakao/khaiii" target="_blank">github.com/kakao/khaiii</a></h5>
       	<h5>Komoran<span>, Apache License v2.0&nbsp;&nbsp;</span><a href="https://www.shineware.co.kr/products/komoran/" target="_blank">shineware.co.kr/products/komoran</a></h5>
        <hr>
        <h4>적용한 NLP 이론</h4>
        <h5>word2vec<span>, Paper&nbsp;&nbsp;</span><a href="https://en.wikipedia.org/wiki/Word2vec" target="_blank">en.wikipedia.org/wiki/Word2vec</a></h5>
        <h5>TF-IDF<span>, Paper&nbsp;&nbsp;</span><a href="https://en.wikipedia.org/wiki/Tf%E2%80%93idf" target="_blank">en.wikipedia.org/wiki/Tf-idf</a></h5>
        <hr>
        <h4>그리고 많은 오픈소스 라이브러리들</h4>
       	<h5>NAVER 뉴스 + API, DAUM 뉴스, Twitter API, cloudflare, Google CDN, BeautifulSoup4, pandas, yweather, numpy, konlpy, gensim...</h5>
        <h5>and many...</h5>    
        <div class="infoclosediv">
          <button onclick="document.getElementById('infojs').style.display='none'" id="closebutton">Close</button> 
        </div> 
       </div>
    </div>    
  </div>		    
  <!-- Main Contents [END] -->
    
  <!-- 공용 data container -->
  <div id="yymmdd" class="hidden">${timeunit.yymmdd }</div>
  <div id="hhmm" class="hidden">${timeunit.hhmm }</div>
  <div id="searchWord" class="hidden">${timeunit.searchword }</div>
  <div id="visData" class="hidden">${timeunit.visdata }</div>
  <form id="warp" method="post" action="/" class="hidden">
    <input id="warpDate" name="yymmdd" value="" type="text"/>
    <input id="warpTime" name="hhmm" value="" type="text"/>
  </form>  
      
  <!-- footer -->
  <!-- %@ include file="global/footer.jsp" % -->
  </div>
  
  <!-- global resources -->
  <%@ include file="global/resources_body.jsp" %>
  
  <!-- current resources -->
  <script type="text/javascript" src="resources/third-party-etc/three.js"></script>
  <script type="text/javascript" src="resources/third-party-etc/three-spritetext.js"></script>
  <script type="text/javascript" src="resources/third-party-etc/3d-force-graph.min.js"></script>
  <script type="text/javascript" src="resources/third-party-etc/dat.gui.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-confirm/3.3.2/jquery-confirm.min.js"></script>
  <script type="text/javascript" src="resources/js/util.js"></script>
  <script type="text/javascript" src="resources/js/timeline-api.js"></script>
  <script type="text/javascript" src="resources/js/home.js"></script>

</body>
</html>