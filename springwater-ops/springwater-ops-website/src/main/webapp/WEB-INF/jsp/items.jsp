<!--     Chris Boucher  -->
<!--     items.jsp -->
<!--     Page for viewing items in the catalog -->
<!--     Last Modified by: Chris Boucher -->
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      th:include="template :: page">

<head th:fragment="header">
	<title>NB Gardens - Items</title>       
     <!-- Import javaScript files for basket update -->
     <script src="js/basketUpdater.js" type="text/javascript"></script>
</head>

<body>
<div th:fragment="content">     
    <!-- Page Content -->    
    <div class="jumbotron content">
        <div class="container-fluid">
            
            <div class="row">
               
            <!-- Left Column -->   
  			<div class="col-md-2" id="leftCol">
              	
                <!-- Filter Section -->
				<div class="well"> 
                    
              	<ul class="nav nav-stacked" id="sidebar">
                    
                    <!-- Search field -->
                    <li>
                        <div class="input-group panel">                            
                            <input type="text" class="form-control" id="searchBox" placeholder="Search for an item..."/>
                            <span class="input-group-btn">
                            <button class="btn btn-default" type="button" onclick="search();"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
                            </span>
                        </div>
                    </li>
                    
                    <li>
                        <div class="form-group">
                            <label for="colour">Colour:</label>
                            <select class="form-control" id="colour">
                                <option value=""></option>
                                <option value="Blue">Blue</option>
                                <option value="Green">Green</option>
                                <option value="Yellow">Yellow</option>
                                <option value="Red">Red</option>
                                <option value="Grey">Grey</option>
                                <option value="White">White</option>
                            </select>
                        </div>
                    </li >
                    
                    <li>
                        <div class="form-group">
                            <label for="category">Category:</label>
                            <select class="form-control" id="category">
                                <option value=""></option>
                                <option value="Gnomes">Gnomes</option>
                                <option value="Furniture">Furniture</option>
                                <option value="Tools">Tools</option>
                                <option value="Pottery">Pottery</option>
                            </select>
                        </div>
                    </li>
                    
                    
                    <!-- Sort box -->
                    <li>
                        <div class="list-group panel">
                            <a href="#Sort" class="list-group-item strong" data-toggle="collapse" data-parent="#SortMenu">Sort results<i class="fa fa-caret-down"></i></a>
                            <div class="collapse" id="Sort">
                                <a href="#PriceMenu" class="list-group-item strong" data-toggle="collapse" data-parent="#PriceMenu">Price<i class="fa fa-caret-down"></i></a>
                                <div class="collapse list-group-submenu" id="PriceMenu">
                                    <a href="#" class="list-group-item" data-parent="#PriceMenu">Low - High</a>
                                    <a href="#" class="list-group-item" data-parent="#PriceMenu">High - Low</a>
                                </div>
                                <a href="#NameMenu" class="list-group-item strong" data-toggle="collapse" data-parent="#NameMenu">Name<i class="fa fa-caret-down"></i></a>
                                <div class="collapse list-group-submenu" id="NameMenu">
                                    <a href="#" class="list-group-item" data-parent="#NameMenu">A - Z</a>
                                    <a href="#" class="list-group-item" data-parent="#NameMenu">Z - A</a>
                                </div>
                                <a href="#RatingMenu" class="list-group-item strong" data-toggle="collapse" data-parent="#RatingMenu">Rating<i class="fa fa-caret-down"></i></a>
                                <div class="collapse list-group-submenu" id="RatingMenu">
                                    <a href="#" class="list-group-item" data-parent="#RatingMenu">High - Low</a>
                                    <a href="#" class="list-group-item" data-parent="#RatingMenu">Low - High</a>
                                </div>
                            </div>
                        </div>
                    </li>
              	</ul>
  				</div>

      		</div>    

            <!-- Right Column -->
            <div class="col-md-9">
                <!-- Item Grid -->
                <!-- Header -->
                <div class="col-lg-12">
                    <h2 id="productTitle">Search Results</h2>
                </div>

                <div th:each="item : ${itemList}" id="testItems">
                    <!-- Item Template-->
                    <div id ="itemTemplate" class="col-lg-3 col-md-3 col-xs-4 thumb">
                        <a class="thumbnail" th:href="@{/itempage(itemid=${item.itemID})}">
                        <img class="img-responsive" th:src="${item.imageLocation}" id="itemThumb" alt="" />
                        </a>
                        <h4 style="text-align:center" id="supersubtitle"><p id="itemName" th:text="${item.itemName}"/></h4>
                        <h4 style="text-align:center" id="supersubtitle"><p id="itemPrice" th:text="'£' + ${item.formattedPrice()}" /></h4>
                        <!-- Rating If Statement -->
                        <p th:if="${item.rating} == 0" style="text-align:center">
                            <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                        </p>
                        <p th:if="${item.rating} == 1" style="text-align:center">
                            <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                        </p>
                        <p th:if="${item.rating} == 2" style="text-align:center">
                            <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                        </p>
                        <p th:if="${item.rating} == 3" style="text-align:center">
                            <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                        </p>
                        <p th:if="${item.rating} == 4" style="text-align:center">
                            <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                        </p>
                        <p th:if="${item.rating} == 5" style="text-align:center">
                            <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        </p>
                    </div>  
                </div>
                
            </div>
        
        </div>
        </div>
    </div>  
</div>
</body>
</html>