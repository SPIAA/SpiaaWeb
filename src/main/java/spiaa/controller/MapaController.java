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
import spiaa.model.entity.Estrato;

@Controller
public class MapaController {

    @RequestMapping(value = "/mapa", method = RequestMethod.GET)
    public ModelAndView novo() throws Exception {

        ModelAndView mv = new ModelAndView("mapa/mapa");
        List<Estrato> estratoList = new ArrayList<Estrato>();
        Map<String, Object> criteria = new HashMap<String, Object>();
//        Estrato estrato = new Estrato();
//        estrato = ServiceLocator.getBaseEstratoService().readById(3L);
        estratoList = ServiceLocator.getBaseEstratoService().readByCriteria(criteria);
        mv.addObject("estratoList", estratoList);
//         mv.addObject("estratoList", estrato);

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
