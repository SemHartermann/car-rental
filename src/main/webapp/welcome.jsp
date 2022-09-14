<%@ page pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" value="Welcome" scope="page"/>
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>
<%@ include file="/WEB-INF/jspf/header.jspf" %>
<div class="content center align-items-center">

    <div class="row center align-items-center">
        <h1>
            Welcome to Epam Car Rental
        </h1>
        <div class="btn-group center align-items-center" role="group" aria-label="Basic outlined example">
            <a type="button" class="btn btn-outline-dark" href="login.jsp"><fmt:message key='login.header'/></a>
            <a type="button" class="btn btn-outline-dark" href="register.jsp"><fmt:message key='register.header'/></a>
        </div>
    </div>
    <%@ include file="/WEB-INF/jspf/footer.jspf" %>
</div>
</body>
</html>