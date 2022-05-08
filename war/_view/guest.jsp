<!DOCTYPE html>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

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
    
    <style>
body {
  background-image: url('https://t4.ftcdn.net/jpg/01/82/63/99/360_F_182639993_rMROh0oukAWLmLtpBw0PyBDg6UYNilZP.jpg');
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
        <h1><center><p style="color: white">Guest Sign In</p></center></h1>
	   <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        <br>
        
		<form action="${pageContext.servletContext.contextPath}/guest" method="post">
			<center><table><center>
				<tr><center>
					<center><td class="label"><p style="color: white">What is your name?:</p></td></center>
					<center><td><input type="text" name="guestName" size="12" value="${guest.guestName}" /></td></center>
				</center></tr>
                 
			</center></table></center>
            <br>
			<center><input type="Submit" name="submit" value="CONTINUE!"></center>
		</form>
        <br>
		          <center><a href="http://localhost:8081/MineSweeper/signUp"><h3><p style="color: aquamarine;">There's still time to make an account!!</p></h3> </a></center>
        
                <br>
        <img src="https://www.bluebird-electric.net/submarines/submarine_pictures/naval-mine-self-contained-explosive-device-floating-in-the-sea-to-destroy-ships-or-submarines.jpg" alt="Flag" width="250" height="200">
        <img align="right" src="https://thumbs.gfycat.com/DefiantVigorousCats-max-1mb.gif" alt="Flag" width="250" height="200">
        
	</body>
</html>