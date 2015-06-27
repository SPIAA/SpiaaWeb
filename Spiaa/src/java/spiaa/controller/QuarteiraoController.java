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
    * @return
    *
    */
   @RequestMapping(value = "/quarteirao", method = RequestMethod.GET)
   public ModelAndView read() {
      ModelAndView mv;
      try {
         List<Quarteirao> quarteiaoList = ServiceLocator.getbaseQuarteiraoService()
                 .readByCriteria(new HashMap<String, Object>());
         mv = new ModelAndView("quarteirao/list");
         mv.addObject("quarteiraoList", quarteiaoList);
      } catch (Exception e) {
         mv = new ModelAndView("erro/erro");
         mv.addObject("e", e);
      }

      return mv;
   }

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
    *
    * @return
    *
    * @throws java.lang.Exception
    *
    */
   @RequestMapping(value = "/quarteirao/novo", method = RequestMethod.GET)
   public ModelAndView create() throws Exception {
      ModelAndView mv;
      try {
         List<Bairro> bairroList = ServiceLocator.getBaseBairroService()
                 .readByCriteria(new HashMap<String, Object>());
         mv = new ModelAndView("quarteirao/form");
         mv.addObject("bairroList", bairroList);
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
    * @param quantidade
    *
    * @return
    */
   @RequestMapping(value = "/quarteirao/novo", method = RequestMethod.POST)
   public ModelAndView create(Quarteirao quarteirao, int quantidade) {
      ModelAndView mv;

      try {
         String sigla = quarteirao.getDescricao();
         for (int i = 0; i < quantidade; i++) {
            quarteirao.setDescricao(sigla + "-" + (i + 1));
            ServiceLocator.getbaseQuarteiraoService().create(quarteirao);
         }
         mv = new ModelAndView("redirect:/quarteirao");
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
    *
    * @return
    *
    * @throws Exception
    */
   @RequestMapping(value = "/quarteirao/{id}/alterar", method = RequestMethod.GET)
   public ModelAndView update(@PathVariable Long id) throws Exception {
      ModelAndView mv;
      try {
         Quarteirao quarteirao = ServiceLocator.getbaseQuarteiraoService().readById(id);
         List<Bairro> bairroList = ServiceLocator.getBaseBairroService()
                 .readByCriteria(new HashMap<String, Object>());
         mv = new ModelAndView("quarteirao/form");
         mv.addObject("quarteirao", quarteirao);
         mv.addObject("bairroList", bairroList);
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
    *
    * @return
    */
   @RequestMapping(value = "/quarteirao/{id}/alterar", method = RequestMethod.POST)
   public ModelAndView update(Quarteirao quarteirao) {
      ModelAndView mv;
      try {
         ServiceLocator.getbaseQuarteiraoService().update(quarteirao);
         mv = new ModelAndView("redirect:/quarteirao");
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
    *
    * @return
    */
   @RequestMapping(value = "/quarteirao/{id}/excluir", method = RequestMethod.GET)
   public ModelAndView delete(@PathVariable Long id) {
      ModelAndView mv;
      try {
         ServiceLocator.getbaseQuarteiraoService().delete(id);
         mv = new ModelAndView("redirect:/quarteirao");
      } catch (Exception e) {
         mv = new ModelAndView("erro/erro");
         mv.addObject("e", e);
      }
      return mv;
   }

}
