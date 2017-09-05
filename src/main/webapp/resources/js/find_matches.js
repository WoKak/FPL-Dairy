/**
 * Created by Michał on 2017-08-01.
 */

//main function with anonymous function responsible for processing form submitting
jQuery(document).ready(function ($) {

    $("#matchday_form").submit(function (event) {

        enableSearchButton(false);
        event.preventDefault();

        searchMatchViaAjax();
    });
});

//function responsible for AJAX request
function searchMatchViaAjax() {

    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/searchMatches?number=" + $("#day_number").val(),
        dataType: 'json',
        timeout: 100000,
        success: function (data) {
            console.log("SUCCESS: ", data);
            displayMatches(data);
        },
        error: function (e) {
            console.log("ERROR: ", e);
        },
        done: function () {
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

    let toDisplay = "<h4>Mecze:</h4>";

    const response = JSON.parse(JSON.stringify(data, null, 4));

    let matches = '';

    let matchToHTML = (response, i) => {

        let toReturn = '';
        toReturn += '<p id="match' + i + '" class="match" onclick="searchNoteViaAjax(' + i + ')">';
        toReturn += response.matches[i].homeTeam + " ";
        toReturn += response.matches[i].homeGoals + ":";
        toReturn += response.matches[i].awayGoals + " ";
        toReturn += response.matches[i].awayTeam;
        toReturn += '</p>';

        return toReturn
    };

    for (let i = 0; i < response.matches.length; i++) {

        matches += matchToHTML(response, i);
    }

    toDisplay += matches;

    $('#games').html(toDisplay);
}