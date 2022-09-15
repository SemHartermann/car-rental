<%@ page pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jspf/directive/page.jspf" %>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf" %>

<html>
<%-- head start --%>
<c:set var="title" value="Cars"/>
<%@ include file="/WEB-INF/jspf/head.jspf" %>
<%--	head end  --%>
<body>
<table id="main-container">
    <%@ include file="/WEB-INF/jspf/header.jspf" %>

    <tr>
        <td class="content center">

            <form>
                <input type="hidden" name="command" value="availableCarsList"/>
                <select name="sort">
                    <option value="name"><fmt:message key='list_available_cars.name'/></option>
                    <option value="price"><fmt:message key='list_available_cars.price'/></option>
                </select>
                <input type="hidden" name="command" value="selectCarsSel"/>
                <select
                        name="selectionByClass">
                    <c:forEach var="carClass" items="${selectCarsClass}">
                        <option value="${carClass}">${carClass}</option>
                    </c:forEach>
                </select>
                <input type="hidden" name="command" value="selectCarsSel"/>
                <select
                        name="selectionByMark">

                    <c:forEach var="carMark" items="${selectCarsMark}">
                        <option value="${carMark}">${carMark}</option>
                    </c:forEach>
                </select>
                <p>
                    <input type="submit" value="<fmt:message key='list_available_cars.sort'/>"/>
                </p>
            </form>


            <table>

                <tr>
                    <td width="100px" align="center"><fmt:message key='carstable.img'/></td>
                    <td width="100px" align="center"><fmt:message key='carstable.number'/></td>
                    <td width="100px" align="center"><fmt:message key='carstable.model'/></td>
                    <td width="100px" align="center"><fmt:message key='carstable.mark'/></td>
                    <td width="100px" align="center"><fmt:message key='carstable.class'/></td>
                    <td width="100px" align="center"><fmt:message key='carstable.price'/></td>
                    <td width="100px" align="center"><fmt:message key='carstable.driverPrice'/></td>

                </tr>
                <c:if test="${fn:length(param.sort) > 0}">
                    <c:forEach var="car" items="${availableCarsList}">

                        <tr>
                            <td><img style="background: url('images/cars/id/${car.id}.jpg'); width:330px; height:200px;
                                    border: 0px; border-radius:20px; -webkit-border-radius:20px; -moz-border-radius:20px;">
                            </td>
                            <td width="100px" align="center">${car.id}</td>
                            <td width="100px" align="center">${car.model}</td>
                            <td width="100px" align="center">${car.mark}</td>
                            <td width="100px" align="center">${car.carClass}</td>
                            <td width="100px" align="center">${car.price}</td>
                            <td width="100px" align="center">${car.driverPrice}</td>
                        </tr>

                    </c:forEach>
                </c:if>
                <c:forEach var="car" items="${availableCarsListById}">
                    <tr>
                        <td><img style="background: url('images/cars/id/${car.id}.jpg'); width:330px; height:200px;
                                border: 0px; border-radius:20px; -webkit-border-radius:20px; -moz-border-radius:20px;">
                        </td>
                        <td width="100px" align="center">${car.id}</td>
                        <td width="100px" align="center">${car.model}</td>
                        <td width="100px" align="center">${car.mark}</td>
                        <td width="100px" align="center">${car.carClass}</td>
                        <td width="100px" align="center">${car.price}</td>
                        <td width="100px" align="center">${car.driverPrice}</td>
                        <td width="100px" align="center">
                            <form action="controller?command=viewAddUserInfo" method="post">
                                <input type="hidden" name="carId" value="${car.id}"/>
                                <div class="col">
                                    <input class="btn btn-outline-dark" type="submit" value="<fmt:message
									key='add_client_info.header'/>">
                                </div>
                            </form>
                        </td>
                    </tr>
                </c:forEach>

            </table>

            <%@ include file="/WEB-INF/jspf/footer.jspf" %>
</table>

<%--END BODY CLASS
<c:forEach var="car" items="${availableCarsListById}">

                   <myT:carstable id="${car.id}"
                                  driverPrice="${car.driverPrice}"
                                  model="${car.model}" price="${car.price}"
                                  carClass="${car.Carclass}" mark="${car.mark}" />

               </c:forEach>
               &lt;%&ndash; CONTENT &ndash;%&gt;
                &lt;%&ndash;	Cars sorting form  &ndash;%&gt;
                <c:if test="${fn:length(param.sort) > 0}">
                   <c:forEach var="car" items="${availableCarsList}">

                       <myT:carstable driverPrice="${car.driverPrice}"
                           model="${car.model}" price="${car.price}"
                           carClass="${car.carClass}" mark="${car.mark}" id="${car.id}"/>

                   </c:forEach>
               </c:if>

footer end --%>
</body>
</html>

