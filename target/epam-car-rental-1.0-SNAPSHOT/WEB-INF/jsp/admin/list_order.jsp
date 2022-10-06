<%@ page pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" value="ListOrders" scope="page"/>
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>
<div class="content">
    <%@ include file="/WEB-INF/jspf/header.jspf" %>
    <c:choose>
        <c:when test="${fn:length(orderList) == 0}"><fmt:message key='list_orders.noSuchOrders'/></c:when>
        <c:otherwise>
            <div class="align-items-center">
                <div class="row border-3">
                    <div class="col border-start"><fmt:message key='list_order.number'/></div>
                    <div class="col border-start"><fmt:message key='list_order.userId'/></div>
                    <div class="col border-start"><fmt:message key='list_order.carId'/></div>
                    <div class="col border-start"><fmt:message key='list_order.driverStatus'/></div>
                    <div class="col border-start"><fmt:message key='list_order.startDate'/></div>
                    <div class="col border-start"><fmt:message key='list_order.endDate'/></div>
                    <div class="col border-start"><fmt:message key='list_order.price'/></div>
                    <div class="col border-start"><fmt:message key='list_order.status'/></div>
                    <div class="col border-start"><fmt:message key='list_order.rejectionReason'/></div>
                    <div class="col border-start"><fmt:message key='list_order.damage'/></div>
                    <div class="col border-start"><fmt:message key='list_order.priceForRepairs'/></div>
                </div>
                <c:forEach var="order" items="${orderList}">
                    <div class="row mb-1 border-top border-3 border-dark">
                        <div class="col border-start">${order.id}</div>
                        <div class="col border-start">${order.userId}</div>
                        <div class="col border-start">${order.carId}</div>
                        <div class="col border-start">${order.driverStatus}</div>
                        <div class="col border-start">${order.startDate}</div>
                        <div class="col border-start">${order.endDate}</div>
                        <div class="col border-start">${order.price}</div>
                        <div class="col border-start">${order.statusId}</div>
                        <div style="width: 100px; word-wrap:break-word; table-layout: fixed;" class="col border-start" class="col border-start">${order.rejectionReason}</div>
                        <div class="col border-start">${order.damage}</div>
                        <div class="col border-start">${order.priceForRepairs}</div>
                    </div>
                </c:forEach>
            </div>
        </c:otherwise>
    </c:choose>

    <%@ include file="/WEB-INF/jspf/footer.jspf" %>
</div>

</body>
</html>