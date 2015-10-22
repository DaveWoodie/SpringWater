<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      th:include="template :: page">

<head th:fragment="header">
    <title>NB Gardens</title>
</head>

<body>
<div th:fragment="content">    
    <!-- Page Content -->
    <div class="jumbotron content">
        
        <!-- ******************************* Carousel Gnome Featured ************************************* -->        
        <div class="container-fluid">
                <div class="row">
                        <!-- Left Panel -->
                        <div class="col-lg-4">
                            <img class="img-responsive thumbnail" id="carouselThumb" src="img/logo.png" alt="" />
                            <div class="panel panel-default">
                                <div class="panel-body" style="text-align:center">
                                    Welcome to NB Gardens. We are a retailer of high quality garden products who pride ourselves in our high quality gnomes.
                                </div>
                            </div>
                        </div>
                
                        <!-- Right Panel -->
                        <div class="col-lg-8">
                                <img src="img/header.jpg" class="img-responsive" style="width:auto;height:auto" />
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
                                <a class="thumbnail" id="smallThumb" href="itempage"><img class="img-responsive" src="img/gnome.jpg" /></a>
                            </div>

                            <!-- Gnome Carousel Images -->
                            <div class="item">
                                <a class="thumbnail" id="smallThumb" href="itempage"><img class="img-responsive" src="img/gnome02.jpg" /></a>
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
                                <a class="thumbnail" id="smallThumb" href="itempage"><img class="img-responsive" src="img/gnome03.jpg" /></a>
                            </div>

                            <!-- Gnome Carousel Images -->
                            <div class="item">
                                <a class="thumbnail" id="smallThumb" href="itempage"><img class="img-responsive" src="img/gnome04.jpg" /></a>
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
                                <a class="thumbnail" id="smallThumb" href="itempage"><img class="img-responsive" src="img/gnome05.jpg" /></a>
                            </div>

                            <!-- Gnome Carousel Images -->
                            <div class="item">
                                <a class="thumbnail" id="smallThumb" href="itempage"><img class="img-responsive" src="img/gnome06.jpg" /></a>
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
                                <a class="thumbnail" id="smallThumb" href="itempage"><img class="img-responsive" src="img/jacuzzi01.png" /></a>
                            </div>

                            <!-- Gnome Carousel Images -->
                            <div class="item">
                                <a class="thumbnail" id="smallThumb" href="itempage"><img class="img-responsive" src="img/jacuzzi02.jpg" /></a>
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
                                <a class="thumbnail" id="smallThumb" href="itempage"><img class="img-responsive" src="img/jacuzzi03.jpg" /></a>
                            </div>

                            <!-- Gnome Carousel Images -->
                            <div class="item">
                                <a class="thumbnail" id="smallThumb" href="itempage"><img class="img-responsive" src="img/jacuzzi04.png" /></a>
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
                                <a class="thumbnail" id="smallThumb" href="itempage"><img class="img-responsive" src="img/hoe01.jpg" /></a>
                            </div>

                            <!-- Gnome Carousel Images -->
                            <div class="item">
                                <a class="thumbnail" id="smallThumb" href="itempage"><img class="img-responsive" src="img/hoe2.jpg" /></a>
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
                                            <a class="thumbnail" id="carouselThumb" href="itempage"><img class="img-responsive" src="img/gnome.jpg" /></a> 
                                        </div>
                                        <div class="col-lg-6">
                                            <a class="thumbnail" id="carouselThumb" href="itempage"><img class="img-responsive" src="img/gnome02.jpg" /></a>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- Gnome Carousel Images -->
                            <div class="item">
                                <div class="container-fluid">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <a class="thumbnail" id="carouselThumb" href="itempage"><img class="img-responsive" src="img/gnome03.jpg" /></a> 
                                        </div>
                                        <div class="col-lg-6">
                                            <a class="thumbnail" id="carouselThumb" href="itempage"><img class="img-responsive" src="img/gnome04.jpg" /></a>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- Gnome Carousel Images -->
                            <div class="item">
                                <div class="container-fluid">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <a class="thumbnail" id="carouselThumb" href="itempage"><img class="img-responsive" src="img/gnome05.jpg" /></a> 
                                        </div>
                                        <div class="col-lg-6">
                                            <a class="thumbnail" id="carouselThumb" href="itempage"><img class="img-responsive" src="img/gnome06.jpg" /></a>
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
                                            <a class="thumbnail" id="carouselThumb" href="itempage"><img class="img-responsive" src="img/jacuzzi01.png" /></a> 
                                        </div>
                                        <div class="col-lg-6">
                                            <a class="thumbnail" id="carouselThumb" href="itempage"><img class="img-responsive" src="img/gnome.jpg" /></a>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- Gnome Carousel Images -->
                            <div class="item">
                                <div class="container-fluid">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <a class="thumbnail" id="carouselThumb" href="itempage"><img class="img-responsive" src="img/pot03.jpg" /></a> 
                                        </div>
                                        <div class="col-lg-6">
                                            <a class="thumbnail" id="carouselThumb" href="itempage"><img class="img-responsive" src="img/gnome05.jpg" /></a>
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- Gnome Carousel Images -->
                            <div class="item">
                                <div class="container-fluid">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <a class="thumbnail" id="carouselThumb" href="itempage"><img class="img-responsive" src="img/pot01.jpg" /></a> 
                                        </div>
                                        <div class="col-lg-6">
                                            <a class="thumbnail" id="carouselThumb" href="itempage"><img class="img-responsive" src="img/pot02.JPG" /></a>
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
</div>

</body>

</html>