<%@ page contentType="text/html; charset=UTF-8"%>  
<%@ page import="com.hengyunsoft.sso.util.CasUtils"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>  
<%  
    String separator = "";  
        // 需要输入 login-at 参数，当生成lt后或登录失败后则重新跳转至 原登录页，并传入参数 lt 和 error_message  
    String referer = request.getParameter("login-at");  
  
    referer = CasUtils.resetUrl(referer);  
    if (referer != null && referer.length() > 0) {  
        separator = (referer.indexOf("?") > -1) ? "&" : "?";  
%>  
<html>  
    <title>cas get login ticket</title>  
    <head>  
        <META http-equiv="Content-Type" content="text/html; charset=UTF-8">  
        <script>  
        var redirectURL = "<%=referer + separator%>lt=${flowExecutionKey}";  
        <spring:hasBindErrors name="credential">  
            var errorMsg = '<c:forEach var="error" items="${errors.allErrors}"><spring:message code="${error.code}" text="${error.defaultMessage}" /></c:forEach>';  
            redirectURL += '&error_message=' + encodeURIComponent (errorMsg);  
        </spring:hasBindErrors>  
         window.location.href = redirectURL;  
       </script>  
    </head>  
    <body></body>  
</html>  
<%  
    } else {  
%>         
        <script>window.location.href = "/login";</script>  
<%         
    }  
%>