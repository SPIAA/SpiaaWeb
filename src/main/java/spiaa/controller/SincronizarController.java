/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiaa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spiaa.model.entity.ExportarDados;
import spiaa.model.entity.ImportarDados;

/**
 *
 * @author Felipe de Souza
 */
@Controller		
public class SincronizarController {		
		
    @RequestMapping(value = "/sincronizar/importar", method = RequestMethod.GET)		
    public ImportarDados importar() {		
        ImportarDados importar = new ImportarDados();		
        return importar;		
    }		
		
    @RequestMapping(value = "/sincronizar/exportar", method = RequestMethod.GET)		
    public ExportarDados exportar() {		
       ExportarDados exportar = new ExportarDados();		
        return exportar;		
    }		
}
