<!DOCTYPE html>
<html lang="en">

<head>
    <title>NB Gardens</title>
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
                <a class="navbar-brand" href="index.jsp"><img src="resources/img/logo2.png" id="logo"></a>
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
                    <a href="wishlist.jsp" class="btn btn-danger"><span class="glyphicon glyphicon-star" aria-hidden="true"></span> Wish List <span class="badge">0</span></a>
                    <a href="basket.jsp" class="btn btn-info"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> Basket <span class="badge">0</span></a>
                    <a href="loginRegister.jsp" type="submit" class="btn btn-success"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Login</a>
                    <a href="loginRegister.jsp" class="btn btn-primary"><span class="glyphicon glyphicon-tasks" aria-hidden="true"></span> Register</a>
                </form>
            </div>
            <!-- END OF COLLASPE AREA -->
        </div>
    </nav>
    <!-- END OF NAVBAR -->

    <!-- Content Area -->
    <div class="jumbotron content">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <h2 id="productTitle">Your Wish List</h2>
                </div>
                <div class="col-lg-3"></div>
                <div class="col-lg-3">
                    <div class="panel panel-default">
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="Search for...">
                            <span class="input-group-btn"><button class="btn btn-default" type="button"><span class="glyphicon glyphicon-search" aria-hidden="true"></span> Search</button></span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="well">
                <div class="panel panel-default">
                    <!-- Table -->
                    <table class="table">

                        <!-- Wish List -->
                        <tbody>

                            <!-- Wish List Row -->
                            <tr>
                                <td><a class="thumbnail" id="wishThumb" href="itemPage.jsp"><img class="img-responsive" src="resources/img/pot03.jpg"></a></td>
                                <td id="textLine">
                                    <h2>Brown Plant Pot</h2>
                                    <h5>A brown pot, perfect for putting plants inside.</h5>
                                </td>
                                <td id="wishLine"><span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span></td>
                                <td><h2>&pound;0.00</h2></td>
                                <td id="wishLine">
                                    <button class="btn btn-block btn-warning"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span> Remove From Wish List</button>
                                </td>
                            </tr>
                            
                            <!-- Wish List Row -->
                            <tr>
                                <td><a class="thumbnail" id="wishThumb" href="itemPage.jsp"><img class="img-responsive" src="resources/img/gnome.jpg"></a></td>
                                <td id="textLine">
                                    <h2>Happy Gnome</h2>
                                    <h5>A happy looking gnome with a red hat.</h5>
                                </td>
                                <td id="wishLine"><span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span></td>
                                <td><h2>&pound;0.00</h2></td>
                                <td id="wishLine">
                                    <button class="btn btn-block btn-warning"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span> Remove From Wish List</button>
                                </td>
                            </tr>
                            
                            <!-- Wish List Row -->
                            <tr>
                                <td><a class="thumbnail" id="wishThumb" href="itemPage.jsp"><img class="img-responsive" src="resources/img/gnome05.jpg"></a></td>
                                <td id="textLine">
                                    <h2>Three Wise Gnomes</h2>
                                    <h5>A set of three wise gnomes, based on the three wise monkeys.</h5>
                                </td>
                                <td id="wishLine"><span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span></td>
                                <td><h2>&pound;0.00</h2></td>
                                <td id="wishLine">
                                    <button class="btn btn-block btn-warning"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span> Remove From Wish List</button>
                                </td>
                            </tr>
                            
                            <!-- Wish List Row -->
                            <tr>
                                <td><a class="thumbnail" id="wishThumb" href="itemPage.jsp"><img class="img-responsive" src="resources/img/jacuzzi03.jpg"></a></td>
                                <td id="textLine">
                                    <h2>Jacuzzi 5000</h2>
                                    <h5>A top of the range jacuzzi with 600 different bubble settings including an equaliser mode that bubbles to your beats.</h5>
                                </td>
                                <td id="wishLine"><span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span></td>
                                <td><h2>&pound;0.00</h2></td>
                                <td id="wishLine">
                                    <button class="btn btn-block btn-warning"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span> Remove From Wish List</button>
                                </td>
                            </tr>
                            
                            <!-- Wish List Row -->
                            <tr>
                                <td><a class="thumbnail" id="wishThumb" href="itemPage.jsp"><img class="img-responsive" src="resources/img/hoe01.jpg"></a></td>
                                <td id="textLine">
                                    <h2>Garden Tool</h2>
                                    <h5>A small garden tool with a ceramic blade.</h5>
                                </td>
                                <td id="wishLine"><span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span></td>
                                <td><h2>&pound;0.00</h2></td>
                                <td id="wishLine">
                                    <button class="btn btn-block btn-warning"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span> Remove From Wish List</button>
                                </td>
                            </tr>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <!-- END OF CONTENT -->
    
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
    <!-- END OF FOOTER -->
</body>

</html>