package com.third.iter.service;

import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import com.third.iter.service.bean.PlayerInfoBean;
import com.third.iter.service.entities.heroes.PlayerInfo;
import com.third.iter.service.entities.monsters.MonsterInfo;

/** @author p.siderov */
public interface UserManagmentService {

  public PlayerInfo createUser(PlayerInfo player);

  public MonsterInfo monsterEncounter(Integer encounter);

  public void deleteUser(long playerId);

  public PlayerInfo transformToPlayerInfo(PlayerInfoBean playerBean);

  public PlayerInfo getPlayer(long playerId);

  public PlayerInfo modifyName(long id, String player);

  public Integer calculatePowerRatio(
      MonsterInfo monster, PlayerInfo player, Integer skullDice, Integer gracefulDice);

  public Map<String, String> battleCalculator(long playerId);

  public List<PlayerInfo> listUsers();

  ResponseEntity<PlayerInfo> login(String username);
}
