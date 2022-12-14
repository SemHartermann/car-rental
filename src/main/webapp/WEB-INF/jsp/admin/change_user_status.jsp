<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" value="ChangeUserStatus" />
<%@ include file="/WEB-INF/jspf/head.jspf" %>
	
<body>

	<div class="content">

		<%@ include file="/WEB-INF/jspf/header.jspf"%>

		<div class="align-items-center">

				
				<form id="login_form" action="controller" method="post">


					<input type="hidden" name="command" value="changeUserStatus"/>

					<fieldset >
						<legend><fmt:message key='change_user_status.id'/></legend>
						<input type="text" name="id" required pattern="\d{1,10}" min="0" max="2147483647" 
				title="Only numbers, max=2147483647"/><br/>
					</fieldset><br/>
					<fieldset>
						<legend><fmt:message key='change_user_status.ban'/></legend>
						<input type="checkbox" name="status"/>
					</fieldset><br/>
					
					<input type="submit" value="<fmt:message key='change_user_status.button'/>">								
				</form> 
				

		</div>

		<%@ include file="/WEB-INF/jspf/footer.jspf"%>
		
	</div>
</body>
</html>