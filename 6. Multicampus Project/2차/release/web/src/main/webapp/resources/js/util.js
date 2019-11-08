/**
 * util.js
 */

HashMap = function(){
	this.map = new Array();
}

HashMap.prototype = {
	put: function(key, value){
		this.map[key] = value;
	},
	get: function(key){
		return this.map[key];
	},
	length: function(){
		return Object.keys(this.map).length
	},
	keys: function(){
		return Object.keys(this.map)
	}
}


function hexToRgb(hex) {
	// Expand shorthand form (e.g. "03F") to full form (e.g. "0033FF")
	var shorthandRegex = /^#?([a-f\d])([a-f\d])([a-f\d])$/i;
	hex = hex.replace(shorthandRegex, function(m, r, g, b) {
		return r + r + g + g + b + b;
	});
	
	var result = /^#?([a-f\d]{2})([a-f\d]{2})([a-f\d]{2})$/i.exec(hex);
	
	return result ? {
		r: parseInt(result[1], 16),
		g: parseInt(result[2], 16),
		b: parseInt(result[3], 16)
	} : null;
}


function zeroPad(nr, base){
  var  len = (String(base).length - String(nr).length)+1;
  return len > 0? new Array(len).join('0')+nr : nr;
}


function yymmddFormat(yymmdd){
	return "20" + yymmdd.slice(0, 2) + "." + yymmdd.slice(2, 4) + "." 
		+ yymmdd.slice(4, 6);
}


function hhmmFormat(hhmm){
	return zeroPad(Math.floor(parseInt(hhmm)/100), 10) + ":" 
		+ zeroPad(parseInt(hhmm)%100, 10);
}
