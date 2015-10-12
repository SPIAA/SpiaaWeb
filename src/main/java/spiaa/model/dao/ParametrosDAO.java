/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiaa.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import spiaa.model.base.BaseDAO;
import spiaa.model.entity.Parametros;

/**
 *
 * @author Felipe de Souza
 */
public class ParametrosDAO implements BaseDAO<Parametros> {

    @Override
    public void create(Parametros entity, Connection conn) throws Exception {
        String sql = "INSERT INTO parametros( hostname, smtp, porta, email, senha) VALUES (?, ?, ?, ?, ?) RETURNING id";
        PreparedStatement ps = conn.prepareStatement(sql);

        int i = 0;
        ps.setString(++i, entity.getCaminhoHostName());
        ps.setString(++i, entity.getSmtp());
        ps.setInt(++i, entity.getPorta());
        ps.setString(++i, entity.getEmail());
        ps.setString(++i, entity.getSenha());

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            entity.setId(rs.getLong("id"));
        }
        ps.close();
        rs.close();
    }

    @Override
    public Parametros readById(Long id, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Parametros> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<Parametros> parametrosList = new ArrayList<Parametros>();
        Parametros parametros = null;
        String sql = "SELECT * FROM parametros WHERE 1=1;";

        Statement s = conn.createStatement();

        ResultSet rs = s.executeQuery(sql);
        if (rs.next()) {
            parametros = new Parametros();
            parametros.setId(rs.getLong("id"));
            parametros.setCaminhoHostName(rs.getString("hostname"));
            parametros.setSmtp(rs.getString("smtp"));
            parametros.setPorta(rs.getInt("porta"));
            parametros.setEmail(rs.getString("email"));
            parametros.setSenha(rs.getString("senha"));
            parametrosList.add(parametros);
        }
        rs.close();
        s.close();

        return parametrosList;
    }

    @Override
    public void update(Parametros entity, Connection conn) throws Exception {
        String sql = "UPDATE parametros SET hostname=?, smtp=? ,porta=?, email=?, senha=? WHERE id=? ;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, entity.getCaminhoHostName());
        ps.setString(++i, entity.getSmtp());
        ps.setInt(++i, entity.getPorta());
        ps.setString(++i, entity.getEmail());
        ps.setString(++i, entity.getSenha());
        ps.setLong(++i, entity.getId());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
