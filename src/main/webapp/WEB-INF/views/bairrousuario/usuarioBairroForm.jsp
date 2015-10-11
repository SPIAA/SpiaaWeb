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
                <script src="<c:url value="/js/views/usuarioBairro.js"/>"></script>

            </nav>

            <div id="page-wrapper">
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="row">

                        <div class="col-lg-12">
                            <h1 class="page-header">
                                Usuário ${usuario.nome}
                                <small>Bairros sobre sua responsabilidade</small>
                            </h1>
                            <input type="hidden" id="bairroid"  name="usuarioId" value="${usuario.id}"/>
                            <c:if test="${usuario.tipo eq 'AGS'}">
                                <div class="form-group col-lg-12">
                                    <h3>Selecione os Bairros que são de responsabilidade deste agente :</h3>
                                </div>
                                <br/>
                                <div class="checkbox col-lg-12">
                                    <c:forEach items="${bairroList}" var="bairro">
                                        <div class="form-group col-md-3">
                                            <label>
                                                <input type="checkbox" value="${bairro.id}" name="bairro"
                                                       <c:forEach items="${usuarioBairroList}" var="usuarioBairro">
                                                           <c:if test="${bairro.id eq usuarioBairro.bairro.id}"> checked</c:if>
                                                       </c:forEach>
                                                       >
                                                ${bairro.nome}
                                            </label>
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>

                            <div class="form-group col-md-12 ">
                                <div class="form-group col-md-5 "></div>
                                <div class="form-group col-md-2 ">
                                    <label class="" for="dataInicio">&nbsp;</label><br/>
                                    <input class="btn btn-success " onclick="getFormData()" value="Salvar" />  
                                </div>
                                <div class="form-group col-md-5 "></div>
                            </div>
                        </c:if>
                            <c:if test="${usuario.tipo eq 'ADM'}">
                                <div class="col-lg-12">
                                    <div class="alert alert-danger" role="alert">
                                        Este Usuário <b>não</b> é do <b>Tipo Agente de Saúde</b>, portanto não é possivel anexar <b>Bairros</b> sobre sua responsabilidade.
                                    </div>
                                </div>
                            </c:if>
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
                            <strong > Salvando Bairros , aguarde por favor..</strong> <br/>
                            <i class="fa fa-2x fa-spinner fa-pulse"></i>
                            <p>Você será redirecionado.....</p>
                        </div>

                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
    </body>
</html>
