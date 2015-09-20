package spiaa.model.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import spiaa.model.ConnectionManager;
import spiaa.model.base.service.BaseInseticidaService;
import spiaa.model.dao.InseticidaDAO;
import spiaa.model.entity.Inseticida;

public class InseticidaService implements BaseInseticidaService {

    @Override
    public void create(Inseticida entity) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        InseticidaDAO dao = new InseticidaDAO();
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
    public Inseticida readById(Long id) throws Exception {

        Connection conn = ConnectionManager.getInstance().getConnection();
        InseticidaDAO dao = new InseticidaDAO();
        Inseticida inseticida = dao.readById(id, conn);
        conn.close();
        return inseticida;
    }

    @Override
    public List<Inseticida> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Inseticida> inseticidaList = null;
        InseticidaDAO dao = new InseticidaDAO();
        inseticidaList = dao.readByCriteria(criteria, conn);
        conn.close();
        return inseticidaList;
    }

    @Override
    public void update(Inseticida entity) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        InseticidaDAO dao = new InseticidaDAO();
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
        Connection conn = ConnectionManager.getInstance().getConnection();
        InseticidaDAO dao = new InseticidaDAO();
        try {
            dao.delete(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }

    }

}
