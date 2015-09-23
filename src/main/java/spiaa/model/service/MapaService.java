package spiaa.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import spiaa.model.ConnectionManager;
import spiaa.model.base.service.BaseMapaService;
import spiaa.model.dao.MapaDAO;
import spiaa.model.entity.Estrato;
import spiaa.model.entity.Mapa;

public class MapaService implements BaseMapaService {

    @Override
    public void create(Mapa entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Mapa readById(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Mapa> readByCriteria(Map<String, Object> criteria) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Mapa entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Estrato> readByCriteriaMapaEstrato(Map<String, Object> criteria) throws Exception {
        List<Estrato> mapalist = new ArrayList<>();

        Connection conn = ConnectionManager.getInstance().getConnection();
        MapaDAO dao = new MapaDAO();
        mapalist = dao.readByCriteriaMapaEstrato(criteria, conn);
      //  mapalist = CalculaCriadouro(mapalist);
        conn.close();

        return mapalist;
    }

//    public List<Estrato> CalculaCriadouro(List<Estrato> estrato) throws Exception {
//        List<BairroCriadouro> newlist = null;
//        List<BairroCriadouro> bairroCriadouroList = new ArrayList<>();
//        List<BairroEstrato> bairroEstratoList = new ArrayList<>();
//        List<Criadouro> criadouroList = new ArrayList<>();
//        criadouroList = ServiceLocator.getBaseCriadouroService().readByCriteria(null);
//        List<Criadouro> newCriadouroList = new ArrayList<>();
//        for (Estrato estrato1 : estrato) {
//
//            bairroEstratoList = estrato1.getBairroEstratoList();
//
//            for (BairroEstrato bairroEstrato : bairroEstratoList) {
//
//                bairroCriadouroList = bairroEstrato.getBairroCriadouroList();
//                if (!bairroCriadouroList.isEmpty()) {
//                    for (BairroCriadouro bairroCriadouro : bairroCriadouroList) {
//                        Integer totcriadouro = 0;
//                        for (Criadouro criadouro : criadouroList) {
//                            if (criadouro.getId().equals(bairroCriadouro.getCriadouro().getId())) {
//                                totcriadouro = criadouro.getQtde() + bairroCriadouro.getTotal();
//                                criadouro.setQtde(totcriadouro);
//                            }
//                         }
//                        
//                    }
//
//                }
//
//                bairroEstrato.setCriadouroList(criadouroList);
//            }
//
//        }
//
//        return estrato;
//    }
}
