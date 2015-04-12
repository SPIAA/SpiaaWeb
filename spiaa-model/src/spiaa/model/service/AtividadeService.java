package spiaa.model.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import spiaa.model.ConnectionManager;
import spiaa.model.base.service.BaseAtividadeService;
import spiaa.model.dao.AtividadeDAO;
import spiaa.model.entity.Atividade;

public class AtividadeService implements BaseAtividadeService {

    @Override
    public void create(Atividade entity) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            AtividadeDAO dao = new AtividadeDAO();
            dao.create(entity, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }
    }

    @Override
    public Atividade readById(Long id) throws Exception {
        Atividade atividade = null;
        Connection conn = ConnectionManager.getInstance().getConnection();

        AtividadeDAO dao = new AtividadeDAO();
        atividade = dao.readById(id, conn);
        conn.close();

        return atividade;
    }

    @Override
    public List<Atividade> readByCriteria(Map<String, Object> criteria) throws Exception {
        List<Atividade> atividadeList = null;
        Connection conn = ConnectionManager.getInstance().getConnection();
        AtividadeDAO dao = new AtividadeDAO();
        atividadeList = dao.readByCriteria(criteria, conn);
        if (atividadeList.size() <= 0) {
                atividadeList = null;
            }
        conn.close();
        return atividadeList;
    }

    @Override
    public void update(Atividade entity) throws Exception {

        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            AtividadeDAO dao = new AtividadeDAO();
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
            AtividadeDAO dao = new AtividadeDAO();
            dao.delete(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }}

}
