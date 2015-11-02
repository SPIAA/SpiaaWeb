<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../imports.jspf" %>
<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <jsp:include page="../template-admin/header.jsp"/>
        <script src="<c:url value="/js/views/atividade.js"/>"></script>
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
                    <div class="row">
                        <div class="col-lg-12">
                            <h1 class="page-header">
                                Tratamento Anti-Vetorial
                                <small>Atividade</small>
                            </h1>

                            <form role="form" method="POST">

                                <input type="text" name="boletimId" hidden value="${atividade.boletimDiario.id}">

                                <div class="form-group col-md-12">
                                    <div class="form-group col-md-2 ">
                                        <label for="codigo">Data Inicial:</label>
                                        <input type="text" class="form-control"  name="dataInicial" value="<fmt:formatDate pattern="dd/MM/yyyy hh:mm" value="${atividade.dataInicial}" />" id="default_datetimepickerIn" >
                                    </div>

                                    <div class="form-group col-md-2 ">
                                        <label for="codigo">Data Final:</label>
                                        <input type="text" class="form-control"  name="dataFinal" value="<fmt:formatDate pattern="dd/MM/yyyy hh:mm" value="${atividade.dataFinal}" />" id="default_datetimepickerFin" >
                                    </div>

                                </div>
                                <div class="col-md-1">
                                    <label for="numero_quateirao">Nª Quart.</label>
                                    <select  class="form-control validate[required]" name="quarteirao.id" id="">
                                        <c:forEach var="quarteirao" items="${quarteiraoList}">
                                            <option value="${quarteirao.id}" <c:if test="${atividade.quarteirao.id eq quarteirao.id}">selected</c:if>> ${quarteirao.descricao}  </option>
                                        </c:forEach>
                                    </select>
                                </div>

                                <div class="form-group col-md-3">
                                    <label for="endereco">Endereço</label>
                                    <input type="text" class="form-control" name="endereco" id="endereco" value="${atividade.endereco}">
                                </div>
                                <div class="form-group col-md-1">
                                    <label for="numero">Nº:</label>
                                    <input type="text" class="form-control" name="numero" id="numero" value="${atividade.numero}" >
                                </div>


                                <div class="form-group col-md-5">
                                    <label for="endereco" class="form-group">Tipo de unidade :</label>
                                    <br/>
                                    <c:forEach var="imovel" items="${tipoImoveisList}">
                                        <label class="radio-inline col-md-2">
                                            <input type="radio" name="tipoImovel" id="tipoimovel" value="${imovel.id}"
                                                   <c:if test="${imovel.id eq atividade.tipoImoveis.id}"> checked </c:if>
                                                   > ${imovel.sigla}

                                        </label>
                                    </c:forEach>
                                </div>

                                <div class="form-group col-md-1">
                                    <label for="total_inspecionado">T.Insp.:</label>
                                    <input type="text" class="form-control" name="inspecionado" value="${atividade.inspecionado}">
                                </div>

                                <div class="form-group col-lg-4 ">
                                    <label for="endereco" class="form-group">Consumo de Inseticida :</label>
                                    <br/>
                                    <c:if test="${empty atividade.atividadeInseticidasList}">
                                        <c:forEach var="inseticida" items="${inseticidaList}">
                                            <div class="form-group col-md-6">
                                                <label for="endereco">${inseticida.nome}</label>
                                                <input type="text" class="form-control" name="quantidadeInseticida" value="">
                                                <input type="hidden" name="inseticida" value="${inseticida.id}">
                                            </div>
                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${not empty atividade.atividadeInseticidasList}">
                                        <c:forEach var="inseticida" items="${atividade.atividadeInseticidasList}">
                                            <div class="form-group col-md-6">
                                                <label for="endereco">${inseticida.inseticida.nome}</label>
                                                <input type="text" class="form-control" name="quantidadeInseticida" value="${inseticida.quantidadeInseticida}">
                                                <input type="hidden" name="inseticida" value="${inseticida.inseticida.id}">
                                            </div>
                                        </c:forEach>


                                    </c:if>
                                </div>

                                <div class="form-group col-lg-8 ">
                                    <br/><br/>
                                    <label for="endereco" class="form-group">Observações :</label>
                                    <br/>
                                    <label class="radio-inline col-md-2">
                                        <input type="radio" name="observacao" id="observacao" value="RECEBIDO" <c:if test="${atividade.observacao eq 'RECEBIDO'}">checked</c:if>   > RECEBIDO
                                        </label>
                                        <label class="radio-inline col-md-2">
                                            <input type="radio" name="observacao" id="observacao" value="FECHADO" <c:if test="${atividade.observacao eq 'FECHADO'}">checked</c:if>  > FECHADO
                                        </label>
                                        <label class="radio-inline col-md-2">
                                            <input type="radio" name="observacao" id="observacao" value="RESGATADO" <c:if test="${atividade.observacao eq 'RESGATADO'}">checked</c:if> > RESGATADO
                                        </label>

                                    </div>
                                    <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/>

                                    <div class="form-group col-lg-12 ">
                                        <label for="endereco" class="form-group">Tipo de criadouro :</label>
                                        <br/>
                                    <c:if test="${empty atividade.atividadeCriadouroList}">
                                        <c:forEach var="criadouro" items="${criadouroList}">

                                            <div class="form-group col-md-1">
                                                <label for="criadouro">${criadouro.grupo} :<i class="fa fa-exclamation-circle text-info" data-toggle="tooltip" data-placement="top" title="${criadouro.recipiente}"></i></label>
                                                <input type="text" class="form-control" id="quantidadeCriadouro"  name="quantidadeCriadouro" >
                                                <input type="hidden" name="criadouro" id="criadouro" value="${criadouro.id}">
                                            </div>

                                        </c:forEach>
                                    </c:if>
                                    <c:if test="${not empty atividade.atividadeCriadouroList}">
                                        <c:forEach var="criadouro" items="${atividade.atividadeCriadouroList}">
                                            <div class="form-group col-md-1">
                                                <label for="criadouro">${criadouro.criadouro.grupo} :<i class="fa fa-exclamation-circle text-info" data-toggle="tooltip" data-placement="top" title="${criadouro.criadouro.recipiente}"></i></label>
                                                <input type="text" class="form-control" id="quantidadeCriadouro"  name="quantidadeCriadouro" value="${criadouro.quantidadeCriadouro}">
                                                <input type="hidden" name="criadouro" id="criadouro" value="${criadouro.criadouro.id}">
                                            </div>

                                        </c:forEach>

                                    </c:if>
                                </div>
                                <div class="form-group col-md-2">
                                    <label for="total_inspecionado">Latitude</label>
                                    <input type="text" class="form-control" name="latitude" id="latitude" value="${atividade.latitude}">
                                </div>
                                <div class="form-group col-md-2">
                                    <label for="total_inspecionado">Longitude</label>
                                    <input type="text" class="form-control" name="longitude" id="longitude" value="${atividade.longitude}">
                                </div>
                                <br/><br/><br/><br/>
                                <div class="col-lg-12" align="center">

                                    <button class="btn btn-success" type="submit" > Salvar Atividade</button>  
                                    <a class="btn btn-primary" href="#" onclick="geocodeAddress()"><i class="fa fa-map-marker fa-fw"></i> Coordenadas</a>

                                </div>
                                <br/>
                            </form>
                            <br/>
                            <!-- Modal -->
                        </div>
                    </div>
                    <!-- /.row -->
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- /#page-wrapper -->
        </div>
        <!-- /#wrapper -->
        <link href="<c:url value="/css/jquery.datetimepicker.css"/>" rel="stylesheet"/>
        <link href="<c:url value="/css/jquery-ui.min.css"/>" rel="stylesheet">
        <script src="<c:url value="/js/jquery-ui.min.js"/>"></script>
        <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyABlmqhgaqNRF4iaanJFZw_gzKAsc1VNU0&signed_in=true&callback=initMap" async defer></script>
        <script type="text/javascript" src="<c:url value="/js/jquery.datetimepicker.js"/>"></script>
        <script>
                                        $(function () {
                                            $('[data-toggle="tooltip"]').tooltip()
                                        });

                                        function geocodeAddress(resultsMap) {
                                            var geocoder = new google.maps.Geocoder();
                                            var address = "Santa Rita do Sapucai," + document.getElementById('endereco').value + "," + document.getElementById('numero').value;
                                            geocoder.geocode({'address': address}, function (results, status) {
                                                if (status === google.maps.GeocoderStatus.OK) {
                                                    document.getElementById('latitude').value = results[0].geometry.location.lat();
                                                    document.getElementById('longitude').value = results[0].geometry.location.lng();
                                                } else {
                                                    alert('Geocode was not successful for the following reason: ' + status);
                                                }
                                            });
                                        }
        </script>
        <script>
            $(function () {
                $('#default_datetimepickerIn').datetimepicker({
                    lang: 'pt',
                    format: 'd/m/Y H:i',
                    step: 30
                });
                $('#default_datetimepickerFin').datetimepicker({
                    lang: 'pt',
                    format: 'd/m/Y H:i',
                    step: 30
                });

            });

        </script>
    </body>
</html>
