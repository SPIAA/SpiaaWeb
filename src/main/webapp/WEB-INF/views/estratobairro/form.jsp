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

            </nav>

            <div id="page-wrapper">

                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">
                                Estrato
                                <c:if test="${not empty criadouro}"><small>Alterar</small></c:if>
                                <c:if test="${empty criadouro}"><small>Novo</small></c:if>
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
                                        <input type="submit" class="btn btn-success btn-block" value=" Salvar" />

                                    </div>

                                    <br/> <br/>    <br/> <br/> <br/> 

                                    <div class="form-group col-lg-12">
                                        <label>Selecione os Bairros pertencentes a este Estrato :</label>

                                    </div>
                                    <br/> 
                                    <div class="checkbox col-lg-12">

                                        <c:if test="${not empty estrato.bairroEstratoList}">
                                            <c:forEach var="bairros" items="${estrato.bairroEstratoList}">
                                                <div class="panel panel-default col-md-6">
                                                    <div class="panel-heading">
                                                        <div class="panel-title">
                                                            <input type="checkbox" value="${bairros.bairro.id}" checked="" name="bairro">
                                                            <a data-toggle="collapse" data-parent="#accordion" href="#${bairros.bairro.id}">
                                                                ${bairros.bairro.nome}
                                                            </a>
                                                        </div>
                                                    </div>

                                                    <div id="${bairros.bairro.id}" class="panel-collapse collapse">
                                                        <div class="panel-body">
                                                            <div class="form-inline col-md-12">
                                                                <div class="form-group col-md-4 ">
                                                                    <label for="codigo">codigo :</label>
                                                                    <input type="text" class="form-control"  name="codigo" value="${bairros.codigo}">
                                                                </div>
                                                                <div class="form-group col-md-4">
                                                                    <label for="armazem">Total Armazem : </label>
                                                                    <input type="text" class="form-control"  name="armazem" value="${bairros.armazem}">
                                                                </div>

                                                                <div class="form-group col-md-4">
                                                                    <label for="residencia">Total Residência : </label>
                                                                    <input type="text" class="form-control"  name="residencia" value="${bairros.residencia}">
                                                                </div>
                                                                <div class="form-group col-md-4">
                                                                    <label for="imoveis">Total Imóveis :</label>
                                                                    <input type="text" class="form-control"  name="imoveis" value="${bairros.imovel}">
                                                                </div>  
                                                                <div class="form-group col-md-4">
                                                                    <label for="comercio">Total Comércio : </label>
                                                                    <input type="text" class="form-control" name="comercio"  value="${bairros.comercio}">
                                                                </div>

                                                                <div class="form-group col-md-4">
                                                                    <label for="predio">Total Prédios : </label>
                                                                    <input type="text" class="form-control" name="predio" value="${bairros.predio}">
                                                                </div>
                                                                <div class="form-group col-md-4">
                                                                    <label for="terrenobaldio">T. Terreno Baldio : </label>
                                                                    <input type="text" class="form-control"  name="terrenobaldio" value="${bairros.terrenoBaldio}">
                                                                </div>
                                                                <div class="form-group col-md-4">
                                                                    <label for="habitantes">Total Habitantes :</label>
                                                                    <input type="text" class="form-control" name="habitantes" value="${bairros.habitante}">
                                                                </div>  
                                                                <div class="form-group col-md-4">
                                                                    <label for="outros">Outros :</label>
                                                                    <input type="text" class="form-control"  name="outros" value="${bairros.outros}"> 
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </c:forEach>
                                            </c:if>
                                        </div> 
                                        <div class="col-lg-1 row"></div>   

                                        <br/><br/> <br/><br/>
                                    </div>
                                </form>
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
