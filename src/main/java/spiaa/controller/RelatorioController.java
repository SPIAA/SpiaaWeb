/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiaa.controller;

import com.google.gson.Gson;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import spiaa.model.ServiceLocator;
import spiaa.model.entity.relatorio.ImoveisVisitadorPorAgentes;
import spiaa.util.GSONConverter;
import sun.misc.BASE64Encoder;

/**
 *
 * @author Felipe de Souza
 */
@Controller
public class RelatorioController {

    @RequestMapping(value = "/relatorio/imoveisagentes", method = RequestMethod.GET)
    public ModelAndView read() throws Exception {
        ModelAndView mv = null;
        try {
            Map<String, Object> criteria = new HashMap<String, Object>();
            mv = new ModelAndView("relatorio/imoveisagente");
        } catch (Exception ex) {
            mv = new ModelAndView("erro/erro");
            mv.addObject("erro", ex);
        }
        return mv;
    }

    @RequestMapping(value = "/relatorio/imoveisagentes", method = RequestMethod.POST)
    public ModelAndView read(@DateTimeFormat(pattern = "dd/MM/yyyy") Date dataInicial, @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataFinal) throws Exception {
        ModelAndView mv = null;

        try {
            List<ImoveisVisitadorPorAgentes> imoveisVisitadosList = new ArrayList<>();
            imoveisVisitadosList = ServiceLocator.getbaseRelatorioService().readImoveisVisitadorPorAgentes(dataInicial, dataFinal);

            mv = new ModelAndView("relatorio/imoveisagente");
            mv.addObject("imoveisVisitadosList", imoveisVisitadosList);
            mv.addObject("dataInicial", dataInicial);
            mv.addObject("dataFinal", dataFinal);
        } catch (Exception e) {
            mv = new ModelAndView("erro/erro");
            mv.addObject("erro", e);
        }
        return mv;
    }

    @RequestMapping(value = "/relatorio/imoveisagentespdf", method = RequestMethod.POST)
    @ResponseBody
    public String relatoriopdf(@RequestBody String jsonData) throws Exception {
        byte report[] = null;
        String base64 = "";
        try {
            Gson gson = new Gson();
            ImoveisVisitadorPorAgentes imoveisVisitados = (ImoveisVisitadorPorAgentes) GSONConverter.convert(jsonData, ImoveisVisitadorPorAgentes.class);

            List<ImoveisVisitadorPorAgentes> imoveisVisitadosList = new ArrayList<>();
            imoveisVisitadosList = ServiceLocator.getbaseRelatorioService().readImoveisVisitadorPorAgentes(imoveisVisitados.getDataInicial(), imoveisVisitados.getDataFinal());
            //O report Principal
            InputStream isReport = RelatorioController.class.getResourceAsStream("/imoveisVisitados.jasper");

            //Gerando o relatório
            JasperPrint print = JasperFillManager.fillReport(isReport, null, new JRBeanCollectionDataSource(imoveisVisitadosList));

            report = JasperExportManager.exportReportToPdf(print);
            BASE64Encoder base64Encoder = new BASE64Encoder();
            base64 = "data:application/pdf;base64,";
            base64 += base64Encoder.encode(report);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return base64;
    }

}
