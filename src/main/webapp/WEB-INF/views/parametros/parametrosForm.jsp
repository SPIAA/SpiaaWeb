<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../imports.jspf" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <jsp:include page="../template-admin/header.jsp"/>
        <script src="<c:url value="/js/views/parametros.js"/>"></script>
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
                                Configura&ccedil;&otilde;es
                                <small>Par&acirc;metros</small>
                            </h1>
                            <div class="panel panel-default">
                                <div class="panel-heading">Envio de email</div>
                                <div class="panel-body">

                                    <form class="form-group" method="POST" name="form" id="form">
                                        <input type="hidden"   name="id" value="${parametros.id}"/>
                                        <div class="form-group col-md-12 ">
                                            <label for="hostname">Host Name </label>
                                            <input type="text" class="form-control validate[required]"  name="caminhoHostName" value="${parametros.caminhoHostName}"/>
                                        </div>
                                        <div class="form-group col-md-6 ">
                                            <label for="smtp">smtp </label>
                                            <input type="text" class="form-control validate[required]"  name="smtp" value="${parametros.smtp}"/>
                                        </div>
                                        <div class="form-group col-md-6">
                                            <label for="porta">Porta:</label>
                                            <input type="number" class="form-control validate[required]"  name="porta" value="${parametros.porta}"/>
                                        </div> 
                                        <div class="form-group col-md-6">
                                            <label for="email">Email :</label>
                                            <input type="email" class="form-control validate[required]"  name="email" value="${parametros.email}"/>
                                        </div> 
                                        <div class="form-group col-md-6">
                                            <label for="senha">Senha :</label>
                                            <input type="password" class="form-control validate[required]"  name="senha" value="${parametros.senha}"/>
                                        </div> 
                                        <div class="col-lg-12" align="center">
                                            <div class="form-group col-md-5 "></div>
                                            <div class="form-group col-md-2 ">
                                                <input class="btn btn-success " onclick="getFormData()" value="Salvar" />  
                                            </div>
                                            <div class="form-group col-md-5 "></div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.container-fluid -->
            </div>
        </div>
        <!-- /#wrapper -->     
        <div class="modal fade" id="successCreate">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header btn-success">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h3 class="modal-title">SPIAA</h3>
                    </div>
                    <div class="modal-body text-center">
                        <div class="alert alert-success">
                            <strong > Salvando Configura&Ccedil;&otilde;es, aguarde por favor..</strong> <br/>
                            <i class="fa fa-2x fa-spinner fa-pulse"></i>
                            <p>Você será redirecionado.....</p>
                        </div>

                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
    </body>
</html>
