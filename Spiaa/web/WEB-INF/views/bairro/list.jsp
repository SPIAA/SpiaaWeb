<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../imports.jspf" %>
<!DOCTYPE html>
<html lang="pt-br">

  <head>
    <jsp:include page="../template-admin/header.jsp"/>
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
                Bairro
                <small>Listagem</small>
              </h1>
              <a href="bairro/novo" class="btn btn-primary">Novo Bairro</a><br/><br/>
              <display:table class="table table-striped table-hover"  name="bairrolist" id="bairrolist" requestURI="" pagesize="7">
                <display:column property="nome" title="Estrato"/>
                <display:column title="Quarteirão"><a href="<c:url value="/quarteirao/${bairrolist.id}"/>"><i class="fa fa-2x fa-edit"></i></a></display:column>
              </display:table>
            </div>
          </div>
          <!-- /.row -->
        </div>
        <!-- /.container-fluid -->
      </div>
      <!-- /#page-wrapper -->
    </div>
    <!-- /#wrapper -->
  </body>
</html>
