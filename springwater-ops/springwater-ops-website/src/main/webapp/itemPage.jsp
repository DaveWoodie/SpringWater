<!--------------------------------------------------------

    Chris J W Walker 
    
    loginRegister.html

    13/10/2015

    Page for viewing specific information about a 
    single product

    Last Modified by: chrisjwwalker

--------------------------------------------------------->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                    <a href="wishlist.jsp" class="btn btn-danger"><span class="glyphicon glyphicon-star" aria-hidden="true"></span> Wish List <span class="badge">0</span></a>
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
                        <h1 id="productTitle">Product Title</h1>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-5">
                    <a href="#" class="thumbnail" data-toggle="modal" data-target="#enlargedImage">
                        <img src="resources/img/placeholder2.png" alt="..." width="60%" height="60%">
                    </a>
                </div>
                <div class="col-md-7">
                    <div class="page-header">
                        <h1 id="desc">Description</h1>
                    </div>

                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>

                    <a class="btn btn-danger btn-lg" href=""><span class="glyphicon glyphicon-star" aria-hidden="true"></span> Add to Wish List</a>
                    <a class="btn btn-warning btn-lg" href="#reviews"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> Reviews</a>
                    <a class="btn btn-info btn-lg" href=""><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> Add to Basket</a>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="page-header">
                        <h1 id="productTitle">Recommended Items</h1>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-6 col-md-3">
                    <div class="thumbnail">
                        <a href="itemPage.jsp"><img src="resources/img/placeholder2.png" alt="..."></a>
                        <div class="caption">
                            <h3>Recommended Item 1</h3>
                            <p>&pound;X.XX</p>
                            <p>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star-empty ratings" aria-hidden="true"></span>
                            </p>
                            <p>
                                <a href="itemPage.jsp" class="btn btn-primary" role="button"><span class="glyphicon glyphicon-triangle-right" aria-hidden="true"></span> Go to Item</a>
                                <a href="#" class="btn btn-success" data-toggle="modal" data-target="#RI1" role="button"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> Quick Look</a>
                            </p>
                        </div>
                    </div>
                </div>

                <div class="col-sm-6 col-md-3">
                    <div class="thumbnail">
                        <a href="itemPage.jsp"><img src="resources/img/placeholder2.png" alt="..."></a>
                        <div class="caption">
                            <h3>Recommended Item 2</h3>
                            <p>&pound;X.XX</p>
                            <p>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star-empty ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star-empty ratings" aria-hidden="true"></span>
                            </p>
                            <p>
                                <a href="itemPage.jsp" class="btn btn-primary" role="button"><span class="glyphicon glyphicon-triangle-right" aria-hidden="true"></span> Go to Item</a>
                                <a href="#" class="btn btn-success" data-toggle="modal" data-target="#RI2" role="button"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> Quick Look</a>
                            </p>
                        </div>
                    </div>
                </div>

                <div class="col-sm-6 col-md-3">
                    <div class="thumbnail">
                        <a href="itemPage.jsp"><img src="resources/img/placeholder2.png" alt="..."></a>
                        <div class="caption">
                            <h3>Recommended Item 3</h3>
                            <p>&pound;X.XX</p>
                            <p>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                            </p>
                            <p>
                                <a href="itemPage.jsp" class="btn btn-primary" role="button"><span class="glyphicon glyphicon-triangle-right" aria-hidden="true"></span> Go to Item</a>
                                <a href="#" class="btn btn-success" data-toggle="modal" data-target="#RI3" role="button"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> Quick Look</a>
                            </p>
                        </div>
                    </div>
                </div>

                <div class="col-sm-6 col-md-3">
                    <div class="thumbnail">
                        <a href="itemPage.jsp"><img src="resources/img/placeholder2.png" alt="..."></a>
                        <div class="caption">
                            <h3>Recommended Item 4</h3>
                            <p>&pound;X.XX</p>
                            <p>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star-empty ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star-empty ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star-empty ratings" aria-hidden="true"></span>
                            </p>
                            <p>
                                <a href="itemPage.jsp" class="btn btn-primary" role="button"><span class="glyphicon glyphicon-triangle-right" aria-hidden="true"></span> Go to Item</a>
                                <a href="#" class="btn btn-success" data-toggle="modal" data-target="#RI4" role="button"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> Quick Look</a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="jumbotron content" id="reviews">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="page-header">
                        <h1 id="productTitle">Reviews</h1>
                    </div>

                    <table class="table table-striped">
                        <thead>
                            <th>Reviewer</th>
                            <th style="width: 22%">Rating</th>
                            <th>Comment</th>
                        </thead>

                        <tbody>
                            <tr>
                                <td>GnomeFanatic616</td>
                                <td class="reviewRatings">
                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
                                </td>
                                <td>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua</td>
                            </tr>

                            <tr>
                                <td>Garden_Warrior</td>
                                <td class="reviewRatings">
                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                </td>
                                <td>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua</td>
                            </tr>

                            <tr>
                                <td>Gn0m3Gardener</td>
                                <td class="reviewRatings">
                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
                                </td>
                                <td>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua</td>
                            </tr>
                        </tbody>
                    </table>
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
                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-6 whiteText">
                        <div id="paymentDiv">
                            <p><span class="glyphicon glyphicon-credit-card" aria-hidden="true"></span> We only accept <img src="https://www.paypalobjects.com/webstatic/i/logo/rebrand/ppcom-white.svg" style="width:25%;height:auto"> as a payment option</p>
                        </div>
                        <div id="paymentDiv">
                    		<p><span class="glyphicon glyphicon-credit-card" aria-hidden="true"></span> We operate on a 'buy now, pay if satisfied' policy</p>
                    	</div>
                    </div>
                    <div class="col-md-3"></div>
                </div>
            </div>
        </div>
</body>

<!-- Modals -->
<div class="modal fade" id="enlargedImage" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Product Name</h4>
            </div>
            <div class="modal-body">
                <img class="center-block" src="resources/img/placeholder2.png" alt="..." width="100%">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span> Close</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="RI1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Product Name</h4>
            </div>
            <div class="modal-body">
                <img class="center-block" src="resources/img/placeholder2.png" alt="..." width="100%">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span> Close</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="RI2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Product Name</h4>
            </div>
            <div class="modal-body">
                <img class="center-block" src="resources/img/placeholder2.png" alt="..." width="100%">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span> Close</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="RI3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Product Name</h4>
            </div>
            <div class="modal-body">
                <img class="center-block" src="resources/img/placeholder2.png" alt="..." width="100%">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span> Close</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="RI4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Product Name</h4>
            </div>
            <div class="modal-body">
                <img class="center-block" src="resources/img/placeholder2.png" alt="..." width="100%">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span> Close</button>
            </div>
        </div>
    </div>
</div>

</html>