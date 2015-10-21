<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>SPIAA - Sistema de Prevenção de infestação do Aedes Aegypti</title>
        <!-- core CSS -->
        <link href="../css/bootstrap.min.css" rel="stylesheet">
        <link href="../css/font-awesome.min.css" rel="stylesheet">
        <link href="../css/animate.min.css" rel="stylesheet">
        <link href="../css/owl.carousel.css" rel="stylesheet">
        <link href="../css/owl.transitions.css" rel="stylesheet">
        <link href="../css/prettyPhoto.css" rel="stylesheet">
        <link href="../css/main.css" rel="stylesheet">
        <link href="../css/responsive.css" rel="stylesheet">
        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->       
        <link rel="shortcut icon" href="../img/icone_spiaa.png">
    </head><!--/head-->

    <body id="home" class="homepage">

        <header id="header">
            <nav id="main-menu" class="navbar navbar-default navbar-fixed-top" role="banner">
                <div class="container">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="<c:url value="/"/>"><img src="../img/logo.png" alt="logo"></a>
                    </div>

                    <div class="collapse navbar-collapse navbar-right">
                        <ul class="nav navbar-nav">
                            <li class="scroll "><a href="<c:url value="/"/>">Início</a></li>
                            <li class="scroll"><a href="<c:url value="/mapa"/>"  target="_blank">Mapa</a></li>
                            <li class="scroll"><a href="<c:url value="/#"/>">Recursos</a></li>
                            <li class="scroll"><a href="<c:url value="/"/>">Equipe</a></li>
                            <li class="scroll"><a href="<c:url value="/"/>">Denúncia</a></li>
                            <li class="scroll active"><a href="<c:url value="/login"/>">Restrito</a></li>                        
                        </ul>
                    </div>
                </div><!--/.container-->
            </nav><!--/nav-->
        </header><!--/header-->
        <section id="features">
            <div class="container">
                <div class="row clearfix">

                 <div class="col-md-3 column"></div>
                <div class="col-md-6 column" style="border: 1px silver solid; border-radius: 15px;">
                    <div class="col-md-12 text-center">
                        <h2 class="text-success">Email enviada com sucesso</h2>
                        <br/><br/>
                        <h4>Foi enviado um link no seu email para redefinir a sua senha!</h4>
                        <br/>
                        <p class="text-success"><i class="fa fa-4x fa-smile-o"></i></p>
                        <br/>
                        <a href="<c:url value="/home"/>" class="btn btn-success">Voltar a Página Inicial!</a>
                        <br/><br/><br/>
                    </div>


                </div>

                <div class="col-md-3 column">

                </div>
            </div>
             </section>
        <section id="cta2">
            <div class="container">
                <div class="text-center">
                    <h2 class="wow fadeInUp" data-wow-duration="300ms" data-wow-delay="0ms"><span style="color:red">VENHA CONOSCO</span> ENFRENTAR ESTA BATALHA</h2>
                     <div class="text-center">
                        <div class="col-md-4" align="center">
                            <a href="http://www.fai-mg.br/portal/index.php/faitec/apresentacao" target="-Blank">
                                <img class="img-responsive wow fadeIn" src="img/cta2/faitec_logo_mini.png" alt="" data-wow-duration="300ms" data-wow-delay="300ms">
                            </a>
                        </div>
                        <!--<div class="col-md-3" align="center">
                        <img class="img-responsive wow fadeIn" src="img/cta2/logoSUS.png" alt="" data-wow-duration="300ms" data-wow-delay="300ms">
                        </div> -->

                        <div class="col-md-4" align="center">
                            <a href="http://www.fai-mg.br/portal/" target="-Blank">
                                <img class="img-responsive wow fadeIn" src="img/cta2/fai_mg.png" alt="" data-wow-duration="300ms" data-wow-delay="300ms">
                            </a>
                        </div>
                        <div class="col-md-4" align="center">
                            <br/>
                            <a href="http://www.compels.net/" target="-Blank">
                                <img class="img-responsive wow fadeIn" src="img/cta2/logo-compels.png" alt="" data-wow-duration="300ms" data-wow-delay="300ms">
                            </a>
                        </div>
                    </div>
                    <img class="img-responsive wow fadeIn" src="../img/cta2/cta2-img.png" alt="" data-wow-duration="300ms" data-wow-delay="300ms">
                </div>
            </div>
        </section>
        <footer id="footer">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        &copy; 2015 SPIAA
                    </div>
                </div>
            </div>
        </footer><!--/#footer-->
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
        <script src="../js/jquery.min.js"></script>
        <script src="../js/bootstrap.min.js"></script>
        <script src="../js/jquery.prettyPhoto.js"></script>
        <script src="../js/jquery.isotope.min.js"></script>
        <script src="../js/jquery.inview.min.js"></script>
        <script src="../js/wow.min.js"></script> 
        <script src="../js/main.js"></script>
        <script type="text/javascript" src="<c:url value="../js/scripts.js"/>"></script>
        <script src="<c:url value="../js/views/recuperarSenha.js"/>"></script>
        <script src="<c:url value="../js/jquery.validationEngine-pt_BR.js"/>" type="text/javascript" charset="utf-8"></script>
        <script src="<c:url value="../js/jquery.validationEngine.js"/>" type="text/javascript" charset="utf-8"></script>
        <script>
                                    jQuery(document).ready(function () {
                                        // binds form submission and fields to the validation engine
                                        jQuery("#formRecuperarSenha").validationEngine('attach', {promptPosition: "bottomLeft", autoPositionUpdate: true});
                                    });
        </script>
    </body>
</html>