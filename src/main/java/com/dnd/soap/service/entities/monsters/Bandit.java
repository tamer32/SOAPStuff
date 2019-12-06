package com.dnd.soap.service.entities.monsters;

import java.util.Map;

public class Bandit extends MonsterInfo {
  public Map<String, Integer> getStats() {
    monsterAttributes(2, 5, 2);
    return MonsterInfo.monsterAttributes;
  }

  public String getName() {
    return "Bandit";
  }
}
