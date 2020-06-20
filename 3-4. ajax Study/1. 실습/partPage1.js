$(document).ready(function(){
   $("#login").click(function(){
		var uid = $("#userid").val();  
	    var upwd = $("#userpwd").val();  
	    $.ajax({
	    	url: "admin.jsp",
	    	data: {userid: uid, userpwd:upwd},
	    	success : function(data) {	    		
	    		var result = $(data).find("result").text();	    		 
	    		var name = $(data).find("id").text();	    	 
	    		if (result == "1"){//사용자 인증성공시
	    		      var str="<table><tr><td align='center'><b>"+name+"</b> 님 오셨구려..</td></tr>"
	    		      str+="<tr><td align='center'><input type='button' id='logout' value='로그아웃' onclick ='logoutMethod()'/></td></tr></table>"
	    		    	  $("#confirmed").html( str );
	    		}else if(result=="0"){//사용자 인증실패시 - 비밀번호가 틀림
	    		      alert("비밀번호가 맞지 않습니다.\n다시 입력해 주시기 바랍니다.");
	    		      $("#userid").val(name);
	    		      $("#userpwd").val("");
	    		      $("#userpwd").focus();
	    		}else{//사용자 인증실패시 - 아이디가가 틀림
	    		      alert("아이디가 맞지 않습니다.\n다시 입력해 주시기 바랍니다.");
	    		      $("#userid").val("");
	    		      $("#userpwd").val("");
	    		      $("#userid").focus();
	    		}
	    	}
	    });	    
	});
});