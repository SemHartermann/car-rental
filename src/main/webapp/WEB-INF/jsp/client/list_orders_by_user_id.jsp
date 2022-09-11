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
			<c:when test="${fn:length(userOrderBeanListByUserId) == 0}">
			<fmt:message key='list_orders_by_user_id.noSuchOrders'/></c:when>
	
			<c:otherwise>
			<table id="list_order_table">
				<thead>
					<tr>
						<td><fmt:message key='list_orders_by_user_id.number'/></td>
						<td><fmt:message key='list_orders_by_user_id.client'/></td>
						<td><fmt:message key='list_orders_by_user_id.car'/></td>
						<td><fmt:message key='list_orders_by_user_id.driverStatus'/></td>
						<td><fmt:message key='list_orders_by_user_id.startDate'/></td>
						<td><fmt:message key='list_orders_by_user_id.endDate'/></td>
						<td><fmt:message key='list_orders_by_user_id.price'/></td>
						<td><fmt:message key='list_orders_by_user_id.status'/></td>
						<td><fmt:message key='list_orders_by_user_id.rejectionReason'/></td>
						<td><fmt:message key='list_orders_by_user_id.damage'/></td>
						<td><fmt:message key='list_orders_by_user_id.priceForRepairs'/></td>
						
					</tr>
				</thead>


				<c:forEach var="bean" items="${userOrderBeanListByUserId}">
					
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
						<c:set var = "opened" scope = "session" value = "opened"/>
						<c:if test="${bean.statusName == opened}">
						<form id="Payment_from_orders_form" action="controller" method="post">
							<input type="hidden" name="command" value="paymentFromOrders"/>
							<input type="hidden" name="price" value="${bean.orderPrice}"/>
							<input type="hidden" name="orderId" value="${bean.id}"/>
							<td><input type="submit" value="<fmt:message key='list_orders_by_user_id.payment'/>"></td>
						</form>
						</c:if>
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