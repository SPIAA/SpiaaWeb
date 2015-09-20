package spiaa.model.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import spiaa.model.ConnectionManager;
import spiaa.model.base.service.BaseConsolidacaoDadosService;
import spiaa.model.dao.ConsolidacaoDadosDAO;
import spiaa.model.entity.ConsolidacaoDados;

public class ConsolidacaoDadosService implements BaseConsolidacaoDadosService {

    @Override
    public void create(ConsolidacaoDados entity) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();

        try {
            ConsolidacaoDadosDAO dao = new ConsolidacaoDadosDAO();
            dao.create(entity, conn);
            conn.commit();
            conn.close();

        } catch (Exception e) {
            conn.close();
            conn.close();

        }

    }

    @Override
    public ConsolidacaoDados readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        ConsolidacaoDados consolidacaoDados = null;

        ConsolidacaoDadosDAO dao = new ConsolidacaoDadosDAO();
        consolidacaoDados = dao.readById(id, conn);

        conn.close();

        return consolidacaoDados;
    }

    @Override
    public List<ConsolidacaoDados> readByCriteria(Map<String, Object> criteria) throws Exception {
        List<ConsolidacaoDados> consolidacaoDadosList = null;
        Connection conn = ConnectionManager.getInstance().getConnection();

        ConsolidacaoDadosDAO dao = new ConsolidacaoDadosDAO();
        consolidacaoDadosList = dao.readByCriteria(criteria, conn);
        conn.close();
        if (consolidacaoDadosList.size() < 1) {
            consolidacaoDadosList = null;
        }

        return consolidacaoDadosList;
    }

    @Override
    public void update(ConsolidacaoDados entity) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            ConsolidacaoDadosDAO dao = new ConsolidacaoDadosDAO();
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
            ConsolidacaoDadosDAO dao = new ConsolidacaoDadosDAO();
            dao.delete(id, conn);
            conn.commit();
            conn.close();

        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }
    
    }

}
