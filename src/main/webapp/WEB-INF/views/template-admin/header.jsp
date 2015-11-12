<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../imports.jspf" %>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>SPIAA - Sistema de Prevenção de infestação do Aedes Aegypti </title>

<!-- Bootstrap Core CSS -->
<link href="<c:url value="/css/bootstrap.min-3.css"/>" rel="stylesheet">
<!-- Custom CSS -->  
<link href="<c:url value="/css/sb-admin.css"/>" rel="stylesheet">
<!-- Custom Fonts -->
<link href="<c:url value="/css/font-awesome.min.css"/>" rel="stylesheet">
<!-- data tables -->
<link href="<c:url value="/css/jquery.dataTables.css"/>" rel="stylesheet">
<link href="<c:url value="/css/dataTables.bootstrap.min.css"/>" rel="stylesheet">


<!--validate -->
<link rel="stylesheet" href="<c:url value="/css/validationEngine.jquery.css"/>" type="text/css"/>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->

<link rel="shortcut icon" href="<c:url value="/img/icone_spiaa.png"/>">
<!-- jQuery Version 1.11.0 -->
<script src="<c:url value="/js/jquery.min.js"/>"></script>

<!-- Bootstrap Core JavaScript -->
<script src="<c:url value="/js/jquery.dataTables.js"/>"></script>
<script src="<c:url value="/js/dataTables.bootstrap.min.js"/>"></script>
<!-- Bootstrap Core JavaScript -->
<script src="<c:url value="/js/bootstrap.min.js"/>"></script>

<script src="<c:url value="/js/jquery.validationEngine-pt_BR.js"/>" type="text/javascript" charset="utf-8"></script>
<script src="<c:url value="/js/jquery.validationEngine.js"/>" type="text/javascript" charset="utf-8"></script>
<script>
    $(document).ready(function () {
        $('#table_id').DataTable({
            "language": {
                "sEmptyTable": "Nenhum registro encontrado",
                "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
                "sInfoEmpty": "Mostrando 0 até 0 de 0 registros",
                "sInfoFiltered": "(Filtrados de _MAX_ registros)",
                "sInfoPostFix": "",
                "sInfoThousands": ".",
                "sLengthMenu": "_MENU_ resultados por página",
                "sLoadingRecords": "Carregando...",
                "sProcessing": "Processando...",
                "sZeroRecords": "Nenhum registro encontrado",
                "sSearch": "Pesquisar",
                "oPaginate": {
                    "sNext": "Próximo",
                    "sPrevious": "Anterior",
                    "sFirst": "Primeiro",
                    "sLast": "Último"
                },
                "oAria": {
                    "sSortAscending": ": Ordenar colunas de forma ascendente",
                    "sSortDescending": ": Ordenar colunas de forma descendente"
                }
            },
            buttons: [
                'copy', 'excel', 'pdf'
            ],
            "order": [0, 'desc']
            
        });

    });
    $('.btn_pag').on("click", function () {
        $('#confirmDelete').modal('show');
        $("#confirmDelete .btn-danger").attr("href", $(this).attr("href"));
        return false;
    });

    $(function () {
        $('[data-toggle="tooltip"]').tooltip()
    });

</script>