<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../imports.jspf" %>

<ul class="nav navbar-nav side-nav ">
    <li>
        <a href="<c:url value="/boletim"/>" style="color: #fff"><i class="fa fa-2x fa-edit"></i> Boletim Diário</a>
    </li>
    <li>
        <a href="<c:url value="/liraa"/>" style="color: #fff"><i class="fa fa-2x fa-navicon"></i> Liraa</a>
    </li>
    <li>
        <a href="<c:url value="/estrato"/>" style="color: #fff"><i class="fa fa-2x  fa-puzzle-piece"></i> Estrato</a>
    </li>
    <li>
        <a href="<c:url value="/bairro"/>" style="color: #fff"><i class="fa fa-2x fa-edit"></i> Bairro</a>
    </li>
    <li>
        <a href="<c:url value="/denuncia"/>" style="color: #fff"><i class="fa fa-2x fa-exclamation-circle"></i> Denúncia</a>
    </li>
    <li>
        <a href="<c:url value="/mapa/admin"/>" style="color: #fff"><i class="fa fa-2x fa-globe"></i> Mapa</a>
    </li>

</ul>