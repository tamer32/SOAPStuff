package com.dnd.soap.service.entities.heroes;

public class Sorcerer extends PlayerInfo {
  public void getStats() {
    super.setStats(4, 4, 22);
  }

  @Override
  public void setAttributes() {
    setStats(4, 4, 22);
  }

  public void getLvl() {
    super.levelUp(4, 3, 13);
  }
}
