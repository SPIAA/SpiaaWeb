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
import spiaa.model.entity.Bairro;
import spiaa.model.entity.PontoEstrategico;
import spiaa.model.entity.Usuario;

@Controller
public class PontoEstrategicoController {

    @RequestMapping(value = "/pontoestrategico", method = RequestMethod.GET)
    public ModelAndView listar(String mensagem) throws Exception {

        List<PontoEstrategico> pontoEstrategicoList = new ArrayList<PontoEstrategico>();
        Map<String, Object> criteria = new HashMap<String, Object>();
        pontoEstrategicoList = ServiceLocator.getbasePontoEstrategicoService().readByCriteria(criteria);
        ModelAndView mv = new ModelAndView("pontoestrategico/pontoEstrategicoList");
        mv.addObject("pontoEstrategicoList", pontoEstrategicoList);

        return mv;
    }

    @RequestMapping(value = "/pontoestrategico/novo", method = RequestMethod.GET)
    public ModelAndView novo() {
        ModelAndView mv = null;
        try {
            Map<String, Object> criteria = new HashMap<String, Object>();
            List<Usuario> usuarioList = ServiceLocator.getBaseUsuarioService().readByCriteria(criteria);
            List<Bairro> bairroList = ServiceLocator.getBaseBairroService().readByCriteria(criteria);
            mv = new ModelAndView("pontoestrategico/pontoEstrategicoForm");
            mv.addObject("bairroList", bairroList);
            mv.addObject("usuarioList", usuarioList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

    @RequestMapping(value = "/pontoestrategico/novo", method = RequestMethod.POST)
    @ResponseBody
    public String teste(@RequestBody String jsonData, HttpServletResponse response) throws Exception {
        String retorno = "error";
        try {
            Gson gson = new Gson();
            PontoEstrategico pontoEstrategico = gson.fromJson(jsonData, PontoEstrategico.class);
            ServiceLocator.getbasePontoEstrategicoService().create(pontoEstrategico);
            retorno = "success";
            response.setStatus(200);
        } catch (Exception e) {
            response.setStatus(500);
        }
        return retorno;
    }

    @RequestMapping(value = "/pontoestrategico/{id}/alterar", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable Long id) throws Exception {
        ModelAndView mv = new ModelAndView("pontoestrategico/pontoEstrategicoForm");
        Map<String, Object> criteria = new HashMap<String, Object>();
        List<Usuario> usuarioList = ServiceLocator.getBaseUsuarioService().readByCriteria(criteria);
        List<Bairro> bairroList = ServiceLocator.getBaseBairroService().readByCriteria(criteria);
        PontoEstrategico pontoEstrategico = ServiceLocator.getbasePontoEstrategicoService().readById(id);
        
        mv.addObject("pontoEstrategico", pontoEstrategico);
        mv.addObject("bairroList", bairroList);
        mv.addObject("usuarioList", usuarioList);

        return mv;
    }

    @RequestMapping(value = "/pontoestrategico/alterar", method = RequestMethod.POST)
    @ResponseBody
    public String update(@RequestBody String jsonData, HttpServletResponse response) throws Exception {
        String retorno = "error";
        try {
            Gson gson = new Gson();
            PontoEstrategico pontoEstrategico = gson.fromJson(jsonData, PontoEstrategico.class);
            ServiceLocator.getbasePontoEstrategicoService().update(pontoEstrategico);
            retorno = "success";
            response.setStatus(200);
        } catch (Exception e) {
            response.setStatus(500);
        }
        return retorno;
    }

    @RequestMapping(value = "/pontoestrategico/{id}/excluir", method = RequestMethod.GET)
    public ModelAndView deletar(@PathVariable Long id) throws Exception {
        ModelAndView mv = new ModelAndView("pontoestrategico/pontoEstrategicoForm");
        try {
            ServiceLocator.getbasePontoEstrategicoService().delete(id);
            mv = new ModelAndView("redirect:/pontoestrategico");
        } catch (Exception e) {
            mv.addObject("mensagem", "Houve alguma falha ao deletar o Ponto Estratégico. Por favor tente novamente.");
            e.printStackTrace();
        }

        return mv;
    }
}
