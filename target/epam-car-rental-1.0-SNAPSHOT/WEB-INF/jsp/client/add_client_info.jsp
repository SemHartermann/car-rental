<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>


<c:set var="title" value="AddClientInfo" />
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


					<input type="hidden" name="command" value="addUserInfo"/>

					<fieldset >
						<legend><fmt:message key='add_client_info.firstName'/></legend>
						<input type="text" name="firstName" required pattern="\w{3,20}"  maxlength="20" 
						title="from 3 to 20 symbols (Latin alphabet, numbers)"/><br/>
					</fieldset><br/>
					<fieldset>
						<legend><fmt:message key='add_client_info.lastName'/></legend>
						<input type="text" name="lastName" required pattern="\w{3,20}"  maxlength="20" 
						title="from 3 to 20 symbols (Latin alphabet, numbers)"/>
					</fieldset><br/>
					<fieldset>
						<legend><fmt:message key='add_client_info.passport'/></legend>
						<input type="text" name="passportNumber" required pattern="\w{3,20}"  maxlength="20" 
						title="from 3 to 20 symbols (Latin alphabet, numbers)"/>
					</fieldset><br/>
					<fieldset>
						<legend><fmt:message key='add_client_info.telephone'/></legend>
						<input type="tel" name="phoneNumber" required pattern="\d{1,20}" 
						title="Only numbers, max 20 numbers"/>
					</fieldset><br/>
					<fieldset>
						<legend><fmt:message key='add_client_info.email'/></legend>
						<input type="email" name="email" required maxlength="40" 
						title="from 3 to 40 symbols (Latin alphabet, numbers, symbols)"/>
					</fieldset><br/>  
					
					<input type="submit" value="ADD_USER_INFO">		
											
				</form>
				
				
			<%-- CONTENT --%>

			</td>
		</tr>

		<%@ include file="/WEB-INF/jspf/footer.jspf"%>
		
	</table>
</body>
</html>