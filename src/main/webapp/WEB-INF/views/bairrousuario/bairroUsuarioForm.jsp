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
                <script src="<c:url value="/js/views/bairroUsuario.js"/>"></script>

            </nav>

            <div id="page-wrapper">
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="row">

                        <div class="col-lg-12">
                            <h1 class="page-header">
                                Bairro ${bairro.nome}
                                <small>Agentes responsáveis</small>
                            </h1>
                            <input type="hidden" id="bairroid"  name="bairroid" value="${bairro.id}"/>
                            <div class="form-group col-lg-12">
                                <h3>Selecione os Usuários responsáveis para este bairro :</h3>
                            </div>
                            <br/>
                            <div class="checkbox col-lg-12">
                                <c:forEach items="${agenteList}" var="agente">
                                    <div class="form-group col-md-3">
                                        <label>
                                            <input type="checkbox" value="${agente.id}" name="agente"
                                                   <c:forEach items="${usuarioBairroList}" var="usuarioBairro">
                                                       <c:if test="${agente.id eq usuarioBairro.usuario.id}"> checked</c:if>
                                                   </c:forEach>
                                                   >
                                            ${agente.nome}
                                        </label>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>

                        <div class="form-group col-md-12 ">
                            <div class="form-group col-md-4 "></div>
                            <div class="form-group col-md-4 ">
                                <label class="" for="dataInicio">&nbsp;</label><br/>
                                <input class="btn btn-success " onclick="getFormData()" value="Salvar" />  
                                <a href="#"  name="cancelar" class="btn btn-default" onclick="javascript:history.back();" value="cancelar">&nbsp;&nbsp;&nbsp;&nbsp;Cancelar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
                            </div>
                            <div class="form-group col-md-4 "></div>
                        </div>
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- /#page-wrapper -->
        </div>
        <!-- /#wrapper -->
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
                            <strong > Salvando usuários responsáveis, aguarde por favor..</strong> <br/>
                            <i class="fa fa-2x fa-spinner fa-pulse"></i>
                            <p>Você será redirecionado.....</p>
                        </div>

                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
    </body>
</html>
