package com.third.iter.service.entities.monsters;

import java.util.Map;

public class VajirSorceress extends MonsterInfo {
  public Map<String, Integer> getStats() {
    monsterAttributes(2, 4, 10);
    return MonsterInfo.monsterAttributes;
  }

  public String getName() {
    return "Vaj'ir Sorceress";
  }
}
