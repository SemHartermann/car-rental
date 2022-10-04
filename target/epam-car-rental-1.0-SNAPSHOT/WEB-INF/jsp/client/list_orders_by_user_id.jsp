<%@ page pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" value="Orders" scope="page"/>
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>


<div class="content">
    <%@ include file="/WEB-INF/jspf/header.jspf" %>
    <c:choose>
        <c:when test="${fn:length(userOrderBeanListByUserId) == 0}">
            <fmt:message key='list_orders_by_user_id.noSuchOrders'/></c:when>
        <c:otherwise>
            <div class="align-items-center">
                <div class="row border-3">
                    <div class="col border-start"><fmt:message key='list_orders_by_user_id.number'/></div>
                    <div class="col border-start"><fmt:message key='list_orders_by_user_id.client'/></div>
                    <div class="col border-start"><fmt:message key='list_orders_by_user_id.car'/></div>
                    <div class="col border-start"><fmt:message key='list_orders_by_user_id.driverStatus'/></div>
                    <div class="col border-start"><fmt:message key='list_orders_by_user_id.startDate'/></div>
                    <div class="col border-start"><fmt:message key='list_orders_by_user_id.endDate'/></div>
                    <div class="col border-start"><fmt:message key='list_orders_by_user_id.price'/></div>
                    <div class="col border-start"><fmt:message key='list_orders_by_user_id.status'/></div>
                    <div class="col border-start"><fmt:message key='list_orders_by_user_id.rejectionReason'/></div>
                    <div class="col border-start"><fmt:message key='list_orders_by_user_id.damage'/></div>
                    <div class="col border-start"><fmt:message key='list_orders_by_user_id.priceForRepairs'/></div>
                    <div class="col border-start"><fmt:message key='list_orders_by_user_id.payment'/></div>
                </div>
                <c:forEach var="bean" items="${userOrderBeanListByUserId}">
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
                        <div class="col border-start">
                        <c:set var="confirmed" scope="session" value="confirmed"/>
                        <c:if test="${bean.statusName == confirmed}">
                            <form id="Payment_from_orders_form" action="controller" method="post">
                                <input type="hidden" name="command" value="paymentFromOrders"/>
                                <input type="hidden" name="price" value="${bean.orderPrice}"/>
                                <input type="hidden" name="orderId" value="${bean.id}"/>
                                <input type="submit" class="btn btn-outline-dark"
                                                        value="<fmt:message key='list_orders_by_user_id.payment'/>">
                            </form>
                        </c:if>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </c:otherwise>
    </c:choose>

    <%@ include file="/WEB-INF/jspf/footer.jspf" %>
</div>
</body>
</html>