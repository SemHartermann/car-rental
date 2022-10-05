<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" value="CarRental" scope="page"/>
<%@ include file="/WEB-INF/jspf/head.jspf" %>


<head>
    <title>CarRental</title>
</head>

<body>
<div class="content">

    <%@ include file="/WEB-INF/jspf/header.jspf" %>

    <div class="align-items-center">
            <p>
                <fmt:message key='locale.changed'/>
            </p>
    </div>


    <%@ include file="/WEB-INF/jspf/footer.jspf" %>

</div>

</body>
</html>