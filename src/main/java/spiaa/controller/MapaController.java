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
import spiaa.model.dao.AtividadeDAO;
import spiaa.model.entity.Atividade;
import spiaa.model.entity.Bairro;
import spiaa.model.entity.Criadouro;
import spiaa.model.entity.Estrato;

@Controller
public class MapaController {

    @RequestMapping(value = "/mapa", method = RequestMethod.GET)
    public ModelAndView novo() throws Exception {

        ModelAndView mv = new ModelAndView("mapa/mapa_1");
        List<Estrato> estratoList = new ArrayList<Estrato>();
        List<Estrato> estratos = new ArrayList<Estrato>();
        List<Criadouro> criadouroList = new ArrayList<>();
        Map<String, Object> criteria = new HashMap<String, Object>();
        estratoList = ServiceLocator.getBaseEstratoService().readByCriteria(criteria);
        estratos = ServiceLocator.getBaseEstratoService().readAll();
        criadouroList = ServiceLocator.getBaseCriadouroService().readByCriteria(criteria);
        mv.addObject("criadouroList", criadouroList);
        mv.addObject("estratoList", estratoList);
        mv.addObject("estratos", estratos);
        mv.addObject("corEstrato", estratos);
        mv.addObject("totalCriadouro", criadouroList);

        return mv;
    }

    @RequestMapping(value = "/mapa/admin", method = RequestMethod.GET)
    public ModelAndView mapaAdministrativo() throws Exception {
        ModelAndView mv = null;
        try {
            List<Bairro> bairroList = new ArrayList<>();
            Map<String, Object> criteriaBairro = new HashMap<String, Object>();
            bairroList = ServiceLocator.getBaseBairroService().readByCriteria(criteriaBairro);
            mv = new ModelAndView("mapa/list");
            mv.addObject("bairroList", bairroList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mv;
    }

    @RequestMapping(value = "/mapa/visualizarMapaAdministrador", method = RequestMethod.POST)
    public ModelAndView visualizaMapa(String bairro_id) throws Exception {
        ModelAndView mv = null;
        List<Atividade> atividadeList = new ArrayList<Atividade>();
        List<Bairro> bairroList = new ArrayList<>();
        try {
            Map<String, Object> criteriaAtividade = new HashMap<String, Object>();
            Map<String, Object> criteriaBairro = new HashMap<String, Object>();
            if (bairro_id != null && !bairro_id.trim().isEmpty()) {
                Bairro bairro = new Bairro();
                Long id = Long.parseLong(bairro_id);
                bairro = ServiceLocator.getBaseBairroService().readById(id);
                bairroList.add(bairro);
                criteriaAtividade.put(AtividadeDAO.CRITERION_BAIRRO_ID_EQ, Long.getLong(bairro_id));
            } else {
                bairroList = ServiceLocator.getBaseBairroService().readByCriteria(criteriaBairro);
            }

            criteriaAtividade.put(AtividadeDAO.CRITERION_LAT_LNG_OK, "1");
            atividadeList = ServiceLocator.getbaseAtividadeService().readByCriteria(criteriaAtividade);

            mv = new ModelAndView("mapa/mapaAdministrativoView");
            mv.addObject("atividadeList", atividadeList);
            mv.addObject("bairroList", bairroList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mv;
    }
}
