$(document).ready(function(){
    $("#option").click(function(){
        $("selectAddress").text() + ' <span class="caret"></span>';
        $(this).parents(".list-group").val($(this).data('value'));
    })(jQuery);
});