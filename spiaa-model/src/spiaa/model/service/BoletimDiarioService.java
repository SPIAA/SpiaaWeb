package spiaa.model.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import spiaa.model.ConnectionManager;
import spiaa.model.base.service.BaseBoletimDiarioService;
import spiaa.model.dao.BoletimDiarioDAO;
import spiaa.model.entity.BoletimDiario;

public class BoletimDiarioService implements BaseBoletimDiarioService {
    
    @Override
    public void create(BoletimDiario entity) throws Exception {
        
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            BoletimDiarioDAO dao = new BoletimDiarioDAO();
            dao.create(entity, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }
        
    }
    
    @Override
    public BoletimDiario readById(Long id) throws Exception {
        BoletimDiario boletimDiario = null;
        Connection conn = ConnectionManager.getInstance().getConnection();
        BoletimDiarioDAO dao = new BoletimDiarioDAO();
        boletimDiario = dao.readById(id, conn);
        conn.close();
        return boletimDiario;
    }
    
    @Override
    public List<BoletimDiario> readByCriteria(Map<String, Object> criteria) throws Exception {
        List<BoletimDiario> boletimDiarioList = null;
        Connection conn = ConnectionManager.getInstance().getConnection();
        BoletimDiarioDAO dao = new BoletimDiarioDAO();
        boletimDiarioList = dao.readByCriteria(criteria, conn);
        if (boletimDiarioList.size() <= 0) {
                boletimDiarioList = null;
            }
        conn.close();
        return boletimDiarioList;
    }
    
    @Override
    public void update(BoletimDiario entity) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            BoletimDiarioDAO dao = new BoletimDiarioDAO();
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
            BoletimDiarioDAO dao = new BoletimDiarioDAO();
            dao.delete(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }
    }
    
}
