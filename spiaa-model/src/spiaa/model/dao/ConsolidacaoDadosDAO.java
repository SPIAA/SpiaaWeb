package spiaa.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import spiaa.model.base.BaseDAO;
import spiaa.model.entity.ConsolidacaoCriadouro;
import spiaa.model.entity.ConsolidacaoDados;
import spiaa.model.entity.Criadouro;
import spiaa.model.entity.Estrato;
import spiaa.model.entity.Liraa;

public class ConsolidacaoDadosDAO implements BaseDAO<ConsolidacaoDados> {

    public static final String CRITERION_LIRAA_ID_EQ = "1";
    public static final String CRITERION_ESTRATO_ID_EQ = "2";

    @Override
    public void create(ConsolidacaoDados entity, Connection conn) throws Exception {
        String sql = "INSERT INTO consolidacao_dados(programados, inspecionados, terreno_baldio, outros, estrato_fk, liraa_fk) VALUES ( ?, ?, ?, ?, ?, ?)RETURNING id;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setInt(++i, entity.getProgramados());
        ps.setInt(++i, entity.getInspecionados());
        ps.setInt(++i, entity.getTerrenobaldio());
        ps.setInt(++i, entity.getOutros());
        ps.setLong(++i, entity.getEstrato().getId());
        ps.setLong(++i, entity.getLiraa().getId());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            entity.setId(rs.getLong("id"));
        }
        rs.close();
        ps.close();

        List<ConsolidacaoCriadouro> consolidacaoCriadouroList = entity.getConsolidacaoCriadouroList();
        if (consolidacaoCriadouroList != null && consolidacaoCriadouroList.size() > 0) {
            String sqlConsolidacao = "INSERT INTO consolidacao_criadouro(consolidacao_fk, criadouro_fk, quantidade) VALUES (?, ?, ?);";
            PreparedStatement psConsolidacao = conn.prepareStatement(sqlConsolidacao);
            for (ConsolidacaoCriadouro consolidacaoCriadouro : consolidacaoCriadouroList) {
                psConsolidacao.setLong(1, entity.getId());
                psConsolidacao.setLong(2, consolidacaoCriadouro.getCriadouro().getId());
                psConsolidacao.setInt(3, consolidacaoCriadouro.getQuantidade());
                psConsolidacao.execute();
            }

            psConsolidacao.close();
        }
    }

    @Override
    public ConsolidacaoDados readById(Long id, Connection conn) throws Exception {
        ConsolidacaoDados consolidacaoDados = null;

        String sql = "SELECT consolidacao_dados.*, consolidacao_criadouro.qtde as consolidacao_criadouro_qtde, criadouro.id as criadouro_id, criadouro.grupo as criadouro_nome, liraa.id as liraa_id, liraa.data_inicio as liraa_data_inicio, liraa.data_fim as liraa_data_fim, estrato.id as estrato_id, estrato.nome as estrato_nome FROM consolidacao_dados LEFT JOIN consolidacao_criadouro on consolidacao_criadouro.consolidacao_fk = consolidacao_dados.id LEFT JOIN criadouro on criadouro.id = consolidacao_criadouro.criadouro_fk LEFT JOIN liraa on liraa.id = consolidacao_dados.liraa_fk LEFT JOIN estrato on estrato.id = consolidacao_dados.estrato_fk WHERE consolidacao_dados.id = ?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            if (consolidacaoDados == null) {

                consolidacaoDados = new ConsolidacaoDados();
                consolidacaoDados.setProgramados(rs.getInt("programados"));
                consolidacaoDados.setInspecionados(rs.getInt("inspecionados"));
                consolidacaoDados.setTerrenobaldio(rs.getInt("terreno_baldio"));
                consolidacaoDados.setOutros(rs.getInt("outros"));

                //liraa
                Liraa liraa = new Liraa();
                liraa.setId(rs.getLong("liraa_id"));
                liraa.setDataInicio(rs.getDate("liraa_data_inicio"));
                liraa.setDataTermino(rs.getDate("liraa_data_fim"));
                consolidacaoDados.setLiraa(liraa);

                //esatrato
                Estrato estrato = new Estrato();
                estrato.setId(rs.getLong("estrato_id"));
                estrato.setNome(rs.getString("estrato_nome"));
                consolidacaoDados.setEstrato(estrato);

            }
            Long criadouro_id = rs.getLong("criadouro_id");
            if (criadouro_id > 0) {
                //criadouro
                Criadouro criadouro = new Criadouro();
                criadouro.setId(criadouro_id);
                criadouro.setGrupo(rs.getString("criadouro_nome"));

                //Consolidacao_criadouro
                ConsolidacaoCriadouro consolidacaoCriadouro = new ConsolidacaoCriadouro();
                consolidacaoCriadouro.setCriadouro(criadouro);
                consolidacaoCriadouro.setQuantidade(rs.getInt("consolidacao_criadouro_qtde"));
                consolidacaoDados.getConsolidacaoCriadouroList().add(consolidacaoCriadouro);
            }
        }

        rs.close();
        ps.close();

        return consolidacaoDados;
    }

    @Override
    public List<ConsolidacaoDados> readByCriteria(Map<String, Object> criteria, Connection conn) throws Exception {
        List<ConsolidacaoDados> consolidacaoDadosList = new ArrayList<ConsolidacaoDados>();
        List<ConsolidacaoCriadouro> consolidacaoCriadouroList = new ArrayList<ConsolidacaoCriadouro>();
        ConsolidacaoDados consolidacaoDados = null;

        String sql = "SELECT consolidacao_dados.*, liraa.id as liraa_id, liraa.data_inicio as liraa_data_inicio, liraa.data_fim as liraa_data_fim, estrato.id as estrato_id, estrato.nome as estrato_nome FROM consolidacao_dados LEFT JOIN liraa on liraa.id = consolidacao_dados.liraa_fk LEFT JOIN estrato on estrato.id = consolidacao_dados.estrato_fk WHERE 1=1";

        Long criterionLiraIdEq = (Long) criteria.get(CRITERION_LIRAA_ID_EQ);
        if (criterionLiraIdEq != null && criterionLiraIdEq > 0) {

            sql += " AND consolidacao_dados.liraa_fk ='" + criterionLiraIdEq + "'";
        }
        Long criterionEstratoIdEq = (Long) criteria.get(CRITERION_ESTRATO_ID_EQ);
        if (criterionEstratoIdEq != null && criterionEstratoIdEq > 0) {

            sql += " AND consolidacao_dados.estrato_fk ='" + criterionEstratoIdEq + "'";
        }

        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            consolidacaoDados = new ConsolidacaoDados();
            consolidacaoDados.setId(rs.getLong("id"));
            consolidacaoDados.setProgramados(rs.getInt("programados"));
            consolidacaoDados.setInspecionados(rs.getInt("inspecionados"));
            consolidacaoDados.setTerrenobaldio(rs.getInt("terreno_baldio"));
            consolidacaoDados.setOutros(rs.getInt("outros"));

            //liraa
            Liraa liraa = new Liraa();
            liraa.setId(rs.getLong("liraa_id"));
            liraa.setDataInicio(rs.getDate("liraa_data_inicio"));
            liraa.setDataTermino(rs.getDate("liraa_data_fim"));
            consolidacaoDados.setLiraa(liraa);

            //esatrato
            Estrato estrato = new Estrato();
            estrato.setId(rs.getLong("estrato_id"));
            estrato.setNome(rs.getString("estrato_nome"));
            consolidacaoDados.setEstrato(estrato);

            consolidacaoCriadouroList = getConsolidacaoCriadouro(consolidacaoDados.getId(), conn);
            consolidacaoDados.setConsolidacaoCriadouroList(consolidacaoCriadouroList);
            consolidacaoDadosList.add(consolidacaoDados);
        }

        rs.close();
        ps.close();

        return consolidacaoDadosList;
    }

    @Override
    public void update(ConsolidacaoDados entity, Connection conn) throws Exception {
        String sql = "UPDATE consolidacao_dados  SET  programados=?, inspecionados=?, terreno_baldio=?, outros=?, estrato_fk=?, liraa_fk=? WHERE id=?;";
        PreparedStatement ps = conn.prepareStatement(sql);
        int i = 0;
        ps.setInt(++i, entity.getProgramados());
        ps.setInt(++i, entity.getInspecionados());
        ps.setInt(++i, entity.getTerrenobaldio());
        ps.setInt(++i, entity.getOutros());
        ps.setLong(++i, entity.getEstrato().getId());
        ps.setLong(++i, entity.getLiraa().getId());
        ps.setLong(++i, entity.getId());
        ps.execute();
        ps.close();

        //deletando a consolidacao criadouro
        String sqldelete = "DELETE FROM consolidacao_criadouro WHERE consolidacao_fk = ?";
        PreparedStatement psdelete = conn.prepareStatement(sqldelete);
        psdelete.setLong(1, entity.getId());
        psdelete.execute();
        psdelete.close();

        //inserindo a nova list de conolidacao criadouro
        List<ConsolidacaoCriadouro> consolidacaoCriadouroList = entity.getConsolidacaoCriadouroList();
        if (consolidacaoCriadouroList != null && consolidacaoCriadouroList.size() > 0) {
            String sqlConsolidacao = "INSERT INTO consolidacao_criadouro(consolidacao_fk, criadouro_fk, qtde) VALUES (?, ?, ?);";
            PreparedStatement psConsolidacao = conn.prepareStatement(sqlConsolidacao);
            for (ConsolidacaoCriadouro consolidacaoCriadouro : consolidacaoCriadouroList) {
                psConsolidacao.setLong(1, entity.getId());
                psConsolidacao.setLong(2, consolidacaoCriadouro.getCriadouro().getId());
                psConsolidacao.setInt(3, consolidacaoCriadouro.getQuantidade());
                psConsolidacao.execute();
            }

            psConsolidacao.close();
        }

    }

    @Override
    public void delete(Long id, Connection conn) throws Exception {

        //deletando a consolidacao criadouro
        String sqlCriadouro = "DELETE FROM consolidacao_criadouro WHERE consolidacao_fk = ?";
        PreparedStatement psdelete = conn.prepareStatement(sqlCriadouro);
        psdelete.setLong(1, id);
        psdelete.execute();
        psdelete.close();

        //deletando consolidação  
        String sql = "DELETE FROM consolidacao_dados  WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
        ps.execute();
        ps.close();

    }

    public List<ConsolidacaoCriadouro> getConsolidacaoCriadouro(Long id, Connection conn) throws SQLException, Exception {

        List<ConsolidacaoCriadouro> consolidacaoCriadouroList = new ArrayList<ConsolidacaoCriadouro>();
        ConsolidacaoCriadouro consolidacaoCriadouro = null;
        Criadouro criadouro = null;
        String sqlCriadouro = "SELECT consolidacao_criadouro.*, consolidacao_criadouro.qtde as consolidacao_criadouro_qtde, criadouro.id as criadouro_id, criadouro.grupo as criadouro_nome FROM consolidacao_criadouro LEFT JOIN criadouro on criadouro.id = consolidacao_criadouro.criadouro_fk WHERE consolidacao_criadouro.consolidacao_fk = ?";
        PreparedStatement ps = conn.prepareStatement(sqlCriadouro);
        ps.setLong(1, id);
        ResultSet rsCriadouro = ps.executeQuery();
        while (rsCriadouro.next()) {
            criadouro = new Criadouro();
            criadouro.setId(rsCriadouro.getLong("criadouro_id"));
            criadouro.setGrupo(rsCriadouro.getString("criadouro_nome"));

            consolidacaoCriadouro = new ConsolidacaoCriadouro();
            consolidacaoCriadouro.setCriadouro(criadouro);
            consolidacaoCriadouro.setQuantidade(rsCriadouro.getInt("consolidacao_criadouro_qtde"));

            consolidacaoCriadouroList.add(consolidacaoCriadouro);
        }
        rsCriadouro.close();
        ps.close();

        return consolidacaoCriadouroList;

    }

}
