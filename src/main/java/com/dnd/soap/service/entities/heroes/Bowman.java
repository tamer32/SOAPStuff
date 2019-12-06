package com.dnd.soap.service.entities.heroes;

public class Bowman extends PlayerInfo {

  @Override
  public void setAttributes() {
    super.setStats(6, 14, 10);
  }

  public void getLvl() {
    super.levelUp(4, 7, 4);
  }
}
