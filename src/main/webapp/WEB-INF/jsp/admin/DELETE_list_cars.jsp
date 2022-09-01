<%@ page pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>

<html>

<c:set var="title" value="Cars" scope="page" />
<%@ include file="/WEB-INF/jspf/head.jspf"%>

<body>
	<table id="main-container">

		<%@ include file="/WEB-INF/jspf/header.jspf"%>

		<tr>
			<td class="contentT">
				<%-- CONTENT --%> <c:choose>
					<c:when test="${fn:length(carsList) == 0}">No such cars</c:when>

					<c:otherwise>
						<table id="list_car_table">

							<c:forEach var="car" items="${carsList}">

								<img
									style="background: url('images/cars/id${car.id}/2.jpg'); width:330px; height:200px; border: 0px; border-radius:20px; -webkit-border-radius:20px; -moz-border-radius:20px;">
								<p>№ ${car.id} |  Name: ${car.name} |  Mark: ${car.mark} | Class: ${car.carClass} |
									Price: ${car.price} | Price with driver: ${car.driverPrice}.</p>

							</c:forEach>
						</table>
					</c:otherwise>
				</c:choose> <%-- CONTENT --%>
			</td>
		</tr>

		<%@ include file="/WEB-INF/jspf/footer.jspf"%>

	</table>
</body>
</html>