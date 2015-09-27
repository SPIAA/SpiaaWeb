package spiaa.model.base.service;

import java.util.List;
import spiaa.model.base.BaseService;
import spiaa.model.entity.Estrato;

public interface BaseEstratoService extends BaseService<Estrato> {

    public List<Estrato> readAll() throws Exception;
}
