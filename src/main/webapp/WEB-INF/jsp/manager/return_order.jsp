<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" value="Return" />
<%@ include file="/WEB-INF/jspf/head.jspf" %>
	
<body>

	<table id="main-container">

		<%-- HEADER --%>
		<%@ include file="/WEB-INF/jspf/header.jspf"%>
		<%-- HEADER --%>


		<tr >
			<td class="content center">
			<%-- CONTENT --%>

				
				<form id="login_form" action="controller" method="post">


					<input type="hidden" name="command" value="returnCar"/>

					<fieldset >
						<legend><fmt:message key='return_order.id'/></legend>
						<input type="text" name="id" required pattern="\d{1,10}" min="0"  max="2147483647" 
				title="Only numbers, max=2147483647"/><br/>
					</fieldset><br/>
					<fieldset>
						<legend><fmt:message key='return_order.damage'/></legend>
						<input type="checkbox" name="damage"/>
					</fieldset><br/>
					<fieldset >
						<legend><fmt:message key='return_order.priceForRepairs'/></legend>
						<input type="text" name="priceForRepairs" pattern="\d{1,10}" min="0"  max="2147483647" 
				title="Only numbers, max=2147483647"/><br/>
					</fieldset><br/>
					
					<input type="submit" value="<fmt:message key='return_order.button'/>">								
				</form> 
				
				
			<%-- CONTENT --%>

			</td>
		</tr>

		<%@ include file="/WEB-INF/jspf/footer.jspf"%>
		
	</table>
</body>
</html>