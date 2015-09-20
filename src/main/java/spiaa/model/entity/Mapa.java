package spiaa.model.entity;

import java.util.ArrayList;
import java.util.List;
import spiaa.model.base.BaseEntity;

public class Mapa extends BaseEntity{

    private List<AtividadeCriadouro> atividadeCriadouroList = null;

    public Mapa() {
        atividadeCriadouroList = new ArrayList<>();
    }

    public List<AtividadeCriadouro> getAtividadeCriadouroList() {
        return atividadeCriadouroList;
    }

    public void setAtividadeCriadouroList(List<AtividadeCriadouro> atividadeCriadouroList) {
        this.atividadeCriadouroList = atividadeCriadouroList;
    }
}
