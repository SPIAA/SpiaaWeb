/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiaa.controller.api;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spiaa.model.ServiceLocator;
import spiaa.model.entity.TratamentoAntiVetorial;

/**
 *
 * @author William
 */
@Controller
@RequestMapping(value = "/boletins")
public class TratamentoAntiVetorialApiController {

   @RequestMapping(value = "/salvar", method = RequestMethod.POST)
   public @ResponseBody
   String create(List<TratamentoAntiVetorial> TAVs) {
      String resposta;
      try {
         for (TratamentoAntiVetorial tav : TAVs) {
            ServiceLocator.getbaseTratamentoAntiVetorialService().create(tav);
         }
         resposta = "{\"resposta\":\"success\"}";
      } catch (Exception e) {
         resposta = null;
      }
      return resposta;
   }
}
