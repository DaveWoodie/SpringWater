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
        <div class="container">

            <div class="row">

                <!-- Left Column -->
                <div class="col-lg-8" id="leftCol">
                    <div class="container">
                        <h2 id="productTitle">Your Basket</h2>

                        <!-- Item Area -->
                        <div class="well">
                            <div class="panel panel-default">

                                <!-- Table -->
                                <table class="table table-striped">

                                    <!-- Table Headings -->
                                    <thead>
                                        <tr>
                                            <th id="supersubtitle">Item Name</th>
                                            <th id="supersubtitle">Item Price</th>
                                            <th id="supersubtitle">Quantity</th>
                                            <th id="supersubtitle">Subtotal</th>
                                            <th id="supersubtitle">Add / Remove</th>
                                        </tr>
                                    </thead>

                                    <!-- Items -->
                                    <tbody>

                                        <!-- Item Row -->
                                        <tr>
                                            <td>[ITEM NAME]</td>
                                            <td>&pound;0.00</td>
                                            <td>1</td>
                                            <td>&pound;0.00</td>
                                            <td>
                                                <button class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button>
                                                <button class="btn btn-info"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span></button>
                                                <button class="btn btn-danger"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                                            </td>
                                        </tr>

                                        <!-- Item Row -->
                                        <tr>
                                            <td>[ITEM NAME]</td>
                                            <td>&pound;0.00</td>
                                            <td>1</td>
                                            <td>&pound;0.00</td>
                                            <td>
                                                <button class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button>
                                                <button class="btn btn-info"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span></button>
                                                <button class="btn btn-danger"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                                            </td>
                                        </tr>

                                        <!-- Item Row -->
                                        <tr>
                                            <td>[ITEM NAME]</td>
                                            <td>&pound;0.00</td>
                                            <td>1</td>
                                            <td>&pound;0.00</td>
                                            <td>
                                                <button class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button>
                                                <button class="btn btn-info"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span></button>
                                                <button class="btn btn-danger"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                                            </td>
                                        </tr>

                                        <!-- Item Row -->
                                        <tr>
                                            <td>[ITEM NAME]</td>
                                            <td>&pound;0.00</td>
                                            <td>1</td>
                                            <td>&pound;0.00</td>
                                            <td>
                                                <button class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button>
                                                <button class="btn btn-info"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span></button>
                                                <button class="btn btn-danger"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>

                            </div>
                        </div>

                    </div>
                </div>

                <!-- Right Column -->
                <div class="col-lg-4" id="rightCol">
                    <div class="container">

                        <div class="well">

                            <!-- Total panel -->
                            <div class="panel panel-success">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Order Details</h3></div>
                                <div class="container">
                                    <div class="row">
                                        <div class="col-sm-6 panel-body" id="panelLeft">Subtotal:</div>
                                        <div class="col-sm-6 panel-body">&pound;0.00</div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6 panel-body" id="panelLeft">VAT (20%):</div>
                                        <div class="col-sm-6 panel-body">&pound;0.00</div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6 panel-body" id="panelLeft">Postage:</div>
                                        <div class="col-sm-6 panel-body">&pound;0.00</div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6 panel-body" id="panelLeft">Total Price:</div>
                                        <div class="col-sm-6 panel-body">&pound;0.00</div>
                                    </div>
                                </div>
                            </div>

                            <!-- Address Section -->
                            <!-- Address Panel -->
                            <div class="nav nav-stacked panel panel-success" id="sidebar">
                                <div class="panel-heading">Address Options</div>

                                <!-- Dropdown -->
                                <div class="list-group panel">
                                    <a href="#AddressMenu" class="list-group-item strong" data-toggle="collapse" data-parent="#AddressMenu" id="selectAddress">Select Address<i class="fa fa-caret-down"></i></a>
                                    <div class="collapse" id="AddressMenu">
                                        <a href="#" class="list-group-item" data-parent="#AddressMenu" id="option">STREET NAME 1</a>
                                        <a href="#" class="list-group-item" data-parent="#AddressMenu" id="option">STREET NAME 2</a>
                                    </div>
                                </div>
                            </div>

                            <!-- Address Options -->
                            <div class="panel" style="background:none">
                                <a href="addAddresses.jsp" class="btn btn-block btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Add Address</a>
                                <a href="addAddresses.jsp" class="btn btn-block btn-info"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> Edit Address</a>
                            </div>

                            <!-- Accept Button -->
                            <div class="panel" style="background:none" id="paymentDiv">
                                <a href="http://www.paypal.com" class="btn btn-block btn-primary"><img src="https://www.paypalobjects.com/webstatic/i/logo/rebrand/ppcom-white.svg" style="width:40%;height:auto"></a>
                            </div>

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

<!-- Custom script -->
<script src="basket.js"></script>

</html>