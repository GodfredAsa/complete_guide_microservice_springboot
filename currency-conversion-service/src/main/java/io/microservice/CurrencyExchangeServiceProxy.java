package io.microservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//NOTE: WHEN RIBBON IS USED FOR DISTRIBUTING LOAD THERE IS NO NEED TO ADD THE URL OF THE
// CLIENT TO COMMUNICATE TO AS IT WILL ENFORCE LOAD DISTRIBUTION AMONG MULTI-INSTANCES.
// BUT RATHER SHOULD BE CONFIGURED IN THE APPLICATION PROPERTIES OF THAT PARTICULAR SERVICE.

//@FeignClient(name = "currency-exchange-service", url = "http://localhost:8001")
@FeignClient(name = "currency-exchange-service")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

    @RequestMapping(value = "/currency-exchange/from/{from}/to/{to}", method = RequestMethod.GET)
     CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
