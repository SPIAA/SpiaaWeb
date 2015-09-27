package spiaa.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import spiaa.model.ConnectionManager;
import spiaa.model.base.service.BaseMapaService;
import spiaa.model.dao.CriadouroDAO;
import spiaa.model.dao.MapaDAO;
import spiaa.model.entity.BairroEstrato;
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
        CriadouroDAO criadouroDao = new CriadouroDAO();

        for (Estrato estratoList : mapalist) {
            for (BairroEstrato bairroEstrato : estratoList.getBairroEstratoList()) {
                bairroEstrato.getBairro().setTotalCriadouro(criadouroDao.findCriadouroByBairroId(conn, bairroEstrato.getBairro().getId()));
            }
        }
        conn.close();
        return mapalist;
    }
}
