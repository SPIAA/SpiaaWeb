
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
                                Bairro
                                <c:if test="${not empty bairro}"><small>Alterar</small></c:if>
                                <c:if test="${empty bairro}"><small>Novo</small></c:if>
                            </h1>
                            <form class="form-group" method="POST">
                                <div class="form-group col-md-4 ">
                                    <label for="nome">Nome: </label>
                                    <input type="text" class="form-control"  name="nome" value="${user.nome}"/>
                                </div>

                                <br/><br/><br/><br/><br/><br/><br/><br/>
                                <div class="col-lg-12" align="center">
                                    <button class="btn btn-success " >Salvar</button>  
                                </div>
                            </form>
                            <br/>
                        </div>
                    </div>
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- /#page-wrapper -->
        </div>
        <!-- /#wrapper -->     
    </body>
</html>
