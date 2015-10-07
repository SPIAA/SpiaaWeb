/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiaa.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import spiaa.model.base.BaseDAO;
import spiaa.model.entity.Bairro;
import spiaa.model.entity.Quarteirao;

/**
 *
 * @author William
 */
public class QuarteiraoDAO implements BaseDAO<Quarteirao> {

    public static final String CRITERION_BAIRRO_ID = "1";

    @Override
    public void create(Quarteirao entity, Connection conn) throws Exception {
        String sql = "INSERT INTO quarteirao(descricao, bairro_fk) VALUES (?, ?) RETURNING id;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, entity.getDescricao());
        ps.setLong(2, entity.getBairro().getId());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            entity.setId(rs.getLong("id"));
        }
        rs.close();
        ps.close();
    }

    @Override
    public Quarteirao readById(Long id, Connection conn) throws Exception {
        Quarteirao quarteirao = new Quarteirao();
        String sql = "SELECT q.*, b.id as b_id, b.nome, b.coordenadas FROM quarteirao q "
                + "LEFT JOIN bairro b ON q.bairro_fk=b.id WHERE q.id=?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            Bairro bairro = new Bairro();
            bairro.setId(rs.getLong("b_id"));
            bairro.setNome(rs.getString("nome"));
            bairro.setCoordenadas(rs.getString("coordenadas"));

            quarteirao = new Quarteirao();
            quarteirao.setId(rs.getLong("id"));
            quarteirao.setDescricao(rs.getString("descricao"));
            quarteirao.setBairro(bairro);
        }
        rs.close();
        ps.close();
        return quarteirao;
    }

    @Override
    public List<Quarteirao> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<Quarteirao> quarteiraoList = new ArrayList<>();
        String sql = "SELECT q.*, b.id as b_id, b.nome FROM quarteirao q "
                + "LEFT JOIN bairro b ON q.bairro_fk=b.id WHERE 1=1 ";

        Long criterionBairroId = (Long) criteria.get(CRITERION_BAIRRO_ID);
        if (criterionBairroId != null) {
            sql += " AND b.id = " + criterionBairroId;
        }

        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        Quarteirao quarteirao;
        while (rs.next()) {
            Bairro bairro = new Bairro();
            bairro.setId(rs.getLong("b_id"));
            bairro.setNome(rs.getString("nome"));

            quarteirao = new Quarteirao();
            quarteirao.setId(rs.getLong("id"));
            quarteirao.setDescricao(rs.getString("descricao"));
            quarteirao.setBairro(bairro);

            quarteiraoList.add(quarteirao);
        }
        rs.close();
        ps.close();
        return quarteiraoList;
    }

    @Override
    public void update(Quarteirao entity, Connection conn) throws Exception {
        String sql = "UPDATE quarteirao SET descricao=?, bairro_fk=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, entity.getDescricao());
        ps.setLong(2, entity.getBairro().getId());
        ps.setLong(3, entity.getId());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        String sql = "DELETE FROM quarteirao WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ps.execute();
        ps.close();
    }

}
