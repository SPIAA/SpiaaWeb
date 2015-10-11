package spiaa.model.entity;

import java.util.Date;
import spiaa.model.base.BaseEntity;

public class Denuncia extends BaseEntity {

    public static final String STATUS_ABERTA = "Aberta";
    public static final String STATUS_FECHADA = "Fechada";
    public static final String STATUS_ENCAMINHADA = "Encaminhada";

    private String endereco;
    private String numero;
    private String telefone;
    private String irregularidade;
    private String observacao;
    private String status;
    private String conclusao;
    private Bairro bairro;
    private Usuario usuario;
    private Date dataAbertura;
    private Date dataFinalizacao;

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getConclusao() {
        return conclusao;
    }

    public void setConclusao(String conclusao) {
        this.conclusao = conclusao;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public String getIrregularidade() {
        return irregularidade;
    }

    public void setIrregularidade(String irregularidade) {
        this.irregularidade = irregularidade;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataFinalizacao() {
        return dataFinalizacao;
    }

    public void setDataFinalizacao(Date dataFinalizacao) {
        this.dataFinalizacao = dataFinalizacao;
    }

}
