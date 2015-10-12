package spiaa.model.base.service;

import spiaa.model.base.BaseService;
import spiaa.model.entity.RecuperarSenha;
import spiaa.model.entity.Usuario;

public interface BaseUsuarioService extends BaseService<Usuario> {

    public Usuario login(String usuario, String senha) throws Exception;

    public String encodeStrToUTF8(Usuario usuario);

    public void recuperarSenhaCreate(RecuperarSenha recuperar) throws Exception;

    public void recuperarSenhaDelete(Long id) throws Exception;

    public RecuperarSenha recuperarSenhaReadByUserToken(String usuario, String token) throws Exception;

    public void enviarEmailRecuperarSenha(RecuperarSenha recuperarSenha) throws Exception;

    public void redefinirSenha(RecuperarSenha recuperar) throws Exception;

}
