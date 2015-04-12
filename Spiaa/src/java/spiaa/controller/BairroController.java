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
import spiaa.model.entity.Bairro;

@Controller
public class BairroController {

    @RequestMapping(value = "/bairro", method = RequestMethod.GET)
    public ModelAndView novo() throws Exception {
        ModelAndView mv = null;

        List<Bairro> bairroList = new ArrayList<Bairro>();
        Map<String, Object> criteria = new HashMap<String, Object>();
        bairroList = ServiceLocator.getBaseBairroService().readByCriteria(criteria);

        mv = new ModelAndView("bairro/list");
        mv.addObject("bairrolist", bairroList);

        return mv;
    }
}
