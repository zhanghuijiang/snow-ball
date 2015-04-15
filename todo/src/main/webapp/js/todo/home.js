define(function(require) {
	var $ = require('jquery');
	
	
	$(document).ready(function() {	
		
		//
		$('.container').on('click','#navbar .nav li a',function(e) {
			$(this).closest('.nav').find('.active').removeClass('active');
			$(this).closest('li').addClass('active');
			//demo
			if($(this).attr('href') == '#Demo' ){
				$(this).closest('.dropdown').find('ul').animate({height: 'toggle', opacity: 'toggle'}, "slow");
			}else{
				$('.dropdown').find('ul').hide();
			}
		});
		
		//添加默认选择效果
		if(window.location.hash == ""){
			$('[href=#Home]').closest('li').addClass('active');
		}else{
			$('[href='+window.location.hash+']').closest('li').addClass('active');
		}
		
	});
	
});