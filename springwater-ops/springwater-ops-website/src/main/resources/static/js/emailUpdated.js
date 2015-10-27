var answers = [];

var item1 = ["Red Gnome", "12.99"];
var item2 = ["Sundial", "45.00"];
var item3 = ["Jacuzzi", "399.95"];

var subTotals = [];

var increment = 0;

var tot = 0;

var VAT = 0;

var op1 = 2.99;
var op2 = 5.99;
var op3 = 10.99;

function updateAddr(ID) {
    for (var n = 0; n < document.getElementById(ID).value.length; n++) {
        answers[ID] = document.getElementById(ID).value;
    }
    
    if (document.getElementById(ID).value === "") {
        document.getElementById('A' + ID).style.display = "none";
        document.getElementById('A' + ID).innerHTML = "";
    } else {
        document.getElementById('A' + ID).style.display = "block";
        document.getElementById('A' + ID).innerHTML = answers[ID];
    }
}

function addItem() {
    var itemID = document.getElementById('itemEntry').value;

    var itemsOnOrder = document.getElementById('itemsOnOrder');

    var containerDiv = document.createElement('div');

    var item;

    if (itemID == 1) {
        console.log(item1[0] + " " + item1[1]);
        item = '<div class="row"> <div class="col-sm-6 panel-body" id="panelLeft">' + item1[0] + '</div> <div class="col-sm-6 panel-body">&pound;' + item1[1] + '</div> </div>';
        subTotals.push(item1[1]);
    } else if (itemID == 2) {
        console.log(item2[0] + " " + item2[1]);
        item = '<div class="row"> <div class="col-sm-6 panel-body" id="panelLeft">' + item2[0] + '</div> <div class="col-sm-6 panel-body">&pound;' + item2[1] + '</div> </div>';
        subTotals.push(item2[1]);
    } else if (itemID == 3) {
        console.log(item3[0] + " " + item3[1]);
        item = '<div class="row"> <div class="col-sm-6 panel-body" id="panelLeft">' + item3[0] + '</div> <div class="col-sm-6 panel-body">&pound;' + item3[1] + '</div> </div>';
        subTotals.push(item3[1]);
    } else {
        console.log("Item Doesn't exist");
    }

    subTotal();

    containerDiv.innerHTML = item;

    itemsOnOrder.appendChild(containerDiv);
}

function subTotal() {

    var parsed;
    tot=0;
    for (var i = 0; i < subTotals.length; i++) {
        parsed = parseFloat(subTotals[i]);

        tot += parsed;
    }

    document.getElementById('subTot').innerHTML = "&pound;" + tot.toFixed(2);

    vat();
}

function vat() {

    VAT = tot * 0.2;
    
    var rounded = VAT.toFixed(2);

    document.getElementById('VAT').innerHTML = "&pound;" + rounded;

    postageAndFinal();
}

function postageAndFinal() {

    var total = 0;

    if (subTotals.length < 4) {
        document.getElementById('postage').innerHTML = "&pound;" + op1;
        total = tot + VAT + op1;
        document.getElementById('total').innerHTML = "&pound;" + total.toFixed(2);
    } else if (subTotals.length < 10) {
        document.getElementById('postage').innerHTML = "&pound;" + op2;
        total = tot + VAT + op2;
        document.getElementById('total').innerHTML = "&pound;" + total.toFixed(2);
    } else {
        document.getElementById('postage').innerHTML = "&pound;" + op3;
        total = tot + VAT + op3;
        total = tot + VAT + op3;
        document.getElementById('total').innerHTML = "&pound;" + total.toFixed(2);
    }
}

var MongoClient = require('mongodb').MongoClient
  , assert = require('assert');
 
// Connection URL 
var url = 'mongodb://localhost:27017/nbgardensdata';
// Use connect method to connect to the Server 
MongoClient.connect(url, function(err, db) {
  assert.equal(null, err);
  console.log("Connected correctly to server");
 
  db.close();
});
