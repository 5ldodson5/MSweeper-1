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
        <a href="http://localhost:8081/MineSweeper/startPage"><h3>SIGN OUT!</h3> </a>
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
            <h3><center>1. ${userOneEasy}</center></h3>
        <h3><center>${timeOneEasy} Seconds</center></h3>
        <h3><center>2. ${userTwoEasy}</center></h3>
        <h3><center>${timeTwoEasy} Seconds</center></h3>
        <h3><center>3. ${userThreeEasy}</center></h3>
        <h3><center>${timeThreeEasy} Seconds</center></h3>
        <h3><center>4. ${userFourEasy}</center></h3>
        <h3><center>${timeFourEasy} Seconds</center></h3>
        <h3><center>5. ${userFiveEasy}</center></h3>
        <h3><center>${timeFiveEasy} Seconds</center></h3>
            </div>
            
            <div class="item">
                <h2>MEDIUM!</h2>
            <h3><center>1. ${userOneMedium}</center></h3>
        <h3><center>${timeOneMedium} Seconds</center></h3>
        <h3><center>2. ${userTwoMedium}</center></h3>
        <h3><center>${timeTwoMedium} Seconds</center></h3>
        <h3><center>3. ${userThreeMedium}</center></h3>
        <h3><center>${timeThreeMedium} Seconds</center></h3>
        <h3><center>4. ${userFourMedium}</center></h3>
        <h3><center>${timeFourMedium} Seconds</center></h3>
        <h3><center>5. ${userFiveMedium}</center></h3>
        <h3><center>${timeFiveMedium} Seconds</center></h3>
            </div>
            
            <div class="item">
                <h2>HARD!</h2>
        <h3><center>1. ${userOneHard}</center></h3>
        <h3><center>${timeOneHard} Seconds</center></h3>
        <h3><center>2. ${userTwoHard}</center></h3>
        <h3><center>${timeTwoHard} Seconds</center></h3>
        <h3><center>3. ${userThreeHard}</center></h3>
        <h3><center>${timeThreeHard} Seconds</center></h3>
        <h3><center>4. ${userFourHard}</center></h3>
        <h3><center>${timeFourHard} Seconds</center></h3>
        <h3><center>5. ${userFiveHard}</center></h3>
        <h3><center>${timeFiveHard} Seconds</center></h3>
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
