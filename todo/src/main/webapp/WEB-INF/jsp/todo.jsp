<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>TO DO</title>

    <!-- Bootstrap core CSS -->
    <link href="js/plugin/bootstrap-3.3.4-dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="css/dashboard.css" rel="stylesheet">
    <link rel="stylesheet" href="css/todos.css"/>
  
    <script data-curl-run="js/todo.js" src="js/plugin/curl/curl.js"></script>
    
    <script type="text/template" id="item-template">
    <div class="view">
      <input class="toggle" type="checkbox" {{= done ? 'checked="checked"' : '' }} />
      <label>{{- title}}</label>
      <a class="destroy"></a>
    </div>
    <input class="edit" type="text" value="{{- title}}" />
  </script>

  <script type="text/template" id="stats-template">
    {{# if (done) { }}
      <a id="clear-completed">Clear {{= done }} completed {{= done == 1 ? 'item' : 'items' }}</a>
    {{# } }}
      <div class="todo-count"><b>{{= remaining }}</b> {{= remaining == 1 ? 'item' : 'items' }} left</div>

  </script>
    
</head>

  <body>

    <!-- Fixed navbar -->
    <jsp:include page="navbar.jsp"/>

    <div class="container">

		<div class="row">
		        
		       <div class="col-sm-3 col-md-2 sidebar">
		          <ul class="nav nav-sidebar">
		            <li class="active"><a href="#Todos">简介</a></li>
		          </ul>
		        </div>
		        
		        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		        
		          <h1 class="page-header"></h1>
		          
		          <div class="table-responsive">
		          
		             <div id="todoapp">
		
					    <header>
					      <input id="new-todo" type="text" placeholder="What needs to be done?"/>
					      <input id="new-todo-button" type="button" value="add">
					    </header>
					
					    <section id="main">
					      <input id="toggle-all" type="checkbox">
					      <label for="toggle-all">Mark all as complete</label>
					      <ul id="todo-list"></ul>
					    </section>
					
					    <footer>
					      <a id="clear-completed">Clear completed</a>
					      <div id="todo-count"></div>
					    </footer>
					
					  </div>
					
					  <div id="instructions">
					    1.Enter to save a todo.</br>
					    2.Double-click to edit a todo.
					  </div>
		            
		          </div>
		          
		</div>
		        
      </div>
  
    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script type="text/javascript" src="js/plugin/jquery/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" src="js/plugin/bootstrap-3.3.4-dist/js/bootstrap.min.js"></script>
    <script src="js/plugin/bootstrap-3.3.4-dist/assets/js/ie10-viewport-bug-workaround.js"></script>
    
  </body>
</html>
    