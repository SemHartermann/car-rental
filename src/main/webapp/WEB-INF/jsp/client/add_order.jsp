
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>


<c:set var="title" value="AddOrder" />
<%@ include file="/WEB-INF/jspf/head.jspf" %>
	
<body>
<div class="content">
	<%@ include file="/WEB-INF/jspf/header.jspf"%>

	<form id="Login_form" action="controller" method="post">


		<input type="hidden" name="command" value="addOrder"/>
		<c:set var="carId" value="${sessionScope.carId}"/>
		<input type="hidden" name="carId" value="carId"/>

		<fieldset>
			<legend><fmt:message key='add_order.driverStatus'/></legend>
			<input type="checkbox" name="driverStatus"/><br/>
		</fieldset><br/>
		<fieldset >
			<legend><fmt:message key='add_order.startDate'/></legend>
			<input type="date" name="startDate" required max="${yearsAfterDate}" min="${currentDate}"/><br/>
		</fieldset><br/><br/>
		<fieldset >
			<legend><fmt:message key='add_order.endDate'/></legend>
			<input type="date" name="endDate" required max="${yearsAfterDate}" min="${currentDate}" /><br/>
		</fieldset><br/>

		<input type="submit" value="<fmt:message key='add_order.button'/>">

	</form>

	<%@ include file="/WEB-INF/jspf/footer.jspf"%>
</div>
</body>
</html>