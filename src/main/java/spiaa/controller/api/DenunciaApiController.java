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
import spiaa.model.dao.DenunciaDAO;
import spiaa.model.entity.Denuncia;

/**
 *
 * @author William
 */
@Controller
public class DenunciaApiController {

   private static final String RESPONSE_ERROR = "{\"success\":false}";
   private static final String REPONSE_SUCCESS = "{\"success\":true}";

   @RequestMapping(value = "/denuncias/agente/{id}", method = RequestMethod.GET)
   public @ResponseBody
   String getDenuncias(@RequestBody @PathVariable Long id) {
      String resposta;
      try {
         Map<String, Object> criteria = new HashMap<>();
         criteria.put(DenunciaDAO.CRITERION_AGENTE_ID, id);
         List<Denuncia> denuncias = ServiceLocator.getbaseDenunciaService().readByCriteria(criteria);

         Gson gson = new Gson();
         resposta = gson.toJson(denuncias);
      } catch (Exception e) {
         resposta = RESPONSE_ERROR;
      }
      return resposta;
   }

   @RequestMapping(value = "/denuncias", method = RequestMethod.PUT)
   @ResponseBody
   public String finalizarDenuncias(@RequestBody List<Denuncia> denuncias) {
      String resposta;
      try {
         for (Denuncia denuncia : denuncias) {
            ServiceLocator.getbaseDenunciaService().update(denuncia);
         }
         resposta = REPONSE_SUCCESS;
      } catch (Exception e) {
         resposta = RESPONSE_ERROR;
      }
      return resposta;
   }
}
