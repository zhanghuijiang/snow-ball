<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>Todo</title>
  
  <script data-curl-run="js/todo.js" src="js/plugin/curl/curl.js"></script>
  
  <link rel="stylesheet" href="css/todos.css"/>
   
</head>

<body>

  <div id="todoapp">

    <header>
      <h1>Todos</h1>
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
  

  </body>
</html>

    