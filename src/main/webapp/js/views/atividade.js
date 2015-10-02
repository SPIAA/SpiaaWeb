function getFormData(obj) {
    var quantidadeCriadouro = document.getElementById("quantidadeCriadouro").value;
    var criadouro = document.getElementById("criadouro");

    var id = document.getElementById("id").value;
    var url = "";
    var domain = "";
    if (document.domain == "localhost") {
        domain = "/Spiaa"
    }
    if (id != null && id != "") {
        url += domain + "/atividade/alterar";
    } else {
        url += domain + "/atividade/novo";
        id = null;
    }
    var grupo = document.getElementById("grupo").value;
    var recipiente = document.getElementById("recipiente").value;
    var jsonData = {
        id: id,
        grupo: grupo,
        recipiente: recipiente
    };
    $.ajax({
        url: url,
        data: JSON.stringify(jsonData),
        jsonData: jsonData,
        method: 'POST',
        dataType: 'text',
        contentType: 'application/x-www-form-urlencoded; charset=iso-8859-1',
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Accept", "application/text");
            xhr.setRequestHeader("Content-Type", "text/plain");
            xhr.overrideMimeType('text/html;charset=iso-8859-1');
        }
    }).done(function (retorno) {
        if (retorno != null) {
            $('#successCreate').modal('show');
        }
        setTimeout(function () {
            document.location.assign(domain + '/criadouro');
        }, 3000);
    }).fail(function () {

    });
}
$(function () {
    $('[data-toggle="tooltip"]').tooltip()
});