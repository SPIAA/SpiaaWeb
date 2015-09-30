  /* 
   * To change this license header, choose License Headers in Project Properties.
   * To change this template file, choose Tools | Templates
   * and open the template in the editor.
   */

  $(document).ready(function () {

     var usuario = {
        id: '',
        nome: 'Teste',
        nomeUsuario:'Administrador',
        senha:'administrador',
        tipo: 'AGS'
     };
    $.ajax({method:'post', url:'http://localhost:8084/Spiaa/agente/login', usuario:usuario}).success(function(data){
       alert(data);
    }).fail(function(data){
       alert(data);
    });
     
  });
