
package spiaa.controller.api;

import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;
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

   @RequestMapping(value = "/login", method = RequestMethod.POST)
   public @ResponseBody
   Usuario login(@RequestBody Usuario agenteSaude, HttpServletResponse response) {
      Usuario agente = null;
      try {
         agente = ServiceLocator.getbaseAgenteSaudeService()
                 .login(agenteSaude.getUsuario(), agenteSaude.getSenha());
         response.setStatus(200);
                 
      } catch (Exception e) {
         response.setStatus(500);
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
