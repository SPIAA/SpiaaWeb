
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../imports.jspf" %>
<!DOCTYPE html>
<html>

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
                            <h1 class="page-header">Estrato <small>Listagem</small>  </h1>
                            <a href="estrato/novo" class="btn btn-primary">Novo Estrato</a><br/><br/>
                            <display:table class="table table-striped table-hover "  name="estrato" id="estrato" requestURI="" pagesize="7">
                                <display:column  property="nome" title="Estrato"/>
                                <display:column value="<a href=\"estrato/${estrato.id}/alterar\">Alterar</a>" title=""/>
                                <display:column value="<a href=\"estratobairro/${estrato.id}\">Dados bairros</a>" title=""/>
                            </display:table>


                            <br/><br/> <br/><br/>




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
