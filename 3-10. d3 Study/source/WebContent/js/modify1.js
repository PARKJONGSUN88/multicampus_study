window.addEventListener("load", function(){

var barElements;	
	
	d3.selectAll("button").on("click", function(){
		var csvFile = this.getAttribute("data-src");
		var dataSet = [];
		
		d3.csv(csvFile).then(function(data){		
			for(var i=0; i<data.length; i++){			
				dataSet.push(data[i]["상품A"]);
			}
			
			barElements = d3.select("#myGraph")
				.selectAll("rect")
				.data(dataSet)	//데이터 설정
			barElements.enter()		 
				.append("rect")
				.attr("class", "bar")
				.attr("width", function(d, i){
					return d;		  
				})
				.attr("height", 20)
				.attr("x", 0)		  	
				.attr("y", function(d, i){		  
					return i*25;
			    })				
				.attr("width", function(d, i){
					return d;
				})
					
				barElements
					.exit()
					.remove()
		});
		
	})
	
	
});