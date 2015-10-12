package spiaa.model.entity;

import java.util.List;
import spiaa.model.base.BaseEntity;

public class Bairro extends BaseEntity {

    private String nome;
    private String coordenadas;
    private List<AtividadeCriadouro> totalCriadouro;
    private List<Quarteirao> quarteiraoList;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public void setCoordenadas(String coordenadas) {
        this.coordenadas = coordenadas;
    }

    public List<AtividadeCriadouro> getTotalCriadouro() {
        return totalCriadouro;
    }

    public void setTotalCriadouro(List<AtividadeCriadouro> totalCriadouro) {
        this.totalCriadouro = totalCriadouro;
    }

    public List<Quarteirao> getQuarteiraoList() {
        return quarteiraoList;
    }

    public void setQuarteiraoList(List<Quarteirao> quarteiraoList) {
        this.quarteiraoList = quarteiraoList;
    }

}
