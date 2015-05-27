<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="../taglibs.jsp"%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="renderer" content="webkit">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>社群汇后台日志</title>
  <link rel="stylesheet" type="text/css" href="${ctx}/css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="${ctx}/css/dashboard.css">

  <script type="text/javascript" src="${ctx}/js/jquery-1.11.2.min.js"></script>
  <script type="text/javascript" src="${ctx}/js/twbs/jquery.twbsPagination.min.js"></script>
  <script type="text/javascript" src="${ctx}/js/bootstrap.js"></script>
  <script type="text/javascript" src="${ctx}/js/record/view.js"></script>
  <script type="text/javascript" src="${ctx}/js/record/model.js"></script>
  <script type="text/javascript" src="${ctx}/js/record/record.js"></script>
 
  
  <script type="text/plain" id="titles-01">
			   <tr>
                  <th>登录人</th>
                  <th>用户ID</th>
                  <th>登录时间</th>
                </tr>
  </script>

  <script type="text/plain" id="titles-02">
			   <tr>
                  <th>登录人</th>
                  <th>用户ID</th>
                  <th>注册时间</th>
                </tr>
  </script>
  
  <script type="text/plain" id="titles-03">
			   <tr>
                  <th>用户命</th>
                  <th>用户ID</th>
                  <th>群发时间</th>
                  <th>数量</th>
                  <th>短信内容</th>
               </tr>
  </script>
  
 <script type="text/plain" id="titles-04">
			   <tr>
                  <th>用户命</th>
                  <th>用户ID</th>
                  <th>群发时间</th>
                  <th>数量</th>
                  <th>邮件内容</th>
               </tr>
  </script>
  
  
  </head>
  
   <body>
    
   <nav class="navbar navbar-inverse navbar-fixed-top">
   
      <div class="container-fluid">
      
        <div class="navbar-header">
          <a class="navbar-brand" href="#">社群汇后台日志</a>
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        </div>
        
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
           <li data-index='0'><a href="${ctx}/record/login#login">登录日志</a></li>
           <li data-index='1'><a href="${ctx}/record/register#register">注册日志</a></li>
           <li data-index='2'><a href="${ctx}/record/sms#sms">短信日志</a></li>
           <li data-index='3'><a href="${ctx}/record/email#email">邮件日志</a></li>
          </ul>
        </div>
        
      </div>
      
   </nav>
       
    <div class="container-fluid">
    
      <div class="row">
      
       <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li data-index='0'><a href="${ctx}/record/login#login">登录日志</a></li>
            <li data-index='1'><a href="${ctx}/record/register#register">注册日志</a></li>
            <li data-index='2'><a href="${ctx}/record/sms#sms">短信日志</a></li>
            <li data-index='3'><a href="${ctx}/record/email#email">邮件日志</a></li>
          </ul>
        </div>
        
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          
          <div class="table-responsive" style="display:none">
          
            <table class="table table-striped table-bordered table-condensed">
            
              <thead id="page-titles"></thead>
              
              <tbody id="page-content"></tbody>
              
            </table>
    
          </div>
          
           <div class="text-center">
		       <ul id="pagination-footer" class="pagination-sm"></ul>
		   </div>
		    
        </div>
        
      </div>
      
    </div>
    
   </body>
   
</html>