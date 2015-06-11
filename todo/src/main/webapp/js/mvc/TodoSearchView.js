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
	
	//数据  model
	var Todo = Backbone.Model.extend({});
	
	//数据视图
	var TodoView = Backbone.View.extend({
		tagName:  "tr",//模版 root DOM 元素
		template : _.template($('#item-template').html()),//获取模版
	    render: function() {
	      this.listenTo(this.model, 'all', this.remove);
	      this.$el.html(this.template(this.model.attributes));//将model属性集合填充到模版中，并且写入缓存中的jquery DOM 元素中
	      return this;
	    }
	});
	
	//集合
	var TodoList = Backbone.Collection.extend({
		model: Todo,//数据模版
		urlRoot: 'todo',//访问路径
		searchTitle:'',
		url: function() {
			return this.urlRoot+'?name='+this.searchTitle;
		},
	    initialize: function() {
	    	this.on("reset",function(render){})
	    },
	    comparator: 'order'
	});
	var Todos = new TodoList();
	
	 
	return Backbone.View.extend({
		el: $("body"),//视图页面绑定
	    initialize: function() {
	      this.input = this.$("#todo-title");//内容输入框
	      this.listenTo(Todos, 'add', this.render);
	      Todos.fetch();//刷新视图
	    },
	    render: function(todo) {
            var view = new TodoView({model:todo});
		    this.$("#todo-list").append(view.render().el)
	    },
	    events: {
		      "keypress #todo-title":  "searchOnEnter",
		      "click #todo-title-button":  "searchOnButton"
		},
		clearModels:function(){
    	  Todos.each(function(model){
    		  model.clear();
    	  })
		},
	    reload:function(){
	    	var render = this.render;
	    	Todos.searchTitle = this.input.val();
	    	Todos.fetch({
    		  reset : true,
    		  success: function(collection,resp,options){
    			  collection.each(function(model){
    				  render(model);
    	    	  })
    		  }
	    	})
	    },
		searchOnEnter: function(e) {
		      if (e.keyCode != 13) return;
		      var musketeers  = Todos.where({title: this.input.val()});
		      if(musketeers){
		    	  this.clearModels();
		    	  this.reload();
		      }
		},
		searchOnButton: function(e) {
		      var musketeers  = Todos.where({title: this.input.val()});
		      if(musketeers){
		    	  this.clearModels();
		    	  this.reload();
		      }
		}
	});
	
	
	
})