package com.dnd.soap.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;

@Endpoint
public class MarketEndpoint {
  @Autowired private MarketService marketService;
}
