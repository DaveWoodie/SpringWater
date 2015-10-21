<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      th:include="template :: page">

<head th:fragment="header">
    <title>NB Gardens - Profile</title>
    
    <!-- Load Javascript files -->
    <script src="js/avatars.js" type="text/javascript"></script>

</head>

<body>
<div th:fragment="content">
    <!-- PROFILE PAGE -->
    <div class="container" style="padding-top: 30px;">
        <h1 class="page-header">Summary</h1>
        <div class="row">
            <!-- left column -->
            <div class="col-md-4 col-sm-6 col-xs-12">
                <div class="text-center">
                    <img id="myImage" src="resources/img/placeholder.png" class="avatar img-circle img-thumbnail" alt="avatar">
                    <h6>Choose a profile avatar...</h6>
                    <button type="button" class="btn btn-default" onclick="changeAv01()"><img src="img/av01.png" id="avatarPic"></button>
                    <button type="button" class="btn btn-default" onclick="changeAv02()" id="av02"><img src="img/av02.png" id="avatarPic"></button>
                    <button type="button" class="btn btn-default" onclick="changeAv03()" id="av03"><img src="img/av03.png" id="avatarPic"></button>
					<button type="button" class="btn btn-default" onclick="changeAv04()" id="av04"><img src="img/av04.png" id="avatarPic"></button>
                </div>
            </div>

            <!-- User details -->
            <h3>Details</h3>
            <div class="col-sm-4">
                <div class="list-group">
	                <ul>
	                    <li class="list-group-item active">
	                        First Name: <br /></li>
	                    <li class="list-group-item active">
	                        Last Name: </li>
	                </ul>
                </div>

                <hr>
            </div>
            <!-- /.col-sm-4 -->

            <div class="col-sm-4">
                <div class="list-group">
	                <ul>
	                    <li class="list-group-item">
	                        Joe <br /></li>
	                    
	                    <li class="list-group-item">
	                        Bloggs</li>
	                </ul>
                </div>
                <hr />
            </div>
            <!-- /.col-sm-4 -->

            <!-- Menu for profile, addresses and order nav bar-->
            <div class="masthead">
                <nav>
                    <ul class="nav nav-justified">
                        <li class="active"><a href="#">Profile</a></li>
                        <li><a href="addaddresses">Addresses</a></li>
                        <li><a href="ordersP">Orders</a></li>
					</ul>
                        <!-- Profile stuff -->
                        <div class="col-sm-8">
                            <div class="well">
                                <div class="container">
                                    <div class="col-lg-2">
                                        <div class="panel-body">
                                            CustomerID:
                                        </div>
                                        <div class="panel-body">
                                            Username:
                                        </div>
                                        <div class="panel-body">
                                            Email:
                                        </div>
                                        <div class="panel-body">
                                            Date of Birth:
                                        </div>
                                        <div class="panel-body">
                                            Phone Number:
                                        </div>
                                        <div class="panel-body">
                                            Customer Credit:
                                        </div>
                                    </div>
                                    <div class="col-lg-2">
                                        <div class="panel-body">
                                            123
                                        </div>
                                        <div class="panel-body">
                                            gn0me0
                                        </div>
                                        <div class="panel-body">
                                            ilovegnomes@gnomemail.com
                                        </div>
                                        <div class="panel-body">
                                            01/01/2000
                                        </div>
                                        <div class="panel-body">
                                            01234 567 891
                                        </div>
                                        <div class="panel-body">
                                            &pound;100.00
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                </nav>
            </div>
            <hr />
        </div>
	</div>
</div>
</body>

</html>