/**
 * Created by Michał on 2017-08-02.
 */

//function responsible for AJAX request
function searchNoteViaAjax(id) {

    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: "/searchNote?position=" + id,
        dataType: 'json',
        timeout: 100000,
        success: function (data) {
            console.log("SUCCESS: ", data);
            displayNote(data);
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

//function responsible for displaying data
function displayNote(data) {

    const response = JSON.parse(JSON.stringify(data, null, 4));

    const toDisplay = "<p>" + response.note + "</p>";

    $('#note').html(toDisplay);
}