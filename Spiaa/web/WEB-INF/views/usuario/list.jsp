
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
                            <h1 class="page-header">Usu&aacute;rio <small>Listagem</small>  </h1>
                            <a href="<c:url value="/usuario/novo"/>" class="btn btn-primary">Novo Usu&aacute;rio</a><br/><br/>
                            <display:table class="table table-striped table-hover "  name="usuario" id="usuario" requestURI="" pagesize="7">
                                <display:column  property="nome" title="Usuario"/>
                                <display:column value="<a href=\"usuario/${usuario.id}/atualizar\">Alterar</a>" title=""/>
                                <display:column value="<a href=\"usuario/${usuario.id}/excluir\">Excluir</a>" title=""/>
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
