package spiaa.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import spiaa.model.ServiceLocator;
import spiaa.model.entity.Liraa;

@Controller
public class LiraaController {

    @RequestMapping(value = "/liraa", method = RequestMethod.GET)
    public ModelAndView read() throws Exception {
        ModelAndView mv = null;

        Map<String, Object> criteria = new HashMap<String, Object>();
        List<Liraa> liraaList = new ArrayList<Liraa>();
        liraaList = ServiceLocator.getBaseLiraaService().readByCriteria(criteria);

        mv = new ModelAndView("liraa/list");
        mv.addObject("liraa", liraaList);

        return mv;

    }

    @RequestMapping(value = "/liraa/novo", method = RequestMethod.GET)
    public ModelAndView create() {
        ModelAndView mv = null;

        mv = new ModelAndView("liraa/form");

        return mv;
    }

    @RequestMapping(value = "/liraa/novo", method = RequestMethod.POST)
    public ModelAndView create(@Valid Liraa liraa, BindingResult results) throws Exception {
        ModelAndView mv = null;

        if (results.hasErrors()) {
            mv = new ModelAndView("/liraa/novo");

        } else {
            ServiceLocator.getBaseLiraaService().create(liraa);
            mv = new ModelAndView("redirect:/liraa");
        }

        return mv;
    }

    @RequestMapping(value = "/liraa/{id}/alterar", method = RequestMethod.GET)
    public ModelAndView alterar(@PathVariable Long id) throws Exception {

        ModelAndView mv = null;

        Liraa liraa = new Liraa();
        liraa = ServiceLocator.getBaseLiraaService().readById(id);

        mv = new ModelAndView("liraa/form");
        mv.addObject("liraa", liraa);

        return mv;
    }

    @RequestMapping(value = "/liraa/{id}/alterar", method = RequestMethod.POST)
    public ModelAndView alterar(@PathVariable Long id, Liraa liraa) throws Exception {

        ModelAndView mv = null;

        ServiceLocator.getBaseLiraaService().update(liraa);

        mv = new ModelAndView("redirect:/liraa");
        mv.addObject("liraa", liraa);

        return mv;
    }

}
