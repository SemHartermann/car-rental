<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>


<c:set var="title" value="AddOrder" />
<%@ include file="/WEB-INF/jspf/head.jspf" %>
	
<body>
<table id="main-container">

<%--=========================================================================== 
This is the CONTENT, containing the main part of the page.
===========================================================================--%> 
<%-- HEADER --%>
		<%@ include file="/WEB-INF/jspf/header.jspf"%>
		<%-- HEADER --%>


		<tr >
			<td class="content center">
			<%-- CONTENT --%>
			
			
			
<%--=========================================================================== 
Defines the web form.
===========================================================================--%> 
				<form id="Login_form" action="controller" method="post">


					<input type="hidden" name="command" value="addOrder"/>

					
					<fieldset >
						<legend><fmt:message key='add_order.carId'/></legend>
						<input type="text" name="carId" required pattern="\d{1,10}" min="0"  max="2147483647" 
						title="Only numbers, max=2147483647"/><br/>
					</fieldset><br/><br/>
					<fieldset>
						<legend><fmt:message key='add_order.driverStatus'/></legend>
						<input type="checkbox" name="driverStatus"/><br/>
					</fieldset><br/>
					<fieldset >
					<legend><fmt:message key='add_order.orderData'/></legend>
						<input type="date" name="orderData" required max="${yearsAfterDate}" min="${currentDate}"/><br/>
					</fieldset><br/><br/>
					<fieldset >
						<legend><fmt:message key='add_order.returnData'/></legend>
						<input type="date" name="returnData" required max="${yearsAfterDate}" min="${currentDate}" /><br/>
					</fieldset><br/>
					
					<input type="submit" value="<fmt:message key='add_order.button'/>">		
											
				</form>
				
				
			<%-- CONTENT --%>

			</td>
		</tr>

		<%@ include file="/WEB-INF/jspf/footer.jspf"%>
		
	</table>
</body>
</html>