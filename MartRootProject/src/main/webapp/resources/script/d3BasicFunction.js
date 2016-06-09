//d3js basic function 
function drawLine(root, x1, y1, x2, y2, strokeWidth, stroke, addClass) {
	var line = root.append('line').attr({
		x1: x1,
		y1: y1,
		x2: x2,
		y2: y2,
		stroke: stroke,
		'class' : addClass
	});
	line.attr('stroke-width',strokeWidth);
	return line;
}

function drawRect(root, x, y, width, height, fill, addClass, name){
	var rect = root.append('rect').attr({
		x: x,
		y: y,
		width: width,
		height: height,
		fill: fill,
		class : addClass,
		name : name
	});
	
	return rect;
}