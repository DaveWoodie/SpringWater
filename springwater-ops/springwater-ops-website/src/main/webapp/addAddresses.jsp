<!--------------------------------------------------------

    Chris J W Walker 
    
    addAddresses.html

    13/10/2015

    Page for customers to manage their addresses. 
    View, add and delete addresses.

    Last Modified by: chrisjwwalker

--------------------------------------------------------->

<!DOCTYPE HTML>
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
                    <a href="#" class="btn btn-danger"><span class="glyphicon glyphicon-star" aria-hidden="true"></span> Wish List <span class="badge">0</span></a>
                    <a href="basket.jsp" class="btn btn-info"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> Basket <span class="badge">0</span></a>
                    <a href="loginRegister.jsp" type="submit" class="btn btn-success"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Login</a>
                    <a href="loginRegister.jsp" class="btn btn-primary"><span class="glyphicon glyphicon-tasks" aria-hidden="true"></span> Register</a>
                </form>
            </div>
            <!-- END OF COLLASPE AREA -->
        </div>
    </nav>

    <div class="jumbotron content">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="page-header">
                        <h1 id="productTitle">Manage Delivery Addresses</h1>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6">
                    <div class="page-header">
                        <h1 id="productTitle"><small>Add Address</small></h1>
                    </div>
                    <form>
                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon1">Address Line 1</span>
                            <input type="text" class="form-control" placeholder="Address Line 1" aria-describedby="basic-addon1">
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon1">Address Line 2</span>
                            <input type="text" class="form-control" placeholder="Address Line 2" aria-describedby="basic-addon1">
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon1">Town or City</span>
                            <input type="text" class="form-control" placeholder="Town or City" aria-describedby="basic-addon1">
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon1">County</span>
                            <input type="text" class="form-control" placeholder="County" aria-describedby="basic-addon1">
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon1">Post Code</span>
                            <input type="text" class="form-control" placeholder="Post Code" aria-describedby="basic-addon1">
                        </div>
                        <br>
                        <button class="btn btn-primary"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Add Address</button>
                    </form>
                </div>

                <div class="col-md-6">
                    <div class="page-header">
                        <h1 id="productTitle"><small>See Your Addresses</small></h1>
                    </div>

                    <div class="panel panel-success">
                        <div class="panel-heading">
                            <span class="glyphicon glyphicon-home" aria-hidden="true"></span> Home
                        </div>

                        <div class="panel-body">
                            <p>
                                62 Bentley Road
                                <br> Uttoxeter
                                <br> Staffordshire
                                <br> ST14 7EN
                            </p>
                            <button class="btn btn-primary"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> Edit Address</button>
                            <button class="btn btn-danger"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span> Delete Address</button>
                        </div>
                    </div>

                    <div class="panel panel-success">
                        <div class="panel-heading">
                            <span class="glyphicon glyphicon-home" aria-hidden="true"></span> Work
                        </div>

                        <div class="panel-body">
                            <p>
                                NETBuilder LTD
                                <br> Floor 5
                                <br> Anchorage Quay
                                <br> Salford Quays
                                <br> M50 3YJ
                            </p>
                            <button class="btn btn-primary"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> Edit Address</button>
                            <button class="btn btn-danger"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span> Delete Address</button>
                        </div>
                    </div>

                    <div class="panel panel-success">
                        <div class="panel-heading">
                            <span class="glyphicon glyphicon-home" aria-hidden="true"></span> Uni
                        </div>

                        <div class="panel-body">
                            <p>
                                Flat 4 Phoenix Nights
                                <br> Phoenix Street
                                <br> Lancaster
                                <br> LA1 1DD
                            </p>
                            <button class="btn btn-primary"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> Edit Address</button>
                            <button class="btn btn-danger"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span> Delete Address</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

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
</body>

</html>