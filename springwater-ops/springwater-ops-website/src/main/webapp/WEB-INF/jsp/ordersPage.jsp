<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      th:include="template :: page">

<head th:fragment="header">
    <title>NB Gardens - Orders</title>
</head>

<body>
<div th:fragment="content">  
    <!-- Content Area -->
    <div class="jumbotron content">

        <div class="container">
            <div class="rows">
                <div class="col-lg-6">
                    <!-- Navigation links for user sub-directories -->
                    <p>
                        <a href="profile">Account</a> &gt; Orders
                    </p>
                </div>
                <div class="col-lg-6 col-md-6 col-md-6">
                    <!-- Search for -->
                    <form class="navbar-form navbar-right" role="search">
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="Search all orders" />
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
                        <li><a href="openorders">Open Orders</a></li>
                        <li><a href="cancelledorders">Cancelled Orders</a></li>
                	</ul>
                </nav>
            </div>

            <div class="col-lg-12">
                <!-- New horizontal line -->
                <hr />
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
                        <p class="panel-title">&pound;14.75</p>
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
                        <img id="orderImage" src="img/gnome.jpg" />
                    </div>

                    <div class="col-md-3">
                        <br />
                        <br />
                        <br />
                        <br />
                        <br />
                        <br />
                        <br />
                        <br />
                        <a href="#">Happy Gnome</a>
                        <p>Quantity: 3</p>
                        <p>&pound;2.99</p>
                        <button type="submit" class="btn btn-success"><span class="glyphicon glyphicon-credit-card" aria-hidden="true"></span> Buy it Again</button>
                    </div>
                    
                    <!-- Button List -->
                    <div class="col-mid-3">
                    	<button class="btn btn-primary"><span class="glyphicon glyphicon-tasks" aria-hidden="true"></span> Leave Buyer Feedback</button>
                    	<button class="btn btn-primary"><span class="glyphicon glyphicon-tasks" aria-hidden="true"></span> Close Panel</button>
                    </div>
                    
                </div>
            </div>
        </div>

    </div>
</div>
</body>

</html>