
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
                    <a href="#" class="thumbnail" data-toggle="modal" data-target="#enlargedImage">
                        <img th:src="${item.imageLocation}" alt="..." width="60%" height="60%" />
                    </a>
                </div>
                <div class="col-md-7">
                    <div class="page-header">
                        <h1 id="desc" th:text="'£' + ${item.price}"></h1>
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
                <div class="col-sm-6 col-md-3">
                    <div class="thumbnail">
                        <a href="itempage"><img src="img/placeholder2.png" alt="..." /></a>
                        <div class="caption">
                            <h3>Recommended Item 1</h3>
                            <p>&pound;X.XX</p>
                            <p>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star-empty ratings" aria-hidden="true"></span>
                            </p>
                            <p>
                                <a href="itempage" class="btn btn-primary" role="button"><span class="glyphicon glyphicon-triangle-right" aria-hidden="true"></span> Go to Item</a>
                                <a href="#" class="btn btn-success" data-toggle="modal" data-target="#RI1" role="button"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> Quick Look</a>
                            </p>
                        </div>
                    </div>
                </div>

                <div class="col-sm-6 col-md-3">
                    <div class="thumbnail">
                        <a href="itempage"><img src="img/placeholder2.png" alt="..." /></a>
                        <div class="caption">
                            <h3>Recommended Item 2</h3>
                            <p>&pound;X.XX</p>
                            <p>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star-empty ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star-empty ratings" aria-hidden="true"></span>
                            </p>
                            <p>
                                <a href="itempage" class="btn btn-primary" role="button"><span class="glyphicon glyphicon-triangle-right" aria-hidden="true"></span> Go to Item</a>
                                <a href="#" class="btn btn-success" data-toggle="modal" data-target="#RI2" role="button"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> Quick Look</a>
                            </p>
                        </div>
                    </div>
                </div>

                <div class="col-sm-6 col-md-3">
                    <div class="thumbnail">
                        <a href="itempage"><img src="img/placeholder2.png" alt="..." /></a>
                        <div class="caption">
                            <h3>Recommended Item 3</h3>
                            <p>&pound;X.XX</p>
                            <p>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                            </p>
                            <p>
                                <a href="itempage" class="btn btn-primary" role="button"><span class="glyphicon glyphicon-triangle-right" aria-hidden="true"></span> Go to Item</a>
                                <a href="#" class="btn btn-success" data-toggle="modal" data-target="#RI3" role="button"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> Quick Look</a>
                            </p>
                        </div>
                    </div>
                </div>

                <div class="col-sm-6 col-md-3">
                    <div class="thumbnail">
                        <a href="itemPage"><img src="img/placeholder2.png" alt="..." /></a>
                        <div class="caption">
                            <h3>Recommended Item 4</h3>
                            <p>&pound;X.XX</p>
                            <p>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star-empty ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star-empty ratings" aria-hidden="true"></span>
                                <span class="glyphicon glyphicon-star-empty ratings" aria-hidden="true"></span>
                            </p>
                            <p>
                                <a href="itempage" class="btn btn-primary" role="button"><span class="glyphicon glyphicon-triangle-right" aria-hidden="true"></span> Go to Item</a>
                                <a href="#" class="btn btn-success" data-toggle="modal" data-target="#RI4" role="button"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span> Quick Look</a>
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
	                            <th style="width: 22%">Rating</th>
	                            <th>Comment</th>
                            </tr>
                        </thead>

                        <tbody>
                            <tr>
                                <td>GnomeFanatic616</td>
                                <td class="reviewRatings">
                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
                                </td>
                                <td>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua</td>
                            </tr>

                            <tr>
                                <td>Garden_Warrior</td>
                                <td class="reviewRatings">
                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                </td>
                                <td>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua</td>
                            </tr>

                            <tr>
                                <td>Gn0m3Gardener</td>
                                <td class="reviewRatings">
                                    <span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
                                    <span class="glyphicon glyphicon-star-empty" aria-hidden="true"></span>
                                </td>
                                <td>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua</td>
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
                <h4 class="modal-title" id="myModalLabel">Product Name</h4>
            </div>
            <div class="modal-body">
                <img class="center-block" src="img/placeholder2.png" alt="..." width="100%" />
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span> Close</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="RI1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Product Name</h4>
            </div>
            <div class="modal-body">
                <img class="center-block" src="img/placeholder2.png" alt="..." width="100%" />
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span> Close</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="RI2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Product Name</h4>
            </div>
            <div class="modal-body">
                <img class="center-block" src="img/placeholder2.png" alt="..." width="100%" />
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span> Close</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="RI3" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Product Name</h4>
            </div>
            <div class="modal-body">
                <img class="center-block" src="img/placeholder2.png" alt="..." width="100%" />
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span> Close</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="RI4" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Product Name</h4>
            </div>
            <div class="modal-body">
                <img class="center-block" src="img/placeholder2.png" alt="..." width="100%" />
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-dismiss="modal"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span> Close</button>
            </div>
        </div>
    </div>
</div>

</html>