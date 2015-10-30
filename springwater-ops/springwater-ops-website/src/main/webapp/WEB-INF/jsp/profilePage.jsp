<!--     Callum Cooper  -->
    
<!--     profilePage.jps -->

<!--     14/10/2015 -->

<!--     User profile page -->

<!--     Last Modified by: Callum Cooper -->

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      th:include="template :: page">

<head th:fragment="header">
    <title>NB Gardens - Profile</title>
    
    <!-- Load Javascript files -->
    <script src="js/avatars.js" type="text/javascript"></script>
    <script src="js/loginValidator.js" type="text/javascript"></script>
    <script src="bootstrap/js/bootstrap.js" type="text/javascript"></script>
    <link href="bootstrap/css/bootstrap.css" rel="stylesheet" />
    <link href="bootstrap/css/bootstrap-theme.min.css" rel="stylesheet" />

</head>

<body>
<div th:fragment="content">
    <!-- PROFILE PAGE -->
    <div class="container" style="padding-top: 30px;">
        <h1 class="page-header">Summary</h1>
        <div class="row">
            <!-- left column -->
            <div class="col-lg-4">
                <div class="text-center">
                    <img id="myImage" src="img/placeholder.png" class="avatar img-circle img-thumbnail" alt="avatar" />
                    <h6>Choose a profile avatar...</h6>
                    <button type="button" class="btn btn-default" onclick="changeAv01()"><img src="img/av01.png" id="avatarPic" /></button>
                    <button type="button" class="btn btn-default" onclick="changeAv02()" id="av02"><img src="img/av02.png" id="avatarPic" /></button>
                    <button type="button" class="btn btn-default" onclick="changeAv03()" id="av03"><img src="img/av03.png" id="avatarPic" /></button>
					<button type="button" class="btn btn-default" onclick="changeAv04()" id="av04"><img src="img/av04.png" id="avatarPic" /></button>
                </div>
            </div>
			<div class="col-lg-8">
				<h3>Details</h3>
		            <!-- User details -->
		            <div class="col-lg-6">
		                <div class="list-group">
			                <ul>
			                    <li class="list-group-item active">
			                        First Name: <br /></li>
			                    <li class="list-group-item active">
			                        Last Name: </li>
			                </ul>
		                </div>
		                <hr />
		            </div>
		            <!-- /.col-sm-4 -->
		
		            <div class="col-lg-6">
		                <div class="list-group">
			                <ul>
			                    <li class="list-group-item">
			                       <table>
    									<tr th:each="user : ${profile}">
											<td th:text="${user.firstName}"></td>
										</tr>
									</table>
			                    </li>
			                    
			                    <li class="list-group-item">
			                        <table>
    									<tr th:each="user : ${profile}">
											<td th:text="${user.lastName}"></td>
										</tr>
									</table>
			                    </li>
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
	                        <li><a href="orders">Orders</a></li>
						</ul>
	                       <!-- Profile stuff -->
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
	                                   
	                                       	<table>
    											<tr th:each="user : ${profile}">
											        <td th:text="${user.customerID}"></td>
											    </tr>
											</table>
	                                       	
	                                   </div>
	                                   <div class="panel-body">
	                                   <table>
    										<tr th:each="user : ${profile}">
	                                       		<td th:text="${user.username}">...</td>
	                                       	</tr>
										</table>
	                                   </div>
	                                   <div class="panel-body">
	                                   	<table>
    										<tr th:each="user : ${profile}">
	                                       		<td th:text="${user.email}">...</td>
	                                       	</tr>
										</table>
	  
	                                   </div>
	                                   <div class="panel-body">
	                                       <table>
    										<tr th:each="user : ${profile}">
	                                       		<td th:text="${user.dateOfBirth}">...</td>
	                                       	</tr>
										</table>
	                                   </div>
	                                   <div class="panel-body">
	                                        <table>
    										<tr th:each="user : ${profile}">
	                                       		<td th:text="${user.phoneNumber}">...</td>
	                                       	</tr>
										</table>
	                                   </div>
	                                   <div class="panel-body">
	                                       <table>
    										<tr th:each="user : ${profile}">
	                                       		<td th:text="${user.customerCredit}"></td>
	                                       	</tr>
										</table>
	                                   </div>
	                               </div>
	                           </div>
	                       </div>
	                </nav>
	            </div>
            </div>
            <hr />
        </div>
	</div>
</div>
</body>

</html>