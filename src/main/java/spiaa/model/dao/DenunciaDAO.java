package spiaa.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;
import spiaa.model.base.BaseDAO;
import spiaa.model.entity.Bairro;
import spiaa.model.entity.Denuncia;
import spiaa.model.entity.Usuario;

@Repository
public class DenunciaDAO implements BaseDAO<Denuncia> {

    public static final String CRITERION_AGENTE_ID = "0";
    public static final String CRITERION_STATUS_ENCAMINHADA = "1";

    @Override
    public void create(Denuncia entity, Connection conn) throws Exception {
        String sql = "INSERT INTO denuncia(endereco, numero, telefone, irregularidade, observacao, status ,bairro_fk)VALUES (?, ?, ?, ?, ?, ?, ?);";

        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;

        ps.setString(++i, entity.getEndereco());
        ps.setString(++i, entity.getNumero());
        ps.setString(++i, entity.getTelefone());
        ps.setString(++i, entity.getIrregularidade());
        ps.setString(++i, entity.getObservacao());
        ps.setString(++i, Denuncia.STATUS_ABERTA);
        ps.setLong(++i, entity.getBairro().getId());
        ps.execute();

        ps.close();

    }

    @Override
    public Denuncia readById(Long id, Connection conn) throws Exception {
        Denuncia denuncia = new Denuncia();
        String sql = "SELECT denuncia .*,bairro.id as bairro_id, bairro.nome as bairro_nome from denuncia left join bairro on bairro.id = denuncia.bairro_fk WHERE denuncia.id =?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            denuncia.setId(rs.getLong("id"));
            denuncia.setEndereco(rs.getString("endereco"));
            denuncia.setNumero(rs.getString("numero"));
            denuncia.setTelefone(rs.getString("telefone"));
            denuncia.setObservacao(rs.getString("observacao"));
            denuncia.setIrregularidade(rs.getString("irregularidade"));
            denuncia.setConclusao(rs.getString("conclusao"));
            denuncia.setStatus(rs.getString("status"));

            Bairro bairro = new Bairro();
            bairro.setId(rs.getLong("bairro_id"));
            bairro.setNome(rs.getString("bairro_nome"));
            denuncia.setBairro(bairro);

            Usuario usuario = new Usuario();
            usuario.setId(rs.getLong("usuario_fk"));
            denuncia.setUsuario(usuario);
        }

        return denuncia;
    }

    @Override
    public List<Denuncia> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<Denuncia> denunciaList = new ArrayList<>();
        Denuncia entity;
        String sql = "SELECT denuncia .*,bairro.id as bairro_id, bairro.nome as bairro_nome,";
        sql += " usuario.id as usuario_is, usuario.nome as usuario_nome from denuncia ";
        sql += " left join bairro on bairro.id = denuncia.bairro_fk ";
        sql += " left join usuario on usuario.id = denuncia.usuario_fk WHERE 1=1";

        Long criterionUsuarioId = (Long) criteria.get(CRITERION_AGENTE_ID);
        if (criterionUsuarioId != null) {
            sql += " and denuncia.usuario_fk=" + criterionUsuarioId;
        }
        String criterionStatusEncaminhada = (String) criteria.get(CRITERION_STATUS_ENCAMINHADA);
        if (criterionStatusEncaminhada != null && criterionStatusEncaminhada.trim() != "") {
            sql += " and denuncia.status = '" + criterionStatusEncaminhada + "' ";
        }

        Statement s = conn.createStatement();

        ResultSet rs = s.executeQuery(sql);
        while (rs.next()) {
            entity = new Denuncia();
            entity.setId(rs.getLong("id"));
            entity.setEndereco(rs.getString("endereco"));
            entity.setNumero(rs.getString("numero"));
            entity.setTelefone(rs.getString("telefone"));
            entity.setIrregularidade(rs.getString("irregularidade"));
            entity.setObservacao(rs.getString("observacao"));
            entity.setConclusao(rs.getString("conclusao"));
            entity.setStatus(rs.getString("status"));

            Bairro bairro = new Bairro();
            bairro.setId(rs.getLong("bairro_id"));
            bairro.setNome(rs.getString("bairro_nome"));

            Usuario usuario = new Usuario();
            usuario.setId(rs.getLong("usuario_fk"));
            usuario.setNome(rs.getString("usuario_nome"));

            entity.setBairro(bairro);
            entity.setUsuario(usuario);

            denunciaList.add(entity);
        }
        return denunciaList;
    }

    @Override
    public void update(Denuncia entity, Connection conn) throws Exception {
        String sql = " UPDATE denuncia  SET observacao=?, status=?, usuario_fk=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, entity.getObservacao());
        ps.setString(++i, entity.getStatus());
        ps.setLong(++i, entity.getUsuario().getId());
        ps.setLong(++i, entity.getId());
        ps.execute();
        ps.close();
    }

    public void fechar(Denuncia entity, Connection conn) throws Exception {
        String sql = " UPDATE denuncia  SET observacao=?, status=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, entity.getObservacao());
        ps.setString(++i, entity.getStatus());
        ps.setLong(++i, entity.getId());
        ps.execute();
        ps.close();
    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
