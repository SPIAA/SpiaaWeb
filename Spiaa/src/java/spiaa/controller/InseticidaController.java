/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiaa.controller;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import spiaa.model.ServiceLocator;
import spiaa.model.entity.Inseticida;

@Controller
public class InseticidaController {

    @RequestMapping(value = "/inseticida", method = RequestMethod.GET)
    public ModelAndView listar(String mensagem) throws Exception {

        List<Inseticida> inseticidaList = new ArrayList<Inseticida>();
        Map<String, Object> criteria = new HashMap<String, Object>();
        inseticidaList = ServiceLocator.getbaseInseticidaService().readByCriteria(criteria);
        ModelAndView mv = new ModelAndView("inseticida/inseticidaList");
        mv.addObject("inseticidaList", inseticidaList);
        mv.addObject("mensagem", mensagem);

        return mv;
    }

    @RequestMapping(value = "/inseticida/novo", method = RequestMethod.GET)
    public ModelAndView novo() {
        ModelAndView mv = null;
        try {
            mv = new ModelAndView("inseticida/inseticidaForm");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mv;
    }

    @RequestMapping(value = "/inseticida/novo", method = RequestMethod.POST)
    @ResponseBody
    public String teste(@RequestBody String jsonData, HttpServletResponse response) throws Exception {
        String retorno = "error";
        try {
            Gson gson = new Gson();
            Inseticida inseticida = gson.fromJson(jsonData, Inseticida.class);
            ServiceLocator.getbaseInseticidaService().create(inseticida);
            retorno = "success";
            response.setStatus(200);
        } catch (Exception e) {
            response.setStatus(500);
        }
        return retorno;
    }

    @RequestMapping(value = "/inseticida/{id}/atualizar", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable Long id) throws Exception {
        Inseticida inseticida = ServiceLocator.getbaseInseticidaService().readById(id);
        ModelAndView mv = new ModelAndView("inseticida/inseticidaForm");
        mv.addObject("inseticida", inseticida);

        return mv;
    }

    @RequestMapping(value = "/inseticida/atualizar", method = RequestMethod.POST)
    @ResponseBody
    public String update(@RequestBody String jsonData, HttpServletResponse response) throws Exception {
        String retorno = "error";
        try {
            Gson gson = new Gson();
            Inseticida inseticida = gson.fromJson(jsonData, Inseticida.class);
            ServiceLocator.getbaseInseticidaService().update(inseticida);
            retorno = "success";
            response.setStatus(200);
        } catch (Exception e) {
            response.setStatus(500);
        }
        return retorno;
    }

    @RequestMapping(value = "/inseticida/{id}/deletar", method = RequestMethod.GET)
    public ModelAndView deletar(@PathVariable Long id) throws Exception {
        ModelAndView mv = new ModelAndView("inseticida/inseticidaForm");
        try {
            ServiceLocator.getbaseInseticidaService().delete(id);
            mv = new ModelAndView("redirect:/inseticida");
        } catch (Exception e) {
            mv.addObject("mensagem", "Houve alguma falha ao deletar o Inseticida. Por favor tente novamente.");
            e.printStackTrace();
        }

        return mv;
    }

}
