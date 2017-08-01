/**
 * Created by Michał on 2017-08-01.
 */
jQuery(document).ready(function($) {

    $("#matchday_form").submit(function(event) {

        enableSearchButton(false);
        event.preventDefault();

        searchViaAjax();

    });

});

function searchViaAjax() {

    var search = {};
    search["number"] = $("#day_number").val();

    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : "/search",
        data : JSON.stringify(search),
        dataType : 'json',
        timeout : 100000,
        success : function(data) {
            console.log("SUCCESS: ", data);
            display(data);
        },
        error : function(e) {
            console.log("ERROR: ", e);
            display(e);
        },
        done : function(e) {
            console.log("DONE");
            enableSearchButton(true);
        }
    });

}

function enableSearchButton(flag) {
    $("#search").prop("disabled", flag);
}

function display(data) {

    var json = "<h4>Mecze:</h4>";

    var response = JSON.parse(JSON.stringify(data, null, 4));

    var matches = '';

    for(var i = 0; i < response.matches.length; i++) {

        matches += '<p>';
        matches += response.matches[i].homeTeam + " ";
        matches += response.matches[i].homeGoals + ":";
        matches += response.matches[i].awayGoals + " ";
        matches += response.matches[i].awayTeam;
        matches += '</p>';
    }

    json += matches;

    $('#games').html(json);
}