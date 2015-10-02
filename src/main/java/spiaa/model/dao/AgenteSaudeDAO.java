package spiaa.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import spiaa.model.base.BaseDAO;
import spiaa.model.entity.Usuario;

/**
 *
 * @author William
 */
public class AgenteSaudeDAO implements BaseDAO<Usuario> {

   public static final String CRITERION_USUARIO_EQ = "1";
   public static final String CRITERION_SENHA_EQ = "2";
   public static final String TIPO_AGENTE = "AGS";

   @Override
   public void create(Usuario entity, Connection conn) throws Exception {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public Usuario readById(Long id, Connection conn) throws Exception {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public List<Usuario> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
      List<Usuario> agenteSaudeList = new ArrayList<>();
      Usuario agenteSaude = null;
      String sql = "SELECT * FROM usuario u WHERE u.tipo ILIKE '" + TIPO_AGENTE + "'";

      String criterionUsuarioEq = (String) criteria.get(CRITERION_USUARIO_EQ);
      if (criterionUsuarioEq != null && !criterionUsuarioEq.trim().isEmpty()) {
         sql += " AND u.usuario = '" + criterionUsuarioEq + "'";
      }

      String criterionSenhaEq = (String) criteria.get(CRITERION_SENHA_EQ);
      if (criterionSenhaEq != null && !criterionSenhaEq.trim().isEmpty()) {
         sql += " AND u.senha = '" + criterionSenhaEq + "'";
      }

      Statement s = conn.createStatement();
      ResultSet rs = s.executeQuery(sql);

      while (rs.next()) {
         agenteSaude = new Usuario();
         agenteSaude.setId(rs.getLong("id"));
         agenteSaude.setEmail(rs.getString("email"));
         agenteSaude.setSenha(rs.getString("senha"));
         agenteSaude.setUsuario(rs.getString("usuario"));
         agenteSaude.setNome(rs.getString("nome"));
         agenteSaude.setTipo(rs.getString("tipo"));
         agenteSaude.setNumero(rs.getString("numero"));
         agenteSaude.setTurma(rs.getString("turma"));
         agenteSaudeList.add(agenteSaude);
      }
      s.close();
      rs.close();
      return agenteSaudeList;
   }

   @Override
   public void update(Usuario entity, Connection conn) throws Exception {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public void delete(Long id, Connection conn) throws Exception {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

}
