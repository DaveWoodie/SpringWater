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
                    <div class="col-md-8">
                        <h1 id="productTitle"><small>Your Details</small></h1>
                        <form>
                            <div class="well">
                                <p><small>Contact Details</small></p>
                                <div class="input-group">
                                    <span class="input-group-addon" id="basic-addon1">First Name</span>
                                    <input type="text" class="form-control" placeholder="First Name" aria-describedby="basic-addon1" id="firstNameInput" />
                                </div>
                                <br />
                                <div class="input-group">
                                    <span class="input-group-addon" id="basic-addon1">Last Name</span>
                                    <input type="text" class="form-control" placeholder="Last Name" aria-describedby="basic-addon1" id="lastNameInput" />
                                </div>
                                <br />
                                <div class="input-group">
                                    <span class="input-group-addon" id="basic-addon1">Email</span>
                                    <input type="text" class="form-control" placeholder="Email Address" aria-describedby="basic-addon1" id="emailInput" />
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
                                    <span class="input-group-addon" id="basic-addon1">Item Code</span>
                                    <input id="itemEntry" type="text" class="form-control" placeholder="Item Code" aria-describedby="basic-addon1" />
                                </div>
                                <br />
                                <a id="addItem" onclick="addItem()" class="btn btn-primary"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Add Item</a>
                            </div>
                        </form>
                    </div>

                    <div class="col-md-4">
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
                                        <div id="subTot" class="col-sm-6 panel-body"></div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6 panel-body" id="panelLeft">VAT (20%):</div>
                                        <div id="VAT" class="col-sm-6 panel-body"></div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6 panel-body" id="panelLeft">Postage:</div>
                                        <div id="postage" class="col-sm-6 panel-body"></div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6 panel-body" id="panelLeft">Total Price:</div>
                                        <div id="total" class="col-sm-6 panel-body"></div>
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

                            <!-- Address Options -->
                            <div class="panel" style="background:none">
                                <a href="addaddresses" class="btn btn-block btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Add Address</a>
                                <a href="addaddresses" class="btn btn-block btn-info"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> Edit Address</a>
                            </div>

                            <!-- Accept Button -->
                            <div class="panel" style="background:none" id="paymentDiv">
                                <a href="orderconfirm" class="btn btn-block btn-primary"><img src="https://www.paypalobjects.com/webstatic/i/logo/rebrand/ppcom-white.svg" style="width:40%;height:auto" /></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>