//Backbone 数据层
define(function(require) {
	var Backbone = require('Backbone');
	//Model 扩展
	return Backbone.Model.extend({
		urlRoot: 'userCount',
		url: function() {
			return this.urlRoot;
		}
	});
});