<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../imports.jspf" %>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <jsp:include page="../template-admin/header.jsp"/>
        <script src="<c:url value="/js/views/denuncia.js"/>"></script>
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
                            <form role="form" id="formDenuncia" method="POST">   
                                <h1 class="page-header">
                                    Denúncia
                                    <small>Visualizar</small> 
                                </h1>
                                <c:if test="${not empty mensagem}">  <div class="alert alert-info alert-dismissible" role="alert">
                                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                        <p class="text-center">${mensagem}</p> 
                                    </div>
                                </c:if>
                                <div class="col-lg-6 column">

                                    <div class="panel panel-danger">
                                        <div class="panel-heading">Dados da Denúncia</div>
                                        <div class="panel-body">
                                            <div class="form-group col-md-6">
                                                <label for="Inputendereco">Data da  Abertura : </label><input type="text"  class="form-control" readonly name="dataAbertura" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${denuncia.dataAbertura}" />"/>
                                            </div>
                                            <div class="form-group col-md-6">
                                                <label for="Inputendereco">Data da  Finalização : </label><input type="text"  class="form-control" readonly name="dataAbertura" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${denuncia.dataFinalizacao}" />"/>
                                            </div>
                                            <div class="form-group col-md-12">
                                                <label for="Inputendereco">Bairro :</label><input type="text"  class="form-control" readonly name="bairro.nome" value="${denuncia.bairro.nome}"/>
                                            </div>


                                            <div class="form-group col-md-12">
                                                <label for="Inputendereco">Endereço:</label><input type="text"  class="form-control" readonly name="endereco" value="${denuncia.endereco}"/>
                                            </div>

                                            <div class="form-group col-md-12">
                                                <label for="Inputnumero">Número:</label><input type="text"  class="form-control" readonly name="numero" value="${denuncia.numero}" />
                                            </div>
                                            <div class="form-group col-md-12" hidden="">
                                                <label for="Inputtelefone">Telefone:</label><input type="text"  class="form-control" readonly id="telefone" name="telefone" value="${denuncia.telefone}"/>

                                            </div>
                                            <div class="form-group col-md-12">
                                                <label for="Inputtipoirregularidade">Irregularidades:</label><textarea  class="form-control" readonly name="irregularidade" >${denuncia.irregularidade}</textarea>
                                            </div>
                                            <div class="form-group col-md-12">
                                                <label for="Inputobservacao">Observação:</label><textarea  class="form-control" readonly name="observacao" > ${denuncia.observacao}</textarea>
                                            </div>

                                        </div>
                                    </div>

                                </div>

                                <input type="text" class="" hidden="" name="id" value="${denuncia.id}"/>
                                <div class="col-md-6 column">
                                    <div class="form-group">
                                        <label for="InputStatus"> Responsável : </label>
                                        <select  class="form-control validate[required]" name="usuario_id" id="usuario_id" <c:if test="${denuncia.status eq 'Finalizada'}"> disabled</c:if>>
                                                <option value=""> selecione... </option>
                                            <c:forEach var="usuario" items="${usuario}">
                                                <option value="${usuario.id}" <c:if test="${denuncia.usuario.id eq usuario.id}">selected</c:if>> ${usuario.nome}  </option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="InputStatus">  Status : </label>
                                        <select class="form-control col-lg-11"  name="status" id="status" <c:if test="${denuncia.status eq 'Finalizada'}"> disabled</c:if>>
                                            <option value="Aberta" <c:if test="${denuncia.status eq 'Aberta'}"> selected</c:if> >Aberta</option>
                                            <option value="Encaminhada" <c:if test="${denuncia.status eq 'Encaminhada'}"> selected</c:if>>Encaminhada</option>
                                            <c:if test="${denuncia.status eq 'Finalizada'}">
                                                <option value="Finalizada" <c:if test="${denuncia.status eq 'Finalizada'}"> selected</c:if>>Finalizada</option>
                                            </c:if>
                                        </select>
                                    </div>

                                    <div class="col-sm-4"> <p> &nbsp;</p></div>
                                    <div class="col-sm-4"> 
                                        <input class="btn btn-lg btn-block btn-default" style="margin-top: 30px;" onclick="getFormData()"  value="Salvar" <c:if test="${denuncia.status eq 'Finalizada'}"> disabled</c:if> /> 
                                    <a href="#"  name="cancelar" class="btn btn-default" onclick="javascript:history.back();" value="cancelar">&nbsp;&nbsp;&nbsp;&nbsp;Cancelar&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
                                    </div>
                                    <div class="col-sm-4"> <p> &nbsp;</p>
                                    </div>
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

        <div class="modal fade" id="successCreate">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header btn-success">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h3 class="modal-title">SPIAA</h3>
                    </div>
                    <div class="modal-body text-center">
                        <div class="alert alert-success">
                            <strong> Denúncia salva com sucesso</strong> <br/>
                            <i class="fa fa-2x fa-spinner fa-pulse"></i>
                            <p>Você está sendo redirecionado.....</p>
                        </div>

                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
        <!-- /#wrapper -->
        <div class="modal fade" id="obrigatorio">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header btn-warning">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h3 class="modal-title">SPIAA</h3>
                    </div>
                    <div class="modal-body text-center">
                        <div class="alert alert-warning">
                            <strong > Usuario não Selecionado</strong> <br/>
                            <i class="fa fa-2x fa-warning"></i>
                            <p>É necessário Escolher ao menos um usuário!</p>
                        </div>

                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
    </body>

</html>
