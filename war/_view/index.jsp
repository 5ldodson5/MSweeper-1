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
	
    <style>
body {
  background-image: url('https://images.squarespace-cdn.com/content/v1/5497331ae4b0148a6141bd47/1533488464157-AYYS0QO7ZW0KPGOT6XRQ/underwater-sea-mine-danger-weapon-deadly-naval-ocean-sea_bpocqo-8__F0000.png?format=1500w');
     background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}
</style>
    
    
    
    <body>
        
        <h1><center><p style="color: white;">CHOOSE YOUR DIFFICULTY
        <c:if test="${! empty userName}">
            ${userName}!
		</c:if>
		</p></center></h1>
		
		
		<form action="${pageContext.servletContext.contextPath}/index" method="post">
		
		<button type="Submit" name="easy">EASY GAME!</button>
		<br>
		<button type="Submit" name="medium">MEDIUM GAME!</button>
		<br>
		<button type="Submit" name="hard">HARD GAME!</button>
		
		</form>
		
		
        <a href="http://localhost:8081/MineSweeper/startPage"><h3>SIGN OUT!</h3> </a>
        <br>

		
        <center><a href="http://localhost:8081/MineSweeper/easy" target="_parent"><button>_EASY GAME!_</button></a></center>
       
        <br>
      
      	
        <center><a href="http://localhost:8081/MineSweeper/medium" target="_parent"><button>MEDIUM GAME!</button></a></center>
        <br> 
        <center><a href="http://localhost:8081/MineSweeper/hard" target="_parent"><button> _HARD GAME!_</button></a></center>
        
        
        <br>
        <br>

        <h1><center><p style="color:white;">Leaderboards!</p></center></h1>
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

            <h2><p style="color: white;">EASY!</p></h2>
            <h3><center><p style="color:white;">1. ${userOneEasy}</p></center></h3>
            <h3><center><p style="color: white;">${timeOneEasy} Seconds</p></center></h3>
            <h3><center><p style="color: white;">2. ${userTwoEasy}</p></center></h3>
            <h3><center><p style="color: white;">${timeTwoEasy} Seconds</p></center></h3>
            <h3><center><p style="color:white;">3. ${userThreeEasy}</p></center></h3>
            <h3><center><p style="color:white;">${timeThreeEasy} Seconds</p></center></h3>
            <h3><center><p style="color: white;">4. ${userFourEasy}</p></center></h3>
            <h3><center><p style="color: white;">${timeFourEasy} Seconds</p></center></h3>
            <h3><center><p style="color:white;">5. ${userFiveEasy}</p></center></h3>
            <h3><center><p style="color: white;">${timeFiveEasy} Seconds</p></center></h3>
            <br>
            <br>
            <br>
            </div>
            
            <div class="item">

             <h2><p style="color: white;">MEDIUM!</p></h2>
            <h3><center><p style="color:white;">1. ${userOneMedium}</p></center></h3>
            <h3><center><p style="color: white;">${timeOneMedium} Seconds</p></center></h3>
            <h3><center><p style="color: white;">2. ${userTwoMedium}</p></center></h3>
            <h3><center><p style="color: white;">${timeTwoMedium} Seconds</p></center></h3>
            <h3><center><p style="color:white;">3. ${userThreeMedium}</p></center></h3>
            <h3><center><p style="color:white;">${timeThreeMedium} Seconds</p></center></h3>
            <h3><center><p style="color: white;">4. ${userFourMedium}</p></center></h3>
            <h3><center><p style="color: white;">${timeFourMedium} Seconds</p></center></h3>
            <h3><center><p style="color:white;">5. ${userFiveMedium}</p></center></h3>
            <h3><center><p style="color: white;">${timeFiveMedium} Seconds</p></center></h3>
            <br>
            <br>
            <br>
            </div>
            
            <div class="item">

             <h2><p style="color: white;">HARD!</p></h2>
            <h3><center><p style="color:white;">1. ${userOneHard}</p></center></h3>
            <h3><center><p style="color: white;">${timeOneHard} Seconds</p></center></h3>
            <h3><center><p style="color: white;">2. ${userTwoHard}</p></center></h3>
            <h3><center><p style="color: white;">${timeTwoHard} Seconds</p></center></h3>
            <h3><center><p style="color:white;">3. ${userThreeHard}</p></center></h3>
            <h3><center><p style="color:white;">${timeThreeHard} Seconds</p></center></h3>
            <h3><center><p style="color: white;">4. ${userFourHard}</p></center></h3>
            <h3><center><p style="color: white;">${timeFourHard} Seconds</p></center></h3>
            <h3><center><p style="color:white;">5. ${userFiveHard}</p></center></h3>
            <h3><center><p style="color: white;">${timeFiveHard} Seconds</p></center></h3>
            <h3><center><p style="color: white;"></p></center></h3>
             <br>
            <br>
            <br>

 
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
