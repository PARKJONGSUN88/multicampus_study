window.addEventListener("load", function(){
	
	var dataSet = [];
	
	d3.csv("data.csv").then(function(data){
		for(var i=0; i<data.length; i++){
			dataSet.push(data[i].item1);		
		}
		
		d3.select("#myGraph")
		  .selectAll("rect")
		  .data(dataSet)	//데이터 설정
	      .enter()	//데이터 수에 따라 rect 요소 생성
		  .append("rect")
		  .attr("x", 0)
		  .attr("y", function(d, i){
			  return i*30;		  
		  })
		  	.attr("height", "20px")
			.attr("width", function(d, i){		  
				return d+"px";
			})				

    var scale = d3.scaleLinear() //선형 스케일 설정
    				.domain([0, 300]) //원래 데이터 범위
    				.range([0, 300]) //실제 출력 크기
    var axis = d3.axisBottom(scale);     	
			
		//눈금을 설정하고 표시
		d3.select("#myGraph")
			.attr("width", 300)
			.attr("height", 250)
			.append("g") //그룹화함
			.attr("class", "axis") //스타일시트 클래스 설정
			.attr("transform", "translate(10, "+((1+dataSet.length)*25+5) +")")
			.call(axis)			
			
	}) //then() end
	
}); //addEventListener() end
