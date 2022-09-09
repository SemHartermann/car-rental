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
					<input type="hidden" name="command" value="selectCarsSel" /> <select
						name="selectionByClass">
						
						<option value="-">-</option>
						<c:forEach var="carClass" items="${selectCarsClass}">
						<option value="${carClass}">${carClass}</option>
							</c:forEach>
					</select>
					<input type="hidden" name="command" value="selectCarsSel" /> <select
						name="selectionByMark">
						<option value="-">-</option>
						<c:forEach var="carMark" items="${selectCarsMark}">
						<option value="${carMark}">${carMark}</option>
							</c:forEach>
					</select>
					<p>
						<input type="submit" value="<fmt:message key='list_selection_cars.button'/>" />
					</p>
				</form> 
					<c:forEach var="car" items="${selectCars}">

					<myT:carstable driverPrice="${car.driverPrice}" model="${car.model}" price="${car.price}"
								   carClass="${car.carClass}" mark="${car.mark}" id="${car.id}"></myT:carstable>

					</c:forEach>
				<%@ include file="/WEB-INF/jspf/footer.jspf"%>
	</table>

	<%-- END BODY CLASS--%>

	<%-- contacts and footer end --%>
</body>
</html>