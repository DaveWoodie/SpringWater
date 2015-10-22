<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      th:include="template :: page">

<head th:fragment="header">
    <title>NB Gardens - Items</title>    
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
                            <input type="text" class="form-control" placeholder="Search for an item..." />
                            <span class="input-group-btn">
                            <button class="btn btn-default" type="button"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
                            </span>
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
                                        <button class="btn btn-primary" type="button" id="BlueButton"></button>
                                        <button class="btn btn-success" type="button" id="GreenButton"></button>
                                        <button class="btn btn-warning" type="button" id="YellowButton"></button>
                                        <button class="btn btn-danger" type="button" id="RedButton"></button>
                                        <button class="btn" style="background:gray" type="button" id="GreyButton"></button>
                                        <button class="btn btn-default btn-outline" type="button" id="WhiteButton"></button>

                                    </a>
                                </div>
                                <a href="#CategoryMenu" class="list-group-item strong" data-toggle="collapse" data-parent="#CategoryMenu">Category<i class="fa fa-caret-down"></i></a>
                                <div class="collapse list-group-submenu" id="CategoryMenu">
                                    <a href="#" class="list-group-item" data-parent="#CategoryMenu">Gnomes</a>
                                    <a href="#" class="list-group-item" data-parent="#CategoryMenu">Furniture</a>
                                    <a href="#" class="list-group-item" data-parent="#CategoryMenu">Tools</a>
                                    <a href="#" class="list-group-item" data-parent="#CategoryMenu">Pottery</a>
                                </div>
                            </div>
                        </div>
                    </li>
              	</ul>
  				</div>
  				
  				<button onclick="updateItemCount()">Update Cart</button>

      		</div>  
        
            <!-- Right Column -->
      		<div class="col-md-9" id="rightCol">
                <!-- Item Grid -->
                <!-- Header -->
                <div class="col-lg-12">
                    <h2 id="productTitle">Category / Search Results</h2>
                </div>
            
                <!-- Loads content into page -->
                <script th:inline="javascript">
                /*<![CDATA[*/

                    var itemList = [[${itemList}]];

                    for(var i = 0;i < itemList.length; i++) 
                    {
                        var div = document.createElement('div');
                        var a = document.createElement('a');
                        var img = document.createElement('img');
                        var text1 = document.createElement('h4');
                        var text2 = document.createElement('h4');
                        var p = document.createElement('p');
                        var style = document.createAttribute('style');
                        var id = document.createAttribute('id');
                        var href = document.createAttribute('href');
                        var text1text = document.createTextNode(itemList[i].getItemName);
                        var text2text = document.createTextNode(itemList[i].getPrice);
                        href.value = itemList[i].getImageLocation;
                        id.value = 'supersubtitle';
                        style.value = 'text-align:center';
                        div.className = 'col-lg-3 col-md-3 col-xs-4 thumb';
                        a.className = 'thumbnail';
                        img.className = 'img-responsive';
                        text1.setAttribute(id);
                        text1.setAttribute(style);
                        text2.setAttribute(style);
                        text2.setAttribute(id);
                        text1.appendChild(text1text);
                        text2.appendChild(text2text);
                        p.setAttribute(style);
                        a.innerHTML = img;
                        
                        div.innerHTML = a + text1 + text2 + p;
                    }

                /*]]>*/
                </script>
                
                <!-- Item -->
                <div class="col-lg-3 col-md-3 col-xs-4 thumb">
                    <a class="thumbnail" href="itempage">
                    <img class="img-responsive" src="img/pot03.jpg" id="itemThumb" alt="" />
                    </a>
                    <h4 style="text-align:center" id="supersubtitle">Product Name</h4>
                    <h4 style="text-align:center" id="supersubtitle">&pound;0.00</h4>
                    <p style="text-align:center">
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
</body>
</html>