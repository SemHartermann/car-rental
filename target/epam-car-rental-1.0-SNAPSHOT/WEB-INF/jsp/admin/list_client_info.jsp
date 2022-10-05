<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" value="Clients" scope="page" />
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>
	<div class="content">

		<%@ include file="/WEB-INF/jspf/header.jspf" %>

			<c:choose>
			<c:when test="${fn:length(userInfoBeanList) == 0}">No such users info</c:when>
	
			<c:otherwise>
			<div class="align-items-center">

					<div class="row border-3">
						<div class="col border-start"><fmt:message key='list_client_info.number'/></div>
						<div class="col border-start"><fmt:message key='list_client_info.login'/></div>
						<div class="col border-start"><fmt:message key='list_client_info.password'/></div>
						<div class="col border-start"><fmt:message key='list_client_info.firstName'/></div>
						<div class="col border-start"><fmt:message key='list_client_info.lastName'/></div>
						<div class="col border-start"><fmt:message key='list_client_info.passport'/></div>
						<div class="col border-start"><fmt:message key='list_client_info.telephone'/></div>
						<div class="col border-start"><fmt:message key='list_client_info.email'/></div>
						<div class="col border-start"><fmt:message key='list_client_info.status'/></div>
						<div class="col border-start"><fmt:message key='list_client_info.change'/></div>
					</div>

				<c:forEach var="user" items="${userInfoBeanList}">
					
					<div class="row mb-1 border-top border-3 border-dark">
						<div class="col border-start">${user.id}</div>
						<div class="col border-start">${user.login}</div>
						<div class="col border-start">${user.password}</div>
						<div class="col border-start">${user.firstName}</div>
						<div class="col border-start">${user.lastName}</div>
						<div class="col border-start">${user.passportNumber}</div>
						<div class="col border-start">${user.phoneNumber}</div>
						<div class="col border-start">${user.email}</div>
						<div class="col border-start">${user.status}</div>
						<div class="col border-start"><form id="login_form" action="controller" method="post">


							<input type="hidden" name="command" value="changeUserStatus"/>


							<input type="hidden" name="id" value="${user.id}">
								<input type="checkbox" name="status"/>
							<br/>

							<input type="submit" value="<fmt:message key='change_user_status.button'/>">
						</form> </div>
					</div>

				</c:forEach>
			</div>
			</c:otherwise>
			</c:choose>


		<%@ include file="/WEB-INF/jspf/footer.jspf" %>

	</div>
</body>
</html>