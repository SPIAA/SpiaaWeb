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
import spiaa.model.entity.Bairro;
import spiaa.model.entity.BairroEstrato;
import spiaa.model.entity.Estrato;

@Controller
public class EstratoBairroController {

    @RequestMapping(value = "estratobairro/{id}", method = RequestMethod.GET)
    public ModelAndView create(@PathVariable Long id) {

        ModelAndView mv = null;
        Estrato estrato = null;
        List<Bairro> bairroList = new ArrayList<Bairro>();
        Map<String, Object> criteria = new HashMap<String, Object>();
        try {
      
                estrato = new Estrato();
                estrato = ServiceLocator.getBaseEstratoService().readById(id);
                bairroList = ServiceLocator.getBaseBairroService().readByCriteria(criteria);
                mv = new ModelAndView("estratobairro/list");
                mv.addObject("estrato", estrato);
                mv.addObject("bairroList", bairroList);
            

        } catch (Exception e) {
        }
        return mv;
    }

    @RequestMapping(value = "estratobairro/{id}", method = RequestMethod.POST)
    public ModelAndView create(Estrato estrato, HttpServletRequest request) {
        ModelAndView mv = null;
        Bairro bairro = null;
        BairroEstrato bairroEstrato = null;
        List<BairroEstrato> bairroEstratolist = new ArrayList<BairroEstrato>();
        Map<String, Object> criteria = new HashMap<String, Object>();
        String bairros[] = request.getParameterValues("bairro");
        String codigo[] = request.getParameterValues("codigo");
        String armazem[] = request.getParameterValues("armazem");
        String residencia[] = request.getParameterValues("residencia");
        String imoveis[] = request.getParameterValues("imoveis");
        String comercio[] = request.getParameterValues("comercio");
        String predio[] = request.getParameterValues("predio");
        String terrenobaldio[] = request.getParameterValues("terrenobaldio");
        String habitantes[] = request.getParameterValues("habitantes");
        String outros[] = request.getParameterValues("outros");

        try {
            for (int i = 0; i < bairros.length; i++) {
                bairro = new Bairro();
                bairro.setId(Long.parseLong(bairros[i]));

                bairroEstrato = new BairroEstrato();
                bairroEstrato.setCodigo(Integer.parseInt(codigo[i]));
                bairroEstrato.setArmazem(Integer.parseInt(armazem[i]));
                bairroEstrato.setResidencia(Integer.parseInt(residencia[i]));
                bairroEstrato.setImovel(Integer.parseInt(imoveis[i]));
                bairroEstrato.setComercio(Integer.parseInt(comercio[i]));
                bairroEstrato.setPredio(Integer.parseInt(predio[i]));
                bairroEstrato.setTerrenoBaldio(Integer.parseInt(terrenobaldio[i]));
                bairroEstrato.setHabitante(Integer.parseInt(habitantes[i]));
                bairroEstrato.setOutros(Integer.parseInt(outros[i]));

                bairroEstrato.setBairro(bairro);
                if (bairroEstrato.getCodigo() == null) {
                    bairroEstrato.setCodigo(0);
                }
                if ((bairroEstrato.getArmazem() == null)) {
                    bairroEstrato.setArmazem(0);
                }
                if ((bairroEstrato.getResidencia() == null)) {
                    bairroEstrato.setResidencia(0);
                }
                if ((bairroEstrato.getImovel() == null)) {
                    bairroEstrato.setImovel(0);
                }
                if ((bairroEstrato.getComercio() == null)) {
                    bairroEstrato.setComercio(0);
                }
                if ((bairroEstrato.getPredio() == null)) {
                    bairroEstrato.setPredio(0);
                }
                if ((bairroEstrato.getTerrenoBaldio() == null)) {
                    bairroEstrato.setTerrenoBaldio(0);
                }
                if ((bairroEstrato.getHabitante() == null)) {
                    bairroEstrato.setHabitante(0);
                }
                if ((bairroEstrato.getOutros() == null)) {
                    bairroEstrato.setOutros(0);
                }

                bairroEstratolist.add(bairroEstrato);
            }

            estrato.setBairroEstratoList(bairroEstratolist);
            ServiceLocator.getBaseEstratoService().update(estrato);
            mv = new ModelAndView("redirect:/estrato");

        } catch (Exception e) {
        }
        return mv;
    }
}
