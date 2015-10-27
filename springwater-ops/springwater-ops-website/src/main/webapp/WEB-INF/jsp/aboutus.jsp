<!--     Chris J W Walker  --> 
<!--     aboutus.jsp -->
<!--     13/10/2015 -->
<!--     Page for viewing details on the company -->
<!--     Last Modified by: Chris J W Walker -->
<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      th:include="template :: page">

<head th:fragment="header">
    <title>NB Gardens - About Us</title>
</head>

<body>
<div th:fragment="content">
    <!-- Page Header Jumbotron -->
    <div class="jumbotron content">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="page-header">
                        <h1 id="productTitle">About NBGardens</h1>
                    </div>
                    <p>Find out about our company and meet the team!</p>
                </div>
            </div>
        </div>
    </div>
    <!-- END OF PAGE HEADER -->

    <div class="jumbotron" id="searchBar">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="page-header">
                        <h1 style="color: #ffffff" id="aboutHeadings">The Company</h1>
                    </div>

                    <p style="color: #ffffff">NB Gardens is a traditional catalogue company based in the North-West of England and sells garden products. NB Gardens specialises in gnomes, gnome accessories and garden ornaments and it prides itself on the speed and quality of its service to its expanding customer base. The company is renowned for the quality of its products, sourcing its stock from only the finest suppliers. The company has 600 employees within its distribution centre, call centre and head office - based in Stockport. Within the call centre there are 100 sales representatives who process 2000 orders per NB gardens have been established since 1875.</p>

                </div>
            </div>
        </div>
    </div>


    <div class="jumbotron content">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="page-header">
                        <h1><small id="aboutHeadings">The Team</small></h1>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4"></div>
                <div class="col-md-4">
                    <div class="thumbnail">
                        <p id="placeHolderTeam"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></p>
                        <div class="caption">
                            <h3>David Rose<br />CEO</h3> David joined us after studying Economics at Cambridge and was appointed as CEO 10 years ago.
                        </div>
                    </div>
                </div>
                <div class="col-md-4"></div>
            </div>

            <div class="row">
                <div class="col-md-3">
                    <div class="thumbnail">
                        <p id="placeHolderTeam"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></p>
                        <div class="caption">
                            <h3>Debbie Thorne<br />Chief HR Officer</h3> Debbie's key focus is the wellbeing and development of the employees of NB Gardens. She has over 20 years of experience looking after the staff of a variey of retail companies.
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="thumbnail">
                        <p id="placeHolderTeam"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></p>
                        <div class="caption">
                            <h3>John Mann<br />Chief Ops Officer</h3>
                            <br />
                            <br />
                            <br />
                            <br />
                            <br />
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="thumbnail">
                        <p id="placeHolderTeam"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></p>
                        <div class="caption">
                            <h3>Andrew Herbinson<br />Warehouse Manager</h3> Andrews main focus is managing thw warehouse process and procedures so your order can get to you!
                            <br />
                            <br />
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="thumbnail">
                        <p id="placeHolderTeam"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></p>
                        <div class="caption">
                            <h3>Tauruma Patel<br />Call Center Manager</h3>
                            <br />
                            <br />
                            <br />
                            <br />
                            <br />
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>