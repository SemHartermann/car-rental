<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>



<c:set var="title" value="payment" />
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

									<p><fmt:message key='payment.name'/></p>
				<myT:orderprice price="${price}"></myT:orderprice>
		<form id="login_form" action="controller" method="post">
					<input type="hidden" name="command" value="payment" /> 
					<input type="hidden" name="result" value="success" />  
					<input type="submit" value="<fmt:message key='payment.pay'/>">
				</form>
				&nbsp;
				<form id="login_form" action="controller" method="post">
					<input type="hidden" name="command" value="payment" /> 
					<input type="hidden" name="result" value="reject" />  
					<input type="submit" value="<fmt:message key='payment.refuse'/>">
				</form>
		
		
		
				
				
			<%-- CONTENT --%>

			</td>
		</tr>

		<%@ include file="/WEB-INF/jspf/footer.jspf"%>
		
	</table>
</body>
</html>