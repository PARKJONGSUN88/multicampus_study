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
	});
	
	d3.select("#updateButton")
	  .on("click", function(){	  
		  for(var i=0;i<dataSet.length;i++){
			  dataSet[i] = Math.floor(Math.random()*320);
		  }
		  d3.select("#myGraph")
		    .selectAll("rect")
		    .data(dataSet)
		    .transition() //변환
		    .attr("width", function(d, i){
		    	return d+"px";
		    });	 
	});
	
	
	
});
