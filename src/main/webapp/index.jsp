<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>SPIAA - Sistema de Prevenção de infestação do Aedes Aegypti</title>
        <!-- core CSS -->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/animate.min.css" rel="stylesheet">
        <link href="css/owl.carousel.css" rel="stylesheet">
        <link href="css/owl.transitions.css" rel="stylesheet">
        <link href="css/prettyPhoto.css" rel="stylesheet">
        <link href="css/main.css" rel="stylesheet">
        <link href="css/responsive.css" rel="stylesheet">
        <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
        <![endif]-->       
        <link rel="shortcut icon" href="img/icone_spiaa.png">

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
                        <a class="navbar-brand" href="<c:url value="/"/>"><img src="img/logo.png" alt="logo"></a>
                    </div>

                    <div class="collapse navbar-collapse navbar-right">
                        <ul class="nav navbar-nav">
                            <li class="scroll active"><a href="#" >Início</a></li>
                            <li class="scroll"><a href="<c:url value="/mapa"/>" target="_blank">Mapa</a></li>
                            <li class="scroll"><a href="#features">Recursos</a></li>
                            <li class="scroll"><a href="#meet-team">Equipe</a></li>
                            <li class="scroll"><a href="#get-in-touch">Denúncia</a></li>
                            <li class="scroll"><a href="<c:url value="/login"/>">Restrito</a></li>                        
                        </ul>
                    </div>
                </div><!--/.container-->
            </nav><!--/nav-->
        </header><!--/header-->

        <section id="main-slider">
            <div class="owl-carousel">
                <div class="item" style="background-image: url(img/slider/bg1.jpg);">
                    <div class="slider-inner">
                        <div class="container">
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="carousel-content">
                                        <h2><span style="color:black">Mapeamento, controle e agilidade</span></h2>
                                        <a class="btn btn-danger btn-lg" target="_blank" href="<c:url value="/mapa"/>">Mapa da cidade</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div><!--/.item-->
                <div class="item" style="background-image: url(img/slider/bg2.jpg);">
                    <div class="slider-inner">
                        <div class="container">
                            <div class="row">
                                <div class="col-sm-6">
                                    <div class="carousel-content">
                                        <h2>Santa Rita do Sapucaí <span style="color:white">Contra a Dengue</span></h2>
                                        <a class="btn btn-danger btn-lg" target="_blank" href="<c:url value="/mapa"/>">Mapa da Cidade</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div><!--/.item-->
            </div><!--/.owl-carousel-->
        </section><!--/#main-slider-->

        <section id="cta" class="wow fadeIn">
            <div class="container">
                <div class="row">
                    <div class="col-sm-9">
                        <h2>SPIAA</h2>
                        <p>
                            Para auxiliar a Secretaria Municipal de Saúde de Santa Rita do Sapucaí - MG a tomar decisões e monitorar a infestação da Dengue, 
                            foi desenvolvido o Sistema de Prevenção de Infestação do Aedes Aegypti (SPIAA). Este software permite visualizar e identificar informações 
                            importantes para o controle de focos em todos os bairros, através do mapa municipal.
                        </p>
                    </div>
                    <!--<div class="col-sm-3 text-right">
                        <a class="btn btn-primary btn-lg" href="#">Download Now!</a>
                    </div>-->
                </div>
            </div>
        </section><!--/#cta-->

        <section id="features">
            <div class="container">
                <div class="section-header">
                    <h2 class="section-title text-center wow fadeInDown">Recursos</h2>
                    <p class="text-center wow fadeInDown"></p>
                </div>
                <div class="row">
                    <div class="col-sm-6 wow fadeInLeft">
                        <img class="img-responsive" src="img/main-feature.jpg" alt="">
                    </div>
                    <div class="col-sm-6">
                        <div class="media service-box wow fadeInRight">
                            <div class="pull-left">
                                <i class="fa fa-line-chart"></i>
                            </div>
                            <div class="media-body">
                                <h4 class="media-heading">Gerenciamento de atividades</h4>
                                <p> As atividades realizadas pelos Agentes de Saúde podem ser gerenciadas através do navegador.</p>

                            </div>
                        </div>

                        <div class="media service-box wow fadeInRight">
                            <div class="pull-left">
                                <i class="fa fa-map-marker"></i>
                            </div>
                            <div class="media-body">
                                <h4 class="media-heading">Mapeamento do foco do mosquito transmissor</h4>
                                <p>As regiões mais infectadas podem ser identificadas através de um mapa dinâmico e customizável.</p>
                            </div>
                        </div>

                        <div class="media service-box wow fadeInRight">
                            <div class="pull-left">
                                <i class="fa  fa-refresh"></i>
                            </div>
                            <div class="media-body">
                                <h4 class="media-heading">Otimização de processos</h4>
                                <p>Com a versão do software para mobile, os agentes de Saúde podem realizar suas atividades, 
                                    buscas em campo e envio dos dados coletados, com mais facilidade e agilidade.</p>
                            </div>
                        </div>

                        <div class="media service-box wow fadeInRight">
                            <div class="pull-left">
                                <i class="fa fa-users"></i>
                            </div>
                            <div class="media-body">
                                <h4 class="media-heading">Interatividade com a população</h4>
                                <p>
                                    A população, além de visualizar o mapeamento do foco através do mapa, pode denunciar outros possíveis focos.
                                </p>
                            </div>
                        </div>
                    </div>
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
                    <img class="img-responsive wow fadeIn" src="img/cta2/cta2-img.png" alt="" data-wow-duration="300ms" data-wow-delay="300ms">
                </div>
            </div>
        </section>

        <section id="meet-team">
            <div class="container">
                <div class="section-header">
                    <h2 class="section-title text-center wow fadeInDown">Conheça a equipe</h2>
                    <p class="text-center wow fadeInDown">Equipe responsável pela elaboração e desenvolvimento deste projeto.</p>
                </div>

                <div class="row">
                    <div class="col-sm-6 col-md-3">
                        <div class="team-member wow fadeInUp" data-wow-duration="400ms" data-wow-delay="0ms">
                            <div class="team-img">
                                <img class="img-responsive" src="img/team/01.jpg" alt="">
                            </div>
                            <div class="team-info">
                                <h3>Elessandra Estevão</h3>
                                <span>Manager / Mobile Dev</span>
                            </div>

                            <ul class="social-icons">
                                <li><a href="https://www.facebook.com/elessandra.estevao" target="_blank"><i class="fa fa-facebook"></i></a></li>
                                <li><a href="https://twitter.com/EleEstevao" target="_blank"><i class="fa fa-twitter"></i></a></li>
                                <li><a href="https://plus.google.com/+ElessandraEstevão" target="_blank"><i class="fa fa-google-plus"></i></a></li>
                                <li><a href="http://br.linkedin.com/in/elessandraestevao" target="_blank"><i class="fa fa-linkedin"></i></a></li>
                                <li><a href="https://github.com/elessandraestevao" target="_blank"><i class="fa fa-github"></i></a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-3">
                        <div class="team-member wow fadeInUp" data-wow-duration="400ms" data-wow-delay="100ms">
                            <div class="team-img">
                                <img class="img-responsive" src="img/team/02.jpg" alt="">
                            </div>
                            <div class="team-info">
                                <h3>Dênis Leonardo</h3>
                                <span>Designer / Nusiness Analyst</span>
                            </div>

                            <ul class="social-icons">
                                <li><a href="https://www.facebook.com/dlcgomes" target="_blank"><i class="fa fa-facebook"></i></a></li>
                                <li><a href="#" target="_blank"><i class="fa fa-twitter"></i></a></li>
                                <li><a href="https://plus.google.com/u/0/104283172531695275708/about"target="_blank"><i class="fa fa-google-plus"></i></a></li>
                                <li><a href="https://br.linkedin.com/pub/leonardo-gomes/98/108/255"target="_blank"><i class="fa fa-linkedin"></i></a></li>
                                <li><a href="https://github.com/LeonardoGomes182" target="_blank"><i class="fa fa-github"></i></a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-3">
                        <div class="team-member wow fadeInUp" data-wow-duration="400ms" data-wow-delay="200ms">
                            <div class="team-img">
                                <img class="img-responsive" src="img/team/03.jpg" alt="">
                            </div>
                            <div class="team-info">
                                <h3>Felipe de Souza</h3>
                                <span>Front-end / Back-end Dev</span>
                            </div>

                            <ul class="social-icons">
                                <li><a href="https://www.facebook.com/felipe.pereira.1426" target="_blank"><i class="fa fa-facebook"></i></a></li>
                                <li><a href="https://twitter.com/felipepdsouza" target="_blank"><i class="fa fa-twitter"></i></a></li>
                                <li><a href="https://plus.google.com/u/0/+FelipePereiradeSouzaSi/posts" target="_blank"><i class="fa fa-google-plus"></i></a></li>
                                <li><a href="https://www.linkedin.com/pub/felipe-pereira-de-souza/92/840/86" target="_blank"><i class="fa fa-linkedin"></i></a></li>
                                <li><a href="https://github.com/felipepdsouzasi" target="_blank"><i class="fa fa-github"></i></a></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-3">
                        <div class="team-member wow fadeInUp" data-wow-duration="400ms" data-wow-delay="300ms">
                            <div class="team-img">
                                <img class="img-responsive" src="img/team/04.jpg" alt="">
                            </div>
                            <div class="team-info">
                                <h3>William Daniel</h3>
                                <span>Front-end / Back-end Dev</span>
                            </div>

                            <ul class="social-icons">
                                <li><a href="https://www.facebook.com/william.daniel.oliveira" target="_blank"><i class="fa fa-facebook"></i></a></li>
                                <li><a href="#" target="_blank"><i class="fa fa-twitter"></i></a></li>
                                <li><a href="#" target="_blank"><i class="fa fa-google-plus"></i></a></li>
                                <li><a href="https://br.linkedin.com/pub/william-daniel-de-oliveira/4a/421/423" target="_blank"><i class="fa fa-linkedin"></i></a></li>
                                <li><a href="https://github.com/WilliamDaniel" target="_blank"><i class="fa fa-github"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="divider"></div>

            </div>
        </section><!--/#meet-team-->

        <section id="get-in-touch">
            <div class="container">
                <div class="section-header">
                    <h2 class="section-title text-center wow fadeInDown">Ajude-nos</h2>
                    <p class="text-center wow fadeInDown">
                        Em caso de irregularidade, entre em contato conosco através do formulário de denúncia abaixo. 
                    </p>
                </div>
            </div>
        </section><!--/#get-in-touch-->

        <section id="contact">
            <div id="google-map" style="height:650px" data-latitude="-22.25512281604783" data-longitude="-45.7041751"></div>
            <div class="container-wrapper">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-4 col-sm-offset-8">
                            <div class="contact-form">
                                <h3>Denúncia</h3>
                                <form id="main-contact-form" name="contact-form" method="post" action="#">
                                    <div class="form-group">
                                        <label for="exampleInputPassword1">Bairro:</label>
                                        <select  class="form-control validate[required]" name="bairro" id="options">
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="Inputendereco">Endereço:</label><input type="text" class="form-control validate[required]" name="endereco" id="endereco" value=""/>
                                    </div>
                                    <div class="form-group">
                                        <label for="Inputnumero">Número:</label><input type="text" class="form-control validate[required]" name="numero" id="numero" value=""/>
                                    </div>
                                    <div class="form-group">
                                        <label for="Inputtipoirregularidade">Irregularidades:</label><textarea  class="form-control validate[required]" name="irregularidade" id="irregularidade" ></textarea>
                                    </div>

                                    <div class="form-group text-center">
                                        <input class="btn btn-success " onclick="getFormData()" value="Enviar" />  
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section><!--/#bottom-->

        <footer id="footer">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        &copy; 2015 SPIAA.
                    </div>

                </div>
            </div>
        </footer><!--/#footer-->

        <script src="js/jquery.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="http://maps.google.com/maps/api/js?sensor=true"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/mousescroll.js"></script>
        <script src="js/smoothscroll.js"></script>
        <script src="js/jquery.prettyPhoto.js"></script>
        <script src="js/jquery.isotope.min.js"></script>
        <script src="js/jquery.inview.min.js"></script>
        <script src="js/wow.min.js"></script>
        <script src="js/main.js"></script>
        <script src="<c:url value="/js/views/denunciaForm.js"/>"></script>

        <div class="modal fade" id="successCreate">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header btn-success">
                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                        <h3 class="modal-title">SPIAA</h3>
                    </div>
                    <div class="modal-body text-center">
                        <div class="alert alert-success">
                            <strong > Denúncia enviada com sucesso..</strong> <br/>
                            <i class="fa fa-2x  fa-smile-o"></i>
                            <p>Obrigado por colaborar</p>
                        </div>

                    </div>
                </div><!-- /.modal-content -->
            </div><!-- /.modal-dialog -->
        </div><!-- /.modal -->
    </body>
</html>