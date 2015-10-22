<!--     Callum Cooper  -->
    
<!--     registerConfirmedPage.jsp -->

<!--     21/10/2015 -->

<!--     Page for the confirmation of a registered -->
<!--     user. -->

<!--     Last Modified by: c33-cooper -->

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      th:include="template :: page">

<head th:fragment="header">
    <title>NB Gardens - Register Confirmed</title>
    
    <!-- Link javascript fields -->
    <script src="js/registerUser.js" type="text/javascript"></script>
</head>

<body>
<div th:fragment="content"> 
    <!-- Content Area -->
    <div class="jumbotron content">
    	
    	<hr />
    	
    		<div class="container">
	    		<div class="page-header" style="text-align:center">
	                   		<h1>Congratulations, </h1><h1 id="fName"></h1><h1>you are now registered!</h1>
	             </div>
             </div>
    		
    		<p style="text-align:center" id="email"></p>
    		<p style="text-align:center" id="fName"></p>
    		
    		<!-- Script for calling cookie data  -->
    		<script>
				document.getElementById("fName").innerHTML = getCookie("firstName") + " " + getCookie("lastName");
                document.getElementById("email").innerHTML = "A confirmation email has been sent to " + getCookie("email");
			</script>
			<div class="container" style="text-align:center">
					<p id="uniqueNumberRef">customer reference number is </p> <p id="uniqueNum"></p>
			</div>
			
			<!-- Script for creating unique number for user -->
			<script>
				document.getElementById("uniqueNum").innerHTML = getUniqueNumber();
			</script>
    	<hr />
   
    </div>
    <!-- END OF CONTENT -->
    
</div>
</body>

</html>