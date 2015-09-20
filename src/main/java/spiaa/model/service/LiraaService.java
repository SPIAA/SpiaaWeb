package spiaa.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import spiaa.model.ConnectionManager;
import spiaa.model.base.service.BaseLiraaService;
import spiaa.model.dao.LiraaDAO;
import spiaa.model.entity.Liraa;

public class LiraaService implements BaseLiraaService {

    @Override
    public void create(Liraa entity) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            LiraaDAO dao = new LiraaDAO();
            dao.create(entity, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }
    }

    @Override
    public Liraa readById(Long id) throws Exception {
        Liraa liraa = new Liraa();
        Connection conn = ConnectionManager.getInstance().getConnection();
        LiraaDAO dao = new LiraaDAO();
        liraa = dao.readById(id, conn);
        conn.close();
        return liraa;
    }

    @Override
    public List<Liraa> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Liraa> listLiraa = new ArrayList<Liraa>();
        LiraaDAO dao = new LiraaDAO();
        listLiraa = dao.readByCriteria(criteria, conn);
        if (listLiraa.size() <= 0) {
                listLiraa = null;
            }
        conn.close();
        return listLiraa;
    }

    @Override
    public void update(Liraa entity) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            LiraaDAO dao = new LiraaDAO();
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
            LiraaDAO dao = new LiraaDAO();
            dao.delete(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();

        }
    }
}
