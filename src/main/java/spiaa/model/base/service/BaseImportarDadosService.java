/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiaa.model.base.service;

import java.util.List;
import spiaa.model.entity.ImportarDados;

/**
 *
 * @author Felipe de Souza
 */
public interface BaseImportarDadosService {
    public List<ImportarDados> readData();
}
