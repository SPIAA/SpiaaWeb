<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=utf-8 />
        
        <title>SPIAA - Sistema de Prevenção de infestação do Aedes Aegypti </title>
        <meta name='viewport' content='initial-scale=1,maximum-scale=1,user-scalable=no' />
        <!--<script src='https://api.mapbox.com/mapbox.js/v2.2.2/mapbox.js'></script>-->
        <!--<link href='https://api.mapbox.com/mapbox.js/v2.2.2/mapbox.css' rel='stylesheet' />-->
        <script src="<c:url value="/js/mapbox.js"/>"></script>
        <link href="<c:url value="/css/mapbox.css"/>" rel="stylesheet">
        <link href="<c:url value="/css/font-awesome.min.css"/>" rel="stylesheet">
        <style>
            body { margin:0; padding:0; }
            #map { position:absolute; top:0; bottom:0; width:100%; }
        </style>
    </head>
    <body>
        <div id='map'></div>
        <script>
                    L.mapbox.accessToken = 'pk.eyJ1Ijoic3BpYWEyMDE0IiwiYSI6ImxxMm02ME0ifQ.ea4Ix3YM1KK4oMj7ENLmfA';
                    var map = L.mapbox.map('map', 'mapbox.streets')
                    .setView([ - 22.25512281604783, - 45.7041751], 16);
                    var myLayer = L.mapbox.featureLayer().addTo(map);
//                    // The GeoJSON representing the two point features
//                            function getStyle(feature) {
//                            return {
//                            weight: 2,
//                                    opacity: 0.1,
//                                    color: 'black',
//                                    fillOpacity: 0.7,
//                                    fillColor: '#fffff'
//                            };
//                            }


                    var geojson = {
                    type: 'FeatureCollection',
                            features: [
            <c:forEach items="${bairroList}" var="bairro">
                            {
                            title: "${bairroestrato.bairro.nome}",
                                    type: 'Feature',
                                    geometry: {
                                    type: 'Polygon',
                                            coordinates: [
                                                    [
                ${bairro.coordenadas}

                                                    ],
                                            ]
                                    },
                                    properties: {
                                    name: "${bairro.nome}",
                                    }
                            },
            </c:forEach>


            <c:forEach items="${atividadeList}" var="atividade">
                            {
                            type: 'Feature',
                                    properties: {
                                    title: '${atividade.endereco}' + ',' + '${atividade.numero}',
                                            'marker-color': '#f86767',
                                            'marker-size': 'large',
//                                "icon": {
//                                "iconUrl": "",
//                                "iconSize": [25, 25], // size of the icon
//                                "iconAnchor": [25, 25], // point of the icon which will correspond to marker's location
//                                "popupAnchor": [0, -25], // point from which the popup should open relative to the iconAnchor
//                                "className": "dot"
//                            }

                                    },
                                    geometry: {
                                    type: 'Point',
                                            coordinates: [${atividade.longitude}, ${atividade.latitude}]
                                    }
                            },
            </c:forEach>
                            ]
                    };
//            myLayer.on('layeradd', function (e) {
//                var marker = e.layer,
//                        feature = marker.feature;
//
//                marker.setIcon(L.icon(feature.properties.icon));
//            });
//            
//                    var myLayer = L.mapbox.featureLayer(geojson, {
//                    style: getStyle,
//                            onEachFeature: onEachFeature
//                    }).addTo(map);
//                    // The GeoJSON representing the two point features
//                            function getStyle(feature) {
//                            return {
//                            weight: 2,
//                                    opacity: 0.1,
//                                    color: 'black',
//                                    fillOpacity: 0.7,
//                                    fillColor: '#fffff'
//                            };
//                            }
                    // Pass features and a custom factory function to the map
                    myLayer.on('click', function (e) {
                    });
                            myLayer.setGeoJSON(geojson);
        </script>


    </body>
</html>
