<!DOCTYPE HTML>
<!--------------------------------------------------------

    Chris J W Walker 
    
    aboutus.html

    13/10/2015

    Page explaining NBGardens and profiles for
    the team

    Last Modified by: chrisjwwalker

--------------------------------------------------------->

<html lang="en">

<head>
    <title>NB Gardens - About Us</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
    <script src="resources/Bootstrap/js/bootstrap.js" type="text/javascript"></script>
    <link href="resources/Bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="resources/Bootstrap/css/bootstrap-theme.min.css" rel="stylesheet">
    <link href="resources/main.css" rel="stylesheet">
    <link href="resources/collapse.css" rel="stylesheet">
</head>

<body>
    <!-- Start of navbar -->
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

            <!-- Nav bar that collaspes into toggle menu -->
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
                </form>

                <form class="navbar-form navbar-right" role="search">
                    <a class="btn btn-danger" href="wishlist.jsp"><span class="glyphicon glyphicon-star" aria-hidden="true"></span> Wish List <span class="badge">0</span></a>
                    <a class="btn btn-info" href="basket.jsp"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> Basket <span class="badge">0</span></a>
                    <a class="btn btn-success" href="loginRegister.jsp"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Login</a>
                    <a class="btn btn-primary" href="loginRegister.jsp"><span class="glyphicon glyphicon-tasks" aria-hidden="true"></span> Register</a>
                </form>
            </div>
            <!-- END OF COLLASPE AREA -->
        </div>
    </nav>
    <!-- END OF NAVBAR -->

    <!-- Page Header Jumbotron -->
    <div class="jumbotron content">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="page-header">
                        <h1 id="productTitle">About NBGardens</h1>
                    </div>
                    <p>Find out about our company and meet the team!</p>
                </div>
            </div>
        </div>
    </div>
    <!-- END OF PAGE HEADER -->

    <div class="jumbotron" id="searchBar">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="page-header">
                        <h1 style="color: #ffffff" id="aboutHeadings">The Company</h1>
                    </div>

                    <p style="color: #ffffff">NB Gardens is a traditional catalogue company based in the North-West of England and sells garden products. NB Gardens specialises in gnomes, gnome accessories and garden ornaments and it prides itself on the speed and quality of its service to its expanding customer base. The company is renowned for the quality of its products, sourcing its stock from only the finest suppliers. The company has 600 employees within its distribution centre, call centre and head office - based in Stockport. Within the call centre there are 100 sales representatives who process 2000 orders per NB gardens have been established since 1875.</p>

                </div>
            </div>
        </div>
    </div>


    <div class="jumbotron content">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="page-header">
                        <h1><small id="aboutHeadings">The Team</small></h1>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4"></div>
                <div class="col-md-4">
                    <div class="thumbnail">
                        <p id="placeHolderTeam"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></p>
                        <div class="caption">
                            <h3>David Rose<br>CEO</h3> David joined us after studying Economics at Cambridge and was appointed as CEO 10 years ago.
                        </div>
                    </div>
                </div>
                <div class="col-md-4"></div>
            </div>

            <div class="row">
                <div class="col-md-3">
                    <div class="thumbnail">
                        <p id="placeHolderTeam"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></p>
                        <div class="caption">
                            <h3>Debbie Thorne<br>Chief HR Officer</h3> Debbie's key focus is the wellbeing and development of the employees of NB Gardens. She has over 20 years of experience looking after the staff of a variey of retail companies.
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="thumbnail">
                        <p id="placeHolderTeam"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></p>
                        <div class="caption">
                            <h3>John Mann<br>Chief Ops Officer</h3>
                            <br>
                            <br>
                            <br>
                            <br>
                            <br>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="thumbnail">
                        <p id="placeHolderTeam"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></p>
                        <div class="caption">
                            <h3>Andrew Herbinson<br>Warehouse Manager</h3> Andrews main focus is managing thw warehouse process and procedures so your order can get to you!
                            <br>
                            <br>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="thumbnail">
                        <p id="placeHolderTeam"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></p>
                        <div class="caption">
                            <h3>Tauruma Patel<br>Call Center Manager</h3>
                            <br>
                            <br>
                            <br>
                            <br>
                            <br>
                        </div>
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
                   <a href="contact.jsp"> <p class="whiteText"><span class="glyphicon glyphicon-globe" aria-hidden="true"></span> Contact</p></a>
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
                        <p><span class="glyphicon glyphicon-credit-card" aria-hidden="true"></span> We only accept <img src="https://www.paypalobjects.com/webstatic/i/logo/rebrand/ppcom-white.svg" style="width:25%;height:auto"> as a payment option</p>
                    </div>
                </div>
                <div class="col-md-3"></div>
            </div>
        </div>
    </div>
    <!-- END OF FOOTER -->
</body>

</html>