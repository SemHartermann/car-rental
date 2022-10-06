<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>

<c:set var="title" value="addCar" scope="page"/>
<%@ include file="/WEB-INF/jspf/head.jspf" %>

<body>

<div class="content">


    <%-- HEADER --%>
    <%@ include file="/WEB-INF/jspf/header.jspf" %>
    <%-- HEADER --%>

    <div class="align-items-center">

        <form id="login_form" action="controller" method="post">

            <input type="hidden" name="command" value="addCar"/>
            <fieldset>
                <legend><fmt:message key='add_car.name'/></legend>
                <input name="name" required pattern="\w{3,20}" maxlength="20"
                       title="from 3 to 20 symbols (Latin alphabet, numbers)"/><br/>
            </fieldset>
            <br/>

            <fieldset>
                <legend><fmt:message key='add_car.mark'/></legend>
                <input name="mark" required pattern="\w{3,20}" maxlength="20"
                       title="from 3 to 20 symbols (Latin alphabet, numbers)"/>
            </fieldset>
            <br/>

            <fieldset>
                <legend><fmt:message key='add_car.class'/></legend>
                <input name="carClass" required pattern="\w{1,5}" maxlength="5"
                       title="from 1 to 5 symbols (Latin alphabet, numbers)"/>
            </fieldset>
            <br/>

            <fieldset>
                <legend><fmt:message key='add_car.price'/></legend>
                <input name="carPrice" required pattern="\d{1,10}" min="0" max="2147483647"
                       title="Only numbers, max=2147483647"/>
            </fieldset>
            <br/>

            <fieldset>
                <legend><fmt:message key='add_car.priceDriver'/></legend>
                <input name="driverPrice" required pattern="\d{1,10}" min="0" max="2147483647"
                       title="Only numbers, max=2147483647"/>
            </fieldset>
            <br/>

            <input type="submit" value="<fmt:message key='add_car.button'/>"/>
        </form>
        <%--<form action="/webapp/images/cars/id" method="post" enctype="multipart/form-data">
            <input type="file" name="car"/>
            <input type="text" name="filename"/>
            <input type="submit" value="Download"/>
        </form>--%>

    </div>


    <%@ include file="/WEB-INF/jspf/footer.jspf" %>

</div>
</body>
</html>