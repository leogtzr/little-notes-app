$(document).ready(function () {

    $('#alert').hide();
    $('#alert_error').hide();

    function getContextPath() {
       return window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));
    }

    $('#addnote').on('submit', function(e) {


        console.log('The context path is: ');
        console.log(getContextPath());

        var path = getContextPath();

        console.log('End ... ');

        var currentForm = this;
        e.preventDefault();
        var text = $('#text').val();

        $.ajax({
            url: path + '/notes',
            type: 'POST',
            data: JSON.stringify({text: text, id: 3}),
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function(data) {
                $('#text').val('');
                $("#alert").fadeTo(2000, 500).slideUp(500, function() {
                    $("#alert").slideUp(500);
                });
            },
            error: function(data) {
                $("#alert_error").fadeTo(2000, 500).slideUp(500, function() {
                    $("#alert_error").slideUp(500);
                });
            }
        });

    });

});