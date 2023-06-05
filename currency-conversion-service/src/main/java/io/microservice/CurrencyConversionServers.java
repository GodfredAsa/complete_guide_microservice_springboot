package io.microservice;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "currency-exchange-service")
public class CurrencyConversionServers {
    private List<String> urls;
}
