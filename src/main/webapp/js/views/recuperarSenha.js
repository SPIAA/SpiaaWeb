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
    var confirmaSenha = $("input[name=confirmaSenha").val();
    var senha = $("input[name=senha").val();

    if (senha != confirmaSenha) {
        $('#warning').modal('show');
        return;
    }

    var url = "";
    var domain = "";
    if (document.domain == "localhost") {
        domain = "/Spiaa"
    }

    url = domain + "/login/redefinirsenha";

    var userId = $("input[name=userId").val();
    var id = $("input[name=id").val();
    var token = $("input[name=token").val();
    var email = $("input[name=email").val();

    var jsonData = {
        usuario: {
            id: userId,
            email: email,
            senha: senha
        },
        id: id,
        token: token,
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
            } else if (retorno == "error") {
                $('#errorCreate').modal('show');
            }
        }
        setTimeout(function () {
            document.location.assign(domain + '/login');
        }, 3000);
    }).fail(function () {

    });
}

