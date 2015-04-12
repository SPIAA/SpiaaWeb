package spiaa.model.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import spiaa.model.ConnectionManager;
import spiaa.model.base.service.BaseTipoImovelService;
import spiaa.model.dao.TipoImovelDAO;
import spiaa.model.entity.TipoImoveis;

public class TipoImovelService implements BaseTipoImovelService {

    @Override
    public void create(TipoImoveis entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoImoveis readById(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoImoveis> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<TipoImoveis> tipoImoveisList = null;
        TipoImovelDAO dao = new TipoImovelDAO();
        tipoImoveisList = dao.readByCriteria(criteria, conn);
        conn.close();
        return tipoImoveisList;
    }

    @Override
    public void update(TipoImoveis entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
