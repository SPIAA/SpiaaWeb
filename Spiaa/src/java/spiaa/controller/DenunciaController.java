package spiaa.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import spiaa.model.ServiceLocator;
import spiaa.model.entity.Bairro;
import spiaa.model.entity.Denuncia;

@Controller
public class DenunciaController {

    @RequestMapping(value = "/denunciaform", method = RequestMethod.GET)
    public ModelAndView novo() throws Exception {

        List<Bairro> bairroList = new ArrayList<Bairro>();
        Map<String, Object> criteria = new HashMap<String, Object>();
        bairroList = ServiceLocator.getBaseBairroService().readByCriteria(criteria);
        ModelAndView mv = new ModelAndView("denuncia/Form");
        mv.addObject("bairroList", bairroList);

        return mv;
    }

    @RequestMapping(value = "/denunciaform", method = RequestMethod.POST)
    public ModelAndView novo(Denuncia denuncia) {
        ModelAndView mv = null;
        try {
            ServiceLocator.getbaseDenunciaService().create(denuncia);
            mv = new ModelAndView("redirect:/home");

        } catch (Exception e) {
        }

        return mv;
    }

    @RequestMapping(value = "/denuncia/list", method = RequestMethod.GET)
    public ModelAndView listarAdm() {
        ModelAndView mv = null;
        try {
            List<Denuncia> denunciaList = new ArrayList<Denuncia>();
            Map<String, Object> criteria = new HashMap<String, Object>();
            denunciaList = ServiceLocator.getbaseDenunciaService().readByCriteria(criteria);
            mv = new ModelAndView("redirect:/home");

        } catch (Exception e) {
        }

        return mv;
    }

    @RequestMapping(value = "/denuncia", method = RequestMethod.GET)
    public ModelAndView Listar() throws Exception {
        ModelAndView mv = null;

        List<Denuncia> denunciaList = new ArrayList<Denuncia>();
        Map<String, Object> criteria = new HashMap<String, Object>();
        denunciaList = ServiceLocator.getbaseDenunciaService().readByCriteria(criteria);

        mv = new ModelAndView("denuncia/list");
        mv.addObject("denunciaList", denunciaList);

        return mv;
    }

    @RequestMapping(value = "/denuncia/{id}/visualiza", method = RequestMethod.GET)
    public ModelAndView visualizar(@PathVariable Long id) throws Exception {
        ModelAndView mv = null;
        
            Denuncia denuncia = new Denuncia();

            denuncia = ServiceLocator.getbaseDenunciaService().readById(id);

            mv = new ModelAndView("denuncia/view");
            mv.addObject("denuncia", denuncia);

               return mv;
    }
}
