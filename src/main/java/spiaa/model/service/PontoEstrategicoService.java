package spiaa.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import spiaa.model.ConnectionManager;
import spiaa.model.base.BaseService;
import spiaa.model.dao.PontoEstrategicoDAO;
import spiaa.model.entity.PontoEstrategico;

public class PontoEstrategicoService implements BaseService<PontoEstrategico> {

    @Override
    public void create(PontoEstrategico entity) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            PontoEstrategicoDAO dao = new PontoEstrategicoDAO();
            dao.create(entity, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }
    }

    @Override
    public PontoEstrategico readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        PontoEstrategico ponto = new PontoEstrategico();
        PontoEstrategicoDAO dao = new PontoEstrategicoDAO();
        ponto = dao.readById(id, conn);
        conn.close();
        return ponto;
    }

    @Override
    public List<PontoEstrategico> readByCriteria(Map<String, Object> criteria) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        List<PontoEstrategico> pontoList = new ArrayList<>();
        PontoEstrategicoDAO dao = new PontoEstrategicoDAO();
        pontoList = dao.readByCriteria(criteria, conn);

        return pontoList;
    }

    @Override
    public void update(PontoEstrategico entity) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            PontoEstrategicoDAO dao = new PontoEstrategicoDAO();
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
            PontoEstrategicoDAO dao = new PontoEstrategicoDAO();
            dao.delete(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }
    }

}
