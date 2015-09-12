<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../imports.jspf" %>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <jsp:include page="../template-admin/header.jsp"/>
    </head>

    <body>

        <div id="wrapper"  class="col-lg-12">

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
                                Ponto Estratégico
                                <small>Listagem</small>
                            </h1>
                            <c:if test="${not empty mensagem}">  <div class="alert alert-info alert-dismissible" role="alert">
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <p class="text-center">${mensagem}</p> 
                                </div>
                            </c:if>

                            <a href="<c:url value="pontoestrategico/novo"/> "class="btn btn-default"><i class="fa fa-fw fa-plus"></i>Novo</a><br/><br/>

                            <display:table class="table table-striped table-hover"  name="pontoEstrategicoList" id="pontoEstrategicoList" requestURI="" pagesize="7">
                                <display:column property="rua" title="Rua"/>
                                <display:column property="numero" title="Numero"/>
                                <display:column property="complemento" title="Complemento"/>
                                <display:column property="bairro.nome" title="Bairro"/>
                                <display:column property="usuario.usuario" title="Agente Reposnsável"/>
                                <display:column title="Alterar"><a href="<c:url value="/pontoestrategico/${pontoEstrategicoList.id}/atualizar"/>"><i class="fa fa-2x fa-edit"></i></a></display:column>
                                <display:column title="Deletar" class="deleteLink"><a href="<c:url value="/pontoestrategico/${pontoEstrategicoList.id}/deletar"/>"><i class="fa fa-2x fa-trash-o text-danger"></i></a></display:column>
                                </display:table>
                        </div>
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- /#page-wrapper -->
        </div>
        <!-- /#wrapper -->
        <!-- /#wrapper -->
        <!-- /#wrapper -->
        <div class="modal fade" id="confirmDelete">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header btn-danger">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h3 class="modal-title">Atenção</h3>
                    </div>
                    <div class="modal-body">
                        <p>Deseja realmente excluir este Ponto Estratégico?</p>
                        <div class="alert alert-danger">
                            <strong> Atenção: esta operação não pode ser desfeita.</strong> 
                        </div>

                    </div>
                    <div class="modal-footer">
                        <a href="#" class="btn btn-danger">Sim, desejo excluir.</a>
                        <a href="#" class="btn btn-default" data-dismiss="modal">Cancelar</a>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
        <script>
            $(function () {
                $("td.deleteLink a").click(function () {
                    $('#confirmDelete').modal('show');
                    $("#confirmDelete .btn-danger").attr("href", $(this).attr("href"));
                    return false;
                });
            });
        </script>
    </body>

</html>