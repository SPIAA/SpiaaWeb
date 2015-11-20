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
                <link href="<c:url value="/css/jquery-ui.min.css"/>" rel="stylesheet">
                <script src="<c:url value="/js/jquery-ui.min.js"/>"></script>


            </nav>

            <div id="page-wrapper">

                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">
                                Emissão de Relatório
                                <!--<small>subTitulo</small>-->

                            </h1>
                            <form role="form" action="<c:url value="/relatorio/imoveisagentes"/>" target="_blank" method="POST">
                                <div class="form-group col-md-12">
                                    <div class="form-group col-md-2 ">
                                        <label for="codigo">Data Inicial:</label>
                                        <input type="text" class="form-control"  name="dataInicial" id="datepickerIn" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${dataInicial}" />">
                                    </div>
                                    <div class="form-group col-md-2 ">
                                        <label for="codigo">Data Final:</label>
                                        <input type="text" class="form-control"  name="dataFinal" id="datepickerFin" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${dataFinal}" />">
                                    </div>
                                    <div class="form-group col-md-1 ">
                                        <label for="codigo">&nbsp;&nbsp;</label>
                                        <br/>
                                        <input class="btn btn btn-default" type="submit" value="Gerar Relatório" /> 
                                    </div>
                                </div>

                            </form>
                            <table id="table_id" class="table table-striped table-bordered" cellspacing="0" width="100%">
                                <thead>
                                    <tr>
                                        <th>Agente</th>
                                        <th align="right"> Dias Trabalhados</th>
                                        <th align="rigth"> Imóveis Visitados</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${imoveisVisitadosList}" var="imoveisVisitados">
                                        <tr>
                                            <td>${imoveisVisitados.usuario.nome}</td>
                                            <td>${imoveisVisitados.diasTrabalhados}</td>
                                            <td>${imoveisVisitados.imoveisVisitados}</td>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>
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
                $("#datepickerIn").datepicker(
                        {dateFormat: "dd/mm/yy",
                            monthNames: ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"],
                            dayNamesMin: ["Dm", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab"]

                        });
                $("#datepickerFin").datepicker(
                        {dateFormat: "dd/mm/yy",
                            monthNames: ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"],
                            dayNamesMin: ["Dm", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab"]

                        });
            });
        </script>

    </body>

</html>
