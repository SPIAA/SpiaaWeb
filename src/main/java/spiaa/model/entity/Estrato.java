package spiaa.model.entity;

import java.util.ArrayList;
import java.util.List;
import spiaa.model.base.BaseEntity;

public class Estrato extends BaseEntity {

    private String nome;
    private String cor;
    private List<BairroEstrato> bairroEstratoList;

    public Estrato() {
        bairroEstratoList = new ArrayList<BairroEstrato>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<BairroEstrato> getBairroEstratoList() {
        return bairroEstratoList;
    }

    public void setBairroEstratoList(List<BairroEstrato> bairroEstratoList) {
        this.bairroEstratoList = bairroEstratoList;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
