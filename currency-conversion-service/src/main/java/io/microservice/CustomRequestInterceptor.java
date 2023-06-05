// THIS CODE WAS USED WHEN THE LOAD BALANCER WAS NOT WORKING
// BUT WE CHANGED THE RIBBON TO TALK TO THE NAMING SERVER AND
// RETRIEVE THE INSTANCES FROM THERE IT'S NO LONGER NECESSARY TO
// HAVE IT HENCE DELETION.



//package io.microservice;
//
//import feign.RequestInterceptor;
//import feign.RequestTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Random;
//
//@Configuration
//public class CustomRequestInterceptor implements RequestInterceptor {
//
//    @Autowired private CurrencyConversionServers servers;
//
//    @Override
//    public void apply(RequestTemplate requestTemplate) {
//        List<String> servers = getServers();
//        int serverPosition = getRandomServerPosition(servers);
//        requestTemplate.target(servers.get(serverPosition));
//    }
//
//    private List<String> getServers() {
//        return Arrays.stream(servers.getUrls().toArray(new String[]{})).toList();
//    }
//
//    private static int getRandomServerPosition(List<String> urls) {
//        return new Random().nextInt(urls.size());
//    }
//}