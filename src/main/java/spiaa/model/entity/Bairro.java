package spiaa.model.entity;

import java.util.List;
import spiaa.model.base.BaseEntity;

public class Bairro extends BaseEntity {

    private String nome;
    private String coordenadas;
    private Long codigo;
    private List<AtividadeCriadouro> totalCriadouro;

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

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public List<AtividadeCriadouro> getTotalCriadouro() {
        return totalCriadouro;
    }

    public void setTotalCriadouro(List<AtividadeCriadouro> totalCriadouro) {
        this.totalCriadouro = totalCriadouro;
    }

    

}
