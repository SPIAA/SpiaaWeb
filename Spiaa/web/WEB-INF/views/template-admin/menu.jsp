<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../imports.jspf" %>

<ul class="nav navbar-nav side-nav ">
    <li>
        <a href="<c:url value="/boletim"/>" style="color: #fff"><i class="fa fa-2x fa-table"></i> Boletim Diário</a>
    </li>

    <li>
        <a href="<c:url value="/denuncia"/>" style="color: #fff"><i class="fa fa-2x fa-exclamation-circle"></i> Denúncia</a>
    </li>

    <li>
        <a href="<c:url value="/mapa/admin"/>" style="color: #fff"><i class="fa fa-2x fa-globe"></i> Mapa</a>
    </li>
    <li>
        <a href="javascript:;" data-toggle="collapse" style="color: #fff" data-target="#demo"><i class="fa fa-2x fa-plus-square-o"></i> Cadastros <i class="fa fa-fw fa-caret-down"></i></a>
        <ul id="demo" class="in">
            <li>
                <a href="<c:url value="/usuario"/>" style="color: #fff"><i class="fa fa-2x fa-user-plus"></i> Usuário</a>
            </li>
            <li>
                <a href="<c:url value="/estrato"/>" style="color: #fff"><i class="fa fa-2x  fa-puzzle-piece"></i> Estrato</a>
            </li>
            <li>
                <a href="<c:url value="/bairro"/>" style="color: #fff"><i class="fa fa-2x fa-edit"></i> Bairro</a>
            </li>
            <li>
                <a href="<c:url value="/quarteirao"/>" style="color: #fff"><i class="fa fa-2x fa-edit"></i> Quarteir&atilde;o</a>
            </li>
            <li>
                <a href="<c:url value="/inseticida"/>" style="color: #fff"><i class="fa fa-2x fa-flask"></i> Inseticida</a>
            </li>
            <li>
                <a href="<c:url value="/criadouro"/>" style="color: #fff"><i class="fa fa-2x fa-cube"></i> Criadouro</a>
            </li>
        </ul>
    </li>

</ul>