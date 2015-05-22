package spiaa.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import spiaa.model.base.BaseDAO;
import spiaa.model.entity.Usuario;

public class UsuarioDAO implements BaseDAO<Usuario> {

    public static final String CRITERION_USUARIO_EQ = "1";
    public static final String CRITERION_SENHA_EQ = "2";

    @Override
    public void create(Usuario entity, Connection conn) throws Exception {
        String sql = "INSERT INTO usuario(nome, usuario, senha, email, tipo) VALUES (?, ?, ?, ?, ?) RETURNING id";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, entity.getNome().trim());
        ps.setString(++i, entity.getUsuario().trim());
        ps.setString(++i, entity.getSenha().trim());
        ps.setString(++i, entity.getEmail().trim());
        ps.setString(++i, entity.getTipo().trim());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            entity.setId(rs.getLong("id"));
        }
        ps.close();
        rs.close();
    }

    @Override
    public Usuario readById(Long id, Connection conn) throws Exception {
        Usuario usuario = null;
        String sql = "SELECT * FROM usuario WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            usuario = new Usuario();
            usuario.setId(rs.getLong("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setUsuario(rs.getString("usuario"));
            usuario.setTipo(rs.getString("tipo"));
            usuario.setEmail(rs.getString("email"));
            usuario.setSenha(rs.getString("senha"));
        }
        ps.close();
        rs.close();
        return usuario;
    }

    @Override
    public List<Usuario> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<Usuario> usuarioList = new ArrayList<>();
        Usuario usuario = null;
        String sql = "SELECT * FROM usuario WHERE 1=1";
        Statement s = conn.createStatement();

        String criterionUsuarioEq = (String) criteria.get(CRITERION_USUARIO_EQ);
        if (criterionUsuarioEq != null && !criterionUsuarioEq.trim().isEmpty()) {
            sql += " AND usuario = '" + criterionUsuarioEq + "'";
        }

        String criterionSenhaEq = (String) criteria.get(CRITERION_SENHA_EQ);
        if (criterionSenhaEq != null && !criterionSenhaEq.trim().isEmpty()) {
            sql += " AND senha = '" + criterionSenhaEq + "'";
        }

        ResultSet rs = s.executeQuery(sql);

        while (rs.next()) {
            usuario = new Usuario();
            usuario.setId(rs.getLong("id"));
            usuario.setEmail(rs.getString("email"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setUsuario(rs.getString("usuario"));
            usuario.setNome(rs.getString("nome"));
            usuarioList.add(usuario);
        }
        s.close();
        rs.close();
        return usuarioList;
    }

    @Override
    public void update(Usuario entity, Connection conn) throws Exception {
        String sql = "UPDATE usuario SET nome=?, usuario=?, senha=?, email=?, tipo=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, entity.getNome());
        ps.setString(++i, entity.getUsuario());
        ps.setString(++i, entity.getSenha());
        ps.setString(++i, entity.getEmail());
        ps.setString(++i, entity.getTipo());
        ps.setLong(++i, entity.getId());
        ps.execute();
        ps.close();

    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        String sql = "DELETE FROM usuario WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ps.execute();
        ps.close();
    }

}
