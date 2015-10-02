package spiaa.model.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;
import spiaa.model.ConnectionManager;
import spiaa.model.base.BaseService;
import spiaa.model.dao.UsuarioBairroDAO;
import spiaa.model.entity.UsuarioBairro;

/**
 *
 * @author William
 */
public class UsuarioBairroService implements BaseService<UsuarioBairro> {

   @Override
   public void create(UsuarioBairro entity) throws Exception {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public UsuarioBairro readById(Long id) throws Exception {
      Connection conn = ConnectionManager.getInstance().getConnection();
      UsuarioBairroDAO dao = new UsuarioBairroDAO();
      UsuarioBairro bairros = dao.readById(id, conn);
      conn.close();
      return bairros;
   }

   @Override
   public List<UsuarioBairro> readByCriteria(Map<String, Object> criteria) throws Exception {
      Connection conn = ConnectionManager.getInstance().getConnection();
      UsuarioBairroDAO dao = new UsuarioBairroDAO();
      List<UsuarioBairro> bairros = dao.readByCriteria(criteria, conn);
      conn.close();
      return bairros;
   }

   @Override
   public void update(UsuarioBairro entity) throws Exception {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public void delete(Long id) throws Exception {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

}
