/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiaa.controller.api;

import com.google.gson.Gson;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spiaa.model.ServiceLocator;
import spiaa.model.entity.ConsolidacaoDados;

/**
 *
 * @author William
 */
@Controller
public class TratamentoAntiVetorialApiController {


   @RequestMapping(value = "/boletim", method = RequestMethod.POST)
   public @ResponseBody
   String setConsolidacoes(List<ConsolidacaoDados> boletins) {
      String resposta;
      try {
         for(ConsolidacaoDados boletim : boletins){
            ServiceLocator.getBaseConsolidacaoDadosService().create(boletim);
         }
         Gson gson = new Gson();
         resposta = "{\"success\": true}";
      } catch (Exception e) {
         resposta = null;
      }
      return resposta;
   }

}
