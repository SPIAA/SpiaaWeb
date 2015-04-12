package spiaa;

import java.sql.Connection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import spiaa.model.ConnectionManager;
import spiaa.model.dao.ConsolidacaoDadosDAO;
import spiaa.model.entity.ConsolidacaoDados;

public class main {

    public static void main(String[] args) throws ParseException, Exception {
        Connection conn = ConnectionManager.getInstance().getConnection();

//        AnoDAO anodao = new AnoDAO();
//        Ano ano = new Ano();
//        ano.setDateAno("2013");
//        ano.setId(2L);
//        anodao.create(ano, conn);
//       

//        Estrato estrato = new Estrato();
//        EstratoDAO estratodao = new EstratoDAO();
//        estrato.setNome("estrato 01");
//        estrato.setAno(ano);
//        estrato.setId(2L);
//        estratodao.create(estrato, conn);

//        Liraa liraa = new Liraa();
//        LiraaDAO liraadao = new LiraaDAO();
//        liraa = liraadao.readById(1L, conn);
        
//        liraa.setProgramados(20);
//        liraa.setInspecionados(18);
//        liraa.setTerrenobaldio(13);
//        liraa.setOutros(14);
//
//        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
//        Date date = (Date) formatter.parse("03/23/2014");
//        liraa.setDataLira(date);

      //  liraa.setEstrato(estrato);

       //  liraadao.create(liraa, conn);
        // liraa = liraadao.readById(1L, conn);
        
//               Bairro bairro = new Bairro();
//        bairro.setId(3L);
//        
//        BairroEstrato best = new  BairroEstrato();
//        best.setCodigo(1111);
//        best.setTotalArmazem(22);
//        best.setTotalResindencia(2);
//        best.setTotalImoveis(3);
//        best.setTotalComercio(4);
//        best.setTotalPredios(5);
//        best.setTotalTerrenoBaldio(6);
//        best.setTotalHabitantes(7);
//        best.setOutros(8);
//        best.setBairro(bairro);
//        best.setEstrato(estrato);
//        
//        BairroEstratoDAO beDAO= new BairroEstratoDAO();
//        beDAO.create(best, conn);
        
        //consolidaca dados
        
        ConsolidacaoDadosDAO conDAO = new ConsolidacaoDadosDAO();
        ConsolidacaoDados consolidacaoDados = new ConsolidacaoDados();
        List<ConsolidacaoDados> consList = new ArrayList<ConsolidacaoDados>();
        consList = conDAO.readByCriteria(null, conn);
        
        System.out.println(consolidacaoDados);
        conn.commit();
    }

}
