/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiaa.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import spiaa.model.ConnectionManager;
import spiaa.model.base.service.BaseDenunciaService;
import spiaa.model.dao.DenunciaDAO;
import spiaa.model.dao.EstratoDAO;
import spiaa.model.entity.Denuncia;

public class DenunciaService implements BaseDenunciaService {

    @Override
    public void create(Denuncia entity) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            DenunciaDAO dao = new DenunciaDAO();
            dao.create(entity, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }
    }

    @Override
    public Denuncia readById(Long id) throws Exception {

        Connection conn = ConnectionManager.getInstance().getConnection();
        Denuncia denuncia = new Denuncia();
        try {
            DenunciaDAO dao = new DenunciaDAO();
            denuncia = dao.readById(id, conn);
            conn.close();
        } catch (Exception e) {
            conn.close();
        }
        return denuncia;
    }

    @Override
    public List<Denuncia> readByCriteria(Map<String, Object> criteria) throws Exception {
        List<Denuncia> listEstrato = new ArrayList<Denuncia>();
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            DenunciaDAO dao = new DenunciaDAO();
            listEstrato = dao.readByCriteria(criteria, conn);
            if (listEstrato.size() <= 0) {
                listEstrato = null;
            }
            conn.close();
        } catch (Exception e) {
            conn.close();
        }
        return listEstrato;
    }

    @Override
    public void update(Denuncia entity) throws Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();
        try {
            DenunciaDAO dao = new DenunciaDAO();
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
            EstratoDAO dao = new EstratoDAO();
            dao.delete(id, conn);
            conn.commit();
            conn.close();
        } catch (Exception e) {
            conn.rollback();
            conn.close();
        }

    }

}
