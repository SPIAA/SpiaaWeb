/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiaa.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import spiaa.model.base.BaseDAO;
import spiaa.model.entity.Criadouro;

public class CriadouroDAO implements BaseDAO<Criadouro> {

    @Override
    public void create(Criadouro entity, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Criadouro readById(Long id, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Criadouro> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {

        List<Criadouro> criadouroList = new ArrayList<Criadouro>();
        Criadouro criadouro = null;
        String sql = "SELECT * FROM criadouro WHERE 1=1";

        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(sql);

        while (rs.next()) {
            criadouro = new Criadouro();
            criadouro.setId(rs.getLong("id"));
            criadouro.setGrupo(rs.getString("grupo"));
            criadouroList.add(criadouro);

        }
        rs.close();
        s.close();

        return criadouroList;
    }

    @Override
    public void update(Criadouro entity, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
