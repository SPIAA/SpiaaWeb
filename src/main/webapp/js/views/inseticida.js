jQuery(document).ready(function () {
    // binds form submission and fields to the validation engine
    jQuery("#form").validationEngine('attach', {promptPosition: "bottomLeft", autoPositionUpdate: true});
});
function getFormData() {
    var id = document.getElementById("id").value;
    var url = "";
    if (document.domain == "localhost") {
        url = "/Spiaa"
    }
    if (id != null && id != "") {
        url += "/inseticida/alterar";
    } else {
    url += "/inseticida/novo";
        id = null;
    }
    var nome = document.getElementById("nome").value;
    var unidade = document.getElementById("unidade").value;
    var jsonData = {
        id: id,
        nome: nome,
        unidade: unidade
    };
    $.ajax({
        url: url,
        data: JSON.stringify(jsonData),
        jsonData: jsonData,
        method: 'POST',
        dataType: 'text',
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
            document.location.assign('/Spiaa/inseticida');
        }, 3000);
    }).fail(function () {
    });

}


