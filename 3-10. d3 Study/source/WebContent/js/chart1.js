window.addEventListener("load", function(){
// 1. 데이터 준비
	var dataSet = [300, 150, 10, 80, 230];
	
	d3.select("#myGraph")
	  .append("rect")
	  .attr("x", 0)
	  .attr("y", 0)
	  .attr("width", dataSet[0])
	  .attr("height", "20px");
	
});
