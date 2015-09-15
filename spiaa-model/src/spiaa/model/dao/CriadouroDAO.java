package spiaa.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
        String sql = "INSERT INTO criadouro( grupo, recipiente)  VALUES (?, ?) RETURNING id;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, entity.getGrupo());
        ps.setString(++i, entity.getRecipiente());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            entity.setId(rs.getLong("id"));
        }
        ps.close();
        rs.close();
    }

    @Override
    public Criadouro readById(Long id, Connection conn) throws Exception {
        String sql = " SELECT * FROM criadouro WHERE id  =? ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        Criadouro criadouro = null;
        if (rs.next()) {
            criadouro = new Criadouro();
            criadouro.setId(rs.getLong("id"));
            criadouro.setGrupo(rs.getString("grupo"));
            criadouro.setRecipiente(rs.getString("recipiente"));
        }
        ps.close();
        rs.close();
        return criadouro;
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
            criadouro.setRecipiente(rs.getString("recipiente"));
            criadouroList.add(criadouro);

        }
        rs.close();
        s.close();

        return criadouroList;
    }

    @Override
    public void update(Criadouro entity, Connection conn) throws Exception {
        String sql = "UPDATE criadouro   SET  grupo=?, recipiente=? WHERE id = ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, entity.getGrupo());
        ps.setString(++i, entity.getRecipiente());
        ps.setLong(++i, entity.getId());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        String sql = "DELETE FROM criadouro WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ps.execute();
        ps.close();
    }
}
