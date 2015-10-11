package spiaa.model.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import spiaa.model.ConnectionManager;
import spiaa.model.base.service.BaseUsuarioBairroService;
import spiaa.model.dao.UsuarioBairroDAO;
import spiaa.model.entity.UsuarioBairro;

/**
 *
 * @author William
 * @author Felipe de Souza
 */
public class UsuarioBairroService implements BaseUsuarioBairroService {

    @Override
    public void create(UsuarioBairro entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UsuarioBairro readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        UsuarioBairroDAO dao = new UsuarioBairroDAO();
        UsuarioBairro bairros = dao.readById(id, conn);
        conn.close();
        return bairros;
    }

    @Override
    public List<UsuarioBairro> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        UsuarioBairroDAO dao = new UsuarioBairroDAO();
        List<UsuarioBairro> bairros = dao.readByCriteria(criteria, conn);
        conn.close();
        return bairros;
    }

    @Override
    public void update(UsuarioBairro entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteByUsuarioId(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            UsuarioBairroDAO dao = new UsuarioBairroDAO();
            dao.deleteByUsuarioId(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }
    }

    @Override
    public void deleteByBairroId(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            UsuarioBairroDAO dao = new UsuarioBairroDAO();
            dao.deleteByBairroId(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }
    }

    @Override
    public void createByUsuario(List<UsuarioBairro> usuarioBairroList) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            UsuarioBairroDAO dao = new UsuarioBairroDAO();
            if (usuarioBairroList != null && usuarioBairroList.size() > 0) {
                deleteByUsuarioId(usuarioBairroList.get(0).getUsuario().getId());
                for (UsuarioBairro usuarioBairro : usuarioBairroList) {
                    dao.create(usuarioBairro, conn);
                }
            }
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }
    }

    @Override
    public void createByBairro(List<UsuarioBairro> usuarioBairroList) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            UsuarioBairroDAO dao = new UsuarioBairroDAO();
            if (usuarioBairroList != null && usuarioBairroList.size() > 0) {
                deleteByBairroId(usuarioBairroList.get(0).getBairro().getId());
                for (UsuarioBairro usuarioBairro : usuarioBairroList) {
                    dao.create(usuarioBairro, conn);
                }
            }
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }
    }
}
