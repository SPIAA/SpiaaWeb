<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../imports.jspf" %>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <jsp:include page="../template-admin/header.jsp"/>
        <script src="<c:url value="/js/views/atividade.js"/>"></script>
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
                                Tratamento Anti-Vetorial
                                <small>Atividade</small>
                            </h1>

                            <form role="form" method="POST">
                                <input type="text" name="boletimId" hidden value="${atividade.boletimDiario.id}">
                                <div class="col-md-1">
                                    <label for="numero_quateirao">Nª Quart.</label>
                                    <select  class="form-control validate[required]" name="quarteirao.id" id="">
                                        <c:forEach var="quarteirao" items="${quarteiraoList}">
                                            <option value="${quarteirao.id}" <c:if test="${atividade.quarteirao.id eq quarteirao.id}">selected</c:if>> ${quarteirao.descricao}  </option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="form-group col-md-4">
                                    <label for="endereco">Endereço</label>
                                    <input type="text" class="form-control" name="endereco" value="${atividade.endereco}">
                                </div>
                                <div class="form-group col-md-1">
                                    <label for="numero">Nº:</label>
                                    <input type="text" class="form-control" name="numero" value="${atividade.numero}" >
                                </div>

                                <div class="form-group col-md-5">
                                    <label for="endereco" class="form-group">Tipo de unidade :</label>
                                    <br/>
                                    <c:forEach var="imovel" items="${tipoImoveisList}">
                                        <label class="radio-inline col-md-2">
                                            <input type="radio" name="tipoImovel" id="tipoimovel" value="${imovel.id}"
                                                   <c:if test="${imovel.id eq atividade.tipoImoveis.id}"> checked </c:if>
                                                   > ${imovel.sigla}

                                        </label>
                                    </c:forEach>
                                </div>

                                <div class="form-group col-md-1">
                                    <label for="total_inspecionado">T.Insp.:</label>
                                    <input type="text" class="form-control" name="inspecionado" value="${atividade.inspecionado}">
                                </div>

                                <div class="form-group col-lg-4 ">
                                    <label for="endereco" class="form-group">Consumo de Inseticida :</label>
                                    <br/>
                                    <c:if test="${empty atividade.atividadeInseticidasList}">
                                        <c:forEach var="inseticida" items="${inseticidaList}">
                                            <div class="form-group col-md-6">
                                                <label for="endereco">${inseticida.nome}</label>
                                                <input type="text" class="form-control" name="quantidadeInseticida" value="">
                                                <input type="hidden" name="inseticida" value="${inseticida.id}">
                                            </div>
                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${not empty atividade.atividadeInseticidasList}">
                                        <c:forEach var="inseticida" items="${atividade.atividadeInseticidasList}">
                                            <div class="form-group col-md-6">
                                                <label for="endereco">${inseticida.inseticida.nome}</label>
                                                <input type="text" class="form-control" name="quantidadeInseticida" value="${inseticida.quantidadeInseticida}">
                                                <input type="hidden" name="inseticida" value="${inseticida.inseticida.id}">
                                            </div>
                                        </c:forEach>


                                    </c:if>
                                </div>

                                <div class="form-group col-lg-8 ">
                                    <br/><br/>
                                    <label for="endereco" class="form-group">Observações :</label>
                                    <br/>
                                    <label class="radio-inline col-md-2">
                                        <input type="radio" name="observacao" id="observacao" value="Recusou" <c:if test="${atividade.observacao eq 'Recusou'}">checked</c:if>   > Recusou
                                        </label>
                                        <label class="radio-inline col-md-2">
                                            <input type="radio" name="observacao" id="observacao" value="Fechado" <c:if test="${atividade.observacao eq 'Fechado'}">checked</c:if>  > Fechado
                                        </label>
                                        <label class="radio-inline col-md-2">
                                            <input type="radio" name="observacao" id="observacao" value="Resgatado" <c:if test="${atividade.observacao eq 'Resgatado'}">checked</c:if> > Resgatado
                                        </label>

                                    </div>
                                    <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/>

                                    <div class="form-group col-lg-12 ">
                                        <label for="endereco" class="form-group">Tipo de criadouro :</label>
                                        <br/>
                                    <c:if test="${empty atividade.atividadeCriadouroList}">
                                        <c:forEach var="criadouro" items="${criadouroList}">

                                            <div class="form-group col-md-1">
                                                <label for="criadouro">${criadouro.grupo} :<i class="fa fa-exclamation-circle text-info" data-toggle="tooltip" data-placement="top" title="${criadouro.recipiente}"></i></label>
                                                <input type="text" class="form-control" id="quantidadeCriadouro"  name="quantidadeCriadouro" >
                                                <input type="hidden" name="criadouro" id="criadouro" value="${criadouro.id}">
                                            </div>

                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${not empty atividade.atividadeCriadouroList}">
                                        <c:forEach var="criadouro" items="${atividade.atividadeCriadouroList}">
                                            <div class="form-group col-md-1">
                                                <label for="criadouro">${criadouro.criadouro.grupo} :<i class="fa fa-exclamation-circle text-info" data-toggle="tooltip" data-placement="top" title="${criadouro.criadouro.recipiente}"></i></label>
                                                <input type="text" class="form-control" id="quantidadeCriadouro"  name="quantidadeCriadouro" value="${criadouro.quantidadeCriadouro}">
                                                <input type="hidden" name="criadouro" id="criadouro" value="${criadouro.criadouro.id}">
                                            </div>

                                        </c:forEach>

                                    </c:if>
                                </div>
                                <br/><br/><br/><br/>
                                <div class="col-lg-12" align="center">

                                    <button class="btn btn-success" type="submit" > Salvar Atividade</button>  

                                </div>
                                <br/>
                            </form>
                            <br/>
                            <!-- Modal -->
                        </div>
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- /#page-wrapper -->
        </div>
        <!-- /#wrapper -->
        <script>
            $(function () {
                $('[data-toggle="tooltip"]').tooltip()
            });
        </script>
    </body>
</html>
