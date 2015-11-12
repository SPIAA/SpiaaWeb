/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiaa.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import spiaa.model.entity.Usuario;
import spiaa.model.entity.relatorio.ImoveisVisitadorPorAgentes;

/**
 *
 * @author Felipe de Souza
 */
public class RelatorioDAO {

    public List<ImoveisVisitadorPorAgentes> readImoveisVisitadorPorAgentes(Date dataInicial, Date dataFinal, Connection conn) throws Exception {
        List<ImoveisVisitadorPorAgentes> imoveisVisitados = new ArrayList<>();
        String sql = " select usuario.id as usuario_id, usuario.nome as usuario_nome, count(tratamento_antivetorial.id )as dias_trabalhados from usuario ";
        sql += " left join tratamento_antivetorial on tratamento_antivetorial.usuario_fk = usuario.id ";
        sql += " where tratamento_antivetorial.data_boletim >= '" + dataInicial.toString() + "' and tratamento_antivetorial.data_boletim <= '" + dataFinal.toString() + "'";
        sql += " group by usuario.nome, usuario.id ";

        PreparedStatement ps = conn.prepareStatement(sql);
//        int i = 0;
//        ps.setDate(++i, new java.sql.Date(dataInicial.getTime()));
//        ps.setDate(++i, new java.sql.Date(dataFinal.getTime()));

        ResultSet rs = ps.executeQuery();
        Usuario usuario = null;
        ImoveisVisitadorPorAgentes imoveisAgentes = null;
        while (rs.next()) {
            imoveisAgentes = new ImoveisVisitadorPorAgentes();
            //usuario
            usuario = new Usuario();
            usuario.setId(rs.getLong("usuario_id"));
            usuario.setNome(rs.getString("usuario_nome"));
            imoveisAgentes.setUsuario(usuario);

            imoveisAgentes.setDiasTrabalhados(rs.getInt("dias_trabalhados"));
            imoveisAgentes.setImoveisVisitados(readTotaImoveisVisitados(usuario.getId(), conn));
            imoveisVisitados.add(imoveisAgentes);
        }

        rs.close();
        ps.close();
        return imoveisVisitados;
    }

    public Integer readTotaImoveisVisitados(Long id, Connection conn) throws SQLException {
        Integer total = 0;

        String sql = "select usuario.nome, count(atividade.id )as imoveis_visitados from usuario ";
        sql += "left join tratamento_antivetorial on tratamento_antivetorial.usuario_fk = usuario.id ";
        sql += "left join atividade on atividade.tratamento_antivetorial_fk = tratamento_antivetorial.id ";
        sql += "where tratamento_antivetorial.usuario_fk = ?";
        sql += "group by usuario.nome ";

        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setLong(++i, id);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            total = rs.getInt("imoveis_visitados");
        }
        rs.close();
        ps.close();
        return total;
    }
}
