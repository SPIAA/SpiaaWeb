
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../imports.jspf" %>
<!DOCTYPE html>
<html lang="pt-br">

  <head>
    <jsp:include page="../template-admin/header.jsp"/>
    <link href="<c:url value="/css/jquery-ui.min.css"/>" rel="stylesheet">
    <script src="<c:url value="/js/jquery-ui.min.js"/>"></script>
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
                Quartei&atilde;o
                <small>Novo</small>
              </h1>
              <c:if test="${not empty mensagem}">  <div class="alert alert-danger alert-dismissible" role="alert">
                  <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                  <p class="text-center">${mensagem}</p> 
                </div>
              </c:if>
              <form class="form-group" method="POST" name="form" id="form">
                <div class="form-group col-md-4 ">
                  <label for="descricao">Descri&ccedil;&atilde;o: </label>
                  <input type="text" class="form-control validate[required]"  name="descricao" value="${quarteirao.descricao}"/>
                </div>
                <br/><br/><br/><br/><br/><br/><br/><br/>
                <div class="col-lg-12" align="left">
                  <input class="btn btn-success" type="submit" name="salvar" value="Salvar"/>  
                </div>
              </form>
            </div>
            <br/>
          </div>
        </div>

      </div>
      <!-- /.container-fluid -->
    </div>
    <!-- /#page-wrapper -->
  </div>
  <!-- /#wrapper -->     
  <script>
    jQuery(document).ready(function () {
      // binds form submission and fields to the validation engine
      jQuery("#form").validationEngine('attach', {promptPosition: "bottomLeft", autoPositionUpdate: true});
    });
  </script>
</body>
</html>
