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
                <a class="navbar-brand" href="#">NBGardens</a>
            </div>

            <!-- Navbar items that collaspe into toggle menu -->
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
                    <button class="btn btn-danger"><span class="glyphicon glyphicon-star" aria-hidden="true"></span> Wish List <span class="badge">0</span></button>
                    <button class="btn btn-info"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> Basket <span class="badge">0</span></button>
                    <button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Login</button>
                    <button class="btn btn-primary"><span class="glyphicon glyphicon-tasks" aria-hidden="true"></span> Register</button>
                </form>
            </div>
            <!-- END OF COLLASPE AREA -->
        </div>
    </nav>
    <!-- END OF NAVBAR -->

    <!-- PROFILE PAGE -->
    <div class="container" style="padding-top: 30px;">
        <h1 class="page-header">Summary</h1>
        <div class="row">
            <!-- left column -->
            <div class="col-md-4 col-sm-6 col-xs-12">
                <div class="text-center">
                    <img src="resources/img/placeholder.png" class="avatar img-circle img-thumbnail" alt="avatar">
                    <h6>Upload a different photo...</h6>
                    <input type="file" class="text-center center-block well well-sm">
                </div>
            </div>

            <!-- User details -->
            <h3>Details</h3>
            <div class="col-sm-4">
                <div class="list-group">
                    <li class="list-group-item active">
                        First Name: </li>
                    <br>
                    <li class="list-group-item active">
                        Last Name: </li>
                </div>

                <hr>
            </div>
            <!-- /.col-sm-4 -->

            <div class="col-sm-4">
                <div class="list-group">
                    <li class="list-group-item">
                        Joe</li>
                    <br>
                    <li class="list-group-item">
                        Bloggs</li>
                </div>
                <hr>
            </div>
            <!-- /.col-sm-4 -->

            <!-- Menu for profile, addresses and order nav bar-->
            <div class="masthead">
                <nav>
                    <ul class="nav nav-justified">
                        <li class="active"><a href="#">Profile</a></li>
                        <li><a href="addAddresses.jsp">Addresses</a></li>
                        <li><a href="ordersPage.jsp">Orders</a></li>

                        <!-- Profile stuff -->
                        <div class="col-sm-8">
                            <div class="well">
                                <p>CustomerID: &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp001</p>
                                <p>Username: &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspgnomefan23</p>
                                <p>Email: &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspgardenfanatic@gmail.com</p>
                                <p>Date of Birth: &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp08/10/90</p>
                                <p>Phone Number: &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp07523476525</p>
                                <p>Current Credit: &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp0.00 GBP</p>
                            </div>
                        </div>
                    </ul>
                </nav>
            </div>
            <hr>
        </div>
    </div>
    </div>

    <!-- Content Area -->
    <div class="jumbotron content">
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