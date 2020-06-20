var req; //XMLHttpRequest객체를 저장할 변수를 전역변수로 선언
window.onload=function(){ //브라우저가 로드 되었을때 처리를 실행하는
	req=new XMLHttpRequest(); //XMLHttpRequest객체 생성
	document.getElementById("login").onclick=startMethod;
};

function startMethod(){
	var uid=document.getElementById("userid").value;
	var upwd=document.getElementById("userpwd").value;
	var url="admin.jsp"; //요청URL설정
	req.onreadystatechange=resultProcess;//응답결과를 처리메소드
	req.open("post", url, "true");//서버의 요청설정-url변수에 설정
	req.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	req.send("userid="+uid+"&userpwd="+upwd);//서버로 요청을 보냄
};

function resultProcess(){//admin.jsp페이지에서 응답결과가 오면
	if(req.readyState==4){//요청객체의 상태가 모든 데이터를 받을 수
		if(req.status==200){//서버로부터 응답받는 HTTP상태가 정산인 경우 수행
			confirmedProcess();//confirmedProcess()메소드 호출
		}
	}
}

function confirmedProcess(){//로그인의 성공과 실패에 따라 표시되는 내용을 결정하는 메소드
    var result =req.responseXML.getElementsByTagName("result")[0].firstChild.data;
    var name = req.responseXML.getElementsByTagName("id")[0].firstChild.data;
     
    if (result == 1){//사용자 인증성공시
      var str="<table><tr><td align='center'><b>"+name+"</b> 님 오셨구려..</td></tr>"
      str+="<tr><td align='center'><input type='button' id='logout' value='로그아웃' onclick ='logoutMethod()'/></td></tr></table>"
    	  document.getElementById("confirmed").innerHTML = str;
    }else if(result==0){//사용자 인증실패시 - 비밀번호가 틀림
      alert("비밀번호가 맞지 않습니다.\n다시 입력해 주시기 바랍니다.");
      document.getElementById("userid").value=name;
      document.getElementById("userpwd").value="";
      document.getElementById("userpwd").focus();
    }else{//사용자 인증실패시 - 아이디가가 틀림
      alert("아이디가 맞지 않습니다.\n다시 입력해 주시기 바랍니다.");
      document.getElementById("userid").value="";
      document.getElementById("userpwd").value="";
      document.getElementById("userid").focus();
    }
}