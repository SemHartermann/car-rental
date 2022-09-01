<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" value="ListOrders" scope="page" />
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>
	<table id="main-container">

		<%@ include file="/WEB-INF/jspf/header.jspf" %>
			
		<tr>
			<td class="content">
			<%-- CONTENT --%>

			<c:choose>
			<c:when test="${fn:length(orderList) == 0}">No such orders</c:when>
	
			<c:otherwise>
			<table id="list_order_table">
				<thead>
					<tr>
						<td><fmt:message key='list_order.number'/></td>
						<td><fmt:message key='list_order.userId'/></td>
						<td><fmt:message key='list_order.carId'/></td>
						<td><fmt:message key='list_order.driverStatus'/></td>
						<td><fmt:message key='list_order.orderData'/></td>
						<td><fmt:message key='list_order.returnData'/></td>
						<td><fmt:message key='list_order.price'/></td>
						<td><fmt:message key='list_order.status'/></td>
						<td><fmt:message key='list_order.rejectionReason'/></td>
						<td><fmt:message key='list_order.damage'/></td>
						<td><fmt:message key='list_order.priceForRepairs'/></td>
						
					</tr>
				</thead>


				<c:forEach var="order" items="${orderList}">
					
					<tr>
						<td>${order.id}</td>
						<td>${order.userId}</td>
						<td>${order.carId}</td>
						<td>${order.driverStatus}</td>
						<td>${order.orderData}</td>
						<td>${order.returnData}</td>
						<td>${order.orderPrice}</td>
						<td>${order.statusId}</td>
						<td>${order.rejectionReason}</td>
						<td>${order.damage}</td>
						<td>${order.priceForRepairs}</td>
					
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