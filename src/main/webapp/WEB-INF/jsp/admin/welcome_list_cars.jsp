<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>

<html>
<%-- head start --%>
<c:set var="title" value="Cars" />
<%@ include file="/WEB-INF/jspf/head.jspf"%>
<%--	head end  --%>
<body>
	<table id="main-container">
		<%@ include file="/WEB-INF/jspf/header.jspf"%>

		<tr>
			<td class="content center">
				<%-- CONTENT --%> <%--	Cars sorting form  --%>
				<form>
					<input type="hidden" name="command" value="carsList" /> <select
						name="sort">
						<option value="name"><fmt:message key='welcome_list_cars.name'/></option>
						<option value="price"><fmt:message key='welcome_list_cars.price'/></option>
					</select>
					<p>
						<input type="submit" value="<fmt:message key='welcome_list_cars.sort'/>" />
					</p>
				</form> <c:if test="${fn:length(param.sort) > 0}">
					<c:forEach var="car" items="${carsList}">

					<myT:carstable driverPrice="${car.driverPrice}" model="${car.model}" price="${car.price}" carClass="${car.carClass}" mark="${car.mark}" id="${car.id}"></myT:carstable>

					</c:forEach>
				</c:if>
	<%@ include file="/WEB-INF/jspf/footer.jspf"%>
	</table>

	<%-- END BODY CLASS--%>
	
	<%-- contacts and footer end --%>
</body>
</html>