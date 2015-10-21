<!--------------------------------------------------------

    Chris J W Walker 
    
    addAddresses.html

    13/10/2015

    Page for customers to manage their addresses. 
    View, add and delete addresses.

    Last Modified by: chrisjwwalker

--------------------------------------------------------->

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
      xmlns:th="http://www.thymeleaf.org"
      th:include="template :: page">

<head th:fragment="header">
    <title>NB Gardens - Addresses</title>
</head>

<body>
<div th:fragment="content">   
    <div class="jumbotron content">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="page-header">
                        <h1 id="productTitle">Manage Delivery Addresses</h1>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-6">
                    <div class="page-header">
                        <h1 id="productTitle"><small>Add Address</small></h1>
                    </div>
                    <form>
                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon1">Address Line 1</span>
                            <input type="text" class="form-control" placeholder="Address Line 1" aria-describedby="basic-addon1">
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon1">Address Line 2</span>
                            <input type="text" class="form-control" placeholder="Address Line 2" aria-describedby="basic-addon1">
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon1">Town or City</span>
                            <input type="text" class="form-control" placeholder="Town or City" aria-describedby="basic-addon1">
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon1">County</span>
                            <input type="text" class="form-control" placeholder="County" aria-describedby="basic-addon1">
                        </div>
                        <br>
                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon1">Post Code</span>
                            <input type="text" class="form-control" placeholder="Post Code" aria-describedby="basic-addon1">
                        </div>
                        <br>
                        <button class="btn btn-primary"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Add Address</button>
                    </form>
                </div>

                <div class="col-md-6">
                    <div class="page-header">
                        <h1 id="productTitle"><small>See Your Addresses</small></h1>
                    </div>

                    <div class="panel panel-success">
                        <div class="panel-heading">
                            <span class="glyphicon glyphicon-home" aria-hidden="true"></span> Home
                        </div>

                        <div class="panel-body">
                            <p>
                                62 Bentley Road
                                <br> Uttoxeter
                                <br> Staffordshire
                                <br> ST14 7EN
                            </p>
                            <button class="btn btn-primary"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> Edit Address</button>
                            <button class="btn btn-danger"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span> Delete Address</button>
                        </div>
                    </div>

                    <div class="panel panel-success">
                        <div class="panel-heading">
                            <span class="glyphicon glyphicon-home" aria-hidden="true"></span> Work
                        </div>

                        <div class="panel-body">
                            <p>
                                NETBuilder LTD
                                <br> Floor 5
                                <br> Anchorage Quay
                                <br> Salford Quays
                                <br> M50 3YJ
                            </p>
                            <button class="btn btn-primary"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> Edit Address</button>
                            <button class="btn btn-danger"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span> Delete Address</button>
                        </div>
                    </div>

                    <div class="panel panel-success">
                        <div class="panel-heading">
                            <span class="glyphicon glyphicon-home" aria-hidden="true"></span> Uni
                        </div>

                        <div class="panel-body">
                            <p>
                                Flat 4 Phoenix Nights
                                <br> Phoenix Street
                                <br> Lancaster
                                <br> LA1 1DD
                            </p>
                            <button class="btn btn-primary"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span> Edit Address</button>
                            <button class="btn btn-danger"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span> Delete Address</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>

</html>