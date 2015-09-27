<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html class="full" lang="en">
    <!-- Make sure the <html> tag is set to the .full CSS class. Change the background image in the full.css file. -->

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>SPIAA - Sistema de Prevenção de infestação do Aedes Aegypti </title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <link href="css/mapbox.css" rel="stylesheet">
        <link rel="stylesheet" href="http://cdn.leafletjs.com/leaflet-0.7.3/leaflet.css" />

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
        <link rel="shortcut icon" href="img/icone_spiaa.png">

        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script src="http://cdn.leafletjs.com/leaflet-0.7.3/leaflet.js"></script>
        <!--<script type="text/javascript" src="js/scripts.js"></script>-->
        <script type="text/javascript" src="js/mapbox.js"></script>

        <style>
            body { margin:0; padding:0; }
            #map { position:absolute; top:0; bottom:0; width:97%; height: 900px; margin-left: 6px;}

            .info {
                padding: 6px 8px;
                font: 14px/16px Arial, Helvetica, sans-serif;
                background: white;
                background: rgba(255,255,255,0.8);
                box-shadow: 0 0 15px rgba(0,0,0,0.2);
                border-radius: 5px;
            }
            .info h4 {
                margin: 0 0 5px;
                color: #777;
            }
        </style>
    </head>

    <body>

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-bottom" role="navigation">
            <div class="container">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="<c:url value="/home"/>">Início</a>
                </div>
                <!-- Collect the nav links, forms, and other content for toggling -->
                <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li>
                            <a href="<c:url value="/mapa"/>">Mapa</a>
                        </li>
                        <li class="text-right">
                            <a href="<c:url value="/login"/>">Restrito</a>
                        </li>
                    </ul>
                </div>
                <!-- /.navbar-collapse -->
            </div>
            <!-- /.container -->
        </nav>

        <!-- Page Content -->
        <div class="">
            <div class="row">
                <div class=" col-lg-12">
                    <div >
                        <div id='map'></div>
                    </div>
                </div>
            </div>
            <!-- /.row -->
        </div>


        <script>
//                    L.mapbox.accessToken = 'pk.eyJ1Ijoic3BpYWEyMDE0IiwiYSI6ImxxMm02ME0ifQ.ea4Ix3YM1KK4oMj7ENLmfA';
                    L.mapbox.accessToken = 'pk.eyJ1Ijoic3BpYWEyMDE0IiwiYSI6ImxxMm02ME0ifQ.ea4Ix3YM1KK4oMj7ENLmfA';
                    var geojson = {"type": "FeatureCollection", "features": [
            <c:forEach items="${estratoList}" var="estratos">
                <c:forEach items="${estratos.bairroEstratoList}" var="bairroestrato">
                    {
                    "title": "${bairroestrato.bairro.nome}",
                            "type": "Feature",
                            "geometry": {
                            "type": "Polygon",
                                    "coordinates": [
                                            [
                    ${bairroestrato.bairro.coordenadas}

                                            ],
                                    ]
                            },
                            "properties": {
                            "name": "${bairroestrato.bairro.nome}",
                                    "armazem": "${bairroestrato.armazem}",
                                    "residencia": "${bairroestrato.resindencia}",
                                    "estrato": "${estratos.nome}",
                                    "imoveis": "${bairroestrato.imovel}",
                                    "comercio": "${bairroestrato.comercio}",
                                    "predios": "${bairroestrato.predio}",
                                    "tbaldio": "${bairroestrato.terrenoBaldio}",
                                    "habitantes": "${bairroestrato.habitante}",
                                    "stroke": " #fc4353 ",
                                    "stroke-width": 5


                            }
                    },
                </c:forEach>

            </c:forEach>
                    ]};
                    var map = L.mapbox.map('map', 'mapbox.streets-satellite')
                    .setView([ - 22.2490, - 45.7025], 15);
                    // control that shows state info on hover
                    var info = L.control();
                    info.onAdd = function(map) {
                    this._div = L.DomUtil.create('div', 'info');
                            this.update();
                            return this._div;
                    };
                    info.update = function(props) {
                    this._div.innerHTML = '<h4><b>Santa Rita do Sapucaí</b></h4>' + (props ?
                            '<b>' + props.name + '</b><br /> Habitantes :' + props.habitantes + '</b><br /> Comercios : ' + props.comercio + '</b><br /> Armazens :' + props.armazem + '</b><br /> Residências :' + props.residencia + '</b><br /> Imoveis :' + props.imoveis + '</b><br /> Quantidade de focos : 12</b><br /> ': 'Passe o mouse nos bairros');
                    };
                    info.addTo(map);
                    function getColor(d) {
                    return d === "Estrato 1" ? '#BD0026' :
                            d === "Estrato 2"  ? '#006400' :
                            d === "Estrato 3"  ? '#9400D3' :

                            '#FFFFF';
                    }

            function style(feature) {
            return {

            weight: 2,
                    opacity: 1,
                    color: '#006400',
                    dashArray: '3',
                    fillOpacity: 0.7,
                    fillColor: getColor(feature.properties.estrato)
            };
            }

            function highlightFeature(e) {
            var layer = e.target;
                    layer.setStyle({
                    weight: 3,
                            color: '#000000',
                            dashArray: '',
                            fillOpacity: 0.7
                    });
                    if (!L.Browser.ie && !L.Browser.opera) {
            layer.bringToFront();
            }

            info.update(layer.feature.properties);
            }


            var geojson0;
                    function resetHighlight(e) {
                    geojson0.resetStyle(e.target);
                            info.update();
                    }

            function zoomToFeature(e) {
            map.fitBounds(e.target.getBounds());
            }

            function onEachFeature(feature, layer) {
            layer.on({
            mouseover: highlightFeature,
                    mouseout: resetHighlight,
                    click: zoomToFeature
            });
            }


            geojson0 = L.geoJson(geojson, {
            style: style,
                    onEachFeature: onEachFeature
            }).addTo(map);


        </script>
