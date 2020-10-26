<%@ page pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</div> <!-- END #content -->

<footer>
  <div id="copyright" class="container">
    <p></p>
        <p style="text-align: center;">版权所有©<a href="http://hengyunsoft.com"><em>中科恒运股份有限公司</em></a><br/>
            <%=org.jasig.cas.CasVersion.getDateTime()%></p>
  </div>
</footer>

</div> <!-- END #container -->

<script src="/js/libs/headjs/1.0.3/head.min.js"></script>
<spring:theme code="cas.javascript.file" var="casJavascriptFile" text="" />
<script type="text/javascript" src="<c:url value="${casJavascriptFile}" />"></script>
</body>
</html>

