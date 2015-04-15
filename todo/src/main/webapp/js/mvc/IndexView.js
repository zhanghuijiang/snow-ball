//Backbone 显示层
define(function(require) {
	
	var Backbone = require('Backbone');
	var $ = require('jquery');
	var _ = require('underscore');
	
	return Backbone.View.extend({
		initialize: function() {
			//underscore 模版取值方式 将 页面的 <%=%> 更换为 {{}}
			_.templateSettings = {interpolate: /\{\{(.+?)\}\}/g};// interpolate SYN insert 
			this.template = _.template($('#form-signin').html());//underscore 处理模版
			
			//Tell an object to listen to a particular event on an other object
			//object.listenTo(other, event, callback) 
			this.listenTo(this.model, 'change', this.render);
          
		},
		render: function(){
			//显示数据
			this.$el.html(this.template(this.model.attributes));
		},
		events:{
			"submit form":"submit"
		},
		submit:function(){
		    var data = this.$el.find('form').serialize();
			$.ajax({
		        url:'login',
		        data:data,
		        type: "post"
		    }).done(function(response){
		    	if(response.code == 200){
		    		window.location.href = "/todo/home";
		    	}else{
		    		alert(response.code);
		    	}
		    }).fail(function(response){
		    	alert("error:"+response.status);
		    });
			return false;
		}
	});
})