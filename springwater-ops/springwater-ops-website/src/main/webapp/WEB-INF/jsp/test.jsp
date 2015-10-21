<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      th:include="template :: page">
      
    <head th:fragment="header">
		<link  type="text/css" rel="stylesheet" href="css/Landing.css" />
	<title>NB Gardens</title>
    </head>
    <body>
    
<div th:fragment="content">

<div class="panel panel-default">
		
			<div class = "jumbotron">
		
			<h2> Welcome to NB Gardens</h2>
			
			<h4>NB Gardens specialises in high quality gnomes and other garden furniture.</h4>
		
		</div>	
		
	</div>	


		
		<div id="carousel-main" class="carousel slide" data-ride="carousel">
		
		  <div class="carousel-inner">
		  
		    <div class="item active">
		      <img src="ImageFolder/fishing.jpg" alt="..."/>
		      <div class="carousel-caption">
		        ...
		      </div>
		    </div>
		    
		    <div class="item">
		      <img src="ImageFolder/trek.jpg" alt="..."/>
		      <div class="carousel-caption">
		      </div>
		    </div>
		    
		  </div>
		
		  <a class="left carousel-control" href="#carousel-main" data-slide="prev">
		    <span class="glyphicon glyphicon-chevron-left"></span>
		    <span class="sr-only">Previous</span>
		  </a>
		  <a class="right carousel-control" href="#carousel-main" data-slide="next">
		    <span class="glyphicon glyphicon-chevron-right"></span>
		    <span class="sr-only">Next</span>
		  </a>
		</div>
		
	<div id = "left-panel">
		
		
		<div class = "jumbotron jumbotron-bottom">
		
		
			
			<h4></h4>
		
		</div>
		
		<div id="carousel-left" class="carousel slide" data-ride="carousel">
		
		  <div class="carousel-inner">
		  
		    <div class="item active">
		    	<h3>Special Offers</h3>
		    </div>
		    
			<div class="item" th:each="product : ${offerProducts}">
		      <img th:src="'ImageFolder/' + ${product.image}" th:alt="${product.productName}"/>
		    </div>
		    
		  </div>
		
		  <a class="left carousel-control" href="#carousel-left" data-slide="prev">
		    <span class="glyphicon glyphicon-chevron-left"></span>
		    <span class="sr-only">Previous</span>
		  </a>
		  <a class="right carousel-control" href="#carousel-left" data-slide="next">
		    <span class="glyphicon glyphicon-chevron-right"></span>
		    <span class="sr-only">Next</span>
		  </a>
		  
		</div>
		
		
	</div>


	<div id = "right-panel">
			    
		<div class = "jumbotron jumbotron-bottom">
		
		
			
			<h4></h4>
		
		</div>

		<div id="carousel-right" class="carousel slide" data-ride="carousel">
		
		  <div class="carousel-inner">

		    <div class="item active">
		    	<h3>Discontinued</h3>
		    </div>
		    
		    <div class="item" th:each="product : ${discontinuedProducts}">
		      <img th:src="'ImageFolder/' + ${product.image}" th:alt="${product.productName}"/>
		    </div>
		    
		  </div>
		
		  <a class="left carousel-control" href="#carousel-right" data-slide="prev">
		    <span class="glyphicon glyphicon-chevron-left"></span>
		    <span class="sr-only">Previous</span>
		  </a>
		  <a class="right carousel-control" href="#carousel-right" data-slide="next">
		    <span class="glyphicon glyphicon-chevron-right"></span>
		    <span class="sr-only">Next</span>
		  </a>
		</div>
	
	
	</div>
        </div>
    </body>
</html>