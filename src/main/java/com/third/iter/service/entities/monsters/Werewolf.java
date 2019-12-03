package com.third.iter.service.entities.monsters;

import java.util.Map;
import java.util.stream.IntStream;

public class Werewolf extends MonsterInfo {
  int[] monsterIDs = IntStream.range(26, 30).toArray();

  public Map<String, Integer> getStats() {
    monsterAttributes(10, 12, 4);
    return MonsterInfo.monsterAttributes;
  }

  public String getName() {
    return "Werewolf";
  }
}
