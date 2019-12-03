package com.third.iter.service.entities.monsters;

import java.util.Map;

public class Zombie extends MonsterInfo {
  public Map<String, Integer> getStats() {
    monsterAttributes(10, 1, 0);
    return MonsterInfo.monsterAttributes;
  }

  public String getName() {
    return "Zombie";
  }
}
