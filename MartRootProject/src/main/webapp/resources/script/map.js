$('#list').hide();
var init = init();
var maxWidth = $('#maxWidth').val()*1;
var maxHeight = $('#maxHeight').val()*1;
var index = 0;

var axis = drawAxis(init, maxWidth, maxHeight);
$(document).ready(function(){
	var count = 0;
	if($('#floor').val() == 2){
		$.ajax({
			url : './getTotalCount',
			dataType : 'json',
			success : function(data){
				$('#totalCount').val(data[0]);
			},
			error : function(err){
				alert(err.message);
			}
		});
		
		$.ajax({
			url : './getSecondFloor',
			dataType : 'json',
			success : function(data){
				drawProduct(data, init, axis);
				$('#secondF').attr('class','selected');
				$.ajax({
					url : './getFloorPath',
					data : {
						floor : 2
					},
					dataType : 'json',
					success : function(data){
						count = data.length-1;
						var className = $('.p'+data[index]).attr('class'); 
						className +=' current';
						$('.p'+data[index]).attr('class',className);
						$('#description').html($('.p'+data[index]).attr('name')+'<br>남은 물품 : '+$('#totalCount').val());
						
						$('.current').modernBlink({
							duration : 1000,
							iterationCount : 'infinite',
							auto : true
						});
						
						for(var i=1; i<data.length; i++){
							var div = $('<div></div>')
								.attr('class','product')
								.html($('.p'+data[i]).attr('name')).hide();
							$('#content').append(div);
						}
						
						$('#nextBtn').click(function(){
							if(index < data.length-1){
								console.log(index);
								$('.current').modernBlink('stop');
								className = className.replace(' current','');
								$('.p'+data[index]).attr('class',className).attr('fill','rgba(69,158,249,0.5)');
								index++;
								className = $('.p'+data[index]).attr('class'); 
								className +=' current';
								$('.p'+data[index]).attr('class',className).attr('fill','rgb(252,76,253)');
								$('.current').modernBlink('start');
								var count = $('#totalCount').val();
								count -= 1;
								$('#totalCount').val(count);
								$('#description').html($('.p'+data[index]).attr('name')+'<br>남은 물품 : '+$('#totalCount').val());
							}else if(index == data.length-1){
								alert('2층 쇼핑 종료! 다음을 누르면 다음층으로 넘어갑니다.');
								location.href = './martRoot?floor=3&totalCount='+$('#totalCount').val();
							}
							
							 var height = $('.p'+data[index]).attr('y');
							$('html,body').animate({scrollTop:height - 400},400);
						});

						
						$('#prevBtn').click(function(){
							if(index > 0){
								console.log(index);
								$('.current').modernBlink('stop');
								className = className.replace(' current','');
								$('.p'+data[index]).attr('class',className).attr('fill','rgba(69,158,249,0.5)');
								index--;
								className = $('.p'+data[index]).attr('class'); 
								className +=' current';
								$('.p'+data[index]).attr('class',className).attr('fill','rgb(252,76,253)');
								$('.current').modernBlink('start');
								
								var count = $('#totalCount').val()*1;
								count += 1;
								$('#totalCount').val(count);
								$('#description').html($('.p'+data[index]).attr('name')+'<br>남은 물품 : '+$('#totalCount').val());
							}else if(index == 0){
								alert('가장 초기의 상태입니다. 더 뒤로 갈 수 없습니다.');
							}

							var height = $('.p'+data[index]).attr('y')*1;
							$('html,body').animate({scrollTop:height - 400},400);
						});
						var height = $('.p'+data[0]).attr('y');
						$('html,body').animate({scrollTop:height - 400},400);
						
						$('#description').click(function(){
							$('html,body').animate({scrollTop:$('.p'+data[index]).attr('y')-400});
						});
						
					},
					error : function(err){
						alert(err.message);
					}
				});
			},
			error : function(err){
				alert(err.message);
			}
		});
	}else if($('#floor').val() == 3){
		$.ajax({
			url : './getThirdFloor',
			dataType : 'json',
			success : function(data){
				console.log(data);
				drawProduct(data, init, axis);
				$('#thirdF').attr('class','selected');
				$.ajax({
					url : './getFloorPath',
					data : {
						floor : 3
					},
					dataType : 'json',
					success : function(data){
						console.log(data);
						var className = $('.p'+data[index]).attr('class'); 
						className +=' current';
						$('.p'+data[index]).attr('class',className);
						
						$('.current').modernBlink({
							duration : 1000,
							iterationCount : 'infinite',
							auto : true
						});
						
						for(var i=1; i<data.length; i++){
							var div = $('<div></div>')
								.attr('class','product')
								.html($('.p'+data[i]).attr('name')).hide();
							$('#content').append(div);
						}
						$('#description').html($('.p'+data[index]).attr('name')+'<br>남은 물품 : '+$('#totalCount').val());
						$('#nextBtn').click(function(){
							if(index < data.length-1){
								$('.current').modernBlink('stop');
								className = className.replace(' current','');
								$('.p'+data[index]).attr('class',className).attr('fill','rgba(69,158,249,0.5)');
								index++;
								className = $('.p'+data[index]).attr('class'); 
								className +=' current';
								$('.p'+data[index]).attr('class',className).attr('fill','rgb(252,76,253)');
								$('.current').modernBlink('start');
								var count = $('#totalCount').val();
								count -= 1;
								$('#totalCount').val(count);
								$('#description').html($('.p'+data[index]).attr('name')+'<br>남은 물품 : '+$('#totalCount').val());
							}else if(index == data.length-1){
								alert('쇼핑이 모두 끝났습니다. 다음을 누르시면 초기 페이지로 넘어갑니다.');
								location.href = './';
							}
							var height = $('.p'+data[index]).attr('y')*1;
							var windowHeight = $(window).height();
							$('html,body').animate({scrollTop:height - 400},400);
						});
						
						$('#prevBtn').click(function(){
							if(index > 0){
								
								$('.current').modernBlink('stop');
								className = className.replace(' current','');
								$('.p'+data[index]).attr('class',className).attr('fill','rgba(69,158,249,0.5)');
								index--;
								className = $('.p'+data[index]).attr('class'); 
								className +=' current';
								$('.p'+data[index]).attr('class',className).attr('fill','rgb(252,76,253)');
								$('.current').modernBlink('start');
								var count = $('#totalCount').val()*1;
								count += 1;
								$('#totalCount').val(count);
								$('#description').html($('.p'+data[index]).attr('name')+'<br>남은 물품 : '+$('#totalCount').val());
							}else if(index == 0){
								alert('2층으로 돌아갑니다.');
								location.href = './martRoot?floor=2';
							}
							var height = $('.p'+data[index]).attr('y')*1;
							$('html,body').animate({scrollTop:height - 400},400);
						});
						var height = $('.p'+data[0]).attr('y');
						$('html,body').animate({scrollTop:height - 400},400);
						
						$('#description').click(function(){
							$('html,body').animate({scrollTop:$('.p'+data[index]).attr('y')-400});
						});
						
						
					},
					error : function(err){
						alert(err.message);
					}
				});
			},
			error : function(err){
				alert(err.message);
			}
		});
	}

	$('#secondF').click(function(){
		location.href='./martRoot?floor=2';
	});

	$('#thirdF').click(function(){
		location.href='./martRoot?floor=3&totalCount='+($('#totalCount').val()*1-count);
	});
	
	$('#showList').click(function(){
		$('svg').toggle('slow',function(){});
		$('.product').toggle('slow',function(){
			if($('svg').css('display') == 'none'){
				$('body,html').css({
					height : '100%'
				});
			}else{
				$('body,html').css({
					height : '150%'
				});
			}
		});
	});
});















//user define
function init(){
	var padding = 10;
	var width = $('#content').width()*1;
	var height = $('#content').height()*1;
	var graphW = width-(padding*2);
	var graphH = height - (padding*2);
	
	var svg = 
		d3.select('#content').append('svg').attr({
			width : width,
			height : height
		});
	
	return {
		svg : svg,
		width : width,
		height : height,
		graphW : graphW,
		graphH : graphH,
		padding : padding
	}
}

function drawAxis(init, maxWidth, maxHeight){
	var xInterval = init.width/maxWidth;
	var yInterval = (init.height-220)/maxHeight;
	var y = [];
	var x = [];
	
	for(var i=0; i<maxWidth; i++){x.push(xInterval*i);}
	for(var i=0; i<maxHeight; i++){y.push(yInterval*i+100);}
	
	return {
		x : x,
		y : y,
		xInterval : xInterval,
		yInterval : yInterval
	}
}

function drawProduct(data, init, axis){
	var color; 

	for(var i=0; i<data.length; i++){
		if(data[i].fProduct =='입구'){
			color = 'rgb(252,76,253)';
		}else{
			color = 'rgba(69,158,249,0.5)';
		}
		drawRect(init.svg, 
				axis.x[data[i].fX-1], axis.y[data[i].fY-1], 
				axis.xInterval*data[i].fWidth, axis.yInterval*data[i].fHeight, 
				color, 'p'+data[i].fId, data[i].fProduct);
	}
}