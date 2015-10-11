function getFormData() {
    if (!$("#form").validationEngine('validate')) {
        return;
    }
    var bairro = new Array();
    $("input[type=checkbox][name='bairro']:checked").each(function () {
        bairro.push($(this).val());
    });

    var usuarioId = $("input[name=usuarioId").val();

    var usuarioBairroList = new Array();
    for (var i = 0; i <= bairro.length; i++) {
        var usuarioBairro = {
            usuario: {
                id: usuarioId,
            },
            bairro: {
                id: bairro[i],
            },
        };
        usuarioBairroList.push(usuarioBairro);
    }
    usuarioBairroList.pop();

    var url = "";
    var domain = "";
    if (document.domain == "localhost") {
        domain = "/Spiaa"
    }

    url = domain + "/usuario/bairrousuario/create";

//    var jsonData = {
//         usuarioBairroList.isArray();
//    };
    $.ajax({
        url: url,
        data: JSON.stringify(usuarioBairroList),
        jsonData: usuarioBairroList,
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
            document.location.assign(domain + '/usuario');
        }, 3000);
    }).fail(function () {

    });
}

