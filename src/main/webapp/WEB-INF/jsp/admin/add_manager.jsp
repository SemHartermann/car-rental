<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>


<c:set var="title" value="AddManager"/>
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>
<div class="content">

    <%--===========================================================================
    This is the CONTENT, containing the main part of the page.
    ===========================================================================--%>
    <%-- HEADER --%>
    <%@ include file="/WEB-INF/jspf/header.jspf" %>
    <%-- HEADER --%>


    <div class="align-items-center">

            <%--===========================================================================
            Defines the web form.
            ===========================================================================--%>
            <form id="Login_form" action="controller" method="post">


                <input type="hidden" name="command" value="addNewManager"/>

                <fieldset>
                    <legend><fmt:message key='add_manager.email'/></legend>
                    <input type="email" name="email" <%--required pattern="\.{3,20}"--%> maxlength="20"
                           title="enter manager email"/><br/>
                </fieldset>
                <br/>
                <fieldset>
                    <legend><fmt:message key='add_manager.password'/></legend>
                    <input type="password" name="password" name="password" required pattern=".{3,20}" maxlength="20"
                           title="enter manager password"/>
                </fieldset>
                <br/>

                <input type="submit" value="<fmt:message key='add_manager.button'/>">

            </form>

    </div>
<%@ include file="/WEB-INF/jspf/footer.jspf" %>
</div>
</body>
</html>