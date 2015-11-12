package spiaa.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import spiaa.model.dao.UsuarioDAO;
import spiaa.model.entity.Usuario;

public class AAFilter extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
        boolean ok = false;
        String uri = request.getRequestURI().replace("/Spiaa", "");
        //Resources
        //CSS
        if (uri.startsWith("/css/") && uri.endsWith(".css")) {
            ok = true;
        }
        if (uri.startsWith("/css/images/") && uri.endsWith(".png")) {
            ok = true;
        }
        //JS
        if (uri.startsWith("/js/") && uri.endsWith(".js")) {
            ok = true;
        }

        // IMG e FONT
        if (uri.startsWith("/img/") && uri.endsWith(".jpg")) {
            ok = true;
        }
        if (uri.startsWith("/img/") && uri.endsWith(".png")) {
            ok = true;
        }
        if (uri.startsWith("/fonts/") && uri.endsWith(".svg")) {
            ok = true;
        }
        if (uri.startsWith("/fonts/") && uri.endsWith(".ttf")) {
            ok = true;
        }
        if (uri.startsWith("/fonts/") && uri.endsWith(".woff")) {
            ok = true;
        }
        if (uri.startsWith("/fonts/") && uri.endsWith(".eot")) {
            ok = true;
        }

        //URI Livres de Autenticação
        if (!ok) {
            if (uri.startsWith("/usuario/novo")) {
                ok = true;
            }
            if (uri.startsWith("/home")) {
                ok = true;
            }

            if (uri.startsWith("/agente")) {
                ok = true;
            }

            if (uri.startsWith("/bairro")) {
                ok = true;
            }

            if (uri.startsWith("/denuncias")) {
                ok = true;
            }

            if (uri.startsWith("/login")) {
                ok = true;
            }

            if (uri.startsWith("/autenticar/agente")) {
                ok = true;
            }
            if (uri.startsWith("/mapa")) {
                ok = true;
            }
            if (uri.startsWith("/mapa")) {
                ok = true;
            }
            if (uri.startsWith("/denunciaform")) {
                ok = true;
            }
            if (uri.startsWith("/api")) {
                ok = true;
            }
            if (uri.startsWith("/relatorio")) {
                ok = true;
            }
        }

        //Verificar Autenticação
        if (!ok) {
            Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
            if (usuario != null && usuario.getTipo().equalsIgnoreCase(UsuarioDAO.TIPO_ADMNISTRADOR)) {
                ok = true;
            }
            // Criar um mecanismo para verificar Autorização
        }

        //Finalizando
        if (!ok) {
            response.sendRedirect("/login/error");
        }

        return ok;
    }

}
