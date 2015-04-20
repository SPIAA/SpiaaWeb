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


                            <div class="form-inline">
                                <div class="form-group col-md-3">
                                    <label>Data Boletim </label><br/>
                                    <fmt:formatDate pattern="dd/MM/yyyy" value="${boletimDiario.dataBoletim}" />

                                </div>
                                <div class="form-group col-md-3">
                                    <label class="">Agente : </label>
                                    <br/>${boletimDiario.usuario.nome}
                                </div>
                                <div class="form-group col-md-3">
                                    <label class="">Bairro : </label>
                                    <br/>${boletimDiario.bairro.nome}
                                </div>
                                <div class="form-group col-md-3">
                                    <label class="">Agente : </label>
                                    <br/>${boletimDiario.turma}
                                </div> 
                                <div class="form-group col-md-3">
                                    <label class="">Numero : </label>
                                    <br/>${boletimDiario.numero}
                                </div> 
                                <div class="form-group col-md-3">
                                    <label class="">Semana : </label>
                                    <br/>${boletimDiario.semana}
                                </div> 
                                <div class="form-group col-md-3">
                                    <label class="">Nº Atividade : </label>
                                    <br/>${boletimDiario.numeroAtividade}
                                </div> 
                                <div class="form-group col-md-3">
                                    <label class="">T. Atividade : </label>
                                    <br/>${boletimDiario.tipoAtividade}
                                </div> 
                            </div>


                            <br/>  <br/>  <br/><br/>  <br/>  <br/><br/>  
                            <a class="btn btn-primary" href="<c:url value="/atividade/${boletimDiario.id}/novo"/>">Nova Atividade</a>
                            <br/>
                            <div class="col-lg-12">
                                <br/><br/>

                                <display:table class="table table-striped table-hover"  name="atividadeList" id="atividadeList" requestURI="" pagesize="7">
                                    <display:column property="quarteirao" title="Quarteirão"/>
                                    <display:column property="rua" title="Endereço"/>
                                    <display:column property="numero" title="Numero"/>
                                    <display:column property="observacao" title="Observação"/>
                                    <display:column property="inspecionado" title="T. Inspec."/>
                                    <display:column value="<a href=\"../atividade/${atividadeList.id}/alterar\">alterar</a>" title=""/>
                                    <display:column value="<a href=\"../atividade/${atividadeList.id}/excluir\">Excluir</a>" class="deleteLink" title=""/>
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
