package spiaa.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import spiaa.model.ServiceLocator;
import spiaa.model.dao.QuarteiraoDAO;
import spiaa.model.entity.Bairro;
import spiaa.model.entity.Quarteirao;

/**
 *
 * @author William
 */
@Controller
public class QuarteiraoController {

  /**
   * LISTAGEM DOS QUARTEIRÕES DO BAIRRO
   *
   * @param bairroID
   * @return
   * @throws java.lang.Exception
   *
   */
  @RequestMapping(value = "/quarteirao/{bairroID}", method = RequestMethod.GET)
  public ModelAndView read(@PathVariable Long bairroID) throws Exception {
    ModelAndView mv;
    try {
      //Buscar quarteirões que correspondam apenas ao id do bairro específico
      Map<String, Object> criteria = new HashMap<String, Object>();
      criteria.put(QuarteiraoDAO.CRITERION_BAIRRO_ID, bairroID);
      List<Quarteirao> quarteiraoList = ServiceLocator.getbaseQuarteiraoService()
              .readByCriteria(criteria);
      mv = new ModelAndView("quarteirao/list");
      mv.addObject("quarteiraoList", quarteiraoList);
      mv.addObject("bairroID", bairroID);
    } catch (Exception e) {
      mv = new ModelAndView("erro/erro");
      mv.addObject("e", e);
    }
    return mv;
  }

  /**
   * OBTÉM FORMULÁRIO DE CADASTRO DE QUARTEIRÃO
   *
   * @param id
   * @return
   * @throws java.lang.Exception
   *
   */
  @RequestMapping(value = "/quarteirao/novo/{id}", method = RequestMethod.GET)
  public ModelAndView create(@PathVariable Long id) throws Exception {
    ModelAndView mv;
    try {
      Bairro bairro = ServiceLocator.getBaseBairroService().readById(id);
      mv = new ModelAndView("quarteirao/form");
      mv.addObject("bairroID", bairro.getId());
    } catch (Exception e) {
      mv = new ModelAndView("erro/erro");
      mv.addObject("e", e);
    }
    return mv;
  }

  /**
   * CADASTRA UM NOVO QUARTEIRÃO
   *
   * @param quarteirao
   * @param id
   * @return
   */
  @RequestMapping(value = "/quarteirao/novo/{id}", method = RequestMethod.POST)
  public ModelAndView create(Quarteirao quarteirao, @PathVariable Long id) {
    ModelAndView mv;

    try {
      Bairro bairro = new Bairro();
      bairro.setId(id);
      quarteirao.setBairro(bairro);
      ServiceLocator.getbaseQuarteiraoService().create(quarteirao);
      mv = new ModelAndView("redirect:/quarteirao/" + id);
    } catch (Exception e) {
      mv = new ModelAndView("erro/erro");
      mv.addObject("e", e);
    }
    return mv;
  }

  /**
   * OBTÉM FORMULÁRIO PARA ATUALIZAÇÃO DOS DADOS DO QUARTEIRÃO
   *
   * @param id
   * @param bairroID
   * @return
   * @throws Exception
   */
  @RequestMapping(value = "/quarteirao/{id}/bairro-{bairroID}/alterar", method = RequestMethod.GET)
  public ModelAndView update(@PathVariable Long id, @PathVariable Long bairroID) throws Exception {
    ModelAndView mv;
    try {
      Quarteirao quarteirao = ServiceLocator.getbaseQuarteiraoService().readById(id);
      mv = new ModelAndView("quarteirao/form");
      mv.addObject("quarteirao", quarteirao);
    } catch (Exception e) {
      mv = new ModelAndView("erro/erro");
      mv.addObject("e", e);
    }
    return mv;
  }

  /**
   * ATUALIZA DADOS DO QUARTEIRÃO
   *
   * @param quarteirao
   * @param id
   * @param bairroID
   * @return
   */
  @RequestMapping(value = "/quarteirao/{id}/bairro-{bairroID}/alterar", method = RequestMethod.POST)
  public ModelAndView update(Quarteirao quarteirao, @PathVariable Long id, @PathVariable Long bairroID) {
    ModelAndView mv;
    try {
      Bairro bairro = new Bairro();
      bairro.setId(bairroID);
      quarteirao.setBairro(bairro);
      ServiceLocator.getbaseQuarteiraoService().update(quarteirao);
      mv = new ModelAndView("redirect:/quarteirao/" + bairroID);
    } catch (Exception e) {
      mv = new ModelAndView("erro/erro");
      mv.addObject("e", e);
    }

    return mv;
  }

  /**
   * EXCLUI QUARTEIRÃO
   *
   * @param id
   * @param bairro
   * @return
   */
  @RequestMapping(value = "/quarteirao/{id}/bairro-{bairro}/excluir", method = RequestMethod.GET)
  public ModelAndView delete(@PathVariable Long id, @PathVariable Long bairro) {
    ModelAndView mv;
    try {
      ServiceLocator.getbaseQuarteiraoService().delete(id);
      mv = new ModelAndView("redirect:/quarteirao/" + bairro);
    } catch (Exception e) {
      mv = new ModelAndView("erro/erro");
      mv.addObject("e", e);
    }
    return mv;
  }

}
