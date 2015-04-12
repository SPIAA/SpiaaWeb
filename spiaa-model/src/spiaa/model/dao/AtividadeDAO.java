package spiaa.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import spiaa.model.base.BaseDAO;
import spiaa.model.entity.Atividade;
import spiaa.model.entity.AtividadeCriadouro;
import spiaa.model.entity.AtividadeInseticida;
import spiaa.model.entity.BoletimDiario;
import spiaa.model.entity.Criadouro;
import spiaa.model.entity.Inseticida;
import spiaa.model.entity.TipoImoveis;

public class AtividadeDAO implements BaseDAO<Atividade> {

    public static final String CRITERION_BOLETIM_ID_EQ = "1";

    @Override
    public void create(Atividade entity, Connection conn) throws Exception {

        String sql = "INSERT INTO atividade(numero_quateirao, endereco, numero, observacao, inspecionado, tipo_imovel_fk, boletim_fk) VALUES (?, ?, ?, ?, ?, ?, ?) RETURNING id;";
        PreparedStatement ps = conn.prepareStatement(sql);

        int i = 0;
        ps.setString(++i, entity.getQuarteirao());
        ps.setString(++i, entity.getEndereco());
        ps.setString(++i, entity.getNumero());
        ps.setString(++i, entity.getObservacao());
        ps.setInt(++i, entity.getInspecionado());
        ps.setLong(++i, entity.getTipoImoveis().getId());
        ps.setLong(++i, entity.getBoletimDiario().getId());

        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            entity.setId(rs.getLong("id"));
        }
        rs.close();
        ps.close();

        List<AtividadeCriadouro> atividadeCriadouroList = entity.getAtividadeCriadouroList();
        if (atividadeCriadouroList != null && atividadeCriadouroList.size() > 0) {
            String sqlCriadouro = "INSERT INTO atividade_criadouro(atividade_fk, criadouro_fk, quantidade)VALUES (?, ?, ?);";
            PreparedStatement psCriadouro = conn.prepareStatement(sqlCriadouro);
            for (AtividadeCriadouro atividadeCriadouro : atividadeCriadouroList) {
                psCriadouro.setLong(1, entity.getId());
                psCriadouro.setLong(2, atividadeCriadouro.getCriadouro().getId());
                psCriadouro.setInt(3, atividadeCriadouro.getQuantidadeCriadouro());
                psCriadouro.execute();
            }
            psCriadouro.close();
        }

        List<AtividadeInseticida> atividadeInseticidaList = entity.getAtividadeInseticidasList();
        if (atividadeInseticidaList != null && atividadeInseticidaList.size() > 0) {
            String sqlInseticida = "INSERT INTO atividade_inseticida(atividade_fk, inseticida_fk, quantidade)VALUES (?, ?, ?);";
            PreparedStatement psinseticida = conn.prepareStatement(sqlInseticida);
            for (AtividadeInseticida atividadeInseticida : atividadeInseticidaList) {
                psinseticida.setLong(1, entity.getId());
                psinseticida.setLong(2, atividadeInseticida.getInseticida().getId());
                psinseticida.setInt(3, atividadeInseticida.getQuantidadeInseticida());
                psinseticida.execute();
            }
            psinseticida.close();
        }

    }

    @Override
    public Atividade readById(Long id, Connection conn) throws Exception {
        Atividade atividade = null;
        String sql = "SELECT atividade .*,tipo_imovel.id as tipo_imovel_id, tipo_imovel.nome as tipo_imovel_nome, tipo_imovel.sigla as tipo_imovel_sigla, atividade_criadouro.quantidade as atividade_criadouro_qtde, criadouro.id as criadouro_id, criadouro.grupo as criadouro_nome FROM atividade LEFT JOIN tipo_imovel on tipo_imovel.id = atividade.tipo_imovel_fk LEFT JOIN atividade_criadouro on atividade_criadouro.atividade_fk = atividade.id LEFT JOIN criadouro on criadouro.id = atividade_criadouro.criadouro_fk WHERE atividade.id = ?";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            if (atividade == null) {
                atividade = new Atividade();
                atividade.setId(rs.getLong("id"));
                atividade.setEndereco(rs.getString("endereco"));
                atividade.setQuarteirao(rs.getString("numero_quateirao"));
                atividade.setNumero(rs.getString("numero"));
                atividade.setObservacao(rs.getString("observacao"));
                atividade.setInspecionado(rs.getInt("inspecionado"));

                //Tipo Imóvel
                TipoImoveis tipoImoveis = new TipoImoveis();
                tipoImoveis.setId(rs.getLong("tipo_imovel_id"));
                tipoImoveis.setSigla(rs.getString("tipo_imovel_sigla"));
                tipoImoveis.setDescricao(rs.getString("tipo_imovel_nome"));
                
                //boletim diario
                BoletimDiario boletimDiario = new BoletimDiario();
                boletimDiario.setId(rs.getLong("boletim_fk"));
                atividade.setBoletimDiario(boletimDiario);

                atividade.setTipoImoveis(tipoImoveis);
                
                //Atividade inseticida
                List<AtividadeInseticida> atividadeInseticidaList = new ArrayList<AtividadeInseticida>();
                atividadeInseticidaList = getInseticida(id, conn);
                atividade.setAtividadeInseticidasList(atividadeInseticidaList);
            }

            Long criadouro_id = rs.getLong("criadouro_id");
            if (criadouro_id > 0) {
                //criadouro
                Criadouro criadouro = new Criadouro();
                criadouro.setId(criadouro_id);
                criadouro.setGrupo(rs.getString("criadouro_nome"));

                //Consolidacao_criadouro
                AtividadeCriadouro atividadeCriadouro = new AtividadeCriadouro();
                atividadeCriadouro.setCriadouro(criadouro);
                atividadeCriadouro.setQuantidadeCriadouro(rs.getInt("atividade_criadouro_qtde"));
                atividade.getAtividadeCriadouroList().add(atividadeCriadouro);
            }

        }

        return atividade;
    }

    @Override
    public List<Atividade> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<Atividade> atividadeList = new ArrayList<Atividade>();
        Atividade atividade = null;
        TipoImoveis tipoImoveis = null;
        String sql = "SELECT atividade .*,tipo_imovel.id as tipo_imovel_id, tipo_imovel.nome as tipo_imovel_nome, tipo_imovel.sigla as tipo_imovel_sigla FROM atividade LEFT JOIN tipo_imovel on tipo_imovel.id = atividade.tipo_imovel_fk WHERE 1 = 1";
        Statement s = conn.createStatement();

        Long criterionBoletimIdEq = (Long) criteria.get(CRITERION_BOLETIM_ID_EQ);
        if (criterionBoletimIdEq != null && criterionBoletimIdEq > 0) {

            sql += " AND boletim_fk ='" + criterionBoletimIdEq + "'";
        }

        ResultSet rs = s.executeQuery(sql);

        while (rs.next()) {
            atividade = new Atividade();
            atividade.setId(rs.getLong("id"));
            atividade.setEndereco(rs.getString("endereco"));
            atividade.setQuarteirao(rs.getString("numero_quateirao"));
            atividade.setNumero(rs.getString("numero"));
            atividade.setObservacao(rs.getString("observacao"));
            atividade.setInspecionado(rs.getInt("inspecionado"));

            //Tipo Imóvel
            tipoImoveis = new TipoImoveis();
            tipoImoveis.setId(rs.getLong("tipo_imovel_id"));
            tipoImoveis.setSigla(rs.getString("tipo_imovel_sigla"));
            tipoImoveis.setDescricao(rs.getString("tipo_imovel_nome"));

            atividade.setTipoImoveis(tipoImoveis);

            //Adicionando na Lista
            atividadeList.add(atividade);

        }

        return atividadeList;

    }

    @Override
    public void update(Atividade entity, Connection conn) throws Exception {

        String sql = "UPDATE atividade SET numero_quateirao=?, endereco=?, numero=?, observacao=?, inspecionado=?, tipo_imovel_fk=?, boletim_fk=? WHERE id=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setString(++i, entity.getQuarteirao());
        ps.setString(++i, entity.getEndereco());
        ps.setString(++i, entity.getNumero());
        ps.setString(++i, entity.getObservacao());
        ps.setInt(++i, entity.getInspecionado());
        ps.setLong(++i, entity.getTipoImoveis().getId());
        ps.setLong(++i, entity.getBoletimDiario().getId());
        ps.setLong(++i, entity.getId());
        ps.execute();
        ps.close();

        //deletendo criadouros
        String sqldelCriadouro = "DELETE FROM atividade_criadouro WHERE atividade_fk = ?";
        PreparedStatement psdelCriadouro = conn.prepareStatement(sqldelCriadouro);
        psdelCriadouro.setLong(1, entity.getId());
        psdelCriadouro.execute();
        psdelCriadouro.close();

        //inserindo criadouro
        List<AtividadeCriadouro> atividadeCriadouroList = entity.getAtividadeCriadouroList();
        if (atividadeCriadouroList != null && atividadeCriadouroList.size() > 0) {
            String sqlCriadouro = "INSERT INTO atividade_criadouro(atividade_fk, criadouro_fk, qtde)VALUES (?, ?, ?);";
            PreparedStatement psCriadouro = conn.prepareStatement(sqlCriadouro);
            for (AtividadeCriadouro atividadeCriadouro : atividadeCriadouroList) {
                psCriadouro.setLong(1, entity.getId());
                psCriadouro.setLong(2, atividadeCriadouro.getCriadouro().getId());
                psCriadouro.setInt(3, atividadeCriadouro.getQuantidadeCriadouro());
                psCriadouro.execute();
            }
            psCriadouro.close();
        }

        //deletando inseticidas 
        String sqldelInseticida = "DELETE FROM atividade_inseticida WHERE atividade_fk = ?";
        PreparedStatement psdelInseticida = conn.prepareStatement(sqldelInseticida);
        psdelInseticida.setLong(1, entity.getId());
        psdelInseticida.execute();
        psdelInseticida.close();

        //inserindo Inseticida
        List<AtividadeInseticida> atividadeInseticidaList = entity.getAtividadeInseticidasList();
        if (atividadeInseticidaList != null && atividadeInseticidaList.size() > 0) {
            String sqlInseticida = "INSERT INTO atividade_inseticida(atividade_fk, inseticida_fk, quantidade)VALUES (?, ?, ?);";
            PreparedStatement psinseticida = conn.prepareStatement(sqlInseticida);
            for (AtividadeInseticida atividadeInseticida : atividadeInseticidaList) {
                psinseticida.setLong(1, entity.getId());
                psinseticida.setLong(2, atividadeInseticida.getInseticida().getId());
                psinseticida.setInt(3, atividadeInseticida.getQuantidadeInseticida());
                psinseticida.execute();
            }
            psinseticida.close();
        }

    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {

        //deletendo criadouros
        String sqldelCriadouro = "DELETE FROM atividade_criadouro WHERE atividade_fk = ?";
        PreparedStatement psdelCriadouro = conn.prepareStatement(sqldelCriadouro);
        psdelCriadouro.setLong(1, id);
        psdelCriadouro.execute();
        psdelCriadouro.close();

        //deletando inseticidas 
        String sqldelInseticida = "DELETE FROM atividade_inseticida WHERE atividade_fk = ?";
        PreparedStatement psdelInseticida = conn.prepareStatement(sqldelInseticida);
        psdelInseticida.setLong(1, id);
        psdelInseticida.execute();
        psdelInseticida.close();

        String sql = "DELETE FROM atividade WHERE id = ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ps.execute();
        ps.close();

    }

    public List<AtividadeInseticida> getInseticida(Long id, Connection conn) throws Exception {
        Inseticida inseticida = null;
        AtividadeInseticida atividadeInseticida = null;
        List<AtividadeInseticida> atividadeInseticidaList = new ArrayList<AtividadeInseticida>();
        String sql = "SELECT atividade_inseticida.*, atividade_inseticida.quantidade as atividade_inseticida_qtde, inseticida.id as inseticida_id, inseticida.nome as inseticida_nome FROM atividade_inseticida LEFT JOIN inseticida on inseticida.id = atividade_inseticida.inseticida_fk LEFT JOIN atividade on atividade.id = atividade_inseticida.atividade_fk WHERE atividade.id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            inseticida = new Inseticida();
            inseticida.setId(rs.getLong("inseticida_id"));
            inseticida.setNome(rs.getString("inseticida_nome"));
            
            atividadeInseticida = new AtividadeInseticida();
            atividadeInseticida.setQuantidadeInseticida(rs.getInt("atividade_inseticida_qtde"));
            atividadeInseticida.setInseticida(inseticida);
        
            atividadeInseticidaList.add(atividadeInseticida);
        }
        
        
        
        return atividadeInseticidaList;
    }

}
