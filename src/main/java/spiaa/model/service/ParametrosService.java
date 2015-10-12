/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiaa.model.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import spiaa.model.ConnectionManager;
import spiaa.model.base.service.BaseParametrosService;
import spiaa.model.dao.ParametrosDAO;
import spiaa.model.entity.Parametros;

/**
 *
 * @author Felipe de Souza
 */
public class ParametrosService implements BaseParametrosService {

    @Override
    public void create(Parametros entity) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        ParametrosDAO dao = new ParametrosDAO();
        try {
            dao.create(entity, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }
    }

    @Override
    public Parametros readById(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Parametros> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Parametros> parametrosList = null;
        ParametrosDAO dao = new ParametrosDAO();
        parametrosList = dao.readByCriteria(criteria, conn);
        conn.close();
        return parametrosList;
    }

    @Override
    public void update(Parametros entity) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        ParametrosDAO dao = new ParametrosDAO();
        try {
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
