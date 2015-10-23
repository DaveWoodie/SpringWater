var answers = [];

function updateAddr(ID) {
    for(var n = 0; n < document.getElementById(ID).value.length; n++) {
        answers[ID] = document.getElementById(ID).value;
    }
    
    document.getElementById('A'+ID).innerHTML = answers[ID];
}