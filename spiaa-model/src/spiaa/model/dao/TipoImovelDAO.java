package spiaa.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import spiaa.model.base.BaseDAO;
import spiaa.model.entity.TipoImoveis;

public class TipoImovelDAO implements BaseDAO<TipoImoveis> {

    @Override
    public void create(TipoImoveis entity, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoImoveis readById(Long id, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TipoImoveis> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        TipoImoveis tipoImoveis = null;
        List<TipoImoveis> tipoImoveisList = new ArrayList<TipoImoveis>();

        String sql = "SELECT * FROM tipo_imovel WHERE 1=1;";

        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(sql);
        while (rs.next()) {
            tipoImoveis = new TipoImoveis();
            tipoImoveis.setId(rs.getLong("id"));
            tipoImoveis.setSigla(rs.getString("sigla"));
            tipoImoveis.setDescricao(rs.getString("descricao"));
            tipoImoveisList.add(tipoImoveis);
        }

        return tipoImoveisList;
    }

    @Override
    public void update(TipoImoveis entity, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
