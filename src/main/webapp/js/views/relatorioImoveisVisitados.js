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

    url = domain + "/relatorio/imoveisagentespdf";

    var dataInicialString = $("input[name=dataInicial").val().split("/");
    var dataFinalString = $("input[name=dataFinal").val().split("/");
    var dataInicial = new Date(dataInicialString[2], dataInicialString[1] - 1, dataInicialString[0]);
    var dataFinal = new Date(dataFinalString[2], dataFinalString[1] - 1, dataFinalString[0]);
    var jsonData = {
        dataInicial: dataInicial,
        dataFinal: dataFinal,
    };
    $.ajax({
        url: url,
        data: JSON.stringify(jsonData),
        jsonData: jsonData,
        method: 'POST',
        dataType: 'text',
        target: '_blank',
        contentType: 'application/x-www-form-urlencoded; charset=iso-8859-1',
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Accept", "application/text");
            xhr.setRequestHeader("Content-Type", "text/plain");
            xhr.overrideMimeType('text/html;charset=iso-8859-1');
        }
    }).done(function (retorno) {
        if (retorno != null) {
            window.open(retorno, '_blank');
        }

    }).fail(function () {

    });
}

