<!DOCTYPE html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>New User Sign Up!</title>
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
  background-image: url(' https://wallpapercave.com/wp/YocUFbD.jpg');
     background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}
</style>
    
    
   
    
	<body>
		<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
	       <h1><center>Sign Up!</center></h1>
        
        
        
        <br><br><br><br><br><br><br><br><br><br><br>
		<form action="${pageContext.servletContext.contextPath}/signUp" method="post">
			<center><table>
				<tr>
					<td class="label">Username:</td>
					<td><input type="text" name="username" size="12" value="${signUp.username}" /></td>
				</tr>
				<tr>
					<td class="label">Password:</td>
					<td><input type="password" name="password" size="12" value="${signUp.password}" /></td>
				</tr>
                <tr>
					<td class="label">Password Confirmation:</td>
					<td><input type="password" name="passwordCheck" size="12" value="${signUp.passwordCheck}" /></td>
				</tr>
                
			</table></center>
			<center><input type="Submit" name="submit" value="Login!"></center>
		</form>
	</body>
</html>