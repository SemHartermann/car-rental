<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" value="Users" scope="page" />
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>
<div class="content">
	<%@ include file="/WEB-INF/jspf/header.jspf" %>
	<c:choose>
		<c:when test="${fn:length(userList) == 0}"><fmt:message key='list_order.noSuchUsers'/></c:when>
		<c:otherwise>
			<div class="align-items-center">
				<div class="row border-3">
					<div class="col border-start"><fmt:message key='list_user.number'/>       </div>
					<div class="col border-start"><fmt:message key='list_user.role'/>         </div>
					<div class="col border-start"><fmt:message key='list_user.login'/>        </div>
					<div class="col border-start"><fmt:message key='list_user.password'/>     </div>
					<div class="col border-start"><fmt:message key='list_client_info.status'/></div>
				</div>
				<c:forEach var="user" items="${userList}">
					<div class="row mb-1 border-top border-3 border-dark">
						<div class="col border-start">${user.id}      </div>
						<div class="col border-start">${user.roleId}  </div>
						<div class="col border-start">${user.email}   </div>
						<div class="col border-start">${user.password}</div>
						<div class="col border-start">${user.status}  </div>
					</div>
				</c:forEach>
			</div>
		</c:otherwise>
	</c:choose>

	<%@ include file="/WEB-INF/jspf/footer.jspf" %>
</div>

</body>
</html>