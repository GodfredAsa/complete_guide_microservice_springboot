package io.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {
    @Autowired private Configuration configuration;

    @RequestMapping(value = "/limits", method = RequestMethod.GET)
    public LimitConfiguration getLimitConfiguration(){
        return new LimitConfiguration(configuration.getMaximum(), configuration.getMinimum());
    }
}
