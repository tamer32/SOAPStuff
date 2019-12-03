package com.app.test.unit;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import com.third.iter.service.UserManagmentServiceImpl;
import com.third.iter.service.bean.PlayerInfoBean;
import com.third.iter.service.entities.heroes.Bowman;
import com.third.iter.service.entities.heroes.PlayerInfo;
import com.third.iter.service.entities.heroes.Rogue;
import com.third.iter.service.entities.heroes.Sorcerer;
import com.third.iter.service.entities.heroes.Warrior;
import com.third.iter.service.entities.monsters.MonsterInfo;

@RunWith(MockitoJUnitRunner.class)
public class UnitTestForDnD {

  @Mock private PlayerInfo player;
  @Mock private MonsterInfo monster;
  @Mock private PlayerInfoBean playerBean;

  @InjectMocks @Spy UserManagmentServiceImpl userService;

  @Before
  public void setUp() {
    Mockito.when(player.getPlayerClass()).thenReturn("Warrior");
    Mockito.when(player.getUsername()).thenReturn("Pehso");
    Mockito.when(player.getId()).thenReturn(1L);
  }

  @Test
  public void testCreateUser() {
    userService.createUser(player);
    assertThat(userService.listUsers().size()).isEqualTo(1);
    assertThat(userService.listUsers().get(userService.listUsers().size() - 1).getUsername())
        .isEqualTo(player.getUsername());
  }

  @Test
  public void testCreateBowmanClass() {
    Mockito.when(player.getPlayerClass()).thenReturn("Bowman");
    userService.createUser(player);
    assertThat(player.getPlayerClass()).isEqualTo("Bowman");
  }

  @Test
  public void testCreateRogueClass() {
    Mockito.when(player.getPlayerClass()).thenReturn("Rogue");
    userService.createUser(player);
    assertThat(player.getPlayerClass()).isEqualTo("Rogue");
  }

  @Test
  public void testCreateSorcererClass() {
    Mockito.when(player.getPlayerClass()).thenReturn("Sorcerer");
    userService.createUser(player);
    assertThat(player.getPlayerClass().equals("Sorcerer"));
  }

  @Test
  public void testDeleteUser() {
    Mockito.when(player.getPlayerClass()).thenReturn("Rogue");
    userService.createUser(player);
    userService.deleteUser(player.getId());
    assertThat(userService.listUsers()).doesNotContain(player);
  }

  @Test
  public void testIsBetween() {
    int lowerNumber = 2;
    int number = 3;
    int biggerNumber = 4;
    assertThat(userService.isBetween(number, lowerNumber, biggerNumber)).isTrue();
  }

  @Test
  public void testIsBetweenFail() {
    int lowerNumber = 5;
    int upperNumber = 3;
    int number = 4;
    assertThat(userService.isBetween(number, lowerNumber, upperNumber)).isFalse();
  }

  @Test
  public void testBattleCalculatorEqualsToZero() {
    Mockito.doReturn(0)
        .when(userService)
        .calculatePowerRatio(
            Mockito.anyObject(), Mockito.anyObject(), Mockito.anyInt(), Mockito.anyInt());
    String message = userService.battleCalculator(Mockito.anyLong()).get("message");
    assertThat(message).contains("You almost defeat the vile beast");
  }

  @Test
  public void testBattleCalculatorLessThanZero() {
    Integer temp = -24;
    PlayerInfo player = new PlayerInfo("Pesho", "Warrior");
    player.setAttributes();
    player.setExp(1);
    Mockito.when(userService.getPlayer(Mockito.anyLong())).thenReturn(player);
    Mockito.doReturn(temp)
        .when(userService)
        .calculatePowerRatio(
            Mockito.anyObject(), Mockito.anyObject(), Mockito.anyInt(), Mockito.anyInt());
    String message = userService.battleCalculator(Mockito.anyLong()).get("message");
    assertThat(message).contains("Congratulations on your victory");
  }

  @Test
  public void testBattleCalculatorBiggerThanZero() {
    Mockito.doReturn(14)
        .when(userService)
        .calculatePowerRatio(
            Mockito.anyObject(), Mockito.anyObject(), Mockito.anyInt(), Mockito.anyInt());
    String message = userService.battleCalculator(Mockito.anyLong()).get("message");
    assertThat(message).contains("his time the fate wasn't on your side");
  }

  @Test
  public void testTransformToPlayerInfoWarrior() {
    Mockito.when(playerBean.getPlayerClass()).thenReturn("Warrior");
    assertThat(userService.transformToPlayerInfo(playerBean)).isInstanceOf(Warrior.class);
  }

  @Test
  public void testTransformToPlayerInfoBowman() {
    Mockito.when(playerBean.getPlayerClass()).thenReturn("Bowman");
    assertThat(userService.transformToPlayerInfo(playerBean)).isInstanceOf(Bowman.class);
  }

  @Test
  public void testTransformToPlayerInfoRogue() {
    Mockito.when(playerBean.getPlayerClass()).thenReturn("Rogue");
    assertThat(userService.transformToPlayerInfo(playerBean)).isInstanceOf(Rogue.class);
  }

  @Test
  public void testTransformToPlayerInfoSorcerer() {
    Mockito.when(playerBean.getPlayerClass()).thenReturn("Sorcerer");
    assertThat(userService.transformToPlayerInfo(playerBean)).isInstanceOf(Sorcerer.class);
  }

  @Test
  public void testModifyName() {
    PlayerInfo tempPlayer = new PlayerInfo();
    tempPlayer.setUsername("pesho");
    userService.createUser(tempPlayer);
    assertThat(userService.modifyName(tempPlayer.getId(), "Gosho").getUsername())
        .isEqualTo("Gosho");
  }

  @Test
  public void testCalculatePowerRatio() {
    Map<String, Integer> map = new HashMap<String, Integer>();
    map.put("Strenght", 10);
    map.put("Agility", 10);
    map.put("Intelect", 10);
    map.put("strenght", 10);
    map.put("agility", 10);
    map.put("intelect", 10);
    Mockito.when(monster.getMonsterAttributes()).thenReturn(map);
    Mockito.when(player.getPlayerAttributes()).thenReturn(map);
    assertThat(userService.calculatePowerRatio(monster, player, 1, 1)).isEqualTo(0);
  }
}
