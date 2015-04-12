package spiaa.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import spiaa.model.base.BaseDAO;
import spiaa.model.entity.Bairro;
import spiaa.model.entity.Denuncia;

public class DenunciaDAO implements BaseDAO<Denuncia> {
    
    @Override
    public void create(Denuncia entity, Connection conn) throws Exception {
        String sql = "INSERT INTO denuncia(endereco, numero, telefone, irregularidade, observacao, bairro_fk)VALUES (?, ?, ?, ?, ?, ?);";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        
        ps.setString(++i, entity.getEndereco());
        ps.setString(++i, entity.getNumero());
        ps.setString(++i, entity.getTelefone());
        ps.setString(++i, entity.getIrregularidade());
        ps.setString(++i, entity.getObservacao());
        ps.setLong(++i, entity.getBairro().getId());
        ps.execute();
        
        ps.close();
        
    }
    
    @Override
    public Denuncia readById(Long id, Connection conn) throws Exception {
        Denuncia denuncia = new Denuncia();
        String sql = "SELECT denuncia .*,bairro.id as bairro_id, bairro.nome as bairro_nome from denuncia left join bairro on bairro.id = denuncia.bairro_fk WHERE denuncia.id =?";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            denuncia.setId(rs.getLong("id"));
            denuncia.setEndereco(rs.getString("endereco"));
            denuncia.setNumero(rs.getString("numero"));
            denuncia.setTelefone(rs.getString("telefone"));
            denuncia.setObservacao(rs.getString("observacao"));
            denuncia.setIrregularidade(rs.getString("irregularidade"));
            
            Bairro bairro = new Bairro();
            bairro.setId(rs.getLong("bairro_id"));
            bairro.setNome(rs.getString("bairro_nome"));
            
            denuncia.setBairro(bairro);
        }
        
        return denuncia;
    }
    
    @Override
    public List<Denuncia> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<Denuncia> denunciaList = new ArrayList<Denuncia>();
        Denuncia entity = null;
        String sql = "SELECT denuncia .*,bairro.id as bairro_id, bairro.nome as bairro_nome from denuncia left join bairro on bairro.id = denuncia.bairro_fk WHERE 1=1";
        
        Statement s = conn.createStatement();
        
        ResultSet rs = s.executeQuery(sql);
        while (rs.next()) {
            entity = new Denuncia();
            entity.setId(rs.getLong("id"));
            entity.setEndereco(rs.getString("endereco"));
            entity.setNumero(rs.getString("numero"));
            entity.setTelefone(rs.getString("telefone"));
            entity.setIrregularidade(rs.getString("irregularidade"));
            entity.setObservacao(rs.getString("observacao"));
            
            Bairro bairro = new Bairro();
            bairro.setId(rs.getLong("bairro_id"));
            bairro.setNome(rs.getString("bairro_nome"));
            
            entity.setBairro(bairro);
            denunciaList.add(entity);
        }
        
        return denunciaList;
        
    }
    
    @Override
    public void update(Denuncia entity, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void delete(Long id, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
