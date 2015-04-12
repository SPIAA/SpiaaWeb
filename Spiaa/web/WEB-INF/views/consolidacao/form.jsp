<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../imports.jspf" %>
<!DOCTYPE html>
<html>

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
                            <h1 class="page-header">Consolidação de Dados <small>Novo</small>  </h1>


                            <div class="form-inline">
                                <div class="form-group col-md-6">
                                    <label><h4>Data Inicial do Liraa:</h4> </label>
                                    <fmt:formatDate pattern="dd/MM/yyyy" value="${consolidacaoDados.liraa.dataInicio}" /> 

                                </div>
                                <div class="form-group col-md-6">
                                    <label class=""> <h4>Data Final do Liraa :</h4> </label>
                                    <fmt:formatDate pattern="dd/MM/yyyy" value="${consolidacaoDados.liraa.dataTermino}" />

                                </div>

                            </div>

                            <form role="form" method="POST">
                                <input type="text" hidden="" name="liraa.id"  value=" ${consolidacaoDados.liraa.id}">
                                <div class="form-inline col-md-12">
                                    <div class="form-group col-md-2">
                                        <label for="programados">Estrato : </label>
                                        <select class="form-control" name="estrato.id" id="estrato.id">
                                            <c:forEach var="estrato" items="${estratoList}">
                                                <option value="${estrato.id}" <c:if test="${consolidacaoDados.estrato.id eq estrato.id}">selected</c:if>>
                                                    
                                                    ${estrato.nome}
                                                </option>
                                                </c:forEach>
                                        </select>
                                    </div>

                                    <div class="form-group col-md-2 ">
                                        <label for="programados">Programados : </label>
                                        <input type="text" class="form-control" id="programados" name="programados" value="${consolidacaoDados.programados}">
                                    </div>
                                    <div class="form-group col-md-2">
                                        <label for="inspecionados">Inspecionados : </label>
                                        <input type="text" class="form-control" id="inspecionados" name="inspecionados" value="${consolidacaoDados.inspecionados}">
                                    </div>

                                    <div class="form-group col-md-2">
                                        <label for="terrenobaldio">Terreno Baldio : </label>
                                        <input type="text" class="form-control" id="terrenobaldio" name="terrenobaldio" value="${consolidacaoDados.terrenobaldio}">
                                    </div>
                                    <div class="form-group col-md-2">
                                        <label for="outros">Outros :</label>
                                        <input type="text" class="form-control" id="outros" name="outros" value="${consolidacaoDados.outros}">
                                    </div>

                                    <div class="form-group col-md-2">

                                    </div>
                                </div>
                                <br/><br/><br/><br/><br/>
                                <div class="form-inline col-md-12">
                                    <div class="">
                                        <h4> Tipo de Criadouros:</h4>  
                                    </div>
                                    <c:if test="${empty consolidacaoDados.consolidacaoCriadouroList}">
                                    <c:forEach var="criadouro" items="${criadouroList}">

                                        <div class="form-group col-md-1">
                                            <label for="criadouro">${criadouro.nome} :</label>
                                            <input type="text" class="form-control"  name="qdte">
                                            <input type="hidden" name="criadouro" value="${criadouro.id}">
                                        </div>

                                    </c:forEach>
                                    </c:if>
                                    <c:if test="${not empty consolidacaoDados.consolidacaoCriadouroList}">
                                        
                                        <c:forEach var="concriadouro" items="${consolidacaoDados.consolidacaoCriadouroList}">

                                        <div class="form-group col-md-1">
                                            <label for="criadouro">${concriadouro.criadouro.nome} :</label>
                                            <input type="text" class="form-control"  name="qdte" value="${concriadouro.qtde}">
                                            <input type="hidden" name="criadouro" value="${concriadouro.criadouro.id}">
                                        </div>

                                    </c:forEach>
                                        
                                    </c:if>

                                </div>
                                <br/><br/><br/><br/><br/>
                                <div class="form-group col-md-12 text-center">
                                    <button type="submit" class="btn btn-success">Salvar Consolidação de Dados</button>
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
    </body>

</html>
