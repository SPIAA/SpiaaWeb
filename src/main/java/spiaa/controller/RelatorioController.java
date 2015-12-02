/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiaa.controller;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import spiaa.model.ServiceLocator;
import spiaa.model.entity.relatorio.ImoveisVisitadorPorAgentes;

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
    public void readaaa(@DateTimeFormat(pattern = "dd/MM/yyyy") Date dataInicial, @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataFinal, HttpServletResponse response) throws Exception {
        ModelAndView mv = null;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dataIn = sdf.format(dataInicial);
        String dataFin = sdf.format(dataFinal);

        HashMap parameters = new HashMap<String, Object>();
        parameters.put("periodo", dataIn + " a " + dataFin);

        List<ImoveisVisitadorPorAgentes> imoveisVisitadosList = new ArrayList<>();
        imoveisVisitadosList = ServiceLocator.getbaseRelatorioService().readImoveisVisitadorPorAgentes(dataInicial, dataFinal);
        InputStream isReport = RelatorioController.class.getResourceAsStream("/imoveisVisitados.jasper");

        //Gerando o relatório
        JasperPrint print = JasperFillManager.fillReport(isReport, parameters, new JRBeanCollectionDataSource(imoveisVisitadosList));

        byte[] pdf = JasperExportManager.exportReportToPdf(print);

        response.setContentType("application/pdf");
        response.getOutputStream().write(pdf);
        response.flushBuffer();

//        return mv;
    }
}
