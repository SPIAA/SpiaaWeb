package spiaa.controller.api;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spiaa.model.ServiceLocator;
import spiaa.model.entity.TratamentoAntiVetorial;

/**
 *
 * @author William
 * @param
 */
@Controller
public class TratamentoAntiVetorialApiController {

    @RequestMapping(value = "/api/boletim/create", method = RequestMethod.POST)
    public @ResponseBody
    String setBoletim(@RequestBody List<TratamentoAntiVetorial> TratamentoAntiVetorialList) throws Exception {
        String response = "SUCCESS";
        try {
            if (TratamentoAntiVetorialList != null && TratamentoAntiVetorialList.size() > 0) {
                for (TratamentoAntiVetorial tav : TratamentoAntiVetorialList) {
                    ServiceLocator.getbaseBoletimDiarioService().create(tav);
                }
            } else {
                throw new Exception(" Null - Lista de Tratamento vazia");
            }
        } catch (Exception e) {
            response = "ERROR";
            throw e;
        }
        return response;
    }

}
