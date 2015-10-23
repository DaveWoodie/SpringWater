
<!--     Chris J W Walker  -->
    
<!--     loginRegister.html -->

<!--     13/10/2015 -->

<!--     Page for viewing specific information about a  -->
<!--     single product -->

<!--     Last Modified by: chrisjwwalker -->
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      th:include="template :: page">

<head th:fragment="header">
    <title>NB Gardens - Item</title>
</head>

<body>
<div th:fragment="content"> 
    <div class="jumbotron content">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="page-header">
                        <h1 id="productTitle" th:text="${item.itemName}"></h1>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-5">
                    <a href="#enlargedImage" class="thumbnail">
                        <img th:src="${item.imageLocation}" alt="..." width="60%" height="60%" />
                    </a>
                </div>
                <div class="col-md-7">
                    <div class="page-header">
                        <!-- Rating If Statement -->
                        <p th:if="${item.rating} == 0" style="text-align:center">
                            <h1 id="desc" th:text="'£' + ${item.price}"></h1>
                            <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                        </p>
                        <p th:if="${item.rating} == 1" style="text-align:center">
                            <h1 id="desc" th:text="'£' + ${item.price}"></h1>
                            <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                        </p>
                        <p th:if="${item.rating} == 2" style="text-align:center">
                            <h1 id="desc" th:text="'£' + ${item.price}"></h1>
                            <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                        </p>
                        <p th:if="${item.rating} == 3" style="text-align:center">
                            <h1 id="desc" th:text="'£' + ${item.price}"></h1>
                            <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                        </p>
                        <p th:if="${item.rating} == 4" style="text-align:center">
                            <h1 id="desc" th:text="'£' + ${item.price}"></h1>
                            <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                        </p>
                        <p th:if="${item.rating} == 5" style="text-align:center">
                            <h1 id="desc" th:text="'£' + ${item.price}"></h1>
                            <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                            <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                        </p>
                    </div>

                    <p th:text="${item.description}"></p>

                    <a class="btn btn-danger btn-lg" href=""><span class="glyphicon glyphicon-star" aria-hidden="true"></span> Add to Wish List</a>
                    <a class="btn btn-warning btn-lg" href="#reviews"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> Reviews</a>
                    <a class="btn btn-info btn-lg" href=""><span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> Add to Basket</a>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="page-header">
                        <h1 id="productTitle">Recommended Items</h1>
                    </div>
                </div>
            </div>

            <div class="row">
                
                <!-- Related Item -->
                <div th:each="item : ${relatedList}" class="col-sm-6 col-md-3">
                    <div class="thumbnail">
                        <a th:href="'itempage+' + ${item.itemID}"><img th:src="${item.imageLocation}" alt="..." /></a>
                        <div class="caption">
                            <h3 style="text-align:center" th:text="${item.itemName}"></h3>
                            <p style="text-align:center" th:text="'£' + ${item.price}"></p>
                            <!-- Rating If Statement -->
                            <p th:if="${item.rating} == 0" style="text-align:center">
                                <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                            </p>
                            <p th:if="${item.rating} == 1" style="text-align:center">
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                            </p>
                            <p th:if="${item.rating} == 2" style="text-align:center">
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                            </p>
                            <p th:if="${item.rating} == 3" style="text-align:center">
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                            </p>
                            <p th:if="${item.rating} == 4" style="text-align:center">
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star-empty ratingsEmpty" aria-hidden="true"></span>
                            </p>
                            <p th:if="${item.rating} == 5" style="text-align:center">
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                            </p>
                            <p>
                                <a th:href="'itempage+' + ${item.itemID}" class="btn btn-primary" role="button"><span class="glyphicon glyphicon-triangle-right" aria-hidden="true"></span> Go to Item</a>
                                <a thhref="'#' + ${item.itemID}" class="btn btn-success" role="button"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> Quick Look</a>
                            </p>
                        </div>
                    </div>
                </div>
                
            </div>
        </div>
    </div>

    <div class="jumbotron content" id="reviews">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="page-header">
                        <h1 id="productTitle">Reviews</h1>
                    </div>

                    <table class="table table-striped">
                        <thead>
                        	<tr>
	                            <th>Reviewer</th>
	                            <th style="width: 22%;text-align:center">Rating</th>
	                            <th>Comment</th>
                            </tr>
                        </thead>

                        <tbody>
                            <tr th:each="review : ${reviewList}">
                                <td th:text="${review.author}"></td>
                                <td th:if="${review.rating} == 0" class="reviewRatings">
                                    <!-- Rating If Statement -->
                                    <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
                                </td>
                                <td th:if="${review.rating} == 1" class="reviewRatings">
                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
                                </td>
                                <td th:if="${review.rating} == 2" class="reviewRatings">
                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
                                </td>
                                <td th:if="${review.rating} == 3" class="reviewRatings">
                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
                                </td>
                                <td th:if="${review.rating} == 4" class="reviewRatings">
                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
                                </td>
                                <td th:if="${review.rating} == 5" class="reviewRatings">
                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                </td>
                                <td th:text="${review.body}"></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

<!-- Modals -->
<div class="modal fade" id="enlargedImage" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel" th:text="${item.itemName}"></h4>
            </div>
            <div class="modal-body">
                <img class="center-block" th:src="${item.imageLocation}" alt="..." width="100%" />
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span> Close</button>
            </div>
        </div>
    </div>
</div>

<div th:each="item : ${relatedList}" class="modal fade" th:id="${item.itemID}" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel" th:text="${item.itemName}"></h4>
            </div>
            <div class="modal-body">
                <img class="center-block" th:src="${item.imageLocation}" alt="..." width="100%" />
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span> Close</button>
            </div>
        </div>
    </div>
</div>

</html>