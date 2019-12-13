package com.dnd.soap.service;

import java.util.LinkedList;
import java.util.stream.Collectors;
import javax.jws.WebService;
import org.springframework.stereotype.Component;
import com.dnd.soap.service.entities.items.Item;

@WebService(
    endpointInterface = "com.dnd.soap.service.MarketService",
    wsdlLocation = "target/generated/wsdl/MarketService.wsdl")
@Component
public class MarketServiceImpl implements MarketService {
  private LinkedList<Item> items = new LinkedList<>();

  @Override
  public void addItem() {
    items.add(new Item("Short sword", 3, 0, 0));
    items.add(new Item("Dagger", 2, 4, 0));
  }

  @Override
  public LinkedList<Item> getItems() {
    return items;
  }

  @Override
  public Item getItemById(Long itemId) {
    return items.stream().filter(item -> item.getId().equals(itemId)).findFirst().orElseThrow();
  }

  @Override
  public void removeItem(Long itemId) {
    items =
        (LinkedList<Item>)
            items
                .stream()
                .filter(item -> !item.getId().equals(itemId))
                .collect(Collectors.toList());
  }
}
