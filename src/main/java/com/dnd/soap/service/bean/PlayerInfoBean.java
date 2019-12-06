package com.dnd.soap.service.bean;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PlayerInfoBean {

  @NotBlank
  @Size(min = 2, max = 32)
  private String username;

  @NotNull @NotEmpty private String playerClass;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPlayerClass() {
    return playerClass;
  }

  public void setPlayerClass(String playerClass) {
    this.playerClass = playerClass;
  }

  public PlayerInfoBean(String username, String playerClass) {
    this.username = username;
    this.playerClass = playerClass;
  }

  public PlayerInfoBean() {}
}
