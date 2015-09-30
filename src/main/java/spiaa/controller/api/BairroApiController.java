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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spiaa.model.ServiceLocator;
import spiaa.model.entity.Bairro;

/**
 *
 * @author William
 */
@Controller
public class BairroApiController {

   private static final String RESPONSE_ERROR = "{\"success\":false}";

   @RequestMapping(value = "/bairro/agente/{id}", method = RequestMethod.GET)
   public @ResponseBody
   String getBairros(@RequestBody @PathVariable Long id) {
      String resposta;
      try {
         Map<String, Object> criteria = new HashMap<>();
         //TODO criterio
         List<Bairro> bairros = ServiceLocator.getBaseBairroService().readByCriteria(criteria);
         Gson gson = new Gson();
         resposta = gson.toJson(bairros);
      } catch (Exception e) {
         resposta = RESPONSE_ERROR;
      }
      return resposta;
   }

}
