package spiaa.model.entity;

import java.util.List;

public class ImportarDados {
    private List<Bairro> bairroList;
    private List<TipoImoveis> tipoImoveisList;
    private List<Criadouro> criadouroList;
    private List<Inseticida> inseticidaLost;

    public List<Bairro> getBairroList() {
        return bairroList;
    }

    public void setBairroList(List<Bairro> bairroList) {
        this.bairroList = bairroList;
    }

    public List<TipoImoveis> getTipoImoveisList() {
        return tipoImoveisList;
    }

    public void setTipoImoveisList(List<TipoImoveis> tipoImoveisList) {
        this.tipoImoveisList = tipoImoveisList;
    }

    public List<Criadouro> getCriadouroList() {
        return criadouroList;
    }

    public void setCriadouroList(List<Criadouro> criadouroList) {
        this.criadouroList = criadouroList;
    }

    public List<Inseticida> getInseticidaLost() {
        return inseticidaLost;
    }

    public void setInseticidaLost(List<Inseticida> inseticidaLost) {
        this.inseticidaLost = inseticidaLost;
    }
}
