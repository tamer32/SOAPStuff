package com.dnd.soap.config;

import javax.xml.ws.Endpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import com.dnd.soap.service.MarketService;
import com.dnd.soap.service.MarketServiceImpl;

@EnableWs
@Configuration
public class WebServiceConfig {
  @Autowired private Bus bus;

  @Bean
  public MarketService marketService() {
    return new MarketServiceImpl();
  }

  @Bean
  public Endpoint endpoint() {
    EndpointImpl endpoint = new EndpointImpl(bus, marketService());
    endpoint.publish("http://localhost:8081/services");
    return endpoint;
  }
}
