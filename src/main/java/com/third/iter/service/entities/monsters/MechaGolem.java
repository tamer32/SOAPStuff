package com.third.iter.service.entities.monsters;

import java.util.Map;

public class MechaGolem extends MonsterInfo {
  public Map<String, Integer> getStats() {
    monsterAttributes(32, 4, 0);
    return MonsterInfo.monsterAttributes;
  }

  public String getName() {
    return "Mecha Golem";
  }
}
