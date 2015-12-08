
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../imports.jspf" %>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <jsp:include page="../template-admin/header.jsp"/>
        <link href="<c:url value="/css/jquery-ui.min.css"/>" rel="stylesheet">
        <script src="<c:url value="/js/jquery-ui.min.js"/>"></script>
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
                                Quartei&atilde;o
                                <c:if test="${not empty quarteirao}"><small>Alterar</small></c:if>
                                <c:if test="${empty quarteirao}"><small>Novo</small></c:if>
                                </h1>
                            <c:if test="${not empty mensagem}">  <div class="alert alert-danger alert-dismissible" role="alert">
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <p class="text-center">${mensagem}</p> 
                                </div>
                            </c:if>
                            <form class="form-inline" method="POST" name="form" id="form">
                                <div class="form-inline col-md-4 ">
                                    <label for="descricao">Sigla: </label>
                                    <input type="text" class="form-control validate[required]"  maxlength="6" name="descricao" value="${quarteirao.descricao}"/>                                    
                                </div>

                                <div class="form-inline col-md-4 ">
                                    <label for="bairro">Bairro: </label>
                                    <select id="bairro" name="bairro.id" class="form-control validate[required]">
                                        <option>Selecione...</option>
                                        <c:if test="${bairroList != null}">
                                            <c:forEach var="bairro" items="${bairroList}">
                                                <option value="${bairro.id}" 
                                                        <c:if test="${quarteirao.bairro.id eq bairro.id}">
                                                            selected
                                                        </c:if>>${bairro.nome}
                                                </option>
                                            </c:forEach>
                                        </c:if>
                                    </select>                                   
                                </div>

                                <div class="form-inline col-md-4 ">
                                    <label for="quantidade">Quantidade de Quartei&otilde;es: </label>
                                    <input type="number" class="form-control validate[required]"  name="quantidade" 
                                           <c:if test="${quarteirao != null}">disabled="" value="1"
                                           </c:if> />                                    
                                </div>
                                <br/><br/><br/><br/><br/><br/><br/><br/>
                                <div class="col-lg-12" align="left">
                                    <a href="#"  name="cancelar" class="btn btn-default" onclick="javascript:history.back();" value="cancelar">Cancelar</a>
                                    <input class="btn btn-success" type="submit" name="salvar" value="&nbsp;&nbsp;Salvar&nbsp;&nbsp;"/>  
                                </div>
                            </form>
                        </div>
                        <br/>
                    </div>
                </div>

            </div>
            <!-- /.container-fluid -->
        </div>
        <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->     
    <script>
        jQuery(document).ready(function () {
            // binds form submission and fields to the validation engine
            jQuery("#form").validationEngine('attach', {promptPosition: "bottomLeft", autoPositionUpdate: true});
        });
    </script>
</body>
</html>
