<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>



<c:set var="title" value="payment" />
<%@ include file="/WEB-INF/jspf/head.jspf" %>
	
<body>
<div class="content">

		<%@ include file="/WEB-INF/jspf/header.jspf"%>

	<p><fmt:message key='payment.name'/><myT:orderprice price="${price}"></myT:orderprice></p>

				<form id="login_form" action="controller" method="post">
					<input type="hidden" name="command" value="payment" /> 
					<input type="hidden" name="result" value="success" />  
					<input class="btn btn-outline-dark" type="submit" value="<fmt:message key='payment.pay'/>">
				</form>
				<form id="login_form" action="controller" method="post">
					<input type="hidden" name="command" value="payment" /> 
					<input type="hidden" name="result" value="reject" />  
					<input class="btn btn-outline-dark" type="submit" value="<fmt:message key='payment.refuse'/>">
				</form>


		<%@ include file="/WEB-INF/jspf/footer.jspf"%>
		
	</div>
</body>
</html>