<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link rel="stylesheet" type="text/css" href="assets/css/zabuto_calendar.css">
    <link rel="stylesheet" type="text/css" href="assets/js/gritter/css/jquery.gritter.css"/>
    <link rel="stylesheet" type="text/css" href="assets/lineicons/style.css">

    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-responsive.css" rel="stylesheet">

    <script src="assets/js/chart-master/Chart.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<section id="container">
    <!-- **********************************************************************************************************************************************************
    TOP BAR CONTENT & NOTIFICATIONS
    *********************************************************************************************************************************************************** -->
    <!--header start-->
    <header class="header black-bg">
        <div class="sidebar-toggle-box">
            <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
        </div>
        <!--logo start-->
        <a href="index.html" class="logo"><b>简易留言板</b></a>
        <!--logo end-->
        <div class="top-menu">
            <ul class="nav pull-right top-menu">
                <li><a class="logout" href="login.jsp">退出</a></li>
            </ul>
        </div>
    </header>
    <!--header end-->

    <!-- **********************************************************************************************************************************************************
    MAIN SIDEBAR MENU
    *********************************************************************************************************************************************************** -->
    <!--sidebar start-->
    <aside>
        <div id="sidebar" class="nav-collapse ">
            <!-- sidebar menu start-->
            <ul class="sidebar-menu" id="nav-accordion">
                <p class="centered">
                    <a href="profile.html">
                        <img src="assets/img/ui-sam.jpg" class="img-circle" width="60">
                    </a>
                </p>
                <h5 class="centered">${user.username}</h5>

                <li class="mt">
                    <a class="active" href="/MessageBoard01/QueryMessageServlet">
                        <i class="fa fa-dashboard"></i>
                        <span>首页</span>
                    </a>
                </li>

                <li class="sub-menu">
                    <a href="sendMessage.jsp">
                        <i class="fa fa-tasks"></i>
                        <span>发布留言</span>
                    </a>
                </li>
                <li class="sub-menu">
                    <a href="/MessageBoard01/QueryUserServlet">
                        <i class="fa fa-cogs"></i>
                        <span>个人信息维护</span>
                    </a>
                </li>
                <li class="sub-menu">
                    <a href="projectInfo.jsp" >
                        <i class="fa fa-th"></i>
                        <span>关于开发者</span>
                    </a>
                </li>
            </ul>
            <!-- sidebar menu end-->
        </div>
    </aside>
    <!--sidebar end-->
    <!--<div class="copyrights">Collect from <a href="http://www.cssmoban.com/">网页模板</a></div>-->

    <!-- **********************************************************************************************************************************************************
    MAIN CONTENT
    *********************************************************************************************************************************************************** -->
    <!--main content start-->
    <section id="main-content">
        <section class="wrapper">
            <h3><i class="fa fa-angle-right"></i>&nbsp;&nbsp;你收到的留言</h3>

            <div class="row">  <!-- 行开始 -->
            <c:forEach var="item" items="${messageInfoList}">
            	<div class="col-md-12" style="margin:20px 0px;">
                    <div class="content-panel">
                        <h4>
                        <!-- 在此位置显示留言具体信息 -->
                            <i class="fa fa-angle-right"></i>&nbsp;&nbsp;
                            ${item.title}&nbsp;&nbsp;${item.fromUser}&nbsp;&nbsp;发布于：${item.fromdate}
                             <a href="/MessageBoard01/DeleteMessageServlet?id=${item.id}" class="btn btn-round btn-info" style="float: right;height: 25px;padding:0px 12px;margin-right: 5px;">删除</a>
                        </h4>
                        <hr>
                        <div style="padding: 20px;">
                            ${item.messageInfo}
                        </div>
                    </div>
                </div>
            </c:forEach>
           <!-- ----------------- 在下面这个div中显示一条留言   div开始处，将这个div放在循环里，就会显示所有查到的留言----------------- -->
                <!-- <div class="col-md-12" style="margin:20px 0px;">
                    <div class="content-panel">
                        <h4>
                        在此位置显示留言具体信息
                            <i class="fa fa-angle-right"></i>&nbsp;&nbsp;
                            此处显示留言主题&nbsp;&nbsp;留言发出者&nbsp;&nbsp;发布于：2018-09-12 12:22:12
                             <a href="删除留言的Servlet路径" class="btn btn-round btn-info" style="float: right;height: 25px;padding:0px 12px;margin-right: 5px;">删除</a>
                        </h4>
                        <hr>
                        <div style="padding: 20px;">
                            留言内容留言
                        </div>
                    </div>
                </div>  -->              
            <!------------------- div结束处，一条留言结束--------------- -->
            
            </div>   <!-- 行结束 -->
        </section>
    </section>

    <!--main content end-->
</section>

<!-- js placed at the end of the document so the pages load faster -->
<script src="assets/js/jquery.js"></script>
<script src="assets/js/jquery-1.8.3.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="assets/js/jquery.scrollTo.min.js"></script>
<script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>
<script src="assets/js/jquery.sparkline.js"></script>


<!--common script for all pages-->
<script src="assets/js/common-scripts.js"></script>

<script type="text/javascript" src="assets/js/gritter/js/jquery.gritter.js"></script>
<script type="text/javascript" src="assets/js/gritter-conf.js"></script>

<!--script for this page-->
<script src="assets/js/sparkline-chart.js"></script>
<script src="assets/js/zabuto_calendar.js"></script>
<script type="application/javascript">

</script>


</body>
</html>
