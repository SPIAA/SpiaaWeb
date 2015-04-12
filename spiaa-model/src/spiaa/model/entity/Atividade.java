package spiaa.model.entity;

import java.util.ArrayList;
import java.util.List;
import spiaa.model.base.BaseEntity;

public class Atividade extends BaseEntity{
    private String endereco;
    private String quarteirao;
    private String numero;
    private String observacao;
    private Integer inspecionado;
    private TipoImoveis tipoImoveis;
    private List<AtividadeCriadouro> atividadeCriadouroList;
    private List<AtividadeInseticida> atividadeInseticidasList;
    private BoletimDiario boletimDiario;

    public Atividade() {
        atividadeCriadouroList = new ArrayList<AtividadeCriadouro>();
        atividadeInseticidasList = new ArrayList<AtividadeInseticida>();
    }
   
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getQuarteirao() {
        return quarteirao;
    }

    public void setQuarteirao(String quarteirao) {
        this.quarteirao = quarteirao;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public TipoImoveis getTipoImoveis() {
        return tipoImoveis;
    }

    public void setTipoImoveis(TipoImoveis tipoImoveis) {
        this.tipoImoveis = tipoImoveis;
    }

    public List<AtividadeCriadouro> getAtividadeCriadouroList() {
        return atividadeCriadouroList;
    }

    public void setAtividadeCriadouroList(List<AtividadeCriadouro> atividadeCriadouroList) {
        this.atividadeCriadouroList = atividadeCriadouroList;
    }

    public List<AtividadeInseticida> getAtividadeInseticidasList() {
        return atividadeInseticidasList;
    }

    public void setAtividadeInseticidasList(List<AtividadeInseticida> atividadeInseticidasList) {
        this.atividadeInseticidasList = atividadeInseticidasList;
    }

    public BoletimDiario getBoletimDiario() {
        return boletimDiario;
    }

    public void setBoletimDiario(BoletimDiario boletimDiario) {
        this.boletimDiario = boletimDiario;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Integer getInspecionado() {
        return inspecionado;
    }

    public void setInspecionado(Integer inspecionado) {
        this.inspecionado = inspecionado;
    } 
    
}
