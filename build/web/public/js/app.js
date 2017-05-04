$(document).ready(function () {
    $(".button-collapse").sideNav();
    $('select').material_select();
    $('.modal').modal();

    $(".deleteButton").on("click", function() {        
        var id = $(this).attr("data-user");               
        $('#modal_1').modal('open');
        $("#confirmDelete").attr("href", "delete.htm?id=" + id);        
    })
    
});