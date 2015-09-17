/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiaa.controller.api;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spiaa.model.ServiceLocator;
import spiaa.model.entity.Usuario;

/**
 *
 * @author William
 */
@Controller
public class UsuarioApiController {

   @RequestMapping(value = "/agente", method = RequestMethod.GET)
   public @ResponseBody
   String getAgente() {
      String json;
      try {
         Map<String, Object> criteria = new HashMap<String, Object>();
         List<Usuario> usuarios = ServiceLocator.getBaseUsuarioService().readByCriteria(criteria);
         Usuario usuario = usuarios.get(0);
         Gson gson = new Gson();
         json = gson.toJson(usuario);
      } catch (Exception e) {
         json = null;
      }
      return json;
   }
}
