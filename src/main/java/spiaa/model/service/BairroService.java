package spiaa.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import spiaa.model.ConnectionManager;
import spiaa.model.base.service.BaseBairroService;
import spiaa.model.dao.BairroDAO;
import spiaa.model.entity.Bairro;

public class BairroService implements BaseBairroService {

    @Override
    public void create(Bairro entity) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            BairroDAO dao = new BairroDAO();
            dao.create(entity, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }

    }

    @Override
    public Bairro readById(Long id) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        Bairro bairro = new Bairro();
        try {
            BairroDAO dao = new BairroDAO();
            bairro = dao.readById(id, conn);
            conn.close();
        } catch (Exception e) {
            conn.close();
        }
        return bairro;
    }

    @Override
    public List<Bairro> readByCriteria(Map<String, Object> criteria) throws Exception {
        List<Bairro> lista = new ArrayList<Bairro>();
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            BairroDAO dao = new BairroDAO();
            lista = dao.readByCriteria(criteria, conn);
            conn.close();
        } catch (Exception e) {
            conn.close();
        }

        return lista;

    }

    @Override
    public void update(Bairro entity) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            BairroDAO dao = new BairroDAO();
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
            BairroDAO dao = new BairroDAO();
            dao.delete(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }
    }

}
