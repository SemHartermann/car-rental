<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" value="Orders" scope="page" />
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>
	<table id="main-container">

		<%@ include file="/WEB-INF/jspf/header.jspf" %>
			
		<tr>
			<td class="content">
			<%-- CONTENT --%>

			<c:choose>
			<c:when test="${fn:length(userOrderBeanList) == 0}"><fmt:message key='list_orders.noSuchOrders'/></c:when>
	
			<c:otherwise>
			<table id="list_order_table">
				<thead>
					<tr>
						<td><fmt:message key='list_orders.number'/></td>
						<td><fmt:message key='list_orders.client'/></td>
						<td><fmt:message key='list_orders.car'/></td>
						<td><fmt:message key='list_orders.driverStatus'/></td>
						<td><fmt:message key='list_orders.orderData'/></td>
						<td><fmt:message key='list_orders.returnData'/></td>
						<td><fmt:message key='list_orders.price'/></td>
						<td><fmt:message key='list_orders.status'/></td>
						<td><fmt:message key='list_orders.rejectionReason'/></td>
						<td><fmt:message key='list_orders.damage'/></td>
						<td><fmt:message key='list_orders.priceForRepairs'/></td>
						
					</tr>
				</thead>


				<c:forEach var="bean" items="${userOrderBeanList}">
					
					<tr>
						<td>${bean.id}</td>
						<td>${bean.userLastName} ${bean.userFirstName}</td>
						<td>${bean.carName}</td>
						<td>${bean.driverStatus}</td>
						<td>${bean.orderData}</td>
						<td>${bean.returnData}</td>
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
						
			<%-- CONTENT --%>
			</td>
		</tr>
		
		<%@ include file="/WEB-INF/jspf/footer.jspf" %>
		
	</table>
</body>
</html>