package spiaa.model;

import spiaa.model.base.service.BaseEstratoService;
import spiaa.model.service.AtividadeService;
import spiaa.model.service.BairroService;
import spiaa.model.service.BoletimDiarioService;
import spiaa.model.service.ConsolidacaoDadosService;
import spiaa.model.service.CriadouroService;
import spiaa.model.service.DenunciaService;
import spiaa.model.service.EstratoService;
import spiaa.model.service.InseticidaService;
import spiaa.model.service.LiraaService;
import spiaa.model.service.MapaService;
import spiaa.model.service.QuarteiraoService;
import spiaa.model.service.TipoImovelService;
import spiaa.model.service.UsuarioService;

public class ServiceLocator {

  public static BaseEstratoService getBaseEstratoService() {
    return new EstratoService();

  }

  public static LiraaService getBaseLiraaService() {
    return new LiraaService();
  }

  public static ConsolidacaoDadosService getBaseConsolidacaoDadosService() {
    return new ConsolidacaoDadosService();
  }

  public static CriadouroService getBaseCriadouroService() {
    return new CriadouroService();
  }

  public static BairroService getBaseBairroService() {
    return new BairroService();
  }

  public static UsuarioService getBaseUsuarioService() {
    return new UsuarioService();
  }

  public static DenunciaService getbaseDenunciaService() {
    return new DenunciaService();
  }

  public static BoletimDiarioService getbaseBoletimDiarioService() {
    return new BoletimDiarioService();
  }

  public static InseticidaService getbaseInseticidaService() {
    return new InseticidaService();
  }

  public static TipoImovelService getbasetipoImovelService() {
    return new TipoImovelService();
  }

  public static AtividadeService getbaseAtividadeService() {
    return new AtividadeService();
  }

  public static MapaService getbaseMapaService() {
    return new MapaService();
  }
  
  public static QuarteiraoService getbaseQuarteiraoService(){
    return new QuarteiraoService();
  }
}
