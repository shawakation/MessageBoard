<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>英才科技-留言板</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet"/>

    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-responsive.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<!-- **********************************************************************************************************************************************************
MAIN CONTENT
*********************************************************************************************************************************************************** -->

<div id="login-page">
    <div class="container">

        <form class="form-login" action="LoginServlet" method="post">
            <h2 class="form-login-heading">欢迎登陆留言板系统</h2>
            <div class="login-wrap">
            	<input type="hidden" name="method" value="loginCheck">
            	
            	<!-- ----------------用户名输入框，名字叫做username，这个名字在Java代码中要用---------------- -->
                <input type="text" name="username" class="form-control" placeholder="用户名" autofocus>
                <br>
                <!-- ----------------密码输入框，名字叫password，名字在Java代码中要用---------------- -->
                <input type="password" name="password" class="form-control" placeholder="密码">
                
                
                <label class="checkbox">
		                <span class="pull-right">
		                    <a data-toggle="modal" href="#">忘记密码？</a>
		                </span>
                </label>
                
                <!-- 在下面这个div中显示登录失败的信息 -->
                <div style="color:red;text-align:center;">
                	${loginTip}
                </div>
                
                
                <button class="btn btn-theme btn-block" type="submit">
                    <i class="fa fa-lock">
                    登陆
                    </i>
                </button>
                
                
                <a class="btn btn-theme btn-block" href="/MessageBoard01/regist.jsp">
                    <i class="fa fa-lock">
                        注册新用户
                    </i>
                </a>
            </div>
        </form>

    </div>
</div>

<!-- js placed at the end of the document so the pages load faster -->
<script src="assets/js/jquery.js"></script>
<script src="assets/js/bootstrap.min.js"></script>

<!--BACKSTRETCH-->
<!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
<script type="text/javascript" src="assets/js/jquery.backstretch.min.js"></script>
<script>
    $.backstretch("assets/img/login.jpg", {speed: 500});
</script>
</body>
</html>
