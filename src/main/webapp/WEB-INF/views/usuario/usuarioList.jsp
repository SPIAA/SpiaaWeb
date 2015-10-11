<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../imports.jspf" %>
<!DOCTYPE html>
<html>
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
                            <h1 class="page-header">Usu&aacute;rio <small>Listagem</small>  </h1>
                            <a href="<c:url value="/usuario/novo"/>" class="btn btn-default"><i class="fa fa-fw fa-plus"></i> Novo </a>
                            <br/><br/> 
                            <table id="table_id" class="table table-striped table-bordered" cellspacing="0" width="100%">
                                <thead>
                                    <tr>
                                        <th>Usuário</th>
                                        <th>E-mail</th>
                                        <th align="center" style="width:80px;" > Bairros </th>
                                        <th align="center" style="width:80px;" > Alterar</th>
                                        <th align="center" style="width:80px;" > Excluir</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${usuario}" var="user">
                                        <tr>
                                            <td>${user.nome}</td>
                                            <td>${user.email}</td>
                                            <td align="center"><a href="usuario/${user.id}/bairrousuario" data-toggle="tooltip" data-placement="top" title="Bairros sobre Responsabilidade"><i class="fa fa-2x fa-cubes text-warning"></i> </a></td>
                                            <td align="center"><a href="usuario/${user.id}/alterar" data-toggle="tooltip" data-placement="top" title="Alterar"><i class="fa fa-2x fa-edit text-primary"></i></a></td>
                                            <td align="center"><a href="usuario/${user.id}/excluir" class="btn_pag" data-toggle="tooltip" data-placement="top" title="Excluir"><i class="fa fa-2x fa-trash-o text-danger"></i></a></td>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>
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
        <div class="modal fade" id="confirmDelete">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header btn-danger">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h3 class="modal-title">Atenção</h3>
                    </div>
                    <div class="modal-body">
                        <p>Deseja realmente excluir este usuário?</p>
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
            $('.btn_pag').on("click", function () {
                $('#confirmDelete').modal('show');
                $("#confirmDelete .btn-danger").attr("href", $(this).attr("href"));
                return false;
            });
        </script>
    </body>
</html>
