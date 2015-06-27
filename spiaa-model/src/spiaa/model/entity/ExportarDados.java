/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiaa.model.entity;

import java.util.List;

/**
 *
 * @author Felipe de Souza
 */
public class ExportarDados {		
    private List<BoletimDiario> boletimDiarioList;		
		
    public List<BoletimDiario> getBoletimDiarioList() {		
       return boletimDiarioList;		
    }		
		
    public void setBoletimDiarioList(List<BoletimDiario> boletimDiarioList) {		
        this.boletimDiarioList = boletimDiarioList;		
    }		
}