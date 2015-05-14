
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../imports.jspf" %>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <jsp:include page="../template-admin/header.jsp"/>
        <link href="<c:url value="/css/jquery-ui.min.css"/>" rel="stylesheet">
        <script src="<c:url value="/js/jquery-ui.min.js"/>"></script>
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
                                Usuário
                                <small>Novo</small>
                            </h1>
                            <form class="form-group" method="POST">
                                <div class="form-group col-md-4 ">
                                    <label for="nome">Nome: </label>
                                    <input type="text" class="form-control"  name="nome"/>
                                </div>

                                <div class="form-group col-md-4">
                                    <label for="usuario">Nome de Usuário:</label>
                                    <input type="text" class="form-control"  name="usuario"/>
                                </div> 

                                <div class="form-group col-md-3">
                                    <label for="tipo">Tipo de Usuário: </label>
                                    <select class="form-control" name="tipo" id="tipo">
                                        <option value="0">Selecione...</option>
                                        <option value="AGS">Agente de Saúde</option>
                                        <option value="ADM">Administrador</option>
                                    </select>
                                </div>

                                <div class="form-group col-md-4">
                                    <label for="email">Email:</label>
                                    <input type="email" class="form-control"  name="email"/>
                                </div>                                                               



                                <div class="form-group col-md-3">
                                    <label for="senha">Senha:</label>
                                    <input type="text" class="form-control" name="senha" placeholder="Min. 8 caracteres"/>
                                </div>
                                <div class="form-group col-md-3">
                                    <label for="confirm">Confirme a Senha:</label>
                                    <input type="text" class="form-control" name="confirm"/>
                                </div>


                                <br/><br/><br/><br/><br/><br/><br/><br/>
                                <div class="col-lg-12" align="center">
                                    <button class="btn btn-success " > Cadastrar Usuário</button>  
                                </div>

                            </form>
                            <br/>
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
