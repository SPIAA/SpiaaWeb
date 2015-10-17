
$(document).ready(function () {
    var domain = "";
    if (document.domain == "localhost") {
        domain = "/Spiaa"
    }
    $.getJSON(domain + "/denunciaform", function (result) {
        var options = $("#options");

        for (var i = 0; i < result.length; i++) {
            options.append($("<option />").val(result[i].id).text(result[i].nome));
        }
    });
});

function getFormData() {
    var bairro = $('#options option:selected').val();
    var endereco = $("input[name=endereco").val();
    var numero = $("input[name=numero").val();
    var irregularidade = document.getElementById("irregularidade").value;

    var url = "";
    var domain = "";
    if (document.domain == "localhost") {
        domain = "/Spiaa"
    }

    url = domain + "/denunciaform";

    var jsonData = {
        bairro: {
            id: bairro,
        },
        endereco: endereco,
        numero: numero,
        irregularidade: irregularidade,
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
            document.location.assign(domain + '/');
            $("#endereco").attr("value", "a");
            $("#numero").attr("value", "a");
            $("#irregularidade").attr("value", "a");
            $('#successCreate').modal('hide');
        }, 3000);
    }).fail(function () {

    });
}