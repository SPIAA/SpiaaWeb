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
import spiaa.model.entity.Bairro;
import spiaa.model.entity.TratamentoAntiVetorial;
import spiaa.model.entity.Usuario;

public class TratamentoAntiVetorialDAO implements BaseDAO<TratamentoAntiVetorial> {

    @Override
    public void create(TratamentoAntiVetorial entity, Connection conn) throws Exception {

        String sql = "INSERT INTO boletim_diario(data_boletim, numero, semana_epidemiologica, turma, usuario_fk, bairro_fk,numero_atividade, tipo_atividade)VALUES (?, ?, ?, ?, ?, ?, ?, ?) RETURNING id";
        PreparedStatement ps = conn.prepareStatement(sql);

        int i = 0;
        ps.setDate(++i, new Date(entity.getDataBoletim().getTime()));
        ps.setString(++i, entity.getNumero());
        ps.setString(++i, entity.getSemana());
        ps.setString(++i, entity.getTurma());
        ps.setLong(++i, entity.getUsuario().getId());
        ps.setLong(++i, entity.getBairro().getId());
        ps.setString(++i, entity.getNumeroAtividade());
        ps.setString(++i, entity.getTipoAtividade());

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            entity.setId(rs.getLong("id"));
        }

        rs.close();
        ps.close();

    }

    @Override
    public TratamentoAntiVetorial readById(Long id, Connection conn) throws Exception {
        TratamentoAntiVetorial entity = null;

        String sql = "SELECT boletim_diario.*,usuario.id as usuario_id, usuario.nome as usuario_nome, bairro.id as bairro_id, bairro.nome as bairro_nome FROM boletim_diario LEFT JOIN usuario on usuario.id = boletim_diario.usuario_fk LEFT JOIN bairro on bairro.id = boletim_diario.bairro_fk WHERE boletim_diario.id = ?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            entity = new TratamentoAntiVetorial();
            entity.setId(rs.getLong("id"));
            entity.setDataBoletim(rs.getDate("data_boletim"));
            entity.setNumero(rs.getString("numero"));
            entity.setTurma(rs.getString("turma"));
            entity.setSemana(rs.getString("semana_epidemiologica"));
            entity.setNumeroAtividade(rs.getString("numero_atividade"));
            entity.setTipoAtividade(rs.getString("tipo_atividade"));

            Usuario usuario = new Usuario();
            usuario.setId(rs.getLong("usuario_id"));
            usuario.setNome(rs.getString("usuario_nome"));
            entity.setUsuario(usuario);

            Bairro bairro = new Bairro();
            bairro.setId(rs.getLong("bairro_id"));
            bairro.setNome(rs.getString("bairro_nome"));
            entity.setBairro(bairro);

        }
        rs.close();
        ps.close();
        return entity;

    }

    @Override
    public List<TratamentoAntiVetorial> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        TratamentoAntiVetorial entity = null;
        List<TratamentoAntiVetorial> boletimDiarioList = new ArrayList<TratamentoAntiVetorial>();

        String sql = "SELECT boletim_diario.*,usuario.id as usuario_id, usuario.nome as usuario_nome, bairro.id as bairro_id, bairro.nome as bairro_nome FROM boletim_diario LEFT JOIN usuario on usuario.id = boletim_diario.usuario_fk LEFT JOIN bairro on bairro.id = boletim_diario.bairro_fk WHERE 1 = 1";
        Statement s = conn.createStatement();

        //criterios
        ResultSet rs = s.executeQuery(sql);

        while (rs.next()) {
            entity = new TratamentoAntiVetorial();
            entity.setId(rs.getLong("id"));
            entity.setDataBoletim(rs.getDate("data_boletim"));
            entity.setNumero(rs.getString("numero"));
            entity.setTurma(rs.getString("turma"));
            entity.setSemana(rs.getString("semana_epidemiologica"));
            entity.setNumeroAtividade(rs.getString("numero_atividade"));
            entity.setTipoAtividade(rs.getString("tipo_atividade"));

            Usuario usuario = new Usuario();
            usuario.setId(rs.getLong("usuario_id"));
            usuario.setNome(rs.getString("usuario_nome"));
            entity.setUsuario(usuario);

            Bairro bairro = new Bairro();
            bairro.setId(rs.getLong("bairro_id"));
            bairro.setNome(rs.getString("bairro_nome"));
            entity.setBairro(bairro);

            boletimDiarioList.add(entity);

        }
        rs.close();
        s.close();
        return boletimDiarioList;
    }

    @Override
    public void update(TratamentoAntiVetorial entity, Connection conn) throws Exception {

        String sql = "UPDATE boletim_diario SET data_boletim=?, numero=?, semana=?, turma=?, usuario_fk=?, bairro_fk=?, numero_atividade=?, tipo_atividade=? WHERE id=? ";

        PreparedStatement ps = conn.prepareStatement(sql);

        int i = 0;
        ps.setDate(++i, new Date(entity.getDataBoletim().getTime()));
        ps.setString(++i, entity.getNumero());
        ps.setString(++i, entity.getSemana());
        ps.setString(++i, entity.getTurma());
        ps.setLong(++i, entity.getUsuario().getId());
        ps.setLong(++i, entity.getBairro().getId());
        ps.setString(++i, entity.getNumeroAtividade());
        ps.setString(++i, entity.getTipoAtividade());
        ps.setLong(++i, entity.getId());

        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        String sql = "DELETE FROM boletim_diario  WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ps.execute();
        ps.close();

    }

}
