package spiaa.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import spiaa.model.ServiceLocator;
import spiaa.model.entity.Bairro;

@Controller
public class BairroController {

    @RequestMapping(value = "/bairro", method = RequestMethod.GET)
    public ModelAndView read() throws Exception {
        ModelAndView mv = null;
        try {
            List<Bairro> bairroList = new ArrayList<Bairro>();
            Map<String, Object> criteria = new HashMap<String, Object>();
            bairroList = ServiceLocator.getBaseBairroService().readByCriteria(criteria);
            mv = new ModelAndView("bairro/list");
            mv.addObject("bairrolist", bairroList);
        } catch (Exception ex) {
            mv = new ModelAndView("erro/erro");
            mv.addObject("erro", ex);
        }
        return mv;
    }

    @RequestMapping(value = "/bairro/novo", method = RequestMethod.GET)
    public ModelAndView create() {
        ModelAndView mv = null;

        mv = new ModelAndView("bairro/form");
        return mv;
    }
}
