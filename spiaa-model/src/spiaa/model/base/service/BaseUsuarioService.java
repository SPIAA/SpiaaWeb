
package spiaa.model.base.service;

import spiaa.model.base.BaseService;
import spiaa.model.entity.Usuario;


public interface BaseUsuarioService extends BaseService<Usuario>{
    public Usuario login(String usuario, String senha) throws Exception;
    public void endoceStrToUTF8(Usuario usuario);
}
