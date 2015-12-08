
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../imports.jspf" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <jsp:include page="../template-admin/header.jsp"/>
        <script src="<c:url value="/js/views/bairro.js"/>"></script>
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
                                    <input type="hidden"  name="id" value="${bairro.id}"/>
                                <div class="form-group col-md-12">
                                    <label for="nome">Nome: </label>
                                    <input type="text" class="form-control validate[required]"  name="nome" value="${bairro.nome}"/>
                                </div>
                                <div class="form-group col-md-12">
                                    <label for="coordenadas">Coordenadas: </label>
                                    <textarea class="form-control validate[required]" rows="5" name="coordenadas" id="coordenadas">${bairro.coordenadas}</textarea>
                                </div>

                                <div class="col-lg-12" align="center">
                                    <div class="form-group col-md-3 "></div>
                                    <div class="form-group col-md-6 ">
                                         <a href="#"  name="cancelar" class="btn btn-default" onclick="javascript:history.back();" value="cancelar"> &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp; Cancelar &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;</a>
                                        
                                        <input class="btn btn-success " onclick="getFormData()" value="Salvar" />  
                                    </div>
                                    <div class="form-group col-md-3 ">

                                    </div>
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
        <div class="modal fade" id="successCreate">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header btn-success">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h3 class="modal-title">SPIAA</h3>
                    </div>
                    <div class="modal-body text-center">
                        <div class="alert alert-success">
                            <strong > Salvando Bairro, aguarde por favor..</strong> <br/>
                            <i class="fa fa-2x fa-spinner fa-pulse"></i>
                            <p>Você será redirecionado.....</p>
                        </div>

                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
    </body>
</html>
