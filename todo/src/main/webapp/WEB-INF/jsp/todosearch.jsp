<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    

    <title>Todo Search</title>

    <!-- Bootstrap core CSS -->
    <link href="js/plugin/bootstrap-3.3.4/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/dashboard.css" rel="stylesheet">

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
    
    <script data-curl-run="js/todosearch.js" src="js/plugin/curl/curl.js"></script>
    
    <script type="text/template" id="item-template">
                  <td>{{= order}}</td>
                  <td>{{= title}}</td>
                  {{# if (done) { }}
                     <td><font color="red">{{= done}}</font></td>
                  {{# } }}
                  {{# if (!done) { }}
                     <td>{{= done}}</td>
                  {{# } }}
    </script>
  
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Snow ball</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
           <li><a href="#Default">Default</a></li>
          </ul>
          <div class="navbar-form navbar-right">
            <input id="todo-title" type="text" class="form-control" placeholder="Search Title...">
          </div>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      
      <div class="row">
        
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="#Todos">Todos</a></li>
          </ul>
        </div>
        
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        
          <div class="table-responsive">
          
            <table class="table table-striped">
            
              <thead>
                <tr>
                  <th>order</th>
                  <th>title</th>
                  <th>done</th>
                </tr>
              </thead>
              
              <tbody id="todo-list">
               
              </tbody>
              
            </table>
            
          </div>
          
        </div>
        
      </div>
      
    </div>
    
  </body>
</html>