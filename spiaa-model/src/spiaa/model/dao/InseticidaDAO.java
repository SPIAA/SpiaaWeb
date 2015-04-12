package spiaa.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import spiaa.model.base.BaseDAO;
import spiaa.model.entity.Inseticida;

public class InseticidaDAO implements BaseDAO<Inseticida> {

    @Override
    public void create(Inseticida entity, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Inseticida readById(Long id, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Inseticida> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<Inseticida> inseticidaList = new ArrayList<Inseticida>();
        Inseticida inseticida = null;
        String sql = "SELECT * FROM inseticida WHERE 1=1;";

        Statement s = conn.createStatement();

        ResultSet rs = s.executeQuery(sql);
        while (rs.next()) {
            inseticida = new Inseticida();
            inseticida.setId(rs.getLong("id"));
            inseticida.setNome(rs.getString("nome"));
            inseticidaList.add(inseticida);
        }

        return inseticidaList;
    }

    @Override
    public void update(Inseticida entity, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
