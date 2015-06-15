package spiaa.controller;

import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
        ModelAndView mv = null;
        try {
            Usuario usuariologado = ServiceLocator.getBaseUsuarioService()
                    .login(usuario, senha);
            session.setAttribute("usuarioLogado", usuariologado);
            mv = new ModelAndView("redirect:/liraa");
        } catch (Exception e) {
            mv = new ModelAndView("erro/erro");
            mv.addObject("erro", e.getCause());
        }
        return mv;
    }

    @RequestMapping(value = "/usuario", method = RequestMethod.GET)
    public ModelAndView read() throws Exception {
        ModelAndView mv;
        try {
            List<Usuario> usuarioList = ServiceLocator.getBaseUsuarioService()
                    .readByCriteria(new HashMap<String, Object>());
            mv = new ModelAndView("usuario/list");
            mv.addObject("usuario", usuarioList);
        } catch (Exception ex) {
            mv = new ModelAndView("erro");
            mv.addObject("erro", ex);
        }
        return mv;
    }

    @RequestMapping(value = "/usuario/novo", method = RequestMethod.GET)
    public ModelAndView create() throws Exception {
        ModelAndView mv;
        try {

            mv = new ModelAndView("usuario/form");

        } catch (Exception e) {
            mv = new ModelAndView("erro/erro");
            mv.addObject("erro", e.getCause());
        }
        return mv;
    }

    @RequestMapping(value = "/usuario/novo", method = RequestMethod.POST)
    public ModelAndView create(Usuario usuario, String confirmaSenha) throws Exception {
        ModelAndView mv = null;
        try {
            List<Usuario> usuarioList = null;
            if (usuario.getSenha().equals(confirmaSenha)) {
                ServiceLocator.getBaseUsuarioService().create(usuario);
                mv = new ModelAndView("redirect:/usuario");
                mv.addObject("usuarioList", usuarioList);
            } else {
                mv = new ModelAndView("usuario/form");
                mv.addObject("mensagem", "Senhas não conferem");
                mv.addObject("usuario", usuario);
            }

        } catch (Exception e) {
            mv = new ModelAndView("erro/erro");
            mv.addObject("erro", e.getCause());
        }
        return mv;
    }

    @RequestMapping(value = "/usuario/{id}/excluir", method = RequestMethod.GET)
    public ModelAndView delete(HttpSession session, @PathVariable Long id) throws Exception {
        Usuario u = (Usuario) session.getAttribute("usuarioLogado");
        ModelAndView mv;
        if (!id.equals(u.getId())) {//Não deixa excluir se estiver logado
            try {
                ServiceLocator.getBaseUsuarioService().delete(id);
                mv = new ModelAndView("redirect:/usuario");

            } catch (Exception e) {
                mv = new ModelAndView("erro/erro");
                mv.addObject("erro", e.getCause());
            }
            return mv;
        }
        return new ModelAndView("redirect:/usuario");
    }

    @RequestMapping(value = "/usuario/{id}/atualizar", method = RequestMethod.GET)
    public ModelAndView update(@PathVariable Long id) throws Exception {
        Usuario user = ServiceLocator.getBaseUsuarioService().readById(id);
        ModelAndView mv = new ModelAndView("usuario/form");
        mv.addObject("usuario", user);
        return mv;
    }

    @RequestMapping(value = "/usuario/{id}/atualizar", method = RequestMethod.POST)
    public ModelAndView update(HttpSession session, Usuario usuario) throws Exception {
        ModelAndView mv;
        try {
            ServiceLocator.getBaseUsuarioService().update(usuario);
            List<Usuario> usuarioList = ServiceLocator.getBaseUsuarioService()
                    .readByCriteria(new HashMap<String, Object>());
            Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
            for (Usuario u : usuarioList) { //Atualiza os dados do usuário logado
                if (u.getId().equals(usuarioLogado.getId())) {
                    session.setAttribute("usuarioLogado", u);
                }
            }
            mv = new ModelAndView("redirect:/usuario");
            mv.addObject("usuarioList", usuarioList);
        } catch (Exception ex) {
            mv = new ModelAndView("erro");
            mv.addObject("errp", ex);
        }
        return mv;
    }

    @RequestMapping(value = "/usuario/{id}/perfil", method = RequestMethod.GET)
    public ModelAndView show(@PathVariable Long id) throws Exception {
        ModelAndView mv = new ModelAndView("usuario/perfil");
        Usuario usuario = ServiceLocator.getBaseUsuarioService().readById(id);
        mv.addObject("usuario", usuario);
        return mv;
    }

    @RequestMapping(value = "/usuario/{id}/editaperfil", method = RequestMethod.GET)
    public ModelAndView editarperfil(@PathVariable Long id) throws Exception {
        ModelAndView mv = new ModelAndView("usuario/editarPerfil");
        Usuario usuario = ServiceLocator.getBaseUsuarioService().readById(id);
        mv.addObject("usuario", usuario);
        return mv;
    }

    @RequestMapping(value = "/usuario/{id}/editaperfil", method = RequestMethod.POST)
    public ModelAndView editarperfil(Usuario usuario, String confirmaSenha) throws Exception {
        ModelAndView mv = new ModelAndView("usuario/perfil");
        try {
            if (usuario.getSenha().equals(confirmaSenha)) {
                ServiceLocator.getBaseUsuarioService().update(usuario);
                mv = new ModelAndView("redirect:/usuario/" + usuario.getId() + "/perfil");
                //  mv.addObject("mensagem", "Senha alterada com sucesso!");
            } else {
                mv = new ModelAndView("usuario/editarPerfil");
                mv.addObject("mensagem", "Senhas não conferem");
            }

        } catch (Exception e) {
        }
        mv.addObject("usuario", usuario);
        return mv;
    }

    @RequestMapping("logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:login";
    }
}
