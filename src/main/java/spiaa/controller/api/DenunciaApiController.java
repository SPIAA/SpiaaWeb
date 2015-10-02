package spiaa.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
   List<Denuncia> getDenuncias(@RequestBody Usuario agente) throws Exception {

      List<Denuncia> denunciaList = null;
      try {
         Map<String, Object> criteria = new HashMap<>();
         criteria.put(DenunciaDAO.CRITERION_AGENTE_ID, agente.getId());
         denunciaList = ServiceLocator.getbaseDenunciaService().readByCriteria(criteria);
      } catch (Exception e) {
         e.printStackTrace();
         throw e;

      }
      return denunciaList;
   }

   @RequestMapping(value = "/denuncias", method = RequestMethod.PUT)
   @ResponseBody
   public void finalizarDenuncias(@RequestBody List<Denuncia> denuncias) throws Exception {
      try {
         for (Denuncia denuncia : denuncias) {
            ServiceLocator.getbaseDenunciaService().update(denuncia);
         }
      } catch (Exception e) {
         throw e;
      }

   }
}
