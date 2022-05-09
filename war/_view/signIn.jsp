<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<html>
	<head>
		<title>Returning User Sign In</title>
		<style type="text/css">
		.error {
			color: red;
		}
		
		td.label {
			text-align: right;
		}
		</style>
	</head>
    
       <style>
body {
  background-image: url('https://t4.ftcdn.net/jpg/03/91/41/73/360_F_391417314_EW79DbYOwbBCjmmHqchcIJtDlPO522n7.jpg');
     background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}
</style>
    
    
	<body>
		<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
        <a href="http://localhost:8081/MineSweeper/startPage"><h5>Go Back!</h5> </a>
        <br><br><br><br><br>
        <h1><center><p style="color: orange">Sign In!</p></center></h1>
	       <br><br><br><br><br><br>
		<form action="${pageContext.servletContext.contextPath}/signIn" method="post">
			<center><table>
				<tr>
					<td class="label"><p style="color: orange">Username:</p></td>
					<td><input type="text" name="username" size="12" value="${signIn.username}" /></td>
				</tr>
				<tr>
					<td class="label"><p style="color: orange">Password:</p></td>
					<td><input type="password" name="password" size="12" value="${signIn.password}" /></td>
				</tr>
                
			</table></center>
			<center><input type="Submit" name="submit" value="Login!"></center>
		</form>
	</body>
</html>