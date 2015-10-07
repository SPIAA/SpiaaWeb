/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import spiaa.model.entity.Criadouro;
import spiaa.model.entity.Usuario;

/**
 *
 * @author Felipe de Souza
 */
@Controller
public class CriadouroApiController {

    @RequestMapping(value = "/api/criadouro", method = RequestMethod.POST)
    public @ResponseBody
    List<Criadouro> getCriadouros(@RequestBody Usuario agenteSaude) throws Exception {
        List<Criadouro> criadouroList = null;
        try {
            Map<String, Object> criteria = new HashMap<String, Object>();
            criadouroList = ServiceLocator.getBaseCriadouroService().readByCriteria(criteria);

        } catch (Exception e) {
            throw e;
        }
        return criadouroList;
    }
}
