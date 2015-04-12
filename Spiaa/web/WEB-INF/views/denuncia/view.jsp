<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../imports.jspf" %>
<!DOCTYPE html>
<html lang="pt-br">

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
                            <h1 class="page-header">
                                Denúncia
                                <small>Visualizar</small>
                            </h1>
                            <div class="col-lg-12">
                                <br/>
                                <div class="form-group">
                                    <label for="Inputendereco">Bairro :</label><p>${denuncia.bairro.nome}</p>
                                </div>
                                <div class="form-group">
                                    <label for="Inputendereco">Endereço:</label><p>${denuncia.endereco}</p>
                                </div>

                                <div class="form-group">
                                    <label for="Inputnumero">Numero:</label><p>${denuncia.numero}</p>
                                </div>
                                <div class="form-group">
                                    <label for="Inputtelefone">Telefone:</label><p>${denuncia.telefone}</p>

                                </div>
                                <div class="form-group">
                                    <label for="Inputtipoirregularidade">Tipo de irregularidades:</label><p>${denuncia.irregularidade}</p>-
                                </div>
                                <div class="form-group">
                                    <label for="Inputobservacao">Observação:</label><p>${denuncia.observacao}</p>
                                </div>


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
