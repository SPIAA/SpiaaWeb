package spiaa.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import spiaa.model.base.BaseDAO;
import spiaa.model.entity.Bairro;
import spiaa.model.entity.BairroEstrato;
import spiaa.model.entity.Estrato;

public class EstratoDAO implements BaseDAO<Estrato> {
public static final String CRITERION_ESTRATO_ID_EQ = "1";
    
    @Override
    public void create(Estrato entity, Connection conn) throws Exception {

        String sql = "INSERT INTO estrato(nome)VALUES (?) RETURNING id;";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, entity.getNome());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            entity.setId(rs.getLong("id"));
        }
        rs.close();
        ps.close();

        List<BairroEstrato> bairroEstratoList = entity.getBairroEstratoList();
        if (bairroEstratoList != null && bairroEstratoList.size() > 0) {
            String sqlBairroEstrato = "INSERT INTO bairro_estrato( bairro_fk, estrato_fk, ultima_atualizacao)VALUES (?, ?, now());";
            PreparedStatement psBairroEstrato = conn.prepareStatement(sqlBairroEstrato);
           
            for (BairroEstrato bairroEstrato : bairroEstratoList) {
                 int i = 0;
                psBairroEstrato.setLong(++i, bairroEstrato.getBairro().getId());
                psBairroEstrato.setLong(++i, entity.getId());
//                psBairroEstrato.setInt(++i, bairroEstrato.getCodigo());
//                psBairroEstrato.setInt(++i, bairroEstrato.getTotalArmazem());
//                psBairroEstrato.setInt(++i, bairroEstrato.getTotalResindencia());
//                psBairroEstrato.setInt(++i, bairroEstrato.getTotalImoveis());
//                psBairroEstrato.setInt(++i, bairroEstrato.getTotalComercio());
//                psBairroEstrato.setInt(++i, bairroEstrato.getTotalPredios());
//                psBairroEstrato.setInt(++i, bairroEstrato.getTotalterreno_baldio());
//                psBairroEstrato.setInt(++i, bairroEstrato.getTotalHabitantes());
//                psBairroEstrato.setInt(++i, bairroEstrato.getOutros());

                psBairroEstrato.execute();
            }
            psBairroEstrato.close();;
        }

    }

    @Override
    public Estrato readById(Long id, Connection conn) throws Exception {
        Estrato estrato = null;
       // List<Estrato> estratoList = new ArrayList<Estrato>();
        String sql = "SELECT bairro_estrato.*,estrato.id as estrato_id, estrato.nome as estrato_nome, bairro.id as bairro_id, bairro.nome as bairro_nome, bairro.coordenadas as bairro_coordenadas from estrato left join bairro_estrato on bairro_estrato.estrato_fk = estrato.id left join  bairro on bairro.id = bairro_estrato.bairro_fk WHERE estrato.id = ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            if (estrato == null) {
                estrato = new Estrato();
                estrato.setId(rs.getLong("estrato_id"));
                estrato.setNome(rs.getString("estrato_nome"));

            }
            Long bairro_id = rs.getLong("bairro_id");
            if (bairro_id > 0) {
                Bairro bairro = new Bairro();
                bairro.setId(bairro_id);
                bairro.setNome(rs.getString("bairro_nome"));
                bairro.setCoordenadas(rs.getString("bairro_coordenadas"));

                BairroEstrato bairroEstrato = new BairroEstrato();
                bairroEstrato.setBairro(bairro);
                bairroEstrato.setCodigo(rs.getInt("codigo"));
                bairroEstrato.setArmazem(rs.getInt("armazem"));
                bairroEstrato.setResindencia(rs.getInt("residencia"));
                bairroEstrato.setImovel(rs.getInt("imovel"));
                bairroEstrato.setComercio(rs.getInt("comercio"));
                bairroEstrato.setPredio(rs.getInt("predio"));
                bairroEstrato.setTerrenoBaldio(rs.getInt("terreno_baldio"));
                bairroEstrato.setHabitante(rs.getInt("habitante"));
                bairroEstrato.setOutros(rs.getInt("outros"));

                estrato.getBairroEstratoList().add(bairroEstrato);
            }

        }
        rs.close();
        ps.close();
        return estrato;
    }

    @Override
    public List<Estrato> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<Estrato> estratoList = new ArrayList<Estrato>();

        String sql = "SELECT * FROM estrato WHERE 1=1";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Estrato estrato = new Estrato();
            Long id =rs.getLong("id");
            estrato = readById(id, conn);

            estratoList.add(estrato);
        }

        return estratoList;
    }

    @Override
    public void update(Estrato entity, Connection conn) throws Exception {

        String sql = "UPDATE estrato SET nome=?  WHERE id =?;";
        PreparedStatement ps = conn.prepareStatement(sql);
       
        ps.setString(1, entity.getNome());
        ps.setLong(2, entity.getId());
        ps.execute();
        ps.close();
        
        
        String sqldelete = "DELETE FROM bairro_estrato WHERE estrato_fk =?";
        PreparedStatement psDelete = conn.prepareStatement(sqldelete);
        psDelete.setLong(1, entity.getId());
        psDelete.execute();
        psDelete.close();
        
                
        List<BairroEstrato> bairroEstratoList = entity.getBairroEstratoList();
        if (bairroEstratoList != null && bairroEstratoList.size() > 0) {
            String sqlBairroEstrato = "INSERT INTO bairro_estrato(bairro_fk, estrato_fk, codigo, armazem, "
                    + "residencia, imoveis, comercio, predios, terreno_baldio,"
                    + " habitantes, outros, ultima_atualizacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, now())";
            PreparedStatement psBairroEstrato = conn.prepareStatement(sqlBairroEstrato);
           
            for (BairroEstrato bairroEstrato : bairroEstratoList) {
                 int i = 0;
                psBairroEstrato.setLong(++i, bairroEstrato.getBairro().getId());
                psBairroEstrato.setLong(++i, entity.getId());
                psBairroEstrato.setInt(++i, bairroEstrato.getCodigo());
                psBairroEstrato.setInt(++i, bairroEstrato.getArmazem());
                psBairroEstrato.setInt(++i, bairroEstrato.getResindencia());
                psBairroEstrato.setInt(++i, bairroEstrato.getImovel());
                psBairroEstrato.setInt(++i, bairroEstrato.getComercio());
                psBairroEstrato.setInt(++i, bairroEstrato.getPredio());
                psBairroEstrato.setInt(++i, bairroEstrato.getTerrenoBaldio());
                psBairroEstrato.setInt(++i, bairroEstrato.getHabitante());
                psBairroEstrato.setInt(++i, bairroEstrato.getOutros());

                psBairroEstrato.execute();
            }
            psBairroEstrato.close();;
        }
        
        
    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
