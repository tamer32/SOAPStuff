package com.dnd.soap.service.entities.monsters;

import java.util.HashMap;
import java.util.Map;

public class MonsterInfo {

  protected static Map<String, Integer> monsterAttributes = new HashMap<String, Integer>();

  public Map<String, Integer> getMonsterAttributes() {
    return monsterAttributes;
  }

  public static void monsterAttributes(Integer strenght, Integer agility, Integer intelect) {
    monsterAttributes.put("Strenght", strenght);
    monsterAttributes.put("Agility", agility);
    monsterAttributes.put("Intelect", intelect);
  }
}
