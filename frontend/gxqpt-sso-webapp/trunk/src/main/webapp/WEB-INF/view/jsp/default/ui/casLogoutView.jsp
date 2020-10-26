<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<jsp:directive.include file="includes/top.jsp" />
  <div id="msg" class="success">
    <h2><spring:message code="screen.logout.header" /></h2>
    <p><spring:message code="screen.logout.success" /></p>
    <p><spring:message code="screen.logout.security" /></p>
    <p><a href="login">重新登录</a></p>
  </div>
<jsp:directive.include file="includes/bottom.jsp" />