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
                                Bairro
                                <small>Listagem</small>
                            </h1>
                            <!--<a href="bairro/relatorio" class="btn btn-primary">Exportar Relatório</a>-->
                            <a href="bairro/novo" class="btn btn-default"><i class="fa fa-fw fa-plus"></i> Novo </a><br/><br/>
                            <table id="table_id" class="table table-striped table-bordered" cellspacing="0" width="100%">
                                <thead>
                                    <tr>
                                        <th style="width:70px;">Código</th>
                                        <th>Nome</th>
                                        <th align="center" style="width:70px;" > Quarteirão</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${bairrolist}" var="bairro">
                                        <tr>
                                            <td>${bairro.codigo}</td>
                                            <td>${bairro.nome}</td>
                                            <td align="center"><a href="quarteirao/${bairro.id}"><i class="fa fa-2x fa-edit text-primary"></i> </a></td>
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
    </body>
</html>
