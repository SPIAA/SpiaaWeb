package spiaa.model.base.service;

import java.util.List;
import spiaa.model.base.BaseService;
import spiaa.model.entity.TratamentoAntiVetorial;

public interface BaseTratamentoAntiVetorialService extends BaseService<TratamentoAntiVetorial> {

    public void createTratamentoByApi(List<TratamentoAntiVetorial> tratamentoList) throws Exception;
}
