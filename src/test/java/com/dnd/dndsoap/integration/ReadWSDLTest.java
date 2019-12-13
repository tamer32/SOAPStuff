package com.dnd.dndsoap.integration;

import static org.assertj.core.api.Assertions.assertThat;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.dnd.soap.service.MarketService;
import com.dnd.soap.service.entities.items.Item;

public class ReadWSDLTest {
  private static MarketService marketService;

  @BeforeEach
  public void init() throws MalformedURLException {
    URL url = new URL("http://localhost:8081/services?wsdl");
    QName qname = new QName("http://service.soap.dnd.com/", "MarketServiceService");
    Service service = Service.create(url, qname);
    marketService = service.getPort(MarketService.class);
  }

  @Test
  public void testReadWsdl() {
    marketService.addItem();
    LinkedList<Item> items = marketService.getItems();

    assertThat(items).isNotEmpty();
  }
}
