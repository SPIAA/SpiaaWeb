package spiaa.controller;

import com.google.gson.Gson;
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
import spiaa.model.entity.Bairro;

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
    
     @RequestMapping(value = "/bairro/{id}/alterar", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable Long id) throws Exception {
        Bairro criadouro = ServiceLocator.getBaseBairroService().readById(id);
        ModelAndView mv = new ModelAndView("criadouro/criadouroForm");
        mv.addObject("criadouro", criadouro);

        return mv;
    }
    
    @RequestMapping(value = "/bairro/alterar", method = RequestMethod.POST)
    @ResponseBody
    public String update(@RequestBody String jsonData, HttpServletResponse response) throws Exception {
        String retorno = "error";
        try {
            Gson gson = new Gson();
            Bairro bairro = gson.fromJson(jsonData, Bairro.class);
            ServiceLocator.getBaseBairroService().update(bairro);
            retorno = "success";
            response.setStatus(200);
        } catch (Exception e) {
            response.setStatus(500);
        }
        return retorno;
    }

    
}
