package com.dnd.soap.service.entities.heroes;

public class Rogue extends PlayerInfo {
  @Override
  public void setAttributes() {
    setStats(11, 15, 4);
  }

  public void getLvl() {
    super.levelUp(6, 7, 2);
  }
}
