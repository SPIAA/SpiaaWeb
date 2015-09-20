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

/**
 *
 * @author William
 */
@Controller
@RequestMapping(value = "/denuncias")
public class DenunciaApiController {

   @RequestMapping(value = "/agente/{id}", method = RequestMethod.GET)
   public @ResponseBody
   String getDenuncias(@PathVariable Long id) {
      String resposta;
      try {
         Map<String, Object> criteria = new HashMap<String, Object>();
         criteria.put(DenunciaDAO.CRITERION_AGENTE_ID, id);
         List<Denuncia> denuncias = ServiceLocator.getbaseDenunciaService().readByCriteria(criteria);

         Gson gson = new Gson();
         resposta = gson.toJson(denuncias);
      } catch (Exception e) {
         resposta = null;
      }
      return resposta;
   }

}
