package spiaa.model.entity;

import java.util.Date;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import spiaa.model.base.BaseEntity;

public class TratamentoAntiVetorial extends BaseEntity {

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataBoletim;
    private String numero;
    private String semana;
    private String turma;
    private String numeroAtividade;
    private String tipoAtividade;
    private Usuario usuario;
    private Bairro bairro;
    private List<Atividade> atividadeList;

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

    public Date getDataBoletim() {
        return dataBoletim;
    }

    public void setDataBoletim(Date dataBoletim) {
        this.dataBoletim = dataBoletim;
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

    public List<Atividade> getAtividadeList() {
        return atividadeList;
    }

    public void setAtividadeList(List<Atividade> atividadeList) {
        this.atividadeList = atividadeList;
    }
}
