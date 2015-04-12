package spiaa.model.entity;

import spiaa.model.base.BaseEntity;

public class Criadouro extends BaseEntity {

    private String grupo;
    private String recipiente ;

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getRecipiente() {
        return recipiente;
    }

    public void setRecipiente(String recipiente) {
        this.recipiente = recipiente;
    }

    
}
