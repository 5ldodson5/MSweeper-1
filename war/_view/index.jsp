<!DOCTYPE html>

<html>
	<head>
		<title>Index view</title>
	</head>

	<body>
        <h1><center>CHOOSE YOUR DIFFICULTY
        <c:if test="${! empty userName}">
			${userName}!
		</c:if>
		</center></h1>
        
        <br>
		<center><a href="http://localhost:8081/MineSweeper/easy"><h3>EASY DIFFICULTY!</h3> </a></center>
        <br>
        <center><a href="http://localhost:8081/MineSweeper/medium"><h3>MEDIUM DIFFICULTY!</h3> </a></center>
        <br>
        <center><a href="http://localhost:8081/MineSweeper/hard"><h3>HARD DIFFICULTY!</h3></a></center>
        
        <br>
        <br>
        <br>
        <br>
        <h1><center>HIGHSCORES</center></h1>
        
        <h2><center>1. ${userOne}</center></h2>
        <h2><center>${timeOne} Seconds</center></h2>
        <h2><center>2. ${userTwo}</center></h2>
        <h2><center>${timeTwo} Seconds</center></h2>
        <h2><center>3. ${userThree}</center></h2>
        <h2><center>${timeThree} Seconds</center></h2>
        <h2><center>4. ${userFour}</center></h2>
        <h2><center>${timeFour} Seconds</center></h2>
        <h2><center>5. ${userFive}</center></h2>
        <h2><center>${timeFive} Seconds</center></h2>
        
        
        
	</body>
</html>
