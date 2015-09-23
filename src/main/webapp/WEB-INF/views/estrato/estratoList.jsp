
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
                            <h1 class="page-header">Estrato <small>Listagem</small>  </h1>
                            <a href="estrato/novo" class="btn btn-default"><i class="fa fa-fw fa-plus"></i> Novo </a><br/><br/>
                             <table id="table_id" class="table table-hover table-striped table-bordered" cellspacing="0" width="100%">
                                <thead>
                                    <tr>
                                        <th>Estrato</th>
                                        <th align="center" style="width:70px;" > </th>
                                        <th align="center" style="width:70px;" >Dados Bairros </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${estrato}" var="estrato">
                                        <tr>
                                            <td>${estrato.nome}</td>
                                            <td align="center"><a href="estrato/${estrato.id}/alterar" data-toggle="tooltip" data-placement="top" title="Alterar"><i class="fa fa-2x fa-edit text-primary"></i></a></td>
                                            <td align="center"><a href="estratobairro/${estrato.id}" class="btn_pag " data-toggle="tooltip" data-placement="top" title="Dados Bairros"><i class="fa fa-2x fa-database text-success"></i></a></td>
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
         <script>
                $('.btn_pag').on("click", function () {
                    $('#confirmDelete').modal('show');
                    $("#confirmDelete .btn-danger").attr("href", $(this).attr("href"));
                    return false;
                });
            </script>
    </body>
</html>
