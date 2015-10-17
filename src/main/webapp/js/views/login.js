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
    var url = "";
    var domain = "";
    if (document.domain == "localhost") {
        domain = "/Spiaa"
    }

    url = domain + "/login";

    var usuario = $("input[name=usuario").val();
    var senha = $("input[name=senha").val();

    $.ajax({
        url: url,
        data: {
            usuario: usuario,
            senha: senha,
        },
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
                setTimeout(function () {
                    document.location.assign(domain + '/denuncia');
                }, 3000);
            } else {
                $('#warning').modal('show');
            }
        }
    }).fail(function () {

    });
}

