package spiaa.controller.api;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spiaa.model.ServiceLocator;
import spiaa.model.entity.Bairro;
import spiaa.model.entity.Usuario;
import spiaa.model.entity.UsuarioBairro;

/**
 *
 * @author William
 */
@Controller
public class UsuarioBairroApiController {

    @RequestMapping(value = "/api/bairro/agente", method = RequestMethod.GET)
    public @ResponseBody
    List<Bairro> getBairrosByUser(@RequestBody Usuario agenteSaude) throws Exception {
        List<Bairro> bairroList = null;
        try {
            UsuarioBairro ub = ServiceLocator.getbaseUsuarioBairroService().readById(agenteSaude.getId());
            bairroList = ub.getBairros();

        } catch (Exception e) {
            throw e;
        }
        return bairroList;
    }

    @RequestMapping(value = "/api/bairro/agente", method = RequestMethod.POST)
    public @ResponseBody
    List<Bairro> getBairros(@RequestBody Usuario agenteSaude) throws Exception {
        List<Bairro> bairroList = null;
        try {
            UsuarioBairro ub = ServiceLocator.getbaseUsuarioBairroService().readById(agenteSaude.getId());
            bairroList = ub.getBairros();

        } catch (Exception e) {
            throw e;
        }
        return bairroList;
    }

}
