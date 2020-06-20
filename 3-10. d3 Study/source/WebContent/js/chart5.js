window.addEventListener("load", function(){
// 1. 데이터 준비
	var dataSet = [300, 150, 10, 80, 230];
	
	d3.select("#myGraph")
	  .selectAll("rect")
	  .data(dataSet)	//데이터 설정
	  .enter()	//데이터 수에 따라 rect 요소 생성
	  .append("rect")
	  .attr("x", 0)
	  .attr("y", function(d, i){
		  return i*30;		  
	  })
	  .attr("width", "0px")
	  .attr("height", "20px")
	  .transition()
	  .delay(function(d, i){
		  return i*500;
	  })
	  .duration(2500)
	  .attr("width", function(d, i){
		  return d+"px";
	  })	 	  
	
	  d3.select("#myGraph")
	  .selectAll("rect")
	  .on("click", function(){
		  d3.select(this)
		  	.style("fill", "cyan")		  	
	  })	
	
	

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
