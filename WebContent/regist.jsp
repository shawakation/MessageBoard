<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
        <form class="form-login" action="RegistUserServlet" method="post">
            <h2 class="form-login-heading">新用户注册</h2>
            <div class="login-wrap">
                <div style="color:red;width:100%;text-align:center;">
                	${info} <!-- 提取RegistUserServlet中的info值 -->
                </div>
   				<input type="hidden" name="method" value="registUser">
                <input type="text" name="username" class="form-control" placeholder="用户名" autofocus><br>
               
                <input type="password" name="password" class="form-control" placeholder="密码"><br>
                <input type="text" name="name" class="form-control" placeholder="真实姓名"><br>
                <input type="text" name="age" class="form-control" placeholder="年龄">
                <div class="radio">
                    &nbsp;&nbsp;&nbsp;&nbsp;性别&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <label>
                        <input type="radio" name="sex" id="optionsRadios1" value="男" checked> 男
                    </label>
                    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <label>
                        <input type="radio" name="sex" id="optionsRadios2" value="女"> 女
                    </label>
                </div>
                <input type="text" name="school" class="form-control" placeholder="就读学校"><br>
                <input type="text" name="email" class="form-control" placeholder="Email"><br>
                <input type="text" name="telephone" class="form-control" placeholder="联系电话"><br>

                <button class="btn btn-theme btn-block" href="index.html" type="submit">
                    <i class="fa fa-lock">
                        	注册
                    </i>
                </button>
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
