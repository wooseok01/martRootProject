$('.second').hide();
$('.third').hide();
$(document).ready(function(){
	var selectList = [];
	$('.first').click(function(){
		var bId = $(this).attr('id');
		bId = bId.substring('first'.length, bId.length);
		
		var second = $('.s'+bId).parent();
		$('.third').hide();
		second.toggle('slow',function(){});
	});
	
	$('.second').click(function(){
		var sId = $(this).attr('id');
		sId = sId.substring('second'.length, sId.length);
		
		var third = $('.t'+sId).parent();
		
		third.toggle('slow', function(){});
	});
	
	$('.third').click(function(){
		
		var select = $(this).attr('class');
		if(select.search('selected') != -1){
			select = select.replace('select','');
			$(this).attr('class',select);
			var id = $(this).attr('id');
			id = id.substring('third'.length, id.length);
			deleteArray(id, selectList);
			
		}else{
			select += ' selected';
			$(this).attr('class',select);
			var id = $(this).attr('id');
			var name = $(this).find('span').html();
			id = id.substring('third'.length, id.length);
			
			insertArray(id, name, selectList);
			
		}
		console.log(selectList);
	});
	
	$('#selectList').click(function(){
		$('#contents').toggle('slow',function(){
			var headerClass = $('#header').attr('class');
			if(headerClass.search('toggle') != -1){
				$('#header').attr('class','');
				$('#header').animate({
					height : '10%'
				});
				
				$('.selectList').remove();
			}else{
				var headerClass = $('#header').attr('class');
				$('#header').attr('class','toggle');
				$('#header').animate({
					height : '100%'
				},1000);
				
				for(var i=0; i<selectList.length; i++){
					var div = $('<div></div>');
					div
						.html(selectList[i].name)
						.attr('id', selectList[i].id)
						.attr('class', 'selectList category');
					
					$('#header').append(div);
				}
			}
			
		});
	});
	
	$('#search').keypress(function(e){
		if(e.which == 13){
			var text = $('#search').val();
			
			if(text.length == 0){
				console.log('xxxx');
				$('.first').show();
				$('.second').hide();
				$('.third').hide();
			}else{
				$('.first').hide();
				$('.second').hide();
				var $third = $('div').find('.third');
				console.log($third.length);
				$.each($third,function(index, value){
					var innerText = $(value).find('span').html()
					if(innerText.search(text) != -1){
						$(value).show();
					}
				});
			}
		}
	});
});


function insertArray(id, name, selectList){
	var index = 0;
	for(index=0; index<selectList.length; index++){
		if(selectList[index].id == id){
			break;
		}
	}
	console.log(index);
	console.log(selectList.length);
	if(index == selectList.length){
		console.log('xxxxx');
		selectList.push({
			id : id,
			name : name
		});
		var input = $('<input></input>').attr({
			type : 'hidden',
			name : 'selected',
			id : 'selected'+id,
			value : name
		});
		
		$('#footer').find('form').append(input);
	}
}

function deleteArray(id, selectList){
	console.log(selectList.length);
	var index = 0;
	for(index=0; index<selectList.length; index++){
		if(selectList[index].id == id){
			selectList.splice(index,1);
			$('#selected'+id).remove();
			break;
		}
	}
}