<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" value="RejectOrder"/>
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>

<div class="content">

    <%-- HEADER --%>
    <%@ include file="/WEB-INF/jspf/header.jspf" %>
    <%-- HEADER --%>


    <div class="align-items-center">
        <%-- CONTENT --%>


        <form id="login_form" action="controller" method="post">


            <input type="hidden" name="command" value="rejectOrder"/>

            <input type="hidden" name="id" value="${orderId}">
            <br/>
            <fieldset>
                <legend><fmt:message key='reject_order.rejectionReason'/></legend>
                <input type="text" name="rejectionReason" required pattern=".{3,45}" maxlength="45"
                       title="from 3 to 45 symbols"/>
            </fieldset>
            <br/>

            <input type="submit" value="<fmt:message key='reject_order.button'/>">
        </form>


        <%-- CONTENT --%>

    </div>

    <%@ include file="/WEB-INF/jspf/footer.jspf" %>

</div>
</body>
</html>