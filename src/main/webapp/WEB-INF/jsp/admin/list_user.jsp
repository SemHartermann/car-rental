<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" value="Users" scope="page" />
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>
	<table id="main-container">

		<%@ include file="/WEB-INF/jspf/header.jspf" %>
			
		<tr>
			<td class="content">
			<%-- CONTENT --%>

			<c:choose>
			<c:when test="${fn:length(userList) == 0}"><fmt:message key='list_order.noSuchUsers'/></c:when>
	
			<c:otherwise>
			<table id="list_users_table">
				<thead>
					<tr>
						<td><fmt:message key='list_user.number'/></td>
						<td><fmt:message key='list_user.role'/></td>
						<td><fmt:message key='list_user.login'/></td>
						<td><fmt:message key='list_user.password'/></td>
						<td><fmt:message key='list_client_info.status'/></td>
					</tr>
				</thead>


				<c:forEach var="user" items="${userList}">
					
					<tr>
						<td>${user.id}</td>
						<td>${user.roleId}</td>
						<td>${user.login}</td>
						<td>${user.password}</td>
						<td>${user.status}</td>
					</tr>

				</c:forEach>			
			</table>
			</c:otherwise>
			</c:choose>
						
			<%-- CONTENT --%>
			</td>
		</tr>
		
		<%@ include file="/WEB-INF/jspf/footer.jspf" %>
		
	</table>
</body>
</html>