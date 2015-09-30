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
import spiaa.model.dao.DenunciaDAO;
import spiaa.model.entity.Denuncia;
import spiaa.model.entity.Usuario;

/**
 *
 * @author William
 */
@Controller
public class DenunciaApiController {

   @RequestMapping(value = "/denuncias", method = RequestMethod.GET)
   public @ResponseBody
   String getDenuncias(@PathVariable Long id, Usuario agente) {
      String resposta;
      try {
         Map<String, Object> criteria = new HashMap<>();
         criteria.put(DenunciaDAO.CRITERION_AGENTE_ID, agente.getId());
         List<Denuncia> denuncias = ServiceLocator.getbaseDenunciaService().readByCriteria(criteria);

         Gson gson = new Gson();
         resposta = gson.toJson(denuncias);
      } catch (Exception e) {
         resposta = null;
      }
      return resposta;
   }

   @RequestMapping(value = "/denuncias", method = RequestMethod.PUT)
   @ResponseBody
   public String finalizarDenuncias(List<Denuncia> denuncias) {
      String resposta;
      try {
         for (Denuncia denuncia : denuncias) {
            ServiceLocator.getbaseDenunciaService().update(denuncia);
         }
         resposta = "{\"success\":true}";
      } catch (Exception e) {
         resposta = null;
      }
      return resposta;
   }

}
