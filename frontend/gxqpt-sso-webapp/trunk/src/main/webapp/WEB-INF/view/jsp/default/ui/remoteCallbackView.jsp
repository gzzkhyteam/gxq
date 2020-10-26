<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<body onload="document.redirectForm.submit();">
	<form name="redirectForm" action="<c:out value="${remoteLoginUrl}" escapeXml="true" />" method="post" >
		<div style="display: none">
			<input name="ticket" value="${loginTicket}" />
			<input name="loginUrl" value="${remoteLoginUrl}" />
			<input name="service" value="${service}" />
			<input name="execution" value="${flowExecutionKey}">
			<input name="lg" value="${lg }">
			
			<textarea rows=10 cols=80 name="errorMessage" id="errorMessage">
				<spring:hasBindErrors name="credential">
		       		<c:forEach var="error" items="${errors.allErrors}">
		       			<spring:message code="${error.code}" text="${error.defaultMessage}"  />
		       		</c:forEach>
		        </spring:hasBindErrors>				
			</textarea>
		</div>
		<noscript>
       		<input type="submit" value="提交" />
		</noscript>
	</form>	
	
	<script type="text/javascript">
		
		debugger;
	
	</script>
	
</body>
</html>