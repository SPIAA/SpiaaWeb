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
        <div id="wrapper">

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
                                <c:if test="${empty liraa}">
                                    Novo Liraa 
                                </c:if>
                                    <c:if test="${not empty liraa}">
                                   Alterar Liraa 
                                </c:if>
                                
                            </h1>
                            <br/>
                            <br/><br/>
                            <div class="col-lg-1 row"></div>      
                            <div class="col-lg-10 row">
                                <form class="form-inline" role="form" method="POST">
                                    <div class="form-group col-md-5">
                                        <label class="" for="inputdataInicio">Data Inicial :</label><br/>
                                        <div class="input-group margin-bottom-sm">
                                            <span class="input-group-addon"><i class="fa fa-calendar "></i></span>
                                            <input class="form-control" type="text"  name="dataInicio" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${liraa.dataInicio}"/>" id="datepickerIn">
                                        </div>
                                    </div>
                                    <div class="form-group col-md-5">
                                        <label class="" for="inputdataTermino">Data final :</label><br/>
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="fa fa-calendar "></i></span>
                                        <input class="form-control" type="text" name="dataTermino" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${liraa.dataTermino}"/>" id="datepickerFim">
                                    </div>
                                    </div>
                                   
                                    <div class="form-group col-md-2 ">
                                        <br/>
                                        <input type="submit" class="btn btn-success btn-block" value=" Gravar" />
                                        
                                    </div>
                                    
                               
                                </form>
                               
                            </div>    
                            <div class="col-lg-1 row"></div>   

                            <br/><br/> <br/><br/>
                        </div>
                    </div>
                    <!-- /.row -->

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- /#page-wrapper -->

        </div>
        <!-- /#wrapper -->
  <script>
  $(function() {
    $( "#datepickerIn" ).datepicker(
            {  dateFormat: "dd/mm/yy",
        monthNames: [ "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" ],
        dayNamesMin: [ "Dm", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab" ] 
    
        });
  });
  $(function() {
    $( "#datepickerFim" ).datepicker({  dateFormat: "dd/mm/yy",
        monthNames: [ "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" ],
        dayNamesMin: [ "Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab" ] 
    });
  });
  
  </script>
      </body>
</html>
