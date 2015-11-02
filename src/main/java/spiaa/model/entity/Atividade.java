package spiaa.model.entity;

import java.util.Date;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import spiaa.model.base.BaseEntity;

public class Atividade extends BaseEntity {

    private String endereco;
    private Quarteirao quarteirao;
    private String numero;
    private String observacao;
    private String latitude;
    private String longitude;
    private Integer inspecionado;
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm")
    private Date dataInicial;
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm")
    private Date dataFinal;
    private TipoImoveis tipoImoveis;
    private List<AtividadeCriadouro> atividadeCriadouroList;
    private List<AtividadeInseticida> atividadeInseticidasList;
    private TratamentoAntiVetorial boletimDiario;

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Quarteirao getQuarteirao() {
        return quarteirao;
    }

    public void setQuarteirao(Quarteirao quarteirao) {
        this.quarteirao = quarteirao;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Integer getInspecionado() {
        return inspecionado;
    }

    public void setInspecionado(Integer inspecionado) {
        this.inspecionado = inspecionado;
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

    public TratamentoAntiVetorial getBoletimDiario() {
        return boletimDiario;
    }

    public void setBoletimDiario(TratamentoAntiVetorial boletimDiario) {
        this.boletimDiario = boletimDiario;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

}
