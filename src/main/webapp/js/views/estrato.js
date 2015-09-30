$(function () {
    $('.demo2').colorpicker();
});
function getFormData() {
    var bairro = new Array();
    $("input[type=checkbox][name='bairro']:checked").each(function () {
        bairro.push($(this).val());
    });
    var codigo = new Array();
    $("input[name=codigo").each(function () {
        codigo.push($(this).val());
    });
    var armazem = new Array();
    $("input[name=armazem").each(function () {
        armazem.push($(this).val());
    });
    var residencia = new Array();
    $("input[name=residencia").each(function () {
        residencia.push($(this).val());
    });
    var imovel = new Array();
    $("input[name=imovel").each(function () {
        imovel.push($(this).val());
    });
    var comercio = new Array();
    $("input[name=comercio").each(function () {
        comercio.push($(this).val());
    });
    var predio = new Array();
    $("input[name=predio").each(function () {
        predio.push($(this).val());
    });
    var habitante = new Array();
    $("input[name=habitante").each(function () {
        habitante.push($(this).val());
    });
    var terrenoBaldio = new Array();
    $("input[name=terrenoBaldio").each(function () {
        terrenoBaldio.push($(this).val());
    });
    var outros = new Array();
    $("input[name=outros").each(function () {
        outros.push($(this).val());
    });

    var bairroEstratoList = new Array();
    for (var i = 0; i <= bairro.length; i++) {
        var bairroEstrato = {
            bairro: {
                id: bairro[i],
            },
            codigo: codigo[i],
            armazem: armazem[i],
            residencia: residencia[i],
            imovel: imovel[i],
            comercio: comercio[i],
            predio: predio[i],
            terrenoBaldio: terrenoBaldio[i],
            habitante: habitante[i],
            outros: outros[i],
        };
        bairroEstratoList.push(bairroEstrato);
    }
    bairroEstratoList.pop();

    var id = $("input[name=id").val();
    var nome = $("input[name=nome").val();
    var cor = $("input[name=cor").val();
    
    var url = "";
    if (document.domain == "localhost") {
        url = "/Spiaa"
    }
    
    if (id != null && id != "") {
        url += "/estrato/alterar";
    } else {
    url += "/estrato/novo";
        id = null;
    }
    var jsonData = {
        id: id,
        nome: nome,
        cor: cor,
        bairroEstratoList: bairroEstratoList
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
            document.location.assign('/Spiaa/estrato');
        }, 3000);
    }).fail(function () {

    });
}

