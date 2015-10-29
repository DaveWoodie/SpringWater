<!--     Callum Cooper  -->  
<!--     index.jsp -->
<!--     13/10/2015 -->
<!--     Website Landing Page  -->
<!--     Last Modified by: Chris Boucher -->
<!DOCTYPE html>
<!--     Callum Cooper  -->
    
<!--     openOrdersPage.jps -->

<!--     14/10/2015 -->

<!--     Template for the cancelled orders page -->

<!--     Last Modified by: Callum Cooper -->

<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      th:include="template :: page">

<head th:fragment="header">
    <title>NB Gardens</title>
</head>

<body>
<div th:fragment="content">    
    <!-- Page Content -->
    <div class="jumbotron content">
        
        <script th:inline="javascript">
            var user = /*[[${user}]]*/ null;
            if(user != null) {
                document.cookie = "userName = " + user.firstName;
            }
            else {
                deleteCookie("userName");
            }
            document.getElementById("basketCount").innerHTML = getCookies("itemCount");
            if(getCookies("userName") != null) {
                document.getElementById("userName").innerHTML = " " + getCookies("userName");
                document.getElementById("userButton").setAttribute("href","profile");
                document.getElementById("logout").style.display = "";
            }
            else
            {
                document.getElementById("userName").innerHTML = " Login/Register";
                document.getElementById("userButton").setAttribute("href","loginregister");
                document.getElementById("logout").style.display = 'none';
            }
        </script>
        
        <!-- ******************************* Carousel Gnome Featured ************************************* -->        
        <div class="container-fluid">
                <div class="row">
                        <!-- Left Panel -->
                        <div class="col-lg-4">
                            <img class="img-responsive thumbnail" id="carouselThumb" src="img/logo.png" alt="" />
                            <div class="panel panel-default">
                                <div class="panel-body" style="text-align:center">
                                    Welcome to NB Gardens. We are a retailer of high quality garden products who pride ourselves in our high quality gnomes.
                                </div>
                            </div>
                        </div>
                
                        <!-- Right Panel -->
                        <div class="col-lg-8">
                                <img src="img/header.jpg" class="img-responsive" style="width:auto;height:auto" />
                        </div>
                </div>
        </div>
            
        <!-- Gnome Featured Carousel -->
        <div class="container-fluid">
                <h1>Featured Items</h1>
                <div th:each="item : ${featured}" class="col-lg-2">
                    <div class="item">
                                <a class="thumbnail" th:href="@{/itempage(itemid=${item.itemID})}"><img class="img-responsive" th:src="${item.imageLocation}" /></a>
                    </div>
                </div>
        </div>
        <!-- /container -->

        
        <div class="container-fluid">
            <div class="rows">
                
                <!-- Most Popular Carousel -->
                <div class="col-lg-6">
                    <h2>Most Popular Items</h2>

                    <div id="carousel-popular" class="carousel slide" data-ride="carousel">

                        <ol class="carousel-indicators">
                            <li data-target="#carousel-popular" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-popular" data-slide-to="1"></li>
                            <li data-target="#carousel-popular" data-slide-to="2"></li>
                        </ol>

                        <div class="carousel-inner" role="listbox">
                            <!-- Gnome Carousel Images -->
                            <div class="item active">
                                <div class="container-fluid">
                                    <div class="row">
                                        <div th:each="item : ${mostpopular1}" class="col-lg-6">
                                            <a class="thumbnail" id="carouselThumb" th:href="@{/itempage(itemid=${item.itemID})}"><img class="img-responsive" th:src="${item.imageLocation}" /></a> 
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- Gnome Carousel Images -->
                            <div class="item">
                                <div class="container-fluid">
                                    <div class="row">
                                        <div th:each="item : ${mostpopular2}" class="col-lg-6">
                                            <a class="thumbnail" id="carouselThumb" th:href="@{/itempage(itemid=${item.itemID})}"><img class="img-responsive" th:src="${item.imageLocation}" /></a> 
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- Gnome Carousel Images -->
                            <div class="item">
                                <div class="container-fluid">
                                    <div class="row">
                                        <div th:each="item : ${mostpopular3}" class="col-lg-6">
                                            <a class="thumbnail" id="carouselThumb" th:href="@{/itempage(itemid=${item.itemID})}"><img class="img-responsive" th:src="${item.imageLocation}" /></a> 
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- Carousel Control Buttons -->
                        <a class="left carousel-control" href="#carousel-popular" role="button" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#carousel-popular" role="button" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>
                </div>
                
                <!-- Your Wishlist Carousel -->
                <div class="col-lg-6">
                    <h2>Items On Your Wishlist</h2>

                    <div id="carousel-wishlist" class="carousel slide" data-ride="carousel">

                        <ol class="carousel-indicators">
                            <li data-target="#carousel-wishlist" data-slide-to="0" class="active"></li>
                            <li data-target="#carousel-wishlist" data-slide-to="1"></li>
                            <li data-target="#carousel-wishlist" data-slide-to="2"></li>
                        </ol>

                        <div class="carousel-inner" role="listbox">
                            <!-- Gnome Carousel Images -->
                            <div class="item active">
                                <div class="container-fluid">
                                    <div class="row">
                                        <div th:each="item : ${wishlist1}" class="col-lg-6">
                                            <a class="thumbnail" id="carouselThumb" th:href="@{/itempage(itemid=${item.itemID})}"><img class="img-responsive" th:src="${item.imageLocation}" /></a> 
                                        </div>
                                        
                                    </div>
                                </div>
                            </div>

                            <!-- Gnome Carousel Images -->
                            <div class="item">
                                <div class="container-fluid">
                                    <div class="row">
                                        <div th:each="item : ${wishlist2}" class="col-lg-6">
                                            <a class="thumbnail" id="carouselThumb" th:href="@{/itempage(itemid=${item.itemID})}"><img class="img-responsive" th:src="${item.imageLocation}" /></a> 
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <!-- Gnome Carousel Images -->
                            <div class="item">
                                <div class="container-fluid">
                                    <div class="row">
                                        <div th:each="item : ${wishlist3}" class="col-lg-6">
                                            <a class="thumbnail" id="carouselThumb" th:href="@{/itempage(itemid=${item.itemID})}"><img class="img-responsive" th:src="${item.imageLocation}" /></a> 
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- Carousel Control Buttons -->
                        <a class="left carousel-control" href="#carousel-wishlist" role="button" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="right carousel-control" href="#carousel-wishlist" role="button" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>   
                </div>
            </div>
        <!-- /container -->
        </div>
    </div>
</div>

</body>

</html>