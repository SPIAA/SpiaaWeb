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
import spiaa.model.dao.ConsolidacaoDadosDAO;
import spiaa.model.entity.ConsolidacaoCriadouro;
import spiaa.model.entity.ConsolidacaoDados;
import spiaa.model.entity.Criadouro;
import spiaa.model.entity.Estrato;
import spiaa.model.entity.Liraa;

@Controller
public class ConsolidacaoController {

    @RequestMapping(value = "/consolidacao/{id}", method = RequestMethod.GET)
    public ModelAndView listar(@PathVariable Long id) throws Exception {
        ModelAndView mv = null;

        Liraa liraa = new Liraa();
        List<Liraa> liraaList = new ArrayList<Liraa>();
        List<ConsolidacaoDados> consolidacaoDadosList = new ArrayList<ConsolidacaoDados>();
        Map<String, Object> criteria = new HashMap<String, Object>();
        criteria.put(ConsolidacaoDadosDAO.CRITERION_LIRAA_ID_EQ, id);
        liraa = ServiceLocator.getBaseLiraaService().readById(id);

        consolidacaoDadosList = ServiceLocator.getBaseConsolidacaoDadosService().readByCriteria(criteria);

        mv = new ModelAndView("consolidacao/listconsolidacao");

        liraaList.add(liraa);

        mv.addObject("liraa", liraa);
        mv.addObject("consolidacaoDadosList", consolidacaoDadosList);

        return mv;
    }

    @RequestMapping(value = "/consolidacao/{id}/novo", method = RequestMethod.GET)
    public ModelAndView create(@PathVariable Long id) throws Exception {
        ModelAndView mv = null;

        Liraa liraa = new Liraa();
        List<Estrato> estratoList = new ArrayList<Estrato>();
        List<Criadouro> criadouroList = new ArrayList<Criadouro>();
        Map<String, Object> criteria = new HashMap<String, Object>();
        ConsolidacaoDados consolidacaoDados = new ConsolidacaoDados();

        liraa = ServiceLocator.getBaseLiraaService().readById(id);

        estratoList = ServiceLocator.getBaseEstratoService().readByCriteria(criteria);
        criadouroList = ServiceLocator.getBaseCriadouroService().readByCriteria(criteria);
        consolidacaoDados.setLiraa(liraa);

        mv = new ModelAndView("consolidacao/form");
        mv.addObject("consolidacaoDados", consolidacaoDados);
        mv.addObject("estratoList", estratoList);
        mv.addObject("criadouroList", criadouroList);

        return mv;
    }

    @RequestMapping(value = "/consolidacao/{id}/novo", method = RequestMethod.POST)
    public ModelAndView create(ConsolidacaoDados consolidacaoDados, HttpServletRequest request) {
        String criadouroVetor[] = request.getParameterValues("criadouro");
        String qtdeVetor[] = request.getParameterValues("qdte");
        ModelAndView mv = null;
        Criadouro criadouro = null;
        try {
            List<ConsolidacaoCriadouro> consolidacaoCriadouroList = new ArrayList<ConsolidacaoCriadouro>();

            ConsolidacaoCriadouro consolidacaoCriadouro = null;
            for (int i = 0; i < criadouroVetor.length; i++) {
                criadouro = new Criadouro();

                criadouro.setId(Long.parseLong(criadouroVetor[i]));

                consolidacaoCriadouro = new ConsolidacaoCriadouro();
                consolidacaoCriadouro.setCriadouro(criadouro);
                if (!qtdeVetor[i].isEmpty()) {
                    consolidacaoCriadouro.setQuantidade(Integer.parseInt(qtdeVetor[i]));
                } else {
                    consolidacaoCriadouro.setQuantidade(0);
                }

                consolidacaoCriadouroList.add(consolidacaoCriadouro);
            }
            consolidacaoDados.setConsolidacaoCriadouroList(consolidacaoCriadouroList);
            ServiceLocator.getBaseConsolidacaoDadosService().create(consolidacaoDados);
            mv = new ModelAndView("redirect:/consolidacao/" + consolidacaoDados.getLiraa().getId());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mv;
    }

    @RequestMapping(value = "/consolidacao/{id}/alterar", method = RequestMethod.GET)
    public ModelAndView alterar(@PathVariable Long id, HttpServletRequest request) {
        ModelAndView mv = null;
        ConsolidacaoDados consolidacaoDados = null;
        List<Estrato> estratoList = new ArrayList<Estrato>();
        Map<String, Object> criteria = new HashMap<String, Object>();
        List<Criadouro> criadouroList = new ArrayList<Criadouro>();
        try {

            consolidacaoDados = new ConsolidacaoDados();
            consolidacaoDados = ServiceLocator.getBaseConsolidacaoDadosService().readById(id);
            //buscando estrato
            estratoList = ServiceLocator.getBaseEstratoService().readByCriteria(criteria);
            //buscando criadouros
            criadouroList = ServiceLocator.getBaseCriadouroService().readByCriteria(criteria);

            mv = new ModelAndView("consolidacao/form");
            mv.addObject("consolidacaoDados", consolidacaoDados);
            mv.addObject("estratoList", estratoList);
            mv.addObject("criadouroList", criadouroList);

        } catch (Exception e) {

        }

        return mv;

    }

    @RequestMapping(value = "/consolidacao/{id}/alterar", method = RequestMethod.POST)
    public ModelAndView alterar(ConsolidacaoDados consolidacaoDados, HttpServletRequest request) {
        String criadouroVetor[] = request.getParameterValues("criadouro");
        String qtdeVetor[] = request.getParameterValues("qdte");
        ModelAndView mv = null;
        Criadouro criadouro = null;
        try {

            List<ConsolidacaoCriadouro> consolidacaoCriadouroList = new ArrayList<ConsolidacaoCriadouro>();

            ConsolidacaoCriadouro consolidacaoCriadouro = null;
            for (int i = 0; i < criadouroVetor.length; i++) {
                criadouro = new Criadouro();
                criadouro.setId(Long.parseLong(criadouroVetor[i]));

                consolidacaoCriadouro = new ConsolidacaoCriadouro();
                consolidacaoCriadouro.setCriadouro(criadouro);
                if (!qtdeVetor[i].isEmpty()) {
                    consolidacaoCriadouro.setQuantidade(Integer.parseInt(qtdeVetor[i]));
                } else {
                    consolidacaoCriadouro.setQuantidade(0);
                }

                consolidacaoCriadouroList.add(consolidacaoCriadouro);
            }
            consolidacaoDados.setConsolidacaoCriadouroList(consolidacaoCriadouroList);
            ServiceLocator.getBaseConsolidacaoDadosService().update(consolidacaoDados);
            mv = new ModelAndView("redirect:/consolidacao/" + consolidacaoDados.getLiraa().getId());

        } catch (Exception e) {

        }

        return mv;

    }
    
     @RequestMapping(value = "/consolidacao/{id}/excluir", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable Long id, String boletimId) throws Exception {
        ModelAndView mv = null;
        try {
            ConsolidacaoDados consolidacaoDados = ServiceLocator.getBaseConsolidacaoDadosService().readById(id);
            ServiceLocator.getBaseConsolidacaoDadosService().delete(id);
            
            mv = new ModelAndView("redirect:/consolidacao/" + consolidacaoDados.getLiraa().getId());
            
        } catch (Exception e) {
        }
        return mv;
    }
}
