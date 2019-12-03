package com.third.iter.service.entities.monsters;

import java.util.Map;

public class Siren extends MonsterInfo {
  public Map<String, Integer> getStats() {
    monsterAttributes(6, 12, 18);
    return MonsterInfo.monsterAttributes;
  }

  public String getName() {
    return "Siren";
  }
}
