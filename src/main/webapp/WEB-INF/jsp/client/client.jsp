<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" value="Client" scope="page"/>
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>

<div class="content align-content-center">
    <%@ include file="/WEB-INF/jspf/header.jspf" %>
    <c:choose>
        <c:when test="${fn:length(userProfile) == 0}"></c:when>

        <c:otherwise>
            <div>
                <div class="row">
                    <div class="col"><fmt:message key='client.firstName'/></div>
                    <div class="col"><fmt:message key='client.lastName'/></div>
                    <div class="col"><fmt:message key='client.passportNumber'/></div>
                    <div class="col"><fmt:message key='client.phoneNumber'/></div>
                    <div class="col"><fmt:message key='client.email'/></div>
                </div>
                <c:forEach var="user" items="${userProfile}">
                    <div class="row">
                        <div class="col">${user.firstName}</div>
                        <div class="col">${user.lastName}</div>
                        <div class="col">${user.passportNumber}</div>
                        <div class="col">${user.phoneNumber}</div>
                        <div class="col">${user.email}</div>
                    </div>
                </c:forEach>
            </div>

        </c:otherwise>
    </c:choose>
    <%@ include file="/WEB-INF/jspf/footer.jspf" %>
</div>

</body>
</html>