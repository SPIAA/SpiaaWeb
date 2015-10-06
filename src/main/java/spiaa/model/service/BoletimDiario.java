package spiaa.model.service;

import java.util.Date;
import spiaa.model.base.BaseEntity;
import spiaa.model.entity.Bairro;
import spiaa.model.entity.Usuario;

/**
 *
 * @author Felipe de Souza
 */
public class BoletimDiario extends BaseEntity {

    private Date dataBoletim;
    private String numero;
    private String semana;
    private String turma;
    private String categoria;
    private String numeroAtividade;
    private String tipoAtividade;
    private Usuario usuario;
    private Bairro bairro;

    public Date getDataBoletim() {
        return dataBoletim;
    }

    public void setDataBoletim(Date dataBoletim) {
        this.dataBoletim = dataBoletim;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getSemana() {
        return semana;
    }

    public void setSemana(String semana) {
        this.semana = semana;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNumeroAtividade() {
        return numeroAtividade;
    }

    public void setNumeroAtividade(String numeroAtividade) {
        this.numeroAtividade = numeroAtividade;
    }

    public String getTipoAtividade() {
        return tipoAtividade;
    }

    public void setTipoAtividade(String tipoAtividade) {
        this.tipoAtividade = tipoAtividade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    
}
