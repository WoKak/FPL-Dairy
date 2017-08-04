/**
 * Created by Michał on 2017-08-01.
 */

//main function with anonymous function responsible for processing form submitting
jQuery(document).ready(function($) {

    $("#matchday_form").submit(function(event) {

        enableSearchButton(false);
        event.preventDefault();

        searchMatchViaAjax();
    });
});

//function responsible for AJAX request
function searchMatchViaAjax() {

    var search = {};
    search["number"] = $("#day_number").val();

    $.ajax({
        type : "POST",
        contentType : "application/json",
        url : "/searchMatches",
        data : JSON.stringify(search),
        dataType : 'json',
        timeout : 100000,
        success : function(data) {
            console.log("SUCCESS: ", data);
            displayMatches(data);
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

//function for enabling search button
function enableSearchButton(flag) {
    $("#search").prop("disabled", flag);
}

//function responsible for displaying data
function displayMatches(data) {

    var json = "<h4>Mecze:</h4>";

    var response = JSON.parse(JSON.stringify(data, null, 4));

    var matches = '';

    for(var i = 0; i < response.matches.length; i++) {

        matches += '<p id="match'+ i + '" class="match" onclick="searchNoteViaAjax(' + i + ')">';
        matches += response.matches[i].homeTeam + " ";
        matches += response.matches[i].homeGoals + ":";
        matches += response.matches[i].awayGoals + " ";
        matches += response.matches[i].awayTeam;
        matches += '</p>';
    }

    json += matches;

    $('#games').html(json);
}