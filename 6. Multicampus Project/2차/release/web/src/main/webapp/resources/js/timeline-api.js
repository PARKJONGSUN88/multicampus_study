/**
 * timeline-api.js
 */


/*-----------------------------------------------------------------------------
 * 3d-force-graph 갤럭시 그리기
 */
function initGalaxy(){
	$.ajax({
        url: 'apis/getLastTimeunit',
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        success: function(data){

        	$('#posNum').val(0);
        	let gData = parseTimeline(data);
        	drawGalaxy(gData);
        },
        error: function(equest,status,error) {
        	/*console.error("fail: " + 'apis/getLastTimeunit');*/
        }
    });
}


/*-----------------------------------------------------------------------------
 * visdata로 nodes와 links 만들기
 */
function parseTimeline(data){  		
	
	// visdata 가져오기
	let visdata = data;
//	console.log(visdata);
	
	// 노드 정보 불러오기
	let nodes = visdata['nodes'];
	
	// 디스턴스 매트릭스 불러오고 매트릭스 형태로 변환하기
	let dmatrix = visdata['dmatrix'];
	let dlines = dmatrix.split("\n");
	dlines.pop();
	let mtrx = []
	for (j in dlines) {
		let dcols = dlines[j].split(",");
		mtrx[j] = dcols;
	}
	let len = mtrx.length;
	
	// 노드 JSON 만들기 
	let distThreshold = getThreshold(mtrx);
	let minmax = getNodeMinMax(nodes);
	let min = minmax['min'];
	let max = minmax['max'];
	let nodesJson = [];
	let nodeVals = []
	nodes.forEach(function(d, i){
		// 충분히 강한 링크가 있는 노드들만 추가하기
		let bNodeAdd = false;
		for (j=0; j<i; j++){
			if (mtrx[i+1][j+1] <= distThreshold){
				bNodeAdd = true;
				break;
			}
		}
		if (!bNodeAdd){
			for (j=i; j<len; j++){
				if (j+2 == len)
					break;
				
				if (mtrx[j+2][i+1] <= distThreshold){
					bNodeAdd = true;
					break;
				}
			}
		}
		
		// 링크 검사가 끝난 노드만 추가
		if (bNodeAdd){
			let val = Math.max(
				Math.min(
					Math.sqrt(((d['val'] - min) / (max - min))*100)*4
					, 20
				)
				, 5
			);

			node = { 
				"id" : d['id'],
				"word" : d['word'],
				"group" : d['group'],
				"val" : val
			}

			nodesJson.push(node);
			nodeVals.push(val);
//			console.log(node);
		}
	});
	
	
	// 링크 JSON 리스트 만들기
	let linkJson = [];
	for (j = 1; j < len; j++){
		let tempLinks = []
		for (k = 1; k < j; k++){
			dist = mtrx[j][k];
			
			// 3d-force 수치에 맞게 distance 값 설정
			if (dist > distThreshold)
				continue;
			else
				dist = Math.pow(dist*5, 4);
			
			// 같은 그룹이면 가깝게, 다른 그룹이면 멀게
			if (nodes[j-1]['group'] == nodes[k-1]['group'])
				dist = dist*0.9;
			else
				dist = dist*2;
				
			let forward = {
				"source" : nodes[j-1]['id'], "target" : nodes[k-1]['id'], 
				"group" : nodes[k-1]['gorup'], "dist" : dist
			};
			let reverse = {
				"source" : nodes[k-1]['id'], "target" : nodes[j-1]['id'], 
				"group" : nodes[j-1]['gorup'], "dist" : dist
			};
				
			if (nodeVals[j-1] < nodeVals[k-1]){
				tempLinks.push(forward);
			} else {
				tempLinks.push(reverse);
			}	
			
			// 중요도가 같은 노드끼리 더 가까이 붙어 시각화가 조금 왜곡되는 문제로 삭제
			// 소실되는 양방향성 관계 정보는 크게 중요하지 않아 버림.
			/*
			} else if (nodeVals[j-1] > nodeVals[k-1]){
				tempLinks.push(reverse);
			} else {
				tempLinks.push(forward);
				tempLinks.push(reverse);
			}
			*/
		}
		tempLinks.forEach(function(d, k){
			linkJson.push(d);
		});
	}
	
	return {nodes : nodesJson, links : linkJson};
}

/*-----------------------------------------------------------------------------
 * 정규화를 위한 node val의 min, max 구하기
 */
function getNodeMinMax(nodes){
	let min = 100;
	let max = 0;
	nodes.forEach(function(d, i){
		min = Math.min(min, d['val']);
		max = Math.max(max, d['val']);
	});
	
	return {"min" : min, "max" : max}
}


/*-----------------------------------------------------------------------------
 * 적절한 링크 강도 threshold 만들기
 * 최대링크 개수 2700개로 제한
 */
function getThreshold(mtrx){
	let len = mtrx.length;
	let threshold = 0.7;
	let limitCount = 2700;
	for (ts = threshold; ts > 0.0; ts-=0.002){
		let count = 0;	
		for (j=1; j<len; j++) {
			for (k=1; k<j; k++){
				if (mtrx[j][k] <= ts)
					count++;
			}
		}
		
		if (count <= limitCount){
			threshold = ts;
			break;
		}
	}
	
	return threshold;
}


/*-----------------------------------------------------------------------------
 * 실제 3d-force-graph를 그리는 함수
 */
function drawGalaxy(gData){
	// 그래프 그리기
	g_graph = ForceGraph3D()(document.getElementById('3d-graph'))
		.graphData(gData)
		.nodeAutoColorBy('group')      
		.nodeThreeObject(node => {
			const obj = new THREE.Mesh(
		    	new THREE.SphereGeometry(10),
		    	new THREE.MeshBasicMaterial(
					{depthWrite: false, transparent: true, opacity: 0}
		    	)
		  	);          
			const sprite = new SpriteText(node.word);
				sprite.color = node.color;
		    	sprite.textHeight = node.val;
		    	obj.add(sprite);
		    return obj;
		})
		//.linkDirectionalParticles(3)
		.linkOpacity(0.08)
		.nodeVisibility( node => node.val >= settings.NodeThreshold);
		//오른쪽 클릭 하면 검색! 
		g_graph.onNodeClick(node => searchingnode(node , gData));
		
	//g_graph.d3Force('charge').strength(-500);

	// 링크거리 조절
	const g_linkForce = g_graph
		.d3Force('link')
		.distance(link => link.dist * settings.LinkStrength);
	
	// 그래프 조절 세팅 값
    const Settings = function(){
      this.NodeThreshold = 4.5;
      this.LinkStrength = 1;
      this.Dimensions = 3;
    };
    const settings = new Settings();
	
    // 컨트롤러 장착
    const gui = new dat.GUI();
    const ctrllr = gui.add(settings, 'NodeThreshold', 0, 19.5);
    //const ctrllr2 = gui.add(settings, 'LinkStrength', -3, 3);
    //const ctrllr3 = gui.add(settings, 'Dimensions', 1, 3);
    
    ctrllr.onChange(() => {
    	g_graph.refresh();
    });
/*
    ctrllr2.onChange(() => {
    	g_graph.numDimensions(parseInt(settings.Dimensions));
    });
    ctrllr3.onChange(() => {
    	g_graph.numDimensions(parseInt(settings.Dimensions));
    });
*/    
}


/*-----------------------------------------------------------------------------
 * ajax 로 다시 그리기 구현시 필요하여 만들었으나, ajax시 가비지 컬렉팅 타이밍에 따라 계속 느려질 수 있어
 * post 통신으로 새페이지 로드로 바꾸면서 사용하지 않음.
 */
function reDrawGalaxy(gData){
	let {nodes, links} = g_graph.graphData();
	links = links.filter(l => false);
	nodeIds = nodes.map(node => node.id);
	nodeIds.forEach((d, i) => nodes.slice(d.id, 1));
	
	g_graph.graphData(gData);
	//오른쪽 클릭 하면 검색! 
	g_graph.onNodeClick(node => searchingnode(node , gData));
}


/*-----------------------------------------------------------------------------
 * 복잡한 3d-graph의 briefing 역할을 하는 계기판을 위해 중요 키워드 추출
 */
function getSigwordsMtrx(){
	let {nodes, links} = g_graph.graphData();
	
	let groupSet = new Set();
	for (node of nodes){
		let group = node['group'];
		if(groupSet.has(group))
			continue;
		else
			groupSet.add(group);
	}
	
	function compare(a, b) {
		if ( a['val'] < b['val'] ){
			return 1;
		}
		if ( a['val'] > b['val'] ){
			return -1;
		}
			return 0;
	}
	
	let sigwordsMtrx = [];
	let groups = groupSet.keys()
	for(group of groups){
		let nodesSubset = nodes.filter(node => node['group'] == group );
		nodesSubset = nodesSubset.sort(compare);
		let nodesSubsetSubset = [];
		let count = 0;
		for (node of nodesSubset){
			nodesSubsetSubset.push(node);
			count++;
			if (count >= 3)
				break;
		}
		sigwordsMtrx.push(nodesSubsetSubset);
	}
	
	return sigwordsMtrx;
}

// 색칠공부
function setSigwordsColor(){
	g_graph.nodeThreeObjectExtend(node => {
		let rgb = hexToRgb(node.color);
		let domEl = $("ul.sig-ul-inner li[group='" + node.group + "']");
		domEl.css('background-color',  "rgba(" + rgb.r + ", " + rgb.g 
				+ ", " + rgb.b + ", 0.7)");
		
		return false;
	});
	
	setTimeout(function(){
		$(".sig-ul-inner li").css("visibility", "visible");
	}, 1000);
}


/*-----------------------------------------------------------------------------
 * 복잡한 3d-grapsh의 briefing 역할을 하는 계기판을 위해 중요 키워드 추출
 */
function focus2Node(li){
	g_graph.nodeThreeObjectExtend(node => {
		if(node.word == $(li).html()) {
			let distance = 500;
			let distRatio = 1 + distance/Math.hypot(node.x, node.y, node.z);
			g_graph.cameraPosition(
				{ 
					x: node.x * distRatio, 
					y: node.y * distRatio, 
					z: node.z * distRatio 
				}, // new position
			    node, // lookAt ({ x, y, z })
			    2000  // ms transition duration
			);
			return false;
		}
		else
			return false;
	});
}


/*-----------------------------------------------------------------------------
 * 카메라 위치 초기화
 */
function setCpDefaultIfNothere(){
	let cp = g_graph.cameraPosition();
	if (g_cp.x != cp.x && g_cp.y != cp.y &&	g_cp.z != cp.z){
		g_graph.cameraPosition(
			{x: g_cp.x,	y: g_cp.y, z: g_cp.z },
		    {x: 0, y:0, z:0}, 
		    1000 
		);
	}
}
/*-----------------------------------------------------------------------------
 * 뉴스뛰우기 해보자
 */

//클릭시 창 띄우기 해보자
function searchingnode(node , gData ){
	//로딩 추가
	$('#loading').show();

		var swap = "";

	  	
	  	//이번에는 거리로 해보자.
	  	//저장 리스트 
	  	var distlist = [];
	  	for(var i = 0 ; i<gData['links'].length ; i++){
	  		if(node['word'] == gData['links'][i].source['word'] || node['word'] == gData['links'][i].target['word']){
	  			distlist.push(gData['links'][i])
	  			
	  		}
	  	}
	  	
	  	
	  	
	  	//저장 리스트 이쁘게 배열 하자
	  	for(var i = 0 ; i< distlist.length ; i++){
	  		for(var j = 1 ; j<distlist.length ; j++){
	  			if(distlist[j-1].dist > distlist[j].dist){
	  				swap = distlist[j-1]
	  				distlist[j-1] = distlist[j]
	  				distlist[j] = swap
	  			}
	  		}
	  	}
	  	//저장리스트에서 검색 할 것 만 뺴오자.
	  	
	  	var searchnode = [];
	  	 for(var i = 0 ; i <4 ; i++){
	  		 try{
	  		if(distlist[i].source['word'] != node['word']){
	  			searchnode.push(distlist[i].source['word'])
	  			
	  			 
	  		}else{
	  			searchnode.push(distlist[i].target['word'])
	  			
	  		}
	  		 }catch(e){
	  			 /*console.log(e)*/
	  		 }
	  	} 
	  	
	  	 
	  	 //검색 내용을 넘겨보까? 네이버 api이용 위해서
	  	$.ajax({
	  		method : 'post',
	  		url : 'api/searching',
	  		traditional : true,
	  		dataType : "json",
	 		//contentType: "application/json;charset=utf-8",
	  		data : {
	  			'main' : searchnode,
	  			'keyword' : node['word'],
	  			/*'nowTime' : nowTime*/
	  		},
	  		success : function searchresult(data){
	  			$('#loading').hide();
	  			
	  				
	  			
	  			
	  			
	  			
	  			try{
			  			
			  			  if( !Object.keys(data).length ){
			  				alert("뉴스를 찾을 수 없습니다.")
			  			}else{
			  				$("#newscover").css("display" , "block")
			  			  for(var i=0 ; i < 4 ;i++){
			  			
			  				document.getElementById('infonote' + i).innerHTML = "<div id = 'smalllink'> " 
			  					+ data.clink[i] + "</div>"
			  					+ "<a href = '" + data.originallink[i] + "' target = '_blank' >" +  data.title[i] + "</a><br>"
			  					+ " <div>" + data.cdes[i] + "</div>";
				  			  
			  				}
			  			}
	  				
	  				
	  				}catch(e){
	  				 //console.log(e)
	  				
	  				} 
	  
	  		},
	  			error : function searchresult(request , status , error){
	  			
	  		}
	  	});
	
	
	}


  

	

