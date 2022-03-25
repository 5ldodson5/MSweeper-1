<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Guest Sign In</title>
		<style type="text/css">
		.error {
			color: red;
		}
		
		td.label {
			text-align: right;
		}
		</style>
	</head>

	<body>
		<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
	
		<form action="${pageContext.servletContext.contextPath}/guest" method="post">
			<table>
				<tr>
					<td class="label">What is your name?:</td>
					<td><input type="text" name="first" size="12" value="${guest.name}" /></td>
				</tr>
			</table>
			<input type="Submit" name="submit" value="Guest name!">
		</form>
	</body>
</html>