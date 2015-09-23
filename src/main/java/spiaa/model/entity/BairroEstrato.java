package spiaa.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BairroEstrato {

    private Integer codigo;
    private Integer armazem;
    private Integer resindencia;
    private Integer imovel;
    private Integer comercio;
    private Integer predio;
    private Integer terrenoBaldio;
    private Integer habitante;
    private Integer outros;
    private Date ultimaAtualizacao;
    private Bairro bairro;
    
    private List<BairroCriadouro> bairroCriadouroList;
    private List<Criadouro> criadouroList;

    public BairroEstrato() {
        bairroCriadouroList = new ArrayList<>();
        criadouroList = new ArrayList<>();
    }
    

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getArmazem() {
        return armazem;
    }

    public void setArmazem(Integer armazem) {
        this.armazem = armazem;
    }

    public Integer getResindencia() {
        return resindencia;
    }

    public void setResindencia(Integer resindencia) {
        this.resindencia = resindencia;
    }

    public Integer getImovel() {
        return imovel;
    }

    public void setImovel(Integer imovel) {
        this.imovel = imovel;
    }

    public Integer getComercio() {
        return comercio;
    }

    public void setComercio(Integer comercio) {
        this.comercio = comercio;
    }

    public Integer getPredio() {
        return predio;
    }

    public void setPredio(Integer predio) {
        this.predio = predio;
    }

    public Integer getTerrenoBaldio() {
        return terrenoBaldio;
    }

    public void setTerrenoBaldio(Integer terrenoBaldio) {
        this.terrenoBaldio = terrenoBaldio;
    }

    public Integer getHabitante() {
        return habitante;
    }

    public void setHabitante(Integer habitante) {
        this.habitante = habitante;
    }

    public Integer getOutros() {
        return outros;
    }

    public void setOutros(Integer outros) {
        this.outros = outros;
    }

    public Date getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(Date ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public List<BairroCriadouro> getBairroCriadouroList() {
        return bairroCriadouroList;
    }

    public void setBairroCriadouroList(List<BairroCriadouro> bairroCriadouroList) {
        this.bairroCriadouroList = bairroCriadouroList;
    }

    public List<Criadouro> getCriadouroList() {
        return criadouroList;
    }

    public void setCriadouroList(List<Criadouro> criadouroList) {
        this.criadouroList = criadouroList;
    }

}
