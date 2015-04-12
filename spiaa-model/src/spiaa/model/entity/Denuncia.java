package spiaa.model.entity;

import spiaa.model.base.BaseEntity;

public class Denuncia extends BaseEntity {

    private String endereco;
    private String numero;
    private String telefone;
    private String irregularidade;
    private String observacao;
    private String status;
    private String conlusao;
    private Bairro bairro;

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

    public String getConlusao() {
        return conlusao;
    }

    public void setConlusao(String conlusao) {
        this.conlusao = conlusao;
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

}
