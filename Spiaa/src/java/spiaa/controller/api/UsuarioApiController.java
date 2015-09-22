package spiaa.controller.api;

import com.google.gson.Gson;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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

   @RequestMapping(value = "/atualizar", method = RequestMethod.PUT)
   public @ResponseBody
   String update(Usuario agente, HttpServletResponse response) {
      String resposta;
      try {
         ServiceLocator.getBaseUsuarioService().update(agente);
         resposta = "{\"resposta\":success}";
         response.setStatus(200);
      } catch (Exception e) {
         resposta = null;
         response.setStatus(500);
      }
      return resposta;
   }

   @RequestMapping(value = "/login", method = RequestMethod.POST)
   public @ResponseBody
   String login(String nomeUsuario,String senha, HttpServletResponse response) {
      String resposta;
      try {
         Usuario agente = ServiceLocator.getBaseUsuarioService()
                 .login(nomeUsuario, senha);
         Gson gson = new Gson();
         resposta = gson.toJson(agente);
      } catch (Exception e) {
         resposta = null;
         response.setStatus(500);
      }
      return resposta;
   }
}
