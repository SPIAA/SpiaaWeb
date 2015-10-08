<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../imports.jspf" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <jsp:include page="../template-admin/header.jsp"/>
<!--        <link href="<c:url value="/css/jquery-ui.min.css"/>" rel="stylesheet">
        <script src="<c:url value="/js/jquery-ui.min.js"/>"></script>-->
    </head>
    <body>
        <div id="wrapper"  class="col-lg-12">
            <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
                <jsp:include page="../template-admin/menutop.jsp"/>
            </nav>
            <div id="page-wrapper">
                <div class="container-fluid">
                    <!-- Page Heading -->
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">
                                Usuário
                                 <c:if test="${not empty usuario}"><small>Alterar</small></c:if>
                                <c:if test="${empty usuario}"><small>Novo</small></c:if>
                            </h1>
                            <c:if test="${not empty mensagem}">  <div class="alert alert-danger alert-dismissible" role="alert">
                                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                    <p class="text-center">${mensagem}</p> 
                                </div>
                            </c:if>
                            <form class="form-group" method="POST" name="form" id="form">
                                <div class="form-group col-md-4 ">
                                    <label for="nome">Nome: </label>
                                    <input type="text" class="form-control validate[required]"  name="nome" value="${usuario.nome}"/>
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="usuario">Nome de Usuário:</label>
                                    <input type="text" class="form-control validate[required]"  name="usuario" value="${usuario.usuario}"/>
                                </div> 
                                <div class="form-group col-md-4">
                                    <label for="tipo">Tipo de Usuário: </label>
                                    <select class="form-control " name="tipo" id="tipo">
                                        <option value="0">Selecione...</option>
                                        <option value="AGS" <c:if test="${usuario.tipo == 'AGS'}">selected</c:if>>Agente de Saúde</option>
                                        <option value="ADM" <c:if test="${usuario.tipo == 'ADM'}">selected</c:if>>Administrador</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-md-4">
                                        <label for="email">Email:</label>
                                        <input type="email" class="form-control validate[required]"  name="email" value="${usuario.email}"/>
                                </div>              
                                <div class="form-group col-md-4">
                                    <label for="numero">Número :</label>
                                    <input type="text" class="form-control validate[required]"  name="numero" value="${usuario.numero}"/>
                                </div> 
                                <div class="form-group col-md-4">
                                    <label for="turma">Turma :</label>
                                    <input type="text" class="form-control validate[required]"  name="turma" value="${usuario.turma}"/>
                                </div> 

                                <div class="form-group col-md-4">
                                    <label for="senha">Senha:</label>
                                    <input type="password" class="form-control validate[required]" id="senha" name="senha" value="${usuario.senha}" placeholder="Min. 8 caracteres"/>
                                </div>
                                <div class="form-group col-md-4">
                                    <label for="confirmaSenha">Confirme a Senha:</label>
                                    <input type="password" id="confirmaSenha"class="form-control validate[required]" onchange="verificarSenhas()" name="confirmaSenha" id="confirmaSenha"/>
                                </div>
                                <br/><br/><br/><br/><br/><br/><br/><br/>
                                <div class="col-lg-12" align="center">
                                    <input class="btn btn-success" type="submit" name="salvar" onclick="verificarSenhas()"  value="Salvar"/>  
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