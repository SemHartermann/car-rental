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
            <%--<div class="row">
                <div class="col-form-label-lg"><fmt:message key='client.firstName'/></div>
                <div class="col-form-label-lg"><fmt:message key='client.lastName'/></div>
                <div class="col-form-label-lg"><fmt:message key='client.passportNumber'/></div>
                <div class="col-form-label-lg"><fmt:message key='client.phoneNumber'/></div>
                <div class="col-form-label-lg"><fmt:message key='client.email'/></div>
            </div>
            <c:forEach var="user" items="${userProfile}">
                <div class="row-cols-5">
                    <div class="col-form-label-lg">${user.firstName}</div>
                    <div class="col-form-label-lg">${user.lastName}</div>
                    <div class="col-form-label-lg">${user.passportNumber}</div>
                    <div class="col-form-label-lg">${user.phoneNumber}</div>
&lt;%&ndash;
                    <div class="col-form-label-lg">${user.email}</div>
&ndash;%&gt;
                </div>
            </c:forEach>--%>
        </c:otherwise>
    </c:choose>
    <%@ include file="/WEB-INF/jspf/footer.jspf" %>
</div>

<%--
<table id="main-container">

    <%@ include file="/WEB-INF/jspf/header.jspf" %>

    <tr>
        <td class="content">
            &lt;%&ndash; CONTENT &ndash;%&gt;
            <c:choose>
                <c:when test="${fn:length(userProfile) == 0}"></c:when>

                <c:otherwise>
                    <table id="list_order_table">
                        <thead>
                        <tr>
                            <td><fmt:message key='client.firstName'/></td>
                            <td><fmt:message key='client.lastName'/></td>
                            <td><fmt:message key='client.passportNumber'/></td>
                            <td><fmt:message key='client.phoneNumber'/></td>
                            <td><fmt:message key='client.email'/></td>

                        </tr>
                        </thead>

                        <c:forEach var="user" items="${userProfile}">

                            <tr>
                                <td>${user.firstName}</td>
                                <td>${user.lastName}</td>
                                <td>${user.passportNumber}</td>
                                <td>${user.phoneNumber}</td>

                            </tr>

                        </c:forEach>
                    </table>
                </c:otherwise>
            </c:choose>
            &lt;%&ndash; CONTENT &ndash;%&gt;
        </td>
    </tr>

    <%@ include file="/WEB-INF/jspf/footer.jspf" %>

</table>
--%>
</body>
</html>