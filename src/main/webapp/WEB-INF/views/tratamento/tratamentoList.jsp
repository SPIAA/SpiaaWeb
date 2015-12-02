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
                                Tratamento Anti-Vetorial
                                <small>Listagem</small>
                            </h1>
                            <br/>
                            <a class="btn btn-default" href="<c:url value="/tratamento/novo"/>"><i class="fa fa-fw fa-plus"></i> Novo </a>
                            <br/><br/>
                            <table id="table_id" class="table table-striped table-bordered" cellspacing="0" width="100%">
                                <thead>
                                    <tr>
                                        <th>Número</th>
                                        <th>Semana</th>
                                        <th>Bairro</th>
                                        <th>Usuário</th>
                                        <th align="center" style="width:70px;" class="no-sort">Atividade</th>
                                        <th align="center" style="width:70px;" class="no-sort"> </th>
                                        <th align="center" style="width:70px;" class="no-sort"> </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${boletim}" var="bol">
                                        <tr>
                                            <td>${bol.id}</td>
                                            <td>${bol.semana}</td>
                                            <td>${bol.bairro.nome}</td>
                                            <td>${bol.usuario.nome}</td>
                                            <td align="center"><a href="atividade/${bol.id}" data-toggle="tooltip" data-placement="top" title="Atividade"><i class="fa fa-2x fa-home text-success"></i></a></td>
                                            <td align="center"><a href="tratamento/${bol.id}/alterar" data-toggle="tooltip" data-placement="top" title="Alterar"><i class="fa fa-2x fa-edit text-primary"></i></a></td>
                                            <td align="center"><a href="tratamento/${bol.id}/excluir" class="btn_pag" data-toggle="tooltip" data-placement="top" title="Excluir"><i class="fa fa-2x fa-trash-o text-danger"></i></a></td>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <!-- /.row -->
            </div>
            <!-- /.container-fluid -->

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
            $('.btn_pag').on("click", function () {
                $('#confirmDelete').modal('show');
                $("#confirmDelete .btn-danger").attr("href", $(this).attr("href"));
                return false;
            });
        </script>
    </body>
</html>