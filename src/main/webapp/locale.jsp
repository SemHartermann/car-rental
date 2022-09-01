<%@ include file="/WEB-INF/jspf/directive/page.jspf"%>
<%@ include file="/WEB-INF/jspf/directive/taglib.jspf"%>

<html>

<c:set var="title" value="CarRental" scope="page" />
<%@ include file="/WEB-INF/jspf/head.jspf"%>


<head>
<title>CarRental</title>
</head>

<body>
	<table id="main-container">

		<%@ include file="/WEB-INF/jspf/header.jspf"%>

		<tr>
			<td class="content">
				<%-- CONTENT --%>
				<form>
					<input type="hidden" name="command" value="changeLocale" /> <select
						name="locale">
						<option value="ru">ru</option>
						<option value="en">en</option>

					</select>
					<p>
						<input type="submit"
							value="<fmt:message key='locale.save'/>" />
					</p>
				</form>
			</td>
		</tr>

		<%@ include file="/WEB-INF/jspf/footer.jspf"%>

	</table>

</body>
</html>