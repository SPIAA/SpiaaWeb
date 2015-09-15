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
                                <br/><br/>
                                <display:table class="table table-striped table-hover"  name="denunciaList" id="denunciaList" requestURI="" pagesize="7">
                                    <display:column property="bairro.nome" title="Bairro" sortable="true" />
                                    <display:column property="endereco" title="Endereco"/>
                                    <display:column property="numero" title="Numero"/>
                                    <display:column property="telefone" title="Telefone"/>
                                    <display:column property="status" title="Status" sortable="true"/>
                                    
                                    <display:column value="<a href=\"denuncia/${denunciaList.id}/visualiza\">Visualizar</a>" title=""/>
                                    
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



    </body>

</html>
