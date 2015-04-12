package spiaa.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import spiaa.model.base.BaseDAO;
import spiaa.model.entity.Liraa;

public class LiraaDAO implements BaseDAO<Liraa> {

    @Override
    public void create(Liraa entity, Connection conn) throws Exception {
        String sql = "INSERT INTO liraa (data_inicio, data_fim) VALUES (?, ?) RETURNING id;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setDate(1, new Date(entity.getDataInicio().getTime()));
        ps.setDate(2, new Date(entity.getDataTermino().getTime()));
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            entity.setId(rs.getLong("id"));
        }
        rs.close();
        ps.close();
    }

    @Override
    public Liraa readById(Long id, Connection conn) throws Exception {
        Liraa liraa = null;
        String sql = "SELECT * FROM liraa WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            liraa = new Liraa();
            liraa.setId(rs.getLong("id"));
            liraa.setDataInicio(rs.getDate("data_inicio"));
            liraa.setDataTermino(rs.getDate("data_fim"));
        }
        ps.close();
        rs.close();;
        return liraa;
    }

    @Override
    public List<Liraa> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<Liraa> liraaList = new ArrayList<Liraa>();
        Liraa liraa = null;
        String sql = "SELECT * FROM liraa WHERE 1=1";
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(sql);

        while (rs.next()) {
            liraa = new Liraa();
            liraa.setId(rs.getLong("id"));
            liraa.setDataInicio(rs.getDate("data_inicio"));
            liraa.setDataTermino(rs.getDate("data_fim"));
            liraaList.add(liraa);
        }
        rs.close();
        s.close();

        return liraaList;
    }

    @Override
    public void update(Liraa entity, Connection conn) throws Exception {
        String sql = "UPDATE liraa SET  data_inicio=?, data_fim=? WHERE id=?;";
        PreparedStatement ps = conn.prepareCall(sql);
        ps.setDate(1, new Date(entity.getDataInicio().getTime()));
        ps.setDate(2, new Date(entity.getDataTermino().getTime()));
        ps.setLong(3, entity.getId());
        ps.execute();
        ps.close();

    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
