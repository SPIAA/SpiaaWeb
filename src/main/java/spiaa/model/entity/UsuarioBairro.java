package spiaa.model.entity;

import java.util.List;
import spiaa.model.base.BaseEntity;

/**
 *
 * @author William
 */
public class UsuarioBairro extends BaseEntity {

   private List<Bairro> bairros;

   public List<Bairro> getBairros() {
      return bairros;
   }

   public void setBairros(List<Bairro> bairros) {
      this.bairros = bairros;
   }
}
