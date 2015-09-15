package spiaa.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import spiaa.model.ConnectionManager;
import spiaa.model.base.service.BaseCriadouroService;
import spiaa.model.dao.CriadouroDAO;
import spiaa.model.entity.Criadouro;

public class CriadouroService implements BaseCriadouroService {

    @Override
    public void create(Criadouro entity) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            CriadouroDAO dao = new CriadouroDAO();
            dao.create(entity, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.close();
            conn.close();

        }
    }

    @Override
    public Criadouro readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        CriadouroDAO dao = new CriadouroDAO();
        Criadouro criadouro = dao.readById(id, conn);
        return criadouro;
    }

    @Override
    public List<Criadouro> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<Criadouro> criadouroList = new ArrayList<>();
        CriadouroDAO dao = new CriadouroDAO();
        criadouroList = dao.readByCriteria(criteria, conn);
        conn.close();

        return criadouroList;
    }

    @Override
    public void update(Criadouro entity) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            CriadouroDAO dao = new CriadouroDAO();
            dao.update(entity, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.close();
            conn.close();

        }

    }

    @Override
    public void delete(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            CriadouroDAO dao = new CriadouroDAO();
            dao.delete(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.close();
            conn.close();

        }
    }

}
