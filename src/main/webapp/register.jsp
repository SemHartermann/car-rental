<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" value="Register" />
<%@ include file="/WEB-INF/jspf/head.jspf" %>
	
<body>
<table id="main-container">

<%--=========================================================================== 
This is the CONTENT, containing the main part of the page.
===========================================================================--%> 
		<tr >
			<td class="content center">
			<%-- CONTENT --%>
			
<%--=========================================================================== 
Defines the web form.
===========================================================================--%> 
				<form id="Login_form" action="controller" method="post">

<%--=========================================================================== 
Hidden field. In the query it will act as command=login.
The purpose of this to define the command name, which have to be executed 
after you submit current form. 
===========================================================================--%> 
					<input type="hidden" name="command" value="registerClient"/>

					<fieldset >
						<legend><fmt:message key='register.email'/></legend>
						<input type="email" name="email" required pattern=".{3,20}"  maxlength="20"
						title="from 3 to 20 symbols (Latin alphabet, numbers)"/><br/>
					</fieldset><br/>
					<fieldset>
						<legend><fmt:message key='register.password'/></legend>
						<input type="password" name="password" required pattern=".{3,20}" maxlength="20" 
						title="from 3 to 20 symbols"/>
					</fieldset><br/>
					
					<input type="submit" value="Registration">		
											
				</form>
				
				
			<%-- CONTENT --%>

			</td>
		</tr>

		<%@ include file="/WEB-INF/jspf/footer.jspf"%>
		
	</table>
</body>
</html>