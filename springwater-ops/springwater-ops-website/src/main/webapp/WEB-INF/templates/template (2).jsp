<%@ tag description="Page Template" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	<script src="bootstrap\js\bootstrap.js"></script>
	<link type="text/css" rel="stylesheet" href="bootstrap\css\bootstrap_cosmo.css" />
	<link type="text/css" rel="stylesheet" href="Template.css" />
	<link type="text/css" rel="stylesheet" href="PaymentAgreement.css" />
	<title>NB Gardens</title>
</head>
<body>
	<!----------------------------------------------------------------------------------->
	<!------ Top navbar. Contains logo, search bar and dropdown for mobile--------------->
	<!----------------------------------------------------------------------------------->
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header" id="navbar-header">
			<a class="btn btn-default navbar-toggle collapsed" type="button"
				data-toggle="collapse" data-target="#navbar-collapse"
				id="collapse-top"> <span class="glyphicon glyphicon-th-list"></span>
			</a> <a class="navbar-brand" href="#"> <img id="logo"
				alt="NB Gardens" src="bootstrap\NBGardensLogo.png" />
			</a>
			<div class="row search-row" id="top-search">
				<div>
					<div class="input-group">
						<span class="input-group-btn"> <a class="btn btn-default"
							type="button" id="search-button"> <span
								class="glyphicon glyphicon-search"></span>
						</a>
						</span> <input class="form-control" type="text" id="search-bar">
					</div>
				</div>
			</div>
		</div>
		<!-- /.navbar-header -->
		<!------------------------------------------------------------------------------->
		<!---------- Collect the nav links, forms, and other content for toggling ------->
		<!------------------------------------------------------------------------------->
		<div class="collapse navbar-collapse" id="navbar-collapse">
			<ul class="nav navbar-nav">
				<li><a href="Landing.html" id="home-button-top"> <span
						class="glyphicon glyphicon-home"></span> Home
				</a></li>
			</ul>
			<ul class="nav navbar-nav">
				<li><a href="ProductCatalogue.html" id="home-button-top"> <span
						class="glyphicon glyphicon-gift"></span> Products
				</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown">
					<a href="#" class="button-top dropdown-toggle" id="basket-top" data-toggle="dropdown">
						<span class="glyphicon glyphicon-shopping-cart"></span> Basket <span class="caret"></span>
					</a>
					<ul class="dropdown-menu" id="basket-dropdown">
						<li><a href="Basket.html">View basket</a></li>
						<li><a href="PaymentAgreement.html">Checkout</a></li>
						<li><a href="AddPaymentDetails.html">Review Payment Methods</a></li>
						<li class="divider"></li>
						<li><a href="Landing.html">Cancel Basket</a></li>
					</ul>
				</li>
				<li class="dropdown">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown" id="account-top">
						<span class="glyphicon glyphicon-user"></span> My Account <span class="caret"></span>
					</a>
					<ul class="dropdown-menu" id="account-dropdown">
						<li><a>Logged in as: ... </a></li>
						<li><a href="ChooseAddress.html">View Addresses</a></li>
						<li><a href="OrderTracking.html">Track an Order</a></li>
						<li><a href="UpdateAccount.html">Update your Account</a></li>
						<li><a href="ViewCreditDetails.html">View Credit</a></li>
						<li class="divider"></li>
						<li><a href="Landing.html">Logout</a></li>
					</ul>
				</li>
				<li>
					<a href="About.html" id="about-button-top">
						<span class="glyphicon glyphicon-question-sign"></span> About NB Gardens
					</a>
				</li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> 
	</nav>
	<!----------------------------->
	<!------Content---------------->
	<!----------------------------->
	<jsp:body />
	<!----------------------------->
	<!------Footer----------------->
	<!----------------------------->
	<div id="footer" class="panel-footer">
		<p>
			Credit to Bootstrap <i>(http://getbootstrap.com)</i> for the overall
			website design, as well as Glyphicons <i>(http://glyphicons.com)</i>
			for the Halfling icon set.
		</p>
		<p>
			Using the Readable theme <i>(https://bootswatch.com/readable)</i>
			with our own modifications.
		</p>
	</div>
</body>
</html>