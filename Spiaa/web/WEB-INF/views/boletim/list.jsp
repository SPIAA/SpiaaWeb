<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../imports.jspf" %>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <jsp:include page="../template-admin/header.jsp"/>
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
                                Boletim Diário
                                <small>Listagem</small>
                            </h1>
                            <br/>
                                                      <br/>
                            <a class="btn btn-primary" href="<c:url value="/boletim/novo"/>">Novo Boletim</a>
                            <br/>
                            <div class="col-lg-12">
                                <br/><br/>
                                <display:table class="table table-striped table-hover"  name="boletim" id="boletim" requestURI="" pagesize="7">
                                    <display:column property="dataBoletim" format="{0,date,dd/MM/yyyy}" title="Data Boletim"/>
                                    <display:column property="numero" title="Numero"/>
                                    <display:column property="semana" title="Semana"/>
                                    <display:column property="bairro.nome" title="Bairro"/>
                                    <display:column property="usuario.nome" title="Agente"/>
                                    <display:column value="<a href=\"boletim/${boletim.id}/alterar\">alterar</a>" title=""/>
                                    <display:column value="<a href=\"atividade/${boletim.id}\">atividades</a>" title=""/>
                                    <display:column value="<a href=\"boletim/${boletim.id}/excluir\">Excluir</a>" class="deleteLink" title=""/>
                                </display:table>
                            </div>

                        </div>
                    </div>
                    <!-- /.row -->

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- /#page-wrapper -->

        </div>
        <!-- /#wrapper -->
        <div class="modal fade" id="confirmDelete">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header btn-danger">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h3 class="modal-title">Atenção</h3>
                    </div>
                    <div class="modal-body">
                        <p>Você deseja realmente excluir?</p>
                        <div class="alert alert-danger">
                            Atenção: esta operação não pode ser desfeita.
                        </div>
                        <div class="alert alert-info">
                            Atenção:Caso tenha alguma <strong>Atividade</strong> neste <strong>Boletim diário</strong> ele  <strong class="text-danger">não sera excluído!</strong>
                        <br/>Para isso deve excluir todas as <strong>Atividade</strong> primeiro!
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
            $(function() {
                $("td.deleteLink a").click(function() {
                    $('#confirmDelete').modal('show');
                    $("#confirmDelete .btn-danger").attr("href", $(this).attr("href"));
                    return false;
                });
            });
        </script>


    </body>

</html>
