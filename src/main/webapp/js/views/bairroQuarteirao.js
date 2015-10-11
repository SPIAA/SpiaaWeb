jQuery(document).ready(function () {
    // binds form submission and fields to the validation engine
    jQuery("#form").validationEngine('attach', {promptPosition: "bottomLeft", autoPositionUpdate: true});
});


function novoQuarteirao() {
    $('#novoQuarteirao').modal('show');
    $("#labelDescricao").attr("hidden", "true");
    $("#idQuarteirao").attr("value", "");
    $("#descricaoQuarteirao").attr("value", "");
    $("#quantidadeQuarteirao").attr("type", "number");
}
function alterarQuarteirao(obj) {
    var $row = $(obj).closest("tr");    // Find the row
    var $idQuarteirao = $row.find(".idquarteirao").text(); // Find the text
    var $descricaoQuarteirao = $row.find(".descricaoQuarteirao").text(); // Find the text

    $("#idQuarteirao").attr("value", $idQuarteirao);
    $("#descricaoQuarteirao").attr("value", $descricaoQuarteirao);
    $("#quantidadeQuarteirao").attr("type", "hidden");

    //---label Qauntidade
    $("#labelQuantidade").attr("hidden", "true");

    //----Descricao 
    $("#labelSigla").attr("hidden", "true");


    $('#novoQuarteirao').modal('show');
}
;
$(function () {
    $('[data-toggle="tooltip"]').tooltip()
});
function getFormData() {
    if (!$("#form").validationEngine('validate')) {
        return;
    }
    var id = null;
    var idQuarteirao = $("input[name=idQuarteirao").val();
    var bairroId = $("input[name=bairroid").val();
    var descricao = $("input[name=descricao").val();
    var quantidade = $("input[name=quantidade").val();
    var url = "";
    var domain = "";
    if (document.domain == "localhost") {
        domain = "/Spiaa"
    }
    if (idQuarteirao != null && idQuarteirao != "") {
        url = domain + "/bairro/quarteirao/alterar";
    } else {
        url = domain + "/bairro/quarteirao/novo";
        id = null;
    }
    var jsonData = {
        bairro: {
            id: bairroId,
        },
        id: idQuarteirao != "" ? idQuarteirao : null,
        descricao: descricao,
        quantidade: quantidade != "" ? quantidade : null,
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
                $('#novoQuarteirao').modal('hide');
                setTimeout(function () {
                    document.location.assign(domain + '/bairro/' + bairroId + '/quarteirao');
                }, 3000);
            } else if (retorno == "Duplicated") {
                $('#novoQuarteirao').modal('hide');
                $('#duplicated').modal('show');
            }
        }

    }).fail(function () {

    });
}
;
function excluir(obj) {
    $("#confirmDelete").modal('show');
    var $row = $(obj).closest("tr");    // Find the row
    var $idQuarteirao = $row.find(".idquarteirao").text(); // Find the text
    $("#idQuarteirao").attr("value", $idQuarteirao);
}
;
function excluirQuarteirao() {
    var idQuarteirao = $("input[name=idQuarteirao").val();
    var bairroId = $("input[name=bairroid").val();

    var url = "";
    var domain = "";
    if (document.domain == "localhost") {
        domain = "/Spiaa"
    }

    url = domain + "/bairro/quarteirao/excluir";

    var jsonData = {
        id: idQuarteirao,
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
            $('#confirmDelete').modal('hide');
        }
        setTimeout(function () {
            document.location.assign(domain + '/bairro/' + bairroId + '/quarteirao');
        }, 3000);
    }).fail(function () {

    });
}
;

