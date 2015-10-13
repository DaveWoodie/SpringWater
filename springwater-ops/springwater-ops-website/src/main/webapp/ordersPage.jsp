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

    <!-- Content Area -->
    <div class="jumbotron content">

        <div class="container">
            <div class="rows">
                <div class="col-lg-6">
                    <!-- Navigation links for user sub-directories -->
                    <p>
                        <a href="profilePage.html">Account</a> &#62 Orders
                    </p>
                </div>
                <div class="col-lg-6 col-md-6 col-md-6">
                    <!-- Search for -->
                    <form class="navbar-form navbar-right" role="search">
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="Search all orders">
                            <span class="input-group-btn"><button class="btn btn-default" type="button"><span class="glyphicon glyphicon-search" aria-hidden="true"></span> Search Orders</button>
                            </span>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <div class="container">
            <!-- Header for orders-->
            <h2>Your Orders</h2>

            <!-- list of orders-->
            <div class="col-lg-6">
                <nav>
                    <ul class="nav nav-justified">
                        <li class="active"><a href="#">Orders</a></li>
                        <li><a href="addAddresses.html">Open Orders</a></li>
                        <li><a href="ordersPage.html">Cancelled Orders</a></li>
                </nav>
            </div>

            <div class="col-lg-12">
                <!-- New horizontal line -->
                <hr>
            </div>
            <!-- Everything in the page -->
            <div class="col-lg-12">
                <!-- Form select control -->
                <div class="col-lg-2">
                    <select class="form-control">
                        <option value="Date-Range">Date Range</option>
                        <option value="oneWeek">One Week</option>
                        <option value="twoWeeks">Two Weeks</option>
                        <option value="threeWeeks">Three Weeks</option>
                        <option value="oneMonth">One Month</option>
                    </select>
                </div>
            </div>
        </div>
    </div>

    <!-- Order container -->
    <div class="container">

        <!-- Order panel -->
        <div class="panel panel-default">
            <div class="panel-heading">
                <div class="row">
                    <div class="col-md-3">
                        <h3 class="panel-title">Orders Placed</h3>
                        <p class="panel-title">11th October 2015</p>
                    </div>

                    <div class="col-md-3">
                        <h3 class="panel-title">Total</h3>
                        <p class="panel-title">&#163;11.96</p>
                    </div>

                    <div class="col-md-3">
                        <h3 class="panel-title">Dispatch To</h3>
                        <p class="panel-title">Joe Bloggs</p>
                    </div>

                    <div class="col-md-3">
                        <h3 class="panel-title">ORDER # 202-7084221-9000355</h3>
                    </div>
                </div>
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-md-3">
                        <h3>Arriving Sat, 15 Aug - Wed, 19 Aug</h3>
                        <p><b>Dispatched</b></p>
                        <img id="orderImage" src="resources/img/gnome.jpg"></img>
                    </div>

                    <div class="col-md-3">
                        <br>
                        <br>
                        <br>
                        <br>
                        <br>
                        <br>
                        <br>
                        <br>
                        <br>
                        <br>
                        <p>Garden Gome</p>
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