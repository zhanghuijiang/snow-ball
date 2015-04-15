//AMD (Asynchronous Module Definition)规范：异步模块定义
var curl;
(function () {
	
	curl({
		main: 'js/todo/todopage',
		packages: {
			// Your application's package
			hello: { location: '/' },
			// Third-party packages
			curl: { location: 'js/plugin/curl/curl.js'},
			jquery: { location: 'js/plugin/jquery/jquery-1.11.2.min', main: '.' },
			Backbone: { location: 'js/plugin/backbone/backbone-min', main: '.' },
			underscore: { location: 'js/plugin/underscore/underscore-min', main: '.' }
		}
	});
	
}());