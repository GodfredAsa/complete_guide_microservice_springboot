package io.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@RestController
public class CurrencyExchangeController {
    @Autowired private ExchangeValueRepository repository;

    @Autowired
    private Environment environment;

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(value = "/currency-exchange/from/{from}/to/{to}", method = RequestMethod.GET)
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
        ExchangeValue exchangeValue = repository.getByFromAndTo(from, to);
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return exchangeValue;
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(value = "/currency-exchange/to/{to}", method = RequestMethod.GET)
    public List<ExchangeValue> retrieveExchangeValueByTo(@PathVariable String to){
        List<ExchangeValue> exchangeValues = repository.findByTo(to);
        setPort(exchangeValues);
        return exchangeValues;
    }

    private void setPort(List<ExchangeValue> exchangeValues) {
        exchangeValues.forEach(exchangeValue -> exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port"))));
    }
}
