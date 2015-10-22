<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      th:include="template :: page">

<head th:fragment="header">
    <title>NB Gardens - Basket</title>
</head>

<body>
<div th:fragment="content">
    <!-- Page Content -->
    <div class="jumbotron content">
        <div class="container">

            <div class="row">

                <!-- Left Column -->
                <div class="col-lg-8" id="leftCol">
                    <div class="container">
                        <h2 id="productTitle">Your Basket</h2>

                        <!-- Item Area -->
                        <div class="well">
                            <div class="panel panel-default">

                                <!-- Table -->
                                <table class="table table-striped">

                                    <!-- Table Headings -->
                                    <thead>
                                        <tr>
                                            <th id="supersubtitle">Item Name</th>
                                            <th id="supersubtitle">Item Price</th>
                                            <th id="supersubtitle">Quantity</th>
                                            <th id="supersubtitle">Subtotal</th>
                                            <th id="supersubtitle">Add / Remove</th>
                                        </tr>
                                    </thead>

                                    <!-- Items -->
                                    <tbody>

                                        <!-- Item Row -->
                                        <tr>
                                            <td>Happy Gnome</td>
                                            <td>&pound;2.99</td>
                                            <td>3</td>
                                            <td>&pound;8.97</td>
                                            <td>
                                                <button class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button>
                                                <button class="btn btn-info"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span></button>
                                                <button class="btn btn-danger"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></button>
                                            </td>
                                        </tr>

                                    </tbody>
                                </table>

                            </div>
                        </div>

                    </div>
                </div>

                <!-- Right Column -->
                <div class="col-lg-4" id="rightCol">
                    <div class="container">

                        <div class="well">

                            <!-- Total panel -->
                            <div class="panel panel-success">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Order Details</h3></div>
                                <div class="container">
                                    <div class="row">
                                        <div class="col-sm-6 panel-body" id="panelLeft">Subtotal:</div>
                                        <div class="col-sm-6 panel-body">&pound;8.97</div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6 panel-body" id="panelLeft">VAT (20%):</div>
                                        <div class="col-sm-6 panel-body">&pound;1.79</div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6 panel-body" id="panelLeft">Postage:</div>
                                        <div class="col-sm-6 panel-body">&pound;3.99</div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6 panel-body" id="panelLeft">Total Price:</div>
                                        <div class="col-sm-6 panel-body">&pound;14.75</div>
                                    </div>
                                </div>
                            </div>

                            <!-- Address Section -->
                            <!-- Address Panel -->
                            <div class="nav nav-stacked panel panel-success" id="sidebar">
                                <div class="panel-heading">Address Options</div>

                                <!-- Dropdown -->
                                <div class="list-group panel">
                                    <a href="#AddressMenu" class="list-group-item strong" data-toggle="collapse" data-parent="#AddressMenu" id="selectAddress">Select Address<i class="fa fa-caret-down"></i></a>
                                    <div class="collapse" id="AddressMenu">
                                        <a href="#" class="list-group-item" data-parent="#AddressMenu" id="option">STREET NAME 1</a>
                                        <a href="#" class="list-group-item" data-parent="#AddressMenu" id="option">STREET NAME 2</a>
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
                                <a href="orderconfirm" class="btn btn-block btn-primary"><img src="https://www.paypalobjects.com/webstatic/i/logo/rebrand/ppcom-white.svg" style="width:40%;height:auto"></a>
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