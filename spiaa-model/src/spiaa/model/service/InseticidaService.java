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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Inseticida readById(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
