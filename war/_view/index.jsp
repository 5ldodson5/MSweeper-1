<!doctype html>
<html lang="en">
  <head>
		<title>Index view</title>
        <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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

        <h1><center>Leaderboards!</center></h1>
        <br>
        <br>
        
        <div id="myCarousel" class="carousel slide text-center" data-ride="carousel">
          
          <ol class="carousel-indicators">
            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
            <li data-target="#myCarousel" data-slide-to="1"></li>
            <li data-target="#myCarousel" data-slide-to="2"></li>
          </ol>
            
        <div class="carousel-inner" role="listbox">
            <div class="item active">
            <h2>EASY!</h2>
            <h3><center>1. ${userOne}</center></h3>
        <h3><center>${timeOne} Seconds</center></h3>
        <h3><center>2. ${userTwo}</center></h3>
        <h3><center>${timeTwo} Seconds</center></h3>
        <h3><center>3. ${userThree}</center></h3>
        <h3><center>${timeThree} Seconds</center></h3>
        <h3><center>4. ${userFour}</center></h3>
        <h3><center>${timeFour} Seconds</center></h3>
        <h3><center>5. ${userFive}</center></h3>
        <h3><center>${timeFive} Seconds</center></h3>
            </div>
            
            <div class="item">
                <h2>MEDIUM!</h2>
            <h3><center>1. ${userOne}</center></h3>
        <h3><center>${timeOne} Seconds</center></h3>
        <h3><center>2. ${userTwo}</center></h3>
        <h3><center>${timeTwo} Seconds</center></h3>
        <h3><center>3. ${userThree}</center></h3>
        <h3><center>${timeThree} Seconds</center></h3>
        <h3><center>4. ${userFour}</center></h3>
        <h3><center>${timeFour} Seconds</center></h3>
        <h3><center>5. ${userFive}</center></h3>
        <h3><center>${timeFive} Seconds</center></h3>
            </div>
            
            <div class="item">
                <h2>HARD!</h2>
            <h3><center>1. ${userOne}</center></h3>
        <h3><center>${timeOne} Seconds</center></h3>
        <h3><center>2. ${userTwo}</center></h3>
        <h3><center>${timeTwo} Seconds</center></h3>
        <h3><center>3. ${userThree}</center></h3>
        <h3><center>${timeThree} Seconds</center></h3>
        <h3><center>4. ${userFour}</center></h3>
        <h3><center>${timeFour} Seconds</center></h3>
        <h3><center>5. ${userFive}</center></h3>
        <h3><center>${timeFive} Seconds</center></h3>
            </div>
          </div>
         <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>   
        
            
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
        
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>

        
	</body>
</html>
