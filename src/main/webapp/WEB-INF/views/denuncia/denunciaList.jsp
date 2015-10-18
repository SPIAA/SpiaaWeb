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
                                Denúncia
                                <small>Listagem</small>
                            </h1>
                            <div class="col-lg-12">
                                <table id="table_id" class="table table-striped table-bordered" cellspacing="0" width="100%">
                                    <thead>
                                        <tr>
                                            <th>Data de abertura</th>
                                            <th>Bairro</th>
                                            <th>Endereco</th>
                                            <th>Número</th>
                                            <th>Usuário</th>
                                            <th>Status</th>
                                            <th align="center" style="width:70px;" > </th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${denunciaList}" var="denuncia">
                                            <tr>
                                                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${denuncia.dataAbertura}" /></td>
                                                <td>${denuncia.bairro.nome}</td>
                                                <td>${denuncia.endereco}</td>
                                                <td>${denuncia.numero}</td>
                                                <td>${denuncia.usuario.nome}</td>
                                                <td 
                                                    <c:if test="${denuncia.status eq 'Aberta'}"> class="text-danger "</c:if>
                                                    <c:if test="${denuncia.status eq 'Encaminhada'}"> class="text-warning "</c:if>
                                                    <c:if test="${denuncia.status eq 'Finalizada'}"> class="text-success "</c:if>>
                                                    <b>${denuncia.status}</b>                                            </td>
                                                <td align="center"><a href="denuncia/${denuncia.id}/visualiza" data-toggle="tooltip" data-placement="top" title="Visualizar"><i class="fa fa-2x fa-search-plus text-danger"></i></a></td>
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
            </div>
            <!-- /#page-wrapper -->
        </div>
        <!-- /#wrapper -->
        <script>
            $('.btn_pag').on("click", function () {
                $('#confirmDelete').modal('show');
                $("#confirmDelete .btn-danger").attr("href", $(this).attr("href"));
                return false;
            });
        </script>
    </body>
</html>
