<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" value="Orders" scope="page" />
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>
<div class="content">
	<%@ include file="/WEB-INF/jspf/header.jspf" %>
	<c:choose>
		<c:when test="${fn:length(userOrderBeanList) == 0}"><fmt:message key='list_orders.noSuchOrders'/></c:when>
		<c:otherwise>
			<div class="align-items-center">
				<div class="row border-3">
					<div class="col border-start"><fmt:message key='list_orders.number'/></div>
					<div class="col border-start"><fmt:message key='list_orders.client'/></div>
					<div class="col border-start"><fmt:message key='list_orders.car'/></div>
					<div class="col border-start"><fmt:message key='list_orders.driverStatus'/></div>
					<div class="col border-start"><fmt:message key='list_orders.startDate'/></div>
					<div class="col border-start"><fmt:message key='list_orders.endDate'/></div>
					<div class="col border-start"><fmt:message key='list_orders.price'/></div>
					<div class="col border-start"><fmt:message key='list_orders.status'/></div>
					<div class="col border-start"><fmt:message key='list_orders.rejectionReason'/></div>
					<div class="col border-start"><fmt:message key='list_orders.damage'/></div>
					<div class="col border-start"><fmt:message key='list_orders.priceForRepairs'/></div>
				</div>
				<c:forEach var="bean" items="${userOrderBeanList}">
					<div class="row mb-1 border-top border-3 border-dark">
						<div class="col border-start">${bean.id}</div>
						<div class="col border-start">${bean.userLastName} ${bean.userFirstName}</div>
						<div class="col border-start">${bean.carName}</div>
						<div class="col border-start">${bean.driverStatus}</div>
						<div class="col border-start">${bean.startDate}</div>
						<div class="col border-start">${bean.endDate}</div>
						<div class="col border-start">${bean.orderPrice}</div>
						<div class="col border-start">${bean.statusName}</div>
						<div class="col border-start">${bean.rejectionReason}</div>
						<div class="col border-start">${bean.damage}</div>
						<div class="col border-start">${bean.priceForRepairs}</div>
					</div>
				</c:forEach>
			</div>
		</c:otherwise>
	</c:choose>

	<%@ include file="/WEB-INF/jspf/footer.jspf" %>
</div>
	<%--<div class="content">

		<%@ include file="/WEB-INF/jspf/header.jspf" %>

		<tr>
			<td class="content">
			&lt;%&ndash; CONTENT &ndash;%&gt;

			<c:choose>
			<c:when test="${fn:length(userOrderBeanList) == 0}"><fmt:message key='list_orders.noSuchOrders'/></c:when>

			<c:otherwise>
			<table id="list_order_table">
				<thead>
					<div c>
						<td><fmt:message key='list_orders.number'/></td>
						<td><fmt:message key='list_orders.client'/></td>
						<td><fmt:message key='list_orders.car'/></td>
						<td><fmt:message key='list_orders.driverStatus'/></td>
						<td><fmt:message key='list_orders.startDate'/></td>
						<td><fmt:message key='list_orders.endDate'/></td>
						<td><fmt:message key='list_orders.price'/></td>
						<td><fmt:message key='list_orders.status'/></td>
						<td><fmt:message key='list_orders.rejectionReason'/></td>
						<td><fmt:message key='list_orders.damage'/></td>
						<td><fmt:message key='list_orders.priceForRepairs'/></td>

					</div>
				</thead>


				<c:forEach var="bean" items="${userOrderBeanList}">

					<tr>
						<td>${bean.id}</td>
						<td>${bean.userLastName} ${bean.userFirstName}</td>
						<td>${bean.carName}</td>
						<td>${bean.driverStatus}</td>
						<td>${bean.startDate}</td>
						<td>${bean.endDate}</td>
						<td>${bean.orderPrice}</td>
						<td>${bean.statusName}</td>
						<td>${bean.rejectionReason}</td>
						<td>${bean.damage}</td>
						<td>${bean.priceForRepairs}</td>
					</tr>

				</c:forEach>
			</table>
			</c:otherwise>
			</c:choose>

			&lt;%&ndash; CONTENT &ndash;%&gt;
			</td>
		</tr>

		<%@ include file="/WEB-INF/jspf/footer.jspf" %>

	</div>--%>
</body>
</html>