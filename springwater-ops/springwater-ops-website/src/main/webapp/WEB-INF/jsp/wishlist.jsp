<!--     Chris Boucher  -->
    
<!--     wishlist.jsp -->

<!--     13/10/2015 -->

<!--     Page for viewing a customer's wishlist -->

<!--     Last Modified by: Chris Boucher -->
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      th:include="template :: page">

<head th:fragment="header">
    <title>NB Gardens - Wishlist</title>
</head>

<body>
<div th:fragment="content">
    <!-- Content Area -->
    <div class="jumbotron content">
        <div class="container">
            <div class="row">
                <div class="col-lg-6">
                    <h2 id="productTitle">Your Wish List</h2>
                </div>
                <div class="col-lg-3"></div>
                <div class="col-lg-3">
                    <div class="panel panel-default">
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="Search for..." />
                            <span class="input-group-btn"><button class="btn btn-default" type="button"><span class="glyphicon glyphicon-search" aria-hidden="true"></span> Search</button></span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="well">
                <div class="panel panel-default">
                    <!-- Table -->
                    <table class="table">

                        <!-- Wish List -->
                        <tbody>

                            <!-- Wish List Row -->
                            <tr th:each="item : ${wishlist}">
                                <td><a class="thumbnail" id="wishThumb" th:href="@{/itempage(itemid=${item.itemID})}"><img class="img-responsive" th:src="${item.imageLocation}" /></a></td>
                                <td id="textLine">
                                    <h2 th:text="${item.itemName}"></h2>
                                    <h5 th:text="${item.description}"></h5>
                                </td>
                                <!-- Rating If Statement -->
                                <td th:if="${item.rating} == 0" id="wishline" style="text-align:center">
                                    <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                                </td>
                                <td th:if="${item.rating} == 1" id="wishline" style="text-align:center">
                                    <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                                </td>
                                <td th:if="${item.rating} == 2" id="wishline" style="text-align:center">
                                    <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                                </td>
                                <td th:if="${item.rating} == 3" id="wishline" style="text-align:center">
                                    <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                                </td>
                                <td th:if="${item.rating} == 4" id="wishline" style="text-align:center">
                                    <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                                </td>
                                <td th:if="${item.rating} == 5" id="wishline" style="text-align:center">
                                    <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                </td>
                                <td><h2 th:text="'£' + ${item.price}"></h2></td>
                                <td id="wishLine">
                                    <button class="btn btn-block btn-warning"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span> Remove From Wish List</button>
                                </td>
                            </tr>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <!-- END OF CONTENT -->
</div>
</body>

</html>