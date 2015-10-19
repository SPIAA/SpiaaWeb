package spiaa.controller.api;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spiaa.model.entity.TratamentoAntiVetorial;
import spiaa.model.service.BoletimDiario;

/**
 *
 * @author William
 * @param
 */
@Controller
public class TratamentoAntiVetorialApiController {

    @RequestMapping(value = "/api/boletim/create", method = RequestMethod.PUT)
    public @ResponseBody
    String setBoletim(@RequestBody BoletimDiario boletimDirario) throws Exception {
        String response = "SUCCESS";
        try {
        } catch (Exception e) {
            response = "ERROR";
            throw e;
        }
        return response;
    }

    @RequestMapping(value = "/api/boletim/createjson", method = RequestMethod.PUT)
    public @ResponseBody
    String setBoletim(@RequestBody String tratamentoAntiVetorial) throws Exception {
        String response = "SUCCESS";
        try {
            Gson gson = new Gson();
            TypeToken<List<TratamentoAntiVetorial>> token = new TypeToken<List<TratamentoAntiVetorial>>() {
            };
            try {
                List<TratamentoAntiVetorial> tratamentoList = (List<TratamentoAntiVetorial>) gson.fromJson(tratamentoAntiVetorial, token.getType());
                String teste = "ola";
            } catch (Exception e) {
                response = "ERROR - Problema na Conversão do Json para Objeto TratamentoAntiVeorial";
            }
        } catch (Exception e) {
            throw e;
        }
        return response;
    }

}
