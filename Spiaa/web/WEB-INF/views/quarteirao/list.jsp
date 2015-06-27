<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../imports.jspf" %>
<!DOCTYPE html>
<html>
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
            <!-- Page Heading -->
          <div class="row">
            <div class="col-lg-12">
              <h1 class="page-header">
                 Quarteir&atilde;o
                <small>Listagem</small>
              </h1>
               <a href="<c:url value="/quarteirao/novo"/>" class="btn btn-primary">Novo Quarteir&atilde;o</a><br/><br/>
              <display:table class="table table-striped table-hover"  name="quarteiraoList" id="quarteirao" requestURI="" pagesize="7">
                <display:column property="descricao" title="Sigla"/>
                <display:column property="bairro.nome" title="Bairro"/>
                <display:column>
                   <a href="<c:url value="/quarteirao/${quarteirao.id}/alterar"/>">
                      Alterar
                   </a>
                </display:column>
                <display:column>
                   <a href="<c:url value="/quarteirao/${quarteirao.id}/excluir"/>">
                      Excluir
                   </a>
                </display:column>
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
    <!-- /#wrapper -->
    <div class="modal fade" id="confirmDelete">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header btn-danger">
            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
            <h3 class="modal-title">Atenção</h3>
          </div>
          <div class="modal-body">
            <p>Deseja realmente excluir este Quarteir&atilde;o?</p>
            <div class="alert alert-danger">
              <strong> Atenção: esta operação não pode ser desfeita.</strong> 
            </div>

          </div>
          <div class="modal-footer">
            <a href="#" class="btn btn-danger">Sim, desejo excluir.</a>
            <a href="#" class="btn btn-default" data-dismiss="modal">Cancelar</a>
          </div>
        </div><!-- /.modal-content -->
      </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
    <script>
      $(function () {
        $("td.deleteLink a").click(function () {
          $('#confirmDelete').modal('show');
          $("#confirmDelete .btn-danger").attr("href", $(this).attr("href"));
          return false;
        });
      });
    </script>
  </body>
</html>
