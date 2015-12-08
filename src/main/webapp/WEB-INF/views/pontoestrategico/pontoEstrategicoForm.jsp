
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../imports.jspf" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <jsp:include page="../template-admin/header.jsp"/>
        <link href="<c:url value="/css/jquery-ui.min.css"/>" rel="stylesheet">
        <script src="<c:url value="/js/jquery-ui.min.js"/>"></script>
        <script src="<c:url value="/js/views/pontoestrategico.js"/>"></script>
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
                                Ponto Estratégico
                                <c:if test="${not empty pontoEstrategico}"><small>Alterar</small></c:if>
                                <c:if test="${empty pontoEstrategico}"><small>Novo</small></c:if>
                                </h1>
                            <c:if test="${not empty mensagem}">  <div class="alert alert-danger alert-dismissible" role="alert">
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <p class="text-center">${mensagem}</p> 
                                </div>
                            </c:if>
                            <form method="POST" id="form">
                                <input type="text" hidden="" id="id" name="id" value="${pontoEstrategico.id}"/>
                                <div class="form-group col-md-12">
                                    <label for="exampleInputPassword1">Bairro:</label>
                                    <select  class="form-control validate[required]" name="bairro.id" id="bairro.id">
                                        <c:forEach var="bairroList" items="${bairroList}">
                                            <option value="${bairroList.id}" <c:if test="${pontoEstrategico.bairro.id eq bairroList.id}">selected</c:if> > ${bairroList.nome}  </option>
                                        </c:forEach>
                                    </select>

                                </div>
                                <div class="form-group col-md-12 ">
                                    <label for="rua">Rua :</label>
                                    <input type="text" class="form-control form-control validate[required]" id="rua" name="rua" value="${pontoEstrategico.rua}"/>
                                </div>
                                <div class="form-group col-md-12 ">
                                    <label for="numero">Número: </label>
                                    <input type="text" class="form-control form-control validate[required]" id="numero"  name="numero" value="${pontoEstrategico.numero}"/>
                                </div>
                                <div class="form-group col-md-12 ">
                                    <label for="Complemento">Complemento : </label>
                                    <input type="text" class="form-control form-control validate[required]" id="complemento"  name="complemento" value="${pontoEstrategico.complemento}"/>
                                </div>
                                <div class="form-group col-md-12 ">
                                    <label for="CEP">CEP : </label>
                                    <input type="text" class="form-control form-control validate[required]" id="cep"  name="cep" value="${pontoEstrategico.cep}"/>
                                </div>
                                <div class="form-group col-md-12 ">
                                    <label for="Cidade">Cidade : </label>
                                    <input type="text" class="form-control form-control validate[required]" id="cidade"  name="cidade" value="${pontoEstrategico.cidade}"/>
                                </div>
                                <div class="form-group col-md-12 ">
                                    <label for="Estado">Estado : </label>
                                    <input type="text" class="form-control form-control validate[required]" id="uf"  name="uf" value="${pontoEstrategico.estado}"/>
                                </div>
                                <div class="form-group col-md-12 ">
                                    <label for="Estado">Ramo de Atividade : </label>
                                    <input type="text" class="form-control form-control validate[required]" id="ramoAtividade"  name="ramoAtividade" value="${pontoEstrategico.ramoAtividade}"/>
                                </div>

                                <div class="form-group col-md-12">
                                    <label for="InputStatus"> Responsável : </label>
                                    <select  class="form-control validate[required]" name="usuario.id" id="usuario.id">
                                        <c:forEach var="usuario" items="${usuarioList}">
                                            <c:if test="${usuario.tipo eq 'AGS'}">
                                                <option value="${usuario.id}" <c:if test="${pontoEstrategico.usuario.id eq usuario.id}">selected</c:if>> ${usuario.nome}  </option>
                                            </c:if>

                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="form-group col-md-12 ">
                                    <label for="latitude">Latitude : </label>
                                    <input type="text" class="form-control form-control "   name="latitude" id="latitude" value="${pontoEstrategico.latitude}"/>
                                </div>
                                <div class="form-group col-md-12 ">
                                    <label for="longitude">Longitude : </label>
                                    <input type="text" class="form-control form-control "   name="longitude" id="longitude" value="${pontoEstrategico.longitude}"/>
                                </div>


                                <div class="form-group form-inline col-lg-12 text-center ">
                                    <br/>
                                     <a href="#"  name="cancelar" class="btn btn-default" onclick="javascript:history.back();" value="cancelar"> &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp; Cancelar &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;</a>
                                        
                                    <input class="btn btn-success " onclick="getFormData()" value="Salvar" />  
                                </div>
                            </form>
                            <!--<button onclick="myFunction()">report via ajax</button>-->
                            <br/>
                        </div>
                    </div>
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- /#page-wrapper -->
        </div>
        <div class="modal fade" id="successCreate">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header btn-success">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h3 class="modal-title">SPIAA</h3>
                    </div>
                    <div class="modal-body text-center">
                        <div class="alert alert-success">
                            <strong> Ponto Estratégico salvo com Sucesso</strong> <br/>
                            <i class="fa fa-2x fa-spinner fa-pulse"></i>
                            <p>Você está sendo redirecionado.....</p>
                        </div>

                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
    </body>
</html>
