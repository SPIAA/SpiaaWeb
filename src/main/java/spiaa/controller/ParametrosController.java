/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiaa.controller;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import spiaa.model.ServiceLocator;
import spiaa.model.entity.Parametros;

@Controller
public class ParametrosController {

    @RequestMapping(value = "/parametros", method = RequestMethod.GET)
    public ModelAndView create() throws Exception {
        ModelAndView mv = new ModelAndView("parametros/parametrosForm");
        Map<String, Object> criteria = new HashMap<>();
        List<Parametros> parametrosList = ServiceLocator.getbaseParametrosService().readByCriteria(criteria);
        Parametros parametros = null;
        if (parametrosList != null && parametrosList.size() > 0) {
            parametros = parametrosList.get(0);
        }
        mv.addObject("parametros", parametros);
        return mv;
    }

    @RequestMapping(value = "/parametros/novo", method = RequestMethod.POST)
    @ResponseBody
    public String create(@RequestBody String jsonData) throws Exception {
        String retorno = "error";
        try {
            Gson gson = new Gson();
            Parametros parametros = gson.fromJson(jsonData, Parametros.class);
            ServiceLocator.getbaseParametrosService().create(parametros);
            retorno = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retorno;
    }

    @RequestMapping(value = "/parametros/alterar", method = RequestMethod.POST)
    @ResponseBody
    public String update(@RequestBody String jsonData) throws Exception {
        String retorno = "error";
        try {
            Gson gson = new Gson();
            Parametros parametros = gson.fromJson(jsonData, Parametros.class);
            ServiceLocator.getbaseParametrosService().update(parametros);
            retorno = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retorno;
    }
}
