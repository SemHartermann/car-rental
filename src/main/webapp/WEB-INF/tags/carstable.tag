
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ attribute name="id" required="true"%>
<%@ attribute name="model" required="true"%>
<%@ attribute name="mark" required="true"%>
<%@ attribute name="carClass" required="true"%>
<%@ attribute name="price" required="true"%>
<%@ attribute name="driverPrice" required="true"%>


<center>
	<table>
		<tr>
			<td rowspan="3" colspan="5" align="center">
			<img
				style="background: url('images/cars/id/${id}.jpg'); width:330px; height:200px; border: 0px; border-radius:20px; -webkit-border-radius:20px; -moz-border-radius:20px;">
			<td width="100px" align="center"><fmt:message key='carstable.number'/></td>
			<td width="100px" align="center"><fmt:message key='carstable.model'/></td>
			<td width="100px" align="center"><fmt:message key='carstable.mark'/></td>
			<td width="100px" align="center"><fmt:message key='carstable.class'/></td>
			<td width="100px" align="center"><fmt:message key='carstable.price'/></td>
			<td width="100px" align="center"><fmt:message key='carstable.driverPrice'/></td>
			
		</tr>
		<tr>
		<td width="100px" align="center">${id}</td>
			<td width="100px" align="center">${model}</td>
			<td width="100px" align="center">${mark}</td>
			<td width="100px" align="center">${carClass}</td>
			<td width="100px" align="center">${price}</td>
			<td width="100px" align="center">${driverPrice}</td>
		</tr>
		</table>
</center>

<p>