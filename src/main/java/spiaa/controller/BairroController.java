package spiaa.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import spiaa.model.ServiceLocator;
import spiaa.model.dao.QuarteiraoDAO;
import spiaa.model.dao.UsuarioBairroDAO;
import spiaa.model.dao.UsuarioDAO;
import spiaa.model.entity.Bairro;
import spiaa.model.entity.Quarteirao;
import spiaa.model.entity.Usuario;
import spiaa.model.entity.UsuarioBairro;

@Controller
public class BairroController {

    @RequestMapping(value = "/bairro", method = RequestMethod.GET)
    public ModelAndView read() throws Exception {
        ModelAndView mv = null;
        try {
            List<Bairro> bairroList = new ArrayList<Bairro>();
            Map<String, Object> criteria = new HashMap<String, Object>();
            bairroList = ServiceLocator.getBaseBairroService().readByCriteria(criteria);
            mv = new ModelAndView("bairro/bairroList");
            mv.addObject("bairrolist", bairroList);
        } catch (Exception ex) {
            mv = new ModelAndView("erro/erro");
            mv.addObject("erro", ex);
        }
        return mv;
    }

    @RequestMapping(value = "/bairro/novo", method = RequestMethod.GET)
    public ModelAndView create() {
        ModelAndView mv = null;

        mv = new ModelAndView("bairro/bairroForm");
        return mv;
    }

    @RequestMapping(value = "/bairro/relatorio", method = RequestMethod.GET)
    public void relatorio() throws Exception {
        List<Bairro> bairroList = new ArrayList<Bairro>();
        Map<String, Object> criteria = new HashMap<String, Object>();
        bairroList = ServiceLocator.getBaseBairroService().readByCriteria(criteria);

        InputStream report = BairroController.class.getResourceAsStream("/spiaa/view/report/spiaaBairros.jasper");

        JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(bairroList));
        JasperExportManager.exportReportToPdfFile(print, "E:\\relat.pdf");

    }

    @RequestMapping(value = "bairro/{id}/alterar", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable Long id) throws Exception {
        Bairro bairro = ServiceLocator.getBaseBairroService().readById(id);
        ModelAndView mv = new ModelAndView("bairro/bairroForm");
        mv.addObject("bairro", bairro);
        return mv;
    }

    @RequestMapping(value = "bairro/alterar", method = RequestMethod.POST)
    @ResponseBody
    public String update(@RequestBody String jsonData) throws Exception {
        String retorno = "error";
        try {
            Gson gson = new Gson();
            Bairro bairro = gson.fromJson(jsonData, Bairro.class);
            ServiceLocator.getBaseBairroService().update(bairro);
            retorno = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retorno;
    }

    @RequestMapping(value = "bairro/{id}/bairrousuario", method = RequestMethod.GET)
    public ModelAndView readUsuario(@PathVariable Long id) throws Exception {
        ModelAndView mv = null;
        try {
            Bairro bairro = new Bairro();
            bairro = ServiceLocator.getBaseBairroService().readById(id);

            List<Usuario> agente = new ArrayList<Usuario>();
            Map<String, Object> criteria = new HashMap<String, Object>();
            criteria.put(UsuarioDAO.CRITERION_TIPO_EQ, UsuarioDAO.TIPO_AGENTE);
            agente = ServiceLocator.getBaseUsuarioService().readByCriteria(criteria);

            List<UsuarioBairro> usuarioBairroList = new ArrayList<>();
            Map<String, Object> criteriaBairro = new HashMap<String, Object>();
            criteriaBairro.put(UsuarioBairroDAO.CRITERION_BAIRRO_ID_EQ, id);
            usuarioBairroList = ServiceLocator.getbaseUsuarioBairroService().readByCriteria(criteriaBairro);
            mv = new ModelAndView("bairrousuario/bairroUsuarioForm");

            mv.addObject("agenteList", agente);
            mv.addObject("bairro", bairro);
            mv.addObject("usuarioBairroList", usuarioBairroList);

        } catch (Exception ex) {
            mv = new ModelAndView("erro/erro");
            mv.addObject("erro", ex);
        }
        return mv;
    }

    @RequestMapping(value = "bairro/bairrousuario/create", method = RequestMethod.POST)
    @ResponseBody
    public String saveByUsuario(@RequestBody String jsonData) throws Exception {
        String response = "error";
        try {
            Gson gson = new Gson();
            TypeToken<List<UsuarioBairro>> token = new TypeToken<List<UsuarioBairro>>() {
            };
            List<UsuarioBairro> usuarioBairroList = (List<UsuarioBairro>) gson.fromJson(jsonData, token.getType());

            ServiceLocator.getbaseUsuarioBairroService().createByBairro(usuarioBairroList);
            response = "Success";
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }

    @RequestMapping(value = "bairro/{id}/quarteirao", method = RequestMethod.GET)
    public ModelAndView read(@PathVariable Long id) throws Exception {
        ModelAndView mv;
        try {
            //Buscar quarteir√µes que correspondam apenas ao id do bairro espec√≠fico
            Map<String, Object> criteria = new HashMap<String, Object>();
            criteria.put(QuarteiraoDAO.CRITERION_BAIRRO_ID, id);
            List<Quarteirao> quarteiraoList = ServiceLocator.getbaseQuarteiraoService()
                    .readByCriteria(criteria);
            Bairro bairro = ServiceLocator.getBaseBairroService().readById(id);
            mv = new ModelAndView("bairro/bairroQuarteiraoList");
            mv.addObject("quarteiraoList", quarteiraoList);
            mv.addObject("bairro", bairro);
        } catch (Exception e) {
            mv = new ModelAndView("erro/erro");
            mv.addObject("e", e);
        }
        return mv;
    }

    @RequestMapping(value = "bairro/quarteirao/novo", method = RequestMethod.POST)
    @ResponseBody
    public String createQuarteirao(@RequestBody String jsonData
    ) {
        String response = "error";
        try {
            Gson gson = new Gson();
            Quarteirao quarteirao = gson.fromJson(jsonData, Quarteirao.class);
            String sigla = quarteirao.getDescricao();
            int qdt = quarteirao.getQuantidade();
            for (int i = 0; i < qdt; i++) {
                quarteirao.setDescricao(sigla + "-" + (i + 1));
                ServiceLocator.getbaseQuarteiraoService().create(quarteirao);
            }
            response = "success";

        } catch (Exception e) {
            if (e.getMessage().contains("duplicar valor da chave viola a restriÁ„o de unicidade")) {
                response = "Duplicated";
            }
            e.printStackTrace();
        }
        return response;
    }

    @RequestMapping(value = "bairro/quarteirao/alterar", method = RequestMethod.POST)
    @ResponseBody
    public String alterarQuarteirao(@RequestBody String jsonData
    ) {
        String response = "error";
        try {
            Gson gson = new Gson();
            Quarteirao quarteirao = gson.fromJson(jsonData, Quarteirao.class);
            ServiceLocator.getbaseQuarteiraoService().update(quarteirao);
            response = "success";
        } catch (Exception e) {
            if (e.getMessage().contains("duplicar valor da chave viola a restriÁ„o de unicidade")) {
                response = "Duplicated";
            }
            e.printStackTrace();
        }
        return response;
    }

    @RequestMapping(value = "bairro/quarteirao/excluir", method = RequestMethod.POST)
    @ResponseBody
    public String excluirQuarteirao(@RequestBody String jsonData
    ) {
        String response = "error";
        try {
            Gson gson = new Gson();
            Quarteirao quarteirao = gson.fromJson(jsonData, Quarteirao.class);
            ServiceLocator.getbaseQuarteiraoService().delete(quarteirao.getId());
            response = "success";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
