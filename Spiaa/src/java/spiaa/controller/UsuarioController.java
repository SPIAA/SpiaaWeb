package spiaa.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import spiaa.model.ServiceLocator;
import spiaa.model.entity.Usuario;

@Controller
public class UsuarioController {

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public ModelAndView login() {

        ModelAndView mv = new ModelAndView("login/form");

        return mv;
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView login(String usuario, String senha, HttpSession session) throws Exception {

        try {
            Usuario usuariologado = ServiceLocator.getBaseUsuarioService().login(usuario, senha);
            session.setAttribute("usuarioLogado", usuariologado);

        } catch (Exception e) {
        }

        ModelAndView mv = new ModelAndView("redirect:/liraa");

        return mv;
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:login";
    }
}
