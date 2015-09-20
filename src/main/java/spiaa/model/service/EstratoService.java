package spiaa.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import spiaa.model.ConnectionManager;
import spiaa.model.base.service.BaseEstratoService;
import spiaa.model.dao.EstratoDAO;
import spiaa.model.entity.Estrato;

public class EstratoService implements BaseEstratoService {

    @Override
    public void create(Estrato entity) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            EstratoDAO dao = new EstratoDAO();
            dao.create(entity, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }
    }

    @Override
    public Estrato readById(Long id) throws Exception {

        Connection conn = ConnectionManager.getInstance().getConnection();
        Estrato estrato = new Estrato();
        try {
            EstratoDAO dao = new EstratoDAO();
           estrato = dao.readById(id, conn);
            conn.close();
        } catch (Exception e) {
            conn.close();
        }
        return estrato;
    }

    @Override
    public List<Estrato> readByCriteria(Map<String, Object> criteria) throws Exception {
        List<Estrato> listEstrato = new ArrayList<Estrato>();
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            EstratoDAO dao = new EstratoDAO();
            listEstrato = dao.readByCriteria(criteria, conn);
            conn.close();
        } catch (Exception e) {
            conn.close();
        }
        return listEstrato;
    }

    @Override
    public void update(Estrato entity) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            EstratoDAO dao = new EstratoDAO();
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
            EstratoDAO dao = new EstratoDAO();
            dao.delete(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }

    }

}
