package spiaa.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
        String sql = "INSERT INTO inseticida( nome, unidade) VALUES (?, ?) RETURNING id";
        PreparedStatement ps = conn.prepareStatement(sql);

        int i = 0;
        ps.setString(++i, entity.getNome());
        ps.setString(++i, entity.getUnidade());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            entity.setId(rs.getLong("id"));
        }
        ps.close();
        rs.close();
    }

    @Override
    public Inseticida readById(Long id, Connection conn) throws Exception {
        String sql = "SELECT * FROM inseticida WHERE id = ? ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        Inseticida inseticida = null;
        if (rs.next()) {
            inseticida = new Inseticida();
            inseticida.setId(rs.getLong("id"));
            inseticida.setNome(rs.getString("nome"));
            inseticida.setUnidade(rs.getString("unidade"));
        }
        ps.close();
        rs.close();
        return inseticida;
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
            inseticida.setUnidade(rs.getString("unidade"));
            inseticidaList.add(inseticida);
        }
        rs.close();
        s.close();

        return inseticidaList;
    }

    @Override
    public void update(Inseticida entity, Connection conn) throws Exception {
        String sql = "UPDATE inseticida   SET  nome=?, unidade=?  WHERE id = ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, entity.getNome());
        ps.setString(++i, entity.getUnidade());
        ps.setLong(++i, entity.getId());
        ps.execute();
        ps.close();

    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        String sql = "DELETE FROM inseticida WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ps.execute();
        ps.close();
    }

}
