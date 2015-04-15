define(function(require) {
	
	var $ = require('jquery');

	var AppView = require('js/mvc/TodoSearchView');
	
	$(document).ready(function() {	
		var app = new AppView();
	});
	
});