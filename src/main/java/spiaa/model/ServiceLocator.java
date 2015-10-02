package spiaa.model;

import spiaa.model.base.service.BaseEstratoService;
import spiaa.model.service.AgenteSaudeService;
import spiaa.model.service.AtividadeService;
import spiaa.model.service.BairroService;
import spiaa.model.service.UsuarioBairroService;
import spiaa.model.service.TratamentoAntiVetorialService;
import spiaa.model.service.ConsolidacaoDadosService;
import spiaa.model.service.CriadouroService;
import spiaa.model.service.DenunciaService;
import spiaa.model.service.EstratoService;
import spiaa.model.service.InseticidaService;
import spiaa.model.service.LiraaService;
import spiaa.model.service.MapaService;
import spiaa.model.service.PontoEstrategicoService;
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

   public static TratamentoAntiVetorialService getbaseBoletimDiarioService() {
      return new TratamentoAntiVetorialService();
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

   public static QuarteiraoService getbaseQuarteiraoService() {
      return new QuarteiraoService();
   }

   public static PontoEstrategicoService getbasePontoEstrategicoService() {
      return new PontoEstrategicoService();
   }

   public static UsuarioBairroService getbaseUsuarioBairroService() {
      return new UsuarioBairroService();
   }

   public static AgenteSaudeService getbaseAgenteSaudeService() {
      return new AgenteSaudeService();
   }
}
