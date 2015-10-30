<!--     Chris Boucher  -->
<!--     orderConfirm.jsp -->
<!--     Page confirming order has been accepted  -->
<!--     Last Modified by: Callum Cooper -->
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      th:include="template :: page">

<head th:fragment="header">
    <title>NB Gardens - Confirm Order</title>
</head>

<body>
<div th:fragment="content">
    <!-- Content Area -->
    <div class="jumbotron content">
        
        <!-- Top Header -->
        <div class="jumbotron">
            <div class="container">
                <div class="row">
                    <h1>Your order has been placed</h1>
                </div>
            </div>
        </div>
        
        <!-- Order container -->
        <div class="container">
            <div style="text-align:right;padding-bottom:20px;padding-top:20px"><a href="home" class="btn btn-lg btn-primary"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span> Continue</a></div>
            <!-- Order panel -->
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-md-3">
                            <h3 class="panel-title">Orders Placed</h3>
                            <p class="panel-title" th:text="${orderDate}"></p>
                        </div>
                        <div class="col-md-3">
                            <h3 class="panel-title">Total</h3>
                            <p class="panel-title">&#163;14.75</p>
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
                        <div class="col-md-6">
                            <h3>Arriving Sat, 15 Aug - Wed, 19 Aug</h3>
                            <p><b>Dispatched</b></p>
                        </div>
                        <br /><br />
                        <br />
	                    <br />
	                    <br />
                        <br />
	                    <br />
	                    <br />
                       <div class="row">
	                        <div th:each="itemLine : ${basket.itemList}" class="row">
	                            <div class="col-lg-6">
	                                <center><img id="orderImage" th:src="${itemLine.item.imageLocation}" /></center>
	                            </div>
	                            <div class="col-md-6">
	                                <br />
	                                <br />
	                                <br />
	                                <center><a th:text="${itemLine.item.itemName}"></a></center>
	                                <center><p th:text="'Quantity: ' + ${itemLine.quantity}"></p></center>
	                                <center><p th:text="'£'+${itemLine.formattedTotalPrice()}"></p></center>
	                            </div>
	                        </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
    </div>
    <!-- END OF CONTENT -->
</div>
</body>

</html>