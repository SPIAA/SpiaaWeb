/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiaa.model.entity.relatorio;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import spiaa.model.entity.Usuario;

/**
 *
 * @author Felipe de Souza
 */
public class ImoveisVisitadorPorAgentes {

    private String periodo;
    private Usuario usuario;
    private Integer diasTrabalhados;
    private Integer imoveisVisitados;
    private Date dataInicial;
    private Date dataFinal;

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Integer getDiasTrabalhados() {
        return diasTrabalhados;
    }

    public void setDiasTrabalhados(Integer diasTrabalhados) {
        this.diasTrabalhados = diasTrabalhados;
    }

    public Integer getImoveisVisitados() {
        return imoveisVisitados;
    }

    public void setImoveisVisitados(Integer imoveisVisitados) {
        this.imoveisVisitados = imoveisVisitados;
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
