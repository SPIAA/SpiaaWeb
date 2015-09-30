<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>SPIAA - Sistema de Prevenção de infestação do Aedes Aegypti </title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!--link rel="stylesheet/less" href="less/bootstrap.less" type="text/css" /-->
        <!--link rel="stylesheet/less" href="less/responsive.less" type="text/css" /-->
        <!--script src="js/less-1.3.3.min.js"></script-->
        <!--append ‘#!watch’ to the browser URL, then refresh the page. -->

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
          <script src="js/html5shiv.js"></script>
        <![endif]-->

        <!-- Fav and touch icons -->
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="img/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="img/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="img/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="img/apple-touch-icon-57-precomposed.png">
        <link rel="shortcut icon" href="img/icone_spiaa.png">

        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/scripts.js"></script>
        <script type="text/javascript" src="js/testePOST.js"></script>
    </head>

    <body>
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <div class="row clearfix">
                        <div class="col-md-12 column">
                            <div class="col-md-2 column">
                                <img alt="" src="img/MiniLogo.png" class="img-responsive"> 
                            </div>
                            <div class="col-md-10 column">
                                <h3><b> Todos contra a Dengue!</b></h3>
                            </div>
                        </div>
                    </div>
                    <nav class="navbar navbar-default" role="navigation">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="#">Início</a>
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
                                    <a href="login">Acesso restrito</a>
                                </li>

                            </ul>
                        </div>

                    </nav>
                </div>
            </div>
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <div class="carousel slide" id="carousel-102796">
                        <ol class="carousel-indicators">
                            <li data-slide-to="0" data-target="#carousel-102796">
                            </li>
                            <li data-slide-to="1" data-target="#carousel-102796">
                            </li>
                            <li data-slide-to="2" data-target="#carousel-102796" class="active">
                            </li>
                        </ol>
                        <div class="carousel-inner">
                            <div class="item">
                                <img alt="" src="img/spiaa_mapa_carrossel.png">
                                <div class="carousel-caption">
                                    <h4>

                                    </h4>
                                    <p>

                                    </p>
                                </div>
                            </div>
                            <div class="item">
                                <img alt="" src="img/LogoFaitec2.png">
                                <div class="carousel-caption">
                                    <h4>

                                    </h4>
                                    <p>

                                    </p>
                                </div>
                            </div>
                            <div class="item active">
                                <img alt="" src="img/spiaa.png" >
                                <div class="carousel-caption">
                                    <h3 class="col-lg-offset-4" style="color: #000;">
                                        Sistema de Prevenção de infestação do Aedes Aegypti                                    </h3>
                                    <p>

                                    </p>
                                </div>
                            </div>
                        </div> <a class="left carousel-control" href="#carousel-102796" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a> <a class="right carousel-control" href="#carousel-102796" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
                    </div>
                    <h2>
                        SPIAA
                    </h2>
                    <p>
                        O SPIAA é um software desenvolvido para Secretaria Municipal de Saúde de Santa Rita do Sapucaí-MG com objetivo de 
                        auxiliar na tomada de decisão e monitoramento de infestação da Dengue. O Software permite visualizar o mapa da 
                        cidade divido por bairros, mostrando informações importantes de cada bairro necessário para o controle do mosquito
                        aedes aegypti.                    </p>
                    <br/><br/><br/><br/>
                </div>
            </div>
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <div class="col-lg-3">
                        <img alt=""  height="75" src="img/fai_mg.jpg">
                    </div>
                    <div class="col-lg-3">
                        <img alt="" height="75" src="img/selo_fai.jpg">
                    </div>
                    <div class="col-lg-3">
                        <img alt="" width="174" height="75" src="img/MiniLogo.png" class="img-responsive">
                    </div>
                    <div class="col-lg-3">
                        <img alt="" width="174" height="75" src="img/LogoFaitec2.png" class="img-responsive">
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>

