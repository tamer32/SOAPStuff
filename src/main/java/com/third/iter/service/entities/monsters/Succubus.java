package com.third.iter.service.entities.monsters;

import com.third.iter.service.entities.heroes.PlayerInfo;

public class Succubus extends PlayerInfo {
  public void getStats() {
    super.setStats(4, 3, 2);
  }
}
