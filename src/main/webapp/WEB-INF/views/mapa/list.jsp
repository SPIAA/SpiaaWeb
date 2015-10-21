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
                                Mapa
                                <small>Administrativo</small>
                            </h1>

                            <form role="form" target="_blank" action="<c:url value="/mapa/visualizarMapaAdministrador"/>" method="POST">

                                <div class="form-group">
                                    <label for="bairro">Bairro:</label>
                                    <select  class="form-control validate[required]" name="bairro_id" id="bairro.id">
                                        <option value="" > Todos os Bairros  </option>
                                        <c:forEach var="bairroList" items="${bairroList}">
                                            <option value="${bairroList.id}" > ${bairroList.nome}  </option>
                                        </c:forEach>
                                    </select>

                                </div>
                                <div class="col-lg-12 text-center">
                                    <a class="btn btn-primary" target="_blank" href=<c:url value="/mapa/visualizarMapaAdministrador"/> ><i class="fa fa-map-marker fa-fw"></i> Visualizar Mapa</a>
                                    <input class="btn btn-lg btn-success" type="submit" value=" Visualizar Mapa" /> 
                                </div>
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
