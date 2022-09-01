
<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>

<html>

<c:set var="title" value="ListOrders" scope="page" />
<%@ include file="/WEB-INF/jspf/head.jspf"%>

<body>
	<table id="main-container">

		<%@ include file="/WEB-INF/jspf/header.jspf"%>

		<tr>
			<td class="content">
				<%-- CONTENT --%>
					<c:choose>
					<c:when test="${fn:length(userProfile) == 0}"></c:when>

					<c:otherwise>
						<table id="list_order_table">
							<thead>
								<tr>
									<td><fmt:message key='client.firstName' /></td>
									<td><fmt:message key='client.lastName' /></td>
									<td><fmt:message key='client.passportNumber' /></td>
									<td><fmt:message key='client.phoneNumber' /></td>
									<td><fmt:message key='client.email' /></td>
								</tr>
							</thead>

							<c:forEach var="user" items="${userProfile}">

								<tr>
									<td>${user.firstName}</td>
									<td>${user.lastName}</td>
									<td>${user.passportNumber}</td>
									<td>${user.phoneNumber}</td>
									<td>${user.email}</td>
								</tr>

							</c:forEach>
						</table>
					</c:otherwise>
				</c:choose>
					<%-- CONTENT --%>
			</td>
		</tr>

		<%@ include file="/WEB-INF/jspf/footer.jspf"%>

	</table>
</body>
</html>