package spiaa.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import spiaa.model.ServiceLocator;
import spiaa.model.entity.Criadouro;
import spiaa.model.entity.Estrato;

@Controller
public class MapaController {

    @RequestMapping(value = "/mapa", method = RequestMethod.GET)
    public ModelAndView novo() throws Exception {

        ModelAndView mv = new ModelAndView("mapa/mapa_1");
        List<Estrato> estratoList = new ArrayList<Estrato>();
        List<Estrato> estratos = new ArrayList<Estrato>();
        List<Criadouro> criadouroList = new ArrayList<>();
        Map<String, Object> criteria = new HashMap<String, Object>();
        estratoList = ServiceLocator.getBaseEstratoService().readByCriteria(criteria);
        estratos = ServiceLocator.getBaseEstratoService().readAll();
        criadouroList = ServiceLocator.getBaseCriadouroService().readByCriteria(criteria);
        mv.addObject("criadouroList", criadouroList);
        mv.addObject("estratoList", estratoList);
        mv.addObject("estratos", estratos);
        mv.addObject("corEstrato", estratos);
        mv.addObject("totalCriadouro", criadouroList);

        return mv;
    }

    @RequestMapping(value = "/mapa/admin", method = RequestMethod.GET)
    public ModelAndView novo(HttpServletRequest request) throws Exception {
        ModelAndView mv = null;
        List<Estrato> estratoList = new ArrayList<Estrato>();
        try {

            Map<String, Object> criteria = new HashMap<String, Object>();

            estratoList = ServiceLocator.getbaseMapaService().readByCriteriaMapaEstrato(criteria);
            mv = new ModelAndView("mapa/list");
            mv.addObject("estratoList", estratoList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mv;
    }
}
