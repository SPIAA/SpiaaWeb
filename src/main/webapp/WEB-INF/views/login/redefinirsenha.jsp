<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>SPIAA - FAITEC 2014</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!--link rel="stylesheet/less" href="less/bootstrap.less" type="text/css" /-->
        <!--link rel="stylesheet/less" href="less/responsive.less" type="text/css" /-->
        <!--script src="js/less-1.3.3.min.js"></script-->
        <!--append ‘#!watch’ to the browser URL, then refresh the page. -->
        <!-- Bootstrap Core CSS -->
        <link href="<c:url value="/css/bootstrap.min-3.css"/>" rel="stylesheet">
        <!-- Custom CSS -->  
        <link href="<c:url value="/css/sb-admin.css"/>" rel="stylesheet">
        <!-- Custom Fonts -->
        <link href="<c:url value="/css/font-awesome.min.css"/>" rel="stylesheet">
        <!-- data tables -->

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
          <script src="js/html5shiv.js"></script>
        <![endif]-->

        <link rel="shortcut icon" href="<c:url value="/img/icone_spiaa.png"/>">
        <!-- jQuery Version 1.11.0 -->
        <script src="<c:url value="/js/jquery.min.js"/>"></script>

        <!-- Bootstrap Core JavaScript -->
        <script src="<c:url value="/js/jquery.dataTables.js"/>"></script>
        <script src="<c:url value="/js/dataTables.bootstrap.min.js"/>"></script>
        <!-- Bootstrap Core JavaScript -->
        <script src="<c:url value="/js/bootstrap.min.js"/>"></script>

        <script src="<c:url value="/js/jquery.validationEngine-pt_BR.js"/>" type="text/javascript" charset="utf-8"></script>
        <script src="<c:url value="/js/jquery.validationEngine.js"/>" type="text/javascript" charset="utf-8"></script>

        <script src="<c:url value="/js/views/recuperarSenha.js"/>"></script>
    </head>

    <body>
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <div class="row clearfix">
                        <div class="col-md-12 column">
                            <div class="col-md-2 column">
                                <img alt="" src="<c:url value="/img/MiniLogo.png"/>" class="img-responsive"> 
                            </div>
                            <div class="col-md-10 column">
                                <h3><b> Todos contra a Dengue!</b></h3>
                            </div>
                        </div>
                    </div>
                    <nav class="navbar navbar-default" role="navigation">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> 
                                <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span>
                                <span class="icon-bar"></span></button> <a class="navbar-brand" href="<c:url value="/home"/>">Início</a>
                        </div>

                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav">
                                <li class="">
                                    <a href="<c:url value="/mapa"/>">Mapa da cidade</a>
                                </li>
                                <li>
                                    <a href="<c:url value="/denunciaform"/>">Denuncie</a>
                                </li>

                            </ul>

                            <ul class="nav navbar-nav navbar-right">
                                <li>
                                    <a href="<c:url value="/login"/>">Acesso restrito</a>
                                </li>

                            </ul>
                        </div>

                    </nav>
                </div>
            </div>

            <div class="row clearfix">

                <div class="col-md-2 column"></div>
                <div class="col-md-8 column" style="border: 1px silver solid; border-radius: 15px;">
                    <div class="col-md-12 text-center">
                        <h3>Recupera&ccedil;&atilde;o de senha</h3>
                    </div>
                    <form role="form" class="form-group" method="POST">
                        <input type="hidden" id="id" name="id" value="${redefinirsenha.id}" />
                        <input type="hidden" id="token" name="token" value="${redefinirsenha.token}" />
                        <input type="hidden" id="token" name="userId" value="${redefinirsenha.usuario.id}" />

                        <div class="form-group col-md-12">
                            <div class="alert alert-success text-center" role="alert">Digite uma senha e a confirma&ccedil;&atilde;o de senha e pressione Redefinir para concluir a troca de senha. </div>
                        </div>
                        <div class="form-group col-md-12">
                            <label for="email">Email</label>
                            <input type="email" class="form-control validate[required]" id="email" name="email" value="${redefinirsenha.usuario.email}" disabled="" />
                        </div>
                        <div class="form-group col-md-12">
                            <label for="senha">Senha:</label>
                            <input type="password" class="form-control validate[required]" id="senha" name="senha" value="" placeholder="Min. 8 caracteres"/>
                        </div>
                        <div class="form-group col-md-12">
                            <label for="confirmaSenha">Confirme a Senha:</label>
                            <input type="password" id="confirmaSenha"class="form-control validate[required]" onchange="" name="confirmaSenha" id="confirmaSenha"/>
                        </div>


                        <div class="form-group col-sm-12 ">
                            <input class="btn btn-success btn-block " onclick="getFormData()" value="Redefinir" />  
                        </div>


                    </form>
                </div>
                <div class="col-md-2 column"></div>
            </div>
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <hr>
                    <div class="col-lg-3">
                        <img alt=""  height="75" src="<c:url value="/img/fai_mg.jpg"/>">
                    </div>
                    <div class="col-lg-3">
                        <img alt="" height="75" src="<c:url value="/img/selo_fai.jpg"/>">
                    </div>
                    <div class="col-lg-3">
                        <img alt="" width="174" height="75" src="<c:url value="/img/MiniLogo.png"/>" class="img-responsive">
                    </div>
                    <div class="col-lg-3">
                        <img alt="" width="174" height="75" src="<c:url value="/img/LogoFaitec2.png"/>" class="img-responsive">
                    </div>
                </div>
            </div>
        </div>
        <div class="modal fade" id="warning">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header btn-warning">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h3 class="modal-title">SPIAA</h3>
                    </div>
                    <div class="modal-body text-center">
                        <div class="alert alert-warning">
                            <strong > Senhas n&atilde;o conferem!</strong> <br/>
                            <i class="fa fa-2x fa-warning"></i>
                            <p>Por favor, verifique as senhas e tente novamente!</p>
                        </div>

                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->

        <div class="modal fade" id="successCreate">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header btn-success">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h3 class="modal-title">SPIAA</h3>
                    </div>
                    <div class="modal-body text-center">
                        <div class="alert alert-success">
                            <strong > Senha redefinida com Sucesso , aguarde por favor..</strong> <br/>
                            <i class="fa fa-2x fa-spinner fa-pulse"></i>
                            <p>Você será redirecionado para tela de login.....</p>
                        </div>

                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
        <div class="modal fade" id="errorCreate">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header btn-danger">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h3 class="modal-title">SPIAA</h3>
                    </div>
                    <div class="modal-body text-center">
                        <div class="alert alert-danger">
                            <strong > Ouve um erro ao redefinir a senha.</strong> <br/>
                            <i class="fa fa-2x fa-warning"></i>
                            <p>Entre em contato com o Administrador!</p>
                        </div>

                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->

    </body>
</html>

