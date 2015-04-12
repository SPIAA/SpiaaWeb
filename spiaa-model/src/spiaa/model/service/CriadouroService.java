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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Criadouro readById(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
