<!--     Chris J W Walker  -->
<!--     template.jsp -->
<!--     13/10/2015 -->
<!--     Template for website navbar and footer  -->
<!--     Last Modified by: Chris Boucher -->
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      th:fragment="page">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
        <script src="bootstrap/js/bootstrap.js" type="text/javascript"></script>
        <link href="bootstrap/css/bootstrap.css" rel="stylesheet" />
        <link href="bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" />
        <link href="main.css" rel="stylesheet" />
        <link href="collapse.css" rel="stylesheet" />
        
        <!-- Import javascript for searching -->
        <script src="js/search.js" type="text/javascript"></script>
        
        <!-- Import javaScript files for basket update -->
        <script src="js/basketUpdater.js" type="text/javascript"></script>
        
        <!-- Call the basket updater -->
		<script>
	    	basketUpdater();
	    </script>
    </head>
    
    <div th:include="this :: header"></div>
    
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
                
                <a class="navbar-brand" href="/"><img src="img/logo2.png" style="width:auto;height:25px" /></a>
                
            </div>

            <!-- Navbar items that collaspe into toggle menu -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-th" aria-hidden="true"></span> Categories<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a th:href="@{/items(category=Gnome)}">Gnomes</a></li>
                            <li><a th:href="@{/items(category=Furniture)}">Furniture</a></li>
                            <li><a th:href="@{/items(category=Tool)}">Tools</a></li>
                            <li><a th:href="@{/items(category=Pottery)}">Pottery</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a th:href="@{/items(featured=true)}">Featured</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a th:href="@{/items(mostpopular=true)}">Most Popular</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a th:href="@{/items(wishlist=true)}">Wishlist Items</a></li>
                        </ul>
                    </li>
                </ul>

                <span class="navbar-form navbar-left" role="search">
                    <div class="input-group">
                        <input type="text" class="form-control" id="searchbar" placeholder="Search for an item..."/>
                        <span class="input-group-btn"><button class="btn btn-default" type="button" onclick="searchNav();"><span class="glyphicon glyphicon-search" aria-hidden="true"></span> Search</button>
                        </span>
                    </div>
                </span>

                <form class="navbar-form navbar-right" role="search">
                    <a href="wishlist" class="btn btn-danger"><span class="glyphicon glyphicon-star" aria-hidden="true"></span> Wish List <span class="badge">0</span></a>
                    <a href="basket" class="btn btn-info"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> Basket <span class="badge" id="basketCount"></span></a>
                    <a href="loginregister" type="submit" class="btn btn-success"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Login</a>
                    <a href="loginregister" class="btn btn-primary"><span class="glyphicon glyphicon-tasks" aria-hidden="true"></span> Register</a>
                    
                    <script>
                    	document.getElementById("basketCount").innerHTML = getCookies("itemCount");
                    </script>
                </form>
            </div>
            <!-- END OF COLLASPE AREA -->
        </div>
    </nav>
    <!-- END OF NAVBAR -->

    <!-- Content Area -->
    <div th:include="this :: content"> </div>
    <!-- END OF CONTENT -->
    
    <!-- Footer -->
    <div class="jumbotron" id="searchBar">
        <div class="container">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-2 whiteText">
                    <p><a href="aboutus" class="whiteText"><span class="glyphicon glyphicon-book" aria-hidden="true"></span> About</a></p>
                </div>
                <div class="col-md-2 whiteText">
                    <p><a href="contact" class="whiteText"><span class="glyphicon glyphicon-globe" aria-hidden="true"></span> Contact</a></p>
                </div>
                <div class="col-md-2 whiteText">
                    <p><a href="faq" class="whiteText"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span> FAQ</a></p>
                </div>
                <div class="col-md-3"></div>
            </div>
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6 whiteText">
                    <div id="paymentDiv">
                        <p><span class="glyphicon glyphicon-credit-card" aria-hidden="true"></span> We only accept <a href="http://www.paypal.com/"><img src="https://www.paypalobjects.com/webstatic/i/logo/rebrand/ppcom-white.svg" style="width:25%;height:auto" /></a> as a payment option</p>
                    </div>
                </div>
                <div class="col-md-3"></div>
            </div>
        </div>
    </div>
    <!-- END OF FOOTER -->
</body>

</html>