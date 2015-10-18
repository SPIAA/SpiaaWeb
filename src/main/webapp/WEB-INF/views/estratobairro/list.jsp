<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../imports.jspf" %>
<!DOCTYPE html>
<html>

    <head>
        <jsp:include page="../template-admin/header.jsp"/>
    </head>

    <body>

        <div id="wrapper"  class="col-lg-12">

            <!-- Navigation -->
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">

                <jsp:include page="../template-admin/menutop.jsp"/>

            </nav>

                <div id="page-wrapper" style="height: auto">

                <div class="container-fluid">
                    <!-- Page Heading -->
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">Estrato <small>Dados dos bairros</small>  </h1>
                            
                            <form class="form-inline" role="form" method="POST">
                               <div class="col-lg-12">
                                <div class="form-group col-md-5">
                                    <label class="" for="estrato"><h3>${estrato.nome}</h3></label><br/>
                                    <input type="hidden" value="${estrato.id}" name="id">
                                    <div class="input-group margin-bottom-sm">
                                        <input class="form-control" type="hidden" id="nome"  name="nome" value="${estrato.nome}">
                                    </div>
                                </div>
                                <div class="form-group col-md-7 text-right">   
                                      
                                        <input type="submit" class="btn btn-lg btn-success text-right" value=" Gravar" />
                                   
                                </div>
                               </div>
                                <br/><br/><br/><br/>
                                <div class="col-lg-12">
                                    <div class="checkbox col-md-12">
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
                                                                    <label for="codigo">Código :</label>
                                                                    <input type="text" class="form-control"  name="codigo" value="${bairros.codigo}">
                                                                </div>
                                                                <div class="form-group col-md-4">
                                                                    <label for="armazem">Total Armazém : </label>
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
                                                                    <label for="terrenobaldio">Terreno Baldio : </label>
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
                                                </div>
                                            </c:forEach>
                                        </c:if>
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
    </body>

</html>
