/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiaa.controller.api;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spiaa.model.ServiceLocator;
import spiaa.model.entity.Usuario;

/**
 *
 * @author William
 */
@Controller
@RequestMapping(value = "/agente")
public class UsuarioApiController {

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    String getAgente() {
        String resposta;
        try {
            Map<String, Object> criteria = new HashMap<String, Object>();
            List<Usuario> usuarios = ServiceLocator.getBaseUsuarioService().readByCriteria(criteria);
            Usuario usuario = usuarios.get(0);
            Gson gson = new Gson();
            resposta = gson.toJson(usuario);
        } catch (Exception e) {
            resposta = null;
        }
        return resposta;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public @ResponseBody
    Usuario login(@RequestBody Usuario usuario) {
        String resposta;
        Usuario agente = null;
        try {
            agente = ServiceLocator.getBaseUsuarioService()
                    .login(usuario.getUsuario(), usuario.getSenha());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return agente;
    }

    @RequestMapping(value = "/login/list", method = RequestMethod.POST)
    public @ResponseBody
    String loginList(@RequestBody List<Usuario> usuarioList) {
        String resposta = "SUCCESS";
        Usuario agente = null;
        try {
        } catch (Exception e) {
            resposta = "ERROR";
            e.printStackTrace();
        }
        return resposta;
    }

}
