package com.third.iter.service.entities.heroes;

public class Warrior extends PlayerInfo {
  @Override
  public void setAttributes() {
    super.setStats(20, 7, 3);
  }

  public void getLvl() {
    super.levelUp(12, 3, 1);
  }
}
