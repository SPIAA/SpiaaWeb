
jQuery(document).ready(function () {
    // binds form submission and fields to the validation engine
    jQuery("#form").validationEngine('attach', {promptPosition: "bottomLeft", autoPositionUpdate: true});
});
function getFormData() {
    var id = document.getElementById("id").value;
    var url  = "";
    if(document.domain=="localhost"){
        url = "/Spiaa"
    }

    if (id != null && id != "") {
        url += "/criadouro/alterar";
    } else {
    url += "/criadouro/novo";
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
            document.location.assign('/criadouro');
        }, 3000);
    }).fail(function () {

    });
}

