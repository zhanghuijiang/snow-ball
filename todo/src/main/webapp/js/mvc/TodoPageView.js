define(function(require) {
	
	var Backbone = require('Backbone');
	var $ = require('jquery');
	var _ = require('underscore');
	
 	//设置全局underscore解析方式
	_.templateSettings = {
 		    evaluate    : /\{\{#(.+?)\}\}/g,  
 		    interpolate : /\{\{=(.+?)\}\}/g,  
 		    escape      : /\{\{-(.+?)\}\}/g   
    }
	
	//单行 todo 视图
	var TodoView = Backbone.View.extend({
		tagName:  "tr",//模版 root DOM 元素
		template : _.template($('#item-template').html()),//获取模版
	    render: function() {
	      this.listenTo(this.model, 'all', this.remove);
	      this.$el.html(this.template(this.model.attributes));//将model属性集合填充到模版中，并且写入缓存中的jquery DOM 元素中
	      return this;
	    }
	});
	//todo model
	var Todo = Backbone.Model.extend({});
	
	//todo model 集合
	var TodoList = Backbone.Collection.extend({
		model: Todo,
		pagenum : 0,
		pagesize : 10,
	    comparator: 'order'
	});
	
	//集合变量
	var Todos =  new TodoList();	
	
	//数据模版
	var Page = Backbone.Model.extend({
		url: function (){
			return 'todo/'+Todos.pagenum+'/'+Todos.pagesize;
		}
	});
	
	//model 对象
	var p = new Page();
	
    //页码视图
	var pageView = Backbone.View.extend({
		el: $("#page-info"),
		model:p,
		template : _.template($('#page-template').html()),//获取模版
		initialize: function() {
			this.listenTo(this.model, 'change', this.render);
		},
		events:{
			"click [data-last]":"lastpage",
			"click [data-next]":"nextpage"
		},
		clearModels:function(){
	    	  Todos.each(function(model){
	    		  model.clear();
	    	  })
		},
		lastpage:function(){
	    	var num  = this.model.attributes.number-1; 
	    	Todos.pagenum = num;
			p.fetch();
		},
		nextpage:function(){
	    	var num  = this.model.attributes.number+1; 
	    	Todos.pagenum = num;
			p.fetch();
		},
	    render: function() {
	      this.clearModels();
	      //添加集合数据
	      Todos.add(this.model.attributes.content);
	      this.$el.html(this.template(this.model.attributes));//将model属性集合填充到模版中，并且写入缓存中的jquery DOM 元素中
	      return this;
	    }
	});
	
	p.fetch();//加载数据

	//页面视图对象
	var pageV = new pageView();

	
	return Backbone.View.extend({
		el: $("body"),
	    initialize: function() {
	      this.listenTo(Todos, 'add', this.render);
	    },
	    render: function(todo) {
            var view = new TodoView({model:todo});
		    this.$("#todo-list").append(view.render().el)
	    }
	});
	
	
})