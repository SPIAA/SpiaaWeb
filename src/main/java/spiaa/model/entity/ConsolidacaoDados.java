package spiaa.model.entity;

import java.util.ArrayList;
import java.util.List;
import spiaa.model.base.BaseEntity;

public class ConsolidacaoDados extends BaseEntity {

    private Integer programados;
    private Integer inspecionados;
    private Integer terrenobaldio;
    private Integer outros;

    private List<ConsolidacaoCriadouro> consolidacaoCriadouroList;
    private Liraa liraa;
    private Estrato estrato;

    public ConsolidacaoDados() {
        consolidacaoCriadouroList = new ArrayList<ConsolidacaoCriadouro>();
    }

    public Integer getProgramados() {
        return programados;
    }

    public void setProgramados(Integer programados) {
        this.programados = programados;
    }

    public Integer getInspecionados() {
        return inspecionados;
    }

    public void setInspecionados(Integer inspecionados) {
        this.inspecionados = inspecionados;
    }

    public Integer getTerrenobaldio() {
        return terrenobaldio;
    }

    public void setTerrenobaldio(Integer terrenobaldio) {
        this.terrenobaldio = terrenobaldio;
    }

    public Integer getOutros() {
        return outros;
    }

    public void setOutros(Integer outros) {
        this.outros = outros;
    }

    public Liraa getLiraa() {
        return liraa;
    }

    public void setLiraa(Liraa liraa) {
        this.liraa = liraa;
    }

    public Estrato getEstrato() {
        return estrato;
    }

    public void setEstrato(Estrato estrato) {
        this.estrato = estrato;
    }

    public List<ConsolidacaoCriadouro> getConsolidacaoCriadouroList() {
        return consolidacaoCriadouroList;
    }

    public void setConsolidacaoCriadouroList(List<ConsolidacaoCriadouro> consolidacaoCriadouroList) {
        this.consolidacaoCriadouroList = consolidacaoCriadouroList;
    }
}
