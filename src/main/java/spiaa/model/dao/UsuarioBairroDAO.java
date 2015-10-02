package spiaa.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import spiaa.model.base.BaseDAO;
import spiaa.model.entity.Bairro;
import spiaa.model.entity.UsuarioBairro;

/**
 *
 * @author William
 */
public class UsuarioBairroDAO implements BaseDAO<UsuarioBairro> {

   @Override
   public void create(UsuarioBairro entity, Connection conn) throws Exception {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
      UsuarioBairro bu = new UsuarioBairro();
      List<Bairro> bairros = new ArrayList<>();

      while (rs.next()) {
         Bairro bairro = new Bairro();
         bairro.setId(rs.getLong("id"));
         bairro.setCoordenadas(rs.getString("coordenadas"));
         bairro.setNome(rs.getString("nome"));
         bairros.add(bairro);
      }

      bu.setBairros(bairros);

      return bu;
   }

   @Override
   public List<UsuarioBairro> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
      return null;
   }

   @Override
   public void update(UsuarioBairro entity, Connection conn) throws Exception {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

   @Override
   public void delete(Long id, Connection conn) throws Exception {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   }

}
