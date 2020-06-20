var req;
window.onload=function(){
	document.querySelector("#btn_load").onclick=function(){
	var url="images.jsp";	//요청 URL설정
	req=new XMLHttpRequest();	//XMLHttpRequest객체 생성
	req.onreadystatechange=createImages;
	req.open("Get", url, "true");
	req.send(null);	//서버로 요청을 보냄
	};
}

function createImages(){
	if(req.readyState==4){	//요청객체의 상태가 모든 데이터를 받을 수 있는 경우
		if(req.status==200){ //서버로부터 응답받는 HTTP상태가 정상인 경우
			var obj=JSON.parse(req.responseText);
			var images=obj["rows"];
			var strDOM="";
			for(var i=0;i<images.length;i++){
				//2.N번째 이미지 정보를 구합니다.
				var image=images[i];
				//3. N번재 이미지 패널을 생성합니다.
				strDOM +='<div class="image_panel">'
				strDOM +='	<img src="'+image.url+'">';
				strDOM +='	<p class="title">'+image.title+'</p>';
				strDOM +='</div>';
			}
			document.querySelector("#image_container").innerHTML=strDOM;
		}else{
			alert("처리중 에러가 발생했습니다.");
		}
	}
}