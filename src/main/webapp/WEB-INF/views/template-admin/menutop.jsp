<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../imports.jspf" %>
<div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="index.html">Spiaa - Administrativo</a>
</div>
<!-- Top Menu Items -->
<ul class="nav navbar-right top-nav">

    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> ${usuarioLogado.nome} <b class="caret"></b></a>
        <ul class="dropdown-menu">
            <li>
                <a href="<c:url value="/usuario/${usuarioLogado.id}/perfil"/>"> <i class="fa fa-user"></i> Perfil</a>
            </li>
            <li>
                <a href="<c:url value="/parametros"/>"> <i class="fa fa-cog"></i> Configura&ccedil;&otilde;es</a>
            </li>
            <li>
                <a href="<c:url value="/logout"/>"> <i class="fa fa-sign-out"></i> Sair</a>
            </li>
        </ul>
    </li>
</ul>
<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
<div class="collapse navbar-collapse navbar-ex1-collapse">
    <jsp:include page="menu.jsp"/>
</div>