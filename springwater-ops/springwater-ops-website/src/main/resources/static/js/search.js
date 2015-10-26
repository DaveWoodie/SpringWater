function search() {
    var searchString = document.getElementById('searchBox').value;
    var category = document.getElementById('category').value;
    var colour = document.getElementById('colour').value;
    var url = '/items?';
    if(searchString != '') {
        var string = 'search=' + searchString + '&';
        url = url + string;
    }
    if(category != '') {
        var string = 'category=' + category + '&';
        url = url + string;
    }
    if(colour != '') {
        var string = 'colour=' + colour + '&';
        url = url + string;
    }
        
    alert('Search value = ' + url);
}