<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      th:include="template :: page">

<head th:fragment="header">
    <title>NB Gardens - FAQ</title>
</head>

<body>
<div th:fragment="content"> 
    <!-- Page Content -->
    <div class="jumbotron content">
        <div class="container-fluid">

            <div class="col-lg-2"></div>
            
            <!-- FAQ Panel -->
            <div class="col-lg-7">

                <!-- Title -->
                <h2 id="productTitle">Frequently Asked Questions</h2>

                <!-- FAQ Well -->
                <div class="well">

                    <!-- FAQ Question -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h2 id="subtitle">Q: What is NBGardens.co.uk? </h2></div>
                        <div class="panel-body">A: NBGardens.co.uk is a traditional catalogue based in the North-West of England. It sells garden
                        products to its registered customers via phone, mail, and online. NB Gardens specialises in gnomes, gnome accessories
                        and garden ornaments and it prides itself on the speed and quality of its services to its expanding customer base.</div>
                    </div>

                    <!-- FAQ Question -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h2 id="subtitle">Q: What is the returns policy? </h2></div>
                        <div class="panel-body">A: The returns policy is a hassle free way to return anything, so you can return any item 
                        to us within 28 days of receiving your original order, including sale items.</div>
                    </div>

                    <!-- FAQ Question -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h2 id="subtitle">Q: I'm having technical difficulties? </h2></div>
                        <div class="panel-body">A: If you're having problems accessing our website, we suggest that you have the latest 
                        version of your operating system provider e.g. Windows, OSX etc.</div>
                    </div>

                    <!-- FAQ Question -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h2 id="subtitle">Q: I have received an incorrect item in my order.</h2></div>
                        <div class="panel-body">A: We want to sort out any issue with incorrect items straightaway. Please contact our Customer
                        Care team with the order number amd the incorrect item's name and number</div>
                    </div>

                    <!-- FAQ Question -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h2 id="subtitle">Q: Have you received my returned items? </h2></div>
                        <div class="panel-body">A: As soon as your return has been received and checked by our warehouse, we'll email
                        you to let you know.</div>
                    </div>

                    <!-- FAQ Question -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h2 id="subtitle">Q: Insert a question here </h2></div>
                        <div class="panel-body">A: And here is where the detailed answer goes</div>
                    </div>

                    <!-- FAQ Question -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h2 id="subtitle">Q: Insert a question here </h2></div>
                        <div class="panel-body">A: And here is where the detailed answer goes</div>
                    </div>

                    <!-- FAQ Question -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h2 id="subtitle">Q: Insert a question here </h2></div>
                        <div class="panel-body">A: And here is where the detailed answer goes</div>
                    </div>

                    <!-- FAQ Question -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h2 id="subtitle">Q: Insert a question here </h2></div>
                        <div class="panel-body">A: And here is where the detailed answer goes</div>
                    </div>


                </div>
            </div>
            
            <!-- Section Panel -->
            <div class="col-lg-3">
                <div class="well">

                    <!-- Search Field -->
                    <div class="input-group panel">
                        <input type="text" class="form-control" placeholder="Search for a question..." />
                        <span class="input-group-btn">
                            <button class="btn btn-default" type="button"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
                        </span>
                    </div>

                    <!-- FAQ Question -->
                    <div class="panel-heading">
                        <h4 id="supersubtitle">Have a question?</h4></div>
                    <div></div>
                    <div class="panel panel-default">
                        <input type="text" class="form-control" placeholder="Topic..." />
                    </div>
                    <div class="panel panel-default">
                        <input type="text" class="form-control" placeholder="Your email..." />
                    </div>
                    <div class="panel panel-default">
                        <textarea rows="10" cols="auto" class="form-control" placeholder="Details..."></textarea>
                    </div>
                    <div>
                        <button class="btn btn-block btn-primary"><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span> Submit</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>

</html>