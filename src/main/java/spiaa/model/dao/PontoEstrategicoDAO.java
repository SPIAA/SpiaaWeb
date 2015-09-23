package spiaa.model.dao;

import spiaa.model.base.BaseDAO;
import spiaa.model.entity.Bairro;
import spiaa.model.entity.PontoEstrategico;
import spiaa.model.entity.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PontoEstrategicoDAO implements BaseDAO<PontoEstrategico> {

    @Override
    public void create(PontoEstrategico entity, Connection conn) throws Exception {
        String sql = "INSERT INTO ponto_estrategico(rua, numero, complemento, bairro_fk, cidade, estado, usuario_fk,latitude, longitude, ramo_atividade, cep) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id;";

        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, entity.getRua());
        ps.setString(++i, entity.getNumero());
        ps.setString(++i, entity.getComplemento());
        ps.setLong(++i, entity.getBairro().getId());
        ps.setString(++i, entity.getCidade());
        ps.setString(++i, entity.getEstado());
        ps.setLong(++i, entity.getUsuario().getId());
        ps.setString(++i, entity.getLatitude());
        ps.setString(++i, entity.getLongitude());
        ps.setString(++i, entity.getRamoAtividade());
        ps.setString(++i, entity.getCep());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            entity.setId(rs.getLong("id"));
        }
        ps.close();
        rs.close();

    }

    @Override
    public PontoEstrategico readById(Long id, Connection conn) throws Exception {
        PontoEstrategico pontoEstrategico = new PontoEstrategico();
        String sql = "select ponto_estrategico.*,bairro.id as bairro_id, bairro.nome as bairro_nome, usuario.usuario from ponto_estrategico left join bairro on bairro.id = ponto_estrategico.bairro_fk left join usuario on usuario.id = ponto_estrategico.usuario_fk WHERE ponto_estrategico.id =?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            pontoEstrategico = new PontoEstrategico();
            pontoEstrategico.setId(rs.getLong("id"));
            pontoEstrategico.setRua(rs.getString("rua"));
            pontoEstrategico.setNumero(rs.getString("numero"));
            pontoEstrategico.setComplemento(rs.getString("complemento"));
            pontoEstrategico.setRamoAtividade(rs.getString("ramo_atividade"));
            pontoEstrategico.setCep(rs.getString("cep"));
            pontoEstrategico.setCidade(rs.getString("cidade"));
            pontoEstrategico.setEstado(rs.getString("estado"));

            Bairro bairro = new Bairro();
            bairro.setId(rs.getLong("bairro_fk"));
            pontoEstrategico.setBairro(bairro);

            Usuario usuario = new Usuario();
            usuario.setId(rs.getLong("id"));
            usuario.setUsuario(rs.getString("usuario"));
            pontoEstrategico.setUsuario(usuario);
        }
        ps.close();
        rs.close();

        return pontoEstrategico;

    }

    @Override
    public List<PontoEstrategico> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {

        List<PontoEstrategico> pontoEstrategicoList = new ArrayList<>();
        PontoEstrategico pontoEstrategico = new PontoEstrategico();
        String sql = "select ponto_estrategico.*,bairro.id as bairro_id, bairro.nome as bairro_nome, usuario.usuario from ponto_estrategico left join bairro on bairro.id = ponto_estrategico.bairro_fk left join usuario on usuario.id = ponto_estrategico.usuario_fk WHERE 1=1;";

        Statement s = conn.createStatement();

        ResultSet rs = s.executeQuery(sql);
        while (rs.next()) {
            pontoEstrategico = new PontoEstrategico();
            pontoEstrategico.setId(rs.getLong("id"));
            pontoEstrategico.setRua(rs.getString("rua"));
            pontoEstrategico.setNumero(rs.getString("numero"));
            pontoEstrategico.setComplemento(rs.getString("complemento"));
            pontoEstrategico.setRamoAtividade(rs.getString("ramo_atividade"));
            pontoEstrategico.setCep(rs.getString("cep"));
            pontoEstrategico.setCidade(rs.getString("cidade"));
            pontoEstrategico.setEstado(rs.getString("estado"));

            Bairro bairro = new Bairro();
            bairro.setId(rs.getLong("bairro_fk"));
            bairro.setNome(rs.getString("bairro_nome"));
            pontoEstrategico.setBairro(bairro);

            Usuario usuario = new Usuario();
            usuario.setId(rs.getLong("usuario_fk"));
            usuario.setUsuario(rs.getString("usuario"));
            pontoEstrategico.setUsuario(usuario);

            pontoEstrategicoList.add(pontoEstrategico);
        }
        rs.close();
        s.close();

        return pontoEstrategicoList;

    }

    @Override
    public void update(PontoEstrategico entity, Connection conn) throws Exception {
        String sql = "UPDATE ponto_estrategico SET rua=?, numero=?, complemento=?, bairro_fk=?, cidade=?, estado=?, usuario_fk=?, latitude=?, longitude=?, ramo_atividade=?, cep=? WHERE id= ?;";

        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, entity.getRua());
        ps.setString(++i, entity.getNumero());
        ps.setString(++i, entity.getComplemento());
        ps.setLong(++i, entity.getBairro().getId());
        ps.setString(++i, entity.getCidade());
        ps.setString(++i, entity.getEstado());
        ps.setLong(++i, entity.getUsuario().getId());
        ps.setString(++i, entity.getLatitude());
        ps.setString(++i, entity.getLongitude());
        ps.setString(++i, entity.getRamoAtividade());
        ps.setString(++i, entity.getCep());
        ps.setLong(++i, entity.getId());
        
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        String sql = "DELETE FROM ponto_estrategico WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ps.execute();
        ps.close();
    }

}
