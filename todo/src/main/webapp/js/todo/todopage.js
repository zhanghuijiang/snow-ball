define(function(require) {
	
	var $ = require('jquery');

	var AppView = require('js/mvc/TodoPageView');
	
	$(document).ready(function() {	
		var app = new AppView();
	});
	
});