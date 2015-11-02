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
         <link rel="shortcut icon" href="<c:url value="/img/icone_spiaa.png"/>">
        <link href="<c:url value="/css/bootstrap.min-3.css"/>" rel="stylesheet">
        <link href="css/style.css" rel="stylesheet">
        <link href="<c:url value="/css/mapbox.css"/>" rel="stylesheet">
        <script type="text/javascript" src="js/jquery.min.js"></script>
        <script src="<c:url value="/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/js/mapbox.js"/>"></script>
        <style>
            body { margin:0; padding:0; }
            #map { position:absolute; top:0; bottom:0; width:100%;}
        </style>
    </head>
    <body>
        <div id='map'></div>
        <div class="row clearfix" id="menu" style="margin-left:0; margin-right: 0">
            <div class="btn-group-vertical col-lg-12 " align="rigth" role="group" aria-label="..." >
                <div class="col-lg-10"></div>
                <div class="btn-group-vertical col-lg-2">
                    <a href="<c:url value="/home"/>" class="btn btn-default">Inicio</a>
                    <a href="<c:url value="/login"/>" class="btn btn-default">Restrito</a>
                </div>
            </div>
        </div>
        <div class="panel panel-default"id='legend1'>
<!--            <div class="panel panel-primary">
                <div class="panel-heading">Estratos</div>
                <div class="panel-body">
                    <c:forEach items="${estratos}" var="estratos">
                        <span style="background:${estratos.cor}"><b> &nbsp;&nbsp;&nbsp;&nbsp; </b></span><label> &nbsp;&nbsp;${estratos.nome}</label><br/>
                    </c:forEach>
                </div>
            </div>-->
            <div class="panel panel-primary" style="margin-bottom: -18px;">
                <div class="panel-heading">Tipos de Criadouros</div>
                <div class="panel-body">
                    <c:forEach items="${criadouroList}" var="criadouro">
                        <span><b>${criadouro.grupo} : </b> ${criadouro.recipiente}</span><br/>
                    </c:forEach>
                </div>
            </div>
        </div>

        <style>
            .map-legend .swatch {
                width:20px;
                height:20px;
                float:left;
                margin-right:10px;
            }
            .leaflet-popup-close-button {
                display: none;
            }
            .leaflet-popup-content-wrapper {
                pointer-events: none;
            }
        </style>
        <script>
                    var menu = document.getElementById('menu');
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
                                    "residencia": "${bairroestrato.residencia}",
                                    "estrato": "${estratos.nome}",
                                    "imoveis": "${bairroestrato.imovel}",
                                    "comercio": "${bairroestrato.comercio}",
                                    "predios": "${bairroestrato.predio}",
                                    "tbaldio": "${bairroestrato.terrenoBaldio}",
                                    "habitantes": "${bairroestrato.habitante}",
                    <c:forEach items="${bairroestrato.bairro.totalCriadouro}" var="totalCriadouro">
                            "${totalCriadouro.criadouro.grupo}": "${totalCriadouro.quantidadeCriadouro}",
                    </c:forEach>
                            "stroke": " #fc4353 ",
                                    "stroke-width": 5


                            }
                    },
                </c:forEach>

            </c:forEach>

                    ]};
                    var map = L.mapbox.map('map', 'mapbox.streets-satellite')
                    .setView([ - 22.2490, - 45.7025], 15);
                    var popup = new L.Popup({autoPan: false});
                    // statesData comes from the 'us-states.js' script included above
                    var statesLayer = L.geoJson(geojson, {
                    style: getStyle,
                            onEachFeature: onEachFeature
                    }).addTo(map);
                    function getStyle(feature) {
                    return {
                    weight: 2,
                            opacity: 0.1,
                            color: 'black',
                            fillOpacity: 0.7,
                            fillColor: getColor(feature.properties.estrato)
                    };
                    }

            // get color depending on population density value
            function getColor(d) {
            return  <c:forEach items="${corEstrato}" var="cor">d === '${cor.nome}'  ? '${cor.cor}'  : </c:forEach>'#FFFFF';
            }

            function onEachFeature(feature, layer) {
            layer.on({
            mousemove: mousemove,
                    mouseout: mouseout,
                    click: zoomToFeature
            });
            }

            var closeTooltip;
                    function mousemove(e) {
                    var layer = e.target;
                            popup.setLatLng(e.latlng);
                            popup.setContent('<div class="panel panel-primary" style="margin-bottom: -18px;margin-left: -18px;margin-right: -18px;margin-top: -18px;" > <div class="panel-heading">' + layer.feature.properties.name + '</div><div class="panel-body"> ' +
                                    ' <b>Habitantes :</b>' + layer.feature.properties.habitantes +
                                    ' <br/><b>Residencia :</b>' + layer.feature.properties.residencia +
                                    ' <br/><b>Imóveis :</b>' + layer.feature.properties.imoveis +
                                    ' <br/><b>Comércio :</b>' + layer.feature.properties.comercio +
                                    ' <br/><b>Prédios :</b>' + layer.feature.properties.predios +
                                    ' <br/><b>Armazem :</b>' + layer.feature.properties.armazem +
                                    ' <br/><b>Terrenos Baldio :</b>' + layer.feature.properties.tbaldio +
                                    '<br/><div class="panel panel-primary" style="margin-bottom: -8px;margin-left: -8px;margin-right: -8px;"> <div class="panel-heading">Criadouros Encontrados :</div><div class="panel-body"> ' +
            <c:forEach items="${totalCriadouro}" var="total">
                            '<div class="col-sm-6"><b> ${total.grupo} :</b> ' + layer.feature.properties.${total.grupo} +'</div>'+
            </c:forEach>
                            ' </div></div>   </div>');
                            if (!popup._map)
                            popup.openOn(map);
                            window.clearTimeout(closeTooltip);
                            // highlight feature
                            layer.setStyle({
                            weight: 3,
                                    opacity: 0.3,
                                    fillOpacity: 0.9
                            });
                            if (!L.Browser.ie && !L.Browser.opera) {
                    layer.bringToFront();
                    }
                    }

            function mouseout(e) {
            statesLayer.resetStyle(e.target);
                    closeTooltip = window.setTimeout(function () {
                    map.closePopup();
                    }, 100);
            }

            function zoomToFeature(e) {
            map.fitBounds(e.target.getBounds());
            }

            map.legendControl.addLegend(document.getElementById('legend1').innerHTML);

        </script>