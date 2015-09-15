package spiaa.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import spiaa.model.ServiceLocator;
import spiaa.model.dao.AtividadeDAO;
import spiaa.model.entity.Atividade;
import spiaa.model.entity.Bairro;
import spiaa.model.entity.TratamentoAntiVetorial;
import spiaa.model.entity.Usuario;

@Controller
public class TratamentoAntiVetorialController {

    @RequestMapping(value = "/boletim", method = RequestMethod.GET)
    public ModelAndView listar() throws Exception {
        ModelAndView mv = null;
        List<TratamentoAntiVetorial> boletimDiarioList = null;
        Map<String, Object> criteria = new HashMap<String, Object>();
        try {
            boletimDiarioList = ServiceLocator.getbaseBoletimDiarioService().readByCriteria(criteria);
            mv = new ModelAndView("boletim/list");
            mv.addObject("boletim", boletimDiarioList);
        } catch (Exception e) {

            e.printStackTrace();
        }

        return mv;
    }

    @RequestMapping(value = "/boletim/novo", method = RequestMethod.GET)
    public ModelAndView create() throws Exception {
        ModelAndView mv = null;
        List<Usuario> usuarioList = null;
        List<Bairro> bairrosList = null;
        Map<String, Object> criteria = new HashMap<String, Object>();
        try {
            usuarioList = ServiceLocator.getBaseUsuarioService().readByCriteria(criteria);
            bairrosList = ServiceLocator.getBaseBairroService().readByCriteria(criteria);

            mv = new ModelAndView("boletim/form");
            mv.addObject("usuarioList", usuarioList);
            mv.addObject("bairrosList", bairrosList);

        } catch (Exception e) {
            e.printStackTrace();//Criar retorno de erro.  
        }

        return mv;
    }

    @RequestMapping(value = "/boletim/novo", method = RequestMethod.POST)
    public ModelAndView create(TratamentoAntiVetorial boletimDiario) throws Exception {
        ModelAndView mv = null;
        try {
            ServiceLocator.getbaseBoletimDiarioService().create(boletimDiario);
            mv = new ModelAndView("redirect:/atividade/" + boletimDiario.getId());
        } catch (Exception e) {
        }

        return mv;
    }

    @RequestMapping(value = "/boletim/{id}/alterar", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable Long id) throws Exception {
        ModelAndView mv = null;
        List<Usuario> usuarioList = null;
        List<Bairro> bairrosList = null;
        TratamentoAntiVetorial boletimDiario = new TratamentoAntiVetorial();
        Map<String, Object> criteria = new HashMap<String, Object>();
        try {
            usuarioList = ServiceLocator.getBaseUsuarioService().readByCriteria(criteria);
            bairrosList = ServiceLocator.getBaseBairroService().readByCriteria(criteria);
            boletimDiario = ServiceLocator.getbaseBoletimDiarioService().readById(id);

            mv = new ModelAndView("boletim/form");
            mv.addObject("usuarioList", usuarioList);
            mv.addObject("bairrosList", bairrosList);
            mv.addObject("boletimDiario", boletimDiario);
        } catch (Exception e) {
        }

        return mv;
    }

    @RequestMapping(value = "/boletim/{id}/alterar", method = RequestMethod.POST)
    public ModelAndView update(TratamentoAntiVetorial boletimDiario) throws Exception {
        ModelAndView mv = null;
        try {

            ServiceLocator.getbaseBoletimDiarioService().update(boletimDiario);

            mv = new ModelAndView("redirect:/boletim");
        } catch (Exception e) {
        }

        return mv;
    }

    @RequestMapping(value = "/boletim/{id}/excluir", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable Long id) throws Exception {
        ModelAndView mv = null;
        List<Atividade> atividadeList = new ArrayList<Atividade>();
        Map<String, Object> criteria = new HashMap<String, Object>();

        try {
            criteria.put(AtividadeDAO.CRITERION_BOLETIM_ID_EQ, id);
            atividadeList = ServiceLocator.getbaseAtividadeService().readByCriteria(criteria);
            mv = new ModelAndView("redirect:/boletim");
            if (atividadeList == null) {

                ServiceLocator.getbaseBoletimDiarioService().delete(id);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mv;
    }
}
