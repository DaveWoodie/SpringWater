<!--------------------------------------------------------

    Chris J W Walker 
    
    loginRegister.html

    13/10/2015

    Page for allowing the user to login into NBGardens
    or create a new account

    Last Modified by: chrisjwwalker

--------------------------------------------------------->

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
                <a class="navbar-brand" href="index.jsp">NBGardens</a>
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
                    <a class="btn btn-danger" href="wishlist.jsp"><span class="glyphicon glyphicon-star" aria-hidden="true"></span> Wish List <span class="badge">0</span></a>
                    <a class="btn btn-info" href="basket.jsp"><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> Basket <span class="badge">0</span></a>
                    <a class="btn btn-success" href="loginRegister.jsp"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> Login</a>
                    <a class="btn btn-primary" href="loginRegister.jsp"><span class="glyphicon glyphicon-tasks" aria-hidden="true"></span> Register</a>
                </form>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

    <div class="jumbotron content">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <div class="page-header">
                        <h1 id="productTitle">Already with us?<small> Log in now!</small></h1>
                    </div>

                    <form>
                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon1">Email</span>
                            <input type="text" class="form-control" placeholder="Email Address" aria-describedby="basic-addon1">
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon1">Password</span>
                            <input type="password" class="form-control" placeholder="Password" aria-describedby="basic-addon1">
                        </div>
                        <br>
                        <button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-log-in" aria-hidden="true"></span> Login</button>
                    </form>
                    <br>
                    <div class="panel panel-danger">
                        <div class="panel-heading"><span class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span> Problems logging in?</div>
                        <div class="panel-body">
                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span> Forgotten the email address you use to log in?
                            <br>
                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span> Forgotten your password?
                        </div>
                    </div>
                </div>

                <div class="col-md-6">
                    <div class="page-header">
                        <h1 id="productTitle">New here? <small> Register an account!</small></h1>
                    </div>

                    <form>
                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon1">First Name</span>
                            <input type="text" class="form-control" placeholder="First Name" aria-describedby="basic-addon1">
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon1">Last Name</span>
                            <input type="text" class="form-control" placeholder="Last Name" aria-describedby="basic-addon1">
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon1">Email</span>
                            <input type="text" class="form-control" placeholder="Email Address" aria-describedby="basic-addon1">
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon1">Password</span>
                            <input type="password" class="form-control" placeholder="Password" aria-describedby="basic-addon1">
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon1">Confirm</span>
                            <input type="password" class="form-control" placeholder="Confirm Password" aria-describedby="basic-addon1">
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon1">Date of Birth</span>
                            <input type="text" class="form-control" placeholder="Date of Birth" aria-describedby="basic-addon1">
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon1">Telephone Number</span>
                            <input type="text" class="form-control" placeholder="Telephone Number (Landline or mobile)" aria-describedby="basic-addon1">
                        </div>
                        <br>
                        <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-tasks" aria-hidden="true"></span> Register</button>
                    </form>
                    <br>
                    <div class="panel panel-info">
                        <div class="panel-heading"><span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span> Just a quick note!</div>
                        <div class="panel-body">
                            After you've pressed register please check your emails for your activation link. If you can't find our email please check you spam folders! If you are still facing trouble, please don't hestitate to contact us! (Contact link at the bottom of the page)
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
                    <a href="aboutus.jsp">
                        <p class="whiteText"><span class="glyphicon glyphicon-book" aria-hidden="true"></span> About</p>
                    </a>
                </div>
                <div class="col-md-2 whiteText">
                    <a href="contact.jsp">
                        <p class="whiteText"><span class="glyphicon glyphicon-globe" aria-hidden="true"></span> Contact</p>
                    </a>
                </div>
                <div class="col-md-2 whiteText">
                    <a href="faq.jsp">
                        <p class="whiteText"><span class="glyphicon glyphicon-list-alt" aria-hidden="true"></span> FAQ</p>
                    </a>
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