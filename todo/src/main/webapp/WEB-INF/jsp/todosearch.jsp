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

    <title>TODO-SEARCH</title>

    <!-- Bootstrap core CSS -->
    <link href="js/plugin/bootstrap-3.3.4-dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="css/dashboard.css" rel="stylesheet">
    
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

    <!-- Fixed navbar -->
    <jsp:include page="navbar.jsp"/>

    <div class="container-fluid">
      
      <div class="row">
        
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li class="active"><a href="#Todos">简介</a></li>
          </ul>
        </div>
        
         
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
        
          <div class="row placeholders" id="page-info">
               <input id="todo-title-button" type="button" style="width:30%" value="F5">
          </div>
          
          <h2 class="sub-header">
            <input id="todo-title" type="text" class="form-control" placeholder="Search Title...">
          </h2>
          
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
    
    <script type="text/javascript" src="js/plugin/jquery/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" src="js/plugin/bootstrap-3.3.4-dist/js/bootstrap.min.js"></script>
    
  </body>
</html>
