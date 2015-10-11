package spiaa.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import spiaa.model.base.BaseDAO;
import spiaa.model.entity.Bairro;
import spiaa.model.entity.Usuario;
import spiaa.model.entity.UsuarioBairro;

/**
 *
 * @author William
 */
public class UsuarioBairroDAO implements BaseDAO<UsuarioBairro> {

    public static final String CRITERION_USUARIO_ID_EQ = "1";
    public static final String CRITERION_BAIRRO_ID_EQ = "2";

    @Override
    public void create(UsuarioBairro entity, Connection conn) throws Exception {
        String sql = "INSERT INTO usuario_bairro(usuario_fk, bairro_fk) VALUES (?, ?);";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setLong(++i, entity.getUsuario().getId());
        ps.setLong(++i, entity.getBairro().getId());

        ps.execute();
        ps.close();
    }

    @Override
    public UsuarioBairro readById(Long id, Connection conn) throws Exception {
        String sql = "select * from usuario_bairro ub"
                + " inner join bairro b on ub.bairro_fk=b.id"
                + " inner join usuario u on u.id=ub.usuario_fk "
                + " and ub.usuario_fk=?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        UsuarioBairro bairroUsuarioList = new UsuarioBairro();
        List<Bairro> bairros = new ArrayList<>();

        while (rs.next()) {
            Bairro bairro = new Bairro();
            bairro.setId(rs.getLong("id"));
            bairro.setNome(rs.getString("nome"));
            bairroUsuarioList.setBairro(bairro);
        }

        return bairroUsuarioList;
    }

    @Override
    public List<UsuarioBairro> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {

        List<UsuarioBairro> usuarioBairroList = new ArrayList<>();
        UsuarioBairro usuarioBairro = null;
        String sql = "  select usuario_bairro .*, usuario.id as usuario_id, usuario.nome as usuario_nome, ";
        sql += " bairro.id as bairro_id, bairro.nome as bairro_nome from usuario_bairro ";
        sql += " left join bairro  on bairro.id = usuario_bairro.bairro_fk  ";
        sql += " left join usuario on  usuario.id  = usuario_bairro.usuario_fk WHERE 1=1 ";

        Long criterionUsuarioEq = (Long) criteria.get(CRITERION_USUARIO_ID_EQ);
        if (criterionUsuarioEq != null && criterionUsuarioEq > 0) {
            sql += " AND usuario_bairro.usuario_fk = " + criterionUsuarioEq;
        }

        Long criterionBairroEq = (Long) criteria.get(CRITERION_BAIRRO_ID_EQ);
        if (criterionBairroEq != null && criterionBairroEq > 0) {
            sql += " AND usuario_bairro.bairro_fk = " + criterionBairroEq;
        }

        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(sql);

        while (rs.next()) {
            usuarioBairro = new UsuarioBairro();
            Bairro bairro = new Bairro();
            bairro.setId(rs.getLong("bairro_id"));
            bairro.setNome(rs.getString("bairro_nome"));
            usuarioBairro.setBairro(bairro);

            Usuario usuario = new Usuario();
            usuario.setId(rs.getLong("usuario_id"));
            usuario.setNome(rs.getString("usuario_nome"));
            usuarioBairro.setUsuario(usuario);

            usuarioBairroList.add(usuarioBairro);
        }
        s.close();
        rs.close();
        return usuarioBairroList;

    }

    @Override
    public void update(UsuarioBairro entity, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
    }

    public void deleteByUsuarioId(Long id, Connection conn) throws Exception {
        String sql = "DELETE FROM usuario_bairro WHERE usuario_fk = ? ";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ps.execute();
        ps.close();
    }

    public void deleteByBairroId(Long id, Connection conn) throws Exception {
        String sql = "DELETE FROM usuario_bairro WHERE bairro_fk = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ps.execute();
        ps.close();
    }
}
