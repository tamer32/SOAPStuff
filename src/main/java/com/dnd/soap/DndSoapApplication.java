package com.dnd.soap;

import javax.xml.ws.Endpoint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.dnd.soap.service.MarketService;
import com.dnd.soap.service.MarketServiceImpl;

@SpringBootApplication(scanBasePackageClasses = DndSoapApplication.class)
public class DndSoapApplication {

  public static void main(String[] args) {
    SpringApplication.run(DndSoapApplication.class, args);
    MarketService market = new MarketServiceImpl();
    market.addItem();
    Endpoint.publish("http://localhost:8081/testSOAP", market);
  }
}
