package spiaa.controller;

import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import spiaa.model.ServiceLocator;
import spiaa.model.dao.UsuarioBairroDAO;
import spiaa.model.entity.Bairro;
import spiaa.model.entity.Denuncia;
import spiaa.model.entity.Usuario;
import spiaa.model.entity.UsuarioBairro;

@Controller
public class DenunciaController {

    @RequestMapping(value = "/denunciaform", method = RequestMethod.GET)
    @ResponseBody
    public List<Bairro> novo() throws Exception {

        List<Bairro> bairroList = new ArrayList<Bairro>();
        Map<String, Object> criteria = new HashMap<String, Object>();
        bairroList = ServiceLocator.getBaseBairroService().readByCriteria(criteria);

        return bairroList;
    }

    @RequestMapping(value = "/denunciaform", method = RequestMethod.POST)
    @ResponseBody
    public String novo(@RequestBody String jsonData) {
        String retorno = "error";
        try {
            Gson gson = new Gson();
            Denuncia denuncia = gson.fromJson(jsonData, Denuncia.class);
            ServiceLocator.getbaseDenunciaService().create(denuncia);
            retorno = "success";
        } catch (Exception e) {
            retorno = "error";
            e.printStackTrace();
        }

        return retorno;
    }

    @RequestMapping(value = "/denuncia/list", method = RequestMethod.GET)
    public ModelAndView listarAdm() {
        ModelAndView mv = null;
        try {
            List<Denuncia> denunciaList = new ArrayList<Denuncia>();
            Map<String, Object> criteria = new HashMap<String, Object>();
            denunciaList = ServiceLocator.getbaseDenunciaService().readByCriteria(criteria);
            mv = new ModelAndView("redirect:/home");

        } catch (Exception e) {
        }

        return mv;
    }

    @RequestMapping(value = "/denuncia", method = RequestMethod.GET)
    public ModelAndView Listar() throws Exception {
        ModelAndView mv = null;

        List<Denuncia> denunciaList = new ArrayList<Denuncia>();
        Map<String, Object> criteria = new HashMap<String, Object>();
        denunciaList = ServiceLocator.getbaseDenunciaService().readByCriteria(criteria);

        mv = new ModelAndView("denuncia/denunciaList");
        mv.addObject("denunciaList", denunciaList);

        return mv;
    }

    @RequestMapping(value = "/denuncia/{id}/visualiza", method = RequestMethod.GET)
    public ModelAndView visualizar(@PathVariable Long id) throws Exception {
        ModelAndView mv = null;

        Denuncia denuncia = new Denuncia();

        denuncia = ServiceLocator.getbaseDenunciaService().readById(id);
        List<Usuario> usuarioList = new ArrayList<>();

        List<UsuarioBairro> usuarioBairroList = new ArrayList<>();
        Map<String, Object> criteriaUsuarioBairro = new HashMap<>();
        criteriaUsuarioBairro.put(UsuarioBairroDAO.CRITERION_BAIRRO_ID_EQ, denuncia.getBairro().getId());
        usuarioBairroList = ServiceLocator.getbaseUsuarioBairroService().readByCriteria(criteriaUsuarioBairro);

        for (UsuarioBairro ub : usuarioBairroList) {
            Usuario usuario = new Usuario();
            usuario.setId(ub.getUsuario().getId());
            usuario.setNome(ub.getUsuario().getNome());
            usuarioList.add(usuario);
        }

        mv = new ModelAndView("denuncia/denunciaView");
        mv.addObject("denuncia", denuncia);
        mv.addObject("usuario", usuarioList);

        return mv;
    }

    @RequestMapping(value = "/denuncia/visualiza", method = RequestMethod.POST)
    @ResponseBody
    public String visualizar(@RequestBody String jsonData) throws Exception {
        String retorno = "error";
        try {
            Gson gson = new Gson();
            Denuncia denuncia = gson.fromJson(jsonData, Denuncia.class);
            ServiceLocator.getbaseDenunciaService().update(denuncia);
            retorno = "success";
        } catch (Exception e) {
            retorno = "retorno";
        }
        return retorno;
    }
}
