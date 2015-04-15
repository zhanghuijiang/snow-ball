define(function(require) {
	
	var Backbone = require('Backbone');
	var $ = require('jquery');
	var _ = require('underscore');
	
 	//设置全局underscore解析方式
	_.templateSettings = {
 		    evaluate    : /\{\{#(.+?)\}\}/g,  // 正则表达式来匹配您想要直接一次性执行程序而不需要任何返回值的语句,执行if语句
 		    interpolate : /\{\{=(.+?)\}\}/g,  //插入变量的
 		    escape      : /\{\{-(.+?)\}\}/g    //转义
    }
 	 
	var Todo = Backbone.Model.extend({
	    // Default attributes for the todo item.
		//在创建一个模型实例时，任何没有指定值的属性都会被设置成默认值
	    defaults: function() {
	      return {
	        title: "empty todo...",
	        order: Todos.nextOrder(),
	        done: false
	      };
	    },
	    toggle: function() {//修改model数据对象中的done的数值
	      this.save({done: !this.get("done")}); 
	    }
	});
	
	var TodoList = Backbone.Collection.extend({
		model: Todo,//数据模版
		urlRoot: 'todo',//访问路径
		url: function() {
			return this.urlRoot;
		},
	    done: function() {//条件过滤集合(Collection)中已经完成的todo
	      return this.where({done: true});//where(todo 数据对象{"id":"","order":1,"done":true,"title":"1"})
	    },
	    remaining: function() {//条件过滤集合(Collection)中未完成的todo
	      return this.where({done: false});//where(todo 数据对象{"id":"","order":1,"done":true,"title":"1"})
	    },
	    nextOrder: function() {//获取下一个排序值
	      if (!this.length) return 1;
	      return this.last().get('order') + 1;
	    },
	    comparator: 'order'//函数会实时排序,集合中的模型会按照指定的算法进行排序。换言之，被增加模型，会被插入 collection.models中适合的位置
	});
	
	var Todos = new TodoList();
	
	
	var TodoView = Backbone.View.extend({
	    tagName:  "li",//视图根元素
	    template: _.template($('#item-template').html()),//按目标模版访问实例数据
	    events: { //给指定的dom绑定事件，委托事件,events{'eventType selector' : 'callback'};
	      "click .toggle"   : "toggleDone",
	      "dblclick .view"  : "edit",
	      "click a.destroy" : "clear",
	      "keypress .edit"  : "updateOnEnter",
	      "blur .edit"      : "close"
	    },
	    initialize: function() {
	      this.listenTo(this.model, 'change', this.render);//监听model的改变事件
	      this.listenTo(this.model, 'destroy', this.remove);//监听model的销毁时间
	    },
	    render: function() {
	      this.$el.html(this.template(this.model.toJSON()));//jquery 缓存方式，将数据添加到显示视图中
	      this.$el.toggleClass('done', this.model.get('done'));//toggleClass('要切换的class名','bool值');
	      this.input = this.$('.edit');
	      return this;
	    },
	    toggleDone: function() {//修改任务状态
	      this.model.toggle();
	    },
	    edit: function() {//编辑
	      this.$el.addClass("editing");
	      this.input.focus();
	    },
	    close: function() {//关闭修改
	      var value = this.input.val();
	      if (!value) {
	        this.clear();
	      } else {
	        this.model.save({title: value});
	        this.$el.removeClass("editing");
	      }
	    },
	    updateOnEnter: function(e) {//保存
	      if (e.keyCode == 13) this.close();
	    },
	    clear: function() {//删除
	      this.model.destroy();
	    }

	  });
	
	
	return Backbone.View.extend({
		    el: $("#todoapp"),// tagName, className, id and attributes properties ，视图绑定DOM显示
		    statsTemplate : _.template($('#stats-template').html()),//按目标模版访问实例数据
		    events: {
		      "keypress #new-todo":  "createOnEnter",//回车
		      "click #clear-completed": "clearCompleted",//单击
		      "click #toggle-all": "toggleAllComplete"
		    },
		    initialize: function() {
		    	
		      this.input = this.$("#new-todo");//内容输入框
		      this.allCheckbox = this.$("#toggle-all")[0];//选择框
		      
		      this.listenTo(Todos, 'add', this.addOne);//添加新model
		      this.listenTo(Todos, 'reset', this.addAll);//集合内容被替换
		      this.listenTo(Todos, 'all', this.render);//监听全部事件,事件后执行

		      this.footer = this.$('footer');//页脚
		      this.main = $('#main');//todo 内容展示区域

		      Todos.fetch();//刷新视图
		    },
		    render: function() {
		      var done = Todos.done().length;//已完成任务数量
		      var remaining = Todos.remaining().length;//未完成任务数量
		      if (Todos.length) {//修改页脚
		        this.main.show();
		        this.footer.show();
		        this.footer.html(this.statsTemplate({done:done, remaining: remaining}));
		      } else {
		        this.main.hide();
		        this.footer.hide();
		      }
		      this.allCheckbox.checked = !remaining;//选择全部完成
		    },
		    addOne: function(todo) {//新任务
		      var view = new TodoView({model: todo});
		      this.$("#todo-list").append(view.render().el);
		    },
		    addAll: function() {
		      Todos.each(this.addOne, this);
		    },
		    createOnEnter: function(e) {
		      if (e.keyCode != 13) return;
		      if (!this.input.val()) return;
              //Convenience to create a new instance of a model within a collection
		      Todos.create({title: this.input.val()});
		      this.input.val('');
		    },
		    clearCompleted: function() {
		      _.invoke(Todos.done(), 'destroy');
		      return false;
		    },
		    toggleAllComplete: function () {
		      var done = this.allCheckbox.checked;
		      Todos.each(function (todo) { todo.save({'done': done}); });
		    }

    });
	 
})