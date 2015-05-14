package spiaa.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import spiaa.model.ConnectionManager;
import spiaa.model.base.service.BaseUsuarioService;
import spiaa.model.dao.UsuarioDAO;
import spiaa.model.entity.Usuario;

public class UsuarioService implements BaseUsuarioService {

    @Override
    public void create(Usuario entity) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            UsuarioDAO dao = new UsuarioDAO();
            dao.create(entity, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {            
            conn.rollback();
            conn.close();
        }
    }

    @Override
    public Usuario readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        Usuario usuario = null;
        UsuarioDAO dao = new UsuarioDAO();
        usuario = dao.readById(id, conn);
        conn.close();
        return usuario;
    }

    @Override
    public List<Usuario> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Usuario> listUsuario = new ArrayList<Usuario>();
        Usuario usuario = new Usuario();
        UsuarioDAO dao = new UsuarioDAO();
        listUsuario = dao.readByCriteria(criteria, conn);
        conn.close();
        return listUsuario;
    }

    @Override
    public void update(Usuario entity) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            UsuarioDAO dao = new UsuarioDAO();
            dao.update(entity, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            UsuarioDAO dao = new UsuarioDAO();
            dao.delete(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }
    }

    @Override
    public Usuario login(String usuario, String senha) throws Exception {
        Usuario usuarioLogado = null;
        try {
            Connection conn = ConnectionManager.getInstance().getConnection();
            UsuarioDAO dao = new UsuarioDAO();
            Map<String, Object> criteria = new HashMap<String, Object>();
            criteria.put(UsuarioDAO.CRITERION_USUARIO_EQ, usuario);
            criteria.put(UsuarioDAO.CRITERION_SENHA_EQ, senha);
            List<Usuario> usuarioList = dao.readByCriteria(criteria, conn);
            if (usuarioList != null && usuarioList.size() == 1) {
                usuarioLogado = usuarioList.get(0);
                if (!usuarioLogado.getUsuario().equals(usuario)) {
                    usuarioLogado = null;
                } else {
                    if (!usuarioLogado.getSenha().equals(senha)) {
                        usuarioLogado = null;
                    }
                }
            }
            conn.close();
        } catch (Exception e) {
            throw e;
        }
        return usuarioLogado;
    }
}
