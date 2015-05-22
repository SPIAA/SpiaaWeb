package spiaa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import spiaa.model.entity.ExportarDados;
import spiaa.model.entity.ImportarDados;

@Controller
public class SincronizarController {

    @RequestMapping(value = "/sincronizar/importar", method = RequestMethod.GET)
    public ImportarDados importar() {
        ImportarDados importar = new ImportarDados();
        return importar;
    }

    @RequestMapping(value = "/sincronizar/importar", method = RequestMethod.GET)
    public ExportarDados exportar() {
        ExportarDados exportar = new ExportarDados();
        return exportar;
    }
}
