/**
 * Created by Michał on 2017-08-02.
 */

/*$("#games").on('click', '#games p', function (event) {

    enableSearchButton(false);
    event.preventDefault();

    var id = this.id;
    searchNoteViaAjax(id);
});*/

function searchNoteViaAjax(id) {

    var search = {};
    search["position"] = id;

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "/searchNote",
        data: JSON.stringify(search),
        dataType: 'json',
        timeout: 100000,
        success: function (data) {
            console.log("SUCCESS: ", data);
            displayNote(data);
        },
        error: function (e) {
            console.log("ERROR: ", e);
            displayNote(e);
        },
        done: function (e) {
            console.log("DONE");
            enableSearchButton(true);
        }
    });
}

function displayNote(data) {

    var response = JSON.parse(JSON.stringify(data, null, 4));

    var json = "<p>" + response.note + "</p>";

    $('#note').html(json);
}