<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      th:include="template :: page">

<head th:fragment="header">
    <title>NB Gardens - Items</title>   
    <script src="js/search.js" type="text/javascript"></script>
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
                            <a class="btn btn-default" type="button"><span class="glyphicon glyphicon-search" aria-hidden="true" onclick="search(); "></span></a>
                            </span>
                        </div>
                    </li>
                    
                    <li>
                        <div class="form-group">
                            <label for="colour">Colour:</label>
                            <select class="form-control" id="colour">
                                <option></option>
                                <option>Blue</option>
                                <option>Green</option>
                                <option>Yellow</option>
                                <option>Red</option>
                                <option>Grey</option>
                                <option>White</option>
                            </select>
                        </div>
                    </li >
                    
                    <li>
                        <div class="form-group">
                            <label for="category">Category:</label>
                            <select class="form-control" id="category">
                                <option></option>
                                <option>Gnome</option>
                                <option>Furniture</option>
                                <option>Tool</option>
                                <option>Pottery</option>
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
                    
                    <!-- Filter Box -->
                    <li>
                        <div class="list-group panel">
                            <a href="#Filter" class="list-group-item strong" data-toggle="collapse" data-parent="#FilterMenu">Filter results<i class="fa fa-caret-down"></i></a>
                            <div class="collapse" id="Filter">
                                <a href="#ColourMenu" class="list-group-item strong" data-toggle="collapse" data-parent="#ColourMenu">Colour<i class="fa fa-caret-down"></i></a>
                                <div class="collapse list-group-submenu" id="ColourMenu">
                                    <a href="#" class="list-group-item" data-parent="#ColourMenu">
                                        <a th:href="@{/items(colour=Blue)}" class="btn btn-primary" type="button" id="BlueButton"></a>
                                        <a th:href="@{/items(colour=Green)}" class="btn btn-success" type="button" id="GreenButton"></a>
                                        <a th:href="@{/items(colour=Yellow)}" class="btn btn-warning" type="button" id="YellowButton"></a>
                                        <a th:href="@{/items(colour=Red)}" class="btn btn-danger" type="button" id="RedButton"></a>
                                        <a th:href="@{/items(colour=Grey)}" class="btn" style="background:gray" type="button" id="GreyButton"></a>
                                        <a th:href="@{/items(colour=White)}" class="btn btn-default btn-outline" type="button" id="WhiteButton"></a>

                                    </a>
                                </div>
                                <a href="#CategoryMenu" class="list-group-item strong" data-toggle="collapse" data-parent="#CategoryMenu">Category<i class="fa fa-caret-down"></i></a>
                                <div class="collapse list-group-submenu" id="CategoryMenu">
                                    <a th:href="@{/items(category=Gnome)}" class="list-group-item" data-parent="#CategoryMenu">Gnomes</a>
                                    <a th:href="@{/items(category=Furniture)}" class="list-group-item" data-parent="#CategoryMenu">Furniture</a>
                                    <a th:href="@{/items(category=Tool)}" class="list-group-item" data-parent="#CategoryMenu">Tools</a>
                                    <a th:href="@{/items(category=Pottery)}" class="list-group-item" data-parent="#CategoryMenu">Pottery</a>
                                </div>
                            </div>
                        </div>
                    </li>
              	</ul>
  				</div>
  				
  				<button onclick="updateItemCount()">Update Cart</button>

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
                        <a class="thumbnail" th:href="'itempage+' + ${item.itemID}">
                        <img class="img-responsive" th:src="${item.imageLocation}" id="itemThumb" alt="" />
                        </a>
                        <h4 style="text-align:center" id="supersubtitle"><p id="itemName" th:text="${item.itemName}"/></h4>
                        <h4 style="text-align:center" id="supersubtitle"><p id="itemPrice" th:text="'£' + ${item.price}" /></h4>
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