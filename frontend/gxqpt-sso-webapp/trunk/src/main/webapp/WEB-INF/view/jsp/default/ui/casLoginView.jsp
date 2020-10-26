<%@page import="com.hengyunsoft.sso.authentication.QueryDatabaseAuthenticationAndLogHandler"%>
<%@ page pageEncoding="UTF-8"%>
<%-- <%--<%@ page contentType="text/html; charset=UTF-8"%>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%request.setAttribute("sourcePath", "gxqsource"); %>
<%request.setAttribute("basePath", "${pageContext.request.contextPath}"); %>
<% String userName = request.getParameter("username");
   String salt = QueryDatabaseAuthenticationAndLogHandler.generatorLoginRandomSalt(request);
   if(userName == null){
	   userName = "";
   }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>高新区一体化平台统一登录</title>
    <link rel="stylesheet" type="text/css" href="${sourcePath }/plugIns/bg_animation/css/style.css"/>
	<style>
		body{
			height: 100%;
			overflow: hidden;
			background: #eee url("${sourcePath }/images/login/banner.jpg") no-repeat center top;
			background-size: 100%;
		}
        .logo{
            text-align: center;
            padding-top: 50px;
        }
        .logo img{
            width: 45vw;
        }
		canvas{z-index:-1;position:absolute;}
		.admin_login .djg {
			margin-top: 22px;
			color: #f8f8f8;
		}
		.admin_login .djg2 {
			margin-top: 0px;
			color: #00ffff;
		}
		
		
		#fm1 input[type="text"], #fm1 input[type="password"] {
		    -webkit-box-shadow: 0 0 0px 1000px #fff inset;
		    -moz-box-shadow: 0 0 0px 1000px #fff inset;/*firefox*/
		    box-shadow: 0 0 0px 1000px #fff inset;/*opera或ie9*/
		    -webkit-text-fill-color: #999;
		}
		
	</style>
</head>
<body>
<div class="logo">
	<img src="${sourcePath }/images/login/logo.png" alt="">
</div>
<dl class="admin_login">
	<%--<dt>
		<strong>“数聚高新”一体化基础系统平台</strong>
		<em>The number of poly tech integration system platform</em>
	</dt>--%>
	<form:form method="post" id="fm1" commandName="${commandName}"
			htmlEscape="true">
		<dd class="user_icon">
			<input autocomplete="off" type="text" value="<%=userName.replace("<", "").replace(">", "").replace("\"", "") %>" name="username" placeholder="账号" id="userNameId" onkeydown="keyDown(event)" class="login_txtbx"/>
		</dd>
		<dd class="pwd_icon">
			<input autocomplete="off" type="password" placeholder="密码" id="passwordId" onkeydown="keyDown(event)" class="login_txtbx"/>
			<input  type="hidden" id="hengyunpass" name="password"/>
		</dd>
		<dd class="val_icon">
			<div class="checkcode">
				<input type="text" name="qrcode" id="J_codetext" placeholder="验证码" onkeydown="keyDown(event)" maxlength="4" class="login_txtbx">
				<canvas class="J_codeimg" id="myCanvas" onclick="getCode('${pageContext.request.contextPath}')">对不起，您的浏览器不支持canvas，请下载最新版浏览器!</canvas>
			</div>
			<%--<input type="button" value="切换验证码" class="ver_btn" onClick="validate();">--%>
		</dd>
		<dd>
			<input type="button" value="立即登录" class="submit_btn"/>
		</dd>
		<section class="row btn-row">
				<input type="hidden" name="lt" value="${loginTicket}" /> 
				<input type="hidden" name="execution" value="${flowExecutionKey}" />
				<input type="hidden" name="_eventId" value="submit" />
		</section>
		<div id="check-msg" class="errors first-errors" style="color:red;"></div>
		<form:errors path="*" id="msg" cssClass="errors" style="color:red" element="div" htmlEscape="false" />
	</form:form>

</dl>
    
    <script src="${sourcePath }/plugIns/jquery/jquery.min.js"></script>
    <%--<script src="${sourcePath }/plugIns/bg_animation/js/Particleground.js"></script>--%>
    <script src="${sourcePath }/plugIns/bg_animation/js/verificationNumbers.js"></script>
    <script src="${sourcePath }/js/hengyun-pass.js"></script>
    <script type="text/javascript">
        // 置顶
        if (window.top!=window.self){
            top.location.href = "/gxqpt-sso-webapp/login";
        }
    	$(function (){
            //粒子背景特效
           /* $('body').particleground({
                dotColor: '#00ccff',
                lineColor: '#00ccff'
            });*/

			//当前上下文根
			var  curContext = "${pageContext.request.contextPath}";

            //获取验证码
			getCode(curContext);

            //提交登录
            $(".submit_btn").click(function (){
                //验证表单
				if(checkLoginForm()){
                    $(".check-errors").hide();
                    $("#fm1").submit();
				}else{
                    $(".check-errors").show();
                }
            });

        /**
         * 前端校验登录表单是否为空
         * @returns {boolean}
         */
        function checkLoginForm(){
                $("#msg").html("");
                var userName = $("#userNameId").val().trim();
                var password = $("#passwordId").val().trim();
                var code = $("#J_codetext").val().trim();
                if(userName==null||userName==""){
                    $("#check-msg").html("账号不能为空！！");
                    return false;
                }
                if(password==null||password==""){
                    $("#check-msg").html("密码不能为空！！");
                    return false;
                }
                if(code==null||code==""){
                    $("#check-msg").html("验证码不能为空！！");
                    return false;
                }
                changePassToSafeLogin(password);
                return true;
            }
    	});
    	
        function changePassToSafeLogin(userpass) {
            var pass = hengyunpass(hengyunpass(userpass) + '<%=salt %>');
            $("#hengyunpass").val(pass);
        }
    	
    </script>
    <script type="text/javascript">
    	
    	try{
    		//前后端分离后，无法彻底的解决单点退出的bug，这里将在退出时，进入到单点登录的登录界面时，直接清空前端存储登录信息的localStorage
			localStorage.clear();
		} catch (err){
			console.error(err);
		}
    </script>
</body>
</html>
