<!DOCTYPE HTML>
<html>

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
    
    <!-- NavBar -->
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="container-fluid">
            
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">NBGardens</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-th" aria-hidden="true"></span> Categories<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Action</a></li>
                            <li><a href="#">Another action</a></li>
                            <li><a href="#">Something else here</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">Separated link</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">One more separated link</a></li>
                        </ul>
                    </li>
                </ul>

                <form class="navbar-form navbar-left" role="search">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Search for...">
                        <span class="input-group-btn"><button class="btn btn-default" type="button"><span class="glyphicon glyphicon-search" aria-hidden="true"></span> Search</button>
                        </span>
                    </div>
                    
                    <!-- /input-group -->
                </form>

                <form class="navbar-form navbar-right" role="search">
                    <button class="btn btn-danger"><span class="glyphicon glyphicon-star" aria-hidden="true"></span> Wish List <span class="badge">0</span></button>
                    <button class="btn btn-info"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> Basket <span class="badge">0</span></button>
                    <button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Login</button>
                    <button class="btn btn-primary"><span class="glyphicon glyphicon-tasks" aria-hidden="true"></span> Register</button>
                </form>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

    <!-- Page Content -->
    <div class="jumbotron content">
    
        <!-- ******************************* Carousel Gnome Featured ************************************* -->
        <div class="container-fluid">
            <div class="row">
                    
                <!-- Left Panel -->
                <div class="col-lg-4">
                    <div class="well">
                        <a class="thumbnail" href="#">
                    <img class="img-responsive" src="resources/img/logo.png" alt="">
                    </a>
                        <div class="panel panel-default">
                            <div class="panel-body">
                                Enter a description here.
                            </div>
                        </div>
                    </div>
                </div>

                <!-- Right Panel -->
                <!-- Gnome Featured Carousel -->
                <div class="col-lg-8">
                    <h1>Featured Items</h1>

                    <div id="carousel-featured" class="carousel slide" data-ride="carousel">

                        <ol class="carousel-indicators">
                            <li data-target="#carousel-featured" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-featured" data-slide-to="1"></li>
                            <li data-target="#carousel-featured" data-slide-to="2"></li>
                        </ol>

                        <div class="carousel-inner" role="listbox">
                            <!-- Gnome Carousel Images -->
                            <div class="item active">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <a class="thumbnail" href="#"><img class="img-responsive" src="resources/img/gnome.jpg" alt=""></a> 
                                        </div>
                                        <div class="col-lg-6">
                                            <a class="thumbnail" href="#"><img class="img-responsive" src="resources/img/gnome02.jpg" alt=""></a>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <!-- Carousel Control Buttons -->
                        <a class="left carousel-control" href="#carousel-featured" role="button" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#carousel-featured" role="button" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
                    
            </div>
        <!-- /container -->
        </div>

        
        <div class="container-fluid">
            <div class="rows">
                
                <!-- Most Popular Carousel -->
                <div class="col-lg-6">
                    <h2>Most Popular Items</h2>

                    <div id="carousel-featured" class="carousel slide" data-ride="carousel">

                        <ol class="carousel-indicators">
                            <li data-target="#carousel-featured" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-featured" data-slide-to="1"></li>
                            <li data-target="#carousel-featured" data-slide-to="2"></li>
                        </ol>

                        <div class="carousel-inner" role="listbox">
                            <!-- Gnome Carousel Images -->
                            <div class="item active">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <a class="thumbnail" href="#"><img class="img-responsive" src="resources/img/gnome.jpg" alt=""></a> 
                                        </div>
                                        <div class="col-lg-6">
                                            <a class="thumbnail" href="#"><img class="img-responsive" src="resources/img/gnome02.jpg" alt=""></a>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <!-- Carousel Control Buttons -->
                        <a class="left carousel-control" href="#carousel-featured" role="button" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#carousel-featured" role="button" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
                
                <!-- Your Wishlist Carousel -->
                <div class="col-lg-6">
                    <h2>Items On Your Wishlist</h2>

                    <div id="carousel-featured" class="carousel slide" data-ride="carousel">

                        <ol class="carousel-indicators">
                            <li data-target="#carousel-featured" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-featured" data-slide-to="1"></li>
                            <li data-target="#carousel-featured" data-slide-to="2"></li>
                        </ol>

                        <div class="carousel-inner" role="listbox">
                            <!-- Gnome Carousel Images -->
                            <div class="item active">
                                <div class="container">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <a class="thumbnail" href="#"><img class="img-responsive" src="resources/img/gnome.jpg" alt=""></a> 
                                        </div>
                                        <div class="col-lg-6">
                                            <a class="thumbnail" href="#"><img class="img-responsive" src="resources/img/gnome02.jpg" alt=""></a>
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <!-- Carousel Control Buttons -->
                        <a class="left carousel-control" href="#carousel-featured" role="button" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#carousel-featured" role="button" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>   
                </div>
            </div>
        <!-- /container -->
        </div>

</div>

    <!-- Footer -->
    <div class="jumbotron" id="searchBar">
        <div class="container">
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-2 whiteText">
                    <p><span class="glyphicon glyphicon-book" aria-hidden="true"></span> About</p>
                </div>
                <div class="col-md-2 whiteText">
                    <p><span class="glyphicon glyphicon-globe" aria-hidden="true"></span> Contact</p>
                </div>
                <div class="col-md-2 whiteText">
                    <p><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span> FAQ</p>
                </div>
                <div class="col-md-3"></div>
            </div>
            <div class="row">
                <div class="col-md-3"></div>
                <div class="col-md-6 whiteText">
                    <div id="paymentDiv">
                        <p><span class="glyphicon glyphicon-credit-card" aria-hidden="true"></span> We only accept <img src="https://www.paypalobjects.com/webstatic/i/logo/rebrand/ppcom-white.svg" style="width:25%;height:auto"> as a payment option</p>
                    </div>
                </div>
                <div class="col-md-3"></div>
            </div>
        </div>
    </div>

</body>

</html>