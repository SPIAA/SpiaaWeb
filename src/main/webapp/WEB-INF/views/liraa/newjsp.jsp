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
                                Paginá em branco
                                <small>subTitulo</small></h1>

                            <form class="form-inline" role="form" method="POST">

                                <div class="form-group">
                                    <label for="inputDataNascimento">Data de Nascimento</label>
                                    <input type="text" class="form-control" id="inputDataNascimento" name="dataInicio" value="<fmt:formatDate pattern="dd/MM/yyy" value="${liraa.dataInicio}"/>">
                                    <span><form:errors path="liraa.dataNascimento"/></span>
                                </div>
                                
                                <div class="form-group">
                                    <label for="inputDataNascimento">Data de Nascimento</label>
                                    <input type="text" class="form-control" id="inputDataNascimento" name="dataTermino" value="<fmt:formatDate pattern="dd/MM/yyy" value="${liraa.dataTermino}"/>">
                                    <span><form:errors path="liraa.dataTermino"/></span>
                                </div>
                                <button type="submit" class="btn btn-default">Submit</button>
                            </form>

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
