<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" value="Login"/>
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>

    <%@ include file="/WEB-INF/jspf/header.jspf" %>


    <div class="content">
        <div class="m-5">
            <form id="login_form" action="controller" method="post">
                <input type="hidden" name="command" value="login"/>

                <div class="row-cols-4">
                    <label for="email" class="col-form-label-lg"><fmt:message key='login.email'/></label>
                </div>
                <div class="row-cols-4">
                    <input type="email" class="form-control-lg" id="email"
                           name="email" required pattern=".{3,20}" maxlength="20"
                           title="enter your email" placeholder="enter your email">
                </div>
                <div class="row-cols-4">
                    <label for="password" class="col-form-label-lg"><fmt:message key='login.password'/></label>
                </div>
                <div class="row-cols-4">
                    <input type="password" class="form-control-lg"
                           required pattern=".{3,20}" maxlength="20" name="password"
                           title="enter your password" id="password" placeholder="enter your password">
                    <br>
                </div>
                <div class="row-cols-4">
                    <p></p>
                    <input class="btn btn-dark " id="submit" type="submit" value="Login">
                </div>
            </form>
        </div>
        <%@ include file="/WEB-INF/jspf/footer.jspf" %>
    </div>

</body>
</html>