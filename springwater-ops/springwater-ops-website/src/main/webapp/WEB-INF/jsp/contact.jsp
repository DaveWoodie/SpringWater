<!--------------------------------------------------------

    Chris J W Walker 
    
    contact.html

    13/10/2015

    Page providing contact information for NBGardens

    Last Modified by: chrisjwwalker

--------------------------------------------------------->

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      th:include="template :: page">

<head th:fragment="header">
    <title>NB Gardens - Contact</title>
</head>

<body>
<div th:fragment="content">    

    <div class="jumbotron content">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="page-header">
                        <h1 id="productTitle">Contact us!</h1>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4">
                    <p><span class="glyphicon glyphicon-globe" aria-hidden="true"></span> Stockport, United Kingdom</p>
                    <p><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span> enquires@nbgardens.co.uk</p>
                    <p><span class="glyphicon glyphicon-phone-alt" aria-hidden="true"></span> 0161 987 3652</p>
                </div>

                <div class="col-md-8">
                    <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d38045.55352152961!2d-2.1840812375372036!3d53.417560682172784!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x487a3515ca33c427%3A0xf418f67b823efe48!2sStockport!5e0!3m2!1sen!2suk!4v1444664424719" width="100%" height="600" style="border:0"></iframe>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>