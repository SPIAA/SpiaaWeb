
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<%@include file="../imports.jspf" %>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <jsp:include page="../template-admin/header.jsp"/>
        <link href="<c:url value="/css/jquery-ui.min.css"/>" rel="stylesheet">
        <script src="<c:url value="/js/jquery-ui.min.js"/>"></script>
    </head>

    <body>

        <div id="wrapper">

            <!-- Navigation -->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

                <jsp:include page="../template-admin/menutop.jsp"/>

            </nav>

            <div id="page-wrapper">
                <div class="container-fluid">
                    <!-- Page Heading -->
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">
                                Criadouro
                                <small>Novo</small>
                            </h1>
                            <c:if test="${not empty mensagem}">  <div class="alert alert-danger alert-dismissible" role="alert">
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <p class="text-center">${mensagem}</p> 
                                </div>
                            </c:if>
                            <form class="form-group" method="POST" id="form">
                                <input type="text" hidden="" id="id" name="id" value="${criadouro.id}"/>
                                <div class="form-group col-md-4 ">
                                    <label for="nome">Nome: </label>
                                    <input type="text" class="form-control form-control validate[required]" id="grupo" name="grupo" value="${criadouro.grupo}"/>
                                </div>
                                <div class="form-group col-md-4 ">
                                    <label for="unidade">Unidade de medida : </label>
                                    <input type="text" class="form-control form-control validate[required]" id="recipiente"  name="recipiente" value="${criadouro.recipiente}"/>
                                </div>
                                <div class="col-lg-4" align="center">
                                    <br/>
                                    <input class="btn btn-success " onclick="myFunction()" value="Gravar" />  
                                </div>
                            </form>
                            <!--<button onclick="myFunction()">report via ajax</button>-->
                            <br/>
                        </div>
                    </div>
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- /#page-wrapper -->
        </div>


        <div class="modal fade" id="successCreate">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header btn-success">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h3 class="modal-title">SPIAA</h3>
                    </div>
                    <div class="modal-body text-center">
                        <div class="alert alert-success">
                            <strong> Criadouro salvo com sucesso</strong> <br/>
                            <i class="fa fa-2x fa-spinner fa-pulse"></i>
                            <p>Você esta sendo redimensionado....</p>
                        </div>

                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->

        <!-- /#wrapper -->     
        <script>
            jQuery(document).ready(function () {
                // binds form submission and fields to the validation engine
                jQuery("#form").validationEngine('attach', {promptPosition: "bottomLeft", autoPositionUpdate: true});
            });
            function myFunction() {
                var id = document.getElementById("id").value;

                var url = "/Spiaa/criadouro/novo";
                if (id != null && id != "") {
                    url = "/Spiaa/criadouro/atualizar";
                } else {
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
                        document.location.assign('/Spiaa/criadouro');
                    }, 3000);
                }).fail(function () {

                });
            }


        </script>
    </body>
</html>
