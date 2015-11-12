/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spiaa.model.service;

import java.sql.Connection;
import java.util.Date;
import java.util.List;
import spiaa.model.ConnectionManager;
import spiaa.model.dao.RelatorioDAO;
import spiaa.model.entity.relatorio.ImoveisVisitadorPorAgentes;

/**
 *
 * @author Felipe de Souza
 */
public class RelatorioService {

    public List<ImoveisVisitadorPorAgentes> readImoveisVisitadorPorAgentes(Date dataInicial, Date dataFinal) throws Exception {
        List<ImoveisVisitadorPorAgentes> imoveisVisitados = null;
        Connection conn = ConnectionManager.getInstance().getConnection();
        RelatorioDAO dao = new RelatorioDAO();

        imoveisVisitados = dao.readImoveisVisitadorPorAgentes(dataInicial, dataFinal, conn);
        
        conn.close();
        
        return imoveisVisitados;
    }
}
