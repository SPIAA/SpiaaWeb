<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <title>Bootstrap 3, from LayoutIt!</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!--link rel="stylesheet/less" href="less/bootstrap.less" type="text/css" /-->
        <!--link rel="stylesheet/less" href="less/responsive.less" type="text/css" /-->
        <!--script src="js/less-1.3.3.min.js"></script-->
        <!--append ‘#!watch’ to the browser URL, then refresh the page. -->

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <link href="css/mapbox.css" rel="stylesheet">
        <link rel="stylesheet" href="http://cdn.leafletjs.com/leaflet-0.7.3/leaflet.css" />
        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
          <script src="js/html5shiv.js"></script>
        <![endif]-->

        <!-- Fav and touch icons -->
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="img/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="img/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="img/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="img/apple-touch-icon-57-precomposed.png">
        <link rel="shortcut icon" href="img/favicon.png">

        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script src="http://cdn.leafletjs.com/leaflet-0.7.3/leaflet.js"></script>
        <!--<script type="text/javascript" src="js/scripts.js"></script>-->
        <script type="text/javascript" src="js/mapbox.js"></script>


        <style>
            body { margin:0; padding:0; }
            #map { position:absolute; top:0; bottom:0; width:97%; height: 500px; }

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
        <div class="container">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <div class="row clearfix">
                        <div class="col-md-12 column">
                            <h2>Aqui vai o Logotipo e mais alguma coisa</h2>


                        </div>
                    </div>
                    <nav class="navbar navbar-default" role="navigation">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> 
                                <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span><span class="icon-bar"></span>
                                <span class="icon-bar"></span></button> <a class="navbar-brand" href="" onclick="javascript:history.back();">Início</a>
                        </div>

                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <ul class="nav navbar-nav">
                                <li class="">
                                    <a href="#">Mapa da cidade</a>
                                </li>
                                <li>
                                    <a href="#">Denuncie</a>
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
                <div class="col-md-12 column">
                    <div class="row clearfix">

                        <div class="col-md-12 column" style="height: 500px;">
                            <div id='map' class="col-md-12"></div>
                        </div>
                    </div>
                </div>
            </div>



            <div class="row clearfix">
                <div class="col-md-12 column">

                    <h1>Aqui será o rodapé</h1>
                </div>
            </div>
        </div>
    </body>
</html>

<script>
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
                    "armazem": "${bairroestrato.totalArmazem}",
                    "residencia": "${bairroestrato.totalResindencia}",
                    "estrato": "${estratos.nome}", 
                    "imoveis": "${bairroestrato.totalImoveis}",
                    "comercio": "${bairroestrato.totalComercio}",
                    "predios": "${bairroestrato.totalPredios}",
                    "tbaldio": "${bairroestrato.totalTerrenoBaldio}",
                    "habitantes": "${bairroestrato.totalHabitantes}",
                    "stroke": " #fc4353 ",
                    "stroke-width": 5


                }
            },
    </c:forEach>

    </c:forEach>
        ]};
    var map = L.mapbox.map('map', 'examples.map-i86nkdio')
            .setView([-22.2490, -45.7025], 15);


    // control that shows state info on hover
    var info = L.control();

    info.onAdd = function(map) {
        this._div = L.DomUtil.create('div', 'info');
        this.update();
        return this._div;
    };

    info.update = function(props) {
        this._div.innerHTML = '<h4><b>Santa Rita do Sapucaí</b></h4>' + (props ?
                '<b>' + props.name + '</b><br /> Habitantes :' + props.habitantes + '</b><br /> Comercios : ' + props.comercio + '</b><br /> Armazens :'  + props.armazem + '</b><br /> Residências :'  + props.residencia + '</b><br /> Imoveis :' + props.imoveis + '</b><br />' : 'Passe o mouse nos bairros');
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
