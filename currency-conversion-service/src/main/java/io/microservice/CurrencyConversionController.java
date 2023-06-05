package io.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
public class CurrencyConversionController {

    @Autowired private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

    @RequestMapping(value = "/currency-converter/from/{from}/to/{to}/qty/{qty}")
    public CurrencyConversionBean convertCurrency
            (@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal qty){
                Map<String, String> uriVariables = new HashMap<>();
                uriVariables.put("from", from);
                uriVariables.put("to", to);

                ResponseEntity<CurrencyConversionBean> responseEntity =
                        new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                                CurrencyConversionBean.class, uriVariables);
                CurrencyConversionBean response = responseEntity.getBody();
        return new CurrencyConversionBean(
                        response.getId(), from, to,response.getConversionMultiple(),
                        qty, qty.multiply(response.getConversionMultiple()), response.getPort()
        );
    }


    @RequestMapping(value = "/currency-converter-feign/from/{from}/to/{to}/qty/{qty}")
    public CurrencyConversionBean convertCurrencyFeign
            (@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal qty){

        CurrencyConversionBean response = currencyExchangeServiceProxy.retrieveExchangeValue(from, to);
        return new CurrencyConversionBean(response.getId(), from, to,response.getConversionMultiple(),
                qty, qty.multiply(response.getConversionMultiple()), response.getPort()
        );
    }
}
