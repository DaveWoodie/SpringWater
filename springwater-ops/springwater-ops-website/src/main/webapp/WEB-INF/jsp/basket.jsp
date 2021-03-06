<!--     Chris Boucher  -->
<!--     basket.jsp -->
<!--     Page for viewing the customer's basket -->
<!--     Last Modified by: Chris Boucher -->
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      th:include="template :: page">

<head th:fragment="header">
    <title>NB Gardens - Basket</title>
</head>

<body>
<div th:fragment="content">
    
    <script th:inline="javascript">
        var basketSize= /*[[${basket.getSize()}]]*/ '0';
        document.cookie = "itemCount = " + basketSize;
        document.getElementById("basketCount").innerHTML = getCookies("itemCount");
    </script>
    
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
                                        <!-- NOTE ******* th:each is same as a foreach loop, that loops through the items
                                        					in the basket!!!! **** -->
                                        <tr th:each="itemLine : ${basket.itemList}">
                                            <td><a th:href="@{/itempage(itemid=${itemLine.item.itemID})}" th:text="${itemLine.item.itemName}" style="color:black"></a></td>
                                            <td th:text="'£'+${itemLine.item.formattedPrice()}"></td>
                                            <td th:text="${itemLine.quantity}"></td>
                                            <td th:text="'£'+${itemLine.formattedTotalPrice()}"></td>
                                            <td>
                                                <a th:href="@{/editquantity(itemid=${itemLine.item.itemID},quantity='1')}" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></a>
                                                <a th:href="@{/editquantity(itemid=${itemLine.item.itemID},quantity='-1')}" class="btn btn-info"><span class="glyphicon glyphicon-minus" aria-hidden="true"></span></a>
                                                <a th:href="@{/removeitem(itemid=${itemLine.item.itemID})}" class="btn btn-danger"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span></a>
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
                                        <div class="col-sm-6 panel-body" th:text="'£'+${basket.formattedGrandTotal()}"></div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6 panel-body" id="panelLeft">VAT (20%):</div>
                                        <div class="col-sm-6 panel-body" th:text="'£'+${basket.formattedVAT()}"></div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6 panel-body" id="panelLeft">Postage:</div>
                                        <div class="col-sm-6 panel-body" th:text="'£'+${basket.formattedPostage()}"></div>
                                    </div>
                                    <div class="row">
                                        <div class="col-sm-6 panel-body" id="panelLeft">Total Price:</div>
                                        <div class="col-sm-6 panel-body" th:text="'£'+${basket.formattedFullTotal()}"></div>
                                    </div>
                                </div>
                            </div>

                            <!-- Address Section -->
                            <div class="panel">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Address</h3>
                                </div>
                            </div>
                            <!-- Address Panel -->
                            <div class="form-group">
                                <select class="form-control" id="address">
                                    <option th:each="address : ${user.addressList}" th:value="${address.getFirstLine()}" th:text="${address.getFirstLine()}"></option>
                                </select>
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
</div>
</body>

</html>