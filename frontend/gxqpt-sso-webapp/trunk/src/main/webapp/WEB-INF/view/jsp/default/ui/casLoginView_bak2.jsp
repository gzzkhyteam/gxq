<!DOCTYPE html>
<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta charset="utf-8" />
<title>登录</title>
<link href="Content/Images/Default.css" rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="Content/Scripts/jquery/jquery.min.js"></script>
<style type="text/css">
html {
	height: 100%;
	background: url(Content/Images/login/lg_bj.jpg) no-repeat center;
	background-size: 100%;
}

.logo {
	background: url(Content/Images/login/lg_04.png) no-repeat center;
	height: 200px;
	padding: 30px 0;
}

.container {
	background: url(Content/Images/login/lg_01.png) no-repeat center;
	height: 320px;
}

.container .inner {
	width: 500px;
	height: 274px;
	margin: 0 auto;
	padding-top: 15px;
}

.container .inner .item {
	text-align: left;
	padding-top: 20px;
	position: relative;
	padding-left: 115px;
}

.container .inner .item input[type="text"],.container .inner .item input[type="password"]
	{
	width: 220px;
	height: 32px;
	line-height: 32px;
	padding: 0 8px 0 40px;
	text-align: left;
	background: #91c5d7;
	border: 1px solid #0789f4;
	border-radius: 4px;
	-moz-box-shadow: 0px 0px 5px #4ab297 !important;
	-webkit-box-shadow: 0px 0px 5px #4ab297 !important;
	box-shadow: 0px 0px 5px #49d9fe !important;
	color: #000;
}

.container .inner .item_code input[type="text"] {
	width: 100px;
	float: left;
	margin-right: 8px;
}

.container .inner .item i.user {
	display: block;
	position: absolute;
	width: 25px;
	height: 25px;
	background: url(Content/Images/login/icouser.png) no-repeat;
	left: 122px;
	top: 24px;
}

.container .inner .item i.pwd {
	display: block;
	position: absolute;
	width: 25px;
	height: 25px;
	background: url(Content/Images/login/icopwd.png) no-repeat;
	left: 122px;
	top: 24px;
}

.container .inner .item i.code {
	display: block;
	position: absolute;
	width: 25px;
	height: 25px;
	background: url(Content/Images/login/icocode.png) no-repeat;
	background-size: 23px;
	left: 122px;
	top: 24px;
}

.container .inner .rememberfield span.l1 {
	float: left;
	cursor: pointer;
	color: #fff;
}

.container .inner .rememberfield span.l2 {
	margin-right: 135px;
	color: #fff;
}

.container .inner .rememberfield span a {
	color: #fff;
}

.container .inner .rememberfield input[type="checkbox"] {
	width: 15px;
	border: none;
	float: left;
}

.container .inner .submitfield {
	text-align: center;
	padding-top: 20px;
}
/*.container .inner .submitfield input { background: #0aa2c6; color: #fff; border: 1px solid #87c2eb; width: 265px; height: 32px; line-height: 32px; box-shadow: 1px 1px 3px #555; cursor: pointer; font-family: 'Microsoft YaHei'; border-radius: 4px; }*/
.container .inner .submitfield input {
	background: url(Content/Images/login/btnlogin.png) no-repeat center;
	width: 265px;
	height: 32px;
	line-height: 32px;
	border: none;
	cursor: pointer;
	border-radius: 3px;
	color: #fff;
	font-family: 'Microsoft YaHei';
}

.btminfo {
	text-align: center;
	color: #fff;
	line-height: 36px;
	padding: 30px 0 0 0;
}
.title{
    color: #68d1ff;
    height: 150px;
    line-height:150px;
    padding: 30px;
    font-size: 36px;
    letter-spacing: 5px;
    font-family: "宋体";
    font-weight: 700;
    text-align: center;
}
</style>
<script type="text/javascript">
	$(function() {
		/*$('.btnsubmit').click(function() {
			var username = $('[name="username"]').val();
			var userpwd = $('[name="userpwd"]').val();
			if (username == '' || userpwd == '') {
				alert('用户名和密码不能为空');
			} else {
				if (username == 'admin' && userpwd == '123456') {
					location.href = "1权力配置/1_04权力清单.html";
				} else {
					alert('用户名或密码错误');
				}
			}
		});*/
		if (top.location != self.location) {
            top.location = self.location;
        }
		
	});
</script>
</head>
<body>
<body>
	<header>
		<h1 class="title" >贵阳市督办督查局用户登录中心</h1>
	</header>
	<!-- <div class="logo"></div> -->
	<div class="container clearfix">
		<form:form  method="post" id="fm1" commandName="${commandName}"
			htmlEscape="true">
			<div class="inner">
				<div class="item">
					<form:errors path="*" id="msg" cssClass="text_con" element="span"
						htmlEscape="false" />
				</div>
				<div class="item">
					<i class="user"></i>
					<form:input cssClass="required" cssErrorClass="error" id="username"
						size="25" tabindex="1" accesskey="${userNameAccessKey}"
						path="username" autocomplete="off" htmlEscape="true" />
				</div>
				<div class="item">
					<i class="pwd"></i>
					<form:password cssClass="required" cssErrorClass="error"
						id="password" size="25" tabindex="2" path="password"
						accesskey="${passwordAccessKey}" htmlEscape="true"
						autocomplete="off" />
				</div>
				<%--<div class="item item_code clearfix">
					<i class="code"></i> <input type="text" name="icocode.png" /><span><img
						src="Content/Images/login/code.png" width="110" /></span>
				</div>--%>
				<div class="submitfield">
					<input type="submit" class="btnsubmit" value="登录" />
				</div>
				<section class="row btn-row">
					<input type="hidden" name="lt" value="${loginTicket}" /> <input
						type="hidden" name="execution" value="${flowExecutionKey}" /> <input
						type="hidden" name="_eventId" value="submit" />
					<%-- <input class="btn-submit" name="submit" accesskey="l" value="<spring:message code="screen.welcome.button.login" />" tabindex="6" type="submit" />
            <input class="btn-reset" name="reset" accesskey="c" value="<spring:message code="screen.welcome.button.clear" />"
                tabindex="7" type="reset" /> --%>
				</section>
			</div>
		</form:form>
	</div>
	<div class="btminfo">
		<div>版权所有：贵阳市督办督察局，技术支持：中科恒运</div>
		<div style="color: red;font-size: 20px;">建议使用Chrome浏览器：<a style="color: #ffff99;" href="/gysfj-sso-webapp/chrome安装程序.rar">点击下载</a></div>
		<%--<div>建议使用浏览器：IE9+/FireFox等浏览器</div>--%>
	</div>
</body>
</html>
