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
                                        <div class="panel-heading">Dados da Denuncia</div>
                                        <div class="panel-body">
                                            <div class="form-group">
                                                <label for="Inputendereco">Bairro :</label><input type="text"  class="form-control" readonly name="bairro.nome" value="${denuncia.bairro.nome}"/>
                                            </div>


                                            <div class="form-group">
                                                <label for="Inputendereco">Endereço:</label><input type="text"  class="form-control" readonly name="endereco" value="${denuncia.endereco}"/>
                                            </div>

                                            <div class="form-group">
                                                <label for="Inputnumero">Numero:</label><input type="text"  class="form-control" readonly name="numero" value="${denuncia.numero}" />
                                            </div>
                                            <div class="form-group">
                                                <label for="Inputtelefone">Telefone:</label><input type="text"  class="form-control" readonly id="telefone" name="telefone" value="${denuncia.telefone}"/>

                                            </div>
                                            <div class="form-group">
                                                <label for="Inputtipoirregularidade">Tipo de irregularidades:</label><textarea  class="form-control" readonly name="irregularidade" >${denuncia.irregularidade}</textarea>
                                            </div>
                                            <div class="form-group">
                                                <label for="Inputobservacao">Observação:</label><textarea  class="form-control" readonly name="observacao" > ${denuncia.observacao}</textarea>
                                            </div>

                                        </div>
                                    </div>

                                </div>

                                <input type="text" class="" hidden="" name="id" value="${denuncia.id}"/>
                                <div class="col-md-6 column">
                                    <div class="form-group">
                                        <label for="InputStatus"> Responsável : </label>
                                        <select  class="form-control validate[required]" name="usuario.id" id="">
                                            <c:forEach var="usuario" items="${usuario}">
                                                <c:if test="${usuario.tipo eq 'AGS'}">
/                                                    <option value="${usuario.id}" <c:if test="${denuncia.usuario.id eq usuario.id}">selected</c:if>> ${usuario.nome}  </option>
                                                </c:if>

                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="InputStatus">  Status : </label>
                                        <select class="form-control col-lg-11"  name="status" <c:if test="${denuncia.status eq 'fechado'}"> disabled</c:if>>
                                            <option value="aberto" <c:if test="${denuncia.status eq 'aberto'}"> selected</c:if> >Aberto</option>
                                            <option value="encaminhado" <c:if test="${denuncia.status eq 'encaminhado'}"> selected</c:if>>Encaminhado</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label for="InputConclusao">Conclusão :</label><textarea  class="form-control" name="conclusao" readonly >${denuncia.conclusao}</textarea>
                                        </div>
                                        <div class="col-sm-4"> <p> &nbsp;</p></div>
                                        <div class="col-sm-4"> <input class="btn btn-lg btn-block btn-default" type="submit"  value="Salvar" <c:if test="${denuncia.status eq 'fechado'}"> disabled</c:if> /> </div>
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



    </body>

</html>
