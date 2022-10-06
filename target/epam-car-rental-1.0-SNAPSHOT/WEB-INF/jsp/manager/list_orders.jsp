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
        <c:when test="${fn:length(userOrderBeanList) == 0}"><fmt:message key='list_orders.noSuchOrders'/></c:when>
        <c:otherwise>
            <div class="align-items-center" >
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
                    <div class="col border-start"><fmt:message key='list_orders.confirming'/></div>
                    <div class="col border-start"><fmt:message key='list_orders.rejecting'/></div>
                    <div class="col border-start"><fmt:message key='list_orders.returning'/></div>
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
                        <div style="width: 100px; word-wrap:break-word; table-layout: fixed;" class="col border-start">${bean.rejectionReason}</div>
                        <div class="col border-start">${bean.damage}</div>
                        <div class="col border-start">${bean.priceForRepairs}</div>

                        <div class="col border-start">
                            <form action="controller" method="post">
                                <input type="hidden" name="command" value="confirmOrder"/>
                                <input type="hidden" name="id" value="${bean.id}"/>
                                <input class="btn btn-outline-dark" type="submit"
                                       value="<fmt:message key='confirm_order.button'/>">
                            </form>
                        </div>
                        <div class="col border-start">
                            <form action="controller" method="post">
                                <input type="hidden" name="command" value="viewRejectOrder"/>
                                <input type="hidden" name="orderId" value="${bean.id}"/>
                                <input type="submit" class="btn btn-outline-dark"
                                       value="<fmt:message key='reject_order.button'/>">
                            </form>
                        </div>
                        <div class="col border-start">
                            <form action="controller" method="post">
                                <input type="hidden" name="command" value="viewReturnCar"/>
                                <input type="hidden" name="orderId" value="${bean.id}"/>
                                <input type="submit" class="btn btn-outline-dark"
                                       value="<fmt:message key='return_order.button'/>">
                            </form>
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