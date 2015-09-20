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
                                Liraa
                            </h1>
                            <br/>
                            <a href="liraa/novo" class="btn btn-primary">Novo Liraa</a>
                            <br/><br/>

                             <display:table class="table table-striped table-hover"  name="liraa" id="liraa" requestURI="" pagesize="7">
                                    <display:column property="dataInicio" format="{0,date,dd/MM/yyyy}" title="Data Inicio"/>
                                    <display:column property="dataTermino" format="{0,date,dd/MM/yyyy}" title="Data Término"/>

                                    <display:column value="<a href=\"liraa/${liraa.id}/alterar\">alterar</a>" title=""/>
                                    <display:column value="<a href=\"consolidacao/${liraa.id}\">Consolidação de dados</a>" title=""/>
                                </display:table>
                            
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
