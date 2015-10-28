<!--

    Chris J W Walker
    
    Email Order Form
    
    27/10/2015

-->

<!DOCTYPE HTML>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" th:include="template :: page">

<head th:fragment="header">
    <title>NB Gardens - Email Order</title>
</head>

<body>
    <div th:fragment="content">
        <div class="jumbotron content">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="page-header">
                            <h1 id="productTitle">Email Order Form</h1>
                        </div>
                    </div>
                </div>

                <script src="js/emailUpdated.js" type="text/javascript"></script>
                
                <div class="row">
                    <div class="col-md-12">
                        <h1 id="productTitle"><small>Your Details</small></h1>
                    </div>
                </div>
                   
               
                <div class="row">
                    <div class="col-md-8">

                        <div id="moreThan10" style="display: none" class="alert alert-danger" role="alert"><span class="glyphicon glyphicon-remove-sign" aria-hidden="true"></span><strong> Something isn't quite right! </strong> If you would like to order more than 10 items, please register for an account <strong><a href="loginregister">here</a></strong></div>
                        <form th:action="@{/sendSimpleMail}" method="post">
                            <div class="well">
                                <p><small>Contact Details</small></p>
                                <div class="input-group">
                                    <span class="input-group-addon" id="basic-addon1">First Name</span>
                                    <input type="text" class="form-control" placeholder="First Name" aria-describedby="basic-addon1" id="firstNameInput" name="firstNameInput" />
                                </div>
                                <br />
                                <div class="input-group">
                                    <span class="input-group-addon" id="basic-addon1">Last Name</span>
                                    <input type="text" class="form-control" placeholder="Last Name" aria-describedby="basic-addon1" id="lastNameInput" name="lastNameInput" />
                                </div>
                                <br />
                                <div class="input-group">
                                    <span class="input-group-addon" id="basic-addon1">Email</span>
                                    <input type="text" class="form-control" placeholder="Email Address" aria-describedby="basic-addon1" id="emailInput" name="emailInput" />
                                </div>
                                <br />
                                <div class="input-group">
                                    <span class="input-group-addon" id="basic-addon1">Telephone Number</span>
                                    <input type="text" class="form-control" placeholder="Telephone Number (Landline or mobile)" aria-describedby="basic-addon1" id="telephoneNumberInput" />
                                </div>
                            </div>

                            <div class="well">
                                <p><small>Address Details</small></p>

                                <div class="input-group">
                                    <span class="input-group-addon" id="basic-addon1">Address Line 1</span>
                                    <input type="text" class="form-control" id="0" placeholder="Address Line 1" oninput="updateAddr(0)" aria-describedby="basic-addon1" />
                                </div>
                                <br />
                                <div class="input-group">
                                    <span class="input-group-addon" id="basic-addon1">Address Line 2</span>
                                    <input type="text" class="form-control" id="1" placeholder="Address Line 2" oninput="updateAddr(1)" aria-describedby="basic-addon1" />
                                </div>
                                <br />
                                <div class="input-group">
                                    <span class="input-group-addon" id="basic-addon1">Town or City</span>
                                    <input type="text" class="form-control" id="2" placeholder="Town or City" oninput="updateAddr(2)" aria-describedby="basic-addon1" />
                                </div>
                                <br />
                                <div class="input-group">
                                    <span class="input-group-addon" id="basic-addon1">County</span>
                                    <input type="text" class="form-control" id="3" placeholder="County" oninput="updateAddr(3)" aria-describedby="basic-addon1" />
                                </div>
                                <br />
                                <div class="input-group">
                                    <span class="input-group-addon" id="basic-addon1">Post Code</span>
                                    <input type="text" class="form-control" id="4" placeholder="Post Code" oninput="updateAddr(4)" aria-describedby="basic-addon1" />
                                </div>
                            </div>

                            <div class="well">
                                <p><small>Add items to your order</small></p>

                                <div class="input-group">
                                    <span class="input-group-addon" id="basic-addon1">Select Item</span>
                                    <select class="form-control" id="itemid">
                                        <option th:each="item : ${itemList}" th:value="${item.price}" th:text="${item.itemID} + '  ' + ${item.itemName}"></option>
                                    </select>
                                </div>
                                <br />
                                <a id="addItem" onclick="addItem()" class="btn btn-primary"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Add Item</a>
                                <button class="btn btn-success" type="submit"><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span> Send Your Order</button>
                            </div>
                        </form>
                    </div>

                    <div class="col-md-4">
                        <div class="alert alert-info" role="alert"><span class="glyphicon glyphicon-info-sign" aria-hidden="true"></span><strong> Just so you know!</strong> If you would like to order more than 10 items, register for an account <strong><a href="loginregister">here</a></strong></div>

                        <div class="well">
                            <!-- Total panel -->
                            <div class="panel panel-success">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Item on your Order</h3></div>
                                <div id="itemsOnOrder" class="container">

                                </div>
                            </div>

                            <div class="panel panel-success">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Order Details</h3></div>
                                <div class="container">
                                    <div class="row">
                                        <div class="col-sm-6 panel-body" id="panelLeft">Subtotal:</div>
                                        <div id="subTot" class="col-sm-6 panel-body">&pound;0.00</div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6 panel-body" id="panelLeft">VAT (20%):</div>
                                        <div id="VAT" class="col-sm-6 panel-body">&pound;0.00</div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6 panel-body" id="panelLeft">Postage:</div>
                                        <div id="postage" class="col-sm-6 panel-body">&pound;0.00</div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6 panel-body" id="panelLeft">Total Price:</div>
                                        <div id="total" class="col-sm-6 panel-body">&pound;0.00</div>
                                    </div>
                                </div>
                            </div>

                            <!-- Address Section -->
                            <!-- Address Panel -->
                            <div class="panel panel-success">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Delivery Address</h3></div>
                                <div class="container">
                                    <div class="row">
                                        <div class="col-sm-12 panel-body" id="A0"></div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-12 panel-body" id="A1"></div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-12 panel-body" id="A2"></div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-12 panel-body" id="A3"></div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-12 panel-body" id="A4"></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>