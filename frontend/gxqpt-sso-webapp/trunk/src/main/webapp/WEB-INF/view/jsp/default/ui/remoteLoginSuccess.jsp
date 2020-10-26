<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<body onload="document.redirectForm.submit();">
	<form name="redirectForm" action="<c:out value="${service}" escapeXml="true" />"  >
		<div style="display: none">
		</div>
		<noscript>
       		<input type="submit" value="提交" />
		</noscript>
	</form>	
</body>
</html>