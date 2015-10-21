<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      th:include="template :: page">

<head th:fragment="header">
    <title>NB Gardens - Wishlist</title>
</head>

<body>
<div th:fragment="content">
    <!-- Content Area -->
    <div class="jumbotron content">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <h2 id="productTitle">Your Wish List</h2>
                </div>
                <div class="col-lg-3"></div>
                <div class="col-lg-3">
                    <div class="panel panel-default">
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="Search for..." />
                            <span class="input-group-btn"><button class="btn btn-default" type="button"><span class="glyphicon glyphicon-search" aria-hidden="true"></span> Search</button></span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="well">
                <div class="panel panel-default">
                    <!-- Table -->
                    <table class="table">

                        <!-- Wish List -->
                        <tbody>

                            <!-- Wish List Row -->
                            <tr>
                                <td><a class="thumbnail" id="wishThumb" href="itemPage"><img class="img-responsive" src="img/pot03.jpg" /></a></td>
                                <td id="textLine">
                                    <h2>Brown Plant Pot</h2>
                                    <h5>A brown pot, perfect for putting plants inside.</h5>
                                </td>
                                <td id="wishLine"><span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span></td>
                                <td><h2>&pound;0.00</h2></td>
                                <td id="wishLine">
                                    <button class="btn btn-block btn-warning"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span> Remove From Wish List</button>
                                </td>
                            </tr>
                            
                            <!-- Wish List Row -->
                            <tr>
                                <td><a class="thumbnail" id="wishThumb" href="itemPage"><img class="img-responsive" src="img/gnome.jpg" /></a></td>
                                <td id="textLine">
                                    <h2>Happy Gnome</h2>
                                    <h5>A happy looking gnome with a red hat.</h5>
                                </td>
                                <td id="wishLine"><span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span></td>
                                <td><h2>&pound;0.00</h2></td>
                                <td id="wishLine">
                                    <button class="btn btn-block btn-warning"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span> Remove From Wish List</button>
                                </td>
                            </tr>
                            
                            <!-- Wish List Row -->
                            <tr>
                                <td><a class="thumbnail" id="wishThumb" href="itemPage"><img class="img-responsive" src="img/gnome05.jpg" /></a></td>
                                <td id="textLine">
                                    <h2>Three Wise Gnomes</h2>
                                    <h5>A set of three wise gnomes, based on the three wise monkeys.</h5>
                                </td>
                                <td id="wishLine"><span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span></td>
                                <td><h2>&pound;0.00</h2></td>
                                <td id="wishLine">
                                    <button class="btn btn-block btn-warning"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span> Remove From Wish List</button>
                                </td>
                            </tr>
                            
                            <!-- Wish List Row -->
                            <tr>
                                <td><a class="thumbnail" id="wishThumb" href="itemPage"><img class="img-responsive" src="img/jacuzzi03.jpg" /></a></td>
                                <td id="textLine">
                                    <h2>Jacuzzi 5000</h2>
                                    <h5>A top of the range jacuzzi with 600 different bubble settings including an equaliser mode that bubbles to your beats.</h5>
                                </td>
                                <td id="wishLine"><span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span></td>
                                <td><h2>&pound;0.00</h2></td>
                                <td id="wishLine">
                                    <button class="btn btn-block btn-warning"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span> Remove From Wish List</button>
                                </td>
                            </tr>
                            
                            <!-- Wish List Row -->
                            <tr>
                                <td><a class="thumbnail" id="wishThumb" href="itemPage"><img class="img-responsive" src="img/hoe01.jpg" /></a></td>
                                <td id="textLine">
                                    <h2>Garden Tool</h2>
                                    <h5>A small garden tool with a ceramic blade.</h5>
                                </td>
                                <td id="wishLine"><span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span></td>
                                <td><h2>&pound;0.00</h2></td>
                                <td id="wishLine">
                                    <button class="btn btn-block btn-warning"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span> Remove From Wish List</button>
                                </td>
                            </tr>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <!-- END OF CONTENT -->
</div>
</body>

</html>