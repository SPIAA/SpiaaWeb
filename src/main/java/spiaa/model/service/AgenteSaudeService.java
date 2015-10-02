package spiaa.model.service;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import spiaa.model.ConnectionManager;
import spiaa.model.base.service.BaseUsuarioService;
import spiaa.model.dao.AgenteSaudeDAO;
import spiaa.model.entity.RecuperarSenha;
import spiaa.model.entity.Usuario;

/**
 *
 * @author William
 */
public class AgenteSaudeService implements BaseUsuarioService {

   @Override
   public Usuario login(String usuario, String senha) throws Exception {
      Usuario agenteSaude = null;
      try {
         Connection conn = ConnectionManager.getInstance().getConnection();
         AgenteSaudeDAO dao = new AgenteSaudeDAO();
         Map<String, Object> criteria = new HashMap<>();
         criteria.put(AgenteSaudeDAO.CRITERION_USUARIO_EQ, usuario);
         criteria.put(AgenteSaudeDAO.CRITERION_SENHA_EQ, senha);
         List<Usuario> usuarioList = dao.readByCriteria(criteria, conn);
         if (usuarioList != null && usuarioList.size() == 1) {
            agenteSaude = usuarioList.get(0);
            if (!agenteSaude.getUsuario().equals(usuario)) {
               agenteSaude = null;
            } else {
               if (!agenteSaude.getSenha().equals(senha)) {
                  agenteSaude = null;
               } else if (!agenteSaude.getTipo().equalsIgnoreCase(AgenteSaudeDAO.TIPO_AGENTE)) {
                  agenteSaude = null;
               }
            }
         }
         conn.close();
      } catch (Exception e) {
         e.printStackTrace();
         throw e;
      }
      return agenteSaude;
   }

   @Override
   public String encodeStrToUTF8(Usuario usuario) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public void recuperarSenhaCreate(RecuperarSenha recuperar) throws Exception {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public void recuperarSenhaDelete(Long id) throws Exception {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public RecuperarSenha recuperarSenhaReadByUserToken(String usuario, String token) throws Exception {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public void enviarEmailRecuperarSenha(RecuperarSenha recuperarSenha) throws Exception {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public void create(Usuario entity) throws Exception {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public Usuario readById(Long id) throws Exception {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public List<Usuario> readByCriteria(Map<String, Object> criteria) throws Exception {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public void update(Usuario entity) throws Exception {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public void delete(Long id) throws Exception {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

}
