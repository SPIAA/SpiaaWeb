<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../imports.jspf" %>

<ul class="nav navbar-nav side-nav ">
    <li>
        <a href="<c:url value="/tratamento"/>" style="color: #fff"><i class="fa fa-table"></i> Tratamento<br/> &nbsp;&nbsp;&nbsp;&nbsp; Anti-Vetorial</a>
    </li>

    <li>
        <a href="<c:url value="/denuncia"/>" style="color: #fff"><i class="fa fa-1x fa-exclamation-circle"></i> Denúncia</a>
    </li>

    <li>
        <a href="<c:url value="/mapa/admin"/>" style="color: #fff"><i class="fa fa-globe"></i> Mapa</a>
    </li>
    <li>
        <a href="javascript:;" data-toggle="collapse" style="color: #fff" data-target="#demo"><i class="fa  fa-plus-square-o"></i> Cadastros <i class="fa fa-fw fa-caret-down"></i></a>
        <ul id="demo" class="in">
            <li>
                <a href="<c:url value="/usuario"/>" style="color: #fff"><i class="fa  fa-user-plus"></i> Usuário</a>
            </li>
            <li>
                <a href="<c:url value="/estrato"/>" style="color: #fff"><i class="fa  fa-puzzle-piece"></i> Estrato</a>
            </li>
            <li>
                <a href="<c:url value="/bairro"/>" style="color: #fff"><i class="fa  fa-edit"></i> Bairro</a>
            </li>
            <li>
                <a href="<c:url value="/quarteirao"/>" style="color: #fff"><i class="fa  fa-edit"></i> Quarteir&atilde;o</a>
            </li>
            <li>
                <a href="<c:url value="/inseticida"/>" style="color: #fff"><i class="fa  fa-flask"></i> Inseticida</a>
            </li>
            <li>
                <a href="<c:url value="/criadouro"/>" style="color: #fff"><i class="fa  fa-cube"></i> Criadouro</a>
            </li>
            <li>
                <a href="<c:url value="/pontoestrategico"/>" style="color: #fff"><i class="fa fa-map-marker"></i> Ponto <br/>&nbsp;&nbsp;&nbsp;&nbsp;Estratégico</a>
            </li>
        </ul>
    </li>

</ul>