<!--     Chris J W Walker  -->
    
<!--     loginRegister.html -->

<!--     21/10/2015 -->

<!--     Page for allowing the user to login into NBGardens -->
<!--     or create a new account -->

<!--     Last Modified by: c33-cooper -->
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      th:include="template :: page">

<head th:fragment="header">
    <title>NB Gardens - Login/Register</title>
    <!-- Load in register user javascript files -->
    <script src="js/registerUser.js" type="text/javascript"></script>
    
</head>

<body>
<div th:fragment="content">      
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
                            <input type="text" class="form-control" placeholder="Email Address" aria-describedby="basic-addon1" />
                        </div>
                        <br />
                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon1">Password</span>
                            <input type="password" class="form-control" placeholder="Password" aria-describedby="basic-addon1" />
                        </div>
                        <br />
                        <a href="profile" type="submit" class="btn btn-success"><span class="glyphicon glyphicon-log-in" aria-hidden="true"></span> Login</a>
                    </form>
                    <br />
                    <div class="panel panel-danger">
                        <div class="panel-heading"><span class="glyphicon glyphicon-remove-circle" aria-hidden="true"></span> Problems logging in?</div>
                        <div class="panel-body">
                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span> Forgotten the email address you use to log in?
                            <br />
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
                            	<input type="text" class="form-control" placeholder="First Name" aria-describedby="basic-addon1" id="firstNameInput" />
                        </div>
                        <br />
                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon1">Last Name</span>
                            <input type="text" class="form-control" placeholder="Last Name" aria-describedby="basic-addon1" id="lastNameInput" />
                        </div>
                        <br />
                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon1">Email</span>
                            <input type="text" class="form-control" placeholder="Email Address" aria-describedby="basic-addon1" id="emailInput" />
                        </div>
                        <br />
                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon1">Password</span>
                            <input type="password" class="form-control" placeholder="Password" aria-describedby="basic-addon1" id="passwordInput" />
                        </div>
                        <br />
                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon1">Confirm</span>
                            <input type="password" class="form-control" placeholder="Confirm Password" aria-describedby="basic-addon1" id="confirmPasswordInput" />
                        </div>
                        <br />
                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon1">Date of Birth</span>
                            <input type="text" class="form-control" placeholder="Date of Birth" aria-describedby="basic-addon1" id="dobInput" />
                        </div>
                        <br />
                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon1">Telephone Number</span>
                            <input type="text" class="form-control" placeholder="Telephone Number (Landline or mobile)" aria-describedby="basic-addon1" id="telephoneNumberInput" />
                        </div>
                        <br />
                        	 <a onclick="registerUserDetails(); " class="btn btn-primary"><span class="glyphicon glyphicon-tasks" aria-hidden="true"></span> Register</a>
                        </form>
                    <br />
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
</div>
</body>

</html>