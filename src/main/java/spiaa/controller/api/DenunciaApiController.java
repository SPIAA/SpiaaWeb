package spiaa.controller.api;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
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
   String getDenuncias(@PathVariable Long id, HttpServletResponse response) {
      String resposta;
      try {
         Map<String, Object> criteria = new HashMap<String, Object>();
         criteria.put(DenunciaDAO.CRITERION_AGENTE_ID, id);
         criteria.put(DenunciaDAO.CRITERION_STATUS_ILIKE, "encaminha");
         List<Denuncia> denuncias = ServiceLocator.getbaseDenunciaService().readByCriteria(criteria);

         Gson gson = new Gson();
         resposta = gson.toJson(denuncias);
         response.setStatus(200);
      } catch (Exception e) {
         resposta = null;
         response.setStatus(500);
      }
      return resposta;
   }

   @RequestMapping(value = "/finalizar", method = RequestMethod.PUT)
   public @ResponseBody
   String finalizeDenuncia(List<Denuncia> denuncias, HttpServletResponse response) {
      String resposta;
      try {
         for (Denuncia denuncia : denuncias) {
            ServiceLocator.getbaseDenunciaService().update(denuncia);
         }
         resposta = "{\"resposta\":\"success\"}";
         response.setStatus(200);
      } catch (Exception e) {
         resposta = null;
         response.setStatus(500);
      }
      return resposta;
   }

}
