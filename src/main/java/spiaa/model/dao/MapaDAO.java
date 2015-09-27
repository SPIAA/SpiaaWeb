package spiaa.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import spiaa.model.base.BaseDAO;
import spiaa.model.entity.Bairro;
import spiaa.model.entity.BairroCriadouro;
import spiaa.model.entity.BairroEstrato;
import spiaa.model.entity.Criadouro;
import spiaa.model.entity.Estrato;
import spiaa.model.entity.Mapa;

public class MapaDAO implements BaseDAO<Mapa> {

   @Override
    public void create(Mapa entity, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Mapa readById(Long id, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Mapa> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<Mapa> mapaListcriadouro = new ArrayList<>();
        String sql = "Select atividade_criadouro .*, criadouro.id as criadouro_id, criadouro.nome as criadouro_nome "
                + "from atividade_criadouro "
                + "left join criadouro on criadouro.id = atividade_criadouro.criadouro_fk "
                + "Left join atividade on atividade.id = atividade_criadouro.atividade_fk "
                + "left join boletim_diario on boletim_diario.id = atividade.boletim_fk "
                + "Left Join bairro on bairro.id = boletim_diario.bairro_fk "
                + "where bairro.id = 7";

        return mapaListcriadouro;

    }

    @Override
    public void update(Mapa entity, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<BairroCriadouro> readByIdBairroCriadouro(Long id, Connection conn) throws Exception {
        List<BairroCriadouro> mapaListBairroCriadouro = new ArrayList<>();
        String sql = "Select atividade_criadouro .*, criadouro.id as criadouro_id, criadouro.grupo as criadouro_nome "
                + "from atividade_criadouro "
                + "left join criadouro on criadouro.id = atividade_criadouro.criadouro_fk "
                + "Left join atividade on atividade.id = atividade_criadouro.atividade_fk "
                + "left join boletim_diario on boletim_diario.id = atividade.boletim_fk "
                + "Left Join bairro on bairro.id = boletim_diario.bairro_fk "
                + "where bairro.id = ?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Criadouro criadouro = new Criadouro();
            criadouro.setId(rs.getLong("criadouro_id"));
            criadouro.setGrupo(rs.getString("criadouro_nome"));

            BairroCriadouro bairroCriadouro = new BairroCriadouro();
            bairroCriadouro.setCriadouro(criadouro);
            bairroCriadouro.setTotal(rs.getInt("quantidade"));

            mapaListBairroCriadouro.add(bairroCriadouro);

        }
        rs.close();
        ps.close();

        return mapaListBairroCriadouro;
    }

    public List<Estrato> readByCriteriaMapaEstrato(Map<String, Object> criteria, Connection conn) throws Exception {
        List<Estrato> estratoList = new ArrayList<Estrato>();

        String sql = "SELECT * FROM estrato WHERE 1=1";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Estrato estrato = new Estrato();
            Long id = rs.getLong("id");
            estrato = readByIdMapaEstrato(id, conn);

            estratoList.add(estrato);
        }

        return estratoList;
    }

    public Estrato readByIdMapaEstrato(Long id, Connection conn) throws Exception {
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
                bairroEstrato.setResidencia(rs.getInt("residencia"));
                bairroEstrato.setImovel(rs.getInt("imovel"));
                bairroEstrato.setComercio(rs.getInt("comercio"));
                bairroEstrato.setPredio(rs.getInt("predio"));
                bairroEstrato.setTerrenoBaldio(rs.getInt("terreno_baldio"));
                bairroEstrato.setHabitante(rs.getInt("habitantes"));
                bairroEstrato.setOutros(rs.getInt("outros"));

                //Bairro Criadouro
                List<BairroCriadouro> bairroCriadouroList = new ArrayList<BairroCriadouro>();
                bairroCriadouroList = readByIdBairroCriadouro(bairro_id, conn);
                if (bairroCriadouroList.isEmpty()) {
                    bairroCriadouroList = null;
                } else {
                    bairroEstrato.setBairroCriadouroList(bairroCriadouroList);
                }

                estrato.getBairroEstratoList().add(bairroEstrato);
            }

        }
        rs.close();
        ps.close();
        return estrato;
    }

}
