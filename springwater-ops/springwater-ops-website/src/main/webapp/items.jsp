<!DOCTYPE HTML>
<html lang="en">

<head>
    <title>NB Gardens - Items</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script src="resources/Bootstrap/js/bootstrap.js" type="text/javascript"></script>
    <link href="resources/Bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="resources/Bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="resources/main.css" rel="stylesheet">
    <link href="resources/collapse.css" rel="stylesheet">
</head>

<body>
    
    <!-- Navbar -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.jsp">NBGardens</a>
            </div>

            <!-- Navbar items that collaspe into toggle menu -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-th" aria-hidden="true"></span> Categories<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="items.jsp">Gnomes</a></li>
                            <li><a href="items.jsp">Furniture</a></li>
                            <li><a href="items.jsp">Tools</a></li>
                            <li><a href="items.jsp">Pottery</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="items.jsp">Featured</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="items.jsp">Most Popular</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="items.jsp">Wishlist Items</a></li>
                        </ul>
                    </li>
                </ul>

                <form class="navbar-form navbar-left" role="search">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search for...">
                        <span class="input-group-btn"><button class="btn btn-default" type="button"><span class="glyphicon glyphicon-search" aria-hidden="true"></span> Search</button>
                        </span>
                    </div>
                </form>

                <form class="navbar-form navbar-right" role="search">
                    <a href="#" class="btn btn-danger"><span class="glyphicon glyphicon-star" aria-hidden="true"></span> Wish List <span class="badge">0</span></a>
                    <a href="basket.jsp" class="btn btn-info"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> Basket <span class="badge">0</span></a>
                    <a href="loginRegister.jsp" type="submit" class="btn btn-success"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Login</a>
                    <a href="loginRegister.jsp" class="btn btn-primary"><span class="glyphicon glyphicon-tasks" aria-hidden="true"></span> Register</a>
                </form>
            </div>
            <!-- END OF COLLASPE AREA -->
        </div>
    </nav>
    
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
                            <input type="text" class="form-control" placeholder="Search for an item...">
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

      		</div>  
        
            <!-- Right Column -->
      		<div class="col-md-9" id="rightCol">
                <!-- Item Grid -->
                <!-- Header -->
                <div class="col-lg-12">
                    <h2 id="productTitle">Category / Search Results</h2>
                </div>
            
                <!-- Item -->
                <div class="col-lg-3 col-md-3 col-xs-4 thumb">
                    <a class="thumbnail" href="itemPage.jsp">
                    <img class="img-responsive" src="resources/img/gnome.jpg" id="itemThumb" alt="">
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
                
                <!-- Item -->
                <div class="col-lg-3 col-md-3 col-xs-4 thumb">
                    <a class="thumbnail" href="itemPage.jsp">
                    <img class="img-responsive" src="resources/img/gnome02.jpg" id="itemThumb" alt="">
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
                
                <!-- Item -->
                <div class="col-lg-3 col-md-3 col-xs-4 thumb">
                    <a class="thumbnail" href="itemPage.jsp">
                    <img class="img-responsive" src="resources/img/gnome03.jpg" id="itemThumb" alt="">
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
                
                <!-- Item -->
                <div class="col-lg-3 col-md-3 col-xs-4 thumb">
                    <a class="thumbnail" href="itemPage.jsp">
                    <img class="img-responsive" src="resources/img/gnome04.jpg" id="itemThumb" alt="">
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
                
                <!-- Item -->
                <div class="col-lg-3 col-md-3 col-xs-4 thumb">
                    <a class="thumbnail" href="itemPage.jsp">
                    <img class="img-responsive" src="resources/img/gnome05.jpg" id="itemThumb" alt="">
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
                
                <!-- Item -->
                <div class="col-lg-3 col-md-3 col-xs-4 thumb">
                    <a class="thumbnail" href="itemPage.jsp">
                    <img class="img-responsive" src="resources/img/gnome06.jpg" id="itemThumb" alt="">
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
                
                <!-- Item -->
                <div class="col-lg-3 col-md-3 col-xs-4 thumb">
                    <a class="thumbnail" href="itemPage.jsp">
                    <img class="img-responsive" src="resources/img/jacuzzi01.png" id="itemThumb" alt="">
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
                
                <!-- Item -->
                <div class="col-lg-3 col-md-3 col-xs-4 thumb">
                    <a class="thumbnail" href="itemPage.jsp">
                    <img class="img-responsive" src="resources/img/jacuzzi02.jpg" id="itemThumb" alt="">
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
                
                <!-- Item -->
                <div class="col-lg-3 col-md-3 col-xs-4 thumb">
                    <a class="thumbnail" href="itemPage.jsp">
                    <img class="img-responsive" src="resources/img/jacuzzi04.png" id="itemThumb" alt="">
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
                
                <!-- Item -->
                <div class="col-lg-3 col-md-3 col-xs-4 thumb">
                    <a class="thumbnail" href="itemPage.jsp">
                    <img class="img-responsive" src="resources/img/hoe01.jpg" id="itemThumb" alt="">
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
                
                <!-- Item -->
                <div class="col-lg-3 col-md-3 col-xs-4 thumb">
                    <a class="thumbnail" href="itemPage.jsp">
                    <img class="img-responsive" src="resources/img/hoe2.jpg" id="itemThumb" alt="">
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
                
                <!-- Item -->
                <div class="col-lg-3 col-md-3 col-xs-4 thumb">
                    <a class="thumbnail" href="itemPage.jsp">
                    <img class="img-responsive" src="resources/img/pot01.jpg" id="itemThumb" alt="">
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
                
                <!-- Item -->
                <div class="col-lg-3 col-md-3 col-xs-4 thumb">
                    <a class="thumbnail" href="itemPage.jsp">
                    <img class="img-responsive" src="resources/img/pot02.JPG" id="itemThumb" alt="">
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
                
                <!-- Item -->
                <div class="col-lg-3 col-md-3 col-xs-4 thumb">
                    <a class="thumbnail" href="itemPage.jsp">
                    <img class="img-responsive" src="resources/img/pot03.jpg" id="itemThumb" alt="">
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
    
    <!-- Footer -->
    <div class="jumbotron" id="searchBar">
        <div class="container">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-2 whiteText">
                    <a href="aboutus.jsp"><p class="whiteText"><span class="glyphicon glyphicon-book" aria-hidden="true"></span> About</p></a>
                </div>
                <div class="col-md-2 whiteText">
                    <a href="contact.jsp"><p class="whiteText"><span class="glyphicon glyphicon-globe" aria-hidden="true"></span> Contact</p></a>
                </div>
                <div class="col-md-2 whiteText">
                    <a href="faq.jsp"><p class="whiteText"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span> FAQ</p></a>
                </div>
                <div class="col-md-3"></div>
            </div>
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6 whiteText">
                    <div id="paymentDiv">
                        <p><span class="glyphicon glyphicon-credit-card" aria-hidden="true"></span> We only accept <a href="http://www.paypal.com/"><img src="https://www.paypalobjects.com/webstatic/i/logo/rebrand/ppcom-white.svg" style="width:25%;height:auto"></a> as a payment option</p>
                    </div>
                </div>
                <div class="col-md-3"></div>
            </div>
        </div>
    </div>
    
</body>
    
    <!-- JQuery script -->
    <script src="Bootstrap/js/jquery.js"></script>
    
    <!-- Bootstrap script -->
    <script src="BootStrap/js/bootstrap.js" type="text/javascript"></script>

</html>