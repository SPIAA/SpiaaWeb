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

    @RequestMapping(value = "/api/denuncia/agente", method = RequestMethod.POST)
    public @ResponseBody
    List<Denuncia> getDenuncias(@RequestBody Usuario agenteSaude) throws Exception {

        List<Denuncia> denunciaList = null;
        try {
            Map<String, Object> criteria = new HashMap<>();
            criteria.put(DenunciaDAO.CRITERION_AGENTE_ID, agenteSaude.getId());
            criteria.put(DenunciaDAO.CRITERION_STATUS_ENCAMINHADA, Denuncia.STATUS_ENCAMINHADA);
            denunciaList = ServiceLocator.getbaseDenunciaService().readByCriteria(criteria);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return denunciaList;
    }

    @RequestMapping(value = "/api/denuncia/update", method = RequestMethod.PUT)
    public @ResponseBody
    String setDenuncias(@RequestBody List<Denuncia> denunciaList) throws Exception {
        String response = "SUCCESS";
        try {
            for (Denuncia denuncia : denunciaList) {
                ServiceLocator.getbaseDenunciaService().fechar(denuncia);
            }
        } catch (Exception e) {
            response = "ERROR -" + e.getMessage();
            throw e;
        }
        return response;
    }
}
