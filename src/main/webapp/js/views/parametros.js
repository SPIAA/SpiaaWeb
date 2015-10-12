$(function () {
    $('[data-toggle="tooltip"]').tooltip()
});
jQuery(document).ready(function () {
    // binds form submission and fields to the validation engine
    jQuery("#form").validationEngine('attach', {promptPosition: "bottomLeft", autoPositionUpdate: true});
});
function getFormData() {
    if (!$("#form").validationEngine('validate')) {
        return;
    }
    var id = $("input[name=id").val();
    var url = "";
    var domain = "";
    if (document.domain == "localhost") {
        domain = "/Spiaa"
    }
    if (id != null && id != "") {
        url = domain + "/parametros/alterar";
    } else {
        url = domain + "/parametros/novo";
        id = null;
    }
    var caminhoHostName = $("input[name=caminhoHostName").val();
    var smtp = $("input[name=smtp").val();
    var porta = $("input[name=porta").val();
    var email = $("input[name=email").val();
    var senha = $("input[name=senha").val();

    var jsonData = {
        id: id,
        smtp: smtp,
        caminhoHostName: caminhoHostName,
        porta: porta,
        email: email,
        senha: senha,
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
            if (retorno == "success") {
                $('#successCreate').modal('show');
            }
        }
        setTimeout(function () {
            document.location.assign(domain + '/parametros');
        }, 3000);
    }).fail(function () {

    });
}

