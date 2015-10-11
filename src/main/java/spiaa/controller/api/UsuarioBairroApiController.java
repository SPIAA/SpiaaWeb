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
import spiaa.model.dao.QuarteiraoDAO;
import spiaa.model.dao.UsuarioBairroDAO;
import spiaa.model.entity.Bairro;
import spiaa.model.entity.Usuario;
import spiaa.model.entity.UsuarioBairro;

/**
 *
 * @author Felipe
 */
@Controller
public class UsuarioBairroApiController {

    @RequestMapping(value = "/api/bairro/agente", method = RequestMethod.POST)
    public @ResponseBody
    List<Bairro> getBairros(@RequestBody Usuario agenteSaude) throws Exception {
        List<UsuarioBairro> usuarioBairroList = null;
        Map<String, Object> criteria = new HashMap<>();
        List<Bairro> bairroList = null;
        try {
            criteria.put(UsuarioBairroDAO.CRITERION_USUARIO_ID_EQ, agenteSaude.getId());
            usuarioBairroList = ServiceLocator.getbaseUsuarioBairroService().readByCriteria(criteria);
            for (UsuarioBairro ub : usuarioBairroList) {
                bairroList.add(ub.getBairro());
            }
        } catch (Exception e) {
            throw e;
        }
        return bairroList;
    }

    @RequestMapping(value = "/api/bairroquarteirao/agente", method = RequestMethod.POST)
    public @ResponseBody
    List<Bairro> getBairrosQuarteiroes(@RequestBody Usuario agenteSaude) throws Exception {
        List<UsuarioBairro> usuarioBairroList = null;
        Map<String, Object> criteria = new HashMap<>();
        List<Bairro> bairroList = null;
        try {
            criteria.put(UsuarioBairroDAO.CRITERION_USUARIO_ID_EQ, agenteSaude.getId());
            usuarioBairroList = ServiceLocator.getbaseUsuarioBairroService().readByCriteria(criteria);
            for (UsuarioBairro ub : usuarioBairroList) {
                bairroList.add(ub.getBairro());
            }
            for (Bairro bairro : bairroList) {
                criteria.put(QuarteiraoDAO.CRITERION_BAIRRO_ID, bairro.getId());
                bairro.setQuarteiraoList(ServiceLocator.getbaseQuarteiraoService().readByCriteria(criteria));
            }
        } catch (Exception e) {
            throw e;
        }
        return bairroList;
    }

}
