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

    <title>Just do it</title>

    <!-- Bootstrap core CSS -->
    <link href="js/plugin/bootstrap-3.3.4/dist/css/bootstrap.min.css" rel="stylesheet">
    <script type="text/javascript" src="js/plugin/jquery/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" src="js/plugin/bootstrap-3.3.4/dist/js/bootstrap.min.js"></script>
    
    <!-- Custom styles for this template -->
    <link href="css/dashboard.css" rel="stylesheet">
    <link rel="stylesheet" href="css/todos.css"/>
  
    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]>
      <script src="js/plugin/bootstrap-3.3.4/assets/js/ie8-responsive-file-warning.js"></script>
    <![endif]-->
      <script src="js/plugin/bootstrap-3.3.4/assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
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
    <nav class="navbar navbar-inverse navbar-fixed-top">
       
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#"></a>
        </div>
        
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li><a href="togo?name=home">Home</a></li>
            <li><a href="togo?name=todo">todo</a></li>
            <li><a href="togo?name=todosearch">search</a></li>
            <li><a href="togo?name=todopage">page</a></li>
          </ul>
         
      </div>
    </nav>

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
			     
			      <input id="new-todo" type="text" placeholder="What needs to be done?">
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
    <script src="js/plugin/bootstrap-3.3.4/assets/js/ie10-viewport-bug-workaround.js"></script>
    
  </body>
</html>
    