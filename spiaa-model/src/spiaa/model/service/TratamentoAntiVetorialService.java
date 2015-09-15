package spiaa.model.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import spiaa.model.ConnectionManager;
import spiaa.model.base.service.BaseTratamentoAntiVetorialService;
import spiaa.model.dao.TratamentoAntiVetorialDAO;
import spiaa.model.entity.TratamentoAntiVetorial;

public class TratamentoAntiVetorialService implements BaseTratamentoAntiVetorialService {
    
    @Override
    public void create(TratamentoAntiVetorial entity) throws Exception {
        
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            TratamentoAntiVetorialDAO dao = new TratamentoAntiVetorialDAO();
            dao.create(entity, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }
        
    }
    
    @Override
    public TratamentoAntiVetorial readById(Long id) throws Exception {
        TratamentoAntiVetorial boletimDiario = null;
        Connection conn = ConnectionManager.getInstance().getConnection();
        TratamentoAntiVetorialDAO dao = new TratamentoAntiVetorialDAO();
        boletimDiario = dao.readById(id, conn);
        conn.close();
        return boletimDiario;
    }
    
    @Override
    public List<TratamentoAntiVetorial> readByCriteria(Map<String, Object> criteria) throws Exception {
        List<TratamentoAntiVetorial> boletimDiarioList = null;
        Connection conn = ConnectionManager.getInstance().getConnection();
        TratamentoAntiVetorialDAO dao = new TratamentoAntiVetorialDAO();
        boletimDiarioList = dao.readByCriteria(criteria, conn);
        if (boletimDiarioList.size() <= 0) {
                boletimDiarioList = null;
            }
        conn.close();
        return boletimDiarioList;
    }
    
    @Override
    public void update(TratamentoAntiVetorial entity) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            TratamentoAntiVetorialDAO dao = new TratamentoAntiVetorialDAO();
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
            TratamentoAntiVetorialDAO dao = new TratamentoAntiVetorialDAO();
            dao.delete(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }
    }
    
}
