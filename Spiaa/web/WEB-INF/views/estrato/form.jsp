<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../imports.jspf" %>
<!DOCTYPE html>
<html lang="pt-br">

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
                            <h1 class="page-header">
                              <c:if test="${empty estrato}">
                                    Novo Estrato 
                                </c:if>
                                    <c:if test="${not empty estrato}">
                                   Alterar Estrato 
                                </c:if>
                            </h1>
                            <br/>
                            <div class="col-lg-1 row"></div>      
                            <div class="col-lg-12 row">
                                <form class="form-inline" role="form" method="POST">
                                    <div class="form-group col-md-5">
                                        <label class="" for="estrato">Nome :</label><br/>
                                        <input type="hidden" value="${estrato.id}" name="id">
                                        <div class="input-group margin-bottom-sm">
                                            <span class="input-group-addon"><i class="fa fa-globe "></i></span>
                                            <input class="form-control" type="text" id="nome" name="nome" value="${estrato.nome}" placeholder="Digite o Nome do estrato">
                                        </div>
                                    </div>
                                    <div class="form-group col-md-2 ">
                                        <label class="" for="dataInicio">&nbsp;</label><br/>
                                        <input type="submit" class="btn btn-success btn-block" value=" Gravar" />

                                    </div>

                                    <br/> <br/>    <br/> <br/> <br/> 

                                    <div class="form-group col-lg-12">
                                        <label>Selecione os Bairros pertencentes a este Estrato :</label>

                                    </div>
                                    <br/> 
                                    <div class="checkbox col-lg-12">
                                        <!--<div class="panel-group" id="accordion">-->

                                        <c:forEach var="bairros" items="${bairroList}">

                                            <div class="form-group col-md-3">
                                                <label>
                                                    <input type="checkbox" value="${bairros.id}" name="bairro"
                                                           <c:forEach var="bairross" items="${estrato.bairroEstratoList}">
                                                               <c:if test="${bairros.id eq bairross.bairro.id}">
                                                                   checked
                                                               </c:if>
                                                           </c:forEach> 
                                                           >
                                                    ${bairros.nome}
                                                </label>

                                            </div>
                                            <c:forEach var="dadosbairro" items="${estrato.bairroEstratoList}">
                                                <c:if test="${bairros.id eq dadosbairro.bairro.id}">    
                                                    <div class="form-inline col-md-12" hidden>
                                                        <div class="form-group col-md-4 ">
                                                            <label for="codigo">codigo :</label>
                                                            <input type="text" class="form-control"  name="codigo" value="${dadosbairro.codigo}">
                                                        </div>
                                                        <div class="form-group col-md-4">
                                                            <label for="armazem">Total Armazem : </label>
                                                            <input type="text" class="form-control"  name="armazem" value="${dadosbairro.totalArmazem}">
                                                        </div>

                                                        <div class="form-group col-md-4">
                                                            <label for="residencia">Total Residência : </label>
                                                            <input type="text" class="form-control"  name="residencia" value="${dadosbairro.totalResindencia}">
                                                        </div>
                                                        <div class="form-group col-md-4">
                                                            <label for="imoveis">Total Imóveis :</label>
                                                            <input type="text" class="form-control"  name="imoveis" value="${dadosbairro.totalImoveis}">
                                                        </div>  
                                                        <div class="form-group col-md-4">
                                                            <label for="comercio">Total Comércio : </label>
                                                            <input type="text" class="form-control" name="comercio"  value="${dadosbairro.totalComercio}">
                                                        </div>

                                                        <div class="form-group col-md-4">
                                                            <label for="predio">Total Prédios : </label>
                                                            <input type="text" class="form-control" name="predio" value="${dadosbairro.totalPredios}">
                                                        </div>
                                                        <div class="form-group col-md-4">
                                                            <label for="terrenobaldio">T. Terreno Baldio : </label>
                                                            <input type="text" class="form-control"  name="terrenobaldio" value="${dadosbairro.totalTerrenoBaldio}">
                                                        </div>
                                                        <div class="form-group col-md-4">
                                                            <label for="habitantes">Total Habitantes :</label>
                                                            <input type="text" class="form-control" name="habitantes" value="${dadosbairro.totalHabitantes}">
                                                        </div>  
                                                        <div class="form-group col-md-4">
                                                            <label for="outros">Outros :</label>
                                                            <input type="text" class="form-control"  name="outros" value="${dadosbairro.outros}">
                                                        </div>
                                                    </div>
                                                </c:if>
                                            </c:forEach>
                                        </c:forEach>


                                    </div> 
                                    <!--                                    </div> -->


                                </form>


                                <div class="col-lg-1 row"></div>   

                                <br/><br/> <br/><br/>
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
