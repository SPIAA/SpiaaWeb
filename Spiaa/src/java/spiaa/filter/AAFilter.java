package spiaa.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AAFilter extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean ok = false;
        String uri = request.getRequestURI();
        //Resources
        //CSS
        if (uri.startsWith("/Spiaa/css/") && uri.endsWith(".css")) {
            ok = true;
        }
        //JS
        if (uri.startsWith("/Spiaa/js/") && uri.endsWith(".js")) {
            ok = true;
        }

        // IMG e FONT
        if (uri.startsWith("/Spiaa/img/") && uri.endsWith(".jpg")) {
            ok = true;
        }
        if (uri.startsWith("/Spiaa/img/") && uri.endsWith(".png")) {
            ok = true;
        }
        if (uri.startsWith("/Spiaa/fonts/") && uri.endsWith(".svg")) {
            ok = true;
        }
        if (uri.startsWith("/Spiaa/fonts/") && uri.endsWith(".ttf")) {
            ok = true;
        }
        if (uri.startsWith("/Spiaa/fonts/") && uri.endsWith(".woff")) {
            ok = true;
        }
        if (uri.startsWith("/Spiaa/fonts/") && uri.endsWith(".eot")) {
            ok = true;
        }

        //URI Livres de Autenticação
        if (!ok) {
            if (uri.startsWith("/Spiaa/usuario/novo")) {
                ok = true;
            }
            if (uri.startsWith("/Spiaa/home")) {
                ok = true;
            }
            if (uri.startsWith("/Spiaa/login")) {
                ok = true;
            }
            if (uri.startsWith("/Spiaa/mapa")) {
                ok = true;
            }
            if (uri.startsWith("/Spiaa/mapa")) {
                ok = true;
            }
            if (uri.startsWith("/Spiaa/denunciaform")) {
                ok = true;
            }
        }

        //Verificar Autenticação
        if (!ok) {
            Object usuario = request.getSession().getAttribute("usuarioLogado");
            if (usuario != null) {
                ok = true;
            }
            // Criar um mecanismo para verificar Autorização
        }

        //Finalizando
        if (!ok) {
            response.sendRedirect("/Spiaa/login");
        }

        return ok;
    }

}
