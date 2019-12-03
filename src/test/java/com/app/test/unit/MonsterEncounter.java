package com.app.test.unit;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;
import com.third.iter.service.UserManagmentServiceImpl;
import com.third.iter.service.entities.monsters.Bandit;
import com.third.iter.service.entities.monsters.Dragon;
import com.third.iter.service.entities.monsters.Elemental;
import com.third.iter.service.entities.monsters.Goblin;
import com.third.iter.service.entities.monsters.MechaGolem;
import com.third.iter.service.entities.monsters.VajirSorceress;
import com.third.iter.service.entities.monsters.Werewolf;
import com.third.iter.service.entities.monsters.Zombie;

@RunWith(MockitoJUnitRunner.class)
public class MonsterEncounter {
  @Spy UserManagmentServiceImpl userService;

  @Test
  public void testCheckGoblinEncounter() {
    assertThat(userService.monsterEncounter(8)).isInstanceOf(Goblin.class);
  }

  @Test
  public void testCheckBanditEncounter() {
    assertThat(userService.monsterEncounter(14)).isInstanceOf(Bandit.class);
  }

  @Test
  public void testCheckZombieEncounter() {
    assertThat(userService.monsterEncounter(16)).isInstanceOf(Zombie.class);
  }

  @Test
  public void testCheckSorceressEncounter() {
    assertThat(userService.monsterEncounter(24)).isInstanceOf(VajirSorceress.class);
  }

  @Test
  public void testCheckWerewolfEncounter() {
    assertThat(userService.monsterEncounter(31)).isInstanceOf(Werewolf.class);
  }

  @Test
  public void testCheckMechaGolemEncounter() {
    assertThat(userService.monsterEncounter(38)).isInstanceOf(MechaGolem.class);
  }

  @Test
  public void testCheckElementalEncounter() {
    assertThat(userService.monsterEncounter(44)).isInstanceOf(Elemental.class);
  }

  @Test
  public void testCheckDragonEncounter() {
    assertThat(userService.monsterEncounter(48)).isInstanceOf(Dragon.class);
  }
}
