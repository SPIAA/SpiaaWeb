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
import spiaa.model.base.service.BaseQuarteiraoService;
import spiaa.model.dao.QuarteiraoDAO;
import spiaa.model.entity.Quarteirao;

/**
 *
 * @author William
 */
public class QuarteiraoService implements BaseQuarteiraoService {

    @Override
    public void create(Quarteirao entity) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            QuarteiraoDAO dao = new QuarteiraoDAO();
            dao.create(entity, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
    }

    @Override
    public Quarteirao readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        QuarteiraoDAO dao = new QuarteiraoDAO();
        Quarteirao quarteirao = dao.readById(id, conn);
        conn.close();
        return quarteirao;
    }

    @Override
    public List<Quarteirao> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        QuarteiraoDAO dao = new QuarteiraoDAO();
        List<Quarteirao> quarteiraoList = dao.readByCriteria(criteria, conn);
        conn.close();
        return quarteiraoList;
    }

    @Override
    public void update(Quarteirao entity) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            QuarteiraoDAO dao = new QuarteiraoDAO();
            dao.update(entity, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
    }

    @Override
    public void delete(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            QuarteiraoDAO dao = new QuarteiraoDAO();
            dao.delete(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
            throw e;
        }
    }
}
