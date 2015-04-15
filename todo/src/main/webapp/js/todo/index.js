define(function(require) {
	
	var TModel = require('js/mvc/IndexModel');
	var TView = require('js/mvc/IndexView');
	
	var $ = require('jquery');
	
	var model = new TModel();
	model.fetch();//获取数据

	
	$(document).ready(function() {	
		var hello = new TView({
			el: $('.container').first(),//显示区域
			model: model//模版数据
		});
	});

	
	
});