package spiaa.controller;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import spiaa.model.ServiceLocator;
import spiaa.model.entity.Bairro;
import spiaa.model.entity.BairroEstrato;
import spiaa.model.entity.Criadouro;
import spiaa.model.entity.Estrato;

@Controller
public class EstratoController {

    @RequestMapping(value = "/estrato", method = RequestMethod.GET)
    public ModelAndView listar() {
        ModelAndView mv = null;
        List<Estrato> estratoList = null;
        Map<String, Object> criteria = new HashMap<String, Object>();
        try {

            estratoList = ServiceLocator.getBaseEstratoService().readByCriteria(criteria);

            mv = new ModelAndView("estrato/estratoList");
            mv.addObject("estrato", estratoList);

        } catch (Exception e) {

        }
        return mv;
    }

    @RequestMapping(value = "/estrato/novo", method = RequestMethod.GET)
    public ModelAndView create() {
        ModelAndView mv = null;
        List<Bairro> bairroList = new ArrayList<Bairro>();
        Map<String, Object> criteria = new HashMap<String, Object>();
        try {

            bairroList = ServiceLocator.getBaseBairroService().readByCriteria(criteria);
            mv = new ModelAndView("estrato/estratoForm");
            mv.addObject("bairroList", bairroList);

        } catch (Exception e) {

        }
        return mv;
    }

    @RequestMapping(value = "/estrato/novo", method = RequestMethod.POST)
    public ModelAndView create(Estrato estrato, HttpServletRequest request) {
        ModelAndView mv = null;
        Bairro bairro = null;
        BairroEstrato bairroEstrato = null;
        List<BairroEstrato> bairroEstratolist = new ArrayList<BairroEstrato>();
        String bairros[] = request.getParameterValues("bairro");

        try {
            for (int i = 0; i < bairros.length; i++) {
                bairro = new Bairro();
                bairro.setId(Long.parseLong(bairros[i]));

                bairroEstrato = new BairroEstrato();
                bairroEstrato.setBairro(bairro);
                bairroEstratolist.add(bairroEstrato);
            }
            estrato.setBairroEstratoList(bairroEstratolist);
            ServiceLocator.getBaseEstratoService().create(estrato);
            mv = new ModelAndView("redirect:/estrato");

        } catch (Exception e) {

        }
        return mv;
    }

    @RequestMapping(value = "/estrato/{id}/alterar", method = RequestMethod.GET)
    public ModelAndView alterar(@PathVariable Long id) {
        ModelAndView mv = null;
        Estrato estrato = null;
        List<Bairro> bairroList = new ArrayList<Bairro>();
        Map<String, Object> criteria = new HashMap<String, Object>();
        try {
            estrato = new Estrato();
            bairroList = ServiceLocator.getBaseBairroService().readByCriteria(criteria);
            estrato = ServiceLocator.getBaseEstratoService().readById(id);
            mv = new ModelAndView("estrato/estratoForm");
            mv.addObject("estrato", estrato);
            mv.addObject("bairroList", bairroList);

        } catch (Exception e) {

        }
        return mv;
    }

    @RequestMapping(value = "/estrato/alterar", method = RequestMethod.POST)
    @ResponseBody
    public String alterar(@RequestBody String jsonData, HttpServletResponse response) {
        String retorno = "error";
        try {
            Gson gson = new Gson();
            Estrato estrato = gson.fromJson(jsonData, Estrato.class);
            ServiceLocator.getBaseEstratoService().update(estrato);
            retorno = "success";
            response.setStatus(200);
        } catch (Exception e) {
            response.setStatus(500);
        }
        return retorno;
    }

}
