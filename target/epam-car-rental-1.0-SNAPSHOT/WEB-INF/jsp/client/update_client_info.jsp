<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" value="UpdateUserInfo"/>
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>
<div class="content">
    <%@ include file="/WEB-INF/jspf/header.jspf" %>
    <form id="login_form" action="controller" method="post">


        <input type="hidden" name="command" value="updateUserInfo"/>

        <fieldset>
            <legend><fmt:message key='update_client_info.firstName'/></legend>
            <input class="btn btn-outline-dark" name="firstName" required pattern="\w{3,20}" maxlength="20"
                   title="from 3 to 20 symbols (Latin or cyrillic alphabet)"/><br/>
        </fieldset>
        <br/>
        <fieldset>
            <legend><fmt:message key='update_client_info.lastName'/></legend>
            <input class="btn btn-outline-dark" name="lastName" required pattern="\w{3,20}" maxlength="20"
                   title="from 3 to 20 symbols (Latin or cyrillic alphabet, numbers)"/><br/>
        </fieldset>
        <br/>
        <fieldset>
            <legend><fmt:message key='update_client_info.passport'/></legend>
            <input class="btn btn-outline-dark" type="text" name="passportNumber" required pattern="\d{3,20}" maxlength="20"
                   title="Only numbers, max 20 numbers"/><br/>
        </fieldset>
        <br/>
        <fieldset>
            <legend><fmt:message key='update_client_info.telephone'/></legend>
            <input class="btn btn-outline-dark" type="text" name="phoneNumber" required pattern="\d{1,20}"
                   title="Only numbers, max 20 numbers"/><br/>
        </fieldset>
        <br/>


        <input class="btn btn-outline-dark" type="submit" value="<fmt:message key='update_client_info.button'/>">
    </form>
    <%@ include file="/WEB-INF/jspf/footer.jspf" %>
</div>


</body>
</html>