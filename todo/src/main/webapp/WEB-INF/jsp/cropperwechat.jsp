<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="A complete example of Cropper.">
  <meta name="keywords" content="HTML, CSS, JS, JavaScript, jQuery, PHP, image cropping, web development">
  <meta name="author" content="Fengyuan Chen">
  <title>Crop Avatar -WeChat</title>
  
  <link href="js/plugin/bootstrap-3.3.4-dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="js/plugin/cropper/dist/css/cropper.min.css" rel="stylesheet">
  <link href="css/cropper-wechat.css" rel="stylesheet">

  <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->

</head>

<script type="text/javascript"></script>
<body>

    <!-- Fixed navbar -->
    <jsp:include page="navbar.jsp"/>
    
    
   <div class="container-fluid" id="crop-avatar">
     
    <div class="avatar-view" title="Change the avatar">
      <img src="images/picture.jpg" alt="Avatar">
    </div>
               
    <!-- Cropping-->
    <div id="avatar-modal">
    
          <form class="avatar-form" action="upload" enctype="multipart/form-data" method="post">
          
		  <!-- Upload image and data -->
		  <div class="avatar-upload">
		    <input class="avatar-src" name="avatar_src" type="hidden">
		    <input class="avatar-data" name="avatar_data" type="hidden">
		    <input class="avatar-input" style="display:none"  id="avatarInput" name="avatar_file" type="file">
		  </div>
    
          <!-- Crop  -->
          <div class="avatar-wrapper freeze"></div>
            
          </form>
    </div>

    <div class="loading" aria-label="Loading" role="img" tabindex="-1"></div>
    
    <div class="bottomNav">
           <span class="cancel"><a>取消</a></span>
           <span class="done"><a>选取</a></span>
    </div>
          
    
   </div>
    
   
   <script type="text/javascript" src="js/plugin/jquery/jquery-1.11.2.min.js"></script>
   <script type="text/javascript" src="js/plugin/bootstrap-3.3.4-dist/js/bootstrap.min.js"></script>
   <script type="text/javascript" src="js/plugin/cropper/dist/js/cropper.min.js"></script>
   <script type="text/javascript" src="js/cropper-wechat.js"></script>
    
</body>
</html>

    