<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" value="Clients" scope="page" />
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>
	<table id="main-container">

		<%@ include file="/WEB-INF/jspf/header.jspf" %>
			
		<tr>
			<td class="content">
			<%-- CONTENT --%>

			<c:choose>
			<c:when test="${fn:length(userInfoBeanList) == 0}">No such users info</c:when>
	
			<c:otherwise>
			<table id="list_users_info_table">
				<thead>
					<tr>
						<td><fmt:message key='list_client_info.number'/></td>
						<td><fmt:message key='list_client_info.login'/></td>
						<td><fmt:message key='list_client_info.password'/></td>
						<td><fmt:message key='list_client_info.firstName'/></td>
						<td><fmt:message key='list_client_info.lastName'/></td>
						<td><fmt:message key='list_client_info.passport'/></td>
						<td><fmt:message key='list_client_info.telephone'/></td>
						<td><fmt:message key='list_client_info.email'/></td>
						<td><fmt:message key='list_client_info.status'/></td>
					</tr>
				</thead>


				<c:forEach var="user" items="${userInfoBeanList}">
					
					<tr>
						<td>${user.id}</td>
						<td>${user.login}</td>
						<td>${user.password}</td>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td>${user.passportNumber}</td>
						<td>${user.phoneNumber}</td>
						<td>${user.email}</td>
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