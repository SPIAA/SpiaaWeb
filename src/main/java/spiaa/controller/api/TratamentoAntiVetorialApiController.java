package spiaa.controller.api;

import com.google.gson.Gson;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import spiaa.model.ServiceLocator;
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
//            if (tratamentoAntiVetorialList != null && tratamentoAntiVetorialList.size() > 0) {
//                for (TratamentoAntiVetorial tav : tratamentoAntiVetorialList) {
//                    ServiceLocator.getbaseBoletimDiarioService().create(tav);
//                }
//            } else {
//                throw new Exception(" Null - Lista de Tratamento vazia");
//            }
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
            try {
                TratamentoAntiVetorial tratamento = (TratamentoAntiVetorial) gson.fromJson(tratamentoAntiVetorial, TratamentoAntiVetorial.class);

            } catch (Exception e) {
                response = "ERROR - Problema na Conversão do Json para Objeto TratamentoAntiVeorial";

            }

        } catch (Exception e) {
            throw e;
        }
        return response;
    }

}
