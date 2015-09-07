package spiaa.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import spiaa.model.ServiceLocator;
import spiaa.model.dao.AtividadeDAO;
import spiaa.model.dao.QuarteiraoDAO;
import spiaa.model.entity.Atividade;
import spiaa.model.entity.AtividadeCriadouro;
import spiaa.model.entity.AtividadeInseticida;
import spiaa.model.entity.BoletimDiario;
import spiaa.model.entity.Criadouro;
import spiaa.model.entity.Inseticida;
import spiaa.model.entity.Quarteirao;
import spiaa.model.entity.TipoImoveis;

@Controller
public class AtividadeController {

    @RequestMapping(value = "/atividade/{id}", method = RequestMethod.GET)
    public ModelAndView listar(@PathVariable Long id) throws Exception {
        ModelAndView mv = null;
        BoletimDiario boletimDiario = new BoletimDiario();
        Map<String, Object> criteria = new HashMap<String, Object>();
        List<Atividade> atividadeList = new ArrayList<Atividade>();

        try {
            criteria.put(AtividadeDAO.CRITERION_BOLETIM_ID_EQ, id);
            atividadeList = ServiceLocator.getbaseAtividadeService().readByCriteria(criteria);

            boletimDiario = ServiceLocator.getbaseBoletimDiarioService().readById(id);

            mv = new ModelAndView("atividade/list");
            mv.addObject("boletimDiario", boletimDiario);
            mv.addObject("atividadeList", atividadeList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mv;
    }

    @RequestMapping(value = "/atividade/{id}/novo", method = RequestMethod.GET)
    public ModelAndView create(@PathVariable Long id) throws Exception {
        ModelAndView mv = null;
        List<Criadouro> criadouroList = new ArrayList<Criadouro>();
        List<Inseticida> inseticidaList = new ArrayList<Inseticida>();
        List<TipoImoveis> tipoImoveisList = new ArrayList<TipoImoveis>();
        List<Quarteirao> quarteiraoList = new ArrayList<Quarteirao>();

        Map<String, Object> criteria = new HashMap<String, Object>();
        try {
            criadouroList = ServiceLocator.getBaseCriadouroService().readByCriteria(criteria);
            inseticidaList = ServiceLocator.getbaseInseticidaService().readByCriteria(criteria);
            tipoImoveisList = ServiceLocator.getbasetipoImovelService().readByCriteria(criteria);
            BoletimDiario boletimDiario = ServiceLocator.getbaseBoletimDiarioService().readById(id);
            criteria.put(QuarteiraoDAO.CRITERION_BAIRRO_ID, boletimDiario.getBairro().getId());
            quarteiraoList = ServiceLocator.getbaseQuarteiraoService().readByCriteria(criteria);
            mv = new ModelAndView("atividade/form");
            mv.addObject("criadouroList", criadouroList);
            mv.addObject("inseticidaList", inseticidaList);
            mv.addObject("tipoImoveisList", tipoImoveisList);
            mv.addObject("quarteiraoList", quarteiraoList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mv;
    }

    @RequestMapping(value = "/atividade/{id}/novo", method = RequestMethod.POST)
    public ModelAndView create(@PathVariable Long id, Atividade atividade, HttpServletRequest request) throws Exception {
        ModelAndView mv = null;
        String inseticidaVetor[] = request.getParameterValues("inseticida");
        String qtdeInseticidaVetor[] = request.getParameterValues("quantidadeInseticida");
        String criadouroVetor[] = request.getParameterValues("criadouro");
        String qtdeCriadouroVetor[] = request.getParameterValues("quantidadeCriadouro");
        String observacaoVetor[] = request.getParameterValues("observacao");
        String tipoimovelVetor[] = request.getParameterValues("tipoImovel");

        Inseticida inseticida = null;
        Criadouro criadouro = null;
        TipoImoveis tipoImoveis = null;
        AtividadeInseticida atividadeInseticida = null;
        AtividadeCriadouro atividadeCriadouro = null;
        BoletimDiario boletimDiario = null;

        try {
            List<AtividadeInseticida> atividadeInseticidaList = new ArrayList<AtividadeInseticida>();
            List<AtividadeCriadouro> atividadeCriadouroList = new ArrayList<AtividadeCriadouro>();

            for (int i = 0; i < inseticidaVetor.length; i++) {
                //inseticida
                inseticida = new Inseticida();
                inseticida.setId(Long.parseLong(inseticidaVetor[i]));

                //AtividadeInseticida
                atividadeInseticida = new AtividadeInseticida();
                atividadeInseticida.setInseticida(inseticida);
                if (qtdeInseticidaVetor[i].isEmpty()) {
                    atividadeInseticida.setQuantidadeInseticida(0);
                } else {
                    atividadeInseticida.setQuantidadeInseticida(Integer.parseInt(qtdeInseticidaVetor[i]));
                }

                atividadeInseticidaList.add(atividadeInseticida);
            }

            for (int i = 0; i < criadouroVetor.length; i++) {
                //criadouro
                criadouro = new Criadouro();
                criadouro.setId(Long.parseLong(criadouroVetor[i]));

                //AtividadeCriadouro
                atividadeCriadouro = new AtividadeCriadouro();
                atividadeCriadouro.setCriadouro(criadouro);
                if (qtdeCriadouroVetor[i].isEmpty()) {
                    atividadeCriadouro.setQuantidadeCriadouro(0);
                } else {
                    atividadeCriadouro.setQuantidadeCriadouro(Integer.parseInt(qtdeCriadouroVetor[i]));
                }
                atividadeCriadouroList.add(atividadeCriadouro);
            }
            //tipo do Imovel
            tipoImoveis = new TipoImoveis();
            tipoImoveis.setId(Long.parseLong(tipoimovelVetor[0]));

//            //observacao
            if (observacaoVetor != null && observacaoVetor[0].length() > 0) {
                atividade.setObservacao(observacaoVetor[0]);
            }
            //boletim diario
            boletimDiario = new BoletimDiario();
            boletimDiario.setId(id);

            atividade.setAtividadeCriadouroList(atividadeCriadouroList);
            atividade.setAtividadeInseticidasList(atividadeInseticidaList);
            atividade.setTipoImoveis(tipoImoveis);
            atividade.setBoletimDiario(boletimDiario);
            ServiceLocator.getbaseAtividadeService().create(atividade);
            mv = new ModelAndView("redirect:/atividade/" + boletimDiario.getId());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mv;
    }

    @RequestMapping(value = "/atividade/{id}/alterar", method = RequestMethod.GET)
    public ModelAndView alterar(@PathVariable Long id) throws Exception {
        ModelAndView mv = null;
        List<Criadouro> criadouroList = new ArrayList<Criadouro>();
        List<Inseticida> inseticidaList = new ArrayList<Inseticida>();
        List<TipoImoveis> tipoImoveisList = new ArrayList<TipoImoveis>();
        Map<String, Object> criteria = new HashMap<String, Object>();
        List<Quarteirao> quarteiraoList = new ArrayList<Quarteirao>();
        Atividade atividade = new Atividade();
        try {
            criadouroList = ServiceLocator.getBaseCriadouroService().readByCriteria(criteria);
            inseticidaList = ServiceLocator.getbaseInseticidaService().readByCriteria(criteria);
            tipoImoveisList = ServiceLocator.getbasetipoImovelService().readByCriteria(criteria);
            atividade = ServiceLocator.getbaseAtividadeService().readById(id);
            BoletimDiario boletimDiario = ServiceLocator.getbaseBoletimDiarioService().readById(atividade.getBoletimDiario().getId());
            criteria.put(QuarteiraoDAO.CRITERION_BAIRRO_ID, boletimDiario.getBairro().getId());
            quarteiraoList = ServiceLocator.getbaseQuarteiraoService().readByCriteria(criteria);
            mv = new ModelAndView("atividade/form");
            mv.addObject("criadouroList", criadouroList);
            mv.addObject("inseticidaList", inseticidaList);
            mv.addObject("tipoImoveisList", tipoImoveisList);
            mv.addObject("atividade", atividade);
            mv.addObject("quarteiraoList", quarteiraoList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return mv;
    }

    @RequestMapping(value = "/atividade/{id}/alterar", method = RequestMethod.POST)
    public ModelAndView alterar(@PathVariable Long id, Atividade atividade, String boletimId, HttpServletRequest request) throws Exception {
        ModelAndView mv = null;
        String inseticidaVetor[] = request.getParameterValues("inseticida");
        String qtdeInseticidaVetor[] = request.getParameterValues("quantidadeInseticida");
        String criadouroVetor[] = request.getParameterValues("criadouro");
        String qtdeCriadouroVetor[] = request.getParameterValues("quantidadeCriadouro");
        String observacaoVetor[] = request.getParameterValues("observacao");
        String tipoimovelVetor[] = request.getParameterValues("tipoImovel");

        Inseticida inseticida = null;
        Criadouro criadouro = null;
        TipoImoveis tipoImoveis = null;
        AtividadeInseticida atividadeInseticida = null;
        AtividadeCriadouro atividadeCriadouro = null;
        BoletimDiario boletimDiario = null;

        try {
            List<AtividadeInseticida> atividadeInseticidaList = new ArrayList<AtividadeInseticida>();
            List<AtividadeCriadouro> atividadeCriadouroList = new ArrayList<AtividadeCriadouro>();

            for (int i = 0; i < inseticidaVetor.length; i++) {
                //inseticida
                inseticida = new Inseticida();
                inseticida.setId(Long.parseLong(inseticidaVetor[i]));

                //AtividadeInseticida
                atividadeInseticida = new AtividadeInseticida();
                atividadeInseticida.setInseticida(inseticida);
                if (qtdeInseticidaVetor[i].isEmpty()) {
                    atividadeInseticida.setQuantidadeInseticida(0);
                } else {
                    atividadeInseticida.setQuantidadeInseticida(Integer.parseInt(qtdeInseticidaVetor[i]));
                }

                atividadeInseticidaList.add(atividadeInseticida);
            }

            for (int i = 0; i < criadouroVetor.length; i++) {
                //criadouro
                criadouro = new Criadouro();
                criadouro.setId(Long.parseLong(criadouroVetor[i]));

                //AtividadeCriadouro
                atividadeCriadouro = new AtividadeCriadouro();
                atividadeCriadouro.setCriadouro(criadouro);
                if (qtdeCriadouroVetor[i].isEmpty()) {
                    atividadeCriadouro.setQuantidadeCriadouro(0);
                } else {
                    atividadeCriadouro.setQuantidadeCriadouro(Integer.parseInt(qtdeCriadouroVetor[i]));
                }
                atividadeCriadouroList.add(atividadeCriadouro);
            }
            //tipo do Imovel
            tipoImoveis = new TipoImoveis();
            tipoImoveis.setId(Long.parseLong(tipoimovelVetor[0]));

            //observacao
            if (observacaoVetor != null && observacaoVetor[0].length() > 0) {
                atividade.setObservacao(observacaoVetor[0]);
            }
            //boletim diario
            boletimDiario = new BoletimDiario();
            boletimDiario.setId(Long.parseLong(boletimId));

            atividade.setAtividadeCriadouroList(atividadeCriadouroList);
            atividade.setAtividadeInseticidasList(atividadeInseticidaList);
            atividade.setTipoImoveis(tipoImoveis);
            atividade.setBoletimDiario(boletimDiario);
            ServiceLocator.getbaseAtividadeService().update(atividade);
            mv = new ModelAndView("redirect:/atividade/" + boletimDiario.getId());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return mv;
    }

    @RequestMapping(value = "/atividade/{id}/excluir", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable Long id, String boletimId) throws Exception {
        ModelAndView mv = null;
        try {
            Atividade atividade = ServiceLocator.getbaseAtividadeService().readById(id);
            ServiceLocator.getbaseAtividadeService().delete(id);

            mv = new ModelAndView("redirect:/atividade/" + atividade.getBoletimDiario().getId());

        } catch (Exception e) {
        }
        return mv;
    }

}
