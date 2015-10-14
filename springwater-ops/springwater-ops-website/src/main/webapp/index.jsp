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
    
    <!-- Page Content -->
    <div class="jumbotron content">
        
        <!-- ******************************* Carousel Gnome Featured ************************************* -->        
        <div class="container-fluid">
                <div class="row">
                        <!-- Left Panel -->
                        <div class="col-lg-4">
                            <a class="thumbnail" id="carouselThumb" href="#">
                                <img class="img-responsive" src="resources/img/logo.png" alt="">
                            </a>
                            <div class="panel panel-default">
                                <div class="panel-body" style="text-align:center">
                                    Welcome to NB Gardens. We are a retailer of high quality garden products who pride ourselves in our high quality gnomes.
                                </div>
                            </div>
                        </div>
                
                        <!-- Right Panel -->
                        <div class="col-lg-8">
                                <img src="resources/img/header.jpg" class="img-responsive" style="width:auto;height:auto">
                        </div>
                </div>
        </div>
            
        <!-- Gnome Featured Carousel -->
        <div class="container-fluid">
                <h1>Featured Items</h1>
                <div class="col-lg-2">
                    <div id="carousel-featured" class="carousel slide" data-ride="carousel">

                        <ol class="carousel-indicators">
                            <li data-target="#carousel-featured" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-featured" data-slide-to="1"></li>
                            <li data-target="#carousel-featured" data-slide-to="2"></li>
                        </ol>

                        <div class="carousel-inner" role="listbox">
                            <!-- Gnome Carousel Images -->
                            <div class="item active">
                                <a class="thumbnail" id="smallThumb" href="itemPage.jsp"><img class="img-responsive" src="resources/img/gnome.jpg"></a>
                            </div>

                            <!-- Gnome Carousel Images -->
                            <div class="item">
                                <a class="thumbnail" id="smallThumb" href="itemPage.jsp"><img class="img-responsive" src="resources/img/gnome02.jpg"></a>
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
            
                <div class="col-lg-2">
                    <div id="carousel-featured1" class="carousel slide" data-ride="carousel">

                        <ol class="carousel-indicators">
                            <li data-target="#carousel-featured" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-featured" data-slide-to="1"></li>
                            <li data-target="#carousel-featured" data-slide-to="2"></li>
                        </ol>

                        <div class="carousel-inner" role="listbox">
                            <!-- Gnome Carousel Images -->
                            <div class="item active">
                                <a class="thumbnail" id="smallThumb" href="itemPage.jsp"><img class="img-responsive" src="resources/img/gnome03.jpg"></a>
                            </div>

                            <!-- Gnome Carousel Images -->
                            <div class="item">
                                <a class="thumbnail" id="smallThumb" href="itemPage.jsp"><img class="img-responsive" src="resources/img/gnome04.jpg"></a>
                            </div>
                        </div>


                        <!-- Carousel Control Buttons -->
                        <a class="left carousel-control" href="#carousel-featured1" role="button" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#carousel-featured1" role="button" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
            
                <div class="col-lg-2">
                    <div id="carousel-featured2" class="carousel slide" data-ride="carousel">

                        <ol class="carousel-indicators">
                            <li data-target="#carousel-featured" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-featured" data-slide-to="1"></li>
                            <li data-target="#carousel-featured" data-slide-to="2"></li>
                        </ol>

                        <div class="carousel-inner" role="listbox">
                            <!-- Gnome Carousel Images -->
                            <div class="item active">
                                <a class="thumbnail" id="smallThumb" href="itemPage.jsp"><img class="img-responsive" src="resources/img/gnome05.jpg"></a>
                            </div>

                            <!-- Gnome Carousel Images -->
                            <div class="item">
                                <a class="thumbnail" id="smallThumb" href="itemPage.jsp"><img class="img-responsive" src="resources/img/gnome06.jpg"></a>
                            </div>
                        </div>


                        <!-- Carousel Control Buttons -->
                        <a class="left carousel-control" href="#carousel-featured2" role="button" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#carousel-featured2" role="button" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
            
                <div class="col-lg-2">
                    <div id="carousel-featured3" class="carousel slide" data-ride="carousel">

                        <ol class="carousel-indicators">
                            <li data-target="#carousel-featured" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-featured" data-slide-to="1"></li>
                            <li data-target="#carousel-featured" data-slide-to="2"></li>
                        </ol>

                        <div class="carousel-inner" role="listbox">
                            <!-- Gnome Carousel Images -->
                            <div class="item active">
                                <a class="thumbnail" id="smallThumb" href="itemPage.jsp"><img class="img-responsive" src="resources/img/jacuzzi01.png"></a>
                            </div>

                            <!-- Gnome Carousel Images -->
                            <div class="item">
                                <a class="thumbnail" id="smallThumb" href="itemPage.jsp"><img class="img-responsive" src="resources/img/jacuzzi02.jpg"></a>
                            </div>
                        </div>


                        <!-- Carousel Control Buttons -->
                        <a class="left carousel-control" href="#carousel-featured3" role="button" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#carousel-featured3" role="button" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
            
                <div class="col-lg-2">
                    <div id="carousel-featured4" class="carousel slide" data-ride="carousel">

                        <ol class="carousel-indicators">
                            <li data-target="#carousel-featured" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-featured" data-slide-to="1"></li>
                            <li data-target="#carousel-featured" data-slide-to="2"></li>
                        </ol>

                        <div class="carousel-inner" role="listbox">
                            <!-- Gnome Carousel Images -->
                            <div class="item active">
                                <a class="thumbnail" id="smallThumb" href="itemPage.jsp"><img class="img-responsive" src="resources/img/jacuzzi03.jpg"></a>
                            </div>

                            <!-- Gnome Carousel Images -->
                            <div class="item">
                                <a class="thumbnail" id="smallThumb" href="itemPage.jsp"><img class="img-responsive" src="resources/img/jacuzzi04.png"></a>
                            </div>
                        </div>


                        <!-- Carousel Control Buttons -->
                        <a class="left carousel-control" href="#carousel-featured4" role="button" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#carousel-featured4" role="button" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
            
                <div class="col-lg-2">
                    <div id="carousel-featured5" class="carousel slide" data-ride="carousel">

                        <ol class="carousel-indicators">
                            <li data-target="#carousel-featured" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-featured" data-slide-to="1"></li>
                            <li data-target="#carousel-featured" data-slide-to="2"></li>
                        </ol>

                        <div class="carousel-inner" role="listbox">
                            <!-- Gnome Carousel Images -->
                            <div class="item active">
                                <a class="thumbnail" id="smallThumb" href="itemPage.jsp"><img class="img-responsive" src="resources/img/hoe01.jpg"></a>
                            </div>

                            <!-- Gnome Carousel Images -->
                            <div class="item">
                                <a class="thumbnail" id="smallThumb" href="itemPage.jsp"><img class="img-responsive" src="resources/img/hoe2.jpg"></a>
                            </div>
                        </div>


                        <!-- Carousel Control Buttons -->
                        <a class="left carousel-control" href="#carousel-featured5" role="button" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#carousel-featured5" role="button" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
        </div>
        <!-- /container -->

        
        <div class="container-fluid">
            <div class="rows">
                
                <!-- Most Popular Carousel -->
                <div class="col-lg-6">
                    <h2>Most Popular Items</h2>

                    <div id="carousel-popular" class="carousel slide" data-ride="carousel">

                        <ol class="carousel-indicators">
                            <li data-target="#carousel-popular" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-popular" data-slide-to="1"></li>
                            <li data-target="#carousel-popular" data-slide-to="2"></li>
                        </ol>

                        <div class="carousel-inner" role="listbox">
                            <!-- Gnome Carousel Images -->
                            <div class="item active">
                                <div class="container-fluid">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <a class="thumbnail" id="carouselThumb" href="itemPage.jsp"><img class="img-responsive" src="resources/img/gnome.jpg"></a> 
                                        </div>
                                        <div class="col-lg-6">
                                            <a class="thumbnail" id="carouselThumb" href="itemPage.jsp"><img class="img-responsive" src="resources/img/gnome02.jpg"></a>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- Gnome Carousel Images -->
                            <div class="item">
                                <div class="container-fluid">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <a class="thumbnail" id="carouselThumb" href="itemPage.jsp"><img class="img-responsive" src="resources/img/gnome03.jpg"></a> 
                                        </div>
                                        <div class="col-lg-6">
                                            <a class="thumbnail" id="carouselThumb" href="itemPage.jsp"><img class="img-responsive" src="resources/img/gnome04.jpg"></a>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- Gnome Carousel Images -->
                            <div class="item">
                                <div class="container-fluid">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <a class="thumbnail" id="carouselThumb" href="itemPage.jsp"><img class="img-responsive" src="resources/img/gnome05.jpg"></a> 
                                        </div>
                                        <div class="col-lg-6">
                                            <a class="thumbnail" id="carouselThumb" href="itemPage.jsp"><img class="img-responsive" src="resources/img/gnome06.jpg"></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- Carousel Control Buttons -->
                        <a class="left carousel-control" href="#carousel-popular" role="button" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#carousel-popular" role="button" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
                
                <!-- Your Wishlist Carousel -->
                <div class="col-lg-6">
                    <h2>Items On Your Wishlist</h2>

                    <div id="carousel-wishlist" class="carousel slide" data-ride="carousel">

                        <ol class="carousel-indicators">
                            <li data-target="#carousel-wishlist" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-wishlist" data-slide-to="1"></li>
                            <li data-target="#carousel-wishlist" data-slide-to="2"></li>
                        </ol>

                        <div class="carousel-inner" role="listbox">
                            <!-- Gnome Carousel Images -->
                            <div class="item active">
                                <div class="container-fluid">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <a class="thumbnail" id="carouselThumb" href="itemPage.jsp"><img class="img-responsive" src="resources/img/jacuzzi01.png"></a> 
                                        </div>
                                        <div class="col-lg-6">
                                            <a class="thumbnail" id="carouselThumb" href="itemPage.jsp"><img class="img-responsive" src="resources/img/gnome.jpg"></a>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- Gnome Carousel Images -->
                            <div class="item">
                                <div class="container-fluid">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <a class="thumbnail" id="carouselThumb" href="itemPage.jsp"><img class="img-responsive" src="resources/img/pot03.jpg"></a> 
                                        </div>
                                        <div class="col-lg-6">
                                            <a class="thumbnail" id="carouselThumb" href="itemPage.jsp"><img class="img-responsive" src="resources/img/gnome05.jpg"></a>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- Gnome Carousel Images -->
                            <div class="item">
                                <div class="container-fluid">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <a class="thumbnail" id="carouselThumb" href="itemPage.jsp"><img class="img-responsive" src="resources/img/pot01.jpg"></a> 
                                        </div>
                                        <div class="col-lg-6">
                                            <a class="thumbnail" id="carouselThumb" href="itemPage.jsp"><img class="img-responsive" src="resources/img/pot02.JPG"></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- Carousel Control Buttons -->
                        <a class="left carousel-control" href="#carousel-wishlist" role="button" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#carousel-wishlist" role="button" data-slide="next">
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

</html>