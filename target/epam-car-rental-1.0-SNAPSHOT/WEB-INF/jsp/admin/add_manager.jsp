<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>


<c:set var="title" value="AddManager" />
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


					<input type="hidden" name="command" value="addNewManager"/>

					<fieldset >
						<legend><fmt:message key='add_manager.login'/></legend>
						<input type="text" name="login" required pattern="\w{3,20}"  maxlength="20" 
						title="from 3 to 20 symbols (Latin alphabet, numbers)"/><br/>
					</fieldset><br/>
					<fieldset>
						<legend><fmt:message key='add_manager.password'/></legend>
						<input type="password" name="password" name="password" required pattern=".{3,20}" maxlength="20" 
						title="from 3 to 20 symbols"/>
					</fieldset><br/>
					
					<input type="submit" value="<fmt:message key='add_manager.button'/>">		
											
				</form>
				
				
			<%-- CONTENT --%>

			</td>
		</tr>

		<%@ include file="/WEB-INF/jspf/footer.jspf"%>
		
	</table>
</body>
</html>