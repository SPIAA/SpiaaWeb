package spiaa.controller.api;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
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
         Map<String, Object> criteria = new HashMap<>();
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
   String login(Usuario usuario) {
      String resposta;
      try {
         Usuario agente = ServiceLocator.getBaseUsuarioService()
                 .login(usuario.getUsuario(), usuario.getSenha());
         Gson gson = new Gson();
         resposta = gson.toJson(agente);
      } catch (Exception e) {
         resposta = null;
      }
      return resposta;
   }
}
