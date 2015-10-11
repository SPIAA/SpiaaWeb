package spiaa.model.entity;

import java.util.List;
import spiaa.model.base.BaseEntity;

/**
 *
 * @author William
 */
public class UsuarioBairro extends BaseEntity {

    private Bairro bairro;
    private Usuario usuario;

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
