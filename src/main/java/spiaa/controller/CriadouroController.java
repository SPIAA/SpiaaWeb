package spiaa.controller;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import spiaa.model.ServiceLocator;
import spiaa.model.entity.Criadouro;

@Controller
public class CriadouroController {

    @RequestMapping(value = "/criadouro", method = RequestMethod.GET)
    public ModelAndView listar(String mensagem) throws Exception {

        List<Criadouro> criadouroList = new ArrayList<Criadouro>();
        Map<String, Object> criteria = new HashMap<String, Object>();
        criadouroList = ServiceLocator.getBaseCriadouroService().readByCriteria(criteria);
        ModelAndView mv = new ModelAndView("criadouro/criadouroList");
        mv.addObject("criadouroList", criadouroList);

        return mv;
    }

    @RequestMapping(value = "/criadouro/novo", method = RequestMethod.GET)
    public ModelAndView novo() {
        ModelAndView mv = null;
        try {
            mv = new ModelAndView("criadouro/criadouroForm");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

    @RequestMapping(value = "/criadouro/novo", method = RequestMethod.POST)
    @ResponseBody
    public String novo(@RequestBody String jsonData, HttpServletResponse response) throws Exception {
        String retorno = "error";
        try {
            Gson gson = new Gson();
            Criadouro criadouro = gson.fromJson(jsonData, Criadouro.class);
            ServiceLocator.getBaseCriadouroService().create(criadouro);
            retorno = "success";
            response.setStatus(200);
        } catch (Exception e) {
            response.setStatus(500);
        }
        return retorno;
    }

    @RequestMapping(value = "/criadouro/{id}/alterar", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable Long id) throws Exception {
        Criadouro criadouro = ServiceLocator.getBaseCriadouroService().readById(id);
        ModelAndView mv = new ModelAndView("criadouro/criadouroForm");
        mv.addObject("criadouro", criadouro);

        return mv;
    }

    @RequestMapping(value = "/criadouro/alterar", method = RequestMethod.POST)
    @ResponseBody
    public String update(@RequestBody String jsonData, HttpServletResponse response) throws Exception {
        String retorno = "error";
        try {
            Gson gson = new Gson();
            Criadouro criadouro = gson.fromJson(jsonData, Criadouro.class);
            ServiceLocator.getBaseCriadouroService().update(criadouro);
            retorno = "success";
            response.setStatus(200);
        } catch (Exception e) {
            response.setStatus(500);
        }
        return retorno;
    }

    @RequestMapping(value = "/criadouro/{id}/excluir", method = RequestMethod.GET)
    public ModelAndView deletar(@PathVariable Long id) throws Exception {
        ModelAndView mv = new ModelAndView("criadouro/criaoduroForm");
        try {
            ServiceLocator.getBaseCriadouroService().delete(id);
            mv = new ModelAndView("redirect:/criadouro");
        } catch (Exception e) {
            mv.addObject("mensagem", "Houve alguma falha ao deletar o Inseticida. Por favor tente novamente.");
            e.printStackTrace();
        }

        return mv;
    }
}
