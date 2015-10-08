
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
                            <c:if test="${empty boletimDiario}">
                            <h1 class="page-header">
                                Boletim Diário
                                <small>Novo</small>
                            </h1>
                            </c:if>
                             <c:if test="${not empty boletimDiario}">
                            <h1 class="page-header">
                                Boletim Diário
                                <small>Alterar</small>
                            </h1>
                            </c:if>
                            <form class="form-group" method="POST">

                                <div class="form-group col-md-2 ">
                                    <label for="codigo">Data :</label>
                                    <input type="text" class="form-control"  name="dataBoletim" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${boletimDiario.dataBoletim}" />" id="datepicker" >
                                </div>
                                <div class="form-group col-md-5">
                                    <label for="armazem">Agente de saúde : </label>
                                    <select class="form-control" name="usuario.id" id="usuario.id">
                                        <c:forEach var="usuario" items="${usuarioList}">
                                            <option value="${usuario.id}" <c:if test="${boletimDiario.usuario.id eq usuario.id}">selected</c:if>>
                                                ${usuario.nome}
                                            </option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="form-group col-md-5">
                                    <label for="residencia">Bairro : </label>
                                    <select  class="form-control" name="bairro.id" id="estrato.id">
                                        <c:forEach var="bairroList" items="${bairrosList}">
                                            <option value="${bairroList.id}" <c:if test="${boletimDiario.bairro.id eq bairroList.id}">selected</c:if> >
                                                ${bairroList.nome}  </option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="form-group col-md-2">
                                    <label for="imoveis">Nº :</label>
                                    <input type="text" class="form-control"  name="numero" value="${boletimDiario.numero}">
                                </div>  
                                <div class="form-group col-md-3">
                                    <label for="comercio"> Turma</label>
                                    <input type="text" class="form-control" name="turma"  value="${boletimDiario.turma}">
                                </div>
                                <div class="form-group col-md-3">
                                    <label for="predio">Semana epidemiológica :</label>
                                    <input type="text" class="form-control" name="semana" value="${boletimDiario.semana}">
                                </div>
                                <div class="form-group col-md-2">
                                    <label for="predio">nº Atividade :</label>
                                    <input type="text" class="form-control" name="numeroAtividade" value="${boletimDiario.numeroAtividade}">
                                </div>
                                <div class="form-group col-md-2">
                                    <label for="predio">Tipo Atividade :</label>
                                    <input type="text" class="form-control" name="tipoAtividade" value="${boletimDiario.tipoAtividade}">
                                </div>


                                <br/><br/><br/><br/><br/><br/><br/><br/>
                                <div class="col-lg-12" align="center">

                                    <button class="btn btn-success " > Salvar</button>  

                                </div>


                            </form>
                            <br/>
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
            $(function() {
                $("#datepicker").datepicker(
                        {dateFormat: "dd/mm/yy",
                            monthNames: ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"],
                            dayNamesMin: ["Dm", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab"]

                        });
            });


        </script>

    </body>


</html>
