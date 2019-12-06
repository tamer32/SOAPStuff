package com.dnd.soap.service;

import java.util.LinkedList;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import com.dnd.soap.service.entities.items.Item;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface MarketService {
  @WebMethod
  public void addItem();

  @WebMethod
  public LinkedList<Item> getItems();

  @WebMethod
  public Item getItemById(Long itemId);

  @WebMethod
  public void removeItem(Long itemId);
}
