<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>

<html>

<c:set var="title" value="Manager" scope="page" />
<%@ include file="/WEB-INF/jspf/head.jspf"%>

<body>
<div class="content">
	<%@ include file="/WEB-INF/jspf/header.jspf"%>

	<div id="admin_hello" >
		<fmt:message key='manager.hello'/>
	</div>

	<%@ include file="/WEB-INF/jspf/footer.jspf"%>
</div>

</body>
</html>