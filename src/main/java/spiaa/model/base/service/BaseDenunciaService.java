package spiaa.model.base.service;

import spiaa.model.base.BaseService;
import spiaa.model.entity.Denuncia;

public interface BaseDenunciaService extends BaseService<Denuncia> {

    public void fechar(Denuncia entity) throws Exception;
}
