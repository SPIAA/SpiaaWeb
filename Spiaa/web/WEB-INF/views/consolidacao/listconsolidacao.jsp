
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
                            <h1 class="page-header">Consolidação de Dados <small>Liraa</small>  </h1>

                            <br/>
                            <label>Data Inicial: </label><fmt:formatDate pattern="dd/MM/yyyy" value="${liraa.dataInicio}" /> <br/><br/>
                            <label>Data Final: </label><fmt:formatDate pattern="dd/MM/yyyy" value="${liraa.dataTermino}" />

                            <br/><br/>
                            <a href="<c:url value="/consolidacao/${liraa.id}/novo"/>" class="btn btn-primary" > Nova Consolidação </a>
                            <br/><br/>
                            <display:table class="table table-striped table-hover"  name="consolidacaoDadosList" id="consolidacaoDadosList" requestURI="" pagesize="7">
                                <display:column property="estrato.nome" title="Estrato"/>
                                <display:column property="programados" title="Programados"/>
                                <display:column property="inspecionados" title="Inspecionados"/>
                                <display:column property="terrenobaldio" title="Terreno Baldio"/>
                                <display:column property="outros" title="Outros"/>
                                <display:column value="<a href=\"${consolidacaoDadosList.id}/alterar\">Alterar</a>" title=""/>
                                <display:column value="<a href=\"../consolidacao/${consolidacaoDadosList.id}/excluir\">Excluir</a>" class="deleteLink" title=""/>

                            </display:table>


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
        <div class="modal fade" id="confirmDelete">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header btn-danger">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h3 class="modal-title">Atenção</h3>
                    </div>
                    <div class="modal-body">
                        <p>Você deseja realmente excluir?</p>
                        <div class="alert alert-danger">
                            Atenção: esta operação não pode ser desfeita.
                        </div>
                    </div>
                    <div class="modal-footer">
                        <a href="#" class="btn btn-danger">Sim, desejo excluir.</a>
                        <a href="#" class="btn btn-default" data-dismiss="modal">Cancelar</a>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
        <script>
            $(function() {
                $("td.deleteLink a").click(function() {
                    $('#confirmDelete').modal('show');
                    $("#confirmDelete .btn-danger").attr("href", $(this).attr("href"));
                    return false;
                });
            });
        </script>


    </body>

</html>
