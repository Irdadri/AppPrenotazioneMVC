$(document).ready(function () {

    $("#prenotazioni-form").submit(function (event) {

        //stop submit the form, we will post it manually.
        event.preventDefault();

        fire_ajax_submit();

    });

    $('#nuovaPrenotazione').click(function (event) {
        event.preventDefault();
        nuovaPrenotazione();
    });

    $('#dashboardButton').click(function (event) {
        event.preventDefault();
        returnToDashboard();
    });

});

function fire_ajax_submit() {

    var postazione = $("#nPostazione").val();
    var data = $("#dataInizio").val();
    var json = {"nPostazione": postazione, "dataInizio": data};

    $("#btn-search").prop("disabled", true);

    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "prenotazione",
        data: JSON.stringify(json),
        dataType: 'json',
        cache: false,
        timeout: 600000,

        beforeSend: function (xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "application/json");
        },

        success: function (data) {

            console.log("SUCCESS : ", data);
            $("#btn-search").prop("disabled", false);

            const modalBody = document.getElementById("modalBody");
            modalBody.innerHTML = "<p> Dati della tua prenotazione <p/>" +
                "<p>Postazione: " + data.nPostazione + "</p>" +
                "<p>Data: " + data.dataInizio + "</p>";

            const modalElement = document.getElementById("submitModal");
            const modal = new bootstrap.Modal(modalElement);
            modal.show();

            /*
            var respContent  = "";
            respContent += "<span class='success'>Prenotazione was created: [";
            respContent += data.msg + "]</span>";
            $("#responseContent").html(respContent);

             */
        },

        error: function (e) {
            console.log("ERROR : ", e);
            $("#btn-search").prop("disabled", false);

        }
    });

}

function returnToDashboard() {
    window.location.replace(contextPath + "/dashboard/");
}

function nuovaPrenotazione() {
    window.location.replace(contextPath + "/dashboard/prenotazione");
}
