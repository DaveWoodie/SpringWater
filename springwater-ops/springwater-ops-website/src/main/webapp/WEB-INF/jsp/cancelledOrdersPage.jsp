<!DOCTYPE html>
<!--------------------------------------------------------

    Callum Cooper 
    
    openOrdersPage.jps

    14/10/2015

    Template for the cancelled orders page

    Last Modified by: Callum Cooper

--------------------------------------------------------->

<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      th:include="template :: page">

<head th:fragment="header">
    <title>NB Gardens - Cancelled Orders</title>
</head>

<body>
<div th:fragment="content">     
    <!-- END OF NAVBAR -->

    <!-- Content Area -->
    <div class="jumbotron content">
    
    	<div class="container">
            <div class="rows">
                <div class="col-lg-6">
                    <!-- Navigation links for user sub-directories -->
                    <p>
                        <a href="orders">Orders</a> &gt; Cancelled Orders
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
                        <li class="active"><a href="orders">Orders</a></li>
                        <li><a href="openorders">Open Orders</a></li>
                        <li><a href="#">Cancelled Orders</a></li>
                    </ul>
                </nav>
            </div>
            
              <div class="col-lg-12">
                <!-- New horizontal line -->
                <hr>
            </div>
            
           <div class="rows">
           	<div class="col-md-3"></div>
           	<div class="col-md-6">
           <div id="paymentDiv">
           <p style="text-align:center">We can't find any cancelled orders (in the last 6 months). <a href="orders">View all orders</a></p>
           </div>
           </div>
           </div>
    
    	</div>
    <!-- END OF CONTENT -->
	</div>
</div>
</body>

</html>