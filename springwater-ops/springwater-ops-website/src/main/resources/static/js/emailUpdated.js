var answers = [];

var item1 = ["Red Gnome", "12.99"];
var item2 = ["Sundial", "45.00"];
var item3 = ["Jacuzzi", "399.95"];

var subTotals = [];
var sublength = subTotals.length;
var orderLine = [];

var increment = 0;

var tot = 0;

var VAT = 0;

var op1 = 2.99;
var op2 = 5.99;
var op3 = 10.99;

var itemCount = 0;

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

    if (itemCount == 10) {
        document.getElementById('moreThan10').style.display = "block";
    } else {

        document.getElementById('moreThan10').style.display = "none";

        var containerDiv = document.createElement('div');

        var selector = document.getElementById('itemid');
        var price = selector.options[selector.selectedIndex].value;
        var itemInf = selector.options[selector.selectedIndex].text;

        subTotals[increment] = price;
        var temp = "%0A" + itemInf + "%20@%20£" + price + "%0A"; 
        var replace = temp.replace(" ", "%20");
        orderLine[increment] = replace;
        console.log(orderLine[increment]);
        console.log(orderLine.length);

        item = '<div id="item' + increment + '" class="row"> <div class="col-sm-5 panel-body" id="panelLeft">' + itemInf + '</div> <div class="col-sm-2 panel-body">' + price + '</div> <div class="col-sm-5 panel-body text-center"><button onclick="removeItem(' + increment + ')" class="btn btn-danger"><span class="glyphicon glyphicon-remove" aria-hidden="true"></span>Remove</button></div> </div>';

        subTotal();

        containerDiv.innerHTML = item;

        itemsOnOrder.appendChild(containerDiv);

        increment++;
        itemCount++;
    }
}

function subTotal() {

    var parsed;
    tot = 0;
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


    console.log(checkArray());


    if (checkArray()) {
        document.getElementById('postage').innerHTML = "&pound;0.00";
        document.getElementById('total').innerHTML = "&pound;0.00";
        document.getElementById('subTot').innerHTML = "&pound;0.00";
        document.getElementById('VAT').innerHTML = "&pound;0.00";
    } else if (subTotals.length < 4) {
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

function removeItem(divID) {

    document.getElementById('moreThan10').style.display = "none";
    
    var id = "item" + divID;

    var element = document.getElementById(id);
    element.parentNode.removeChild(element);

    subTotals[divID] = 0.00;

    subTotal();

    itemCount--;
}

function checkArray() {
    for (var i = 0; i < subTotals.length; i++) {
        if (subTotals[i] != 0.00) {
            return false;
        }
    }

    return true;
}

function mail() {
    var name = document.getElementById('firstNameInput').value + "%20" + document.getElementById('lastNameInput').value;
    var email = document.getElementById('emailInput').value;
    var phone = document.getElementById('telephoneNumberInput').value;
    var addr = document.getElementById('0').value + "%0A" + document.getElementById('1').value + "%0A" + document.getElementById('2').value + "%0A" + document.getElementById('3').value + "%0A" + document.getElementById('4').value;
    
    var orderInf = "%0A%0AOrder%20Information:%0A";
    var ol;
    for(var i = 0; i < orderLine.length; i++) {
        ol = orderInf.concat(orderLine[i]);
    }
    
    var body = "Contact Details:%0AEmail:%20" + email + "%0APhone:%20" + phone + "%0AAddress:%0A" + addr + ol;

    window.open('mailto:Chris.Walker@qa.com?subject=Order%20from%20' + name + '&body=' + body);
}

















