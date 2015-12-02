<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../imports.jspf" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:include page="../template-admin/header.jsp"/>
        <script src="<c:url value="/js/views/bairroQuarteirao.js"/>"></script>
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
                    <!-- Page Heading -->
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">
                                Bairro ${bairro.nome}
                                <small>Listagem de Quarteirões</small>

                            </h1>
                            <input type="hidden" id="bairroid"  name="bairroid" value="${bairro.id}"/>
                            <a href="#" class="btn btn-default" onclick="novoQuarteirao()"><i class="fa fa-fw fa-plus"></i> Novo</a><br/><br/>
                            <table id="table_id" class="table table-striped table-bordered" cellspacing="0" width="100%">
                                <thead>
                                    <tr>
                                        <th hidden="true">id</th>
                                        <th>Descrição</th>
                                        <th>Bairro</th>
                                        <th align="center" style="width:70px;" class="no-sort"> </th>
                                        <th align="center" style="width:70px;" class="no-sort"> </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${quarteiraoList}" var="quarteirao">
                                        <tr>
                                            <td class="idquarteirao" hidden="true">${quarteirao.id}</td>
                                            <td class="descricaoQuarteirao">${quarteirao.descricao}</td>
                                            <td>${quarteirao.bairro.nome}</td>
                                            <td align="center"><a href="#" data-toggle="tooltip" data-placement="top" onclick="alterarQuarteirao(this)" title="Alterar"><i class="fa fa-2x fa-edit text-primary"></i></a></td>
                                            <td align="center"><a href="#" data-toggle="tooltip" data-placement="top" title="Excluir" onclick="excluir(this)"><i class="fa fa-2x fa-trash-o text-danger"></i></a></td>
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
        <!-- /#wrapper -->
        <div class="modal fade" id="confirmDelete">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header btn-danger">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h3 class="modal-title">Atenção</h3>
                    </div>
                    <div class="modal-body">
                        <p>Deseja realmente excluir este Quarteir&atilde;o?</p>
                        <div class="alert alert-danger">
                            <strong> Atenção: esta operação não pode ser desfeita.</strong> 
                        </div>
                    </div>
                    <div class="modal-footer">
                        <a href="#" onclick="excluirQuarteirao()" class="btn btn-danger">Sim, desejo excluir.</a>
                        <a href="#" class="btn btn-default" data-dismiss="modal">Cancelar</a>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->


        <div class="modal fade" id="novoQuarteirao">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header btn-danger">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h3 class="modal-title">Gerar Quarteirão</h3>
                    </div>
                    <div class="modal-body">
                        <form class="form-group" method="POST" name="form" id="form">
                            <input type="hidden" class="form-control"  name="idQuarteirao" id="idQuarteirao" />                                    

                            <div class="form-group ">
                                <label for="descricao" id="labelDescricao" >Descrição :</label>
                                <label for="descricao" id="labelSigla">Sigla referência :<i class="fa fa-question-circle text-info" data-toggle="tooltip" data-placement="top" title="Sigla que será utilizada para gerar a descrção do quarteirão!"></i> </label>
                                <input type="text" class="form-control validate[required]"  maxlength="6" name="descricao" id="descricaoQuarteirao" value="${quarteirao.descricao}"/>                                    
                            </div>
                            <div class="form-group" >
                                <label for="quantidade" id="labelQuantidade" >Quantidade de Quarteir&otilde;es: </label>
                                <input type="number" class="form-control" id="quantidadeQuarteirao" name="quantidade" />                                    
                            </div>
                        </form>
                    </div>
                    <div class="modal-footer">
                        <a href="#" class="btn btn-default" onclick="getFormData()">Salvar</a>
                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->

        <!-- /#wrapper -->
        <div class="modal fade" id="successCreate">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header btn-success">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h3 class="modal-title">SPIAA</h3>
                    </div>
                    <div class="modal-body text-center">
                        <div class="alert alert-success">
                            <strong > Salvando Quarteirão, aguarde por favor..</strong> <br/>
                            <i class="fa fa-2x fa-spinner fa-pulse"></i>
                            <p>Você será redirecionado.....</p>
                        </div>

                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
        
        <!-- /#wrapper -->
        <div class="modal fade" id="duplicated">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header btn-warning">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h3 class="modal-title">SPIAA</h3>
                    </div>
                    <div class="modal-body text-center">
                        <div class="alert alert-warning">
                            <strong > Quarteirão Informado já cadastrada!</strong> <br/>
                            <i class="fa fa-2x fa-warning"></i>
                            <p>A descrição informada já foi cadastrada para outro quateirão, verifique e tente novamente!</p>
                        </div>

                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
       
    </body>
</html>