<!-- Created by Chris Boucher -->
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      th:include="template :: page">

    <head th:fragment="header">
        <title>NB Gardens - Error</title>
    </head>

    <body>
        <div th:fragment="content">
            
            <!-- Content Area -->
            <div class="jumbotron content">

                <!-- Top Header -->
                <div class="jumbotron">
                    <div class="container">
                        <div class="row" style="text-align:center">
                            <div class="col-lg-4"></div>
                            <div class="col-lg-4">
                                <img class="img-responsive thumbnail" id="carouselThumb" src="img/errorGnome.png" alt="" />
                            </div>
                        </div>
                        <div class="col-lg-4"></div>
                        <div class="row" style="text-align:center">
                            <h1>Oops, something has gone wrong!</h1>
                            <h2><a href="/" >We suggest you go back to the home page.</a></h2>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>